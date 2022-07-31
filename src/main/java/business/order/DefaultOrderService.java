package business.order;

import api.ApiException;
import business.book.Book;
import business.book.BookDao;
import business.cart.ShoppingCart;
import business.customer.CustomerForm;

import java.time.DateTimeException;
import java.time.YearMonth;
import java.util.Date;

public class DefaultOrderService implements OrderService {

	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public OrderDetails getOrderDetails(long orderId) {
		// NOTE: THIS METHOD PROVIDED NEXT PROJECT
		return null;
	}

	@Override
    public long placeOrder(CustomerForm customerForm, ShoppingCart cart) {

		validateCustomer(customerForm);
		validateCart(cart);

		// NOTE: MORE CODE PROVIDED NEXT PROJECT

		return -1;
	}


	private void validateCustomer(CustomerForm customerForm) {

    	String name = customerForm.getName();
		String address = customerForm.getAddress();
		String phone = customerForm.getPhone();
		String email = customerForm.getEmail();
		String ccNumber = customerForm.getCcNumber();

		if (name == null || name.equals("") || name.length() < 4 || name.length() > 45) {
			throw new ApiException.InvalidParameter("Invalid name field");
		}

		if(address == null || address.equals("") || address.length() < 4 || address.length() > 45){
			throw new ApiException.InvalidParameter("Invalid address field");
		}

		if(phone == null || phone.equals("") || phone.replaceAll("\\D", "").length() != 10){
			throw new ApiException.InvalidParameter("Invalid phone number field");
		}

		if(email == null || email.equals("") || email.contains(" ") || !email.contains("@") || email.endsWith(".")){
			throw new ApiException.InvalidParameter("Invalid email address field");
		}

		if(
				ccNumber == null || ccNumber.equals("") ||
				ccNumber.replaceAll("\\D", "").length() < 14 ||
				ccNumber.replaceAll("\\D", "").length() > 16){
			throw new ApiException.InvalidParameter("Invalid credit card number field");
		}

		if (expiryDateIsInvalid(customerForm.getCcExpiryMonth(), customerForm.getCcExpiryYear())) {
			throw new ApiException.InvalidParameter("Invalid expiry date");
		}
	}

	private boolean expiryDateIsInvalid(String ccExpiryMonth, String ccExpiryYear) {

		if(ccExpiryMonth == null || ccExpiryYear == null){
			return true;
		}

		if(ccExpiryMonth.equals("") || ccExpiryYear.equals("")){
			return true;
		}

		YearMonth currentDate = YearMonth.now();
		YearMonth ccDate = YearMonth.of(Integer.parseInt(ccExpiryYear), Integer.parseInt(ccExpiryMonth));

		if(ccDate.isBefore(currentDate)){
			return true;
		}

		return false;

	}

	private void validateCart(ShoppingCart cart) {

		if (cart.getItems().size() <= 0) {
			throw new ApiException.InvalidParameter("Cart is empty.");
		}

		cart.getItems().forEach(item-> {
			if (item.getQuantity() < 1 || item.getQuantity() > 99) {
				throw new ApiException.InvalidParameter("Invalid quantity");
			}

			Book databaseBook = bookDao.findByBookId(item.getBookId());
			if(databaseBook.getPrice() != item.getBookForm().getPrice()){
				throw new ApiException.InvalidParameter("Invalid book price");
			}

			if(databaseBook.getCategoryId() != item.getBookForm().getCategoryId()){
				throw new ApiException.InvalidParameter("Invalid book category");
			}
		});
	}

}
