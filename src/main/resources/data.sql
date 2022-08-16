INSERT INTO meals(id, name, price, description) VALUES(1,'burger', 200, 'good');
INSERT INTO meals(id, name, price, description) VALUES(2,'rice', 20, 'normal');
INSERT INTO meals(id, name, price, description) VALUES(3,'beef', 3000, 'perfect');
INSERT INTO meals(id, name, price, description) VALUES(4,'chicken', 500, 'it is row');
INSERT INTO meals(id, name, price, description) VALUES(5,'sandwich', 100, 'not bad');
INSERT INTO meals(id, name, price, description) VALUES(6,'fries', 300, 'beautiful');
INSERT INTO orders(seq,total_price,waiter) VALUES(1,220,'Andrew');
INSERT INTO orders(seq,total_price,waiter) VALUES(2,3200,'Mikey');
INSERT INTO orders(seq,total_price,waiter) VALUES(3,3200,'Joanne');
INSERT INTO order_meal(order_seq, meal_id) VALUES(1, 1);
INSERT INTO order_meal(order_seq, meal_id) VALUES(1, 2);
INSERT INTO order_meal(order_seq, meal_id) VALUES(2, 3);
INSERT INTO order_meal(order_seq, meal_id) VALUES(2, 1);
INSERT INTO order_meal(order_seq, meal_id) VALUES(3, 2);
INSERT INTO order_meal(order_seq, meal_id) VALUES(3, 3);


