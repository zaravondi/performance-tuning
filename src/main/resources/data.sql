DROP TABLE IF EXISTS product;
CREATE TABLE product (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price DOUBLE NOT NULL,
    quantity INT NULL
);

INSERT INTO product VALUES (1, 'beer', 5, 100);
INSERT INTO product VALUES (2, 'coke', 2, 40);
INSERT INTO product VALUES (3, 'lemonade', 10, 1);
INSERT INTO product VALUES (4, 'chocolate', 6, 2);
INSERT INTO product VALUES (5, 'candy', 4, 250);
ALTER TABLE product ALTER COLUMN ID RESTART WITH 6;