-- Table: tbconfig
CREATE TABLE tbconfig (
    cdconfig INTEGER       PRIMARY KEY AUTOINCREMENT
                            NOT NULL,
    nmconfig varchar(400) NOT NULL,
    vlconfig VARCHAR (100) NULL,
    flativo CHAR (1)      NOT NULL
);

-- Table: tbmateria
CREATE TABLE tbmateria (
    cdmateria INTEGER       PRIMARY KEY AUTOINCREMENT
                            NOT NULL,
    nmmateria VARCHAR (100) NOT NULL,
    flativo CHAR (1)      NOT NULL
);
INSERT INTO tbmateria (cdmateria, nmmateria, flativo) VALUES (1, 'Geografia', 'S');
INSERT INTO tbmateria (cdmateria, nmmateria, flativo) VALUES (2, 'Ciências', 'S');
INSERT INTO tbmateria (cdmateria, nmmateria, flativo) VALUES (3, 'Português', 'S');

-- Table: tbquestao
CREATE TABLE tbquestao (
    cdquestao INTEGER       PRIMARY KEY AUTOINCREMENT
                            NOT NULL,
    dsquestao varchar(1000) NOT NULL,
    texto VARCHAR (4000) NULL,
    imagem BLOB NULL,
    flativo CHAR (1)      NOT NULL
);

-- Table: tbresposta
CREATE TABLE tbresposta (
    cdresposta INTEGER        NOT NULL,
    cdquestao       INTEGER        NOT NULL,
    texto           VARCHAR (4000),
    flcorreto       CHAR (1)       NOT NULL,
    flativo         CHAR (1),
    FOREIGN KEY (
        cdquestao
    )
    REFERENCES tbquestao (cdquestao),
    PRIMARY KEY (
        cdresposta,
        cdquestao
    )
);