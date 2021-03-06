--商品goods(商品编号goods_id，商品名goods_name, 单价unitprice, 商品类别category, 供应商provider)
create table goods(
    goods_id int comment '商品编号',
    goods_name varchar(32) comment '商品名',
    unitprice int comment '商品价格',
    categorg varchar(16) comment '商品类别',
    provider varchar(64) comment '供应商'
);
--客户customer(客户号customer_id,姓名name,住址address,邮箱email,性别sex，身份证card_id)
create table customer(
    customer_id int comment '客户编号',
    name varchar (32) comment '客户姓名',
    address varchar (128) comment '客户地址',
    email varchar (128) comment '电子邮件',
    sex bit comment '性别',
    card_id varchar (18) comment '身份证号'
);
--购买purchase(购买订单号order_id,客户号customer_id,商品号goods_id,购买数量nums)
create table  if not exists purchase(
    order_id int comment '订单号',
    customer_id int comment '客户号',
    goods_id int comment '商品号',
    nums int comment '购买数量'
);
--设计一张图书表，包含以下字段：图书名称，图书作者、图书价格、图书分类
create table if not exists books (
    book_name varchar (32) comment '图书名称',
    author varchar (32) comment '图书作者',
    price decimal (4,2) comment '图书价格',
    categorg varchar (16) comment '图书分类'
);
--设计一张老师表，包含以下字段：姓名、年龄、身高、体重、性别、学历、生日、身份证号
create table if not exists teacher (
    name varchar (16) comment '姓名',
    age int comment '年龄',
    height int comment '身高',
    hearvy int comment '体重',
    sex  bit comment '性别',
    degree varchar (16) comment '学历',
    birthday timestamp comment '生日',
    birth_number varchar (18) comment '身份证号'
);
--设计一张商品表，包含以下字段：商品名称、商品价格、商品库存、商品描述
create table if not exists goods_one(
    name varchar(16) comment '商品名',
    price decimal(4,2) comment '商品价格',
    inventory int comment '商品库存',
    des varchar (32) comment '商品描述'
);
insert into goods_one values ("学生书包",18.91,101,"无");

create  table if not exists student(
    id int,
    name varchar (20),
    qq varchar (11)
);

create table exam_result(
    id int,
    name varchar(20),
    chinese decimal (3,1),
    math decimal (3,1),
    english decimal (3,1)
);

insert into exam_result(id,name,chinese,math,english) values
    (1,"唐三藏",67,98,56),
    (2,"孙悟空",87.5,78,77),
    (3,"猪悟能",88,98,90),
    (4,"曹孟德",82,84,67),
    (5,"刘玄德",55.5,85,45),
    (6,"孙权",70,73,78.5),
    (7,"宋公明",75,65,30);

--查询article文章表中，发表日期create_date在2019年1月1日上午10点30分至2019年11月10日下午4点2分的文章
select article_name from article where create_date between "2019-01-01 10:30:00" and "2019-11-10 16:02:00";

create table article (
    article_name varchar (64),
    create_date datetime
);
insert into article values("混元太极门马保国",now());
insert into article values("嫦娥四号传回月球背影像图","2019-01-03 10:26:00");
insert into article (create_date) values (now());

select article_name from article where create_date between "2019-01-01 10:30:00" and "2019-11-10 16:02:00";














