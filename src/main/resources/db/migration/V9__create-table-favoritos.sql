create table favoritos (
    id int not null primary key auto_increment,
    cliente_id int not null,
    produto_id int not null,
    foreign key (cliente_id) references clientes(id),
    foreign key (produto_id) references produtos(id)
);