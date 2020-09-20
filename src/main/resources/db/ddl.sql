-- DDL

-- Sarunas

create table user
(
    id        bigint unsigned auto_increment primary key,
    user_name varchar(100) unique not null,
    password  varchar(255)        not null,
    email     varchar(255) unique not null
);


create table hotel
(
    id                    bigint unsigned auto_increment primary key,
    name                  varchar(100) unique not null,
    country               varchar(50)         not null,
    city_region           varchar(100)         not null,
    official_rating       varchar(50)         not null,
    inspection_score      int                 not null,
    food_quality          varchar(50),
    territory_size        varchar(50),
    water_slides          boolean             not null,
    spa                   boolean             not null,
    distance_to_beach     int,
    distance_from_airport double,
    remarks               text,
    user_id               bigint unsigned     not null,
    constraint fk_hotel_user foreign key (user_id) references user (id)
);

create table recommended_to
(
    id    bigint unsigned auto_increment primary key,
    title varchar(50) unique not null
);

create table hotel_recommended_to
(
    hotel_id          bigint unsigned not null,
    constraint fk_hotel_recommended_to_hotel foreign key (hotel_id) references hotel (id),
    recommended_to_id bigint unsigned not null,
    constraint fk_hotel_recommended_to_recommended_to foreign key (recommended_to_id) references recommended_to (id)
);

create table room
(
    id           bigint unsigned auto_increment primary key,
    type         varchar(50) unique,
    room_type_id bigint unsigned not null,
    constraint fk_room_room_type foreign key (room_type_id) references room_type (id),
    size         varchar(50),
    condition    varchar(50),
    remarks      text,
    hotel_id     bigint unsigned not null,
    constraint fk_room_hotel foreign key (hotel_id) references hotel (id)
);

create table room_type
(
    id    bigint unsigned auto_increment primary key,
    title varchar(50) unique not null
);

create table label
(
    id    bigint unsigned auto_increment primary key,
    title varchar(50) unique not null
);

create table hotel_label
(
    hotel_id bigint unsigned not null,
    constraint fk_hotel_label_hotel foreign key (hotel_id) references hotel (id),
    label_id bigint unsigned not null,
    constraint fk_hotel_label_label foreign key (hotel_id) references label (id)
);

create table cuisine_type
(
    id    bigint unsigned auto_increment primary key,
    title varchar(50) unique not null
);

create table hotel_cuisine_type
(
    hotel_id        bigint unsigned not null,
    constraint fk_hotel_cuisine_type_hotel foreign key (hotel_id) references hotel (id),
    cuisine_type_id bigint unsigned not null,
    constraint fk_hotel_cuisine_type_cuisine_type foreign key (cuisine_type_id) references cuisine_type (id)
);

-- Dominykas

-- Birute