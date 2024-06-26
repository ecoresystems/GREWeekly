CREATE TABLE USERS
(
    USER_ID     BIGINT AUTO_INCREMENT PRIMARY KEY,
    MAIL        VARCHAR(50) UNIQUE  NOT NULL,
    USER_NAME VARCHAR(50),
    AGE      TINYINT,
    COUNTRY     VARCHAR(50),
    NATIONALITY VARCHAR(50),
    PASSWORD    VARCHAR(128) NOT NULL
);

CREATE TABLE AUTH_USER_GROUP
(
    AUTH_USER_GROUP_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_MAIL VARCHAR(50) NOT NULL,
    AUTH_GROUP VARCHAR(128) NOT NULL ,
    CONSTRAINT USER_AUTH_USER_GROUP_FK FOREIGN KEY (USER_MAIL) REFERENCES USERS(MAIL),
    UNIQUE (USER_MAIL,AUTH_GROUP)
);

CREATE TABLE ANALYTICAL_WRITING
(
    QUESTION_ID   INT AUTO_INCREMENT PRIMARY KEY,
    QUESTION_TYPE TINYINT NOT NULL,
    QUESTION_BODY TEXT    NOT NULL

);

CREATE TABLE WRITING_ANSWERS
(
    ANSWER_ID   BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_ID     BIGINT   NOT NULL,
    ANSWER_BODY TEXT     NOT NULL,
    QUESTION_ID INT      NOT NULL,
    QUESTION_TYPE TINYINT NOT NULL,
    ANSWER_TIME TIMESTAMP NOT NULL
);

ALTER TABLE WRITING_ANSWERS ADD FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID);
ALTER TABLE WRITING_ANSWERS ADD FOREIGN KEY (QUESTION_ID) REFERENCES ANALYTICAL_WRITING(QUESTION_ID);