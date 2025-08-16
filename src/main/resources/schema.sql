CREATE TABLE IF NOT EXISTS product (
    productid INT PRIMARY KEY AUTO_INCREMENT,
    productname VARCHAR(255),
    price DOUBLE
);

CREATE TABLE IF NOT EXISTS review (
    reviewid INT PRIMARY KEY AUTO_INCREMENT,
    reviewcontent VARCHAR(255),
    rating INT,
    productid INT,
    FOREIGN KEY (productid) REFERENCES product(productid)
);
