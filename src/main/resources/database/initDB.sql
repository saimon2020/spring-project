CREATE TABLE IF NOT EXISTS rooms
(
    number    INTEGER  PRIMARY KEY ,
    type  VARCHAR(20) NOT NULL
);
CREATE TABLE IF NOT EXISTS clients
(
    id    INTEGER PRIMARY KEY ,
    name  VARCHAR(255) NOT NULL ,
    surname  VARCHAR(255) NOT NULL ,
    email VARCHAR(255) NOT NULL ,
    isMale BOOLEAN NOT NULL ,
    birthday DATE NOT NULL
);
CREATE TABLE IF NOT EXISTS slots
(
    id    BIGSERIAL PRIMARY KEY ,
    booking_date DATE NOT NULL ,
    booked BOOLEAN NOT NULL ,
    client_id    BIGSERIAL NOT NULL ,
    room_number    BIGSERIAL NOT NULL ,
    CONSTRAINT rooms_number_fk FOREIGN KEY (room_number) REFERENCES rooms (number) ,
    CONSTRAINT clients_id_fk FOREIGN KEY (client_id) REFERENCES clients (id)
);
CREATE TABLE IF NOT EXISTS bookings
(
    id    BIGSERIAL PRIMARY KEY ,
    paid BOOLEAN NOT NULL ,
    price INTEGER NOT NULL ,
    slot_id    BIGSERIAL NOT NULL ,
    CONSTRAINT slots_id_fk FOREIGN KEY (slot_id) REFERENCES slots (id)
);
CREATE TABLE IF NOT EXISTS feedbacks
(
    id    BIGSERIAL PRIMARY KEY ,
    rate INTEGER NOT NULL ,
    comment  VARCHAR(2000) NOT NULL,
    booking_id    BIGSERIAL NOT NULL ,
    CONSTRAINT bookings_id_fk FOREIGN KEY (booking_id) REFERENCES bookings (id)
);