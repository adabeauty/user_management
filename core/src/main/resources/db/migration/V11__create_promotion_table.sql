CREATE TABLE promotion(

  ID int not null AUTO_INCREMENT,
  TYPE varchar(30) not null default "买三赠一",
  CONDITION varchar(100) not null
);