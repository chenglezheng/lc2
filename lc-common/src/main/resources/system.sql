drop table if exists user;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   bigint(16) not null auto_increment comment '用户Id',
   user_name            varchar(16) comment '用户名称',
   password             varchar(200) not null comment '密码',
   nick_name            varchar(16) not null comment '用户昵称',
   sex                  char comment '性别',
   age                  numeric(3) comment '年龄',
   e_mail               varchar(100) comment '邮箱',
   e_mail_flag          char comment '邮箱激活标志',
   phone_number         numeric(11) comment '手机号码',
   qq                   numeric(16) comment 'qq号',
   wechat               varchar(200) comment '微信号',
   vip_level            char comment 'vip等级',
   role_id              numeric(2) comment '角色',
   is_enabled           tinyint comment '是否可用',
   university_id        numeric(8) comment '大学',
   major                numeric(8) comment '专业',
   head_image           varchar(500) comment '图像',
   register             numeric(1) comment '注册来源',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP comment '更新时间',
   primary key (id)
);

alter table user comment '用户表';


drop table if exists user_credentials;

/*==============================================================*/
/* Table: user_credentials                                      */
/*==============================================================*/
create table user_credentials
(
  user_name            varchar(16) comment '用户名称',
  type                 varchar(50) comment '类型',
  user_id              bigint(16) comment '用户id'
);

alter table user_credentials comment '角色用户关系表';


drop table if exists role_user;

/*==============================================================*/
/* Table: role_user                                             */
/*==============================================================*/
create table role_user
(
  role_id              bigint(11) not null comment '角色Id',
  user_id              bigint(16) not null comment '用户Id',
  primary key (role_id, user_id)
);

alter table role_user comment '角色用户关系表';


drop table if exists role;

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   bigint(11) not null auto_increment comment '角色Id',
   code                 varchar(50) not null comment '角色Code',
   name                 varchar(50) not null comment '角色名称',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP comment '更新时间',
   primary key (id)
);

alter table role comment '角色表';




drop table if exists role_permission;

/*==============================================================*/
/* Table: role_permission                                       */
/*==============================================================*/
create table role_permission
(
  role_id              bigint(3) not null comment '角色Id',
  permiss_id           bigint(3) not null comment '权限Id',
  primary key (role_id, permiss_id)
);

alter table role_permission comment '角色权限表';

drop table if exists permission;

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
  id                   bigint(11) not null auto_increment comment '权限id',
  code                 varchar(100) comment '权限code',
  permission           varchar(100) comment '权限名称',
  create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
  update_time          timestamp default CURRENT_TIMESTAMP comment '更新时间',
  primary key (id)
);

alter table permission comment '权限表';

drop table if exists column_table;

/*==============================================================*/
/* Table: column_table                                          */
/*==============================================================*/
create table column_table
(
   logical_table_name   varchar(50) not null comment '逻辑表名',
   physical_table_name  varchar(50) not null comment '物理表名',
   column_name          varchar(50) comment '列名',
   column_sort          int comment '列序号',
   column_comment       varchar(50) comment '列名名称',
   ref_object           varchar(50) comment '参考对象',
   ref_search_object    varchar(50) comment '参考对象的查询列',
   ref_display_object   varchar(50) comment '参考对象的显示列',
   menu_name            varchar(50) comment '菜单编码',
   column_value         varchar(200) comment '列值',
   is_not_null          int(1) comment '是否为空',
   is_open              int(1) comment '是否开放',
   is_editor            int(1) comment '是否可编辑',
   is_visible           int(1) comment '是否页面可见',
   column_with          int comment '列显示宽度',
   column_dislplay_type int(1) comment '列显示类型（文本框等）',
   valid_method         varchar(100) comment '文本框校验方法',
   display_form         int(2) comment '列展示形式',
   is_forzen_column     int(1) comment '是否冻结列',
   primary key (logical_table_name, physical_table_name)
);

alter table column_table comment '域名表';

drop table if exists object_table;

/*==============================================================*/
/* Table: object_table                                          */
/*==============================================================*/
create table object_table
(
   logical_table_name   varchar(50) not null comment '逻辑表名',
   pysical_table_name   varchar(50) not null comment '物理表名',
   table_comment        varchar(50) comment '表名名称',
   primarykey_count     int comment '主键个数',
   primarykey_name      varchar(50) comment '主键名',
   schema_name          varchar(50) comment '模式名',
   category_name        varchar(50) comment '仓库名',
   class_name           varchar(100) comment '类名（全路径）',
   display_column       varchar(50) comment '显示列',
   display_column_object varchar(50) comment '显示列关联对象',
   display_column_object_column varchar(50) comment '显示列关联对象列的列名称',
   primary key (logical_table_name, pysical_table_name)
);

alter table object_table comment '表名表';


drop table if exists menu;

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   menu_code            varchar(100) not null comment '菜单编码',
   menu_actual_value    varchar(100) not null comment '菜单实际值',
   menu_display_value   varchar(200) comment '菜单显示值',
   primary key (menu_code, menu_actual_value)
);

alter table menu comment '菜单表';

