drop table if exists BOOKINGS;
create table BOOKINGS(ID serial, FIRST_NAME varchar(5) NOT NULL);

drop table if exists `payment`;
CREATE TABLE `payment`(
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`serial` VARCHAR(200) DEFAULT '',
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8