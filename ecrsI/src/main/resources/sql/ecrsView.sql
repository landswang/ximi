-- ----------------------------
-- View structure for `afterloanview`贷后管理
-- ----------------------------
DROP VIEW
IF EXISTS `afterloanview`;

CREATE ALGORITHM = UNDEFINED DEFINER = `nbrs`@`%` SQL SECURITY DEFINER VIEW `afterloanview` AS SELECT
	`a`.`name` AS `name`,
	`l`.`loan_id` AS `loan_id`,
	`l`.`e_product` AS `e_product`,
	`l`.`city` AS `city`,
	`l`.`loan_money` AS `loan_money`,
	`l`.`periods` AS `periods`,
	`l`.`repay_way` AS `repay_way`,
	`l`.`rate` AS `rate`,
	`l`.`final_transfer_date` AS `final_transfer_date`,
	`a`.`id_number` AS `id_number`,
	`l`.`c_card_number` AS `c_card_number`,
	`l`.`c_card_bank` AS `c_card_bank`,
	`l`.`c_card_name` AS `c_card_name`,
	`l`.`loan_method` AS `loan_method`,
	`l`.`remark` AS `remark`,
	`r`.`repayment_date` AS `repayment_date`,
	`r`.`principal` AS `principal`,
	`r`.`interest` AS `interest`,
	`r`.`late_fee` AS `late_fee`,
	`r`.`mast_pay` AS `mast_pay`,
	`r`.`already_pay` AS `already_pay`
FROM
	(
		(
			`loan_info` `l`
			JOIN `applicant_base` `a`
		)
		JOIN `repayment_schedule` `r`
	)
WHERE
	(
		(
			`l`.`a_base_id` = `a`.`a_base_id`
		)
		AND (
			`l`.`loan_id` = `r`.`loan_id`
		)
	);

-- ----------------------------
-- View structure for `filepathview`
-- ----------------------------
DROP VIEW
IF EXISTS `filepathview`;

CREATE ALGORITHM = UNDEFINED DEFINER = `nbrs`@`%` SQL SECURITY DEFINER VIEW `filepathview` AS SELECT
	`d`.`bus_no` AS `loan_id`,                  --流水号
	`c`.`service_info_type` AS `service_type`,  --服务类型       授信类等
	`c`.`doctype_info_type` AS `doc_type`,      --文档资料类型   身份类等
	`c`.`doc_info_type` AS `doc`,               --资料类型         身份证 户口本 等
	`d`.`name` AS `name`                        --文件相对路径      jpg等
FROM
	(
		`ejie_nbrs`.`doc_info_rel` `c`     --文件三个属性  比如授信类 身份类 身份证  
		JOIN (
			SELECT
				`b`.`name` AS `name`,         --文件相对路径        文件相对路径
				`b`.`source` AS `source`,     --对应xml字段source   授信类等 
				`b`.`sub_type` AS `sub_type`, --对应xml字段sub_type 户口本等
				`b`.`bus_no` AS `bus_no`      --对应xml字段bus_no   流水号
			FROM
				(
					`ejie_nbrs`.`ftp_doc` `a`
					JOIN `ejie_nbrs`.`images_info` `b` 
				)
			WHERE
				(`a`.`bus_no` = `b`.`bus_no`)
		) `d`
	)
WHERE
	(
		(
			`d`.`source` = `c`.`service_info_type`
		)
		AND (
			`d`.`sub_type` = `c`.`doc_info_type`
		)
	);

-- ----------------------------
-- View structure for `inastatisticalview`
-- ----------------------------
DROP VIEW
IF EXISTS `inastatisticalview`;

CREATE ALGORITHM = UNDEFINED DEFINER = `nbrs`@`%` SQL SECURITY DEFINER VIEW `inastatisticalview` AS SELECT
	`l`.`l_count` AS `l_count`,
	`l`.`l_pass_count` AS `l_pass_count`,
	`l`.`l_pay` AS `l_pay`,
	`l`.`l_pass_pay` AS `l_pass_pay`,
	`l`.`l_count_rate` AS `l_count_rate`,
	`l`.`l_pay_rate` AS `l_pay_rate`,
	`l`.`l_time` AS `l_time`,
	`c`.`c_count` AS `c_count`,
	`c`.`c_pass_count` AS `c_pass_count`,
	`c`.`c_pay` AS `c_pay`,
	`c`.`c_pass_pay` AS `c_pass_pay`,
	`c`.`c_count_rate` AS `c_count_rate`,
	`c`.`c_pay_rate` AS `c_pay_rate`,
	`c`.`c_time` AS `c_time`,
	`c`.`c_type` AS `c_type`,
	`l`.`l_year` AS `year`,
	`l`.`l_type` AS `l_type`
FROM
	(`l_form` `l` JOIN `c_form` `c`)
WHERE
	(
		(`l`.`l_year` = `c`.`c_year`)
		AND (`l`.`l_time` = `c`.`c_time`)
	)
ORDER BY
	`l`.`l_year` DESC;

-- ----------------------------
-- View structure for `loaninfoentity`贷款审批基本视图
-- ----------------------------
DROP VIEW
IF EXISTS `loaninfoentity`;

CREATE ALGORITHM = UNDEFINED DEFINER = `nbrs`@`%` SQL SECURITY DEFINER VIEW `loaninfoentity` AS SELECT
	`li`.`loan_id` AS `loan_id`,
	`li`.`app_date` AS `app_date`,
	`li`.`e_product` AS `e_product`,
	`li`.`city` AS `city`,
	`li`.`status` AS `status`,
	`ab`.`name` AS `name`,
	`ab`.`id_number` AS `id_number`,
	`li`.`app_money` AS `app_money`,
	`li`.`rate` AS `rate`,
	`li`.`repay_way` AS `repay_way`,
	`gv`.`ejie_comfirm_value` AS `ejie_comfirm_value`,
	`gv`.`g_rate` AS `g_rate`,
	`li`.`grant_credit_date` AS `grant_credit_date`,
	`li`.`give_moeny_date` AS `give_moeny_date`,
	`li`.`final_transfer_date` AS `final_transfer_date`,
	`li`.`serialNo` AS `serialNo`
FROM
	(
		(
			`loan_info` `li`
			JOIN `applicant_base` `ab`
		)
		JOIN `guarantee_value` `gv`
	)
WHERE
	(
		(
			`li`.`serialNo` = `ab`.`serialNo`
		)
		AND (
			`li`.`serialNo` = `gv`.`serialNo`
		)
	)
ORDER BY
	`li`.`loan_id` DESC;

-- ----------------------------
-- View structure for `loanview`贷款详细信息（旧）
-- ----------------------------
DROP VIEW
IF EXISTS `loanview`;

CREATE ALGORITHM = UNDEFINED DEFINER = `nbrs`@`%` SQL SECURITY DEFINER VIEW `loanview` AS SELECT
	`ap`.`a_base_id` AS `a_base_id`,
	`ap`.`id_number` AS `id_number`,
	`ap`.`sex` AS `sex`,
	`ap`.`nationality` AS `nationality`,
	`ap`.`birthday` AS `birthday`,
	`ap`.`phone_number` AS `phone_number`,
	`ap`.`education_background` AS `education_background`,
	`ap`.`marital_status` AS `marital_status`,
	`ap`.`career` AS `career`,
	`ap`.`permanent_address` AS `permanent_address`,
	`ap`.`residence_address` AS `residence_address`,
	`ap`.`name` AS `name`,
	`lo`.`city` AS `city`,
	`lo`.`app_date` AS `app_date`,
	`lo`.`e_product` AS `e_product`,
	`lo`.`repay_way` AS `repay_way`,
	`lo`.`app_money` AS `app_money`,
	`lo`.`rate` AS `rate`,
	`gr`.`repayment_limit` AS `repayment_limit`,
	`lo`.`loan_purpose` AS `loan_purpose`,
	`gu`.`comfirm_value` AS `comfirm_value`,
	`ap`.`company_name` AS `company_name`,
	`ap`.`company_address` AS `company_address`,
	`ap`.`company_property` AS `company_property`,
	`ap`.`company_dept` AS `company_dept`,
	`ap`.`company_number` AS `company_number`,
	`ap`.`years_working` AS `years_working`,
	`ap`.`monthly_income` AS `monthly_income`,
	`ap`.`job_title` AS `job_title`,
	`ma`.`mate_name` AS `mate_name`,
	`ma`.`mate_id_number` AS `mate_id_number`,
	`ma`.`mate_phone_number` AS `mate_phone_number`,
	`ma`.`mate_education_background` AS `mate_education_background`,
	`ma`.`mate_permanent_address` AS `mate_residence_address`,
	`ma`.`mate_residence_address` AS `mate_permanent_address`,
	`lo`.`c_card_number` AS `c_card_number`,
	`lo`.`c_card_name` AS `c_card_name`,
	`lo`.`c_card_bank` AS `c_card_bank`,
	`gr`.`id` AS `id`,
	`gr`.`real_loan_money` AS `real_loan_money`,
	`gr`.`loan_method` AS `loan_method`,
	`gr`.`loan_date` AS `loan_date`,
	`gr`.`repayment_card_number` AS `repayment_card_number`,
	`gr`.`cardholder` AS `cardholder`,
	`gr`.`repayment_bank` AS `repayment_bank`,
	`gr`.`remark` AS `remark`,
	`gu`.`g_rate` AS `g_rate`,
	`lo`.`status` AS `status`,
	`lo`.`guarantee_id` AS `guarantee_id`,
	`lo`.`c_a_info_id` AS `c_a_info_id`,
	`gua`.`mhouse_id` AS `mhouse_id`,
	`gua`.`mcar_id` AS `mcar_id`,
	`gr`.`loan_image` AS `loan_image`
FROM
	(
		(
			(
				(
					(
						`applicant_base` `ap`
						JOIN `loan_info` `lo`
					)
					JOIN `grant_money` `gr`
				)
				JOIN `mate_info` `ma`
			)
			JOIN `guarantee_value` `gu` ON (('' = ''))
		)
		JOIN `guarantee` `gua`
	)
WHERE
	(
		(
			`ap`.`a_base_id` = `lo`.`a_base_id`
		)
		AND (
			`ap`.`mate_info_id` = `ma`.`mate_info_id`
		)
		AND (
			`lo`.`guarantee_id` = `gu`.`guarantee_id`
		)
		AND (`lo`.`loan_id` = `gr`.`id`)
		AND (
			`lo`.`loan_id` = `gua`.`loan_id`
		)
	);

-- ----------------------------
-- View structure for `loanview_copy`贷款详细信息（旧）
-- ----------------------------
DROP VIEW
IF EXISTS `loanview_copy`;

CREATE ALGORITHM = UNDEFINED DEFINER = `nbrs`@`%` SQL SECURITY DEFINER VIEW `loanview_copy` AS SELECT
	`ap`.`a_base_id` AS `a_base_id`,
	`ap`.`id_number` AS `id_number`,
	`ap`.`sex` AS `sex`,
	`ap`.`nationality` AS `nationality`,
	`ap`.`birthday` AS `birthday`,
	`ap`.`phone_number` AS `phone_number`,
	`ap`.`education_background` AS `education_background`,
	`ap`.`marital_status` AS `marital_status`,
	`ap`.`career` AS `career`,
	`ap`.`permanent_address` AS `permanent_address`,
	`ap`.`residence_address` AS `residence_address`,
	`ap`.`name` AS `name`,
	`lo`.`city` AS `city`,
	`lo`.`app_date` AS `app_date`,
	`lo`.`e_product` AS `e_product`,
	`lo`.`repay_way` AS `repay_way`,
	`lo`.`app_money` AS `app_money`,
	`lo`.`rate` AS `rate`,
	`gr`.`repayment_limit` AS `repayment_limit`,
	`lo`.`loan_purpose` AS `loan_purpose`,
	`gu`.`comfirm_value` AS `comfirm_value`,
	`ap`.`company_name` AS `company_name`,
	`ap`.`company_address` AS `company_address`,
	`ap`.`company_property` AS `company_property`,
	`ap`.`company_dept` AS `company_dept`,
	`ap`.`company_number` AS `company_number`,
	`ap`.`years_working` AS `years_working`,
	`ap`.`monthly_income` AS `monthly_income`,
	`ap`.`job_title` AS `job_title`,
	`ma`.`mate_name` AS `mate_name`,
	`ma`.`mate_id_number` AS `mate_id_number`,
	`ma`.`mate_phone_number` AS `mate_phone_number`,
	`ma`.`mate_education_background` AS `mate_education_background`,
	`ma`.`mate_permanent_address` AS `mate_residence_address`,
	`ma`.`mate_residence_address` AS `mate_permanent_address`,
	`lo`.`c_card_number` AS `c_card_number`,
	`lo`.`c_card_name` AS `c_card_name`,
	`lo`.`c_card_bank` AS `c_card_bank`,
	`gr`.`id` AS `id`,
	`gr`.`real_loan_money` AS `real_loan_money`,
	`gr`.`loan_method` AS `loan_method`,
	`gr`.`loan_date` AS `loan_date`,
	`gr`.`repayment_card_number` AS `repayment_card_number`,
	`gr`.`cardholder` AS `cardholder`,
	`gr`.`repayment_bank` AS `repayment_bank`,
	`gr`.`remark` AS `remark`,
	`gu`.`g_rate` AS `g_rate`,
	`lo`.`status` AS `status`,
	`lo`.`guarantee_id` AS `guarantee_id`,
	`lo`.`c_a_info_id` AS `c_a_info_id`,
	`gua`.`mhouse_id` AS `mhouse_id`,
	`gua`.`mcar_id` AS `mcar_id`,
	`gr`.`loan_image` AS `loan_image`
FROM
	(
		(
			(
				(
					(
						`applicant_base` `ap`
						JOIN `loan_info` `lo`
					)
					JOIN `grant_money` `gr`
				)
				JOIN `mate_info` `ma`
			)
			JOIN `guarantee_value` `gu` ON (('' = ''))
		)
		JOIN `guarantee` `gua`
	)
WHERE
	(
		(
			`ap`.`a_base_id` = `lo`.`a_base_id`
		)
		AND (
			`ap`.`mate_info_id` = `ma`.`mate_info_id`
		)
		AND (
			`lo`.`guarantee_id` = `gu`.`guarantee_id`
		)
		AND (`lo`.`loan_id` = `gr`.`id`)
		AND (
			`lo`.`loan_id` = `gua`.`loan_id`
		)
	);

-- ----------------------------
-- View structure for `newloanview`贷款关联详细信息视图
-- ----------------------------
DROP VIEW
IF EXISTS `newloanview`;

CREATE ALGORITHM = UNDEFINED DEFINER = `nbrs`@`%` SQL SECURITY DEFINER VIEW `newloanview` AS SELECT
	`ab`.`name` AS `name`,
	`ab`.`id_number` AS `id_number`,
	`ab`.`sex` AS `sex`,
	`ab`.`nationality` AS `nationality`,
	`ab`.`birthday` AS `birthday`,
	`ab`.`phone_number` AS `phone_number`,
	`ab`.`education_background` AS `education_background`,
	`ab`.`marital_status` AS `marital_status`,
	`ab`.`career` AS `career`,
	`ab`.`permanent_address` AS `permanent_address`,
	`ab`.`residence_address` AS `residence_address`,
	`ab`.`company_address` AS `company_address`,
	`ab`.`company_name` AS `company_name`,
	`ab`.`company_dept` AS `company_dept`,
	`ab`.`company_property` AS `company_property`,
	`ab`.`company_number` AS `company_number`,
	`ab`.`years_working` AS `years_working`,
	`ab`.`monthly_income` AS `monthly_income`,
	`ab`.`job_title` AS `job_title`,
	`li`.`app_date` AS `app_date`,
	`li`.`e_product` AS `e_product`,
	`li`.`repay_way` AS `repay_way`,
	`li`.`app_money` AS `app_money`,
	`li`.`rate` AS `rate`,
	`li`.`periods` AS `periods`,
	`li`.`loan_purpose` AS `loan_purpose`,
	`li`.`c_card_number` AS `c_card_number`,
	`li`.`c_card_name` AS `c_card_name`,
	`li`.`c_card_bank` AS `c_card_bank`,
	`ab`.`a_base_id` AS `a_base_id`,
	`gu`.`mhouse_id` AS `mhouse_id`,
	`gu`.`mcar_id` AS `mcar_id`,
	`li`.`loan_id` AS `loan_id`,
	`li`.`guarantee_id` AS `guarantee_id`,
	`li`.`final_transfer_date` AS `final_transfer_date`,
	`li`.`serialNo` AS `serialNo`,
	`ab`.`mate_info_id` AS `mate_info_id`,
	`li`.`guarantee_object` AS `guarantee_object`,
	`li`.`city` AS `city`
FROM
	(
		(
			`applicant_base` `ab`
			JOIN `loan_info` `li`
		)
		JOIN `guarantee` `gu` ON (('' = ''))
	)
WHERE
	(
		(
			`ab`.`serialNo` = `li`.`serialNo`
		)
		AND (
			`li`.`serialNo` = `gu`.`serialNo`
		)
	);

-- ----------------------------
-- View structure for `newstorageview`押品出入库基本信息视图
-- ----------------------------
DROP VIEW
IF EXISTS `newstorageview`;

CREATE ALGORITHM = UNDEFINED DEFINER = `nbrs`@`%` SQL SECURITY DEFINER VIEW `newstorageview` AS SELECT
	`gm`.`g_id` AS `g_id`,
	`gm`.`loan_id` AS `loan_id`,
	`gm`.`final_transfer_date` AS `final_transfer_date`,
	`gm`.`gm_type` AS `gm_type`,
	`gm`.`gm_status` AS `gm_status`,
	`gm`.`gm_app_id` AS `gm_app_id`,
	`gm`.`gm_in_time` AS `gm_in_time`,
	`gm`.`out_reason` AS `out_reason`,
	`gm`.`gm_out_time` AS `gm_out_time`,
	`gm`.`in_applyTime` AS `in_applyTime`,
	`gm`.`out_applyTime` AS `out_applyTime`,
	`gua`.`mhouse_id` AS `mhouse_id`,
	`mh`.`mhouse_value` AS `mhouse_value`,
	`mh`.`property_owner` AS `property_owner`,
	`mh`.`m_h_id` AS `m_h_id`
FROM
	(
		(
			`guarantee_management` `gm`
			JOIN `guarantee` `gua`
		)
		JOIN `mortgage_house` `mh`
	)
WHERE
	(
		(
			`gm`.`g_id` = `gua`.`guarantee_id`
		)
		AND (
			`gua`.`mhouse_id` = `mh`.`mhouse_id`
		)
	);

-- ----------------------------
-- View structure for `product_information`押品详细信息视图
-- ----------------------------
DROP VIEW
IF EXISTS `product_information`;

CREATE ALGORITHM = UNDEFINED DEFINER = `nbrs`@`%` SQL SECURITY DEFINER VIEW `product_information` AS SELECT
	`mo`.`mortgager_name` AS `mortgager_name`,
	`mo`.`c_number` AS `c_number`,
	`mh`.`mhouse_id` AS `mhouse_id`,
	`mh`.`g_category` AS `g_category`,
	`mh`.`mhouse_value` AS `mhouse_value`,
	`mh`.`property_right_number` AS `property_right_number`,
	`mh`.`property_owner` AS `property_owner`,
	`mh`.`acreage` AS `acreage`,
	`mh`.`g_address` AS `g_address`,
	`mh`.`house_area` AS `house_area`,
	`gv`.`old_value` AS `old_value`,
	`wa`.`is_complete` AS `is_complete`,
	`wa`.`Incomplete_reason` AS `Incomplete_reason`,
	`wa`.`warrant_type` AS `warrant_type`,
	`wa`.`issue_dept` AS `issue_dept`,
	`wa`.`issue_date` AS `issue_date`,
	`wa`.`Storage_dept` AS `Storage_dept`,
	`li`.`loan_id` AS `loan_id`,
	`gm`.`introductce_accessory` AS `introductce_accessory`,
	`gm`.`logoff_accessory` AS `logoff_accessory`,
	`gm`.`clean_accessory` AS `clean_accessory`,
	`gm`.`other_accessory` AS `other_accessory`
FROM
	(
		(
			(
				(
					(
						`mortgager` `mo`
						JOIN `mortgage_house` `mh`
					)
					JOIN `guarantee_value` `gv`
				)
				JOIN `warrant` `wa`
			)
			JOIN `loan_info` `li`
		)
		JOIN `guarantee_management` `gm`
	)
WHERE
	(
		(
			`li`.`a_base_id` = `mo`.`a_base_id`
		)
		AND (
			`mo`.`m_h_id` = `mh`.`m_h_id`
		)
		AND (
			`gm`.`g_id` = `gv`.`guarantee_id`
		)
		AND (
			`mh`.`warrant_id` = `wa`.`warrant_id`
		)
		AND (
			`gm`.`loan_id` = `li`.`loan_id`
		)
	);

-- ----------------------------
-- View structure for `product_view`出入库基本信息
-- ----------------------------
DROP VIEW
IF EXISTS `product_view`;

CREATE ALGORITHM = UNDEFINED DEFINER = `nbrs`@`%` SQL SECURITY DEFINER VIEW `product_view` AS SELECT
	`gm`.`g_id` AS `g_id`,
	`gm`.`gm_type` AS `gm_type`,
	`gm`.`loan_id` AS `loan_id`,
	`gm`.`out_remark` AS `out_remark`,
	`gv`.`comfirm_value` AS `comfirm_value`,
	`gv`.`old_value` AS `old_value`,
	`gm`.`out_reason` AS `out_reason`,
	`gm`.`introductce_accessory` AS `introductce_accessory`,
	`gm`.`logoff_accessory` AS `logoff_accessory`,
	`gm`.`clean_accessory` AS `clean_accessory`,
	`gm`.`other_accessory` AS `other_accessory`,
	`gm`.`g_m_id` AS `g_m_id`,
	`gua`.`mhouse_id` AS `mhouse_id`,
	`gr`.`loan_image` AS `loan_image`
FROM
	(
		(
			(
				`guarantee_management` `gm`
				JOIN `guarantee_value` `gv`
			)
			JOIN `guarantee` `gua`
		)
		JOIN `grant_money` `gr`
	)
WHERE
	(
		(
			`gm`.`g_id` = `gv`.`guarantee_id`
		)
		AND (
			`gm`.`loan_id` = `gua`.`loan_id`
		)
		AND (
			`gm`.`loan_id` = `gr`.`loan_id`
		)
	)
ORDER BY
	`gm`.`g_m_id`;


-- ----------------------------
-- View structure for `role_privilege list`
-- ----------------------------
DROP VIEW
IF EXISTS `role_privilege list`;

CREATE ALGORITHM = UNDEFINED DEFINER = `nbrs`@`%` SQL SECURITY DEFINER VIEW `role_privilege list` list ` AS select ` ri `.` role_id ` AS ` role_id `,` ri `.` role_name ` AS ` role_name `,` ri `.` role_comment ` AS ` role_comment `,` pr `.` privilege_id ` AS ` privilege_id `,` pr `.` privilege_name ` AS ` privilege_name `,` pr `.` privilege_level ` AS ` privilege_level `,` pr `.` url ` AS ` url `,` pr `.` perant_level ` AS ` perant_level ` from ((` privilege ` ` pr ` join ` role_info ` ` ri `) join ` role_privilege ` ` rp `) where ((` rp `.` role_id ` = ` ri `.` role_id `) and (` rp `.` privilege_id ` = ` pr `.` privilege_id `)) ;

-- ----------------------------
-- View structure for ` userwithrole `
-- ----------------------------
DROP VIEW IF EXISTS ` userwithrole `;
CREATE ALGORITHM=UNDEFINED DEFINER=` nbrs `@` % ` SQL SECURITY DEFINER VIEW ` userwithrole ` AS select ` account `.` user_id ` AS ` user_id `,` account `.` account_name ` AS ` account_name `,` account `.` user_name ` AS ` user_name `,` account `.` role_id ` AS ` role_id `,` account `.` PASSWORD ` AS ` PASSWORD `,` account `.` STATUS ` AS ` STATUS `,` account `.` status_remark ` AS ` status_remark `,` role_info `.` role_name ` AS ` role_name `,` role_info `.` role_comment ` AS ` role_comment ` from (` account ` join ` role_info `) where (` account `.` role_id ` = ` role_info `.` role_id `) ;