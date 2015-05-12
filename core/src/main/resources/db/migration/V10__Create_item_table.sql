CREATE TABLE item(

  ID int not null AUTO_INCREMENT,
  NAME varchar(100) not null,
  PRICE double not null,
  UNIT varchar(30) not null,
  CREATE_DATE date not null,
  BRAND varchar(50) not null,
  CATEGORY varchar(50) not null,
  PRIMARY KEY (ID)
);