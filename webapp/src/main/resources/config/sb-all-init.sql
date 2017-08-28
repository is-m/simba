USE mysql ;

DROP DATABASE IF EXISTS simba_demo ;

CREATE DATABASE simba_demo ;

USE simba_demo ;

-- 用户信息表
CREATE TABLE sb_user_t (
  id VARCHAR (50) PRIMARY KEY COMMENT 'ID',
  username VARCHAR (100) COMMENT '用户名',
  passwd VARCHAR (100) COMMENT '密码',
  phone VARCHAR (20) COMMENT '电话',
  email VARCHAR (50) COMMENT '邮箱'
) ;

-- 角色表
CREATE TABLE sb_role_t (
   id VARCHAR (50) PRIMARY KEY COMMENT 'ID',
   NAME VARCHAR(100) COMMENT '角色名称',
   description VARCHAR(100) COMMENT '角色描述',
   default_page VARCHAR(300) COMMENT '角色主页'
);

-- 资源

-- 栏目表
CREATE TABLE sb_catelog_t (
  id VARCHAR (50) PRIMARY KEY COMMENT 'ID',
  title VARCHAR (300) COMMENT '显示内容，可以直接是标题，也可以加zh_CN=菜单1,en_US=Menu 1',
  url VARCHAR (300) COMMENT '链接地址，可以是相对的，也可以是绝对的',
  enabled INT COMMENT '是否生效，1生效，0不生效',
  show_type VARCHAR (10) COMMENT '显示类型，all:全部可见，child:存在子项时可见，permission:功能可用时可见',
  show_value VARCHAR (50) COMMENT '显示指，在 show_type 的值为 permission 在该属性用于存放具体的permission',
  open_type VARCHAR (10) COMMENT '打开方式，当前页面打开：page,新窗口打开：window,内容框架打开：iframe'
) ;

