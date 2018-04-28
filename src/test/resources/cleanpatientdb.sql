delete from patient;
delete from procedurecode;
delete from patientprocedure;
delete from role;
delete from user;
INSERT INTO `patient` VALUES (1,'Calvin','Prinsloo','iliotibial band syndrome','No Summary Available','Dr. Venter','415 North Ridge Drive','Waunakee','WI',53597),(2,'Abigail','Strauss','runners knee','No summary available','Dr. Hounshell','34 Savanah Hill','DeForest','WI',53612),(3,'Doug','Weiman','dislocated shoulder','','Dr. Thorpe','21 Moore Street','Sun Prairie','WI',51292),(4,'Robin','Roberts','Carpal tunnel syndrome','','Dr. Venter','8 Sunrise Valley','McFarland','WI',52932),(5,'Lizaan','Robijn','Post-surgical conditions','','Dr. Coetzer','876 Division Circle','Middleton','WI',52932);
INSERT INTO `procedurecode` VALUES (6,97001,'Physical Therapy Evaluation ',150),(7,97010,'Hot or Cold Packs',80),(8,97012,'Mechanical Traction',220),(9,97014,'Electrical Stimulation',280),(10,97018,'Paraffin bath',180),(11,97026,'Infrared',120),(12,97028,'Ultraviolet',160),(13,97035,'Ultrasound',160),(14,97110,'Therapeutic Exercise',170),(15,97124,'Massage Therapeutic',150),(16,97140,'Manual Therapy Techniques',260),(17,97535,'Self Care / Home Management',90);
INSERT INTO `patientprocedure` VALUES (1,6,'2018-02-16 14:41:53',1,FALSE),(2,7,'2018-02-17 14:42:10',1,TRUE),(3,8,'2018-02-19 14:42:42',1,TRUE),(4,14,'2018-02-19 14:43:05',2,FALSE),(5,17,'2018-02-22 15:37:36',3,TRUE),(6,9,'2018-02-22 15:38:35',4,FALSE),(7,12,'2018-02-25 15:39:16',5,1);
INSERT INTO `user` VALUES (1,'Dot','Robijn','drobijn','ss1'),(2,'Amanda','Spencer','aspencer','ss2');
INSERT INTO `role` VALUES (1,'owner','drobijn',1),(2,'receptionist','aspencer',2);




