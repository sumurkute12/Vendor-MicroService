insert into vendor (vendor_id,  vendor_name,  delivery_charge,rating) values (1, 'Amazon', 30.5, 5.0 );
insert into vendor (vendor_id,  vendor_name,  delivery_charge,rating) values (2, 'Flipkart', 40.5, 4.0 );
insert into vendor (vendor_id,  vendor_name,  delivery_charge,rating) values (3, 'Ondoor', 25.5, 4.2 );
insert into vendor_stock (expected_stock_replinshment_date, stock_in_hand, vendor_id, product_id, id) values ('2020-11-01', 150, 1, 1, 1);
insert into vendor_stock (expected_stock_replinshment_date, stock_in_hand, vendor_id, product_id, id) values ('2020-11-01', 300, 2, 1, 6);
insert into vendor_stock (expected_stock_replinshment_date, stock_in_hand, vendor_id, product_id, id) values ('2021-11-01', 140, 2, 2, 2);
insert into vendor_stock (expected_stock_replinshment_date, stock_in_hand, vendor_id, product_id, id) values ('2021-6-01', 120, 3, 1, 3);
insert into vendor_stock (expected_stock_replinshment_date, stock_in_hand, vendor_id, product_id, id) values ('2020-11-01', 50, 1, 3, 4);
insert into vendor_stock (expected_stock_replinshment_date, stock_in_hand, vendor_id, product_id, id) values ('2021-11-01', 40, 2, 4, 5);