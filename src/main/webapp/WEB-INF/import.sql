insert  into `sklad_kladovshik`(`id`,`LOGIN`,`PASSWORD`) values (1,'Rasputin','1234567');
insert  into `sklad_kladovshik`(`id`,`LOGIN`,`PASSWORD`) values (2,'OLGADS',NULL);
insert  into `sklad_kladovshik`(`id`,`LOGIN`,`PASSWORD`) values (3,'UAS',NULL);
insert  into `sklad_kladovshik`(`id`,`LOGIN`,`PASSWORD`) values (4,'ALEXIA',NULL);
insert  into `sklad_kladovshik`(`id`,`LOGIN`,`PASSWORD`) values (5,'SMOTUZOVA','1234');
insert  into `sklad_kladovshik`(`id`,`LOGIN`,`PASSWORD`) values (6,'NATIS',NULL);
insert  into `sklad_kladovshik`(`id`,`LOGIN`,`PASSWORD`) values (7,'MAXAS',NULL);
insert  into `sklad_kladovshik`(`id`,`LOGIN`,`PASSWORD`) values (8,'SERGAE',NULL);
insert  into `sklad_kladovshik`(`id`,`LOGIN`,`PASSWORD`) values (9,'NATASHA',NULL);
insert  into `sklad_kladovshik`(`id`,`LOGIN`,`PASSWORD`) values (10,'GALAVM',NULL);

INSERT  INTO `sklad`(`id_sklad`,`bismt`,`close_kadr`,`edin`,`imports`,`in_bd`,`isdel`,`karta`,`kolvo`,`naim`,`naim2`,`price`,`sap_kod`,`sklad_key`,`stelach`,`testing`,`tolling`,`used`,`yatheika`) VALUES (1,'0','0','кг','0','0','0','0',1000,'Болт','0','100','0',0,'0','0','0','нет','0'),(2,'0','0','шт','0','0','0','0',200,'Гайка','0','20','0',0,'0','0','0','нет','0'),(3,'0','0','шт','0','0','0','0',50000,'Болт','0','100','0',0,'0','0','0','нет','0');INSERT  INTO `sklad_kladovshik`(`id`,`login`,`password`) VALUES (1,'Rasputin','1234567');
INSERT  INTO `sklad_sk`(`sklad_id`,`kladovshik_id`) VALUES (1,1),(2,1),(3,1);
INSERT  INTO `sklad_user`(`id`,`boss`,`department_id`,`firstname`,`fullname`,`job`,`lastname`,`login`,`otchestvo`,`section_id`,`t_number`,`user_status`,`user_id`) VALUES (2,1,1,'1','1','1','1','Rasputin','1',1,1,'1',1);
