CREATE DATABASE restaurant;
-- Creación de las tablas
CREATE TABLE pizza (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(50) NOT NULL,
                       price NUMERIC(8,2) NOT NULL
);

CREATE TABLE beverage (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(50) NOT NULL,
                          price NUMERIC(8,2) NOT NULL
);

CREATE TABLE waiter (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(50) NOT NULL,
                        age INTEGER NOT NULL
);

CREATE TABLE cook (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(50) NOT NULL,
                      age INTEGER NOT NULL
);

-- Inserción de datos de ejemplo
INSERT INTO pizza (name, price) VALUES
                                    ('Margherita', 8.99),
                                    ('Pepperoni', 10.99),
                                    ('Vegetarian', 9.99);

INSERT INTO beverage (name, price) VALUES
                                       ('Cola', 2.49),
                                       ('Orange Juice', 3.29),
                                       ('Water', 1.99);

INSERT INTO waiter (name, age) VALUES
                                   ('John Doe', 25),
                                   ('Jane Smith', 28),
                                   ('Bob Johnson', 22);

INSERT INTO cook (name, age) VALUES
                                 ('Alice Brown', 30),
                                 ('Charlie Davis', 35),
                                 ('Eva White', 28);
