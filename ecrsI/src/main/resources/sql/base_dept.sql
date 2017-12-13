
drop table if exists mate_info;
/*==============================================================*/
/* Table: mate_info                                             */
/*==============================================================*/
create table mate_info
(
   mate_info_id         int(8) not null auto_increment comment 'mate_info_id',
   mate_name            varchar(20) comment '配偶姓名',
   mate_id_number       varchar(20) comment '证件号',
   mate_phone_number    varchar(14) comment '电话',
   mate_education_background varchar(10) comment '学历',
   mate_permanent_address varchar(200) comment '户籍地址',
   mate_residence_address varchar(200) comment '居住地址',
   primary key (mate_info_id)
)ENGINE=INNODB AUTO_INCREMENT=8200000 DEFAULT CHARSET=utf8 COMMENT='配偶信息';

drop table if exists applicant_base;
/*==============================================================*/
/* Table: applicant_base                                        */
/*==============================================================*/
create table applicant_base
(
   a_base_id            int(8) not null auto_increment comment 'a_base_id',
   name                 varchar(20) comment '借款人姓名',
   id_type              varchar(18) comment '证件类型',
   id_number            varchar(20) comment '证件号',
   nationality          varchar(20) comment '民族',
   sex                  char(2) comment '性别',
   birthday             date comment '出生年月',
   marital_status       varchar(20) comment '婚姻状况',
   mate_info_id         int(8) comment '配偶信息',
   education_background varchar(10) comment '学历',
   career               varchar(20) comment '职业',
   company_address      varchar(100) comment '单位地址',
   company_name         varchar(100) comment '单位名称',
   company_dept         varchar(100) comment '所在部门',
   monthly_income       varchar(20) comment '月收入',
   years_working        varchar(10) comment '工作年限',
   company_number       varchar(14) comment '单位电话',
   job_title            varchar(50) comment '职务',
   company_property     varchar(20) comment '单位性质',
   phone_number         varchar(14) comment '电话',
   permanent_address    varchar(200) comment '居住地址',
   residence_address    varchar(200) comment '户籍地址',
   primary key (a_base_id)
)ENGINE=INNODB AUTO_INCREMENT=8000000 DEFAULT CHARSET=utf8 COMMENT='主借人信息';

drop table if exists common_applicant;
/*==============================================================*/
/* Table: common_applicant                                      */
/*==============================================================*/
create table common_applicant
(
   c_a_info_id          int(8) auto_increment comment 'c_a_info_id',
   c_a_name             varchar(20) comment '共借款人姓名',
   c_a_relationship     varchar(20) comment '与借贷人关系',
   c_a_age              char(2) comment '性别',
   c_a_id_number        varchar(20) comment '证件号',
   c_a_phone_number     varchar(14) comment '电话',
   c_a_residence_address varchar(200) comment '居住地址',
   primary key (c_a_info_id)
)ENGINE=INNODB AUTO_INCREMENT=8100000 DEFAULT CHARSET=utf8 COMMENT='共同申请人';

drop table if exists applicant_info;
/*==============================================================*/
/* Table: applicant_info                                        */
/*==============================================================*/
create table applicant_info
(
   id                   int(8)   auto_increment comment 'id',
   id_image             varchar(200) comment '身份证正反面',
   household_registe    varchar(200) comment '户口本',
   marriage_certificate varchar(200) comment '婚姻证明',
   approval_form        varchar(200) comment '贷款申请审批表',
   creditInvestigation_authorization varchar(200) comment '个人征信等信息查询及使用授权书',
   visa_interview_image varchar(200) comment '金融专员面签照片',
   creditInvestigation_detail varchar(200) comment '个人征信详尽版原件',
   informationdulogement_abstract varchar(200) comment '房屋信息摘要3原件',
   house_proprietary_certificate varchar(200) comment '房产证',
   loan_use_image       varchar(200) comment '贷款用途证明文件',
   assess_information   varchar(200) comment '下户照片及易捷评估信息',
   primary key (id)
)ENGINE=INNODB AUTO_INCREMENT=8300000 DEFAULT CHARSET=utf8 COMMENT='贷款申请人资料';


drop table if exists loan_info;
/*==============================================================*/
/* Table: loan_info      贷款信息表                                       */
/*==============================================================*/
create table loan_info
(
   loan_id              int(10) AUTO_INCREMENT not null comment '贷款编号',
   city                 varchar(20) comment '业务城市',
   app_date             date comment '申请时间',
   e_product            varchar(20) comment '贷款产品',
   repay_way            varchar(20) comment '还款方式',
   app_money            decimal(11,2) comment '申请金额',
   rate                 varchar(20) comment '平台及利率',
   periods              int(2) comment '期数',
   loan_purpose         varchar(20) comment '资金用途',
   loan_money           decimal(11,2) comment '下款总额',
   a_base_id            int(8) comment '主借人',
   c_a_info_id          int(8) comment '共借款人',
   guarantee_id         int(8) comment '抵押物id',
   c_card_number        varchar(20) comment '卡号',
   c_card_bank          varchar(20) comment '开户行',
   c_card_name          varchar(20) comment '持卡人',
   loan_method          varchar(20) comment '放款方式',
   status               int(2) comment '当前状态:  0 ：授信终审-待审核 ，1：授信终审-通过/待放款审批，2：授信终审-未通过，3：放款审批-通过/待放款，4：放款审批-未通过，5：放款确认-已放款，6：放款确认-拒绝放款',
   pay_certificate      varchar(20) comment '放款凭证',
   grant_credit_date    date comment '授信审核时间',
   give_moeny_date      date comment '放款审核时间',
   final_transfer_date  date comment '放款时间',
   remark               varchar(2000) comment '备注',
   primary key (loan_id)
)ENGINE=INNODB AUTO_INCREMENT=7000000 DEFAULT CHARSET=utf8 COMMENT='贷款信息表';

INSERT INTO `loan_info`(city,app_date,e_product,repay_way,app_money,rate,periods,loan_purpose,loan_money,a_base_id,c_a_info_id,guarantee_id,loan_date,c_card_number, c_card_bank,c_card_name,loan_method,status,pay_certificate,remark) 
VALUES 
( '成都', '2017-7-13', '车贷', '等额本金', 10000.88, '芝麻5%', 1, '买房', 8000.88, 10001, 10002, 10003, '2017-7-12', '6220000000221', '成都农业银行', '小张', '一次性放款', 0, 'image.url', '借款8个月......'),
( '北京', '2017-7-17', '房贷', '等额本息', 120000.33, '黄瓜4%', 1, '买车', 110000.33, 10022, 10023, 10024, '2017-7-17', '6220000000224', '成都工商银行', '小李', '分期放款', 0, 'image.url', '立方米那边的美女'),
( '伤害', '2017-7-17', '房贷', '等额本息', 200000.01, '冬瓜7%', 1, '结婚', 150000.01, 10033, 10034, 10035, '2017-7-17', '6220000000335', '成都银行', '小红', '分期放款', 0, 'Images.url', '第三方可接受的空间');

drop table if exists grant_money;
/*==============================================================*/
/* Table: grant_money                                           */
/*==============================================================*/
create table grant_money
(
   id                   int(8) auto_increment comment '贷款编号',
   real_loan_money      decimal(11,2) comment '实际放款金额',
   loan_method          varchar(50) comment '放款模式',
   loan_date            date comment '放款日期',
   loan_image           varchar(100) comment '放款凭证',
   repayment_method     varchar(20) comment '还款方式',
   repayment_limit      varchar(20) comment '还款期限',
   repayment_card_number varchar(20) comment '卡号',
   repayment_bank       varchar(20) comment '开户行',
   cardholder           varchar(20) comment '持卡人',
   remark               varchar(2000) comment '备注',
   primary key (id)
)ENGINE=INNODB AUTO_INCREMENT=7200000 DEFAULT CHARSET=utf8 COMMENT='放款信息';

drop table if exists data_recheck;
/*==============================================================*/
/* Table: data_recheck                                          */
/*==============================================================*/
create table data_recheck
(
   id                   int(8) not null auto_increment comment 'id',
   documental_number    int(10) comment '文档编号',
   loan_procuct         varchar(20) comment '贷款产品',
   applicant_city       varchar(10) comment '业务城市',
   applicant_name       varchar(12) comment '申请人',
   applicant_number     int(11) comment '联系电话',
   applicant_amount     decimal(11,2) comment '申请金额（元）',
   assess_amount        decimal(11,2) comment '评估金额（元）',
   final_amount         decimal(11,2) comment '审批放款金额',
   impawn_rate          int(2) comment '抵押率',
   primary key (id)
)ENGINE=INNODB AUTO_INCREMENT=7300000 DEFAULT CHARSET=utf8 COMMENT='资料复审';

drop table if exists repayment_schedule;
/*==============================================================*/
/* Table: repayment_schedule                                    */
/*==============================================================*/
create table repayment_schedule
(
   id                   int(10) primary key auto_increment,
   loan_id              int(10) comment '贷款编号',
   periods              int(2) comment '期数',
   repayment_date       date comment '还款日期',
   principal            decimal(10,2) comment '本金（万元）',
   interest             decimal(10,2) comment '利息（万元）',
   late_fee             decimal(10,2) comment '违约金（万元）',
   mast_pay             decimal(10,2) comment '本期应还（万元）',
   already_pay          decimal(10,2) comment '本期已还（万元）',
   remark               varchar(100) comment 'remark'
)ENGINE=INNODB AUTO_INCREMENT=7100000 DEFAULT CHARSET=utf8 COMMENT='还款计划';




/*--------------------------------------抵押物相关-------------------------------*/


drop table if exists warrant;
/*==============================================================*/
/* Table: warrant     权证信息                                           */
/*==============================================================*/
create table warrant
(
   warrant_id           int(8) AUTO_INCREMENT comment 'id',
   warrant_type         varchar(15) comment '权证类型',
   c_type               varchar(50) comment '权证号码',
   is_complete          varchar(50) comment '是否完整',
   Incomplete_reason    varchar(500) comment '不完整原因',
   issue_dept           varchar(100) comment '出证机构名称',
   issue_date           date comment '出证时间',
   handle_dept          varchar(500) comment '经办机构',
   Storage_dept         varchar(500) comment '保管机构',
   remark               varchar(500) comment '备注',
   status               int(2) comment '状态',
   primary key (warrant_id)
)ENGINE=INNODB AUTO_INCREMENT=4300000 DEFAULT CHARSET=utf8 COMMENT='权证信息';


drop table if exists mortgage_car;
/*==============================================================*/
/* Table: mortgage_car                                          */
/*==============================================================*/
create table mortgage_car
(
	 m_c_id                int(8)  primary key   AUTO_INCREMENT comment 'id',
   mcar_id              varchar(20) comment '抵押车编号',
   mcar_brand           varchar(20) comment '品牌',
   mcar_version         varchar(20) comment '型号',
   license_plate_number varchar(10) comment '车牌号',
   mcar_vin             varchar(20) comment '车架号',
   mcar_engine_number   varchar(20) comment '发动机号',
   mcar_buy_date        date comment '购之日期',
   mcar_buy_price       decimal(11,2) comment '购置金额',
   status               char(1) comment '状态(待入库、入库申请中、已入库、出库申请中、已出库)',
   warrant_id           int(8)  comment '权证信息'
)ENGINE=INNODB AUTO_INCREMENT=4100000 DEFAULT CHARSET=utf8 COMMENT='抵押车信息';

drop table if exists mortgage_house;
/*==============================================================*/
/* Table: mortgage_house                                        */
/*==============================================================*/
create table mortgage_house
(
	 m_h_id int(8)       primary key   AUTO_INCREMENT comment 'id',
   mhouse_id            varchar(20)  comment '抵押物编号',
   g_category           varchar(20) comment '抵押品类别',
   mhouse_value         decimal(10,2) comment '抵押物评估值',
   property_right_number varchar(20) comment '产权证号',
   property_owner       varchar(50) comment '产权人',
   acreage              decimal(10,2) comment '面积',
   g_address            varchar(100) comment '产权地址',
   and_status           varchar(20) comment '押品土地性质',
   house_area           varchar(100) comment '房屋区域',
   land_certificate     varchar(100) comment '土地证书',
   get_method           varchar(20) comment '获取方式',
   warrant_id           int(8) comment '权证信息',
   status               char(1) comment '状态(待入库、入库申请中、已入库、出库申请中、已出库)'
)ENGINE=INNODB AUTO_INCREMENT=4200000 DEFAULT CHARSET=utf8 COMMENT='抵押房';

drop table if exists guarantee;
/*==============================================================*/
/* Table: guarantee                                             */
/*==============================================================*/
create table guarantee
(
		id                  int(8) primary key AUTO_INCREMENT ,
   guarantee_id         int(8)  ,
   loan_id              int(8) comment '贷款编号',
   mhouse_id            varchar(20) comment '抵押房屋',
   mcar_id              varchar(20) comment '抵押车'
   
)ENGINE=INNODB AUTO_INCREMENT=4000000 DEFAULT CHARSET=utf8 COMMENT='抵押物';

drop table if exists mortgager;

/*==============================================================*/
/* Table: mortgager                                             */
/*==============================================================*/
create table mortgager
(
   mortgager_id         int(8)  primary key AUTO_INCREMENT comment '编号',
   m_h_id               int(8) comment '抵押房编号',
   m_c_id               int(8) comment '抵押车编号',
   mortgager_name       varchar(15) comment '抵押人姓名',
   c_type               varchar(50) comment '证件类型',
   c_number             varchar(50) comment '证件号码',
   a_base_id            int(8) comment '主借人id',
   c_a_info_id          char(10)
)ENGINE=INNODB AUTO_INCREMENT=4800000 DEFAULT CHARSET=utf8 COMMENT='抵押人';

drop table if exists guarantee_value;
/*==============================================================*/
/* Table: guarantee_value                                       */
/*==============================================================*/
create table guarantee_value
(
   gua_v_id             int(8)  primary key  AUTO_INCREMENT comment 'id',
   guarantee_id         int(8) comment '抵押物编号',
   old_value            decimal(11,2) comment '押品原值',
   ejie_comfirm_value   decimal(11,2) comment '中介评估价值',
   comfirm_value        decimal(11,2) comment '资方确认价值',
   comfirm_date         date comment '确认时间',
   g_status             varchar(100) comment '抵押品状态',
   g_rate               float(2,2) comment '抵押率'
  
)ENGINE=INNODB AUTO_INCREMENT=4700000 DEFAULT CHARSET=utf8 COMMENT='抵押物价值';


DROP TABLE IF EXISTS `repay_plan`;

CREATE TABLE `repay_plan` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `serial_no` varchar(60) DEFAULT NULL COMMENT '流水号',
  `loan_id` int(11) DEFAULT NULL COMMENT '贷款编号',
  `p_index` int(4) DEFAULT NULL COMMENT '分期数',
  `repay_date` date DEFAULT NULL COMMENT '还款日期本月',
  `capital` decimal(10,2) DEFAULT NULL COMMENT '本金',
  `interest` decimal(10,2) DEFAULT NULL COMMENT '利息',
  `total` decimal(10,2) DEFAULT NULL COMMENT '档期已还总额',
  `complete_date` date DEFAULT NULL COMMENT '本期完成日期，未完成则传递空字符',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=620 DEFAULT CHARSET=utf8;



insert  into `repay_plan`(`id`,`serial_no`,`loan_id`,`p_index`,`repay_date`,`capital`,`interest`,`total`,`complete_date`) values (582,'YJCD2017081600007',7002524,1,'2017-10-26',0.00,234666.67,0.00,NULL),(583,'YJCD2017081600007',7002524,2,'2017-11-26',0.00,227333.33,0.00,NULL),(584,'YJCD2017081600007',7002524,3,'2017-12-26',0.00,220000.00,0.00,NULL),(585,'YJCD2017081600007',7002524,4,'2018-01-26',0.00,227333.33,0.00,NULL),(586,'YJCD2017081600007',7002524,5,'2018-02-26',0.00,227333.33,0.00,NULL),(587,'YJCD2017081600007',7002524,6,'2018-03-26',0.00,205333.33,0.00,NULL),(588,'YJCD2017081600007',7002524,7,'2018-04-26',0.00,227333.33,0.00,NULL),(589,'YJCD2017081600007',7002524,8,'2018-05-26',0.00,220000.00,0.00,NULL),(590,'YJCD2017081600007',7002524,9,'2018-06-26',0.00,227333.33,0.00,NULL),(591,'YJCD2017081600007',7002524,10,'2018-07-26',0.00,220000.00,0.00,NULL),(592,'YJCD2017081600007',7002524,11,'2018-08-26',0.00,227333.33,0.00,NULL),(593,'YJCD2017081600007',7002524,12,'2018-09-24',30000000.00,212666.67,0.00,NULL),(594,'YJCD2017081600007',7002524,1,'2017-10-26',0.00,234666.67,0.00,NULL),(595,'YJCD2017081600007',7002524,2,'2017-11-26',0.00,227333.33,0.00,NULL),(596,'YJCD2017081600007',7002524,3,'2017-12-26',0.00,220000.00,0.00,NULL),(597,'YJCD2017081600007',7002524,4,'2018-01-26',0.00,227333.33,0.00,NULL),(598,'YJCD2017081600007',7002524,5,'2018-02-26',0.00,227333.33,0.00,NULL),(599,'YJCD2017081600007',7002524,6,'2018-03-26',0.00,205333.33,0.00,NULL),(600,'YJCD2017081600007',7002524,7,'2018-04-26',0.00,227333.33,0.00,NULL),(601,'YJCD2017081600007',7002524,8,'2018-05-26',0.00,220000.00,0.00,NULL),(602,'YJCD2017081600007',7002524,9,'2018-06-26',0.00,227333.33,0.00,NULL),(603,'YJCD2017081600007',7002524,10,'2018-07-26',0.00,220000.00,0.00,NULL),(604,'YJCD2017081600007',7002524,11,'2018-08-26',0.00,227333.33,0.00,NULL),(605,'YJCD2017081600007',7002524,12,'2018-09-24',30000000.00,212666.67,0.00,NULL),(606,'YJCD2017081600006',7002527,1,'2017-10-26',64181.63,3434.67,0.00,NULL),(607,'YJCD2017081600006',7002527,2,'2017-11-26',64753.21,2863.09,0.00,NULL),(608,'YJCD2017081600006',7002527,3,'2017-12-26',65298.84,2317.46,0.00,NULL),(609,'YJCD2017081600006',7002527,4,'2018-01-26',65693.92,1922.38,0.00,NULL),(610,'YJCD2017081600006',7002527,5,'2018-02-26',66169.11,1447.19,0.00,NULL),(611,'YJCD2017081600006',7002527,6,'2018-03-26',66741.47,874.83,0.00,NULL),(612,'YJCD2017081600006',7002527,7,'2018-04-24',67161.82,454.46,0.00,NULL),(613,'YJCD2017081600006',7002527,1,'2017-10-26',64181.63,3434.67,0.00,NULL),(614,'YJCD2017081600006',7002527,2,'2017-11-26',64753.21,2863.09,0.00,NULL),(615,'YJCD2017081600006',7002527,3,'2017-12-26',65298.84,2317.46,0.00,NULL),(616,'YJCD2017081600006',7002527,4,'2018-01-26',65693.92,1922.38,0.00,NULL),(617,'YJCD2017081600006',7002527,5,'2018-02-26',66169.11,1447.19,0.00,NULL),(618,'YJCD2017081600006',7002527,6,'2018-03-26',66741.47,874.83,0.00,NULL),(619,'YJCD2017081600006',7002527,7,'2018-04-24',67161.82,454.46,0.00,NULL);



DROP TABLE IF EXISTS `repayment_schedule`;

CREATE TABLE `repayment_schedule` (
  `loan_id` int(10) NOT NULL COMMENT '贷款编号',
  `serial_no` varchar(60) NOT NULL COMMENT '业务流水号',
  `loan_amount` decimal(10,2) DEFAULT NULL COMMENT '期数',
  `loan_date` date DEFAULT NULL COMMENT '放款日期',
  `repay_limit` int(6) DEFAULT NULL COMMENT '还款期限',
  `repay_method` varchar(10) DEFAULT NULL COMMENT '还款方式',
  `loan_rate` decimal(10,2) DEFAULT NULL COMMENT '利率',
  `star_date` date DEFAULT NULL COMMENT '首期还款日',
  `last_date` date DEFAULT NULL COMMENT '最后一期还款日',
  `left_capital` decimal(10,2) DEFAULT NULL COMMENT '剩余应还本金',
  `all_overdue_days` decimal(10,2) DEFAULT NULL COMMENT '累计逾期天数',
  `clear_date` date DEFAULT NULL COMMENT '结清日期',
  PRIMARY KEY (`loan_id`,`serial_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='还款计划';



insert  into `repayment_schedule`(`loan_id`,`serial_no`,`loan_amount`,`loan_date`,`repay_limit`,`repay_method`,`loan_rate`,`star_date`,`last_date`,`left_capital`,`all_overdue_days`,`clear_date`) values (7002522,'YJCD2017081500002',0.00,NULL,0,NULL,0.00,NULL,NULL,0.00,0.00,NULL),(7002524,'YJCD2017081600007',30000000.00,'2017-09-24',12,'先息后本',8.80,'2017-10-23','2018-09-24',0.00,0.00,NULL),(7002526,'YJCD2017081500001',0.00,NULL,0,NULL,0.00,NULL,NULL,0.00,0.00,NULL),(7002527,'YJCD2017081600006',460000.00,'2017-09-24',7,'等额本息',8.40,'2017-10-23','2018-04-24',0.00,0.00,NULL),(7002531,'YJCD2017082300001',0.00,NULL,0,NULL,0.00,NULL,NULL,0.00,0.00,NULL),(7002532,'YJCD2017081600004',0.00,NULL,0,NULL,0.00,NULL,NULL,0.00,0.00,NULL),(7002535,'YJCD2017081500005',0.00,NULL,0,NULL,0.00,NULL,NULL,0.00,0.00,NULL);




