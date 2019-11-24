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


