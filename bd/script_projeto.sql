CREATE TABLE tbconfig (
    cdconfig INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    nmconfig varchar(400) NOT NULL,
    vlconfig VARCHAR (100) NULL,
    flativo CHAR (1) NOT NULL
);

CREATE TABLE tbmateria (
    cdmateria INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    nmmateria VARCHAR (100) NOT NULL,
    flativo CHAR (1) NOT NULL
);

CREATE TABLE tbprofessor (
    cdprofessor INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    nmprofessor VARCHAR (100) NOT NULL,
    dslogin varchar(20) NOT NULL,
    dssenha varchar(100) NOT NULL,
    flativo CHAR (1) NOT NULL
);

CREATE TABLE tbmateriaprofessor (
    cdmateria INTEGER NOT NULL,
    cdprofessor INTEGER NOT NULL,
    FOREIGN KEY (cdmateria) REFERENCES tbmateria(cdmateria),
    FOREIGN KEY (cdprofessor) REFERENCES tbprofessor(cdprofessor)
);

CREATE TABLE tbquestao (
    cdquestao INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    dsquestao varchar(1000) NOT NULL,
    texto VARCHAR (4000) NULL,
    imagem BLOB NULL,
    flativo CHAR (1) NOT NULL
);

CREATE TABLE tbopcaoresposta (
    cdopcaoresposta INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    cdquestao INTEGER NOT NULL,
    texto VARCHAR (4000) NULL,
    imagem BLOB NULL,
    flcorreto CHAR (1) NOT NULL,
    flativo CHAR (1) NOT NULL,
    FOREIGN KEY (cdquestao) REFERENCES tbquestao(cdquestao)
);

CREATE TABLE tbresposta (
    cdresposta INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    nmaluno INTEGER NOT NULL,
    cdquestao INTEGER NOT NULL,
    flacertou CHAR (1) NOT NULL,
    dstemporesposta INTEGER NOT NULL,
    flativo CHAR (1) NOT NULL,
    FOREIGN KEY (cdquestao) REFERENCES tbquestao(cdquestao)
);
