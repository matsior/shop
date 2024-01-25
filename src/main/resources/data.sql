INSERT INTO product_details (name)
VALUES ('Sok'),
       ('Czekolada'),
       ('Masło');

INSERT INTO shops (code, city)
VALUES ('001', 'Gdynia'),
       ('002', 'Olsztyn');

INSERT INTO users (first_name, last_name, email, shop_id)
VALUES ('Jan', 'Kowalski', 'jan@gmail.com', 1),
       ('Adam', 'Nowak', 'adam@gmail.com', 2);

INSERT INTO orders (datetime, status, user_id, shop_id)
VALUES (now(), 'COMPLETED', 1, 1),
       (now(), 'COMPLETED', 1, 1);

INSERT INTO shop_products (shop_id, product_details_id, quantity)
VALUES (1, 1, 10),
       (1, 2, 20);

INSERT INTO order_products (order_id, product_details_id, quantity)
VALUES (1, 1, 100),
       (1, 2, 200),
       (2, 1, 111),
       (2, 2, 222);
