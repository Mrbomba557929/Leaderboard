CREATE TABLE `leaderboards` (
    `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `time` DECIMAL(10, 2),
    `email` VARCHAR(255) UNIQUE,
    `discord` VARCHAR(255) UNIQUE
);