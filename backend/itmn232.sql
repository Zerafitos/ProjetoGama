CREATE DATABASE itmn232;

USE itmn232;

CREATE TABLE `itmn232_usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nome_usuario` varchar(100) NOT NULL,
  `email_usuario` varchar(100) NOT NULL,
  `racf` varchar(7) NOT NULL,
  `senha` varchar(50) DEFAULT NULL,
  `link_foto` varchar(255) DEFAULT NULL,
  `gestor` int NOT NULL, 
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK_racf` (`racf`)
);

# perfil: 0 = colaborador, 1 = gestor

INSERT INTO `itmn232_usuario` (nome_usuario, email_usuario, racf, senha, link_foto, gestor) VALUES("Huguinho", "huguinho@itau.com.br", "HUGUINH","123456","https://itau.com.br/huguinho.jpg", 0);
INSERT INTO `itmn232_usuario` (nome_usuario, email_usuario, racf, senha, link_foto, gestor) VALUES("Zezinho", "Zezinho@itau.com.br", "ZEZINHO","123456","https://itau.com.br/zezinho.jpg", 0);
INSERT INTO `itmn232_usuario` (nome_usuario, email_usuario, racf, senha, link_foto, gestor) VALUES("Luisinho", "Luisinho@itau.com.br", "LUIZINH","123456","https://itau.com.br/luisinho.jpg", 0);
INSERT INTO `itmn232_usuario` (nome_usuario, email_usuario, racf, senha, link_foto, gestor) VALUES("Tio Patinhas", "tiopatinhas@itau.com.br", "TIOPATI","123456","https://itau.com.br/tiopatinhas.jpg", 1);

CREATE TABLE `itmn232_atividade` (
  `id_atividade` int NOT NULL AUTO_INCREMENT,
  `nome_atividade` varchar(100) NOT NULL,
  PRIMARY KEY (`id_atividade`)
);

INSERT INTO `itmn232_atividade` VALUES (null, "Execução de Mudança Planejada");
INSERT INTO `itmn232_atividade` VALUES (null, "Acionamento por Mudança");
INSERT INTO `itmn232_atividade` VALUES (null, "Acionamento por Incidente");
INSERT INTO `itmn232_atividade` VALUES (null, "Acionamento Indevido");
INSERT INTO `itmn232_atividade` VALUES (null, "Cobertura de Turnos");
INSERT INTO `itmn232_atividade` VALUES (null, "Cancelamento de Rotina Batch");
INSERT INTO `itmn232_atividade` VALUES (null, "Teste de Continuidade");
INSERT INTO `itmn232_atividade` VALUES (null, "Sustentação e Operação (24x7)");
INSERT INTO `itmn232_atividade` VALUES (null, "Implantação de Projeto");
INSERT INTO `itmn232_atividade` VALUES (null, "War Room");
INSERT INTO `itmn232_atividade` VALUES (null, "TOP TI");
INSERT INTO `itmn232_atividade` VALUES (null, "Hora não compensada no mês");
INSERT INTO `itmn232_atividade` VALUES (null, "Outros");

CREATE TABLE `itmn232_ocorrencia` (
  `num_seq` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `id_atividade` int NOT NULL DEFAULT 13,
  `descricao` varchar(255) DEFAULT NULL,
  `data_oc` date NOT NULL,
  `num_horas` time NOT NULL,
  `ponto_manual` int NOT NULL DEFAULT 0,
  `status` int NULL DEFAULT 0,
  PRIMARY KEY (`num_seq`),
  KEY `fk_usuario` (`id_usuario`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `itmn232_usuario` (`id_usuario`),
  KEY `fk_atividade` (`id_atividade`),
  CONSTRAINT `fk_atividade` FOREIGN KEY (`id_atividade`) REFERENCES `itmn232_atividade` (`id_atividade`)
);

# ponto_manual 0 = não, 1 = sim
# status 0 = pendente, 1 = justificada

INSERT INTO `itmn232_ocorrencia` VALUES (null, 4, 1, "Plantão noturno", '2020-09-20', '00:20', 0, 0);
INSERT INTO `itmn232_ocorrencia` VALUES (null, 3, 2, "Plantão diurno", '2020-09-21', '00:30', 0,0);
INSERT INTO `itmn232_ocorrencia` VALUES (null, 1, 10, "Mudança", '2020-09-22', '00:40', 1,0);
INSERT INTO `itmn232_ocorrencia` VALUES (null, 2, 13, "Acionamento", '2020-09-23', '01:20', 1,0);