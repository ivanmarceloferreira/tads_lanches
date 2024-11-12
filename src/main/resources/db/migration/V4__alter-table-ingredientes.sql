alter table ingredientes add produto_id int;

alter table ingredientes add constraint FK_produto
foreign key (produto_id) references produtos(id);