CREATE DATABASE BIBLIOTECA
USE BIBLIOTECA

CREATE TABLE Autor (
  id int not null IDENTITY(1,1),
  nome varchar(100),
  nacionalidade varchar(100),
  PRIMARY KEY (id)
);

CREATE TABLE Categoria (
  id int not null IDENTITY(1,1),
  tipo_categoria varchar(50),
  PRIMARY KEY (id)
);

CREATE TABLE Editora (
  id int not null IDENTITY(1,1),
  nome varchar(50),
  PRIMARY KEY (id)
);

CREATE TABLE Livro (
  ISBN varchar(50),
  id_categoria int not null,
  id_editora int not null,
  titulo varchar(100) not null,
  ano int not null,
  PRIMARY KEY (ISBN),
  FOREIGN KEY (id_categoria) REFERENCES Categoria(id),
  FOREIGN KEY (id_editora) REFERENCES Editora(id)
);

CREATE TABLE Livro_Autor (
  id int not null IDENTITY(1,1),
  fk_autor int not null,
  fk_livro varchar(50) not null,
  PRIMARY KEY (id),
  FOREIGN KEY (fk_autor) REFERENCES Autor(id),
  FOREIGN KEY (fk_livro) REFERENCES Livro(ISBN)
);

INSERT INTO Autor (nome, nacionalidade) 
VALUES ('J.K.Rowling', 'Inglaterra');
INSERT INTO Autor (nome, nacionalidade) 
VALUES ('Clive Staples Lewis', 'Inglaterra');
INSERT INTO Autor (nome, nacionalidade) 
VALUES ('Affonso Solano', 'Brasil');
INSERT INTO Autor (nome, nacionalidade) 
VALUES ('Marcos Piangers', 'Brasil');
INSERT INTO Autor (nome, nacionalidade) 
VALUES ('Ciro Botelho - Tiririca', 'Brasil');
INSERT INTO Autor (nome, nacionalidade) 
VALUES ('Bianca Mól', 'Brasil');


INSERT INTO Categoria (tipo_categoria) 
VALUES ('Leitura Juvenil');
INSERT INTO Categoria (tipo_categoria) 
VALUES ('Ficção Cientifica');
INSERT INTO Categoria (tipo_categoria) 
VALUES ('Humor');

INSERT INTO Editora (nome) 
VALUES ('Rocco');
INSERT INTO Editora (nome) 
VALUES ('Wmf Martins Fontes');
INSERT INTO Editora (nome) 
VALUES ('Casa da Palavra ');
INSERT INTO Editora (nome) 
VALUES ('Belas Letras');
INSERT INTO Editora (nome) 
VALUES ('Matrix');

INSERT INTO Livro (ISBN, titulo, ano, id_categoria, id_editora) 
VALUES ('8532511015', 'Harry Potter e a Pedra Filosofal', '2000', '1', '1');
INSERT INTO Livro (ISBN, titulo, ano, id_categoria, id_editora) 
VALUES ('9788578270698', 'As Crônicas de Nárnia', '2009', '1', '2');
INSERT INTO Livro (ISBN, titulo, ano, id_categoria, id_editora) 
VALUES ('9788577343348', 'O Espadachim de Carvão', '2013', '2', '3');
INSERT INTO Livro (ISBN, titulo, ano, id_categoria, id_editora) 
VALUES ('9788581742458', 'O Papai É Pop', '2015', '3', '4');
INSERT INTO Livro (ISBN, titulo, ano, id_categoria, id_editora) 
VALUES ('9788582302026', 'Pior Que Tá Não Fica', '2015', '3', '5');
INSERT INTO Livro (ISBN, titulo, ano, id_categoria, id_editora) 
VALUES ('9788577345670', 'Garota Desdobrável', '2015', '1', '3');
INSERT INTO Livro (ISBN, titulo, ano, id_categoria, id_editora) 
VALUES ('8532512062', 'Harry Potter e o prisioneiro de Azkaban', '2000', '1', '1');

INSERT INTO Livro_Autor (fk_autor, fk_livro)
VALUES ('1','8532511015');
INSERT INTO Livro_Autor (fk_autor, fk_livro)
VALUES ('1','8532512062');
INSERT INTO Livro_Autor (fk_autor, fk_livro)
VALUES ('3','9788577343348');
INSERT INTO Livro_Autor (fk_autor, fk_livro)
VALUES ('6','9788577345670');
INSERT INTO Livro_Autor (fk_autor, fk_livro)
VALUES ('2','9788578270698');
INSERT INTO Livro_Autor (fk_autor, fk_livro)
VALUES ('4','9788581742458');
INSERT INTO Livro_Autor (fk_autor, fk_livro)
VALUES ('5','9788582302026');

SELECT * FROM Autor;
SELECT * FROM Livro;
SELECT * FROM Categoria;
SELECT * FROM Editora;
SELECT * FROM Livro_Autor;

SELECT l.ISBN, l.titulo, l.ano, e.nome, a.nome, a.nacionalidade, c.tipo_categoria FROM Livro_Autor la
JOIN Livro l ON la.fk_livro = l.ISBN
JOIN Categoria c ON l.id_categoria = c.id
JOIN Editora e ON l.id_editora = e.id
JOIN Autor a ON la.fk_autor = a.id
ORDER BY l.titulo;

SELECT l.ISBN, l.titulo, l.ano, e.nome, a.nome, a.nacionalidade, c.tipo_categoria FROM Livro_Autor la
JOIN Livro l ON la.fk_livro = l.ISBN
JOIN Categoria c ON l.id_categoria = c.id
JOIN Editora e ON l.id_editora = e.id
JOIN Autor a ON la.fk_autor = a.id
ORDER BY a.nome;

SELECT l.ISBN, l.titulo, l.ano, e.nome, a.nome, a.nacionalidade, c.tipo_categoria FROM Livro_Autor la
JOIN Livro l ON la.fk_livro = l.ISBN
JOIN Categoria c ON l.id_categoria = c.id
JOIN Editora e ON l.id_editora = e.id
JOIN Autor a ON la.fk_autor = a.id
WHERE c.id = 1
ORDER BY l.ano;

SELECT l.ISBN, l.titulo, l.ano, e.nome, a.nome, a.nacionalidade, c.tipo_categoria FROM Livro_Autor la
JOIN Livro l ON la.fk_livro = l.ISBN
JOIN Categoria c ON l.id_categoria = c.id
JOIN Editora e ON l.id_editora = e.id
JOIN Autor a ON la.fk_autor = a.id
WHERE 2000<l.ano AND l.ano<2010 AND (c.id=2 OR c.id=3)
ORDER BY l.ano;
