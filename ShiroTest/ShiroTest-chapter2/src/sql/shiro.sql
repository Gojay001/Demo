DROP DATABASE IF EXISTS shiro;
CREATE DATABASE shiro;
USE shiro;

CREATE TABLE users (
  id BIGINT AUTO_INCREMENT,
  username VARCHAR(100),
  password VARCHAR(100),
  password_salt VARCHAR(100),
  CONSTRAINT pk_users PRIMARY KEY(id)
) charset=utf8 ENGINE=InnoDB;
CREATE UNIQUE index idx_users_username ON users(username);

CREATE TABLE user_roles(
  id BIGINT AUTO_INCREMENT,
  username VARCHAR(100),
  role_name VARCHAR(100),
  CONSTRAINT pk_user_roles PRIMARY KEY(id)
) charset=utf8 ENGINE=InnoDB;
CREATE UNIQUE index idx_user_roles ON user_roles(username, role_name);

CREATE TABLE roles_permissions(
  id BIGINT AUTO_INCREMENT,
  role_name VARCHAR(100),
  permission VARCHAR(100),
  CONSTRAINT pk_roles_permissions PRIMARY KEY (id)
) charset=utf8 ENGINE=InnoDB;
CREATE UNIQUE index idx_roles_permissions ON roles_permissions(role_name, permission);

INSERT INTO users(username,password) VALUES ('root','root');