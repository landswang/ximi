DROP DATABASE IF EXISTS ejie_nbrs;
-- 需要 MySQL 5.6.5以上的版本
CREATE DATABASE ejie_nbrs;
USE ejie_nbrs;

DROP TABLE IF EXISTS _user;
-- 用户表
CREATE TABLE _user(
`user_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`user_name` VARCHAR(50) NOT NULL COMMENT '用户名',
`user_phone` BIGINT NOT NULL COMMENT '手机号',
`score` INT NOT NULL COMMENT '积分',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`user_id`),
KEY `idx_user_phone`(`user_phone`)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户表';

DROP TABLE IF EXISTS _goods;
-- 商品表
CREATE TABLE _goods(
`goods_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品ID',
`title` VARCHAR(120) NOT NULL COMMENT '商品名称',
`state` INT NOT NULL COMMENT '商品状态',
`price` FLOAT NOT NULL COMMENT '商品价格',
`number` INT NOT NULL COMMENT '商品数量',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`goods_id`)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品表';

DROP TABLE IF EXISTS _order;
-- 订单表
CREATE TABLE _order(
`order_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '订单ID',
`user_id` BIGINT NOT NULL  COMMENT '用户ID',
`goods_id` BIGINT NOT NULL  COMMENT '商品ID',
`title` VARCHAR(120) NOT NULL COMMENT '订单名称',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`order_id`),
KEY `idx_user_id`(`user_id`),
KEY `idx_goods_id`(`goods_id`)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='订单表';


-- 插入初始数据
INSERT INTO 
	_user(user_name, user_phone, score)
VALUES
	('阿诚', 18768128888, 0),
	('明楼', 18968129999, 0),
	('明台', 18968129999, 0),
	('明镜', 18968129999, 0),
	('漫春', 18968129999, 0),
	('曼丽', 18968129999, 0),
	('阿诚', 18768128888, 0),
	('明楼', 18968129999, 0),
	('明台', 18968129999, 0),
	('明镜', 18968129999, 0),
	('漫春', 18968129999, 0),
	('曼丽', 18968129999, 0),
	('阿诚', 18768128888, 0),
	('明楼', 18968129999, 0),
	('明台', 18968129999, 0),
	('明镜', 18968129999, 0),
	('漫春', 18968129999, 0),
	('曼丽', 18968129999, 0),
	('阿诚', 18768128888, 0),
	('明楼', 18968129999, 0),
	('明台', 18968129999, 0),
	('明镜', 18968129999, 0),
	('漫春', 18968129999, 0),
	('曼丽', 18968129999, 0),
	('阿诚', 18768128888, 0),
	('明楼', 18968129999, 0),
	('明台', 18968129999, 0),
	('明镜', 18968129999, 0),
	('漫春', 18968129999, 0),
	('曼丽', 18968129999, 0),
	('阿诚', 18768128888, 0),
	('明楼', 18968129999, 0),
	('明台', 18968129999, 0),
	('明镜', 18968129999, 0),
	('漫春', 18968129999, 0),
	('曼丽', 18968129999, 0),
	('阿诚', 18768128888, 0),
	('明楼', 18968129999, 0),
	('明台', 18968129999, 0),
	('明镜', 18968129999, 0),
	('漫春', 18968129999, 0),
	('曼丽', 18968129999, 0),
	('阿诚', 18768128888, 0),
	('明楼', 18968129999, 0),
	('明台', 18968129999, 0),
	('明镜', 18968129999, 0),
	('漫春', 18968129999, 0),
	('曼丽', 18968129999, 0),
	('阿诚', 18768128888, 0),
	('明楼', 18968129999, 0),
	('明台', 18968129999, 0),
	('明镜', 18968129999, 0),
	('漫春', 18968129999, 0),
	('曼丽', 18968129999, 0),
	('阿诚', 18768128888, 0),
	('明楼', 18968129999, 0),
	('明台', 18968129999, 0),
	('明镜', 18968129999, 0),
	('漫春', 18968129999, 0),
	('曼丽', 18968129999, 0),
	('阿诚', 18768128888, 0),
	('明楼', 18968129999, 0),
	('明台', 18968129999, 0),
	('明镜', 18968129999, 0),
	('漫春', 18968129999, 0),
	('曼丽', 18968129999, 0),
	('阿诚', 18768128888, 0),
	('明楼', 18968129999, 0),
	('明台', 18968129999, 0),
	('明镜', 18968129999, 0),
	('漫春', 18968129999, 0),
	('曼丽', 18968129999, 0),
	('明楼', 18968129999, 0);


INSERT INTO 
	_goods(title, state, price,number)
VALUES
	('huawei mate9', 1, 3999, 100),
	('meizu pro7', 1, 1999, 2000);
	