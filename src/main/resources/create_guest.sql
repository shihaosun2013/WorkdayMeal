-- auto-generated definition
CREATE TABLE guest
(
  uuid               INT UNSIGNED PRIMARY KEY,
  deliver_address_id VARCHAR(10) DEFAULT ''          NOT NULL
  COMMENT 'deliver address id'
)
  ENGINE = InnoDB;

INSERT guest (uuid) VALUES (1);