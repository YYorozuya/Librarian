CREATE DATABASE library;

use library;

CREATE TABLE IF NOT EXISTS `book`
(
    `id` VARCHAR(17) NOT NULL, /* 13位ISBN + 4位序列号 */
    `name` VARCHAR(50) NOT NULL,
    `author` VARCHAR(50) NOT NULL,
    `category` VARCHAR(30) NOT NULL,
    `price` DECIMAL(7,2) NOT NULL,
    `location` VARCHAR(10) NOT NULL,
    PRIMARY KEY ( `id` )
) DEFAULT CHARSET=UTF8MB4;


CREATE TABLE IF NOT EXISTS `librarian`
(
    `account` VARCHAR(255) NOT NULL,
    `pwd` VARCHAR(255) NOT NULL,
    `gender` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    PRIMARY KEY ( `account` )
) DEFAULT CHARSET=UTF8MB4;

INSERT INTO librarian (account, pwd, gender, name, email) VALUES ('00010001','123','male','hhh','asd@gmail.com');

CREATE TABLE IF NOT EXISTS `reader`
(
    `id` VARCHAR(11) NOT NULL,
    `passwd` VARCHAR(16) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(30) NOT NULL,
    `ctime` BIGINT NOT NULL, /* 创建时间 */
    `deposit` DECIMAL(5,2) NOT NULL, /* 保证金 */
    PRIMARY KEY ( `id` )
) DEFAULT CHARSET=UTF8MB4;


CREATE TABLE IF NOT EXISTS `lending`
(
    `id` INT AUTO_INCREMENT, /* 记录id */
    `bkid` VARCHAR(17) NOT NULL, /* 书籍id */
    `rid` VARCHAR(11) NOT NULL, /* 读者id */
    `btime` BIGINT NOT NULL, /* 借书时间 */
    `rtime` BIGINT NOT NULL, /* 还书时间（未还为0）*/
    PRIMARY KEY ( `id` )
) DEFAULT CHARSET=UTF8MB4;


CREATE TABLE IF NOT EXISTS `fine`
(
    `id` INT NOT NULL, /* 记录id（与br_record中的id对应）*/
    `amount` DECIMAL(5,2) NOT NULL, /* 罚款金额 */
    `time` BIGINT NOT NULL, /* 缴纳时间（未缴纳为0） */
    PRIMARY KEY ( `id` )
) DEFAULT CHARSET=UTF8MB4;


CREATE TABLE IF NOT EXISTS `news`
(
    `id` INT AUTO_INCREMENT, /* 记录id */
    `title` VARCHAR(30) NOT NULL, /* 公告标题 */
    `content` VARCHAR(500) NOT NULL, /* 公告正文 */
    `time` BIGINT NOT NULL, /* 发布时间 */
    PRIMARY KEY ( `id` )
) DEFAULT CHARSET=UTF8MB4;


CREATE TABLE IF NOT EXISTS `del_record`
(
    `id` INT AUTO_INCREMENT, /* 记录id*/
    `bkid` VARCHAR(17) NOT NULL, /* 书籍id */
    `libid` VARCHAR(20) NOT NULL, /* 图书馆员id */
    `reason` VARCHAR(10) NOT NULL, /* 删除原因 */
    `time` BIGINT NOT NULL, /* 删除时间 */
    PRIMARY KEY ( `id` )
) DEFAULT CHARSET=UTF8MB4;


CREATE TABLE IF NOT EXISTS `reserve`
(
    `bkid` VARCHAR(17) NOT NULL, /* 书籍id */
    `rid` VARCHAR(11) NOT NULL /* 读者id */
) DEFAULT CHARSET=UTF8MB4;


CREATE TABLE IF NOT EXISTS `category`
(
    `name` VARCHAR(30) NOT NULL, /*分类名*/
    PRIMARY KEY ( `name` )
) DEFAULT CHARSET=UTF8MB4;

INSERT INTO category (name) VALUES ('Novel'),('Biography'),('Philosophy'),('History');


CREATE TABLE IF NOT EXISTS `location`
(
    `name` VARCHAR(5) NOT NULL, /*位置名*/
    PRIMARY KEY ( `name` )
) DEFAULT CHARSET=UTF8MB4;

INSERT INTO location (name) VALUES ('1-1-1');


CREATE TABLE IF NOT EXISTS `system`
(
    `fvalue` INT NOT NULL, /*罚款金额*/
    `period` INT NOT NULL, /*还书逾期期限*/
    `deposit` INT NOT NULL /*保证金金额*/
) DEFAULT CHARSET=UTF8MB4;

INSERT INTO `system` (fvalue, period, deposit) VALUE (10,90,300);