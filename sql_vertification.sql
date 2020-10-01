/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : localhost:3306
 Source Schema         : sql_vertification

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : 65001

 Date: 01/10/2020 22:50:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `Cno` int(11) NOT NULL AUTO_INCREMENT,
  `Cname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `Cpno` int(30) NULL DEFAULT NULL,
  `Ccredit` int(30) NULL DEFAULT NULL,
  PRIMARY KEY (`Cno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '数据库', 5, 4);
INSERT INTO `course` VALUES (2, '数学', NULL, 2);
INSERT INTO `course` VALUES (3, '信息系统', 1, 4);
INSERT INTO `course` VALUES (4, '操作系统', 6, 3);
INSERT INTO `course` VALUES (5, '数据结构', 7, 4);
INSERT INTO `course` VALUES (6, '数据处理', NULL, 2);
INSERT INTO `course` VALUES (7, 'PASCAL语言', 6, 4);

-- ----------------------------
-- Table structure for j
-- ----------------------------
DROP TABLE IF EXISTS `j`;
CREATE TABLE `j`  (
  `JNO` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `JANAME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `CITY` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`JNO`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of j
-- ----------------------------
INSERT INTO `j` VALUES ('J1', '三建', '北京');
INSERT INTO `j` VALUES ('J2', '一汽', '长春');
INSERT INTO `j` VALUES ('J3', '弹簧厂', '天津');
INSERT INTO `j` VALUES ('J4', '造船厂', '天津');
INSERT INTO `j` VALUES ('J5', '机车厂', '唐山');
INSERT INTO `j` VALUES ('J6', '无线电厂', '常州');
INSERT INTO `j` VALUES ('J7', '半导体厂', '南京');

-- ----------------------------
-- Table structure for p
-- ----------------------------
DROP TABLE IF EXISTS `p`;
CREATE TABLE `p`  (
  `PNO` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `PNAME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `COLOR` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `WEIGHT` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`PNO`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of p
-- ----------------------------
INSERT INTO `p` VALUES ('P1', '螺母', '红', 12);
INSERT INTO `p` VALUES ('P2', '螺栓', '绿', 17);
INSERT INTO `p` VALUES ('P3', '螺丝刀', '蓝', 14);
INSERT INTO `p` VALUES ('P4', '螺丝刀', '红', 14);
INSERT INTO `p` VALUES ('P5', '凸轮', '蓝', 40);
INSERT INTO `p` VALUES ('P6', '齿轮', '红', 30);

-- ----------------------------
-- Table structure for question_answer
-- ----------------------------
DROP TABLE IF EXISTS `question_answer`;
CREATE TABLE `question_answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `problems` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '问题描述',
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '答案SQL',
  `relative_table` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '相关表',
  `notes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_answer
-- ----------------------------
INSERT INTO `question_answer` VALUES (1, '查询所有学生名称', 'select * from student', 'student', '课本练习');
INSERT INTO `question_answer` VALUES (2, '查询不选1号课程的学生名字', NULL, NULL, '例2.25');
INSERT INTO `question_answer` VALUES (3, '查询选修了全部课程的学生姓名', NULL, NULL, '例2.26');
INSERT INTO `question_answer` VALUES (4, '查询学生的姓名和所在系', NULL, NULL, '例2.6');
INSERT INTO `question_answer` VALUES (5, '查询学生关系都有哪些系', NULL, NULL, '例2.7');
INSERT INTO `question_answer` VALUES (6, '查询至少选修1号课程和3号课程的学生号码', NULL, NULL, '例2.10');
INSERT INTO `question_answer` VALUES (7, '查询选修了2号课程的学生的学号', NULL, NULL, '例2.11');
INSERT INTO `question_answer` VALUES (8, '查询至少选修了一门其直接先行课为5号课程的学生姓名', NULL, NULL, '例2.12');
INSERT INTO `question_answer` VALUES (9, '查询选修了全部课程的学生号码和姓名', NULL, NULL, '例2.13');
INSERT INTO `question_answer` VALUES (10, '查询所有被选修的课程号码', NULL, NULL, '例2.14');
INSERT INTO `question_answer` VALUES (11, '查询所有学生数据', NULL, NULL, '例2.15');
INSERT INTO `question_answer` VALUES (12, '查询信息系(IS)中年龄小于20岁的学生的学号和年龄', NULL, NULL, '例2.16');
INSERT INTO `question_answer` VALUES (13, '查询计算机科学系(CS)学生的学号、年龄，结果按照年龄降序排序', NULL, NULL, '例2.17');
INSERT INTO `question_answer` VALUES (14, '取出一个信息系学生的学号', NULL, NULL, '例2.18');
INSERT INTO `question_answer` VALUES (15, '查询信息系年龄最大的三个学生的学号及其年龄，按年龄降序排列', NULL, NULL, '例2.19');
INSERT INTO `question_answer` VALUES (16, '查询信息系学生的名字', NULL, NULL, '例2.20');
INSERT INTO `question_answer` VALUES (17, '查询选修了2号课程的学生名字', NULL, NULL, '例2.21');
INSERT INTO `question_answer` VALUES (18, '查询选修了直接先行课是6号课程的课程的学生学号', NULL, NULL, '例2.22');
INSERT INTO `question_answer` VALUES (19, '查询至少选修一门其先行课为6号课程的学生名字', NULL, NULL, '例2.23');
INSERT INTO `question_answer` VALUES (20, '查询成绩为90分以上的学生名字和课程名字', NULL, NULL, '例2.24');
INSERT INTO `question_answer` VALUES (21, '查询最少选修了201215122学生所选课程的学生学号', NULL, NULL, '例2.27');
INSERT INTO `question_answer` VALUES (22, '查询学生所在系的数目', NULL, NULL, '例2.28');
INSERT INTO `question_answer` VALUES (23, '查询信息系学生的平均年龄', NULL, NULL, '例2.29');

-- ----------------------------
-- Table structure for s
-- ----------------------------
DROP TABLE IF EXISTS `s`;
CREATE TABLE `s`  (
  `SNO` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `SNAME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `STATUS` int(11) NULL DEFAULT NULL,
  `CITY` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`SNO`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s
-- ----------------------------
INSERT INTO `s` VALUES ('S1', '精益', 20, '天津');
INSERT INTO `s` VALUES ('S2', '盛锡', 10, '北京');
INSERT INTO `s` VALUES ('S3', '东方红', 30, '北京');
INSERT INTO `s` VALUES ('S4', '丰泰胜', 20, '天津');
INSERT INTO `s` VALUES ('S5', '为民', 30, '上海');

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc`  (
  `Sno` int(11) NULL DEFAULT NULL,
  `Cno` int(11) NULL DEFAULT NULL,
  `Grade` int(30) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES (201215121, 1, 92);
INSERT INTO `sc` VALUES (201215121, 2, 85);
INSERT INTO `sc` VALUES (201215121, 3, 88);
INSERT INTO `sc` VALUES (201215122, 2, 90);
INSERT INTO `sc` VALUES (201215122, 3, 80);

-- ----------------------------
-- Table structure for spj
-- ----------------------------
DROP TABLE IF EXISTS `spj`;
CREATE TABLE `spj`  (
  `SNO` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `PNO` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `JNO` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `QTY` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of spj
-- ----------------------------
INSERT INTO `spj` VALUES ('S1', 'P1', 'J1', 200);
INSERT INTO `spj` VALUES ('S1', 'P1', 'J3', 100);
INSERT INTO `spj` VALUES ('S1', 'P1', 'J4', 700);
INSERT INTO `spj` VALUES ('S1', 'P2', 'J2', 100);
INSERT INTO `spj` VALUES ('S2', 'P3', 'J1', 400);
INSERT INTO `spj` VALUES ('S2', 'P3', 'J2', 200);
INSERT INTO `spj` VALUES ('S2', 'P3', 'J4', 500);
INSERT INTO `spj` VALUES ('S2', 'P3', 'J5', 400);
INSERT INTO `spj` VALUES ('S2', 'P5', 'J1', 400);
INSERT INTO `spj` VALUES ('S2', 'P5', 'J2', 100);
INSERT INTO `spj` VALUES ('S3', 'P1', 'J1', 200);
INSERT INTO `spj` VALUES ('S3', 'P3', 'J1', 200);
INSERT INTO `spj` VALUES ('S4', 'P5', 'J1', 100);
INSERT INTO `spj` VALUES ('S4', 'P6', 'J3', 300);
INSERT INTO `spj` VALUES ('S4', 'P6', 'J4', 200);
INSERT INTO `spj` VALUES ('S5', 'P2', 'J4', 100);
INSERT INTO `spj` VALUES ('S5', 'P3', 'J1', 200);
INSERT INTO `spj` VALUES ('S5', 'P6', 'J2', 200);
INSERT INTO `spj` VALUES ('S5', 'P6', 'J4', 500);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `Sno` int(11) NOT NULL,
  `Sname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `Ssex` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `Sage` int(30) NULL DEFAULT NULL,
  `Sdept` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`Sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (201515121, '李勇', '男', 20, 'CS');
INSERT INTO `student` VALUES (201515122, '刘成', '男', 19, 'CS');
INSERT INTO `student` VALUES (201515123, '王敏', '女', 20, 'MA');
INSERT INTO `student` VALUES (201515124, '张立', '男', 19, 'IS');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'student teacher admin 三选一',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
