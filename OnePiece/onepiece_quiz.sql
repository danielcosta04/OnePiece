-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18/06/2025 às 02:15
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `onepiece_quiz`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `perguntas`
--

CREATE TABLE `perguntas` (
  `id` int(11) NOT NULL,
  `grupo` int(11) NOT NULL,
  `enunciado` varchar(255) NOT NULL,
  `opcao1` varchar(100) NOT NULL,
  `opcao2` varchar(100) NOT NULL,
  `opcao3` varchar(100) NOT NULL,
  `respostaCorreta` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `perguntas`
--

INSERT INTO `perguntas` (`id`, `grupo`, `enunciado`, `opcao1`, `opcao2`, `opcao3`, `respostaCorreta`) VALUES
(1, 1, 'Qual é o nome da máquina virtual que executa programas Java?', 'JVM', 'JRE', 'JDK', 'JVM'),
(2, 1, 'Qual é o tipo de dado primitivo em Java usado para representar números inteiros de 32 bits?', 'long', 'int', 'short', 'int'),
(3, 1, 'Qual palavra-chave é usada para definir uma classe em Java?', 'class', 'interface', 'struct', 'class'),
(4, 2, 'Qual é a palavra-chave usada para criar uma instância de uma classe?', 'new', 'create', 'instance', 'new'),
(5, 2, 'Qual método é chamado automaticamente quando um objeto é criado em Java?', 'start()', 'init()', '<init>()', '<init>()'),
(6, 2, 'Qual é a saída do código: System.out.println(5 + 3 + \"Java\" + 2 + 1);?', '11Java', '8Java21', '8Java3', '8Java21'),
(7, 3, 'Qual é o tipo de dado usado para valores booleanos em Java?', 'boolean', 'bool', 'Boolean', 'boolean'),
(8, 3, 'Qual é o modificador de acesso que permite acesso apenas dentro do mesmo pacote em Java?', 'public', 'protected', 'default', 'default'),
(9, 3, 'Qual interface em Java é usada para tornar uma classe comparável?', 'Comparable', 'Comparator', 'Compare', 'Comparable'),
(10, 4, 'Qual é o método usado para converter uma string em um inteiro?', 'Integer.parseInt()', 'String.toInt()', 'Integer.valueOf()', 'Integer.parseInt()'),
(11, 4, 'Qual é a palavra-chave usada para herdar uma classe em Java?', 'implements', 'extends', 'inherits', 'extends'),
(12, 4, 'Qual exceção é lançada quando se tenta acessar um índice inválido em um array?', 'NullPointerException', 'ArrayIndexOutOfBoundsException', 'IllegalArgumentException', 'ArrayIndexOutOfBoundsException'),
(13, 5, 'Qual é a classe base para manipulação de strings em Java?', 'StringBuilder', 'String', 'StringBuffer', 'String'),
(14, 5, 'Qual é o método principal para iniciar a execução de um programa Java?', 'run()', 'main()', 'start()', 'main()'),
(15, 5, 'Qual coleção em Java não permite elementos duplicados?', 'List', 'Set', 'Queue', 'Set'),
(16, 6, 'Qual é a palavra-chave para sincronizar threads em Java?', 'synchronized', 'thread', 'lock', 'synchronized'),
(17, 6, 'Qual é o operador usado para verificar igualdade de conteúdo entre dois objetos em Java?', '==', 'equals()', 'compareTo()', 'equals()'),
(18, 6, 'Qual é o tipo de retorno padrão de um método que não retorna valor em Java?', 'void', 'null', 'int', 'void'),
(19, 7, 'Qual é o operador para concatenação de strings em Java?', '&', '+', '||', '+'),
(20, 7, 'Qual palavra-chave é usada para lançar uma exceção em Java?', 'throw', 'throws', 'try', 'throw'),
(21, 7, 'Qual é a superclasse de todas as classes em Java?', 'Class', 'Object', 'Super', 'Object'),
(22, 8, 'Qual é o modificador que torna um método acessível apenas na classe?', 'private', 'protected', 'public', 'private'),
(23, 8, 'Qual é o mecanismo em Java que permite múltiplas formas de um mesmo método?', 'Polimorfismo', 'Encapsulamento', 'Herança', 'Polimorfismo'),
(24, 8, 'Qual é a palavra-chave para declarar uma variável que não pode ser alterada?', 'static', 'final', 'const', 'final'),
(25, 9, 'Qual é a interface para coleções ordenadas em Java?', 'List', 'Set', 'Map', 'List'),
(26, 9, 'Qual é a interface usada para iterar sobre coleções em Java?', 'Iterator', 'Iterable', 'Enumeration', 'Iterator'),
(27, 9, 'Qual é o resultado de String s = null; System.out.println(s);?', 'null', '\"\"', 'Lança NullPointerException', 'null'),
(28, 10, 'Qual é o comando para pausar a execução de uma thread por um tempo?', 'Thread.sleep()', 'Thread.wait()', 'Thread.pause()', 'Thread.sleep()'),
(29, 10, 'Qual é o pacote padrão para classes de entrada/saída em Java?', 'java.util', 'java.io', 'java.net', 'java.io'),
(30, 10, 'Qual é a palavra-chave usada-para implementar uma interface em Java?', 'extends', 'implements', 'uses', 'implements');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `perguntas`
--
ALTER TABLE `perguntas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `perguntas`
--
ALTER TABLE `perguntas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
