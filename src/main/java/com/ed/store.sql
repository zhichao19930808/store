DROP DATABASE IF EXISTS db_store;
CREATE DATABASE db_store;

DROP TABLE IF EXISTS db_store.user;
CREATE TABLE db_store.user (
  id        INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'id',
  userName  VARCHAR(255) NOT NULL UNIQUE
  COMMENT '用户名',
  password  VARCHAR(255) NOT NULL
  COMMENT '密码',
  name      VARCHAR(255) COMMENT '姓名',
  sex       VARCHAR(255) COMMENT '性别',
  email     VARCHAR(255) COMMENT '邮箱',
  telephone VARCHAR(255) COMMENT '电话',
  birthday  DATE COMMENT '生日',
  state   INT DEFAULT 0
  COMMENT '激活状态1/0',
  code      VARCHAR(255) COMMENT '激活码'
);

SELECT *
FROM db_exam.user;
SELECT * FROM db_store.user;
INSERT INTO db_store.user (userName, password, name, sex, email, telephone, birthday, code) VALUES ();

SELECT *
FROM db_store.user;

UPDATE db_store.user
SET state = 1
WHERE id = ? AND code = ?;

DELETE FROM db_store.user;
-- --------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS db_store.kind;
CREATE TABLE db_store.kind (
  id   INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'id',
  name VARCHAR(255) COMMENT '种类名称'
);
INSERT INTO db_store.kind(name) VALUES ('手机数码'),('运动户外'),('电脑办公'),('家具家居'),('鞋靴箱包'),('图书音像'),('母婴孕婴'),('汽车用品');


