
-- 栏目表
DROP TABLE IF EXISTS sb_catelog_t;
CREATE TABLE sb_catelog_t (
  id VARCHAR(32) PRIMARY KEY COMMENT 'ID',
  title VARCHAR(1000) NOT NULL COMMENT '标题',
  icon VARCHAR(50) COMMENT '显示图标，可以是font awsome，也可以自己上传，如果自己上传，数据内容应该以file:attachmentId',
  url VARCHAR(500) COMMENT '访问路径',
  access_mode VARCHAR(20) COMMENT '访问方式，inner:内部链接,iframe:嵌入页面,window:新窗口',
  parent_id VARCHAR(32) COMMENT '父节点ID',
  seq SMALLINT COMMENT '显示顺序',
  is_enabled CHAR(1) COMMENT '是否生效',
  visible_mode VARCHAR(20) COMMENT '可见类型，all:全部可见,child:存在子栏目时可见,right:功能可用时可见',
  visible_value VARCHAR(200) COMMENT '可见值，暂定为 visible_mode 为 right:功能可用时可见 时，该值为具体功能权限点CODE',
  edition INT COMMENT '数据版本号',
  delete_flag CHAR(1) DEFAULT 'N' COMMENT '删除标记,N:未删除，Y:已删除',
  created_by VARCHAR(32) COMMENT '创建人',
  creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  last_update_by VARCHAR(32) COMMENT '最后修改人',
  last_updated_date TIMESTAMP COMMENT '最后修改时间'
)