-- =========================
-- Product Table
-- =========================
CREATE TABLE product
(
  id             VARCHAR(255) PRIMARY KEY,
  name           VARCHAR(255)   NOT NULL,
  description    VARCHAR(255)   NOT NULL,
  price_currency VARCHAR(10)    NOT NULL,
  price_amount   DECIMAL(19, 2) NOT NULL,
  items_in_stock INT
);

-- =========================
-- Cart Table
-- =========================
CREATE TABLE cart
(
  customer_id INT PRIMARY KEY
);

-- =========================
-- Cart Line Item Table
-- =========================
CREATE TABLE cart_line_item
(
  id               SERIAL PRIMARY KEY,
  cart_customer_id INT NOT NULL,
  product_id       VARCHAR(255),
  quantity         INT NOT NULL,

  CONSTRAINT fk_cart
    FOREIGN KEY (cart_customer_id)
      REFERENCES cart (customer_id)
      ON DELETE CASCADE,

  CONSTRAINT fk_product
    FOREIGN KEY (product_id)
      REFERENCES product (id)
);

CREATE TABLE users
(
  id         BIGSERIAL PRIMARY KEY,
  username   VARCHAR(100) NOT NULL UNIQUE,
  email      VARCHAR(255) NOT NULL UNIQUE,
  created_at TIMESTAMP    NOT NULL DEFAULT NOW(),
  updated_at TIMESTAMP    NOT NULL DEFAULT NOW()
);

CREATE TABLE posts
(
  id         BIGSERIAL PRIMARY KEY,
  title      VARCHAR(255) NOT NULL,
  content    TEXT,
  author_id  BIGINT       NOT NULL REFERENCES users (id) ON DELETE CASCADE,
  published  BOOLEAN      NOT NULL DEFAULT FALSE,
  created_at TIMESTAMP    NOT NULL DEFAULT NOW(),
  updated_at TIMESTAMP    NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_posts_author_id ON posts (author_id);

CREATE INDEX idx_users_email ON users (email);
