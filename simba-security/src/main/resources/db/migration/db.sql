DROP TABLE IF EXISTS s_user_group_t;

CREATE TABLE s_user_group_t(
    id VARCHAR(32) comment 'ID' ,
    name VARCHAR(100) comment '组名',
    
);

ALTER TABLE s_user_group_t 
add constraint PK_USER_GROUP primary key (id);

INSERT INTO s_user_group_t(id)
VALUES('1'),('2');