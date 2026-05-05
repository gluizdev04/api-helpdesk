CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    perfil VARCHAR(50) NOT NULL,
    data_criacao TIMESTAMP,
    CONSTRAINT chk_perfil
        CHECK (perfil IN ('USER', 'ADMIN'))
);

CREATE TABLE chamados (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    prioridade VARCHAR(50) NOT NULL,
    usuario_id BIGINT NOT NULL,
    data_criacao TIMESTAMP,
    data_atualizacao TIMESTAMP,
    CONSTRAINT chk_status
        CHECK (status IN ('ABERTO', 'EM_ANDAMENTO', 'FINALIZADO')),
    CONSTRAINT chk_prioridade
        CHECK (prioridade IN ('BAIXA', 'MEDIA', 'ALTA')),
    CONSTRAINT fk_chamados_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuarios(id)
        ON DELETE RESTRICT
);

CREATE TABLE comentarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    texto VARCHAR(255) NOT NULL,
    chamado_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    data_criacao TIMESTAMP,
    CONSTRAINT fk_comentarios_chamado
        FOREIGN KEY (chamado_id)
        REFERENCES chamados(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_comentarios_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuarios(id)
        ON DELETE RESTRICT
);