create table artist
(
    id          varchar(22)  not null
        primary key,
    artist_name varchar(100) not null,
    location_id int          not null
);

create table location
(
    id      int auto_increment
        primary key,
    country varchar(30) not null,
    region  varchar(20) null,
    city    varchar(30) not null
);

create table artist_location
(
    artist_id   varchar(22) not null,
    location_id int         not null,
    primary key (artist_id, location_id),
    constraint artist_location_artist_id_uindex
        unique (artist_id),
    constraint artist_location_location_id_uindex
        unique (location_id),
    constraint artist_location_artist_id_fk
        foreign key (artist_id) references artist (id)
            on update cascade on delete cascade,
    constraint artist_location_location_id_fk
        foreign key (location_id) references location (id)
            on update cascade on delete cascade
)
    comment 'join';

