create database socTeste;
use socTeste;
create table paciente(
id int not null auto_increment primary key,
nome varchar(244)
);


create table exame(
id int not null auto_increment primary key,
nome varchar (244),
data date,
resultadoExame varchar (1000),
pacienteId int,
foreign key (pacienteId) references paciente (id)
);  