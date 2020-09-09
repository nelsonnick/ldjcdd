DROP TABLE IF EXISTS `ComplaintLetter`;
CREATE TABLE `ComplaintLetter`
(
    `id`             int(11)                          NOT NULL AUTO_INCREMENT COMMENT '序号',
    `PersonName`     varchar(255) CHARACTER SET utf8  NULL COMMENT '人员姓名',
    `PersonNumber`   varchar(255) CHARACTER SET utf8  NULL COMMENT '证件号码',
    `PersonAge`      varchar(255) CHARACTER SET utf8  NULL COMMENT '当前年龄',
    `PersonSex`      varchar(255) CHARACTER SET utf8  NULL COMMENT '人员性别',
    `PersonPhone`    varchar(255) CHARACTER SET utf8  NULL COMMENT '联系电话',
    `PersonAddress`  varchar(500) CHARACTER SET utf8  NULL COMMENT '家庭住址',
    `ComplaintDate`  datetime                         NULL COMMENT '投诉时间',
    `CompanyName`    varchar(255) CHARACTER SET utf8  NULL COMMENT '公司名称',
    `CompanyAddress` varchar(500) CHARACTER SET utf8  NULL COMMENT '公司地址',
    `LegalName`      varchar(255) CHARACTER SET utf8  NULL COMMENT '法人姓名',
    `LegalPosition`  varchar(255) CHARACTER SET utf8  NULL COMMENT '法人职务',
    `LegalPhone`     varchar(255) CHARACTER SET utf8  NULL COMMENT '法人电话',
    `PersonnelName`  varchar(255) CHARACTER SET utf8  NULL COMMENT '人事姓名',
    `PersonnelPhone` varchar(255) CHARACTER SET utf8  NULL COMMENT '人事电话',
    `AppealMatter`   varchar(3000) CHARACTER SET utf8 NULL COMMENT '诉求事项',
    `FactReason`     varchar(3000) CHARACTER SET utf8 NULL COMMENT '事实理由',
    PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `FillingCase`;
CREATE TABLE `FilingCase`
(
    `id`             int(11)                          NOT NULL AUTO_INCREMENT COMMENT '序号',
    `PersonName`     varchar(255) CHARACTER SET utf8  NULL COMMENT '人员姓名',
    `PersonNumber`   varchar(255) CHARACTER SET utf8  NULL COMMENT '证件号码',
    `PersonAge`      varchar(255) CHARACTER SET utf8  NULL COMMENT '当前年龄',
    `PersonSex`      varchar(255) CHARACTER SET utf8  NULL COMMENT '人员性别',
    `PersonPhone`    varchar(255) CHARACTER SET utf8  NULL COMMENT '联系电话',
    `PersonAddress`  varchar(500) CHARACTER SET utf8  NULL COMMENT '家庭住址',
    `ComplaintDate`  datetime                         NULL COMMENT '投诉时间',
    `CompanyName`    varchar(255) CHARACTER SET utf8  NULL COMMENT '公司名称',
    `CompanyAddress` varchar(500) CHARACTER SET utf8  NULL COMMENT '公司地址',
    `LegalName`      varchar(255) CHARACTER SET utf8  NULL COMMENT '法人姓名',
    `LegalPosition`  varchar(255) CHARACTER SET utf8  NULL COMMENT '法人职务',
    `LegalPhone`     varchar(255) CHARACTER SET utf8  NULL COMMENT '法人电话',
    `PersonnelName`  varchar(255) CHARACTER SET utf8  NULL COMMENT '人事姓名',
    `PersonnelPhone` varchar(255) CHARACTER SET utf8  NULL COMMENT '人事电话',
    `AppealMatter`   varchar(3000) CHARACTER SET utf8 NULL COMMENT '诉求事项',
    `FactReason`     varchar(3000) CHARACTER SET utf8 NULL COMMENT '事实理由',
    PRIMARY KEY (`id`)
);