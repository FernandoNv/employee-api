INSERT INTO DEPARTMENTS(name)
VALUES ('TI');
INSERT INTO DEPARTMENTS(name)
VALUES ('Departamento Pessoal');
INSERT INTO DEPARTMENTS(name)
VALUES ('Marketing');

INSERT INTO POSITIONS(name, department_id)
VALUES ('Desenvolvedor Fullstack', 1);
INSERT INTO POSITIONS(name, department_id)
VALUES ('Desenvolvedor Frontend', 1);
INSERT INTO POSITIONS(name, department_id)
VALUES ('Desenvolvedor Backend', 1);
INSERT INTO POSITIONS(name, department_id)
VALUES ('Suporte', 1);

INSERT INTO POSITIONS(name, department_id)
VALUES ('Assistente Administrativo I', 2);
INSERT INTO POSITIONS(name, department_id)
VALUES ('Assistente Administrativo II', 2);
INSERT INTO POSITIONS(name, department_id)
VALUES ('Assistente Administrativo III', 2);

INSERT INTO POSITIONS(name, department_id)
VALUES ('Criador de Conteúdo I', 3);
INSERT INTO POSITIONS(name, department_id)
VALUES ('Social Media', 3);
INSERT INTO POSITIONS(name, department_id)
VALUES ('Influencer', 3);

INSERT INTO employees (name, cpf, phone, email, birth_date, salary, address, number, neighborhood, city, state,
                       postal_code, address2, department_id, position_id, seniority)
VALUES ('Alice Johnson', '123.456.789-00', '(98) 97654-3210', 'alice.johnson@example.com', '1985-04-12 00:00:00', 75000,
        '123 Main St', 101, 'Downtown', 'Metropolis', 'NY', '12345-123', NULL, 1, 1, 'SENIOR');
INSERT INTO employees (name, cpf, phone, email, birth_date, salary, address, number, neighborhood, city, state,
                       postal_code, address2, department_id, position_id, seniority)
VALUES ('Bob Smith', '234.567.890-01', '(98) 97654-3210', 'bob.smith@example.com', '1990-08-22 00:00:00', 85000,
        '456 Elm St',
        202, 'Midtown', 'Metropolis', 'NY', '12345-123', NULL, 1, 2, 'PLENO');
INSERT INTO employees (name, cpf, phone, email, birth_date, salary, address, number, neighborhood, city, state,
                       postal_code, address2, department_id, position_id, seniority)
VALUES ('Carol White', '345.678.901-23', '(98) 97654-3210', 'carol.white@example.com', '1982-01-15 00:00:00', 65000,
        '789 Pine St', 303, 'Uptown', 'Metropolis', 'NY', '12345-123', NULL, 1, 3, 'JUNIOR');
INSERT INTO employees (name, cpf, phone, email, birth_date, salary, address, number, neighborhood, city, state,
                       postal_code, address2, department_id, position_id, seniority)
VALUES ('David Brown', '456.789.012-34', '(98) 97654-3210', 'david.brown@example.com', '1978-11-05 00:00:00', 70000,
        '101 Maple St', 404, 'Suburbia', 'Metropolis', 'NY', '12345-123', NULL, 1, 4, 'PLENO');
INSERT INTO employees (name, cpf, phone, email, birth_date, salary, address, number, neighborhood, city, state,
                       postal_code, address2, department_id, position_id, seniority)
VALUES ('Eve Davis', '567.890.123-45', '(98) 97654-3210', 'eve.davis@example.com', '1995-02-20 00:00:00', 72000,
        '202 Oak St',
        505, 'Downtown', 'Metropolis', 'NY', '12345-123', NULL, 2, 5, 'SENIOR');
INSERT INTO employees (name, cpf, phone, email, birth_date, salary, address, number, neighborhood, city, state,
                       postal_code, address2, department_id, position_id, seniority)
VALUES ('Frank Harris', '678.901.234-56', '(98) 97654-3210', 'frank.harris@example.com', '1988-07-12 00:00:00', 60000,
        '303 Birch St', 606, 'Midtown', 'Metropolis', 'NY', '12345-123', NULL, 2, 6, 'JUNIOR');
INSERT INTO employees (name, cpf, phone, email, birth_date, salary, address, number, neighborhood, city, state,
                       postal_code, address2, department_id, position_id, seniority)
VALUES ('Grace Lee', '789.012.345-67', '(98) 97654-3210', 'grace.lee@example.com', '1992-09-30 00:00:00', 95000,
        '404 Cedar St',
        707, 'Uptown', 'Metropolis', 'NY', '12345-123', NULL, 2, 7, 'SENIOR');
INSERT INTO employees (name, cpf, phone, email, birth_date, salary, address, number, neighborhood, city, state,
                       postal_code, address2, department_id, position_id, seniority)
VALUES ('Henry Walker', '890.123.456-78', '(98) 97654-3210', 'henry.walker@example.com', '1983-05-25 00:00:00', 77000,
        '505 Walnut St', 808, 'Suburbia', 'Metropolis', 'NY', '12345-123', NULL, 3, 8, 'PLENO');
INSERT INTO employees (name, cpf, phone, email, birth_date, salary, address, number, neighborhood, city, state,
                       postal_code, address2, department_id, position_id, seniority)
VALUES ('Ivy King', '901.234.567-89', '(98) 97654-3210', 'ivy.king@example.com', '1991-03-14 00:00:00', 67000,
        '606 Cherry St',
        909, 'Downtown', 'Metropolis', 'NY', '12345-123', NULL, 3, 9, 'JUNIOR');
INSERT INTO employees (name, cpf, phone, email, birth_date, salary, address, number, neighborhood, city, state,
                       postal_code, address2, department_id, position_id, seniority)
VALUES ('Jack Wright', '123.450.987-65', '(98) 97654-3210', 'jack.wright@example.com', '1987-10-17 00:00:00', 88000,
        '707 Fir St', 1010, 'Midtown', 'Metropolis', 'NY', '12345-123', NULL, 3, 10, 'SENIOR');
INSERT INTO employees (name, cpf, phone, email, birth_date, salary, address, number, neighborhood, city, state,
                       postal_code, address2, department_id, position_id, seniority)
VALUES ('Karen Scott', '234.561.098-76', '(98) 97654-3210', 'karen.scott@example.com', '1984-06-22 00:00:00', 68000,
        '808 Spruce St', 1111, 'Uptown', 'Metropolis', 'NY', '12345-123', NULL, 1, 1, 'PLENO');
INSERT INTO employees (name, cpf, phone, email, birth_date, salary, address, number, neighborhood, city, state,
                       postal_code, address2, department_id, position_id, seniority)
VALUES ('Leo Turner', '345.672.109-87', '(98) 97654-3210', 'leo.turner@example.com', '1996-12-08 00:00:00', 80000,
        '909 Ash St',
        1212, 'Suburbia', 'Metropolis', 'NY', '12345-123', NULL, 1, 2, 'SENIOR');
INSERT INTO employees (name, cpf, phone, email, birth_date, salary, address, number, neighborhood, city, state,
                       postal_code, address2, department_id, position_id, seniority)
VALUES ('Mia Collins', '456.783.210-98', '(98) 97654-3210', 'mia.collins@example.com', '1989-11-19 00:00:00', 72000,
        '1010 Maple St', 1313, 'Downtown', 'Metropolis', 'NY', '12345-123', NULL, 1, 3, 'PLENO');
