CREATE DATABASE IF NOT EXISTS school
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci;

USE school;

CREATE TABLE IF NOT EXISTS students (
    id         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50)     NOT NULL,
    last_name  VARCHAR(50)     NOT NULL,
    email      VARCHAR(100)    NOT NULL,
    created_at TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY uq_students_email (email),
    KEY idx_students_last_name (last_name)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;