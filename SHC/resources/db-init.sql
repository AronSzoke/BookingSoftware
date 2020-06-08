--drops
--drop sequences
DROP SEQUENCE room_to_reservation_seq;
DROP SEQUENCE hotel_seq;
DROP SEQUENCE room_seq;
DROP SEQUENCE users_seq;
DROP SEQUENCE reservation_seq;
DROP SEQUENCE bed_seq;
DROP SEQUENCE services_seq;
DROP SEQUENCE hotel_to_service_seq;
DROP SEQUENCE bed_to_room_seq;
DROP SEQUENCE equipment_to_room_seq;
DROP SEQUENCE equipment_seq;

--drop tables
DROP TABLE room_to_reservation;
DROP TABLE bed_to_room CASCADE CONSTRAINTS;
DROP TABLE bed CASCADE CONSTRAINTS;
DROP TABLE room CASCADE CONSTRAINTS;
DROP TABLE reservation CASCADE CONSTRAINTS;
DROP TABLE users CASCADE CONSTRAINTS;
DROP TABLE hotel_to_service CASCADE CONSTRAINTS;
DROP TABLE services CASCADE CONSTRAINTS;
DROP TABLE hotel CASCADE CONSTRAINTS;
DROP TABLE equipment_to_room CASCADE CONSTRAINTS;
DROP TABLE equipment CASCADE CONSTRAINTS;

--create sequences
CREATE SEQUENCE hotel_seq;
CREATE SEQUENCE room_seq;
CREATE SEQUENCE users_seq;
CREATE SEQUENCE reservation_seq;
CREATE SEQUENCE bed_seq;
CREATE SEQUENCE services_seq;
CREATE SEQUENCE hotel_to_service_seq;
CREATE SEQUENCE bed_to_room_seq;
CREATE SEQUENCE room_to_reservation_seq;
CREATE SEQUENCE equipment_to_room_seq;
CREATE SEQUENCE equipment_seq;

--create tables
CREATE TABLE hotel (
    hotel_id     NUMBER(20) NOT NULL,
    hotel_type   VARCHAR(50) NOT NULL,
    hotel_name   VARCHAR(50) NOT NULL,
    address      VARCHAR(200) NOT NULL,
    stars        NUMBER(1) NOT NULL,
    review       NUMBER(2, 1),
    CONSTRAINT hotel_pk PRIMARY KEY ( hotel_id ),
    CONSTRAINT hotel_ck1 CHECK ( stars > 0
                                 AND stars <= 5 ),
    CONSTRAINT hotel_ck2 CHECK ( review BETWEEN 0 AND 10 )
);

CREATE TABLE room (
    room_id          NUMBER(20) NOT NULL,
    hotel_id         NUMBER(20) NOT NULL,
    room_type        VARCHAR(50) NOT NULL,
    floor            NUMBER(2) NOT NULL,
    room_number      NUMBER(3) NOT NULL,
    room_size        NUMBER(2) NOT NULL,
    room_price       NUMBER(7) NOT NULL,
    balcony          CHAR(1) DEFAULT 'N' NOT NULL,
    CONSTRAINT room_pk PRIMARY KEY ( room_id ),
    CONSTRAINT room_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( hotel_id ),
    CONSTRAINT room_ck1 CHECK ( floor >= 0 ),
    CONSTRAINT room_ck2 CHECK ( room_number > 0 ),
    CONSTRAINT room_ck3 CHECK ( room_size > 0 ),
    CONSTRAINT room_ck4 CHECK ( room_price > 0 ),
    CONSTRAINT room_ck5 CHECK ( balcony IN (
        'Y',
        'N'
    ) )
);

CREATE TABLE users (
    user_id         NUMBER(20) NOT NULL,
    user_name       VARCHAR(50) NOT NULL,
    user_password   VARCHAR(100) NOT NULL,
    user_type       VARCHAR(20) NOT NULL,
    first_name      VARCHAR(50) NOT NULL,
    last_name       VARCHAR(50) NOT NULL,
    email VARCHAR (100) NOT NULL,
    date_of_birth DATE NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY ( user_id ),
    CONSTRAINT users_ck1 CHECK ( length(user_name) > 2 ),
    CONSTRAINT users_ck2 CHECK ( user_type IN (
        'GUEST',
        'ADMIN'
    ) )
);

CREATE TABLE reservation (
    reservation_id   NUMBER(20) NOT NULL,
    user_id          NUMBER(20) NOT NULL,
    date_from        DATE NOT NULL,
    date_to          DATE NOT NULL,
    total_price      NUMBER(20) NOT NULL,
    status           VARCHAR(20) DEFAULT 'ACTIVE' NOT NULL,
    CONSTRAINT reservation_pk PRIMARY KEY ( reservation_id ),
    CONSTRAINT reservation_ck CHECK ( status IN (
        'ACTIVE',
        'DELETED'
    ) ),
    CONSTRAINT reservation_fk1 FOREIGN KEY ( user_id )
        REFERENCES users ( user_id )
);

CREATE TABLE bed (
    bed_id      NUMBER(20) NOT NULL,
    bed_type    VARCHAR(20) NOT NULL,
    bed_space   NUMBER(1) NOT NULL,
    CONSTRAINT bed_pk PRIMARY KEY ( bed_id ),
    CONSTRAINT bed_ck1 CHECK ( bed_type IN (
        'single',
        'twin',
        'double',
        'king',
        'queen',
        'sofa'
    ) ),
    CONSTRAINT bed_ck2 CHECK ( bed_space > 0 )
);

CREATE TABLE services (
    service_id     NUMBER(20) NOT NULL,
    service_name   VARCHAR(20) NOT NULL,
    price          NUMBER(20) NOT NULL,
    CONSTRAINT services_pk PRIMARY KEY ( service_id ),
    CONSTRAINT services_ck CHECK ( price >= 0 )
);

CREATE TABLE hotel_to_service (
    hotel_to_service_id   NUMBER(20) NOT NULL,
    hotel_id              NUMBER(20) NOT NULL,
    service_id            NUMBER(20) NOT NULL,
    CONSTRAINT hotel_to_service_pk PRIMARY KEY ( hotel_to_service_id ),
    CONSTRAINT hotel_to_service_fk1 FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( hotel_id ),
    CONSTRAINT hotel_to_service_fk2 FOREIGN KEY ( service_id )
        REFERENCES services ( service_id )
);

CREATE TABLE bed_to_room (
    bed_to_room_id   NUMBER(20) NOT NULL,
    room_id          NUMBER(20) NOT NULL,
    bed_id           NUMBER(20) NOT null,
            CONSTRAINT bed_to_room_pk PRIMARY KEY
    (bed_to_room_id),
    CONSTRAINT bed_to_room_fk1 FOREIGN KEY ( room_id )
        REFERENCES room ( room_id ),
    CONSTRAINT bed_to_room_fk2 FOREIGN KEY ( bed_id )
        REFERENCES bed ( bed_id )
);

CREATE TABLE room_to_reservation (
    room_to_reservation_id   NUMBER(20) NOT NULL,
    room_id                  NUMBER(20) NOT NULL,
    reservation_id           NUMBER(20) NOT NULL,
    CONSTRAINT room_to_reservation_pk PRIMARY KEY ( room_to_reservation_id ),
    CONSTRAINT room_to_reservation_fk1 FOREIGN KEY ( room_id )
        REFERENCES room ( room_id ),
    CONSTRAINT room_to_reservation_fk2 FOREIGN KEY ( reservation_id )
        REFERENCES reservation ( reservation_id )
);

CREATE TABLE equipment (
    equipment_id   NUMBER(20) NOT NULL,
    name            VARCHAR(50) NOT NULL,
    CONSTRAINT equipment_pk PRIMARY KEY ( equipment_id )
);

CREATE TABLE equipment_to_room (
    equipment_to_room_id   NUMBER(20) NOT NULL,
    equipment_id           NUMBER(20) NOT NULL,
    room_id                NUMBER(20) NOT NULL,
    CONSTRAINT equipment_to_room_pk PRIMARY KEY ( equipment_to_room_id ),
    CONSTRAINT equipment_to_room_fk1 FOREIGN KEY ( equipment_id )
        REFERENCES equipment ( equipment_id ),
    CONSTRAINT equipment_to_room_fk2 FOREIGN KEY ( room_id )
        REFERENCES room ( room_id )
);



