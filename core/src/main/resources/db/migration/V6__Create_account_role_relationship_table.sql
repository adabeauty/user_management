create table account_role (
    ID int not null AUTO_INCREMENT,
    ROLE_ID int(30) not null,
    ACCOUNT_ID int(30) not null,
    PRIMARY KEY (ID),
    FOREIGN KEY(ROLE_ID) REFERENCES ROLE(ID),
    FOREIGN KEY(ACCOUNT_ID) REFERENCES ACCOUNT(ID)
);