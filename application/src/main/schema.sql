DROP TABLE IF EXISTS `sample_db`.`user`;

CREATE TABLE `sample_db`.`user` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255),
  `address` VARCHAR(255),
  `email` VARCHAR(255),
  `create_date` DATETIME,
  `update_date` DATETIME,
  PRIMARY KEY (`id`));

INSERT INTO `sample_db`.`user` (`id`, `name`, `address`, `email`, `create_date`, `update_date`) VALUES ('1', 'テスト太郎', '東京都品川区1-1', 'taro@test.com', '2021/06/30', '2021/06/30');
INSERT INTO `sample_db`.`user` (`id`, `name`, `address`, `email`, `create_date`, `update_date`) VALUES ('2', 'テスト次郎', '東京都渋谷区1-1', 'jiro@test.com', '2021/06/30', '2021/06/30');