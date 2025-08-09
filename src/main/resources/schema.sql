CREATE TABLE product if NOT EXISTS(
    productId int PRIMARY KEY AUTO_INCREMENT,
    productName TEXT ,
    price DOUBLE
);

CREATE TABLE review if NOT EXISTS(
    reviewId int PRIMARY KEY AUTO_INCREMENT,
    reviewContent TEXT,
    rating int,
    productId int,
    FOREIGN KEY (productId) REFERENCES product(productId)
);