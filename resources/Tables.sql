delimiter $$

USE anterp;$$

CREATE TABLE `tbl_account` (
  `accId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'This is primary key.',
  `empName` varchar(32) DEFAULT NULL,
  `accName` varchar(64) NOT NULL,
  `accPwd` varchar(32) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` smallint(6) DEFAULT NULL,
  `phoneNo` varchar(45) DEFAULT NULL,
  `urgentPhone` varchar(45) DEFAULT NULL,
  `address` varchar(512) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT 0,
  `lastModifyTime` timestamp NOT NULL DEFAULT 0,
  PRIMARY KEY (`accId`),
  UNIQUE KEY `acc_name_UNIQUE` (`accName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This is employee account table.';$$

CREATE TABLE `tbl_role` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(32) NOT NULL,
  `description` varchar(128) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastModifyTime` timestamp NOT NULL DEFAULT 0,
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `roleName_UNIQUE` (`roleName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This is role table';$$

CREATE TABLE `tbl_acc_role` (
  `accId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  KEY `fk_account_id` (`accId`),
  KEY `fk_role_id` (`roleId`),
  CONSTRAINT `fk_account_id` FOREIGN KEY (`accId`) REFERENCES `tbl_account` (`accId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_id` FOREIGN KEY (`roleId`) REFERENCES `tbl_role` (`roleId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This table is the relationship of account and role table.';$$


CREATE TABLE `tbl_privilege` (
  `pvgId` int(11) NOT NULL,
  `functionCode` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This is privilege table, the relation between pvgId and functionCode is n:n.';$$

CREATE TABLE `tbl_role_pvg` (
  `roleId` int(11) NOT NULL,
  `pvgId` varchar(45) NOT NULL,
  UNIQUE KEY `roleId_UNIQUE` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This is role privilege table.';$$

CREATE TABLE `tbl_custom` (
  `custId` int(11) NOT NULL AUTO_INCREMENT,
  `custName` varchar(64) DEFAULT NULL,
  `gender` smallint(6) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL,
  `phoneNo` varchar(32) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `familyDesc` varchar(512) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT 0,
  `lastModifyTime` timestamp NOT NULL DEFAULT 0,
  PRIMARY KEY (`custId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This is custom info table.';$$

/* This is role table built-in record. */
INSERT INTO `tbl_role` (roleId,`roleName`,lastModifyTime) VALUES (1,'超级用户','2012-04-21 12:00:00');$$
INSERT INTO `tbl_role` (roleId,`roleName`,lastModifyTime) VALUES (2,'管理层','2012-04-21 12:00:00');$$
INSERT INTO `tbl_role` (roleId,`roleName`,lastModifyTime) VALUES (3,'财务人员','2012-04-21 12:00:00');$$
INSERT INTO `tbl_role` (roleId,`roleName`,lastModifyTime) VALUES (4,'库管','2012-04-21 12:00:00');$$
INSERT INTO `tbl_role` (roleId,`roleName`,lastModifyTime) VALUES (5,'业务员','2012-04-21 12:00:00');$$

