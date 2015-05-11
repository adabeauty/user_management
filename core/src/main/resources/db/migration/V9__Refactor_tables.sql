DROP table ADMINISTRATOR;
DROP table account_role;
DROP table account;

CREATE TABLE user_role(
    ID int not null AUTO_INCREMENT,
    ROLE_ID int(30) not null,
    USER_ID int(30) not null,
    PRIMARY KEY (ID),
    FOREIGN KEY(ROLE_ID) REFERENCES ROLE(ID),
    FOREIGN KEY(USER_ID) REFERENCES USER(ID)

);