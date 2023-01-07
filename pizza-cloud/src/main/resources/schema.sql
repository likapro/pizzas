create table if not exists Pizza_order (
    id identity,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    delivery_State varchar(2) not null,
    delivery_Zip varchar(10) not null,
    cc_Number varchar(16) not null,
    cc_Expiration varchar(5) not null,
    cc_CVV varchar(3) not null,
    placed_At timestamp not null
);

create table if not exists Pizza (
    id identity,
    name varchar(50) not null,
    pizza_order bigint not null,
    pizza_order_key bigint not null,
    created_at timestamp not null
);

create table if not exists Ingredient_Ref (
    ingredient varchar(4) not null,
    pizza bigint not null,
    pizza_key bigint not null
);

create table if not exists Ingredient (
    id varchar(4) UNIQUE not null,
    name varchar(25) not null,
    type varchar(10) not null
);

alter table Pizza add foreign key (pizza_order) references Pizza_order(id);
alter table Ingredient_Ref add foreign key (ingredient) references Ingredient(id);