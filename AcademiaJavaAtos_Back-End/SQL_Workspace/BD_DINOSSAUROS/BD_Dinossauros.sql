/*4. Crie o comando SQL para a cria��o do banco de dados DINOSSAUROS.*/
CREATE DATABASE DINOSSAUROS
USE DINOSSAUROS
/*5. Crie o comando SQL para a cria��o das tabelas solicitadas.*/
CREATE TABLE [Grupo] (
  [id] int not null Identity,
  [nome] varchar(100) not null,
  PRIMARY KEY ([id])
);

CREATE TABLE [Pais] (
  [id] int not null Identity,
  [nome] varchar(100) not null,
  PRIMARY KEY ([id])
);

CREATE TABLE [Era] (
  [id] int not null Identity,
  [nome] varchar(100),
  [inicio] int not null,
  [fim] int not null,
  PRIMARY KEY ([id])
);

CREATE TABLE [Descobridor] (
  [id] int not null Identity,
  [nome] varchar(100) not null,
  PRIMARY KEY ([id])
);

CREATE TABLE [Dinossauros] (
  [id] int not null Identity,
  [fk_grupo] int not null,
  [fk_pais] int not null,
  [fk_era] int not null,
  [fk_descobridor] int not null,
  [toneladas] int not null,
  [ano] int not null,
  [nome] varchar(100) not null,
  PRIMARY KEY ([id]),
  CONSTRAINT [FK_Dinossauros.fk_grupo]
    FOREIGN KEY ([fk_grupo])
      REFERENCES [Grupo]([id]),
  CONSTRAINT [FK_Dinossauros.fk_pais]
    FOREIGN KEY ([fk_pais])
      REFERENCES [Pais]([id]),
  CONSTRAINT [FK_Dinossauros.fk_era]
    FOREIGN KEY ([fk_era])
      REFERENCES [Era]([id]),
  CONSTRAINT [FK_Dinossauros.fk_descobridor]
    FOREIGN KEY ([fk_descobridor])
      REFERENCES [Descobridor]([id])
);
/*6. Crie o comando SQL para inser��o de pelo menos 3 registros acima, em todas as tabelas necess�rias.*/
INSERT INTO Pais (nome) VALUES ('Mong�lia');
INSERT INTO Pais (nome) VALUES ('Canad�');
INSERT INTO Pais (nome) VALUES ('Tanz�nia');
INSERT INTO Pais (nome) VALUES ('China');
INSERT INTO Pais (nome) VALUES ('Am�rica do Norte');
INSERT INTO Pais (nome) VALUES ('USA');

INSERT INTO Era (nome, inicio, fim) VALUES ('Cret�ceo', 145, 66);
INSERT INTO Era (nome, inicio, fim) VALUES ('Jur�ssico', 201, 145);

INSERT INTO Descobridor (nome) VALUES ('Maryanska');
INSERT INTO Descobridor (nome) VALUES ('John Bell Hatcher');
INSERT INTO Descobridor (nome) VALUES ('Cientistas Alem�es');
INSERT INTO Descobridor (nome) VALUES ('Museu Americano de Hist�ria Natural');
INSERT INTO Descobridor (nome) VALUES ('Othniel Charles Marsh');
INSERT INTO Descobridor (nome) VALUES ('Barnum Brown');

INSERT INTO Grupo (nome) VALUES ('Anquilossauros');
INSERT INTO Grupo (nome) VALUES ('Ceratops�deoss');
INSERT INTO Grupo (nome) VALUES ('Estegossauros');
INSERT INTO Grupo (nome) VALUES ('Ter�podes');

INSERT INTO Dinossauros (nome, fk_grupo, fk_pais, fk_era, fk_descobridor, toneladas, ano)
VALUES ('Saichania', 1, 1, 1, 1, 4, 1977);
INSERT INTO Dinossauros (nome, fk_grupo, fk_pais, fk_era, fk_descobridor, toneladas, ano)
VALUES ('Tricer�tops', 2, 2, 1, 2, 6, 1887);
INSERT INTO Dinossauros (nome, fk_grupo, fk_pais, fk_era, fk_descobridor, toneladas, ano)
VALUES ('Kentrossauro', 3, 3, 2, 3, 2, 1909);
INSERT INTO Dinossauros (nome, fk_grupo, fk_pais, fk_era, fk_descobridor, toneladas, ano)
VALUES ('Pinacossauro', 1, 4, 1, 4, 6, 1999);
INSERT INTO Dinossauros (nome, fk_grupo, fk_pais, fk_era, fk_descobridor, toneladas, ano)
VALUES ('Alossauro', 4, 5, 2, 5, 3, 1877);
INSERT INTO Dinossauros (nome, fk_grupo, fk_pais, fk_era, fk_descobridor, toneladas, ano)
VALUES ('Torossauro', 2, 6, 1, 2, 8, 1891);
INSERT INTO Dinossauros (nome, fk_grupo, fk_pais, fk_era, fk_descobridor, toneladas, ano)
VALUES ('Anquilossauro', 1, 5, 1, 6, 8, 1906);

SELECT * FROM Dinossauros
SELECT * FROM Descobridor
SELECT * FROM Era
SELECT * FROM Grupo
SELECT * FROM Pais

/*7. Crie uma consulta para relacionar todos os dados dispon�veis de todos os dinossauros existentes no cat�logo em ordem alfab�tica de nome.*/
SELECT Dinossauros.nome AS 'Nome',
Grupo.nome AS 'Grupo' ,
Dinossauros.toneladas AS 'Toneladas',
Dinossauros.ano AS 'Ano Descoberta',
Descobridor.nome AS 'Descobridor',
Era.nome AS 'Era',
Era.inicio AS 'Inicio (milh�es)',
Era.fim AS 'Fim (milhoes)',
Pais.nome As 'Pais'
FROM Dinossauros, Descobridor, Era, Grupo, Pais
WHERE Dinossauros.fk_grupo = Grupo.id
AND Dinossauros.fk_pais = Pais.id
AND Dinossauros.fk_era = Era.id
AND Dinossauros.fk_descobridor = Descobridor.id
ORDER BY Dinossauros.nome

/*8. Crie uma consulta para relacionar todos os dados dispon�veis de todos os dinossauros existentes no cat�logo em ordem alfab�tica de descobridor.*/
SELECT Dinossauros.nome AS 'Nome',
Grupo.nome AS 'Grupo' ,
Dinossauros.toneladas AS 'Toneladas',
Dinossauros.ano AS 'Ano Descoberta',
Descobridor.nome AS 'Descobridor',
Era.nome AS 'Era',
Era.inicio AS 'Inicio (milh�es)',
Era.fim AS 'Fim (milhoes)',
Pais.nome As 'Pais'
FROM Dinossauros, Descobridor, Era, Grupo, Pais
WHERE Dinossauros.fk_grupo = Grupo.id
AND Dinossauros.fk_pais = Pais.id
AND Dinossauros.fk_era = Era.id
AND Dinossauros.fk_descobridor = Descobridor.id
ORDER BY Descobridor.nome

/*9. Crie uma consulta para relacionar todos os dados dispon�veis ddos dinossauros do grupo anquilossauros em ordem de ano de descoberta.*/
SELECT Dinossauros.nome AS 'Nome',
Grupo.nome AS 'Grupo' ,
Dinossauros.toneladas AS 'Toneladas',
Dinossauros.ano AS 'Ano Descoberta',
Descobridor.nome AS 'Descobridor',
Era.nome AS 'Era',
Era.inicio AS 'Inicio (milh�es)',
Era.fim AS 'Fim (milhoes)',
Pais.nome As 'Pais'
FROM Dinossauros, Descobridor, Era, Grupo, Pais
WHERE Dinossauros.fk_grupo = Grupo.id
AND Dinossauros.fk_pais = Pais.id
AND Dinossauros.fk_era = Era.id
AND Dinossauros.fk_descobridor = Descobridor.id
AND Grupo.id = 1
ORDER BY Dinossauros.ano

/*10. Crie uma consulta para relacionar todos os dados dispon�veis ddos dinossauros Ceratops�deos ou Anquilossauros com ano de descoberta entre 1990 e 1999.*/
SELECT Dinossauros.nome AS 'Nome',
Grupo.nome AS 'Grupo' ,
Dinossauros.toneladas AS 'Toneladas',
Dinossauros.ano AS 'Ano Descoberta',
Descobridor.nome AS 'Descobridor',
Era.nome AS 'Era',
Era.inicio AS 'Inicio (milh�es)',
Era.fim AS 'Fim (milhoes)',
Pais.nome As 'Pais'
FROM Dinossauros, Descobridor, Era, Grupo, Pais
WHERE Dinossauros.fk_grupo = Grupo.id
AND Dinossauros.fk_pais = Pais.id
AND Dinossauros.fk_era = Era.id
AND Dinossauros.fk_descobridor = Descobridor.id
AND (Grupo.id = 1 OR Grupo.id = 2)
AND 1990 <= Dinossauros.ano
AND Dinossauros.ano <= 1999