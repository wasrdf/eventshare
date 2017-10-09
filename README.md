# eventshare
PROJETO PARA COMPARTILHAMENTO DE EVENTOS
 
 CREATE DATABASE POSEIDON
 
 use poseidon;
  
 queries.
 
 


create table endereco(
codigo int primary key auto_increment,
cep varchar(15),
uf varchar(2),
cidade varchar(50),
bairro varchar(50),
logradouro varchar(50),
numero varchar(15),
complemento varchar(20)
);

create table estabelecimento(
codigo int primary key auto_increment,
cod_endereco int,
telefone varchar(15),
email varchar(50),
situacao varchar(15),
nivel int,
cpf_cnpj varchar(15),
data_cadastro date,
nome_responsavel varchar(50)
);

SELECT * FROM estabelecimento;

/*alter table estabelecimento change column cnpj  cpf_cnpj varchar(15);*/

alter table estabelecimento
add constraint fk_cod_endereco foreign key(cod_endereco) references endereco(codigo);

create table evento(
codigo int primary key auto_increment,
data_evento datetime,
descricao varchar(500),
data_termino_lista_amiga datetime,
url blob
);

create table cliente(
codigo int primary key auto_increment,
nome varchar(50),
telefone varchar(15),
email varchar(50),
aceita_sms boolean,
aceita_email boolean
);


select * from estabelecimento;
