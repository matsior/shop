INSERT INTO products (id, name, price)
VALUES (1, 'Sok', 10.00),
       (2, 'Czekolada', 5.49);

INSERT INTO shops (id, code, city)
VALUES (1, '001', 'Gdynia'),
       (2, '002', 'Olsztyn');

INSERT INTO users (id, first_name, last_name, email, shop_id)
VALUES (1, 'Jan', 'Kowalski', 'jan@gmail.com', 1),
       (2, 'Adam', 'Nowak', 'adam@gmail.com', 2);

INSERT INTO orders (id, datetime, status, user_id, shop_id)
VALUES (1, now(), 'COMPLETED', 1, 1),
       (2, now(), 'COMPLETED', 1, 1);

INSERT INTO shop_products (id, shop_id, product_id, quantity)
VALUES (1, 1, 1, 10),
       (2, 1, 2, 20);

INSERT INTO order_products (id, order_id, product_id, quantity)
VALUES (1, 1, 1, 100),
       (2, 1, 2, 200),
       (3, 2, 1, 111),
       (4, 2, 2, 222);
