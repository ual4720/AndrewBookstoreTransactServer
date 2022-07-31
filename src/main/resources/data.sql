DELETE FROM book;
ALTER TABLE book AUTO_INCREMENT = 1001;

DELETE FROM category;
ALTER TABLE category AUTO_INCREMENT = 1001;

/* INSERT Categories */
INSERT INTO category (name) VALUES
('Fiction:Classics') /* 1001 */
                                 ,('Fiction:Mystery') /* 1002 */
                                 ,('How-To:Home DIY') /* 1003 */
                                 ,('How-To:Permaculture') /* 1004 */
                                 ,('Education:TextBook'); /* 1005 */

/* INSERT Fiction: Classics books */
INSERT INTO book (title, author, price, rating, is_public, is_featured, category_id, description)
VALUES
(
    'Treasure Island'
,'Robert Louis Stevenson'
,0
,0
,true
,false
,1001
,''
)
     ,(
       'Count of Monte Cristo'
      ,'Alexandre Dumas'
      ,1299
      ,0
      ,false
      ,true
      ,1001
      ,''
)
     ,(
       'Three Musketeers'
      ,'Alexandre Dumas'
      ,759
      ,0
      ,false
      ,false
      ,1001
      ,''
)
     ,(
       'The Wind in the Willows'
      ,'Kenneth Grahame'
      ,699
      ,0
      ,false
      ,false
      ,1001
      ,''
);

/* INSERT Fiction: Mystery books */
INSERT INTO book (title, author, price, rating, is_public, is_featured, category_id, description)
VALUES
(
    'The Moonstone'
,'Wilkie Collins'
,994
,0
,false
,false
,1002
,''
)
     ,(
       'The Study in Scarlett'
      ,'Sir Arthur Conan Doyle'
      ,1099
      ,0
      ,false
      ,true
      ,1002
      ,''
)
     ,(
       'The Maltese Falcon'
      ,'Dashiell Hammett'
      ,1699
      ,0
      ,false
      ,false
      ,1002
      ,''
)
     ,(
       'Then There Were None'
      ,'Agatha Christie'
      ,568
      ,0
      ,false
      ,false
      ,1002
      ,''
);

/* INSERT How-To books */
INSERT INTO book (title, author, price, rating, is_public, is_featured, category_id, description)
VALUES
(
    'Bookcases, Cabinets & Built-Ins'
,'Fine Woodworking (editor)'
,849
,0
,false
,false
,1003
,''
)
     ,(
       'The Complete Guide to Home Plumbing'
      ,'Black & Decker'
      ,900
      ,0
      ,false
      ,true
      ,1003
      ,''
)
     ,(
       'The Carpet Installation Training Handbook'
      ,'Eric Larson'
      ,479
      ,0
      ,false
      ,false
      ,1003
      ,''
)
     ,(
       'Whole House Repair Guide'
      ,'Editors at Family Handyman'
      ,1832
      ,0
      ,false
      ,false
      ,1003
      ,''
)
     ,(
    'Gaia\'s Garden'
          ,'Toby Hemenway'
          ,999
          ,0
          ,false
          ,false
          ,1004
          ,''
    )
    ,(
           'Permaculture for Beginners'
          ,'Alex Devine'
          ,1495
          ,0
          ,false
          ,true
          ,1004
          ,''
    )
    ,(
          'Practical Permaculture'
          ,'Jessi Bloom, Dave Boehnlein, & Mr. Paul Kearsley'
          ,2399
          ,0
          ,false
          ,false
          ,1004
          ,''
    )
     ,(
           'The Self-Sufficient Backyard'
          ,'Ron & Johanna Melchiore'
          ,2399
          ,0
          ,false
          ,false
          ,1004
          ,''
    );

/* INSERT Education: Textbook books */
INSERT INTO book (title, author, price, rating, is_public, is_featured, category_id, description)
VALUES
    (
        'Computer Science Illuminated'
        ,'Nell B Dale'
        ,2159
        ,0
        ,false
        ,false
        ,1005
        ,''
    )
    ,(
        'Formal Foundations of Reuse and Domain Engineering'
        ,'Stephen H. Edwards, Gregory Kulczycki (Eds.)'
        ,4210
        ,0
        ,false
        ,true
        ,1005
         ,''
    )
    ,(
        'Financial Accounting Tools for Business Decisions'
         ,'Donald Kieso and Paul D. Kimmel'
         ,4182
         ,0
         ,false
         ,false
         ,1005
         ,''
    )
     ,(
           'Joel on Software'
          ,'Joel Spolsky'
          ,1499
          ,0
          ,false
          ,false
          ,1005
          ,''
    );
