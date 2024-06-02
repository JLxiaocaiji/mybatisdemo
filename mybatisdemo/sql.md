##### 1.基本命令
1. show databases; 查询所有数据库;
2. select databases(); 查询当前数据库;
3. use db01; 使用数据库;
4. create database [ if not exists ] 数据库名;
5. drop database [ if exists ] 数据库名;

##### 2.约束
1. not null: 非空，不能为 null
2. unique: 唯一,不可重复
3. primary key: 主键，非空，唯一
4. default: 未指定字段，采用默认值
5. foreign key: 外键约束

char(): char(x): 最多只能存 x 个字符，不足 x 个字符，占用 10 个字符空间;
varchar(): varchar(x): 最多存储 10 个字符，不足 10 个，按照实际长度存储; 
date: 大小 3 byte, 1000-01-01 至 9999-12-31；
datetime: 大小 8 byte, 1000-01-01 00:00:00 至 9999-12-31 23:59:59
timestamp: 大小 4 byte, 1970-01-01 00:00:01 至 2038-01-19 03：14：07

##### 3. 修改表结构
1.添加字段： alter table 表名 add 字段名 类型(长度) [comment 注释] [约束];
2.修改字段类型： alter table 表名 modify 字段名 新数据类型(长度);
3.修改字段名和字段类型： alter table 表名 change 旧字段名 新字段名 类型(长度) [comment 注释] [约束];
4.删除字段： alter table 表名 drop column 字段名;
5.修改表名： rename table 表名 to 新表名;

##### 4. insert
1.指定字段添加数据： insert into 表名(字段1，字段2) value2(值1，值2);
2.全部字段添加数据： insert into 表名 values (值1，值2, ...);
3.批量添加数据(指定字段)： insert into 表名(字段名1，字段名2) values(值1，值2)，(值1，值2);
4.批量添加数据(全部字段): insert into 表名 values (值1，值2)，(值1，值2)；

##### 5.update
修改数据：update 表名 set 字段名1 = 值1， 字段名2 = 值2, ... [where 条件]
1.更新数据
update tb_emp set name = '张三', update_time = now() where id = 1;
2.将 tb_emp 中的所有员工的入职日期更新为 ‘2010-01-01’
update tb_emp set entrydate = '2010-01-01', update_time = now();

##### 删除
delete from 表名 [where 条件]; 若没有条件语句会全部删除

##### 6.查询
* select 字段列表 from 表名列表 where 条件列表 group by 分组字段列表 having 分组后条件列表 order by 排序字段列表 limit 分页参数1, 分页参数2

1.查询多个字段：select  字段1, 字段2, 字段3  from   表名;
2.查询所有字段（通配符）：select  *  from   表名;
3.设置别名：select  字段1  [ as  别名1 ] , 字段2  [ as  别名2 ]   from   表名;
4.去除重复记录：select  distinct  字段列表  from   表名;

* 聚合查询：将一列数据作为整体，纵向计算： select 聚合函数(字段列表) from 表名;
需要查询分组字段 和 聚合函数 count(*)
```where 中不能使用 count 函数, 但可使用 count```
* 执行顺序 where > 聚合函数 > having;

where与having区别
1.执行时机不同：where是分组之前进行过滤，不满足where条件，不参与分组；而having是分组之后对结果进行过滤。
2.判断条件不同：where不能对聚合函数进行判断，而having可以。


分页查询：select  字段列表  from  表名  limit  起始索引, 查询记录数

##### sql 条件判断
1. 单条件判断 https://blog.csdn.net/Senye_ing/article/details/131833161
if( condition, value_if_true, value_if_false): (条件参数，条件为真返回的值, 条件为假返回的值)

select if ( gender = 1, '男性员工', '女性员工') as 性别, count(*) from tb_emp group by gender;

2. 多条件判断
select
( case job when 1 then '班主任' when 2 then
'讲师' when 3 then '学工主管' when 4 then '教研主管'
else '未分配职位' end) 职位, count(*) from tb_emp group by job;

##### 数据库 1 对 多的实现
‘一’对’多‘关系实现：在数据库表中多的一方，添加字段，来关联 ‘一’ 的一方的主键;

##### 数据库多表问题
例：部门数据可以直接删除，但还有部分员工属于该部门下，产生数据不完整，不一致的问题；
原因：2张表在数据库层面未建立联系，无法保证数据的一致性和完整行；
解决办法：创建外键
1. 新建表时添加外键
create table 表名(
    字段名 数据类型 comment,
    ...,
    [constraint] [外键名称] foreign key (外键字段名称) references 主表 (字段名)
);
示例：
```
create table tb_user_card(
    user_id int unsigned not null unique comment '用户ID',
    constraint fk_user_id foreign key (user_id) references tb_user(id)
) comment '用户信息表';
```


2. 建表完后添加外键
alter table 表名 add constraint 外键名称 foreign key (外键字段名) references 主表(字段名);
示例：
```
alter table tb_dept
   add constraint tb_emp_fk_dept_id
   foreign key (dept_id) references tb_dept (id);
```


##### 一对一
关系：1对1关系，产用于单表拆分，将一张表的基础字段放在一张表中，其他字段放在另一张表中，以提升效率;
实现：在任意一方加入外键，关联另外一方的主键，且设置外键为唯一 unique,

##### 多对多
关系：1个学生可以选修多门，一门课程也可供多个学生选择
实现：建立第三张中间表，中间表至少包含2个外键，分别关联2方主键

mybatis在 xml 中的动态sql: https://mybatis.net.cn/dynamic-sql.html
