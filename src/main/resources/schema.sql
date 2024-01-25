CREATE TABLE product_details
(
    id   INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE shops
(
    id   INTEGER PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(3),
    city VARCHAR(50)
);

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    email      VARCHAR(50),
    shop_id    INTEGER,
    CONSTRAINT users_shop_id_fk FOREIGN KEY (shop_id) REFERENCES shops (id)
);

CREATE TABLE orders
(
    id       INTEGER PRIMARY KEY AUTO_INCREMENT,
    datetime TIMESTAMP,
    status   VARCHAR(50),
    user_id  INTEGER,
    shop_id  INTEGER,
    CONSTRAINT orders_user_id_fk FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT orders_shop_id_fk FOREIGN KEY (shop_id) REFERENCES shops (id)
);

CREATE TABLE shop_products
(
    id                 INTEGER PRIMARY KEY AUTO_INCREMENT,
    shop_id            INTEGER,
    product_details_id INTEGER,
    quantity           INTEGER,
    CONSTRAINT shop_products_shop_id_fk FOREIGN KEY (shop_id) REFERENCES shops (id),
    CONSTRAINT shop_products_product_id_fk FOREIGN KEY (product_details_id) REFERENCES product_details (id)
);

CREATE TABLE order_products
(
    id                 INTEGER PRIMARY KEY AUTO_INCREMENT,
    order_id           INTEGER,
    product_details_id INTEGER,
    quantity           INTEGER,
    CONSTRAINT order_products_order_id_fk FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT order_products_product_id_fk FOREIGN KEY (product_details_id) REFERENCES product_details (id)
);
