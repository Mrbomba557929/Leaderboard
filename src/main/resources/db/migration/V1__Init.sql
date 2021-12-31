CREATE TABLE leaderboards (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    time DECIMAL(10, 2),
    email VARCHAR(255) UNIQUE,
    discord VARCHAR(255) UNIQUE
);