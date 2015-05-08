create table role_url(
  ID int not null AUTO_INCREMENT,
  ROLE_ID int not null,
  URL_ID int not null,
  PRIMARY KEY (ID),
  FOREIGN KEY (ROLE_ID) REFERENCES ROLE(ID),
  FOREIGN KEY (URL_ID) REFERENCES URL(ID)
);