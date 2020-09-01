CREATE TABLE IF NOT EXISTS `user` (
 
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` varchar(40),
    `password` varchar(128),
 	`email_id` VARCHAR(100)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

ALTER TABLE user ADD UNIQUE uidx_user_01 (username);