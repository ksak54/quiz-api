CREATE TABLE IF NOT EXISTS categories (
    id INT PRIMARY KEY,
    category_id INT,
    title VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    clues_count INT
);

CREATE TABLE IF NOT EXISTS questions (
	id INT PRIMARY KEY,
    question_id INT NOT NULL,
    answer VARCHAR(255),
    question VARCHAR(255),
    question_value int,
    air_date TIMESTAMP,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    category_id INT,
    game_id INT,
    invalid_count INT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

