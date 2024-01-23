CREATE TABLE products
(
    id    INTEGER PRIMARY KEY,
    name  VARCHAR(255)   NOT NULL,
    price NUMERIC(10, 2) NOT NULL
);

CREATE TABLE shops
(
    id   INTEGER PRIMARY KEY,
    code VARCHAR(3),
    city VARCHAR(50)
);

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    email      VARCHAR(50),
    shop_id    INTEGER,
    CONSTRAINT users_shop_id_fk FOREIGN KEY (shop_id) REFERENCES shops (id)
);

CREATE TABLE orders
(
    id       INTEGER PRIMARY KEY,
    datetime TIMESTAMP,
    status   VARCHAR(50),
    user_id  INTEGER,
    shop_id  INTEGER,
    CONSTRAINT orders_user_id_fk FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT orders_shop_id_fk FOREIGN KEY (shop_id) REFERENCES shops (id)
);

CREATE TABLE shop_products
(
    id         INTEGER PRIMARY KEY,
    shop_id    INTEGER,
    product_id INTEGER,
    quantity   INTEGER,
    CONSTRAINT shop_products_shop_id_fk FOREIGN KEY (shop_id) REFERENCES shops (id),
    CONSTRAINT shop_products_product_id_fk FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE order_products
(
    id         INTEGER PRIMARY KEY,
    order_id   INTEGER,
    product_id INTEGER,
    quantity   INTEGER,
    CONSTRAINT order_products_order_id_fk FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT order_products_product_id_fk FOREIGN KEY (product_id) REFERENCES products (id)
);
