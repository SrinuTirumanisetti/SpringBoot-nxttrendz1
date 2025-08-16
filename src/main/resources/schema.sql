CREATE TABLE IF NOT EXISTS product (
    productId INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    productName VARCHAR(255),
    price DOUBLE
);

CREATE TABLE IF NOT EXISTS review (
    reviewId INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    reviewContent VARCHAR(255),
    rating INT,
    productId INT,
    FOREIGN KEY (productId) REFERENCES product(productId)
);
