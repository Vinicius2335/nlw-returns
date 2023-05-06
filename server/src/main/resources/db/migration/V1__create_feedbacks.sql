CREATE TABLE IF NOT EXISTS feedbacks (
    id VARCHAR(36) PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    comment VARCHAR(150) NOT NULL,
    screenshot TEXT
);

