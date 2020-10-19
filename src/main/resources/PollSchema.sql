/*
CREATE TABLE pollStat(
id LONG PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(255),
question VARCHAR(255),
answer1 VARCHAR(255),
answer2 VARCHAR(255),
answer3 VARCHAR(255),
votes1 INT,
votes2 INT,
votes3 INT,
Date DATE
);
INSERT INTO pollStat(title,question,answer1,answer2,answer3,votes1,votes2,votes3,date)
VALUES('Candy Poll','What is your favourite Candy','Smarties','salt water taffy' ,'Candy Canes',1,0,0,TO_DATE('13/10/2020', 'DD/MM/YYYY'));
INSERT INTO pollStat(title,question,answer1,answer2,answer3,votes1,votes2,votes3,date)
VALUES('Sport Poll','What is your favourite Sport?','Soccer','Basket Ball' ,'Swimming',0,1,0,TO_DATE('12/10/2020', 'DD/MM/YYYY'));
INSERT INTO pollStat(title,question,answer1,answer2,answer3,votes1,votes2,votes3,date)
VALUES('Color Poll','What is your favourite Color','Red','Blue' ,'Green',0,0,1,TO_DATE('13/10/2020', 'DD/MM/YYYY'));
INSERT INTO pollStat(title,question,answer1,answer2,answer3,votes1,votes2,votes3,date)
VALUES('Candy Poll','What is your favourite Candy','Smarties','salt water taffy' ,'Candy Canes',0,0,1,TO_DATE('14/10/2020', 'DD/MM/YYYY'));/