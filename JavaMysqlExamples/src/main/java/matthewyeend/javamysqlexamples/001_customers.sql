/**
 * Author:  matthewyeend
 * Created: 25 Oct 2026
 */
CREATE TABLE IF NOT EXISTS customers (
    id         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    email      VARCHAR(254)    NOT NULL,
    full_name  VARCHAR(150)    NOT NULL,
    country    CHAR(2)         NOT NULL,
    created_at TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY uk_customers_email (email),
    KEY idx_customers_country (country)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
