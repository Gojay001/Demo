#删除数据库
DROP DATABASE IF EXISTS booksystem;

#创建数据库
CREATE DATABASE booksystem;

#选择数据库
USE booksystem;

#创建图书表
CREATE TABLE `book` (
  `book_id` INTEGER(20) NOT NULL AUTO_INCREMENT COMMENT '图书ID',
  `name` VARCHAR(100) NOT NULL COMMENT '图书名称',
  `detail` TEXT NOT NULL COMMENT '图书描述',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='图书表';