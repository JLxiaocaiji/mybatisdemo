show databases;

create database db01;

use db01;

drop schema db01;

drop table if exists tb_user;

# 创建
create table tb_user (
                         id int primary key auto_increment comment 'ID, 唯一标识',
                         username varchar(20) not null unique comment '用户名',
                         name varchar(10) not null comment '姓名',
                         age int comment '年龄',
                         gender char(1) default '男' comment '性别'
) comment '用户表';

show create table tb_emp;


# 更新数据
update tb_emp set name = '张三', update_time = now() where id = 1;
# 将 tb_emp 中的所有员工的入职日期更新为 ‘2010-01-01’
update tb_emp set entrydate = '2010-01-01', update_time = now();

# 删除
# delete from 表名 [where 条件]; 若没有条件语句会全部删除

create database db02;

use db02;

create table tb_emp (
                        id int unsigned primary key auto_increment comment 'ID',
                        username varchar(20) not null unique comment '用户名',
                        password varchar(32) default '123456' comment '密码',
                        name varchar(10) not null comment '姓名',
                        gender tinyint unsigned not null comment '性别, 说明: 1 男, 2 女',
                        image varchar(300) comment '图像',
                        job tinyint unsigned comment '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管',
                        entrydate date comment '入职时间',
                        create_time datetime not null comment '创建时间',
                        update_time datetime not null comment '修改时间'
) comment '员工表';

insert into tb_emp (id, username, password, name, gender, image, job, entrydate, create_time, update_time) values
                                                                                                               (1, 'jinyong', '123456', '金庸', 1, '1.jpg', 4, '2000-01-01', '2022-10-27 16:35:33', '2022-10-27 16:35:35'),
                                                                                                               (2, 'zhangwuji', '123456', '张无忌', 1, '2.jpg', 2, '2015-01-01', '2022-10-27 16:35:33', '2022-10-27 16:35:37'),
                                                                                                               (3, 'yangxiao', '123456', '杨逍', 1, '3.jpg', 2, '2008-05-01', '2022-10-27 16:35:33', '2022-10-27 16:35:39'),
                                                                                                               (4, 'weiyixiao', '123456', '韦一笑', 1, '4.jpg', 2, '2007-01-01', '2022-10-27 16:35:33', '2022-10-27 16:35:41'),
                                                                                                               (5, 'changyuchun', '123456', '常遇春', 1, '5.jpg', 2, '2012-12-05', '2022-10-27 16:35:33', '2022-10-27 16:35:43'),
                                                                                                               (6, 'xiaozhao', '123456', '小昭', 2, '6.jpg', 3, '2013-09-05', '2022-10-27 16:35:33', '2022-10-27 16:35:45'),
                                                                                                               (7, 'jixiaofu', '123456', '纪晓芙', 2, '7.jpg', 1, '2005-08-01', '2022-10-27 16:35:33', '2022-10-27 16:35:47'),
                                                                                                               (8, 'zhouzhiruo', '123456', '周芷若', 2, '8.jpg', 1, '2014-11-09', '2022-10-27 16:35:33', '2022-10-27 16:35:49'),
                                                                                                               (9, 'dingminjun', '123456', '丁敏君', 2, '9.jpg', 1, '2011-03-11', '2022-10-27 16:35:33', '2022-10-27 16:35:51'),
                                                                                                               (10, 'zhaomin', '123456', '赵敏', 2, '10.jpg', 1, '2013-09-05', '2022-10-27 16:35:33', '2022-10-27 16:35:53'),
                                                                                                               (11, 'luzhangke', '123456', '鹿杖客', 1, '11.jpg', 2, '2007-02-01', '2022-10-27 16:35:33', '2022-10-27 16:35:55'),
                                                                                                               (12, 'hebiweng', '123456', '鹤笔翁', 1, '12.jpg', 2, '2008-08-18', '2022-10-27 16:35:33', '2022-10-27 16:35:57'),
                                                                                                               (13, 'fangdongbai', '123456', '方东白', 1, '13.jpg', 1, '2012-11-01', '2022-10-27 16:35:33', '2022-10-27 16:35:59'),
                                                                                                               (14, 'zhangsanfeng', '123456', '张三丰', 1, '14.jpg', 2, '2002-08-01', '2022-10-27 16:35:33', '2022-10-27 16:36:01'),
                                                                                                               (15, 'yulianzhou', '123456', '俞莲舟', 1, '15.jpg', 2, '2011-05-01', '2022-10-27 16:35:33', '2022-10-27 16:36:03'),
                                                                                                               (16, 'songyuanqiao', '123456', '宋远桥', 1, '16.jpg', 2, '2010-01-01', '2022-10-27 16:35:33', '2022-10-27 16:36:05'),
                                                                                                               (17, 'chenyouliang', '12345678', '陈友谅', 1, '17.jpg', null, '2015-03-21', '2022-10-27 16:35:33', '2022-10-27 16:36:07'),
                                                                                                               (18, 'zhang1', '123456', '张一', 1, '2.jpg', 2, '2015-01-01', '2022-10-27 16:35:33', '2022-10-27 16:36:09'),
                                                                                                               (19, 'zhang2', '123456', '张二', 1, '2.jpg', 2, '2012-01-01', '2022-10-27 16:35:33', '2022-10-27 16:36:11'),
                                                                                                               (20, 'zhang3', '123456', '张三', 1, '2.jpg', 2, '2018-01-01', '2022-10-27 16:35:33', '2022-10-27 16:36:13'),
                                                                                                               (21, 'zhang4', '123456', '张四', 1, '2.jpg', 2, '2015-01-01', '2022-10-27 16:35:33', '2022-10-27 16:36:15'),
                                                                                                               (22, 'zhang5', '123456', '张五', 1, '2.jpg', 2, '2016-01-01', '2022-10-27 16:35:33', '2022-10-27 16:36:17'),
                                                                                                               (23, 'zhang6', '123456', '张六', 1, '2.jpg', 2, '2012-01-01', '2022-10-27 16:35:33', '2022-10-27 16:36:19'),
                                                                                                               (24, 'zhang7', '123456', '张七', 1, '2.jpg', 2, '2006-01-01', '2022-10-27 16:35:33', '2022-10-27 16:36:21'),
                                                                                                               (25, 'zhang8', '123456', '张八', 1, '2.jpg', 2, '2002-01-01', '2022-10-27 16:35:33', '2022-10-27 16:36:23'),
                                                                                                               (26, 'zhang9', '123456', '张九', 1, '2.jpg', 2, '2011-01-01', '2022-10-27 16:35:33', '2022-10-27 16:36:25'),
                                                                                                               (27, 'zhang10', '123456', '张十', 1, '2.jpg', 2, '2004-01-01', '2022-10-27 16:35:33', '2022-10-27 16:36:27'),
                                                                                                               (28, 'zhang11', '123456', '张十一', 1, '2.jpg', 2, '2007-01-01', '2022-10-27 16:35:33', '2022-10-27 16:36:29'),
                                                                                                               (29, 'zhang12', '123456', '张十二', 1, '2.jpg', 2, '2020-01-01', '2022-10-27 16:35:33', '2022-10-27 16:36:31');

## 基本语句 ##
# 1.查询指定字段 name, entrydate 并返回
select name, entrydate from tb_emp;
# 2. 查询返回所有字段
select * from tb_emp;
# 3. 查询所有员工 name, entrydate 并起别名
select name as a, entrydate as b from tb_emp;
# 4. 查询已有员工关联了哪几种职位
select distinct job from tb_emp;

## 条件查询 ##
# 1. 查询姓名 为 杨逍 的员工
select * from tb_emp where name='杨逍';
# 2. 查询 id小于等于5 的员工信息
select * from tb_emp where id <= 5;
# 3. 查询 没有分配职位 的员工信息
select * from tb_emp where job is null;
# 4.查询 有职位 的员工信息
select * from tb_emp where job is not null;
# 5.查询 密码不等于 '123456' 的员工信息
select * from tb_emp where password != '123456';
select * from tb_emp where password <> '123456';
# 6.查询 入职日期 在 '2000-01-01' (包含) 到 '2010-01-01'(包含) 之间的员工信息
select * from tb_emp where entrydate between '2000-01-01' and  '2010-01-01';
select * from tb_emp where entrydate >= '2000-01-01' <= '2010-01-01';
# 7.查询 入职时间 在 '2000-01-01' (包含) 到 '2010-01-01'(包含) 之间 且 性别为女 的员工信息
select * from tb_emp where (entrydate between '2000-01-01' and  '2010-01-01') and gender = 2;
select * from tb_emp where (entrydate between '2000-01-01' and  '2010-01-01') && gender = 2;
# 8.查询 职位是 2 (讲师), 3 (学工主管), 4 (教研主管) 的员工信息
select * from tb_emp where job in (2,3,4);
select * from tb_emp where job = 2 or job = 3 or job = 4;
# 9.查询 姓名 为两个字的员工信息
select * from tb_emp where name like '__';
# 10.查询 姓 '张' 的员工信息
select * from tb_emp where name like '张%';

# 聚合查询
# 1. 统计该企业员工数量
select count(*) from tb_emp;
# 2. 统计该企业员工 ID 的平均值
select avg(id) from tb_emp;
# 3. 统计该企业最早入职的员工
select min(entrydate) from tb_emp;
# 4. 统计该企业最迟入职的员工
select max(entrydate) from tb_emp;
# 5. 统计该企业员工的 ID 之和
select sum(id) from tb_emp;

# 分组查询
# 1. 根据性别分组 , 统计男性和女性员工的数量
select gender, count(*) from tb_emp group by gender;
# 3. 先查询入职时间在 '2015-01-01' (包含) 以前的员工 , 并对结果根据职位分组 , 获取员工数量大于等于2的职位
select job, count(*) from  tb_emp where entrydate <= '2015-01-01' group by job  having count(*) >= 2;

# 排序查询  若多字段排序，当第一个字段值相同时，才会根据第二个字段排序
# 1. 根据 入职时间 对公司的员工进行 升序排序 ， 入职时间相同 , 再按照 更新时间 进行降序排序
select * from tb_emp order by entrydate, update_time desc;

# 分页查询
# 1. 查询 第3页 员工数据, 每页展示5条记录
select * from tb_emp limit 10, 5;

# 示例： 列表条件查询
select * from tb_emp where name like '%张%' and gender = 1 and entrydate
    between '2000-01-01' and '2015-12-31' order by
    update_time desc limit 0, 10;

# 员工性别统计
select gender, count(*) from tb_emp group by gender;

select if ( gender = 1, '男性员工', '女性员工') as 性别, count(*) from tb_emp group by gender;

select
    ( case job when 1 then '班主任' when 2 then
        '讲师' when 3 then '学工主管' when 4 then '教研主管'
               else '未分配职位' end) 职位, count(*) from tb_emp group by job;

drop table if exists tb_dept;

create table tb_emp (
                        id int unsigned primary key auto_increment comment 'ID',
                        username varchar(20) not null unique comment '用户名',
                        password varchar(32) default '123456' comment '密码',
                        name varchar(10) not null comment '姓名',
                        gender tinyint unsigned not null comment '性别：1.男，2.女',
                        image varchar(300) comment '图像',
                        job tinyint unsigned comment '职位，说明：1.班主任，2.讲师，3.学工主管，4.教研主管',
                        entrydate date comment '入职时间',
                        dept_id int unsigned comment '归属部门ID',
                        create_time datetime not null comment '创建时间',
                        update_time datetime not null comment '修改时间'
) comment '员工表';

-- 部门
create table tb_dept (
                         id int unsigned primary key auto_increment comment 'ID',
                         name varchar(10) not null unique comment '部门名称',
                         create_time datetime not null comment '创建时间',
                         update_time datetime not null comment '修改时间'
);

insert into tb_dept (id, name, create_time, update_time) values
                                                             (1,'学工部',now(),now()),(2,'教研部',now(),now()),(3,'咨询部',now(),now()),
                                                             (4,'就业部',now(),now()),(5,'人事部',now(),now());

INSERT INTO tb_emp
(id, username, password, name, gender, image, job, entrydate,dept_id, create_time, update_time) VALUES
(1,'jinyong','123456','金庸',1,'1.jpg',4,'2000-01-01',2,now(),now()),
(2,'zhangwuji','123456','张无忌',1,'2.jpg',2,'2015-01-01',2,now(),now()),
(3,'yangxiao','123456','杨逍',1,'3.jpg',2,'2008-05-01',2,now(),now()),
(4,'weiyixiao','123456','韦一笑',1,'4.jpg',2,'2007-01-01',2,now(),now()),
(5,'changyuchun','123456','常遇春',1,'5.jpg',2,'2012-12-05',2,now(),now()),
(6,'xiaozhao','123456','小昭',2,'6.jpg',3,'2013-09-05',1,now(),now()),
(7,'jixiaofu','123456','纪晓芙',2,'7.jpg',1,'2005-08-01',1,now(),now()),
(8,'zhouzhiruo','123456','周芷若',2,'8.jpg',1,'2014-11-09',1,now(),now()),
(9,'dingminjun','123456','丁敏君',2,'9.jpg',1,'2011-03-11',1,now(),now()),
(10,'zhaomin','123456','赵敏',2,'10.jpg',1,'2013-09-05',1,now(),now()),
(11,'luzhangke','123456','鹿杖客',1,'11.jpg',1,'2007-02-01',1,now(),now()),
(12,'hebiweng','123456','鹤笔翁',1,'12.jpg',1,'2008-08-18',1,now(),now()),
(13,'fangdongbai','123456','方东白',1,'13.jpg',2,'2012-11-01',2,now(),now()),
(14,'zhangsanfeng','123456','张三丰',1,'14.jpg',2,'2002-08-01',2,now(),now()),
(15,'yulianzhou','123456','俞莲舟',1,'15.jpg',2,'2011-05-01',2,now(),now()),
(16,'songyuanqiao','123456','宋远桥',1,'16.jpg',2,'2010-01-01',2,now(),now()),
(17,'chenyouliang','123456','陈友谅',1,'17.jpg',NULL,'2015-03-21',NULL,now(),now());

# 多对多
# 表1
create table tb_student(
                           id int auto_increment primary key comment '主键ID',
                           name varchar(10) comment '姓名',
                           no varchar(10) comment '学号'
) comment '学生表';
insert into tb_student(name, no) values
                                     ('黛绮丝', '2000100101'),('谢逊', '2000100102'),('殷天正', '2000100103'),('韦一笑', '2000100104');
# 表2
create table tb_course(
                          id int auto_increment primary key comment '主键ID',
                          name varchar(10) comment '课程名称'
) comment '课程表';
insert into tb_course ( name ) values ('Java'), ('PHP'), ('MySQL') , ('Hadoop');
# 表3
create table tb_student_course(
                                  id int auto_increment primary key comment '主键' primary key,
                                  student_id int not null comment '学生ID',
                                  course_id int not null comment '课程ID',
                                  constraint fk_courseid foreign key (course_id) references tb_course(id),
                                  constraint fk_studentid foreign key (student_id) references tb_student (id)
);

# 一对一
# 用户基本信息
create table tb_user(
                        id int unsigned  primary key auto_increment comment 'ID',
                        name varchar(10) not null comment '姓名',
                        gender tinyint unsigned not null comment '性别, 1 男  2 女',
                        phone char(11) comment '手机号',
                        degree varchar(10) comment '学历'
) comment '用户信息表';

insert into tb_user values (1,'白眉鹰王',1,'18812340001','初中'),
                           (2,'青翼蝠王',1,'18812340002','大专'),
                           (3,'金毛狮王',1,'18812340003','初中'),
                           (4,'紫衫龙王',2,'18812340004','硕士');

# 用户身份信息
create table tb_user_card (
                              id int unsigned primary key auto_increment comment 'ID',
                              nationality varchar(10) not null comment '民族',
                              birthday date not null comment '生日',
                              idcard char(18) not null comment '身份证号',
                              issued varchar(20) not null comment '签发机关',
                              expire_begin date not null comment '有效期限-开始',
                              expire_end date comment '有效期限-结束',
                              user_id int unsigned not null unique comment '用户ID',
                              constraint fk_user_id foreign key (user_id) references tb_user(id)
) comment '用户信息表';
insert into tb_user_card values
                             (1,'汉','1960-11-06','100000100000100001','朝阳区公安局','2000-06-10',null,1),
                             (2,'汉','1971-11-06','100000100000100002','静安区公安局','2005-06-10','2025-06-10',2),
                             (3,'汉','1963-11-06','100000100000100003','昌平区公安局','2006-06-10',null,3),
                             (4,'回','1980-11-06','100000100000100004','海淀区公安局','2008-06-10','2028-06-10',4);

/* 多对多 案例 */
# 分类表
create table category(
                         id int unsigned primary key auto_increment comment '主键ID',
                         name varchar(20) not null unique comment '分类名称',
                         type tinyint unsigned not null comment '类型 1.菜品分类 2.套餐分类',
                         sort tinyint unsigned not null comment '顺序',
                         status tinyint unsigned not null comment '创建时间',
                         update_time datetime not null comment '更新时间',
                         create_time datetime not null comment '创建时间'
) comment '菜品及套餐分类';

# 菜品表
create table dish(
                     id int unsigned primary key auto_increment comment '主键ID',
                     name varchar(20) not null unique comment '菜品名称',
                     category_id int unsigned not null comment '菜品分类ID',
                     price decimal(8,2) not null comment '菜品价格', # 长度限制在 1-8，且小数点后有2位小数
                         image varchar(300) not null comment '菜品图片',
                     description varchar(200) comment '描述信息',
                     status tinyint unsigned not null default 0 comment '状态, 0 停售 1 起售',
                     create_time datetime not null comment '创建时间',
                     update_time datetime not null comment '更新时间'
) comment '菜品';

# 套餐表
create table setmeal(
                        id int unsigned primary key auto_increment comment '主键ID',
                        name varchar(20) not null unique comment '套餐名称',
                        category_id int unsigned not null comment '分类id',
                        price decimal(8, 2) not null comment '套餐价格',
                        image varchar(300) not null comment '图片',
                        description varchar(200) comment '描述信息',
                        status tinyint unsigned not null default 0 comment '状态 0:停用 1:启用',
                        create_time datetime not null comment '创建时间',
                        update_time datetime not null comment '更新时间'
) comment '套餐';

# 套餐菜品关系表
create table setmeal_dish(
                             id int unsigned primary key auto_increment comment '主键ID',
                             setmeal_id int unsigned not null comment '套餐id',
                             dish_id int unsigned not null comment '菜品id',
                             copies tinyint unsigned not null comment '份数'
) comment '套餐菜品关系';


/* 多表查询 */
use db03;
# 一.数据准备
-- 1.部门管理
create table tb_dept(
                        id int unsigned primary key auto_increment comment '主键ID',
                        name varchar(10) not null unique comment '部门名称',
                        create_time datetime not null comment '创建时间',
                        update_time datetime not null comment '修改时间'
) comment '部门表';
insert into tb_dept (id, name, create_time, update_time) values
                                                             (1,'学工部',now(),now()),(2,'教研部',now(),now()),
                                                             (3,'咨询部',now(),now()), (4,'就业部',now(),now()),
                                                             (5,'人事部',now(),now());

-- 2.员工管理
drop table if exists tb_emp;
create table tb_emp (
                        id int unsigned primary key auto_increment comment 'ID',
                        username varchar(20) not null unique comment '用户名',
                        password varchar(32) default '123456' comment '密码',
                        name varchar(10) not null comment '姓名',
                        gender tinyint unsigned not null comment '性别, 说明: 1 男, 2 女',
                        image varchar(300) comment '图像',
                        job tinyint unsigned comment '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师',
                        entrydate date comment '入职时间',
                        dept_id int unsigned comment '部门ID',
                        create_time datetime not null comment '创建时间',
                        update_time datetime not null comment '修改时间'
) comment '员工表';

# 3.
INSERT INTO tb_emp
(id, username, password, name, gender, image, job, entrydate,dept_id, create_time, update_time) VALUES
(1,'jinyong','123456','金庸',1,'1.jpg',4,'2000-01-01',2,now(),now()),
(2,'zhangwuji','123456','张无忌',1,'2.jpg',2,'2015-01-01',2,now(),now()),
(3,'yangxiao','123456','杨逍',1,'3.jpg',2,'2008-05-01',2,now(),now()),
(4,'weiyixiao','123456','韦一笑',1,'4.jpg',2,'2007-01-01',2,now(),now()),
(5,'changyuchun','123456','常遇春',1,'5.jpg',2,'2012-12-05',2,now(),now()),
(6,'xiaozhao','123456','小昭',2,'6.jpg',3,'2013-09-05',1,now(),now()),
(7,'jixiaofu','123456','纪晓芙',2,'7.jpg',1,'2005-08-01',1,now(),now()),
(8,'zhouzhiruo','123456','周芷若',2,'8.jpg',1,'2014-11-09',1,now(),now()),
(9,'dingminjun','123456','丁敏君',2,'9.jpg',1,'2011-03-11',1,now(),now()),
(10,'zhaomin','123456','赵敏',2,'10.jpg',1,'2013-09-05',1,now(),now()),
(11,'luzhangke','123456','鹿杖客',1,'11.jpg',5,'2007-02-01',3,now(),now()),
(12,'hebiweng','123456','鹤笔翁',1,'12.jpg',5,'2008-08-18',3,now(),now()),
(13,'fangdongbai','123456','方东白',1,'13.jpg',5,'2012-11-01',3,now(),now()),
(14,'zhangsanfeng','123456','张三丰',1,'14.jpg',2,'2002-08-01',2,now(),now()),
(15,'yulianzhou','123456','俞莲舟',1,'15.jpg',2,'2011-05-01',2,now(),now()),
(16,'songyuanqiao','123456','宋远桥',1,'16.jpg',2,'2007-01-01',2,now(),now()),
(17,'chenyouliang','123456','陈友谅',1,'17.jpg',NULL,'2015-03-21',NULL,now(),now());

# 二.多表查询
select * from tb_emp, tb_dept where tb_emp.id = tb_dept.id;
# 1.内连接
# 1.1. 隐式内连接： select 字段列表 from 表1， 表2 条件 ...;
# 例：查询员工姓名及所属部门名称(隐式内连接)
select tb_emp.name, tb_dept.name from tb_emp, tb_dept where tb_emp.dept_id = tb_dept.id;
-- 起别名
select e.name, d.name from tb_emp e, tb_dept d where e.dept_id = d.id;

# 1.2. 显式内连接： select 字段列表 from 表1 [inner] join 表2 on 连接条件...;
select tb_emp.name, tb_dept.name from tb_emp inner join tb_dept on tb_emp.dept_id = tb_dept.id;

# 2.外连接
# 2.1 左外连接：select 字段列表 from 表1 left [outer] join 表2 on 连接条件;
-- 查询员工表所有员工姓名，和对应的部门名称(左外连接)
select tb_emp.name, tb_dept.name from tb_emp left join tb_dept on tb_emp.id = tb_dept.id;

# 2.2 右外连接：select 字段列表 from 表1 right [outer] join 表2 on 连接条件;
-- 查询部门表所有部门名称，和对应的员工名称(右外连接)
select tb_emp.name, tb_dept.name from tb_emp right join tb_dept on tb_emp.id = tb_dept.id;

# 3. 子查询
# 概况：sql 语句中嵌套 select 语句，嵌套查询
                            # 形式：select * from t1 where column1 = (select column1 from t2 ...);
# 附：子查询外部的语句可以是 insert/update/delete/select 中任一个
    # 3.1 分类：
/*
 1.标量子查询：子查询返回结果为单个值;
 2.列子查询：子查询返回的结果为 1 列;
 3.行子查询：子查询结果为 1 行；
 4.表子查询：总查询返回结果为 多行多列；
*/
# 3.1 标量子查询：查询’教研部‘的所有员工信息
select id from tb_dept where name = '教研部';
select * from tb_emp where tb_emp.dept_id = 2;

select * from tb_emp where tb_emp.dept_id = (select id from tb_emp where name = '教研部');

# 3.1 标量子查询： 查询在 ’东方白‘ 入职后的员工信息
select entrydate from tb_emp where name = '东方白';
select * from tb_emp where entrydate > (select entrydate from tb_emp where name = '东方白');

# 3.2 列子查询
-- 3.2.1 查询’教研部‘ 和 ‘咨询部’ 的所有员工信息
select id from tb_dept where name = '教研部' or name = '咨询部';
select * from tb_emp where dept_id in (select id from tb_dept where name = '教研部' or name = '咨询部');

# 3.3 行子查询
-- 3.3.1 查询与‘韦一笑’的入职日期及职位都相同的员工信息;
select entrydate, job from tb_emp where name = '韦一笑'; ## 结果为 ’2007-01-01‘， 2
select * from tb_emp where entrydate = (select entrydate from tb_emp where name = '韦一笑') and
    job = (select job from tb_emp where name = '韦一笑');
-- 根据 ’2007-01-01‘， 2 可优化为如下
select * from tb_emp where (entrydate, job) = (select entrydate, job from tb_emp where name = '韦一笑')

    # 3.4 表子查询
-- 3.4.1 查询入职日期是 '2006-01-01' 后的员工信息及其部门名称
select * from tb_emp where entrydate > '2006-01-01';

select e.*, d.name from (select * from tb_emp where entrydate > '2006-01-01') e, tb_dept d
where e.dept_id =  d.id;


/* 案例 */
-- 分类表
create table category(
                         id int unsigned primary key auto_increment comment '主键ID',
                         name varchar(20) not null unique comment '分类名称',
                         type tinyint unsigned not null comment '类型 1 菜品分类 2 套餐分类',
                         sort tinyint unsigned not null comment '顺序',
                         status tinyint unsigned not null default 0 comment '状态 0 禁用，1 启用',
                         create_time datetime not null comment '创建时间',
                         update_time datetime not null comment '更新时间'
) comment '分类' ;

-- 菜品表
create table dish(
                     id int unsigned primary key auto_increment comment '主键ID',
                     name varchar(20) not null unique comment '菜品名称',
                     category_id int unsigned not null comment '菜品分类ID',
                     price decimal(8, 2) not null comment '菜品价格',
                     image varchar(300) not null comment '菜品图片',
                     description varchar(200) comment '描述信息',
                     status tinyint unsigned not null default 0 comment '状态, 0 停售 1 起售',
                     create_time datetime not null comment '创建时间',
                     update_time datetime not null comment '更新时间'
) comment '菜品';

-- 套餐表
create table setmeal(
                        id int unsigned primary key auto_increment comment '主键ID',
                        name varchar(20) not null unique comment '套餐名称',
                        category_id int unsigned not null comment '分类id',
                        price decimal(8, 2) not null comment '套餐价格',
                        image varchar(300) not null comment '图片',
                        description varchar(200) comment '描述信息',
                        status tinyint unsigned not null default 0 comment '状态 0:停用 1:启用',
                        create_time datetime not null comment '创建时间',
                        update_time datetime not null comment '更新时间'
)comment '套餐' ;

-- 套餐菜品关联表
create table setmeal_dish(
                             id int unsigned primary key auto_increment comment '主键ID',
                             setmeal_id int unsigned not null comment '套餐id ',
                             dish_id int unsigned not null comment '菜品id',
                             copies tinyint unsigned not null comment '份数'
)comment '套餐菜品中间表';

-- 案例1： 查询价格低于 10 块的菜品名称，价格及其菜品的分类名称;
-- 表：dish, category
select d.name, d.price, c.name from dish d, category c where d.category_id = c.id and d.price < 10;

-- 案例2：查询所有价格在 10元(含)到50元(含)之间 且 状态为'起售'的菜品名称、价格 及其 菜品的分类名称 (即使菜品没有分类 , 也需要将菜品查询出来).
-- 表：dish, category
select * from dish left join category on dish.id = category.id; # (即使菜品没有分类 , 也需要将菜品查询出来),所以 left join
select * from dish left join category on dish.id = category.id where dish.price between 10 and 50 and dish.status = 1;

-- 案例3：查询每个分类下最贵的菜品, 展示出分类的名称、最贵的菜品的价格 .
select max(price) from dish;
-- 每个分类下的所有的菜
select category.name, max(dish.price) from dish, category where dish.category_id = category.id group by category.name;

-- 案例4：查询各个分类下 状态为 '起售' , 并且 该分类下菜品总数量大于等于3 的 分类名称 .
-- 表：dish, category
select count(*), category.name from dish, category where dish.category_id = category.id group by category.name;
select * from category where category.status = '1' group by category.name;
-- 聚合函数用 having
select count(*), category.name from dish, category where dish.category_id = category.id
                                                     and category.status = '1'
group by category.name having count(*) >= 3;

-- 案例5：查询出 "商务套餐A" 中包含了哪些菜品 （展示出套餐名称、价格, 包含的菜品名称、价格、份数）.
-- 表：setmeal, dish, setmeal_dish
select setmeal.name, setmeal.price, dish.name, dish.price, setmeal_dish.copies
from setmeal, setmeal_dish, dish
where setmeal.id = setmeal_dish.setmeal_id
  and setmeal_dish.dish_id = dish.id and setmeal.name = '商务套餐A';


-- 案例6：查询出低于菜品平均价格的菜品信息 (展示出菜品名称、菜品价格).
-- 表：dish
select avg(dish.price) from dish;
select dish.name, dish.price from dish where dish.price < (select avg(dish.price) from dish)

/* 事务 */
-- 开启事务 start transaction;
-- 然后再   增删操作；
-- 提交事务 commit;
-- 回滚事务 rollback; 只要 增删过程中有一个操作错误，就需要 回滚

/* 索引 */
-- 1. 创建索引 create [unique] index 索引名 on 表名 (字段名, ...);
-- 2. 查看索引 show index from 表名;
-- 3. 删除索引 drop index 索引名 on 表名;

-- 主键字段，在建表时，会自动创建主键索引.
-- 添加唯一约束时，数据库实际上会添加唯一索引.
-- MySQL数据库中默认的索引结构是 B+tree.
