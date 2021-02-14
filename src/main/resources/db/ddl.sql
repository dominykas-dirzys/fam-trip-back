create table user
(
    id       bigint unsigned auto_increment primary key,
    password varchar(60)         not null,
    email    varchar(255) unique not null
);

create table country
(
    id    bigint unsigned auto_increment primary key,
    title varchar(50) unique not null
);

create table city
(
    id         bigint unsigned auto_increment primary key,
    title      varchar(100)    not null,
    country_id bigint unsigned not null,
    constraint fk_hotel_country foreign key (country_id) references country (id)
);

create table label
(
    id       bigint unsigned auto_increment primary key,
    title    varchar(50) unique not null
);

create table cuisine_type
(
    id       bigint unsigned auto_increment primary key,
    title    varchar(50) unique not null
);

create table hotel
(
    id                    bigint unsigned auto_increment primary key,
    name                  varchar(100) unique not null,
    city_id               bigint unsigned     not null,
    constraint fk_hotel_city foreign key (city_id) references city (id),
    official_rating       varchar(50)         not null,
    inspection_score      tinyint             not null,
    food_quality          varchar(50),
    territory_size        varchar(50),
    water_slides          boolean             not null default false,
    spa                   boolean             not null default false,
    distance_to_beach     int,
    distance_from_airport double,
    remarks               text,
    author_id             bigint unsigned     not null,
    constraint fk_hotel_user foreign key (author_id) references user (id)
);

create table hotel_label
(
    hotel_id bigint unsigned not null,
    constraint fk_hotel_label_hotel foreign key (hotel_id) references hotel (id),
    label_id bigint unsigned not null,
    constraint fk_hotel_label_label foreign key (label_id) references label (id)
);

create table hotel_cuisine_type
(
    hotel_id bigint unsigned not null,
    constraint fk_hotel_cuisine_type_hotel foreign key (hotel_id) references hotel (id),
    cuisine_type_id bigint unsigned not null,
    constraint fk_hotel_cuisine_type_cuisine_type foreign key (cuisine_type_id) references cuisine_type (id)
);

create table hotel_recommended_to
(
    id       bigint unsigned auto_increment primary key,
    title    varchar(50) unique not null,
    hotel_id bigint unsigned not null,
    constraint fk_hotel_recommended_to_hotel foreign key (hotel_id) references hotel (id)
);

create table room
(
    id             bigint unsigned auto_increment primary key,
    type           varchar(50) unique,
    room_type      varchar(50)     not null,
    size           varchar(50),
    room_condition varchar(50),
    remarks        text,
    hotel_id       bigint unsigned not null,
    constraint fk_room_hotel foreign key (hotel_id) references hotel (id)
);
