CREATE TABLE IF NOT EXISTS positions(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    active BOOL DEFAULT TRUE,
    employee_id BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS departments(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    active BOOL DEFAULT TRUE,
    employee_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS employees(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(100) NOT NULL,
    phone VARCHAR(11) NOT NULL,
    email VARCHAR(90) NOT NULL,
    birth_date TIMESTAMP NOT NULL,
    salary double NOT NULL,
    address VARCHAR(100) NOT NULL,
    number INT NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(2) NOT NULL,
    postalCode VARCHAR(8) NOT NULL,
    address2 VARCHAR(100) DEFAULT NULL,
    active BOOL DEFAULT TRUE,
    department_id BIGINT NOT NULL,
    position_id BIGINT NOT NULL,
    CONSTRAINT fk_department_employee FOREIGN KEY(department_id) REFERENCES departments(id),
    CONSTRAINT fk_position_employee FOREIGN KEY(position_id) REFERENCES positions(id)
);

ALTER TABLE positions ADD CONSTRAINT fk_employee_position FOREIGN KEY(employee_id) REFERENCES employees(id);
ALTER TABLE departments ADD CONSTRAINT fk_employee_department FOREIGN KEY(employee_id) REFERENCES employees(id);
