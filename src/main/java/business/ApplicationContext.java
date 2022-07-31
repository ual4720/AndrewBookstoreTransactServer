
package business;

import business.book.BookDao;
import business.book.BookDaoJdbc;
import business.category.CategoryDao;
import business.category.CategoryDaoJdbc;
import business.customer.CustomerDao;
import business.customer.CustomerDaoJdbc;
import business.order.*;

public class ApplicationContext {

    private CategoryDao categoryDao;
    private BookDao bookDao;
    private OrderDao orderDao;
    private LineItemDao lineItem;
    private CustomerDao customer;
    private DefaultOrderService orderService;

    public static ApplicationContext INSTANCE = new ApplicationContext();

    private ApplicationContext() {
        categoryDao = new CategoryDaoJdbc();
        bookDao = new BookDaoJdbc();
        orderService = new DefaultOrderService();
        ((DefaultOrderService)orderService).setBookDao(bookDao);
        orderDao = new OrderDaoJdbc();
        lineItem = new LineItemDaoJdbc();
        customer = new CustomerDaoJdbc();
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public OrderDao getOrderDao() { return orderDao; }
    public LineItemDao getLineItem() { return lineItem; }
    public CustomerDao getCustomer(){ return customer; }
}
