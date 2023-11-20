CREATE TABLE PESSOA_LOGIN(
ID INT PRIMARY KEY auto_increment,
NOME VARCHAR(50) NOT NULL,
EMAIL VARCHAR(50) NOT NULL,
GENERO VARCHAR(20),
CELULAR VARCHAR(11),
USUARIO VARCHAR(30),
SENHA VARCHAR(20),
ADMINISTRADOR CHAR
);

CREATE TABLE ALUGA(
FOREIGN KEY (ID_PESSOA) REFERENCES PESSOA_LOGIN(ID),
FOREIGN KEY (ID_LOCAVEL) REFERENCES LOCAVEIS(ID)
);

CREATE TABLE LOCAVEIS(
ID INT PRIMARY KEY auto_increment,
TIPO VARCHAR(30) NOT NULL,
DESCRICAO VARCHAR(50)
);

CREATE TABLE CONFIRMA(
FOREIGN KEY (ID_LOCAVEL) REFERENCES LOCAVEIS(ID),
FOREIGN KEY (ID_RESERVA) REFERENCES RESERVA(ID_RESERVA),
DATALOC DATE
);

CREATE TABLE RESERVA(
ID_RESERVA INT PRIMARY KEY auto_increment,
NOME_LOCAVEL VARCHAR(30) NOT NULL,
DT_INICIO DATE,
DT_FIM DATE,
USUARIO VARCHAR(30),
ID_LOCAVEL INT
);



--TRIGGER--

DELIMITER //
CREATE TRIGGER after_update_tabela_reserva
AFTER UPDATE ON RESERVA FOR EACH ROW
BEGIN

    INSERT INTO CONFIRMA (ID_LOCAVEL, ID_RESERVA, DATALOC)
    VALUES (NEW.ID_RESERVA, NEW.ID_LOCAVEL, CURDATE());
END;
//
DELIMITER;


--DADOS PARA QUADRA PRÉ MOLDADOS--
INSERT INTO LOCAVEIS(TIPO, DESCRICAO) VALUES('QUADRA SOCIETY', 'QUADRA SOCIETY 1');
INSERT INTO LOCAVEIS(TIPO, DESCRICAO) VALUES('QUADRA SOCIETY', 'QUADRA SOCIETY 2');
INSERT INTO LOCAVEIS(TIPO, DESCRICAO) VALUES('QUADRA POLIESPORTIVA', 'QUADRA POLIESPORTIVA 1');
INSERT INTO LOCAVEIS(TIPO, DESCRICAO) VALUES('QUADRA POLIESPORTIVA', 'QUADRA POLIESPORTIVA 2');
INSERT INTO LOCAVEIS(TIPO, DESCRICAO) VALUES('QUADRA POLIESPORTIVA', 'QUADRA POLIESPORTIVA 3');