create table enderecos (
    id int not null primary key auto_increment,
    cliente_id int not null,
    logradouro varchar(200),
    cidade varchar(200),
    foreign key (cliente_id) references clientes(id)
);