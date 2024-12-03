CREATE TABLE notification (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    subject VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user (id)
);
