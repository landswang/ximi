/*
Navicat MySQL Data Transfer

Source Server         : ecrs
Source Server Version : 50718
Source Host           : 192.168.0.8:3306
Source Database       : ejie_nbrs

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-08-28 15:27:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
`user_id`  int(4) NOT NULL AUTO_INCREMENT COMMENT '用户唯一标示' ,
`account_name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号' ,
`user_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '无' COMMENT '用户姓名' ,
`password`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码' ,
`email`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '无' COMMENT '邮箱' ,
`phone_number`  varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '无' COMMENT '手机' ,
`user_type`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户类型' ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户状态' ,
`apikey`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '安全密匙' ,
`status_remark`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`role_id`  int(4) NULL DEFAULT NULL ,
PRIMARY KEY (`user_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户信息'
AUTO_INCREMENT=1097

;

-- ----------------------------
-- Records of account
-- ----------------------------
BEGIN;
INSERT INTO `account` VALUES ('1000', 'admin', '王', 'jwlmSLVmogI=', '无', '无', '0', '0', '0', '', '1001'), ('1001', 'wqs', 'wang', 'jwlmSLVmogI=', '无', '无', '0', '0', '0', '', '1001'), ('1072', 'adminn', '管理员2', 'cHv0FVE96T/A7NlgvWrfDA==', '无', '无', '0', '0', '0', null, '1062'), ('1073', 'thiisan', 'anfield', 'NRz9GsffhvoY59l/uFTwRw==', '无', '无', '0', '0', '0', null, '1062'), ('1075', 'wang', '王', 'jwlmSLVmogI=', '无', '无', '0', '0', '0', null, '1001'), ('1076', 'tlang', '田浪', 'BoqkulykvFrA7NlgvWrfDA==', '无', '无', '0', '0', '0', '', '1000'), ('1077', 'sxzs', '授信终审专员', 'cHv0FVE96T/A7NlgvWrfDA==', '无', '无', '0', '0', '0', null, '1002'), ('1078', 'fksp', '放款审批专员', 'cHv0FVE96T/A7NlgvWrfDA==', '无', '无', '0', '0', '0', null, '1003'), ('1079', 'wqs1', '王青松', 'jwlmSLVmogI=', '无', '无', '0', '0', '0', null, '1004'), ('1080', 'test', 'c', 'lUXzV/kCvYU=', '无', '无', '0', '0', '0', null, '1001'), ('1081', 'test01', 'abc', 'lUXzV/kCvYU=', '无', '无', '0', '0', '0', '', '1002'), ('1082', 'ceshi01', 'c', 'lUXzV/kCvYU=', '无', '无', '0', '0', '0', null, '1002'), ('1083', '1234', '1223', 'lUXzV/kCvYU=', '无', '无', '0', '0', '0', null, '1001'), ('1084', '123', '00000', 'lUXzV/kCvYU=', '无', '无', '0', '0', '0', null, '1001'), ('1085', '1235', '1223', 'lUXzV/kCvYU=', '无', '无', '0', '0', '0', null, '1001'), ('1086', 'test03', '123', 'lUXzV/kCvYU=', '无', '无', '0', '0', '0', null, '1001'), ('1087', 'xm1', '小明1', 'lUXzV/kCvYU=', '无', '无', '0', '0', '0', null, '1063'), ('1088', 'case001', '角色测试专用', 'lUXzV/kCvYU=', '无', '无', '0', '1', '0', '是是是是是是', '1002'), ('1089', 'abc', 'abc', 'DMaW62e4f1s=', '无', '无', '0', '0', '0', null, '1002'), ('1090', 'xiaoming2', '小明', 'lUXzV/kCvYU=', '无', '无', '0', '0', '0', null, '1073'), ('1091', 'wanglong', '王龙', 'lUXzV/kCvYU=', '无', '无', '0', '0', '0', null, '1066'), ('1092', 'js01', '角色测试专用', 'lUXzV/kCvYU=', '无', '无', '0', '0', '0', null, '1002'), ('1093', 'xiaoming3', '小明', 'lUXzV/kCvYU=', '无', '无', '0', '0', '0', null, '1076'), ('1094', 'c001', 'c', 'lUXzV/kCvYU=', '无', '无', '0', '1', '0', '', '1002'), ('1095', 'hesheng', '何胜', 'lUXzV/kCvYU=', '无', '无', '0', '0', '0', null, '1001'), ('1096', 'qqwe', 'dsf', 'jwlmSLVmogI=', '无', '无', '0', '0', '0', null, '1005');
COMMIT;

-- ----------------------------
-- Table structure for `applicant_base`
-- ----------------------------
DROP TABLE IF EXISTS `applicant_base`;
CREATE TABLE `applicant_base` (
`a_base_id`  int(8) NOT NULL AUTO_INCREMENT COMMENT 'a_base_id' ,
`name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款人姓名' ,
`id_type`  varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件类型' ,
`id_number`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号' ,
`nationality`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族' ,
`sex`  char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别' ,
`birthday`  date NULL DEFAULT NULL COMMENT '出生年月' ,
`marital_status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '婚姻状况' ,
`mate_info_id`  int(8) NULL DEFAULT NULL COMMENT '配偶信息' ,
`education_background`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历' ,
`career`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业' ,
`company_address`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位地址' ,
`company_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位名称' ,
`company_dept`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在部门' ,
`monthly_income`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月收入' ,
`years_working`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作年限' ,
`company_number`  varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位电话' ,
`job_title`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务' ,
`company_property`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位性质' ,
`phone_number`  varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话' ,
`permanent_address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '居住地址' ,
`residence_address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户籍地址' ,
`serialNo`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '流水号' ,
`bankcardno`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号' ,
`bankname`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行名称' ,
`branchBank`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支行名称' ,
`cardName`  varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '持卡人' ,
PRIMARY KEY (`a_base_id`),
UNIQUE INDEX `serid` (`serialNo`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='主借人信息'
AUTO_INCREMENT=8003762

;

-- ----------------------------
-- Records of applicant_base
-- ----------------------------
BEGIN;
INSERT INTO `applicant_base` VALUES ('8003760', '111', '身份证', '110101198001011558', null, '男', '1980-01-01', '未婚', '8203550', '博士', null, null, null, null, '0.0', null, null, null, null, '111', '天津市dgfdfg', '北京市dfgfdfg', 'YJCD2017081100001', '1111111111', '兴业银行', '111111111111', '11111'), ('8003761', '小明6', '身份证', '110101198001010213', null, '男', '1980-01-01', '已婚', '8203551', '博士后', '上班族', '四川省成都市环球中心', '少先队', '组织部', '52222.0', '2年以内', '13322222', '股东', null, '13222222222', '四川省成都市环球中心', '四川省成都市环球中心', 'YJCD2017081600007', '522222222222222', '中国银行', '中国银行成都市高新支行', '小明6');
COMMIT;

-- ----------------------------
-- Table structure for `c_form`
-- ----------------------------
DROP TABLE IF EXISTS `c_form`;
CREATE TABLE `c_form` (
`c_id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '授信报表主键' ,
`c_count`  int(11) NULL DEFAULT NULL COMMENT '授信审核总数' ,
`c_pass_count`  int(11) NULL DEFAULT NULL COMMENT '通过授信总数' ,
`c_pay`  decimal(11,2) NULL DEFAULT NULL COMMENT '申请金额总数' ,
`c_pass_pay`  decimal(11,2) NULL DEFAULT NULL COMMENT '通过金额总数' ,
`c_count_rate`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授信通过率' ,
`c_pay_rate`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通过金额比率' ,
`c_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授信审核月份' ,
`c_year`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报表年度' ,
`c_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报表类型' ,
PRIMARY KEY (`c_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='授信报表'
AUTO_INCREMENT=16

;

-- ----------------------------
-- Records of c_form
-- ----------------------------
BEGIN;
INSERT INTO `c_form` VALUES ('1', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '1', '2017', '授信'), ('2', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '2', '2017', '授信'), ('3', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '3', '2017', '授信'), ('4', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '4', '2017', '授信'), ('5', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '5', '2017', '授信'), ('6', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '6', '2017', '授信'), ('7', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '7', '2017', '授信'), ('8', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '8', '2017', '授信'), ('9', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '9', '2017', '授信'), ('10', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '10', '2017', '授信'), ('11', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '11', '2017', '授信'), ('12', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '12', '2017', '授信'), ('13', '60000', '50000', '36000000.00', '24000000.00', '80', '66.66', '全年', '2017', '授信'), ('14', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '1', '2018', '授信'), ('15', '5000', '4000', '3000000.00', '2000000.00', '80', '66.66', '全年', '2018', '授信');
COMMIT;

-- ----------------------------
-- Table structure for `common_applicant`
-- ----------------------------
DROP TABLE IF EXISTS `common_applicant`;
CREATE TABLE `common_applicant` (
`c_a_info_id`  int(8) NOT NULL AUTO_INCREMENT COMMENT 'c_a_info_id' ,
`c_a_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '共借人类型' ,
`c_a_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '共借款人姓名' ,
`c_a_relationship`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '与借贷人关系' ,
`c_a_age`  char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别' ,
`c_a_id_number`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号' ,
`c_a_phone_number`  varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话' ,
`c_a_residence_address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '居住地址' ,
`c_a_ID_address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户藉地址' ,
`c_a_reason`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '共借原因' ,
`c_a_birthday`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日' ,
`c_a_cardno`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号' ,
`c_a_bankname`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行名称' ,
`c_a_bank`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支行名称' ,
`c_a_cardOwner`  varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '持卡人' ,
`c_a_ownerID`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '持卡人身份证' ,
`a_base_id`  int(11) NULL DEFAULT NULL COMMENT '主借人信息' ,
`serialNo`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务流水号' ,
PRIMARY KEY (`c_a_info_id`),
UNIQUE INDEX `idNum` (`c_a_id_number`) USING BTREE ,
UNIQUE INDEX `serid` (`serialNo`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='共同申请人'
AUTO_INCREMENT=8100956

;

-- ----------------------------
-- Records of common_applicant
-- ----------------------------
BEGIN;
INSERT INTO `common_applicant` VALUES ('8100955', '01', '小强6', '夫妻', '男', '110101198001010213', '13222222222', '环球中心', '环球中心', '', '1980-01-01 00:00:00', '5222222222222', '中信银行', '中信银行成都高新支行', '小强6', null, '8003761', null);
COMMIT;

-- ----------------------------
-- Table structure for `delete_file`
-- ----------------------------
DROP TABLE IF EXISTS `delete_file`;
CREATE TABLE `delete_file` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`file_name`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`stuts`  int(2) NULL DEFAULT NULL ,
`path`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=145

;

-- ----------------------------
-- Records of delete_file
-- ----------------------------
BEGIN;
INSERT INTO `delete_file` VALUES ('139', '11111111111.xml,111-1.jpg,111-2.jpg,111-3.jpg,111-4.jpg,111-5.jpg', '0', 'SXL/1111111111111111'), ('140', '20170924-5ce1bdd5bf0a4834a2701f1229956270.xml,20170823151819818.jpg,20170823151819381.jpg,20170823151819569.jpg,20170823151820224.jpg,20170823151820614.jpg,20170823151820333.jpg,20170823151819210.jpg,20170823151820770.jpg,20170823151819725.jpg,20170823151819990.jpg', '0', 'SXL/YJCD2017082300001'), ('141', '11111111111.xml,111-1.jpg,111-2.jpg,111-3.jpg,111-4.jpg,111-5.jpg', '0', 'SXL/1111111111111111'), ('142', '20170823-df109fd50b9f46e89d97420358f4a4f6.xml,20170823152359652.jpg,20170823152359776.jpg,20170823152359948.jpg,20170823152400073.jpg,20170823152400198.jpg,20170823152400322.jpg,20170823151819725.jpg,20170823152400432.jpg,20170823152400572.jpg,20170823152400728.jpg,20170823152400884.jpg,20170823152401024.jpg,20170823152400322.jpg,20170823151819725.jpg', '0', 'DYJFKL/YJCD2017082300001'), ('143', '11111111111.xml,111-1.jpg,111-2.jpg,111-3.jpg,111-4.jpg,111-5.jpg', '0', 'SXL/1111111111111111'), ('144', '20170823-df109fd50b9f46e89d97420358f4a4f6.xml,20170823152359652.jpg,20170823152359776.jpg,20170823152359948.jpg,20170823152400073.jpg,20170823152400198.jpg,20170823152400322.jpg,20170823151819725.jpg,20170823152400432.jpg,20170823152400572.jpg,20170823152400728.jpg,20170823152400884.jpg,20170823152401024.jpg,20170823152400322.jpg,20170823151819725.jpg', '0', 'DYJFKL/YJCD2017082300001');
COMMIT;

-- ----------------------------
-- Table structure for `doc_info`
-- ----------------------------
DROP TABLE IF EXISTS `doc_info`;
CREATE TABLE `doc_info` (
`type`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`type`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of doc_info
-- ----------------------------
BEGIN;
INSERT INTO `doc_info` VALUES ('BZJZYQRHSMJ', '保证金质押确认函扫描件'), ('DKYTZMWJ', '贷款用途证明文件'), ('DYDJSQHFGJJSXYJ', '抵押登记申请和房管局介绍信原件'), ('EDZYD', '额度支用单'), ('FCZHGTZBDCDJZ', '房产证(含国土证)/不动产登记证'), ('FGJSLHZDZPHSMJ', '房管局受理回执单照片或扫描件'), ('FKSCSPB', '放款审查审批表'), ('FWXXZYSYJ', '房屋信息摘要3原件'), ('GRZXDXXCXJSYSQSDY', '个人征信等信息查询及使用授权书(抵押及放款)'), ('GRZXDXXCXJSYSQSSX', '个人征信等信息查询及使用授权书(授信)'), ('GRZXXJBYJ', '个人征信详尽版原件'), ('HKB', '户口本'), ('HYZM', '婚姻证明'), ('JJ', '借据'), ('JKEDHT', '借款额度合同'), ('MQZP', '面签照片'), ('SFZ', '身份证'), ('STZFSQSKRYHKFYJ', '受托支付申请+收款人银行卡复印件'), ('TXQLZSYJ', '他项权利证书原件'), ('XHZPJYJPGXX', '下户照片及易捷评估信息'), ('XWYHGRDKSQSPS', '新网银行个人贷款申请审批书'), ('ZHWTKKSQS', '账户委托扣款授权书');
COMMIT;

-- ----------------------------
-- Table structure for `doc_info_rel`
-- ----------------------------
DROP TABLE IF EXISTS `doc_info_rel`;
CREATE TABLE `doc_info_rel` (
`doc_info_type`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`service_info_type`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`doctype_info_type`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`doc_info_type`, `service_info_type`, `doctype_info_type`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of doc_info_rel
-- ----------------------------
BEGIN;
INSERT INTO `doc_info_rel` VALUES ('BZJZYQRHSMJ', 'DYJFKL', 'FKSH'), ('DKYTZMWJ', 'SXL', 'HTL'), ('DYDJSQHFGJJSXYJ', 'DYJFKL', 'DYZL'), ('EDZYD', 'DYJFKL', 'FKSH'), ('FCZHGTZBDCDJZ', 'SXL', 'FCL'), ('FGJSLHZDZPHSMJ', 'DYJFKL', 'FKSH'), ('FKSCSPB', 'DYJFKL', 'FKSH'), ('FWXXZYSYJ', 'SXL', 'FCL'), ('GRZXDXXCXJSYSQSDY', 'DYJFKL', 'FKSH'), ('GRZXDXXCXJSYSQSSX', 'SXL', 'HTL'), ('GRZXXJBYJ', 'SXL', 'ZXL'), ('HKB', 'SXL', 'SFL'), ('HYZM', 'SXL', 'SFL'), ('JJ', 'DYJFKL', 'FKSH'), ('JKEDHT', 'DYJFKL', 'FKSH'), ('MQZP', 'DYJFKL', 'FKSH'), ('SFZ', 'SXL', 'SFL'), ('STZFSQSKRYHKFYJ', 'DYJFKL', 'FKSH'), ('TXQLZSYJ', 'DHL', 'DHL'), ('XHZPJYJPGXX', 'SXL', 'HTL'), ('XWYHGRDKSQSPS', 'SXL', 'HTL'), ('ZHWTKKSQS', 'DYJFKL', 'FKSH');
COMMIT;

-- ----------------------------
-- Table structure for `doctype_info`
-- ----------------------------
DROP TABLE IF EXISTS `doctype_info`;
CREATE TABLE `doctype_info` (
`type`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`type`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of doctype_info
-- ----------------------------
BEGIN;
INSERT INTO `doctype_info` VALUES ('DHL', '贷后类'), ('DYZL', '抵押资料'), ('FCL', '房产类'), ('FKSH', '放款审核'), ('HTL', '合同类'), ('SFL', '身份类'), ('ZXL', '征信类');
COMMIT;

-- ----------------------------
-- Table structure for `ejie_neworder`
-- ----------------------------
DROP TABLE IF EXISTS `ejie_neworder`;
CREATE TABLE `ejie_neworder` (
`serialNo`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '贷款编号' ,
`city`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务城市' ,
`realName`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名' ,
`loanDate`  date NULL DEFAULT NULL COMMENT '申请时间' ,
`garantyType`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '贷款产品' ,
`repayMethod`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '还款方式' ,
`loanAmount`  decimal(11,2) NULL DEFAULT NULL COMMENT '申请金额' ,
`loanLimit`  int(2) NULL DEFAULT NULL COMMENT '期数' ,
`loanId`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '贷款编号' ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态' ,
`getTime`  timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间' ,
`loanRate`  float NULL DEFAULT NULL COMMENT '平台及利率' ,
`modify_time`  date NULL DEFAULT NULL COMMENT '最后修改时间' ,
PRIMARY KEY (`serialNo`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='易捷数据接口-新进件'

;

-- ----------------------------
-- Records of ejie_neworder
-- ----------------------------
BEGIN;
INSERT INTO `ejie_neworder` VALUES ('YJCD2017081100001', '四川省成都市', '111', '2017-08-28', '房贷一抵', '等额本息', '200000.00', '8', '7002542', '9', '2017-08-28 15:20:25', '8.4', null), ('YJCD2017081500001', '四川省成都市', '小明MAX', '2017-08-28', '房贷一抵', '等额本息', '400000.00', '7', null, '0', '2017-08-28 15:20:25', '8.4', null), ('YJCD2017081500002', '四川省成都市', 'xw01001', '2017-08-28', '房贷一抵', '等额本息', '1000000.00', '8', null, '0', '2017-08-28 15:20:24', '8.4', null), ('YJCD2017081500005', '四川省成都市', '2017815测试', '2017-08-28', '房贷一抵', '等额本息', '100000.00', '7', null, '0', '2017-08-28 15:20:24', '8.4', null), ('YJCD2017081600001', '四川省成都市', '小明2', '2017-08-28', '房贷一抵', '等额本息', '300000.00', '7', null, '0', '2017-08-28 15:20:24', '8.4', null), ('YJCD2017081600002', '四川省成都市', 'xw02001', '2017-08-28', '房贷一抵', '等额本息', '1000000.00', '12', null, '0', '2017-08-28 15:20:24', '8.4', null), ('YJCD2017081600003', '四川省成都市', '小明3', '2017-08-28', '房贷一抵', '等额本息', '500000.00', '7', null, '0', '2017-08-28 15:20:24', '8.4', null), ('YJCD2017081600004', '四川省成都市', 'xw02002', '2017-08-28', '房贷一抵', '等额本息', '2010000.00', '20', null, '0', '2017-08-28 15:20:24', '8.4', null), ('YJCD2017081600005', '四川省成都市', '小明4', '2017-08-28', '房贷一抵', '等额本息', '200000.00', '7', null, '0', '2017-08-28 15:20:24', '8.4', null), ('YJCD2017081600006', '四川省成都市', '小明5', '2017-08-28', '房贷二抵', '等额本息', '460000.00', '7', null, '0', '2017-08-28 15:20:24', '8.4', null), ('YJCD2017081600007', '四川省成都市', '小明6', '2017-08-28', '房贷一抵', '先息后本', '30000000.00', '12', '7002543', '9', '2017-08-28 15:20:24', '8.8', null), ('YJCD2017081600008', '四川省成都市', '小明7', '2017-08-28', '房贷二抵', '等额本息', '200000.00', '7', null, '0', '2017-08-28 15:20:24', '8.4', null), ('YJCD2017081700002', '四川省成都市', 'xw0301', '2017-08-28', '房贷一抵', '先息后本', '2000000.00', '6', null, '0', '2017-08-28 15:20:24', '8.8', null), ('YJCD2017081700003', '四川省成都市', 'xw02002', '2017-08-28', '房贷一抵', '等额本息', '1200000.00', '10', null, '0', '2017-08-28 15:20:24', '8.4', null), ('YJCD2017081700004', '四川省成都市', '小明8', '2017-08-28', '房贷一抵', '等额本息', '200000.00', '7', null, '0', '2017-08-28 15:20:24', '8.4', null), ('YJCD2017081800001', '四川省成都市', 'xw0401', '2017-08-28', '房贷一抵', '等额本息', '1000000.00', '10', null, '0', '2017-08-28 15:20:24', '8.4', null), ('YJCD2017082100001', '四川省成都市', 'xw05001', '2017-08-28', '房贷一抵', '等额本息', '1200000.00', '10', null, '0', '2017-08-28 15:20:24', '8.4', null), ('YJCD2017082300001', '四川省成都市', 'xw001', '2017-08-28', '房贷一抵', '等额本息', '1000000.00', '10', null, '0', '2017-08-28 15:20:24', '8.4', null);
COMMIT;

-- ----------------------------
-- Table structure for `ftp_doc`
-- ----------------------------
DROP TABLE IF EXISTS `ftp_doc`;
CREATE TABLE `ftp_doc` (
`id`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`branch_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`source`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bus_no`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of ftp_doc
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `grant_money`
-- ----------------------------
DROP TABLE IF EXISTS `grant_money`;
CREATE TABLE `grant_money` (
`id`  int(8) NOT NULL AUTO_INCREMENT COMMENT '贷款编号' ,
`real_loan_money`  decimal(11,2) NULL DEFAULT NULL COMMENT '实际放款金额' ,
`loan_method`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '放款模式' ,
`loan_date`  date NULL DEFAULT NULL COMMENT '放款日期' ,
`loan_image`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '放款凭证' ,
`repayment_method`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '还款方式' ,
`repayment_limit`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '还款期限' ,
`repayment_card_number`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号' ,
`repayment_bank`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户行' ,
`cardholder`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '持卡人' ,
`remark`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`loan_id`  int(10) NULL DEFAULT NULL COMMENT '贷款编号' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='放款信息'
AUTO_INCREMENT=7000152

;

-- ----------------------------
-- Records of grant_money
-- ----------------------------
BEGIN;
INSERT INTO `grant_money` VALUES ('7000151', null, '0', '2017-08-29', '[\"1503904950605u=2418407644,2394454627&fm=11&gp=0.jpg\",\"1503904953069u=3783170743,3488861512&fm=21&gp=0.jpg\",\"1503904955643u=3799164235,2463583136&fm=21&gp=0.jpg\"]', '先息后本', '12', '522222222222222', '中国银行', '小明6', '没有钱了 不放款', '7002543');
COMMIT;

-- ----------------------------
-- Table structure for `guarantee`
-- ----------------------------
DROP TABLE IF EXISTS `guarantee`;
CREATE TABLE `guarantee` (
`id`  int(8) NOT NULL AUTO_INCREMENT ,
`loan_id`  int(8) NULL DEFAULT NULL COMMENT '贷款编号' ,
`guarantee_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押物id' ,
`mcar_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押车编号' ,
`mhouse_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押车编号' ,
`serialNo`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务流水号' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `serid` (`serialNo`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='抵押物'
AUTO_INCREMENT=2976

;

-- ----------------------------
-- Records of guarantee
-- ----------------------------
BEGIN;
INSERT INTO `guarantee` VALUES ('2974', '7002542', '02e62f5bc9c047ade1b6f456dbdeec73', 'f47aab29749ffc5535388569da05a706', '052a165a75d596011715aa82c5065554', 'YJCD2017081100001'), ('2975', '7002543', '6697f4db8b170c14f67abd3d28a1c15e', '729737678c3e76418824314e8931ea92', '824497a4925eea0004d1bf17754d8f62', 'YJCD2017081600007');
COMMIT;

-- ----------------------------
-- Table structure for `guarantee_management`
-- ----------------------------
DROP TABLE IF EXISTS `guarantee_management`;
CREATE TABLE `guarantee_management` (
`g_m_id`  int(8) NOT NULL AUTO_INCREMENT COMMENT 'id' ,
`loan_id`  int(10) NULL DEFAULT NULL COMMENT '贷款编号' ,
`gm_app_id`  int(8) NULL DEFAULT NULL COMMENT '抵押人id' ,
`gm_status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押品状态' ,
`gm_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '押品类型' ,
`gm_out_time`  date NULL DEFAULT NULL COMMENT '出库时间' ,
`gm_in_time`  date NULL DEFAULT NULL COMMENT '入库时间' ,
`out_reason`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出库原因' ,
`out_remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出库说明' ,
`gm_accessory`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件' ,
`g_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押物具体编号' ,
`final_transfer_date`  date NULL DEFAULT NULL COMMENT '放款确认时间' ,
`in_applyTime`  datetime NULL DEFAULT NULL COMMENT '入库申请时间' ,
`out_applyTime`  datetime NULL DEFAULT NULL COMMENT '出库申请时间' ,
PRIMARY KEY (`g_m_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='押品管理'
AUTO_INCREMENT=4400114

;

-- ----------------------------
-- Records of guarantee_management
-- ----------------------------
BEGIN;
INSERT INTO `guarantee_management` VALUES ('4400113', '7002543', '8003761', '1', '住房', null, '2017-08-28', null, '随意吧，不关心入库否', null, '6697f4db8b170c14f67abd3d28a1c15e', '2017-08-29', '2017-08-28 03:23:49', null);
COMMIT;

-- ----------------------------
-- Table structure for `guarantee_value`
-- ----------------------------
DROP TABLE IF EXISTS `guarantee_value`;
CREATE TABLE `guarantee_value` (
`gua_v_id`  int(8) NOT NULL AUTO_INCREMENT COMMENT 'id' ,
`old_value`  decimal(11,2) NULL DEFAULT NULL COMMENT '押品原值' ,
`ejie_comfirm_value`  decimal(11,2) NULL DEFAULT NULL COMMENT '中介评估价值' ,
`comfirm_value`  decimal(11,2) NULL DEFAULT NULL COMMENT '资方确认价值' ,
`comfirm_date`  date NULL DEFAULT NULL COMMENT '确认时间' ,
`g_status`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押品状态' ,
`guarantee_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押物id' ,
`g_rate`  float(3,2) NULL DEFAULT NULL COMMENT '抵押率' ,
`serialNo`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务流水号' ,
`common_applicant`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务流水号' ,
PRIMARY KEY (`gua_v_id`),
UNIQUE INDEX `serid` (`serialNo`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='抵押物价值'
AUTO_INCREMENT=4702413

;

-- ----------------------------
-- Records of guarantee_value
-- ----------------------------
BEGIN;
INSERT INTO `guarantee_value` VALUES ('4702411', null, '1000000.00', null, null, '0', '02e62f5bc9c047ade1b6f456dbdeec73', '0.20', 'YJCD2017081100001', null), ('4702412', null, '25000000.00', null, null, '0', '6697f4db8b170c14f67abd3d28a1c15e', '1.20', 'YJCD2017081600007', null);
COMMIT;

-- ----------------------------
-- Table structure for `images_info`
-- ----------------------------
DROP TABLE IF EXISTS `images_info`;
CREATE TABLE `images_info` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`source`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bus_no`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sub_type`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=5308

;

-- ----------------------------
-- Records of images_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `l_form`
-- ----------------------------
DROP TABLE IF EXISTS `l_form`;
CREATE TABLE `l_form` (
`l_id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '放款报表主键' ,
`l_count`  int(11) NULL DEFAULT NULL COMMENT '放款审核总数' ,
`l_pass_count`  int(11) NULL DEFAULT NULL COMMENT '通过审核数' ,
`l_pay`  decimal(10,2) NULL DEFAULT NULL COMMENT '申请金额总数' ,
`l_pass_pay`  decimal(10,2) NULL DEFAULT NULL COMMENT '通过金额总数' ,
`l_count_rate`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核通过率' ,
`l_pay_rate`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通过金额比率' ,
`l_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '放款审核月份' ,
`l_year`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报表年度' ,
`l_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报表类型' ,
PRIMARY KEY (`l_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='放款报表'
AUTO_INCREMENT=16

;

-- ----------------------------
-- Records of l_form
-- ----------------------------
BEGIN;
INSERT INTO `l_form` VALUES ('1', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '1', '2017', '放款'), ('2', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '2', '2017', '放款'), ('3', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '3', '2017', '放款'), ('4', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '4', '2017', '放款'), ('5', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '5', '2017', '放款'), ('6', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '6', '2017', '放款'), ('7', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '7', '2017', '放款'), ('8', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '8', '2017', '放款'), ('9', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '9', '2017', '放款'), ('10', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '10', '2017', '放款'), ('11', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '11', '2017', '放款'), ('12', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '12', '2017', '放款'), ('13', '48000', '36000', '36000000.00', '24000000.00', '75', '66.66', '全年', '2017', '放款'), ('14', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '1', '2018', '放款'), ('15', '4000', '3000', '3000000.00', '2000000.00', '75', '66.66', '全年', '2018', '放款');
COMMIT;

-- ----------------------------
-- Table structure for `loan_info`
-- ----------------------------
DROP TABLE IF EXISTS `loan_info`;
CREATE TABLE `loan_info` (
`loan_id`  int(10) NOT NULL AUTO_INCREMENT COMMENT '贷款编号' ,
`city`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务城市' ,
`app_date`  date NULL DEFAULT NULL COMMENT '申请时间' ,
`e_product`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '贷款产品' ,
`repay_way`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '还款方式' ,
`app_money`  decimal(11,2) NULL DEFAULT NULL COMMENT '申请金额' ,
`rate`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '平台及利率' ,
`periods`  int(2) NULL DEFAULT NULL COMMENT '期数' ,
`loan_purpose`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资金用途' ,
`loan_money`  decimal(11,2) NULL DEFAULT NULL COMMENT '下款总额' ,
`a_base_id`  int(8) NULL DEFAULT NULL COMMENT '主借人' ,
`c_a_info_id`  int(8) NULL DEFAULT NULL COMMENT '共借款人' ,
`c_card_number`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号' ,
`c_card_bank`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户行' ,
`c_card_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '持卡人' ,
`loan_method`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '放款方式' ,
`status`  int(2) NULL DEFAULT NULL COMMENT '当前状态:  0 ：授信终审-待审核 ，1：授信终审-通过/待放款审批，2：授信终审-未通过，3：放款审批-通过/待放款，4：放款审批-未通过，5：放款确认-已放款，6：放款确认-拒绝放款' ,
`pay_certificate`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '放款凭证' ,
`loan_date`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '放款方式' ,
`grant_credit_date`  date NULL DEFAULT NULL COMMENT '授信审核时间' ,
`give_moeny_date`  date NULL DEFAULT NULL COMMENT '放款审核时间' ,
`final_transfer_date`  date NULL DEFAULT NULL COMMENT '放款时间' ,
`remark`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`guarantee_object`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押对象 单位or个人' ,
`grant_autid_user`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授信审核人' ,
`give_moeny_user`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '放款审批人' ,
`final_transfer_user`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '放款确认人' ,
`serialNo`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务流水好' ,
`guarantee_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押物id' ,
`c_Branch_Bank`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支行名称' ,
`nodeNumber`  int(6) NULL DEFAULT NULL COMMENT '节点标记码' ,
PRIMARY KEY (`loan_id`),
UNIQUE INDEX `serid` (`serialNo`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='贷款信息表'
AUTO_INCREMENT=7002544

;

-- ----------------------------
-- Records of loan_info
-- ----------------------------
BEGIN;
INSERT INTO `loan_info` VALUES ('7002542', '四川省成都市', '2017-08-28', null, '等额本息', '200000.00', '8.4', '8', '个人消费', null, '8003760', null, '1111111111', '兴业银行', '11111', null, '1', null, null, null, null, null, null, null, null, null, null, 'YJCD2017081100001', '02e62f5bc9c047ade1b6f456dbdeec73', '111111111111', null), ('7002543', '四川省成都市', '2017-08-28', null, '先息后本', '30000000.00', '8.8', '12', '创业', null, '8003761', null, '522222222222222', '中国银行', '小明6', null, '5', null, null, null, null, null, null, null, null, null, null, 'YJCD2017081600007', '6697f4db8b170c14f67abd3d28a1c15e', '中国银行成都市高新支行', null);
COMMIT;

-- ----------------------------
-- Table structure for `loan_product`
-- ----------------------------
DROP TABLE IF EXISTS `loan_product`;
CREATE TABLE `loan_product` (
`id`  int(8) NOT NULL AUTO_INCREMENT COMMENT 'id' ,
`e_product`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '贷款产品' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='资料复审'
AUTO_INCREMENT=1000002

;

-- ----------------------------
-- Records of loan_product
-- ----------------------------
BEGIN;
INSERT INTO `loan_product` VALUES ('1000000', '车贷'), ('1000001', '房贷');
COMMIT;

-- ----------------------------
-- Table structure for `log_management`
-- ----------------------------
DROP TABLE IF EXISTS `log_management`;
CREATE TABLE `log_management` (
`log_id`  int(8) NOT NULL AUTO_INCREMENT COMMENT '日志主键标识' ,
`loan_id`  int(8) NULL DEFAULT NULL COMMENT '贷款编号' ,
`log_operate_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作类型标识' ,
`log_operator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人' ,
`log_date`  datetime NULL DEFAULT NULL COMMENT '日志生成时间/操作时间' ,
`log_details`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志详情/具体操作' ,
`log_module_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务模块标识' ,
PRIMARY KEY (`log_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='日志管理'
AUTO_INCREMENT=5000116

;

-- ----------------------------
-- Records of log_management
-- ----------------------------
BEGIN;
INSERT INTO `log_management` VALUES ('5000059', '7002526', '提交入库申请', '1000', '2017-08-25 10:06:55', '[提交抵押物入库申请]11111111111', '押品管理'), ('5000060', '7002526', '入库申请拒绝', '1000', '2017-08-25 10:07:04', '[入库申请拒绝]22222222222', '押品管理'), ('5000061', '7002526', '提交入库申请', '1000', '2017-08-25 10:07:13', '[提交抵押物入库申请]333333333333', '押品管理'), ('5000062', '7002526', '入库申请通过', '1000', '2017-08-25 10:07:20', '[入库申请被通过]没有具体说明。', '押品管理'), ('5000063', '7002526', '强行出库', '1000', '2017-08-25 10:07:38', '[强行出库]444444444444444', '押品管理'), ('5000064', '7002526', '提交出库申请', '1000', '2017-08-25 10:07:48', '[提交抵押物出库申请]没有具体说明。', '押品管理'), ('5000065', '7002526', '出库申请拒绝', '1000', '2017-08-25 10:07:56', '[出库申请拒绝]5555555555555', '押品管理'), ('5000066', '7002526', '提交出库申请', '1000', '2017-08-25 10:08:06', '[提交抵押物出库申请]没有具体说明。', '押品管理'), ('5000067', '7002526', '出库申请通过', '1000', '2017-08-25 10:08:13', '[出库申请通过]没有具体说明。', '押品管理'), ('5000068', '7002531', '提交入库申请', '1076', '2017-08-25 10:10:28', '[提交抵押物入库申请]测试', '押品管理'), ('5000069', '7002531', '入库申请通过', '1076', '2017-08-25 10:10:35', '[入库申请被通过]没有具体说明。', '押品管理'), ('5000070', '7002531', '强行出库', '1076', '2017-08-25 10:11:01', '[强行出库]测试图片', '押品管理'), ('5000071', '7002527', '提交入库申请', '1000', '2017-08-25 10:15:25', '[提交抵押物入库申请]111111111111', '押品管理'), ('5000072', '7002527', '入库申请拒绝', '1000', '2017-08-25 10:15:32', '[入库申请拒绝]222222222222', '押品管理'), ('5000073', '7002527', '提交入库申请', '1000', '2017-08-25 10:15:37', '[提交抵押物入库申请]33333333333333', '押品管理'), ('5000074', '7002527', '入库申请通过', '1000', '2017-08-25 10:15:43', '[入库申请被通过]没有具体说明。', '押品管理'), ('5000075', '7002527', '强行出库', '1000', '2017-08-25 10:16:00', '[强行出库]4444444444444444', '押品管理'), ('5000076', '7002527', '提交出库申请', '1000', '2017-08-25 10:16:08', '[提交抵押物出库申请]没有具体说明。', '押品管理'), ('5000077', '7002527', '出库申请拒绝', '1000', '2017-08-25 10:16:16', '[出库申请拒绝]66666666666666', '押品管理'), ('5000078', '7002527', '提交出库申请', '1000', '2017-08-25 10:16:20', '[提交抵押物出库申请]没有具体说明。', '押品管理'), ('5000079', '7002527', '出库申请通过', '1000', '2017-08-25 10:16:26', '[出库申请通过]没有具体说明。', '押品管理'), ('5000080', '7002522', '提交入库申请', '1076', '2017-08-25 10:23:35', '[提交抵押物入库申请]测试图片地址', '押品管理'), ('5000081', '7002522', '入库申请通过', '1076', '2017-08-25 10:23:41', '[入库申请被通过]没有具体说明。', '押品管理'), ('5000082', '7002522', '强行出库', '1076', '2017-08-25 10:24:05', '[强行出库]测试强行出库，图片路径', '押品管理'), ('5000083', '7002531', '提交出库申请', '1076', '2017-08-25 10:25:57', '[提交抵押物出库申请]没有具体说明。', '押品管理'), ('5000084', '7002522', '提交出库申请', '1076', '2017-08-25 10:25:59', '[提交抵押物出库申请]没有具体说明。', '押品管理'), ('5000085', '7002531', '出库申请通过', '1076', '2017-08-25 10:26:06', '[出库申请通过]没有具体说明。', '押品管理'), ('5000086', '7002522', '出库申请通过', '1076', '2017-08-25 10:26:09', '[出库申请通过]没有具体说明。', '押品管理'), ('5000087', '7002524', '提交入库申请', '1076', '2017-08-25 10:32:39', '[提交抵押物入库申请]测试图片路径', '押品管理'), ('5000088', '7002524', '入库申请通过', '1076', '2017-08-25 10:32:44', '[入库申请被通过]没有具体说明。', '押品管理'), ('5000089', '7002524', '强行出库', '1076', '2017-08-25 10:34:25', '[强行出库]测试强行出库图片路径', '押品管理'), ('5000090', '7002524', '提交出库申请', '1076', '2017-08-25 10:36:31', '[提交抵押物出库申请]没有具体说明。', '押品管理'), ('5000091', '7002524', '出库申请拒绝', '1076', '2017-08-25 10:36:48', '[出库申请拒绝]图片路径还是有问题', '押品管理'), ('5000092', '7002531', '提交入库申请', '1076', '2017-08-25 10:50:46', '[提交抵押物入库申请]测试图片路径', '押品管理'), ('5000093', '7002531', '入库申请通过', '1076', '2017-08-25 10:50:52', '[入库申请被通过]没有具体说明。', '押品管理'), ('5000094', '7002531', '强行出库', '1076', '2017-08-25 10:51:11', '[强行出库]测试强行出库图片路径', '押品管理'), ('5000095', '7002526', '强行出库', '1076', '2017-08-25 10:53:21', '[强行出库]测试强行出库图片路径', '押品管理'), ('5000096', '7002531', '提交入库申请', '1000', '2017-08-25 13:36:29', '[提交抵押物入库申请]1111111111111111', '押品管理'), ('5000097', '7002531', '入库申请拒绝', '1000', '2017-08-25 13:36:47', '[入库申请拒绝]22222222222', '押品管理'), ('5000098', '7002531', '提交入库申请', '1000', '2017-08-25 13:36:53', '[提交抵押物入库申请]3333333333333', '押品管理'), ('5000099', '7002531', '入库申请通过', '1000', '2017-08-25 13:36:58', '[入库申请被通过]没有具体说明。', '押品管理'), ('5000100', '7002531', '提交入库申请', '1000', '2017-08-25 13:37:21', '[提交抵押物入库申请]1111111111111111', '押品管理'), ('5000101', '7002531', '强行出库', '1000', '2017-08-25 13:37:28', '[强行出库]44444444444444444', '押品管理'), ('5000102', '7002531', '提交出库申请', '1000', '2017-08-25 13:37:36', '[提交抵押物出库申请]没有具体说明。', '押品管理'), ('5000103', '7002531', '出库申请拒绝', '1000', '2017-08-25 13:37:43', '[出库申请拒绝]666666666666', '押品管理'), ('5000104', '7002531', '提交出库申请', '1000', '2017-08-25 13:37:47', '[提交抵押物出库申请]没有具体说明。', '押品管理'), ('5000105', '7002531', '出库申请通过', '1000', '2017-08-25 13:37:54', '[出库申请通过]没有具体说明。', '押品管理'), ('5000106', '7002526', '提交入库申请', '1000', '2017-08-25 13:49:00', '[提交抵押物入库申请]11111111111', '押品管理'), ('5000107', '7002526', '提交入库申请', '1000', '2017-08-25 13:49:01', '[提交抵押物入库申请]11111111111', '押品管理'), ('5000108', '7002526', '入库申请通过', '1000', '2017-08-25 13:49:09', '[入库申请被通过]没有具体说明。', '押品管理'), ('5000109', '7002526', '强行出库', '1000', '2017-08-25 13:50:03', '[强行出库]强行出库测试', '押品管理'), ('5000110', '7002522', '提交入库申请', '1076', '2017-08-25 14:05:01', '[提交抵押物入库申请]123123123', '押品管理'), ('5000111', '7002522', '入库申请通过', '1076', '2017-08-25 14:05:05', '[入库申请被通过]没有具体说明。', '押品管理'), ('5000112', '7002522', '强行出库', '1076', '2017-08-25 14:05:21', '[强行出库]213123123123', '押品管理'), ('5000113', '7002522', '提交出库申请', '1076', '2017-08-25 14:07:38', '[提交抵押物出库申请]没有具体说明。', '押品管理'), ('5000114', '7002522', '出库申请通过', '1076', '2017-08-25 14:08:01', '[出库申请通过]没有具体说明。', '押品管理'), ('5000115', '7002543', '提交入库申请', '1000', '2017-08-28 15:23:49', '[提交抵押物入库申请]随意吧，不关心入库否', '押品管理');
COMMIT;

-- ----------------------------
-- Table structure for `mate_info`
-- ----------------------------
DROP TABLE IF EXISTS `mate_info`;
CREATE TABLE `mate_info` (
`mate_info_id`  int(8) NOT NULL AUTO_INCREMENT COMMENT 'mate_info_id' ,
`mate_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配偶姓名' ,
`mate_id_number`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号' ,
`mate_phone_number`  varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话' ,
`mate_education_background`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历' ,
`mate_permanent_address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户籍地址' ,
`mate_residence_address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '居住地址' ,
`mate_age`  char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配偶年龄' ,
`mate_gender`  char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配偶' ,
`serialNo`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务流水号' ,
PRIMARY KEY (`mate_info_id`),
UNIQUE INDEX `mate_id_number` (`mate_id_number`) USING BTREE ,
UNIQUE INDEX `serid` (`serialNo`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='配偶信息'
AUTO_INCREMENT=8203552

;

-- ----------------------------
-- Records of mate_info
-- ----------------------------
BEGIN;
INSERT INTO `mate_info` VALUES ('8203550', '', '', '', null, '', null, null, '女', 'YJCD2017081100001'), ('8203551', '小红6', '11010119800101023X', '1322222222', '中专', '四川省成都市环球中心', '北京市天安门', '37', '女', 'YJCD2017081600007');
COMMIT;

-- ----------------------------
-- Table structure for `mortgage_car`
-- ----------------------------
DROP TABLE IF EXISTS `mortgage_car`;
CREATE TABLE `mortgage_car` (
`m_c_id`  int(8) NOT NULL AUTO_INCREMENT COMMENT 'id' ,
`mcar_brand`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌' ,
`mcar_version`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '型号' ,
`license_plate_number`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号' ,
`mcar_vin`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车架号' ,
`mcar_engine_number`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发动机号' ,
`mcar_buy_date`  date NULL DEFAULT NULL COMMENT '购之日期' ,
`mcar_buy_price`  decimal(11,2) NULL DEFAULT NULL COMMENT '购置金额' ,
`mcar_value`  decimal(11,2) NULL DEFAULT NULL COMMENT '抵押物评估值' ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态(待入库、入库申请中、已入库、出库申请中、已出库)' ,
`warrant_id`  int(8) NULL DEFAULT NULL COMMENT '权证信息' ,
`mcar_price`  decimal(11,2) NULL DEFAULT NULL COMMENT '评估金额' ,
`mcar_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押车编号' ,
`serialNo`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务流水号' ,
PRIMARY KEY (`m_c_id`),
UNIQUE INDEX `serid` (`serialNo`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='抵押车信息'
AUTO_INCREMENT=2

;

-- ----------------------------
-- Records of mortgage_car
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `mortgage_house`
-- ----------------------------
DROP TABLE IF EXISTS `mortgage_house`;
CREATE TABLE `mortgage_house` (
`m_h_id`  int(8) NOT NULL AUTO_INCREMENT COMMENT 'id' ,
`g_category`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押品类别' ,
`mhouse_value`  decimal(10,2) NULL DEFAULT NULL COMMENT '抵押物评估值' ,
`property_right_number`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产权证号' ,
`property_owner`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产权人' ,
`mortgager_tel`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押人电话' ,
`c_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件类型' ,
`c_number`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号码' ,
`acreage`  decimal(10,2) NULL DEFAULT NULL COMMENT '面积' ,
`g_address`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产权地址' ,
`and_status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '押品土地性质' ,
`house_area`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房屋区域' ,
`land_certificate`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '土地证书' ,
`get_method`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '获取方式' ,
`warrant_id`  int(8) NULL DEFAULT NULL COMMENT '权证信息' ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态(待入库、入库申请中、已入库、出库申请中、已出库)' ,
`priceRate`  float NULL DEFAULT NULL COMMENT '业务流水好' ,
`mhouse_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押物编号' ,
`serialNo`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务流水号' ,
PRIMARY KEY (`m_h_id`),
UNIQUE INDEX `serid` (`serialNo`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='抵押房'
AUTO_INCREMENT=2720

;

-- ----------------------------
-- Records of mortgage_house
-- ----------------------------
BEGIN;
INSERT INTO `mortgage_house` VALUES ('2718', '01', '1000000.00', '121212121212', '1111212', null, null, null, '100.00', '12121212121', '住宅', '天津', null, null, null, null, '0', '052a165a75d596011715aa82c5065554', 'YJCD2017081100001'), ('2719', '01', '25000000.00', '41111111111111', '小明6', '13222222222', null, '110101198001010213', '500.00', '四川省成都市环球中心', '住宅', '环球中心', null, null, null, null, '0', '824497a4925eea0004d1bf17754d8f62', 'YJCD2017081600007');
COMMIT;

-- ----------------------------
-- Table structure for `mortgager`
-- ----------------------------
DROP TABLE IF EXISTS `mortgager`;
CREATE TABLE `mortgager` (
`mortgager_id`  int(8) NOT NULL AUTO_INCREMENT COMMENT '编号' ,
`gm_app_id`  int(11) NULL DEFAULT NULL COMMENT '抵押人id' ,
`mortgager_name`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押人姓名' ,
`mortgager_tel`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押人电话' ,
`c_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件类型' ,
`c_number`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号码' ,
`a_base_id`  int(8) NULL DEFAULT NULL COMMENT '主借人id' ,
`c_a_info_id`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`m_h_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押房编号' ,
`m_c_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抵押车编号' ,
PRIMARY KEY (`mortgager_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='抵押人'
AUTO_INCREMENT=80

;

-- ----------------------------
-- Records of mortgager
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `privilege`
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
`privilege_id`  int(4) NOT NULL COMMENT '权限id' ,
`privilege_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称' ,
`privilege_level`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限级别' ,
`perant_level`  int(4) NULL DEFAULT NULL COMMENT '父级id' ,
`url`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限页面' ,
`privilege_comment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '无' COMMENT '权限描述' ,
PRIMARY KEY (`privilege_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='权限表'

;

-- ----------------------------
-- Records of privilege
-- ----------------------------
BEGIN;
INSERT INTO `privilege` VALUES ('1000', '贷款审批', '1', '1000', '0', '贷款审批系列'), ('1001', '授信终审', '2', '1000', 'loan/audit', '贷款审批/授信终审'), ('1002', '放款审批', '2', '1000', 'loan/loanAudit', '贷款审批/放款审批'), ('1003', '放款确认', '2', '1000', 'loan/affirm', '贷款审批/授信终审'), ('2000', '贷后管理', '1', '2000', '0', '贷后管理系列'), ('2001', '还款信息', '2', '2000', 'afterLoan/repayInfo', '贷后管理/还款信息'), ('2002', '逾期客户', '2', '2000', 'afterLoan/overdueCm', '贷后管理/逾期客户'), ('3000', '押品管理', '1', '3000', '0', '押品管理'), ('3001', '入库', '2', '3000', 'guarantee/inStor', '押品管理/入库'), ('3002', '出库', '2', '3000', 'guarantee/outStor', '押品管理/出库'), ('3003', '入库审批', '2', '3000', 'guarantee/guaranteeAudit', '押品管理/入库审批'), ('4000', '统计报表', '1', '4000', '0', '统计报表'), ('4001', '进件统计', '2', '4000', 'statisticReport/inStor', '统计报表/进件统计'), ('4002', '放款统计', '2', '4000', 'statisticReport/outStor', '统计报表/放款统计'), ('4003', '还款统计', '2', '4000', 'statisticReport/outStor', '统计报表/还款统计'), ('4004', '逾期统计', '2', '4000', 'statisticReport/guaranteeAudit', '统计报表/逾期统计'), ('5000', '消息管理', '1', '5000', '0', '消息管理'), ('5001', '消息管理', '2', '5000', 'messageM/myMM', '消息管理/消息管理'), ('6000', '系统管理', '1', '6000', '0', '系统管理'), ('6001', '新建用户', '2', '6000', 'systemManage/createAccount', '系统管理/新建用户'), ('6002', '权限管理', '2', '6000', 'systemManage/privilegeMan', '系统管理/权限管理'), ('6003', '密码修改', '2', '6000', 'systemManage/modifyPassword', '系统管理/密码修改');
COMMIT;

-- ----------------------------
-- Table structure for `repay_plan`
-- ----------------------------
DROP TABLE IF EXISTS `repay_plan`;
CREATE TABLE `repay_plan` (
`id`  int(10) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`serial_no`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '流水号' ,
`loan_id`  int(11) NULL DEFAULT NULL COMMENT '贷款编号' ,
`p_index`  int(4) NULL DEFAULT NULL COMMENT '分期数' ,
`repay_date`  date NULL DEFAULT NULL COMMENT '还款日期本月' ,
`capital`  decimal(10,2) NULL DEFAULT NULL COMMENT '本金' ,
`interest`  decimal(10,2) NULL DEFAULT NULL COMMENT '利息' ,
`total`  decimal(10,2) NULL DEFAULT NULL COMMENT '档期已还总额' ,
`complete_date`  date NULL DEFAULT NULL COMMENT '本期完成日期，未完成则传递空字符' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=715

;

-- ----------------------------
-- Records of repay_plan
-- ----------------------------
BEGIN;
INSERT INTO `repay_plan` VALUES ('582', 'YJCD2017081600007', '7002524', '1', '2017-10-26', '0.00', '234666.67', '0.00', null), ('583', 'YJCD2017081600007', '7002524', '2', '2017-11-26', '0.00', '227333.33', '0.00', null), ('584', 'YJCD2017081600007', '7002524', '3', '2017-12-26', '0.00', '220000.00', '0.00', null), ('585', 'YJCD2017081600007', '7002524', '4', '2018-01-26', '0.00', '227333.33', '0.00', null), ('586', 'YJCD2017081600007', '7002524', '5', '2018-02-26', '0.00', '227333.33', '0.00', null), ('587', 'YJCD2017081600007', '7002524', '6', '2018-03-26', '0.00', '205333.33', '0.00', null), ('588', 'YJCD2017081600007', '7002524', '7', '2018-04-26', '0.00', '227333.33', '0.00', null), ('589', 'YJCD2017081600007', '7002524', '8', '2018-05-26', '0.00', '220000.00', '0.00', null), ('590', 'YJCD2017081600007', '7002524', '9', '2018-06-26', '0.00', '227333.33', '0.00', null), ('591', 'YJCD2017081600007', '7002524', '10', '2018-07-26', '0.00', '220000.00', '0.00', null), ('592', 'YJCD2017081600007', '7002524', '11', '2018-08-26', '0.00', '227333.33', '0.00', null), ('593', 'YJCD2017081600007', '7002524', '12', '2018-09-24', '30000000.00', '212666.67', '0.00', null), ('594', 'YJCD2017081600007', '7002524', '1', '2017-10-26', '0.00', '234666.67', '0.00', null), ('595', 'YJCD2017081600007', '7002524', '2', '2017-11-26', '0.00', '227333.33', '0.00', null), ('596', 'YJCD2017081600007', '7002524', '3', '2017-12-26', '0.00', '220000.00', '0.00', null), ('597', 'YJCD2017081600007', '7002524', '4', '2018-01-26', '0.00', '227333.33', '0.00', null), ('598', 'YJCD2017081600007', '7002524', '5', '2018-02-26', '0.00', '227333.33', '0.00', null), ('599', 'YJCD2017081600007', '7002524', '6', '2018-03-26', '0.00', '205333.33', '0.00', null), ('600', 'YJCD2017081600007', '7002524', '7', '2018-04-26', '0.00', '227333.33', '0.00', null), ('601', 'YJCD2017081600007', '7002524', '8', '2018-05-26', '0.00', '220000.00', '0.00', null), ('602', 'YJCD2017081600007', '7002524', '9', '2018-06-26', '0.00', '227333.33', '0.00', null), ('603', 'YJCD2017081600007', '7002524', '10', '2018-07-26', '0.00', '220000.00', '0.00', null), ('604', 'YJCD2017081600007', '7002524', '11', '2018-08-26', '0.00', '227333.33', '0.00', null), ('605', 'YJCD2017081600007', '7002524', '12', '2018-09-24', '30000000.00', '212666.67', '0.00', null), ('606', 'YJCD2017081600006', '7002527', '1', '2017-10-26', '64181.63', '3434.67', '0.00', null), ('607', 'YJCD2017081600006', '7002527', '2', '2017-11-26', '64753.21', '2863.09', '0.00', null), ('608', 'YJCD2017081600006', '7002527', '3', '2017-12-26', '65298.84', '2317.46', '0.00', null), ('609', 'YJCD2017081600006', '7002527', '4', '2018-01-26', '65693.92', '1922.38', '0.00', null), ('610', 'YJCD2017081600006', '7002527', '5', '2018-02-26', '66169.11', '1447.19', '0.00', null), ('611', 'YJCD2017081600006', '7002527', '6', '2018-03-26', '66741.47', '874.83', '0.00', null), ('612', 'YJCD2017081600006', '7002527', '7', '2018-04-24', '67161.82', '454.46', '0.00', null), ('613', 'YJCD2017081600006', '7002527', '1', '2017-10-26', '64181.63', '3434.67', '0.00', null), ('614', 'YJCD2017081600006', '7002527', '2', '2017-11-26', '64753.21', '2863.09', '0.00', null), ('615', 'YJCD2017081600006', '7002527', '3', '2017-12-26', '65298.84', '2317.46', '0.00', null), ('616', 'YJCD2017081600006', '7002527', '4', '2018-01-26', '65693.92', '1922.38', '0.00', null), ('617', 'YJCD2017081600006', '7002527', '5', '2018-02-26', '66169.11', '1447.19', '0.00', null), ('618', 'YJCD2017081600006', '7002527', '6', '2018-03-26', '66741.47', '874.83', '0.00', null), ('619', 'YJCD2017081600006', '7002527', '7', '2018-04-24', '67161.82', '454.46', '0.00', null), ('620', 'YJCD2017081600007', '7002524', '1', '2017-10-26', '0.00', '234666.67', '0.00', null), ('621', 'YJCD2017081600007', '7002524', '2', '2017-11-26', '0.00', '227333.33', '0.00', null), ('622', 'YJCD2017081600007', '7002524', '3', '2017-12-26', '0.00', '220000.00', '0.00', null), ('623', 'YJCD2017081600007', '7002524', '4', '2018-01-26', '0.00', '227333.33', '0.00', null), ('624', 'YJCD2017081600007', '7002524', '5', '2018-02-26', '0.00', '227333.33', '0.00', null), ('625', 'YJCD2017081600007', '7002524', '6', '2018-03-26', '0.00', '205333.33', '0.00', null), ('626', 'YJCD2017081600007', '7002524', '7', '2018-04-26', '0.00', '227333.33', '0.00', null), ('627', 'YJCD2017081600007', '7002524', '8', '2018-05-26', '0.00', '220000.00', '0.00', null), ('628', 'YJCD2017081600007', '7002524', '9', '2018-06-26', '0.00', '227333.33', '0.00', null), ('629', 'YJCD2017081600007', '7002524', '10', '2018-07-26', '0.00', '220000.00', '0.00', null), ('630', 'YJCD2017081600007', '7002524', '11', '2018-08-26', '0.00', '227333.33', '0.00', null), ('631', 'YJCD2017081600007', '7002524', '12', '2018-09-24', '30000000.00', '212666.67', '0.00', null), ('632', 'YJCD2017081600007', '7002524', '1', '2017-10-26', '0.00', '234666.67', '0.00', null), ('633', 'YJCD2017081600007', '7002524', '2', '2017-11-26', '0.00', '227333.33', '0.00', null), ('634', 'YJCD2017081600007', '7002524', '3', '2017-12-26', '0.00', '220000.00', '0.00', null), ('635', 'YJCD2017081600007', '7002524', '4', '2018-01-26', '0.00', '227333.33', '0.00', null), ('636', 'YJCD2017081600007', '7002524', '5', '2018-02-26', '0.00', '227333.33', '0.00', null), ('637', 'YJCD2017081600007', '7002524', '6', '2018-03-26', '0.00', '205333.33', '0.00', null), ('638', 'YJCD2017081600007', '7002524', '7', '2018-04-26', '0.00', '227333.33', '0.00', null), ('639', 'YJCD2017081600007', '7002524', '8', '2018-05-26', '0.00', '220000.00', '0.00', null), ('640', 'YJCD2017081600007', '7002524', '9', '2018-06-26', '0.00', '227333.33', '0.00', null), ('641', 'YJCD2017081600007', '7002524', '10', '2018-07-26', '0.00', '220000.00', '0.00', null), ('642', 'YJCD2017081600007', '7002524', '11', '2018-08-26', '0.00', '227333.33', '0.00', null), ('643', 'YJCD2017081600007', '7002524', '12', '2018-09-24', '30000000.00', '212666.67', '0.00', null), ('644', 'YJCD2017081600006', '7002527', '1', '2017-10-26', '64181.63', '3434.67', '0.00', null), ('645', 'YJCD2017081600006', '7002527', '2', '2017-11-26', '64753.21', '2863.09', '0.00', null), ('646', 'YJCD2017081600006', '7002527', '3', '2017-12-26', '65298.84', '2317.46', '0.00', null), ('647', 'YJCD2017081600006', '7002527', '4', '2018-01-26', '65693.92', '1922.38', '0.00', null), ('648', 'YJCD2017081600006', '7002527', '5', '2018-02-26', '66169.11', '1447.19', '0.00', null), ('649', 'YJCD2017081600006', '7002527', '6', '2018-03-26', '66741.47', '874.83', '0.00', null), ('650', 'YJCD2017081600006', '7002527', '7', '2018-04-24', '67161.82', '454.46', '0.00', null), ('651', 'YJCD2017081600006', '7002527', '1', '2017-10-26', '64181.63', '3434.67', '0.00', null), ('652', 'YJCD2017081600006', '7002527', '2', '2017-11-26', '64753.21', '2863.09', '0.00', null), ('653', 'YJCD2017081600006', '7002527', '3', '2017-12-26', '65298.84', '2317.46', '0.00', null), ('654', 'YJCD2017081600006', '7002527', '4', '2018-01-26', '65693.92', '1922.38', '0.00', null), ('655', 'YJCD2017081600006', '7002527', '5', '2018-02-26', '66169.11', '1447.19', '0.00', null), ('656', 'YJCD2017081600006', '7002527', '6', '2018-03-26', '66741.47', '874.83', '0.00', null), ('657', 'YJCD2017081600006', '7002527', '7', '2018-04-24', '67161.82', '454.46', '0.00', null), ('658', 'YJCD2017081600007', '7002524', '1', '2017-10-26', '0.00', '234666.67', '0.00', null), ('659', 'YJCD2017081600007', '7002524', '2', '2017-11-26', '0.00', '227333.33', '0.00', null), ('660', 'YJCD2017081600007', '7002524', '3', '2017-12-26', '0.00', '220000.00', '0.00', null), ('661', 'YJCD2017081600007', '7002524', '4', '2018-01-26', '0.00', '227333.33', '0.00', null), ('662', 'YJCD2017081600007', '7002524', '5', '2018-02-26', '0.00', '227333.33', '0.00', null), ('663', 'YJCD2017081600007', '7002524', '6', '2018-03-26', '0.00', '205333.33', '0.00', null), ('664', 'YJCD2017081600007', '7002524', '7', '2018-04-26', '0.00', '227333.33', '0.00', null), ('665', 'YJCD2017081600007', '7002524', '8', '2018-05-26', '0.00', '220000.00', '0.00', null), ('666', 'YJCD2017081600007', '7002524', '9', '2018-06-26', '0.00', '227333.33', '0.00', null), ('667', 'YJCD2017081600007', '7002524', '10', '2018-07-26', '0.00', '220000.00', '0.00', null), ('668', 'YJCD2017081600007', '7002524', '11', '2018-08-26', '0.00', '227333.33', '0.00', null), ('669', 'YJCD2017081600007', '7002524', '12', '2018-09-24', '30000000.00', '212666.67', '0.00', null), ('670', 'YJCD2017081600007', '7002524', '1', '2017-10-26', '0.00', '234666.67', '0.00', null), ('671', 'YJCD2017081600007', '7002524', '2', '2017-11-26', '0.00', '227333.33', '0.00', null), ('672', 'YJCD2017081600007', '7002524', '3', '2017-12-26', '0.00', '220000.00', '0.00', null), ('673', 'YJCD2017081600007', '7002524', '4', '2018-01-26', '0.00', '227333.33', '0.00', null), ('674', 'YJCD2017081600007', '7002524', '5', '2018-02-26', '0.00', '227333.33', '0.00', null), ('675', 'YJCD2017081600007', '7002524', '6', '2018-03-26', '0.00', '205333.33', '0.00', null), ('676', 'YJCD2017081600007', '7002524', '7', '2018-04-26', '0.00', '227333.33', '0.00', null), ('677', 'YJCD2017081600007', '7002524', '8', '2018-05-26', '0.00', '220000.00', '0.00', null), ('678', 'YJCD2017081600007', '7002524', '9', '2018-06-26', '0.00', '227333.33', '0.00', null), ('679', 'YJCD2017081600007', '7002524', '10', '2018-07-26', '0.00', '220000.00', '0.00', null), ('680', 'YJCD2017081600007', '7002524', '11', '2018-08-26', '0.00', '227333.33', '0.00', null), ('681', 'YJCD2017081600007', '7002524', '12', '2018-09-24', '30000000.00', '212666.67', '0.00', null);
INSERT INTO `repay_plan` VALUES ('682', 'YJCD2017081600006', '7002527', '1', '2017-10-26', '64181.63', '3434.67', '0.00', null), ('683', 'YJCD2017081600006', '7002527', '2', '2017-11-26', '64753.21', '2863.09', '0.00', null), ('684', 'YJCD2017081600006', '7002527', '3', '2017-12-26', '65298.84', '2317.46', '0.00', null), ('685', 'YJCD2017081600006', '7002527', '4', '2018-01-26', '65693.92', '1922.38', '0.00', null), ('686', 'YJCD2017081600006', '7002527', '5', '2018-02-26', '66169.11', '1447.19', '0.00', null), ('687', 'YJCD2017081600006', '7002527', '6', '2018-03-26', '66741.47', '874.83', '0.00', null), ('688', 'YJCD2017081600006', '7002527', '7', '2018-04-24', '67161.82', '454.46', '0.00', null), ('689', 'YJCD2017081600006', '7002527', '1', '2017-10-26', '64181.63', '3434.67', '0.00', null), ('690', 'YJCD2017081600006', '7002527', '2', '2017-11-26', '64753.21', '2863.09', '0.00', null), ('691', 'YJCD2017081600006', '7002527', '3', '2017-12-26', '65298.84', '2317.46', '0.00', null), ('692', 'YJCD2017081600006', '7002527', '4', '2018-01-26', '65693.92', '1922.38', '0.00', null), ('693', 'YJCD2017081600006', '7002527', '5', '2018-02-26', '66169.11', '1447.19', '0.00', null), ('694', 'YJCD2017081600006', '7002527', '6', '2018-03-26', '66741.47', '874.83', '0.00', null), ('695', 'YJCD2017081600006', '7002527', '7', '2018-04-24', '67161.82', '454.46', '0.00', null), ('696', 'YJCD2017081600007', '7002524', '1', '2017-10-26', '0.00', '234666.67', '0.00', null), ('697', 'YJCD2017081600007', '7002524', '2', '2017-11-26', '0.00', '227333.33', '0.00', null), ('698', 'YJCD2017081600007', '7002524', '3', '2017-12-26', '0.00', '220000.00', '0.00', null), ('699', 'YJCD2017081600007', '7002524', '4', '2018-01-26', '0.00', '227333.33', '0.00', null), ('700', 'YJCD2017081600007', '7002524', '5', '2018-02-26', '0.00', '227333.33', '0.00', null), ('701', 'YJCD2017081600007', '7002524', '6', '2018-03-26', '0.00', '205333.33', '0.00', null), ('702', 'YJCD2017081600007', '7002524', '7', '2018-04-26', '0.00', '227333.33', '0.00', null), ('703', 'YJCD2017081600007', '7002524', '8', '2018-05-26', '0.00', '220000.00', '0.00', null), ('704', 'YJCD2017081600007', '7002524', '9', '2018-06-26', '0.00', '227333.33', '0.00', null), ('705', 'YJCD2017081600007', '7002524', '10', '2018-07-26', '0.00', '220000.00', '0.00', null), ('706', 'YJCD2017081600007', '7002524', '11', '2018-08-26', '0.00', '227333.33', '0.00', null), ('707', 'YJCD2017081600007', '7002524', '12', '2018-09-24', '30000000.00', '212666.67', '0.00', null), ('708', 'YJCD2017081600006', '7002527', '1', '2017-10-26', '64181.63', '3434.67', '0.00', null), ('709', 'YJCD2017081600006', '7002527', '2', '2017-11-26', '64753.21', '2863.09', '0.00', null), ('710', 'YJCD2017081600006', '7002527', '3', '2017-12-26', '65298.84', '2317.46', '0.00', null), ('711', 'YJCD2017081600006', '7002527', '4', '2018-01-26', '65693.92', '1922.38', '0.00', null), ('712', 'YJCD2017081600006', '7002527', '5', '2018-02-26', '66169.11', '1447.19', '0.00', null), ('713', 'YJCD2017081600006', '7002527', '6', '2018-03-26', '66741.47', '874.83', '0.00', null), ('714', 'YJCD2017081600006', '7002527', '7', '2018-04-24', '67161.82', '454.46', '0.00', null);
COMMIT;

-- ----------------------------
-- Table structure for `repayment_schedule`
-- ----------------------------
DROP TABLE IF EXISTS `repayment_schedule`;
CREATE TABLE `repayment_schedule` (
`loan_id`  int(10) NOT NULL COMMENT '贷款编号' ,
`serial_no`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务流水号' ,
`loan_amount`  decimal(10,2) NULL DEFAULT NULL COMMENT '期数' ,
`loan_date`  date NULL DEFAULT NULL COMMENT '放款日期' ,
`repay_limit`  int(6) NULL DEFAULT NULL COMMENT '还款期限' ,
`repay_method`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '还款方式' ,
`loan_rate`  decimal(10,2) NULL DEFAULT NULL COMMENT '利率' ,
`star_date`  date NULL DEFAULT NULL COMMENT '首期还款日' ,
`last_date`  date NULL DEFAULT NULL COMMENT '最后一期还款日' ,
`left_capital`  decimal(10,2) NULL DEFAULT NULL COMMENT '剩余应还本金' ,
`all_overdue_days`  decimal(10,2) NULL DEFAULT NULL COMMENT '累计逾期天数' ,
`clear_date`  date NULL DEFAULT NULL COMMENT '结清日期' ,
PRIMARY KEY (`loan_id`, `serial_no`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='还款计划'

;

-- ----------------------------
-- Records of repayment_schedule
-- ----------------------------
BEGIN;
INSERT INTO `repayment_schedule` VALUES ('7002522', 'YJCD2017081500002', '0.00', null, '0', null, '0.00', null, null, '0.00', '0.00', null), ('7002524', 'YJCD2017081600007', '30000000.00', '2017-09-24', '12', '先息后本', '8.80', '2017-10-23', '2018-09-24', '0.00', '0.00', null), ('7002526', 'YJCD2017081500001', '0.00', null, '0', null, '0.00', null, null, '0.00', '0.00', null), ('7002527', 'YJCD2017081600006', '460000.00', '2017-09-24', '7', '等额本息', '8.40', '2017-10-23', '2018-04-24', '0.00', '0.00', null), ('7002531', 'YJCD2017082300001', '0.00', null, '0', null, '0.00', null, null, '0.00', '0.00', null), ('7002532', 'YJCD2017081600004', '0.00', null, '0', null, '0.00', null, null, '0.00', '0.00', null), ('7002535', 'YJCD2017081500005', '0.00', null, '0', null, '0.00', null, null, '0.00', '0.00', null);
COMMIT;

-- ----------------------------
-- Table structure for `role_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
`role_id`  int(4) NOT NULL AUTO_INCREMENT COMMENT '角色id' ,
`role_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名' ,
`user_id`  int(4) NULL DEFAULT NULL COMMENT '用户名' ,
`role_comment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '无' COMMENT '角色描述' ,
PRIMARY KEY (`role_id`),
FOREIGN KEY (`user_id`) REFERENCES `account` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `FK_Reference_13` (`user_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='角色表'
AUTO_INCREMENT=1078

;

-- ----------------------------
-- Records of role_info
-- ----------------------------
BEGIN;
INSERT INTO `role_info` VALUES ('1000', '超级管理员', '1000', '超级管理员'), ('1001', '普通管理员', null, '系统管理员'), ('1002', '授信审核专员', null, '授信审核专员'), ('1003', '放款审核专员', null, '放款审核专员'), ('1004', '放款确认专员', null, '放款确认专员'), ('1005', '押品管理专员', null, '押品管理专员'), ('1063', '测试权限', null, '减少权限以测试'), ('1064', '测试角色', null, '测试角色'), ('1065', '授信专员', null, '授信专员干什么'), ('1066', '001', null, '001'), ('1067', '002', null, '002'), ('1068', '003', null, '003'), ('1069', '004', null, '004'), ('1070', '005', null, '005'), ('1071', 'case001', null, '001'), ('1072', '小明测试专用', null, '这是个小明专属的管理员账号'), ('1073', '金融专员', null, '放款确认'), ('1074', '风管审批', null, '审查、审批'), ('1075', '授信审核', null, '授信终审'), ('1076', '123456', null, '测试角色'), ('1077', '大幅度发', null, '的非官方大范甘迪大地飞歌的垫付电饭锅梵蒂冈');
COMMIT;

-- ----------------------------
-- Table structure for `role_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `role_privilege`;
CREATE TABLE `role_privilege` (
`id`  int(4) NOT NULL AUTO_INCREMENT COMMENT 'id' ,
`role_id`  int(4) NULL DEFAULT NULL COMMENT '角色id' ,
`privilege_id`  int(4) NULL DEFAULT NULL COMMENT '权限id' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='角色权限表'
AUTO_INCREMENT=1754

;

-- ----------------------------
-- Records of role_privilege
-- ----------------------------
BEGIN;
INSERT INTO `role_privilege` VALUES ('1213', '1043', null), ('1214', '1043', '1000'), ('1215', '1043', '1001'), ('1216', '1043', '1002'), ('1217', '1043', '1003'), ('1218', '1043', '2000'), ('1219', '1043', '2001'), ('1220', '1043', '2002'), ('1221', '1043', '3000'), ('1222', '1043', '3001'), ('1223', '1043', '3002'), ('1224', '1043', '3003'), ('1225', '1043', '4000'), ('1226', '1043', '4001'), ('1227', '1043', '4001'), ('1228', '1043', '4003'), ('1229', '1043', '4004'), ('1230', '1043', '5000'), ('1231', '1043', '6000'), ('1277', '1046', '1000'), ('1278', '1046', '1001'), ('1279', '1046', '1002'), ('1280', '1046', '1003'), ('1281', '1046', '2000'), ('1282', '1046', '2001'), ('1283', '1046', '2002'), ('1284', '1046', '3000'), ('1285', '1046', '3001'), ('1286', '1046', '3002'), ('1287', '1046', '3003'), ('1288', '1046', '4000'), ('1289', '1046', '4001'), ('1290', '1046', '4001'), ('1291', '1046', '4003'), ('1292', '1046', '4004'), ('1293', '1046', '5000'), ('1294', '1046', '6000'), ('1295', '1056', '1001'), ('1296', '1056', '2002'), ('1297', '1056', '4001'), ('1298', '1056', '4001'), ('1299', '1055', '4001'), ('1300', '1055', '4001'), ('1301', '1000', '1000'), ('1302', '1000', '1001'), ('1303', '1000', '1002'), ('1304', '1000', '1003'), ('1305', '1000', '2000'), ('1306', '1000', '2001'), ('1307', '1000', '2002'), ('1308', '1000', '3000'), ('1309', '1000', '3001'), ('1310', '1000', '3002'), ('1311', '1000', '3003'), ('1312', '1000', '4000'), ('1313', '1000', '4001'), ('1314', '1000', '4002'), ('1315', '1000', '4003'), ('1316', '1000', '4004'), ('1317', '1000', '5000'), ('1318', '1000', '6000'), ('1319', '1061', '2000'), ('1320', '1061', '2001'), ('1321', '1061', '2002'), ('1396', null, '2000'), ('1397', null, '2001'), ('1398', null, '2002'), ('1399', null, '3000'), ('1400', null, '3001'), ('1401', null, '3002'), ('1402', null, '3003'), ('1403', null, '5000'), ('1404', null, '6000'), ('1405', null, '2000'), ('1406', null, '2001'), ('1407', null, '2002'), ('1408', null, '3000'), ('1409', null, '3001'), ('1410', null, '3002'), ('1411', null, '3003'), ('1412', null, '5000'), ('1413', null, '6000'), ('1414', null, '1001'), ('1415', null, '2001'), ('1416', null, '3003'), ('1490', '1045', '1000'), ('1491', '1045', '1002'), ('1492', '1045', '2002'), ('1493', '1045', '2000'), ('1508', '1062', '1000'), ('1509', '1062', '1001'), ('1510', '1062', '1002'), ('1511', '1062', '1003'), ('1512', '1062', '2000'), ('1513', '1062', '2001'), ('1514', '1062', '2002'), ('1515', '1062', '3000'), ('1516', '1062', '3001'), ('1517', '1062', '3002'), ('1518', '1062', '3003');
INSERT INTO `role_privilege` VALUES ('1519', '1062', '4000'), ('1520', '1062', '4001'), ('1521', '1062', '4002'), ('1522', '1062', '4003'), ('1523', '1062', '4004'), ('1524', '1062', '5000'), ('1525', '1062', '6000'), ('1528', '1063', '1000'), ('1529', '1063', '1001'), ('1530', '1063', '1002'), ('1531', '1063', '1003'), ('1532', '1063', '5000'), ('1533', '1063', '6000'), ('1540', '1003', '1002'), ('1541', '1003', '5000'), ('1544', '1065', '1001'), ('1545', '1065', '5000'), ('1557', '1068', '1000'), ('1558', '1068', '1001'), ('1559', '1068', '1002'), ('1560', '1068', '1003'), ('1561', '1068', '2000'), ('1562', '1068', '2001'), ('1563', '1068', '2002'), ('1564', '1068', '3000'), ('1565', '1068', '3001'), ('1566', '1068', '3002'), ('1567', '1068', '3003'), ('1568', '1069', '1000'), ('1569', '1069', '1001'), ('1570', '1069', '1002'), ('1571', '1069', '1003'), ('1572', '1069', '2000'), ('1573', '1069', '2001'), ('1574', '1069', '2002'), ('1575', '1069', '3000'), ('1576', '1069', '3001'), ('1577', '1069', '3002'), ('1578', '1069', '3003'), ('1579', '1069', '4000'), ('1580', '1069', '4001'), ('1581', '1069', '4002'), ('1582', '1070', '1000'), ('1583', '1070', '1001'), ('1584', '1070', '1002'), ('1585', '1070', '1003'), ('1586', '1070', '2000'), ('1587', '1070', '2001'), ('1588', '1070', '2002'), ('1589', '1070', '3000'), ('1590', '1070', '3001'), ('1591', '1070', '3002'), ('1592', '1070', '3003'), ('1593', '1070', '4000'), ('1594', '1070', '4001'), ('1595', '1070', '4002'), ('1596', '1070', '5000'), ('1602', '1067', '1000'), ('1603', '1067', '1001'), ('1604', '1067', '1002'), ('1605', '1067', '1003'), ('1606', '1067', '2000'), ('1607', '1067', '2001'), ('1608', '1067', '2002'), ('1609', '1067', '5000'), ('1641', '1004', '1000'), ('1642', '1004', '1001'), ('1643', '1004', '1002'), ('1644', '1004', '1003'), ('1645', '1004', '2000'), ('1646', '1004', '2001'), ('1647', '1004', '2002'), ('1648', '1004', '3000'), ('1649', '1004', '3001'), ('1650', '1004', '3002'), ('1651', '1004', '3003'), ('1652', '1004', '4000'), ('1653', '1004', '4001'), ('1654', '1004', '4002'), ('1655', '1004', '5000'), ('1656', '1004', '6000'), ('1657', '1072', '1000'), ('1658', '1072', '1001'), ('1659', '1072', '1002'), ('1660', '1072', '1003'), ('1661', '1072', '2000'), ('1662', '1072', '2001'), ('1663', '1072', '2002'), ('1664', '1072', '3000'), ('1665', '1072', '3001'), ('1666', '1072', '3002'), ('1667', '1072', '3003'), ('1668', '1072', '4000'), ('1669', '1072', '4001'), ('1670', '1072', '4002'), ('1671', '1072', '5000'), ('1672', '1072', '6000'), ('1673', '1073', '1000'), ('1674', '1073', '1001'), ('1675', '1073', '1002');
INSERT INTO `role_privilege` VALUES ('1676', '1073', '1003'), ('1677', '1073', '2000'), ('1678', '1073', '2001'), ('1679', '1073', '2002'), ('1680', '1073', '3000'), ('1681', '1073', '3001'), ('1682', '1073', '3002'), ('1683', '1073', '3003'), ('1684', '1073', '4000'), ('1685', '1073', '4001'), ('1686', '1073', '4002'), ('1687', '1073', '5000'), ('1688', '1074', '1001'), ('1689', '1074', '5000'), ('1692', '1064', '5000'), ('1701', '1066', '1001'), ('1702', '1066', '2000'), ('1703', '1066', '2001'), ('1704', '1066', '2002'), ('1705', '1066', '5000'), ('1706', '1002', '1001'), ('1707', '1002', '5000'), ('1708', '1076', '1000'), ('1709', '1076', '1001'), ('1710', '1076', '1002'), ('1711', '1076', '1003'), ('1712', '1076', '2000'), ('1713', '1076', '2001'), ('1714', '1076', '2002'), ('1715', '1076', '5000'), ('1738', '1001', '1000'), ('1739', '1001', '1001'), ('1740', '1001', '1002'), ('1741', '1001', '1003'), ('1742', '1001', '2000'), ('1743', '1001', '2001'), ('1744', '1001', '2002'), ('1745', '1001', '3000'), ('1746', '1001', '3001'), ('1747', '1001', '3002'), ('1748', '1001', '3003'), ('1749', '1001', '4000'), ('1750', '1001', '4001'), ('1751', '1001', '4002'), ('1752', '1001', '5000'), ('1753', '1001', '6000');
COMMIT;

-- ----------------------------
-- Table structure for `service_info`
-- ----------------------------
DROP TABLE IF EXISTS `service_info`;
CREATE TABLE `service_info` (
`type`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`type`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of service_info
-- ----------------------------
BEGIN;
INSERT INTO `service_info` VALUES ('DHL', '贷后类'), ('DYJFKL', '抵押及放款类'), ('SXL', '授信类');
COMMIT;

-- ----------------------------
-- Table structure for `warrant`
-- ----------------------------
DROP TABLE IF EXISTS `warrant`;
CREATE TABLE `warrant` (
`warrant_id`  int(8) NOT NULL AUTO_INCREMENT COMMENT 'id' ,
`warrant_type`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权证类型' ,
`c_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权证号码' ,
`is_complete`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否完整' ,
`Incomplete_reason`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '不完整原因' ,
`issue_dept`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出证机构名称' ,
`issue_date`  date NULL DEFAULT NULL COMMENT '出证时间' ,
`handle_dept`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经办机构' ,
`Storage_dept`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保管机构' ,
`remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`status`  int(2) NULL DEFAULT NULL COMMENT '状态' ,
PRIMARY KEY (`warrant_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='权证信息'
AUTO_INCREMENT=251

;

-- ----------------------------
-- Records of warrant
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- View structure for `afterloanview`
-- ----------------------------
DROP VIEW IF EXISTS `afterloanview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `afterloanview` AS select `a`.`name` AS `name`,`l`.`loan_id` AS `loan_id`,`l`.`e_product` AS `e_product`,`l`.`city` AS `city`,`l`.`loan_money` AS `loan_money`,`l`.`periods` AS `periods`,`l`.`repay_way` AS `repay_way`,`l`.`rate` AS `rate`,`l`.`final_transfer_date` AS `final_transfer_date`,`a`.`id_number` AS `id_number`,`l`.`c_card_number` AS `c_card_number`,`l`.`c_card_bank` AS `c_card_bank`,`l`.`c_card_name` AS `c_card_name`,`l`.`loan_method` AS `loan_method`,`l`.`remark` AS `remark` from (`loan_info` `l` join `applicant_base` `a`) where (`l`.`a_base_id` = `a`.`a_base_id`) ;

-- ----------------------------
-- View structure for `filepathview`
-- ----------------------------
DROP VIEW IF EXISTS `filepathview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `filepathview` AS select `d`.`bus_no` AS `loan_id`,`c`.`service_info_type` AS `service_type`,`c`.`doctype_info_type` AS `doc_type`,`c`.`doc_info_type` AS `doc`,`d`.`name` AS `name` from (`ejie_nbrs`.`doc_info_rel` `c` join (select `b`.`name` AS `name`,`b`.`source` AS `source`,`b`.`sub_type` AS `sub_type`,`b`.`bus_no` AS `bus_no` from (`ejie_nbrs`.`ftp_doc` `a` join `ejie_nbrs`.`images_info` `b`) where (`a`.`bus_no` = `b`.`bus_no`)) `d`) where ((`d`.`source` = `c`.`service_info_type`) and (`d`.`sub_type` = `c`.`doc_info_type`)) ;

-- ----------------------------
-- View structure for `inastatisticalview`
-- ----------------------------
DROP VIEW IF EXISTS `inastatisticalview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `inastatisticalview` AS select `l`.`l_count` AS `l_count`,`l`.`l_pass_count` AS `l_pass_count`,`l`.`l_pay` AS `l_pay`,`l`.`l_pass_pay` AS `l_pass_pay`,`l`.`l_count_rate` AS `l_count_rate`,`l`.`l_pay_rate` AS `l_pay_rate`,`l`.`l_time` AS `l_time`,`c`.`c_count` AS `c_count`,`c`.`c_pass_count` AS `c_pass_count`,`c`.`c_pay` AS `c_pay`,`c`.`c_pass_pay` AS `c_pass_pay`,`c`.`c_count_rate` AS `c_count_rate`,`c`.`c_pay_rate` AS `c_pay_rate`,`c`.`c_time` AS `c_time`,`c`.`c_type` AS `c_type`,`l`.`l_year` AS `year`,`l`.`l_type` AS `l_type` from (`l_form` `l` join `c_form` `c`) where ((`l`.`l_year` = `c`.`c_year`) and (`l`.`l_time` = `c`.`c_time`)) order by `l`.`l_year` desc ;

-- ----------------------------
-- View structure for `loaninfoentity`
-- ----------------------------
DROP VIEW IF EXISTS `loaninfoentity`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `loaninfoentity` AS select `li`.`loan_id` AS `loan_id`,`li`.`app_date` AS `app_date`,`li`.`e_product` AS `e_product`,`li`.`city` AS `city`,`li`.`status` AS `status`,`ab`.`name` AS `name`,`ab`.`id_number` AS `id_number`,`li`.`app_money` AS `app_money`,`li`.`rate` AS `rate`,`li`.`repay_way` AS `repay_way`,`gv`.`ejie_comfirm_value` AS `ejie_comfirm_value`,`gv`.`g_rate` AS `g_rate`,`li`.`grant_credit_date` AS `grant_credit_date`,`li`.`give_moeny_date` AS `give_moeny_date`,`li`.`final_transfer_date` AS `final_transfer_date`,`li`.`serialNo` AS `serialNo` from ((`loan_info` `li` join `applicant_base` `ab`) join `guarantee_value` `gv`) where ((`li`.`serialNo` = `ab`.`serialNo`) and (`li`.`serialNo` = `gv`.`serialNo`)) order by `li`.`loan_id` desc ;

-- ----------------------------
-- View structure for `loanview`
-- ----------------------------
DROP VIEW IF EXISTS `loanview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `loanview` AS select `ap`.`a_base_id` AS `a_base_id`,`ap`.`id_number` AS `id_number`,`ap`.`sex` AS `sex`,`ap`.`nationality` AS `nationality`,`ap`.`birthday` AS `birthday`,`ap`.`phone_number` AS `phone_number`,`ap`.`education_background` AS `education_background`,`ap`.`marital_status` AS `marital_status`,`ap`.`career` AS `career`,`ap`.`permanent_address` AS `permanent_address`,`ap`.`residence_address` AS `residence_address`,`ap`.`name` AS `name`,`lo`.`city` AS `city`,`lo`.`app_date` AS `app_date`,`lo`.`e_product` AS `e_product`,`lo`.`repay_way` AS `repay_way`,`lo`.`app_money` AS `app_money`,`lo`.`rate` AS `rate`,`gr`.`repayment_limit` AS `repayment_limit`,`lo`.`loan_purpose` AS `loan_purpose`,`gu`.`comfirm_value` AS `comfirm_value`,`ap`.`company_name` AS `company_name`,`ap`.`company_address` AS `company_address`,`ap`.`company_property` AS `company_property`,`ap`.`company_dept` AS `company_dept`,`ap`.`company_number` AS `company_number`,`ap`.`years_working` AS `years_working`,`ap`.`monthly_income` AS `monthly_income`,`ap`.`job_title` AS `job_title`,`ma`.`mate_name` AS `mate_name`,`ma`.`mate_id_number` AS `mate_id_number`,`ma`.`mate_phone_number` AS `mate_phone_number`,`ma`.`mate_education_background` AS `mate_education_background`,`ma`.`mate_permanent_address` AS `mate_residence_address`,`ma`.`mate_residence_address` AS `mate_permanent_address`,`lo`.`c_card_number` AS `c_card_number`,`lo`.`c_card_name` AS `c_card_name`,`lo`.`c_card_bank` AS `c_card_bank`,`gr`.`id` AS `id`,`gr`.`real_loan_money` AS `real_loan_money`,`gr`.`loan_method` AS `loan_method`,`gr`.`loan_date` AS `loan_date`,`gr`.`repayment_card_number` AS `repayment_card_number`,`gr`.`cardholder` AS `cardholder`,`gr`.`repayment_bank` AS `repayment_bank`,`gr`.`remark` AS `remark`,`gu`.`g_rate` AS `g_rate`,`lo`.`status` AS `status`,`lo`.`guarantee_id` AS `guarantee_id`,`lo`.`c_a_info_id` AS `c_a_info_id`,`gua`.`mhouse_id` AS `mhouse_id`,`gua`.`mcar_id` AS `mcar_id`,`gr`.`loan_image` AS `loan_image` from (((((`applicant_base` `ap` join `loan_info` `lo`) join `grant_money` `gr`) join `mate_info` `ma`) join `guarantee_value` `gu` on(('' = ''))) join `guarantee` `gua`) where ((`ap`.`a_base_id` = `lo`.`a_base_id`) and (`ap`.`mate_info_id` = `ma`.`mate_info_id`) and (`lo`.`guarantee_id` = `gu`.`guarantee_id`) and (`lo`.`loan_id` = `gr`.`id`) and (`lo`.`loan_id` = `gua`.`loan_id`)) ;

-- ----------------------------
-- View structure for `loanview_copy`
-- ----------------------------
DROP VIEW IF EXISTS `loanview_copy`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `loanview_copy` AS select `ap`.`a_base_id` AS `a_base_id`,`ap`.`id_number` AS `id_number`,`ap`.`sex` AS `sex`,`ap`.`nationality` AS `nationality`,`ap`.`birthday` AS `birthday`,`ap`.`phone_number` AS `phone_number`,`ap`.`education_background` AS `education_background`,`ap`.`marital_status` AS `marital_status`,`ap`.`career` AS `career`,`ap`.`permanent_address` AS `permanent_address`,`ap`.`residence_address` AS `residence_address`,`ap`.`name` AS `name`,`lo`.`city` AS `city`,`lo`.`app_date` AS `app_date`,`lo`.`e_product` AS `e_product`,`lo`.`repay_way` AS `repay_way`,`lo`.`app_money` AS `app_money`,`lo`.`rate` AS `rate`,`gr`.`repayment_limit` AS `repayment_limit`,`lo`.`loan_purpose` AS `loan_purpose`,`gu`.`comfirm_value` AS `comfirm_value`,`ap`.`company_name` AS `company_name`,`ap`.`company_address` AS `company_address`,`ap`.`company_property` AS `company_property`,`ap`.`company_dept` AS `company_dept`,`ap`.`company_number` AS `company_number`,`ap`.`years_working` AS `years_working`,`ap`.`monthly_income` AS `monthly_income`,`ap`.`job_title` AS `job_title`,`ma`.`mate_name` AS `mate_name`,`ma`.`mate_id_number` AS `mate_id_number`,`ma`.`mate_phone_number` AS `mate_phone_number`,`ma`.`mate_education_background` AS `mate_education_background`,`ma`.`mate_permanent_address` AS `mate_residence_address`,`ma`.`mate_residence_address` AS `mate_permanent_address`,`lo`.`c_card_number` AS `c_card_number`,`lo`.`c_card_name` AS `c_card_name`,`lo`.`c_card_bank` AS `c_card_bank`,`gr`.`id` AS `id`,`gr`.`real_loan_money` AS `real_loan_money`,`gr`.`loan_method` AS `loan_method`,`gr`.`loan_date` AS `loan_date`,`gr`.`repayment_card_number` AS `repayment_card_number`,`gr`.`cardholder` AS `cardholder`,`gr`.`repayment_bank` AS `repayment_bank`,`gr`.`remark` AS `remark`,`gu`.`g_rate` AS `g_rate`,`lo`.`status` AS `status`,`lo`.`guarantee_id` AS `guarantee_id`,`lo`.`c_a_info_id` AS `c_a_info_id`,`gua`.`mhouse_id` AS `mhouse_id`,`gua`.`mcar_id` AS `mcar_id`,`gr`.`loan_image` AS `loan_image` from (((((`applicant_base` `ap` join `loan_info` `lo`) join `grant_money` `gr`) join `mate_info` `ma`) join `guarantee_value` `gu` on(('' = ''))) join `guarantee` `gua`) where ((`ap`.`a_base_id` = `lo`.`a_base_id`) and (`ap`.`mate_info_id` = `ma`.`mate_info_id`) and (`lo`.`guarantee_id` = `gu`.`guarantee_id`) and (`lo`.`loan_id` = `gr`.`id`) and (`lo`.`loan_id` = `gua`.`loan_id`)) ;

-- ----------------------------
-- View structure for `newloanview`
-- ----------------------------
DROP VIEW IF EXISTS `newloanview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `newloanview` AS select `ab`.`name` AS `name`,`ab`.`id_number` AS `id_number`,`ab`.`sex` AS `sex`,`ab`.`nationality` AS `nationality`,`ab`.`birthday` AS `birthday`,`ab`.`phone_number` AS `phone_number`,`ab`.`education_background` AS `education_background`,`ab`.`marital_status` AS `marital_status`,`ab`.`career` AS `career`,`ab`.`permanent_address` AS `permanent_address`,`ab`.`residence_address` AS `residence_address`,`ab`.`company_address` AS `company_address`,`ab`.`company_name` AS `company_name`,`ab`.`company_dept` AS `company_dept`,`ab`.`company_property` AS `company_property`,`ab`.`company_number` AS `company_number`,`ab`.`years_working` AS `years_working`,`ab`.`monthly_income` AS `monthly_income`,`ab`.`job_title` AS `job_title`,`li`.`app_date` AS `app_date`,`li`.`e_product` AS `e_product`,`li`.`repay_way` AS `repay_way`,`li`.`app_money` AS `app_money`,`li`.`rate` AS `rate`,`li`.`periods` AS `periods`,`li`.`loan_purpose` AS `loan_purpose`,`ab`.`a_base_id` AS `a_base_id`,`gu`.`mhouse_id` AS `mhouse_id`,`gu`.`mcar_id` AS `mcar_id`,`li`.`loan_id` AS `loan_id`,`li`.`guarantee_id` AS `guarantee_id`,`li`.`final_transfer_date` AS `final_transfer_date`,`li`.`serialNo` AS `serialNo`,`ab`.`mate_info_id` AS `mate_info_id`,`li`.`guarantee_object` AS `guarantee_object`,`li`.`city` AS `city`,`ab`.`bankcardno` AS `bankcardno`,`ab`.`bankname` AS `bankname`,`ab`.`branchBank` AS `branchbank`,`ab`.`cardName` AS `cardholder` from ((`applicant_base` `ab` join `loan_info` `li`) join `guarantee` `gu` on(('' = ''))) where ((`ab`.`serialNo` = `li`.`serialNo`) and (`li`.`serialNo` = `gu`.`serialNo`)) ;

-- ----------------------------
-- View structure for `newstorageview`
-- ----------------------------
DROP VIEW IF EXISTS `newstorageview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `newstorageview` AS select `gm`.`g_id` AS `g_id`,`gm`.`loan_id` AS `loan_id`,`gm`.`final_transfer_date` AS `final_transfer_date`,`gm`.`gm_type` AS `gm_type`,`gm`.`gm_status` AS `gm_status`,`gm`.`gm_app_id` AS `gm_app_id`,`gm`.`gm_in_time` AS `gm_in_time`,`gm`.`out_reason` AS `out_reason`,`gm`.`gm_out_time` AS `gm_out_time`,`gm`.`in_applyTime` AS `in_applyTime`,`gm`.`out_applyTime` AS `out_applyTime`,`gua`.`mhouse_id` AS `mhouse_id`,`mh`.`mhouse_value` AS `mhouse_value`,`mh`.`property_owner` AS `property_owner`,`mh`.`m_h_id` AS `m_h_id`,`gua`.`id` AS `id` from ((`guarantee_management` `gm` join `guarantee` `gua`) join `mortgage_house` `mh`) where ((`gm`.`g_id` = `gua`.`guarantee_id`) and (`gua`.`mhouse_id` = `mh`.`mhouse_id`)) ;

-- ----------------------------
-- View structure for `product_information`
-- ----------------------------
DROP VIEW IF EXISTS `product_information`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `product_information` AS select `mo`.`mortgager_name` AS `mortgager_name`,`mo`.`c_number` AS `c_number`,`mh`.`mhouse_id` AS `mhouse_id`,`mh`.`g_category` AS `g_category`,`mh`.`mhouse_value` AS `mhouse_value`,`mh`.`property_right_number` AS `property_right_number`,`mh`.`property_owner` AS `property_owner`,`mh`.`acreage` AS `acreage`,`mh`.`g_address` AS `g_address`,`mh`.`house_area` AS `house_area`,`gv`.`old_value` AS `old_value`,`wa`.`is_complete` AS `is_complete`,`wa`.`Incomplete_reason` AS `Incomplete_reason`,`wa`.`warrant_type` AS `warrant_type`,`wa`.`issue_dept` AS `issue_dept`,`wa`.`issue_date` AS `issue_date`,`wa`.`Storage_dept` AS `Storage_dept`,`li`.`loan_id` AS `loan_id`,`gm`.`gm_accessory` AS `gm_accessory` from (((((`mortgager` `mo` join `mortgage_house` `mh`) join `guarantee_value` `gv`) join `warrant` `wa`) join `loan_info` `li`) join `guarantee_management` `gm`) where ((`li`.`a_base_id` = `mo`.`a_base_id`) and (`mo`.`m_h_id` = `mh`.`m_h_id`) and (`gm`.`g_id` = `gv`.`guarantee_id`) and (`mh`.`warrant_id` = `wa`.`warrant_id`) and (`gm`.`loan_id` = `li`.`loan_id`)) ;

-- ----------------------------
-- View structure for `product_view`
-- ----------------------------
DROP VIEW IF EXISTS `product_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `product_view` AS select `gm`.`g_id` AS `g_id`,`gm`.`gm_type` AS `gm_type`,`gm`.`loan_id` AS `loan_id`,`gm`.`out_remark` AS `out_remark`,`gv`.`comfirm_value` AS `comfirm_value`,`gv`.`old_value` AS `old_value`,`gm`.`out_reason` AS `out_reason`,`gm`.`g_m_id` AS `g_m_id`,`gua`.`mhouse_id` AS `mhouse_id`,`gr`.`loan_image` AS `loan_image`,`gm`.`in_applyTime` AS `in_applyTime`,`gm`.`out_applyTime` AS `out_applyTime`,`gm`.`gm_accessory` AS `gm_accessory` from (((`guarantee_management` `gm` join `guarantee_value` `gv`) join `guarantee` `gua`) join `grant_money` `gr`) where ((`gm`.`g_id` = `gv`.`guarantee_id`) and (`gm`.`loan_id` = `gua`.`loan_id`) and (`gm`.`loan_id` = `gr`.`loan_id`)) order by `gm`.`g_m_id` ;


-- ----------------------------
-- View structure for `role_privilege list`
-- ----------------------------
DROP VIEW IF EXISTS `role_privilege list`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `role_privilege list` list` AS select `ri`.`role_id` AS `role_id`,`ri`.`role_name` AS `role_name`,`ri`.`role_comment` AS `role_comment`,`pr`.`privilege_id` AS `privilege_id`,`pr`.`privilege_name` AS `privilege_name`,`pr`.`privilege_level` AS `privilege_level`,`pr`.`url` AS `url`,`pr`.`perant_level` AS `perant_level` from ((`privilege` `pr` join `role_info` `ri`) join `role_privilege` `rp`) where ((`rp`.`role_id` = `ri`.`role_id`) and (`rp`.`privilege_id` = `pr`.`privilege_id`)) ;

-- ----------------------------
-- View structure for `userwithrole`
-- ----------------------------
DROP VIEW IF EXISTS `userwithrole`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `userwithrole` AS select `account`.`user_id` AS `user_id`,`account`.`account_name` AS `account_name`,`account`.`user_name` AS `user_name`,`account`.`role_id` AS `role_id`,`account`.`password` AS `password`,`account`.`status` AS `status`,`account`.`status_remark` AS `status_remark`,`role_info`.`role_name` AS `role_name`,`role_info`.`role_comment` AS `role_comment` from (`account` join `role_info`) where (`account`.`role_id` = `role_info`.`role_id`) ;

-- ----------------------------
-- Procedure structure for `creditPro`
-- ----------------------------
DROP PROCEDURE IF EXISTS `creditPro`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `creditPro`(
  	INOUT starttime VARCHAR(20),
  	INOUT endtime VARCHAR(20),
  	INOUT type VARCHAR(20),
	OUT c_count int,
	out c_pass_count int,
	out c_pay DECIMAL(11,2),
	out c_pass_pay DECIMAL(11,2),
	out c_count_rate int,
	out c_pay_rate int
)
BEGIN

	SELECT COUNT(1) INTO c_count FROM loan_info
WHERE loan_info.`status`>0
and loan_info.grant_credit_date >= @starttime
 and loan_info.grant_credit_date <= @endtime;

 	SELECT COUNT(1) INTO c_pass_count FROM loan_info
  WHERE loan_info.`status`>0 AND loan_info.`status` != 2
and loan_info.grant_credit_date >= @starttime
 and loan_info.grant_credit_date <= @endtime;
  
  	SELECT SUM(loan_info.app_money) INTO c_pay FROM loan_info
  WHERE loan_info.`status` >2
and loan_info.grant_credit_date >= @starttime
 and loan_info.grant_credit_date <= @endtime;
 
  	SELECT SUM(loan_info.app_money) INTO c_pass_pay FROM loan_info
  WHERE loan_info.`status` >2 AND loan_info.`status` != 4
and loan_info.grant_credit_date >= @starttime
 and loan_info.grant_credit_date <= @endtime;
  	
  	SELECT (c_pass_count/c_count)*100 INTO c_count_rate;
  
  	SELECT (c_pass_pay/c_pay)*100 INTO c_pay_rate;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `form`
-- ----------------------------
DROP PROCEDURE IF EXISTS `form`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `form`( 
	OUT `c_count` int,
	out c_pass_count int,
	out c_pay DECIMAL(11,2),
	out c_pass_pay DECIMAL(11,2)
)
BEGIN

	SELECT COUNT(1) INTO c_count FROM loan_info
WHERE STATUS>0;

	SELECT COUNT(1) INTO c_pass_count FROM loan_info
WHERE STATUS>0 AND STATUS != 2;

	SELECT SUM(loan_info.app_money) INTO c_pay FROM loan_info
WHERE STATUS >= 0;

	SELECT SUM(loan_info.app_money) INTO c_pass_pay FROM loan_info
WHERE STATUS >0 AND STATUS != 2;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `lendingStatisticsPro`
-- ----------------------------
DROP PROCEDURE IF EXISTS `lendingStatisticsPro`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `lendingStatisticsPro`(
  	IN starttime VARCHAR(20),
		IN endtime VARCHAR(20)
)
BEGIN
	DECLARE applied_amount DECIMAL(11,2);
	DECLARE actual_amount DECIMAL(11,2);
	DECLARE guarantee_amount DECIMAL(11,2);
	DECLARE loan_rate DECIMAL(11,2);
	DECLARE guarantee_rate DECIMAL(11,2);


SELECT SUM(app_money) INTO applied_amount 
FROM loan_info 
WHERE  grant_credit_date>=starttime
AND grant_credit_date<=endtime;

SELECT SUM(loan_money) INTO actual_amount 
FROM loan_info 
WHERE grant_credit_date>=starttime
AND grant_credit_date<=endtime;

SELECT sum(ejie_comfirm_value) INTO guarantee_amount
FROM guarantee_value 
WHERE guarantee_id 
IN
(SELECT guarantee_id 
FROM loan_info 
WHERE  grant_credit_date>=starttime
AND grant_credit_date<=endtime);

SELECT (actual_amount/applied_amount)*100 INTO loan_rate;

SELECT (actual_amount/guarantee_amount)*100 INTO guarantee_rate;

SELECT starttime,endtime,applied_amount,actual_amount,
guarantee_amount,loan_rate,guarantee_rate;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `lo`
-- ----------------------------
DROP PROCEDURE IF EXISTS `lo`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `lo`(
out name1 varchar(225),
in arg date
)
begin

 SELECT city INTO name1 FROM loan_info 
WHERE loan_info.app_date>=arg
LIMIT 1;

end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `loanPro`
-- ----------------------------
DROP PROCEDURE IF EXISTS `loanPro`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `loanPro`(
  	IN starttime VARCHAR(20),
		IN endtime VARCHAR(20),
  	IN type1 VARCHAR(20)
)
BEGIN
	DECLARE l_count int;
	DECLARE l_pass_count int;
	DECLARE l_pay DECIMAL(11,2);
	DECLARE l_pass_pay DECIMAL(11,2);
	DECLARE l_count_rate DECIMAL(11,2);
	DECLARE l_pay_rate DECIMAL(11,2);

	DECLARE c_count int;
	DECLARE c_pass_count int;
	DECLARE c_pay DECIMAL(11,2);
	DECLARE c_pass_pay DECIMAL(11,2);
	DECLARE c_count_rate DECIMAL(11,2);
	DECLARE c_pay_rate DECIMAL(11,2);

IF type1=1 THEN
	SELECT COUNT(1) INTO l_count FROM loan_info
WHERE loan_info.`status`>2
and loan_info.grant_credit_date >= starttime
and loan_info.grant_credit_date <= endtime;

 	SELECT COUNT(1) INTO l_pass_count FROM loan_info
WHERE loan_info.`status`>2 AND loan_info.`status` != 4
and loan_info.grant_credit_date >= starttime
and loan_info.grant_credit_date <= endtime;
  
  	SELECT SUM(loan_info.app_money) INTO l_pay FROM loan_info
WHERE loan_info.`status` >= 0
and loan_info.grant_credit_date >= starttime
and loan_info.grant_credit_date <= endtime;
 
  	SELECT SUM(loan_info.app_money) INTO l_pass_pay FROM loan_info
WHERE loan_info.`status` >0 AND loan_info.`status` != 2
and loan_info.grant_credit_date >= starttime
and loan_info.grant_credit_date <= endtime;
  	
  	SELECT (l_pass_count/l_count)*100 INTO l_count_rate;
  
  	SELECT (l_pass_pay/l_pay)*100 INTO l_pay_rate;

    SELECT starttime,endtime,type1,l_count,l_pass_count ,l_pay,l_pass_pay,l_count_rate,l_pay_rate;

ELSEIF type1=2 THEN

	SELECT COUNT(1) INTO c_count FROM loan_info
WHERE loan_info.`status`>0
and loan_info.grant_credit_date >= starttime
and loan_info.grant_credit_date <= endtime;

 	SELECT COUNT(1) INTO c_pass_count FROM loan_info
WHERE loan_info.`status`>0 AND loan_info.`status` != 2
and loan_info.grant_credit_date >= starttime
and loan_info.grant_credit_date <= endtime;
  
  	SELECT SUM(loan_info.app_money) INTO c_pay FROM loan_info
WHERE loan_info.`status` >2
and loan_info.grant_credit_date >= starttime
and loan_info.grant_credit_date <= endtime;
 
  	SELECT SUM(loan_info.app_money) INTO c_pass_pay FROM loan_info
WHERE loan_info.`status` >2 AND loan_info.`status` != 4
and loan_info.grant_credit_date >= starttime
and loan_info.grant_credit_date <= endtime;
  	
  	SELECT (c_pass_count/c_count)*100 INTO c_count_rate;
  
  	SELECT (c_pass_pay/c_pay)*100 INTO c_pay_rate;

    SELECT starttime,endtime,type1,c_count,c_pass_count ,c_pay,c_pass_pay,c_count_rate,c_pay_rate;

ELSE
	SELECT "没有这个类型";

END IF;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `lp`
-- ----------------------------
DROP PROCEDURE IF EXISTS `lp`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `lp`(
  INOUT time1 VARCHAR(20),
  INOUT time2 VARCHAR(20),
  INOUT type1 VARCHAR(20),
	OUT arg1 INT,
	OUT arg2 INT,
	OUT arg3 DECIMAL(11,2),
	OUT arg4 DECIMAL(11,2),
	OUT arg5 INT,
	OUT arg6 INT,
	OUT arg7 INT
)
BEGIN
	SELECT count(1) INTO arg7 from loan_info
WHERE loan_info.city=@type1;

	SELECT COUNT(1) INTO arg1 FROM loan_info
WHERE loan_info.`status`>2
and loan_info.grant_credit_date >= @time1
 and loan_info.grant_credit_date <= @time2
;

 	SELECT COUNT(1) INTO arg2 FROM loan_info
  WHERE loan_info.`status`>2 AND loan_info.`status` != 4
and loan_info.grant_credit_date >= @time1
 and loan_info.grant_credit_date <= @time2
;
  
  	SELECT SUM(loan_info.app_money) INTO arg3 FROM loan_info
  WHERE loan_info.`status` >= 0
and loan_info.grant_credit_date >= @time1
 and loan_info.grant_credit_date <= @time2
;
 
  	SELECT SUM(loan_info.app_money) INTO arg4 FROM loan_info
  WHERE loan_info.`status` >0 AND loan_info.`status` != 2
and loan_info.grant_credit_date >= @time1
 and loan_info.grant_credit_date <= @time2
;
  	
  	SELECT (arg2/arg1)*100 INTO arg5;
  
  	SELECT (arg4/arg3)*100 INTO arg6;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sel`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sel`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `sel`(
in name1 varchar(225),
out arg int,
  INOUT starttime VARCHAR(20),
  INOUT endtime VARCHAR(20),
  INOUT type1 VARCHAR(20),
	OUT l_count int,
	out l_pass_count int,
	out l_pay DECIMAL(11,2),
	out l_pass_pay DECIMAL(11,2),
	out l_count_rate int,
	out l_pay_rate int,
	out count1 int

)
begin

        SELECT loan_id INTO arg FROM loan_info 
				WHERE loan_info.city=@name1
LIMIT 1;

	SELECT count(1) INTO count1 from loan_info
WHERE loan_info.city=@type1;

	SELECT COUNT(1) INTO l_count FROM loan_info
WHERE loan_info.`status`>2
and loan_info.grant_credit_date >= @starttime
 and loan_info.grant_credit_date <= @endtime
;

 	SELECT COUNT(1) INTO l_pass_count FROM loan_info
  WHERE loan_info.`status`>2 AND loan_info.`status` != 4
and loan_info.grant_credit_date >= @starttime
 and loan_info.grant_credit_date <= @endtime
;
  
  	SELECT SUM(loan_info.app_money) INTO l_pay FROM loan_info
  WHERE loan_info.`status` >= 0
and loan_info.grant_credit_date >= @starttime
 and loan_info.grant_credit_date <= @endtime
;
 
  	SELECT SUM(loan_info.app_money) INTO l_pass_pay FROM loan_info
  WHERE loan_info.`status` >0 AND loan_info.`status` != 2
and loan_info.grant_credit_date >= @starttime
 and loan_info.grant_credit_date <= @endtime
;
  	
  	SELECT (l_pass_count/l_count)*100 INTO l_count_rate;
  
  	SELECT (l_pass_pay/l_pay)*100 INTO l_pay_rate;

end
;;
DELIMITER ;

-- ----------------------------
-- Auto increment value for `account`
-- ----------------------------
ALTER TABLE `account` AUTO_INCREMENT=1097;

-- ----------------------------
-- Auto increment value for `applicant_base`
-- ----------------------------
ALTER TABLE `applicant_base` AUTO_INCREMENT=8003762;

-- ----------------------------
-- Auto increment value for `c_form`
-- ----------------------------
ALTER TABLE `c_form` AUTO_INCREMENT=16;

-- ----------------------------
-- Auto increment value for `common_applicant`
-- ----------------------------
ALTER TABLE `common_applicant` AUTO_INCREMENT=8100956;

-- ----------------------------
-- Auto increment value for `delete_file`
-- ----------------------------
ALTER TABLE `delete_file` AUTO_INCREMENT=145;

-- ----------------------------
-- Auto increment value for `grant_money`
-- ----------------------------
ALTER TABLE `grant_money` AUTO_INCREMENT=7000152;

-- ----------------------------
-- Auto increment value for `guarantee`
-- ----------------------------
ALTER TABLE `guarantee` AUTO_INCREMENT=2976;

-- ----------------------------
-- Auto increment value for `guarantee_management`
-- ----------------------------
ALTER TABLE `guarantee_management` AUTO_INCREMENT=4400114;

-- ----------------------------
-- Auto increment value for `guarantee_value`
-- ----------------------------
ALTER TABLE `guarantee_value` AUTO_INCREMENT=4702413;

-- ----------------------------
-- Auto increment value for `images_info`
-- ----------------------------
ALTER TABLE `images_info` AUTO_INCREMENT=5308;

-- ----------------------------
-- Auto increment value for `l_form`
-- ----------------------------
ALTER TABLE `l_form` AUTO_INCREMENT=16;
DROP TRIGGER IF EXISTS `t_when_loanstatus_change`;
DELIMITER ;;
CREATE TRIGGER `t_when_loanstatus_change` AFTER UPDATE ON `loan_info` FOR EACH ROW BEGIN
      UPDATE  ejie_neworder  SET status=9   where loanid=old.loan_id;
END
;;
DELIMITER ;

-- ----------------------------
-- Auto increment value for `loan_info`
-- ----------------------------
ALTER TABLE `loan_info` AUTO_INCREMENT=7002544;

-- ----------------------------
-- Auto increment value for `loan_product`
-- ----------------------------
ALTER TABLE `loan_product` AUTO_INCREMENT=1000002;

-- ----------------------------
-- Auto increment value for `log_management`
-- ----------------------------
ALTER TABLE `log_management` AUTO_INCREMENT=5000116;

-- ----------------------------
-- Auto increment value for `mate_info`
-- ----------------------------
ALTER TABLE `mate_info` AUTO_INCREMENT=8203552;

-- ----------------------------
-- Auto increment value for `mortgage_car`
-- ----------------------------
ALTER TABLE `mortgage_car` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `mortgage_house`
-- ----------------------------
ALTER TABLE `mortgage_house` AUTO_INCREMENT=2720;

-- ----------------------------
-- Auto increment value for `mortgager`
-- ----------------------------
ALTER TABLE `mortgager` AUTO_INCREMENT=80;

-- ----------------------------
-- Auto increment value for `repay_plan`
-- ----------------------------
ALTER TABLE `repay_plan` AUTO_INCREMENT=715;

-- ----------------------------
-- Auto increment value for `role_info`
-- ----------------------------
ALTER TABLE `role_info` AUTO_INCREMENT=1078;

-- ----------------------------
-- Auto increment value for `role_privilege`
-- ----------------------------
ALTER TABLE `role_privilege` AUTO_INCREMENT=1754;

-- ----------------------------
-- Auto increment value for `warrant`
-- ----------------------------
ALTER TABLE `warrant` AUTO_INCREMENT=251;
