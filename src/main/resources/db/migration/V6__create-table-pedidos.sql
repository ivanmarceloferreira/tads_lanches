create table pedidos (
    id int not null primary key auto_increment,
    dt_pedido date,
    valor_total numeric(10,2)
);

create table pedido_produto (
    pedido_id int not null,
    produto_id int not null,
    primary key (pedido_id, produto_id),
    foreign key (pedido_id) references pedidos(id),
    foreign key (produto_id) references produtos(id)
);