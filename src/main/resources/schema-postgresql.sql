CREATE TABLE IF NOT EXISTS categoria (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50),
    descricao TEXT,
    preco NUMERIC(10, 2),
    categoria INT,
    CONSTRAINT fk_categoria FOREIGN KEY (categoria) REFERENCES categoria(id)
);

CREATE TABLE IF NOT EXISTS users (
  user_id SERIAL PRIMARY KEY,
  username VARCHAR(45) NOT NULL UNIQUE,
  password VARCHAR(64) NOT NULL,
  role VARCHAR(45) NOT NULL,
  enabled BOOLEAN DEFAULT TRUE
);

INSERT INTO users (username, password, role, enabled)
VALUES ('user',
'$2a$12$vLYbNHhMjCaffmemGzh2au.TAtMATl24Y9do5fqDxNPJ9Xvm4kLQy',
'ROLE_USER', TRUE)
ON CONFLICT (username) DO NOTHING;

INSERT INTO users (username, password, role, enabled)
VALUES ('admin',
'$2a$12$yXWeF5BmghdWH25UPCyNR.vGKhqfOHHjCxa4qHJdvCN.AzVdSH9vG',
'ROLE_ADMIN', TRUE)
ON CONFLICT (username) DO NOTHING;
