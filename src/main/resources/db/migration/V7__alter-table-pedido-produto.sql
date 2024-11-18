alter table pedidos add cliente_id int;
alter table pedidos add foreign key (cliente_id)
    references clientes(id);
alter table pedido_produto add valor numeric(10,2);
alter table pedido_produto add quantidade numeric(10,2);