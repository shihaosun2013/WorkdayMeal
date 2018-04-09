-- auto-generated definition
CREATE TABLE user
(
  uuid               INT UNSIGNED AUTO_INCREMENT
    PRIMARY KEY,
  username           VARCHAR(32)                                                 NOT NULL UNIQUE,
  first_name         VARCHAR(32) DEFAULT ''                                      NOT NULL
  COMMENT 'first name',
  last_name          VARCHAR(32) DEFAULT ''                                      NOT NULL
  COMMENT 'last name',
  nickname           VARCHAR(32) DEFAULT ''                                      NULL
  COMMENT 'nick name',
  password           VARCHAR(96) DEFAULT ''                                      NOT NULL
  COMMENT 'password',
  email              VARCHAR(64) DEFAULT ''                                      NOT NULL
  COMMENT 'email address',
  email_bind         BIT DEFAULT b'0'                                            NOT NULL
  COMMENT 'bind with email',
  mobile             VARCHAR(11) DEFAULT ''                                      NOT NULL
  COMMENT 'mobile number',
  mobile_bind        BIT DEFAULT b'0'                                            NOT NULL
  COMMENT 'bind with mobile number',
  avatar             VARCHAR(255) DEFAULT ''                                     NOT NULL
  COMMENT 'avatar',
  sex                VARCHAR(4) DEFAULT '0'                                      NOT NULL
  COMMENT 'sex',
  register_ip        VARCHAR(32) DEFAULT '0'                                     NOT NULL
  COMMENT 'register ip',
  create_time        DATETIME DEFAULT CURRENT_TIMESTAMP                          NOT NULL
  COMMENT 'creation time',
  update_time        DATETIME DEFAULT CURRENT_TIMESTAMP                          NOT NULL ON UPDATE CURRENT_TIMESTAMP
  COMMENT 'update time',
  last_login_time    DATETIME DEFAULT CURRENT_TIMESTAMP                          NOT NULL
  COMMENT 'last log in time',
  last_login_ip      VARCHAR(32) DEFAULT '0'                                     NOT NULL
  COMMENT 'last log in ip',
  status             TINYINT DEFAULT '1'                                         NOT NULL
  COMMENT 'status?0-banned?1-active?2-pending activate',
  is_delete          TINYINT DEFAULT '1'                                         NOT NULL
  COMMENT '0-deleted, 1-existing',
  exam_status        TINYINT DEFAULT '0'                                         NULL
  COMMENT '0-not audit; 1-auditing; 2-pass; 3-reject',
  area               VARCHAR(50)                                                 NULL
  COMMENT 'deliver area',
  zip_code           VARCHAR(10)                                                 NULL
  COMMENT 'deliver zip code',
  deliver_address_id VARCHAR(10)                                                 NULL
  COMMENT 'deliver address id'
)
  ENGINE = InnoDB;


INSERT INTO `user`
VALUES (1, 'happyshihao', 'shihao', 'shihao', NULL, 'afafadfa', 'shihaosun.usc@gmail.com', 1, '2133998198', 0, 0, 0,
                                                                                                                  '192.168.0.1',
                                                                                                                  now(),
                                                                                                                  now(),
                                                                                                                  now(),
                                                                                                                  '192.168.0.1',
                                                                                                                  1, 0,
                                                                                                                  NULL,
                                                                                                                  NULL,
        NULL, NULL);
INSERT INTO `user` (username, first_name, last_name, password, email, email_bind, mobile, mobile_bind, create_time, update_time, last_login_time, status, is_delete)
VALUES
  ('happyliping', 'shihao', 'shihao', 'afafadfa', 'shihaosun.usc@gmail.com', 1, '2133998198', 0, now(), now(), now(), 1,
   0);

INSERT INTO `user` (username, first_name, last_name, password, email, email_bind, mobile, mobile_bind, create_time, update_time, last_login_time, status, is_delete)
VALUES
  ('happycora', 'shihao', 'shihao', 'afafadfa', 'shihaosun.usc@gmail.com', 1, '2133998198', 0, now(), now(), now(), 1,
   0);

INSERT INTO user(username, first_name, last_name, password, email, email_bind, mobile, mobile_bind, create_time, update_time, last_login_time, status, is_delete) Values ('shihao', 'shihao', 'sun', 'password', '@gmail.com', 1, '8123612205', 0, '2018-04-08 16:45:03', '2018-04-08 16:45:03', '2018-04-08 16:45:03', 1, 1);

INSERT INTO user(username, first_name, last_name, password, email, email_bind, mobile, mobile_bind, status, is_delete)
Values ('shihao1', 'shihao', 'sun', 'password', '@gmail.com', 1, '8123612205', 0, 1, 1);