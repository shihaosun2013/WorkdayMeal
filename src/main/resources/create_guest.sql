-- auto-generated definition
CREATE TABLE guest
(
  uuid               INT UNSIGNED PRIMARY KEY,
  deliver_address_id VARCHAR(10)                        NULL
  COMMENT 'deliver address id'
)
  ENGINE = InnoDB;


insert guest(uuid) values (1);