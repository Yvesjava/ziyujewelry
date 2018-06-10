

-- 创建表 product
CREATE TABLE `products`.`goods` (
  `goodsId` INTEGER UNSIGNED NOT NULL,
  `goodsSn` VARCHAR(45) NOT NULL,
  `goodsName` VARCHAR(45) NOT NULL,
  `goodsImg` VARCHAR(45) NOT NULL,
  `goodsDesc` VARCHAR(250) NOT NULL,
  `materId` INTEGER UNSIGNED NOT NULL,
  `goodsTypeId` INTEGER UNSIGNED NOT NULL,
  `mosId` INTEGER UNSIGNED NOT NULL,
  `shopName` VARCHAR(45),
  `markePrice` FLOAT NOT NULL,
  `goodsCost` FLOAT NOT NULL,
  `goodsStock` INTEGER UNSIGNED NOT NULL,
  `saleCount` INTEGER UNSIGNED NOT NULL,
  `isHot` BOOLEAN NOT NULL COMMENT '0否，1是',
  `isNew` BOOLEAN NOT NULL COMMENT '0否，1是',
  PRIMARY KEY (`goodsId`)
)
ENGINE = InnoDB;

--创建表 mater
CREATE TABLE `products`.`mater` (
  `materId` INTEGER UNSIGNED NOT NULL,
  `materName` VARCHAR(45) NOT NULL,
  `materShape` VARCHAR(10) NOT NULL,
  `materCost` FLOAT NOT NULL,
  `materSize` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`materId`)
)
ENGINE = InnoDB;

--创建表 goodsType
CREATE TABLE `products`.`goodsType` (
  `goodsTypeId` INTEGER UNSIGNED NOT NULL,
  `goodsTypeName` VARCHAR(45) NOT NULL,
  `goodsTypeDesc` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`goodsTypeId`)
)
ENGINE = InnoDB;


--创建表 mosaic
CREATE TABLE `products`.`mosaic` (
  `mosId` INTEGER UNSIGNED NOT NULL,
  `mosName` VARCHAR(45) NOT NULL,
  `mosMater` VARCHAR(45) NOT NULL,
  `mosShop` VARCHAR(45) NOT NULL,
  `mosType` VARCHAR(45) NOT NULL,
  `mosMaterCost` FLOAT NOT NULL,
  `isSelfControl` BOOLEAN NOT NULL,
  `mosControlCost` FLOAT NOT NULL,
  `mosDesc` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`mosId`)
)
ENGINE = InnoDB;














-- 创建表 product
CREATE TABLE IF NOT EXISTS `products`.`product` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `pname` VARCHAR(45) NOT NULL,
  `Pid` VARCHAR(45) NULL,
  `cost` INT NULL,
  `price` INT NULL,
  `mater` VARCHAR(45) NULL,
  `jtype` VARCHAR(45) NULL,
  `mosaic` INT NULL,
  `img` VARCHAR(300) NULL,
  `pro_desc` VARCHAR(500) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `pname_UNIQUE` (`pname` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));


--创建表 mater
CREATE TABLE IF NOT EXISTS `products`.`mater` (
  `m_id` INT NOT NULL AUTO_INCREMENT,
  `b_id` VARCHAR(45) NULL,
  `n_mater` VARCHAR(45) NULL,
  `size` VARCHAR(45) NULL,
  `m_cost` INT NULL,
  PRIMARY KEY (`m_id`));

--创建表 jtype 饰品类型表，耳环，手环，项链，分类
CREATE TABLE IF NOT EXISTS `products`.`jtype` (
  `j_id` INT NOT NULL AUTO_INCREMENT,
  `j_type` VARCHAR(45) NULL,
  PRIMARY KEY (`j_id`));

--创建表 mosaic 镶嵌的名称，成本
CREATE TABLE IF NOT EXISTS `products`.`mosaic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mc_name` VARCHAR(100) NULL,
  `mc_cost` INT NULL,
  PRIMARY KEY (`id`))
  AUTO_INCREMENT = 111;
	
alter table mosaic AUTO_INCREMENT = 111;




--在product表中插入一条数据
insert into product(pname,Pid,cost,price,mater,jtype,mosaic,img,pro_desc) 
	values('耳针6咪碧玉','E10101115',57,99,'06biyu','E1',115,'E:/img/id','【碧玉耳钉·走量款】和田玉，阳绿色老料，18k金镶嵌，料子温润细腻，颜色漂亮，品相极好，货量充足。规格：6mm，赠权威证书+礼盒，只赚人气，批发价：100元对');

--在mater表中插入一条数据
insert into mater(b_id,n_mater,size,m_cost)
	values('010106','06biyu','06',6);

--在jtype表中插入一条数据
insert into jtype(j_type)
	values('耳饰');

--在mosaic表中插入一条数据
insert into mosaic(mc_name,mc_cost)
	values('耳针',45);




ALTER TABLE product CHANGE desc descr varchar(500) ;


