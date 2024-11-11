create table produtos (
    id int not null primary key auto_increment,
    nome varchar(250),
    valor decimal(10,2),
    descricao varchar(500)
);