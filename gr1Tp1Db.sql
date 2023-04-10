CREATE DATABASE `gr1tp1db`;

CREATE TABLE `auteur` (
  `matricule` bigint(20) NOT NULL,
  `genre` enum('Masculin','Feminin') NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `livre` (
  `ISBN` bigint(20) NOT NULL,
  `dateEdition` date NOT NULL,
  `description` varchar(255) NOT NULL,
  `editeur` enum('ENI','FIRST','DUNOD') NOT NULL,
  `titre` varchar(255) NOT NULL,
  `matricule` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ISBN`),
  KEY `FKi1ebi5kq858gi66h7pn1qlbxw` (`matricule`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
  `login` varchar(255) NOT NULL,
  `id` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('Visiteur','Admin') NOT NULL,
  PRIMARY KEY (`login`,`id`),
  UNIQUE KEY `UK_slockai06wyhy7i5c8vnd2o31` (`login`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


INSERT INTO gr1tp1db.`user`
(login, id, password, `role`)
VALUES('admin', 1, 'admin', 'Admin');
INSERT INTO gr1tp1db.`user`
(login, id, password, `role`)
VALUES('visiteur', 2, 'visiteur', 'Visiteur');
