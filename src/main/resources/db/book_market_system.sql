/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : book_market_system

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 17/12/2019 20:17:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL COMMENT '用户id',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `amount` double(11, 0) NULL DEFAULT NULL COMMENT '总金额',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bill_book
-- ----------------------------
DROP TABLE IF EXISTS `bill_book`;
CREATE TABLE `bill_book`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bill_id` int(10) NOT NULL COMMENT '订单id',
  `book_id` int(10) NOT NULL COMMENT '图书id',
  `count` int(10) NOT NULL COMMENT '数量',
  `amount` double(11, 0) NULL DEFAULT NULL COMMENT '金额(数量*单价)',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书名',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原作者',
  `press` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出版社',
  `translation_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '翻译作者',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `menu_id` int(10) NULL DEFAULT NULL COMMENT '菜单id',
  `simple_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简略图的地址',
  `price` double(11, 0) NOT NULL COMMENT '单价',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '活着', '余华', '南海出版公司', NULL, '文学小说', 1, '/img/simple/1.jpg', 39, '2019-12-09 20:28:50', NULL, NULL, NULL);
INSERT INTO `book` VALUES (2, '三体', '刘慈欣', '重庆出版社', NULL, '科幻小说', 1, '/img/simple/2.jpg', 49, '2019-12-09 20:28:52', NULL, NULL, NULL);
INSERT INTO `book` VALUES (3, '追风筝的人', '卡勒德胡赛尼', '上海人民出版社', '李继宏', '文学', 1, '/img/simple/3.jpg', 31, NULL, '', NULL, '');
INSERT INTO `book` VALUES (4, '小王子', '圣埃克絮佩里', '辽宁少年儿童出版社', '张荣梅', '文学', 1, '/img/simple/4.jpg', 15, NULL, '', NULL, '');
INSERT INTO `book` VALUES (5, '百年孤独', '加西亚马尔克斯', '南海出版社', '范晔', '文学', 1, '/img/simple/5.jpg', 36, NULL, '', NULL, '');
INSERT INTO `book` VALUES (6, '月亮与六便士', '毛姆', '时代文艺出版社', '苏忠福', '文学', 1, '/img/simple/6.jpg', 34, NULL, '', NULL, '');
INSERT INTO `book` VALUES (7, '鲁滨孙漂流记', '丹尼尔笛福', '浙江工商大学出版社', '王晋华', '文学', 1, '/img/simple/7.jpg', 20, NULL, '', NULL, '');
INSERT INTO `book` VALUES (8, '老人与海', '海明威', '时代文艺出版社', '张炽恒', '文学', 1, '/img/simple/8.jpg', 28, NULL, '', NULL, '');
INSERT INTO `book` VALUES (9, '傲慢与偏见', '奥斯丁', '西安交通大学', '孙智礼', '文学', 1, '/img/simple/9.jpg', 25, NULL, '', NULL, '');
INSERT INTO `book` VALUES (10, '简爱', '夏洛蒂勃朗特', '时代文艺出版社', '宋兆麟', '文学', 1, '/img/simple/10.jpg', 52, NULL, '', NULL, '');
INSERT INTO `book` VALUES (11, '球状闪电', '刘慈欣', '四川科技出版社', '', '流行', 2, '/img/simple/11.jpg', 18, NULL, '', NULL, '');
INSERT INTO `book` VALUES (12, '流浪地球', '刘慈欣', '浙江教育出版社', '', '流行', 2, '/img/simple/12.jpg', 22, NULL, '', NULL, '');
INSERT INTO `book` VALUES (13, '解忧杂货店', '东野圭吾', '南海出版社', '刘姿君', '流行', 2, '/img/simple/13.jpg', 30, NULL, '', NULL, '');
INSERT INTO `book` VALUES (14, '白夜行', '东野圭吾', '南海出版社', '刘姿君', '流行', 2, '/img/simple/14.jpg', 45, NULL, '', NULL, '');
INSERT INTO `book` VALUES (15, '最好的我们', '八月长安', '长江文艺出版社', '', '流行', 2, '/img/simple/15.jpg', 111, NULL, '', NULL, '');
INSERT INTO `book` VALUES (16, '悟空传', '今何在', '北京联合出版社', '', '流行', 2, '/img/simple/16.jpg', 18, NULL, '', NULL, '');
INSERT INTO `book` VALUES (17, '麦田里的守望者', 'JD塞林格', '译林出版社', '施咸荣', '流行', 2, '/img/simple/17.jpg', 40, NULL, '', NULL, '');
INSERT INTO `book` VALUES (18, ' 从你的全世界路过', '张嘉佳', '湖南文艺出版社', '', '流行', 2, '/img/simple/18.jpg', 26, NULL, '', NULL, '');
INSERT INTO `book` VALUES (19, '海贼王', '尾田荣一郎', '浙江人民美术出版社', '', '流行', 2, '/img/simple/19.jpg', 114, NULL, '', NULL, '');
INSERT INTO `book` VALUES (20, '此间的少年', '江南', '长江出版社', '', '流行', 2, '/img/simple/20.jpg', 29, NULL, '', NULL, '');
INSERT INTO `book` VALUES (21, '黄帝内经', '姚春鹏', '中华书局', '', '生活', 3, '/img/simple/21.jpg', 98, NULL, '', NULL, '');
INSERT INTO `book` VALUES (22, '学会呼吸', ']帕特里克·麦基翁', '中国友谊出版社', '李相哲、胡萍 后浪', '生活', 3, '/img/simple/22.jpg', 45, NULL, '', NULL, '');
INSERT INTO `book` VALUES (23, '你是吃出来的', '夏萌', '江西科学技术出版社', '', '生活', 3, '/img/simple/23.jpg', 43, NULL, '', NULL, '');
INSERT INTO `book` VALUES (24, '饮食的迷思', '蒂姆·斯佩克特 ', '广西师范大学出版社', '李超群', '生活', 3, '/img/simple/24.jpg', 49, NULL, '', NULL, '');
INSERT INTO `book` VALUES (25, '优雅老去', '杰罗尔德·温特', '人民卫生出版社', '闫少华', '生活', 3, '/img/simple/25.jpg', 55, NULL, '', NULL, '');
INSERT INTO `book` VALUES (26, '谷物大脑', '泊尔玛特', '机械工业出版社', '温旻', '生活', 3, '/img/simple/26.jpg', 42, NULL, '', NULL, '');
INSERT INTO `book` VALUES (27, '终生健身', '马可·博尔赫斯', '中国友谊出版社', '黄温馨 陈思鹏 后浪', '生活', 3, '/img/simple/27.jpg', 45, NULL, '', NULL, '');
INSERT INTO `book` VALUES (28, '斯坦福高效睡眠法', '西野精致', '文化发展出版社', '', '生活', 3, '/img/simple/28.jpg', 39, NULL, '', NULL, '');
INSERT INTO `book` VALUES (29, '救命饮食', '坎贝尔', '中信出版社', ' 吕奕欣，倪婉君', '生活', 3, '/img/simple/29.jpg', 45, NULL, '', NULL, '');
INSERT INTO `book` VALUES (30, '中国居民膳食指南', '中国营养学会', '人民卫生出版社', '', '生活', 3, '/img/simple/30.jpg', 59, NULL, '', NULL, '');
INSERT INTO `book` VALUES (31, '富爸爸，穷爸爸', '罗伯特·清崎', '四川人民出版社', '萧明', '经管', 4, '/img/simple/31.jpg', 67, NULL, '', NULL, '');
INSERT INTO `book` VALUES (32, '聪明的投资者', '本杰明·格雷厄姆 ', '人民邮电出版社', '刘建位', '经管', 4, '/img/simple/32.jpg', 44, NULL, '', NULL, '');
INSERT INTO `book` VALUES (33, '证券分析', '本杰明·格雷厄姆', '四川人民出版社', '', '经管', 4, '/img/simple/33.jpg', 160, NULL, '', NULL, '');
INSERT INTO `book` VALUES (34, '炒股的智慧', '陈江挺', '商务印书馆', '', '经管', 4, '/img/simple/34.jpg', 18, NULL, '', NULL, '');
INSERT INTO `book` VALUES (35, '小狗钱钱', '博多·舍费尔 ', '四川少儿出版社', '', '经管', 4, '/img/simple/35.jpg', 52, NULL, '', NULL, '');
INSERT INTO `book` VALUES (36, '贫穷的本质', '阿比吉特·班纳吉', '中信出版社', '', '经管', 4, '/img/simple/36.jpg', 54, NULL, '', NULL, '');
INSERT INTO `book` VALUES (37, '美国陷阱', '弗雷德里克·皮耶鲁齐', '中信出版社', '', '经管', 4, '/img/simple/37.jpg', 64, NULL, '', NULL, '');
INSERT INTO `book` VALUES (38, '经济学原理', '曼昆', '北京大学出版社', '梁小民', '经管', 4, '/img/simple/38.jpg', 90, NULL, '', NULL, '');
INSERT INTO `book` VALUES (39, '原则', '瑞·达利欧', '中信出版社', '', '经管', 4, '/img/simple/39.jpg', 92, NULL, '', NULL, '');
INSERT INTO `book` VALUES (40, '卓有成效的管理者', '彼得德鲁克', '机械工业出版社', '宋强', '经管', 4, '/img/simple/40.jpg', 52, NULL, '', NULL, '');
INSERT INTO `book` VALUES (41, '浪潮之巅', '吴军', '人民邮电出版社', '', '科技', 5, '/img/simple/41.jpg', 96, NULL, '', NULL, '');
INSERT INTO `book` VALUES (42, '坏血', '约翰·卡雷鲁', '北京联合出版社', '', '科技', 5, '/img/simple/42.jpg', 39, NULL, '', NULL, '');
INSERT INTO `book` VALUES (43, '智能时代', '吴军', '中信出版社', '', '科技', 5, '/img/simple/43.jpg', 54, NULL, '', NULL, '');
INSERT INTO `book` VALUES (44, '全球科技通史', '吴军', '中信出版社', '', '科技', 5, '/img/simple/44.jpg', 83, NULL, '', NULL, '');
INSERT INTO `book` VALUES (45, '永久记录', '爱德华斯诺登', '民主与建设出版社', '', '科技', 5, '/img/simple/45.jpg', 34, NULL, '', NULL, '');
INSERT INTO `book` VALUES (46, '必然', '周峰', '电子工业出版社', '', '科技', 5, '/img/simple/46.jpg', 74, NULL, '', NULL, '');
INSERT INTO `book` VALUES (47, '硅谷钢铁侠', '阿什利·万斯', '中信出版社', '周恒星、罗庆朗', '科技', 5, '/img/simple/47.jpg', 64, NULL, '', NULL, '');
INSERT INTO `book` VALUES (48, '技术的本质', '布莱恩·阿瑟', '浙江人民出版社', '曹东溟，王健', '科技', 5, '/img/simple/48.jpg', 75, NULL, '', NULL, '');
INSERT INTO `book` VALUES (49, '迷人的材料', '马克·米奥多尼克', '天津科学技术出版社', '赖盈满', '科技', 5, '/img/simple/49.jpg', 47, NULL, '', NULL, '');
INSERT INTO `book` VALUES (50, '创新者', '沃尔特·艾萨克森 ', '中信出版社', '关嘉伟，牛小婧 ', '科技', 5, '/img/simple/50.jpg', 83, NULL, '', NULL, '');

-- ----------------------------
-- Table structure for book_detail
-- ----------------------------
DROP TABLE IF EXISTS `book_detail`;
CREATE TABLE `book_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL COMMENT 'book的id',
  `detail_img_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细图片的地址',
  `content` varchar(1023) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_detail
-- ----------------------------
INSERT INTO `book_detail` VALUES (1, 1, NULL, '地主少爷福贵嗜赌成性，终于赌光了家业一贫如洗，穷困之中的福贵因为母亲生病前去求医，没想到半路上被国民党部队抓了壮丁，后被解放军所俘虏，回到家乡他才知道母亲已经去世，妻子家珍含辛茹苦带大了一双儿女，但女儿不幸变成了聋哑人，儿子机灵活泼……\r\n\r\n然而，真正的悲剧从此才开始渐次上演，每读一页，都让我们止不住泪湿双眼，因为生命里难得的温情将被一次次死亡撕扯得粉碎，只剩得老了的福贵伴随着一头老牛在阳光下回忆。');
INSERT INTO `book_detail` VALUES (2, 2, NULL, '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……\r\n\r\n四光年外，“三体文明”正苦苦挣扎——三颗无规则运行的太阳主导下的百余次毁灭与重生逼迫他们逃离母星。而恰在此时。他们接收到了地球发来的信息。在运用超技术锁死地球人的基础科学之后。三体人庞大的宇宙舰队开始向地球进发……\r\n\r\n人类的末日悄然来临。');
INSERT INTO `book_detail` VALUES (3, 3, '', '全球现象级畅销书《追风筝的人》首度推出中英双语版。双语对照，完整呈现，英语文学入门读物*。 快乐大本营高圆圆感动推荐，朗读者张一山深情诵读，窦靖童的创作灵感来源，奥巴马送给女儿的新年礼物。');
INSERT INTO `book_detail` VALUES (4, 4, '', '纯净而深刻、唯美而忧伤的爱之隐喻， 既献给孩子，也献给大人的哲理童话。 这是一部奇迹般的作品。它被译成250多种语言，全球发行量达5亿册； 它被被全球亿万读者肯定，阅读量仅次于《圣经》。 《小王子》是一部童话，但不是普通意义上的童话。它充满了哲理，但却没有任何说教，一切都蕴含在这个动人的故事里，藏在小王');
INSERT INTO `book_detail` VALUES (5, 5, '', '《百年孤独》有声书即将震撼上市，配音演播艺术家王明军倾情演绎 【50周年纪念版！全新典藏内封；限量赠50周年精美魔幻明信片1套】 【全球惟一正式授权中文版，6年发行量超600万册！】 ★缔造文坛传奇与文学奇迹的');
INSERT INTO `book_detail` VALUES (6, 6, '', '村上春树连读两遍的 魔书 ？张爱玲、余华、高晓松深深折服于毛姆的魅力？ 事实证明，它绝不只是一本单纯讲理想与现实的书。 ◎天才的一生 普罗大众的人生缩影 你的人生，由你做主 这里有人群中格格不入的异乡人，有');
INSERT INTO `book_detail` VALUES (7, 7, '', '关于本书 它是英国文学史乃至欧洲文学史上*部重要的现实主义小说，在世界范围内拥有重要的影响力。它更是一堂生动有趣的野外生存挑战课，一本关于信仰、智慧、勇气与坚持的生存手记。 ◎ 关于鲁滨孙（鲁滨逊） 无数读者的指路明灯和精神图腾 大难不死流落孤岛的他，也曾恐惧、绝望，但他重新振作，建筑 城堡 和 乡间别');
INSERT INTO `book_detail` VALUES (8, 8, '', '★ 国内首套专为孩子定制的诺贝尔文学奖大师经典作品 ★ 国际安徒生奖提名作家金波老师主编，谭旭东、张国龙、张贵勇等众多阅读专家推荐 ★ 精益求精的选本， 被全世界的读者所喜爱的作品，受伟大的作家尊敬的作者 ★ 特邀新锐儿童文学作家和特级中小学语文教师进行改写， 兼顾经典原味和儿童认知水平 ★ 细节用足心思，配');
INSERT INTO `book_detail` VALUES (9, 9, '', '◎关于本书 全世界*伟大的爱情小说之一，也是*受欢迎的名著之一，英国著名作家、戏剧家毛姆将其列入 世界十大小说 。 ◎关于傲慢先生和偏见小姐 纵使时光荏苒两百余载，达西和伊丽莎白身上的特质，仍为读者所喜爱、所探讨。或许读懂了他们，也就懂得了 你的内心肯定有着某种火焰，把你和其他人区别开来 。 ◎关于作者');
INSERT INTO `book_detail` VALUES (10, 10, '', '生命转瞬即逝，我们该拥有怎样的灵魂？ 在古典爱情盛行的年代，女主人公简 爱用迷人的自我，令作品历经百年，依然触动亿万读者。 这是关于女性自我觉醒的*美抒写，诉说：痛苦可以点燃爱意，信念能够超越自卑，坚持会有奇迹。 有关婚恋、人生选择、生命的真谛，你将在这里找到答案。 ◎ 选取百度、 知乎、豆瓣评分超高的');
INSERT INTO `book_detail` VALUES (11, 11, '', '《中国科幻基石丛书：球状闪电》以一种 丝丝入扣的张力 ，紧紧地让读者锁定眼球，书中蕴含的思想，更是使读者的心灵在初读之后便得到了强烈的震撼，正是这样的看似平淡的宏大，向我们生动地展示了一个又一个值得深刻');
INSERT INTO `book_detail` VALUES (12, 12, '', '刘慈欣授权，电影《流浪地球》同名原著小说，收录《超新星纪元》《流浪的地球》《圆圆的肥皂泡》《诗云》四个短篇，无删节，无改写，原滋原味呈现大刘想象奇特、精彩绝伦的科幻世界，大人孩子均可阅读！ 面对日新月');
INSERT INTO `book_detail` VALUES (13, 13, '', '★《白夜行》后，东野圭吾zui受欢迎作品 ★不是推理小说，却更扣人心弦 ★荣获中央公论文艺奖 ★荣登纪伊国屋、诚品、博客来、金石堂各大排行榜第1名 ★东野圭吾这次选择的，是生活中*平凡的片段：在事业和爱情间艰');
INSERT INTO `book_detail` VALUES (14, 14, '', '1999年，东野圭吾41岁正值盛年，写作出道已14年，在笔力、技巧、体力和雄心上都炉火纯青，于是洋洋洒洒写出了这部鸿篇巨制《白夜行》。这种规模宏大的长篇作品在职业作家一生的创作中极为罕见，完成后基本都被视为生');
INSERT INTO `book_detail` VALUES (15, 15, '', '新增10万字全新内容。同名电影由陈飞宇、何蓝逗精彩演绎热映中！刘昊然、谭松韵主演网剧好评如潮！继《你好，旧时光》《暗恋 橘生淮南》后， 振华三部曲 终极篇！我们与青春告别，曲终人不散。 1.新增十万字全新番外，八月长安百万畅销作品六周年纪念版！ 2.陈飞宇主演同名电影2019热映中！ 3.刘昊然、谭松韵主演网剧好评');
INSERT INTO `book_detail` VALUES (16, 16, '', '◆开创华语奇幻文学新时代之作，影响一代人青春的现象级经典，《悟空传》问世以来，持续畅销十五年，累计销量超过两百万册。 ◆同名电影定档2017.7.13，《西游 降魔篇》导演郭子健执导，今何在原著，彭于晏、倪妮、余文乐、欧豪、郑爽、俞飞鸿、乔杉倾情出演。 ◆随书附赠8位主创演员签名、赠语电影海报、电影拍摄花絮记录');
INSERT INTO `book_detail` VALUES (17, 17, '', '《麦田里的守望者》以主人公霍尔顿自叙的语气讲述自己被学校开除后在纽约城游荡将近两昼夜的经历和心灵感受。它不仅生动细致地描绘了一个不安现状的中产阶级子弟的苦闷仿徨、孤独愤世的精神世界，一个青春期少年矛');
INSERT INTO `book_detail` VALUES (18, 18, '', '6 个月，畅销200万册，超会讲故事的人张嘉佳，献给你的心动故事！ 14亿次阅读， 1500 万次转发，全国巡回 9 城 10 场 63 小时签售， 10 万粉丝 路过 张嘉佳， 这些都是你们为《从你的全世界路过》筑起的成绩单。从上');
INSERT INTO `book_detail` VALUES (19, 19, '', '传奇海盗哥尔•D•罗杰在临死前曾留下关于其毕生的财富“One Piece”的消息，由此引得群雄并起，众海盗们为了这笔传说中的巨额财.');
INSERT INTO `book_detail` VALUES (20, 20, '', '《龙族》作者江南青春里程碑之作 畅销中国1,000,000册 中文青春成长小说先驱 10,000,000人的青春刻痕 北京大学团委、华策影视改编电影电视剧 青春是场永志的劫数，江南真情作序 **画手ENO精美绘制少年群像图');
INSERT INTO `book_detail` VALUES (21, 21, '', '传统经典 伴你一生 1. 本套丛书为全本。所收书目是经史子集中*为经典的著作，以权威版本为核校底本，约请业内专家进行注释和翻译。注释准确简明，译文明白晓畅。 2. 内部结构上题解、原文、注释、译文各部分自然结');
INSERT INTO `book_detail` VALUES (22, 22, '', '*本书作者在布泰科呼吸法基础之上，经过13年自身实践和推广教学发展出 呼吸优化训练 。迄今为止，已有数千名呼吸疾病患者及专业运动员受益，得以恢复体适能，缓解鼻塞，激活身心。 *风靡欧美日，获*运动员、主流媒');
INSERT INTO `book_detail` VALUES (23, 23, '', '《你是你吃出来的》是前安贞医院营养科主任夏萌总结自身患病经历和10万 临床病例写成，江西科学技术出版社出版发行。');
INSERT INTO `book_detail` VALUES (24, 24, '', '【专业全面，打破偏见】 拥有傲人发表量和超高引用率的 学霸 作者，为读者介绍、剖析几乎全部的饮食营养成分及常见的都市流行饮食方案， 一书在手，熟悉饮食的方方面面 ，并对饮食及健康问题知其所以然，拒绝人云亦云、盲目跟风， 解放被 减肥道德 绑架的你 ； 【授人以渔， 荟萃分析 各种健康类写作的写作】 健康领域的读');
INSERT INTO `book_detail` VALUES (25, 25, '', '★展现了一幅现实且有所帮助的变老景象，并提供了有助于我们自我提升和有意识进化的实用信息； ★强调了老年对个人和社会的重要意义，以及我们作为人类的内在价值； ★相信我们能够随着年龄增长更懂得品质生活，反');
INSERT INTO `book_detail` VALUES (26, 26, '', '美国健康类**畅销书！ ★出版80周长踞Amazon健康类排行榜第1名！ ★甫出版，即登上《纽约时报》畅销书榜第1名！ ★《纽约时报》畅销书榜连续在榜55周！ ★《美国出版周报》畅销书榜连续在榜超40周！ 好莱坞和运动界');
INSERT INTO `book_detail` VALUES (27, 27, '', '好莱坞明星私人教练 ，接地气的健身 营养 经验 作者作为明星私人教练，获碧昂斯、JAY-Z、坎耶等人一致好评，以及运动生理学家、职业运动员、健康研究机构的鼎力推荐。*重要的是，马可的健身方案使人易于坚持，乐');
INSERT INTO `book_detail` VALUES (28, 28, '', '★*大师，专业研究，干货满满 斯坦福大学睡眠研究所全新成果首次公开，*睡眠科学家、睡眠治疗师西野精治倾情力作，研究精髓，干货满满，三个步骤，带你远离失眠困扰；十大攻略，教你安心睡个好觉！ ★治愈都市人的');
INSERT INTO `book_detail` VALUES (29, 29, '', '连续138周蝉联亚马逊健康类图书榜首 美国前总统克林顿、脱口秀女王奥普拉亲证有效 公开推荐的 《救命饮食：中国健康调查报告》实践版 选择正确的食物，远比昂贵的药物和保健品更重要 你的健康只和三件事有关：早餐、午餐、晚餐 只要看完这本书，实践 14 天 你就能真正掌握保持长期健康的方法 坎贝尔饮食计划 它能帮你远离肥');
INSERT INTO `book_detail` VALUES (30, 30, '', '《中国居民膳食指南（2016）》发布视频： CCTV13 新闻频道 新闻直播间 http://tv.cctv.com/2016/05/13/VIDEcL1VUHrIO8CA8N0gZhEP160513.shtml BTV 首都经济报');
INSERT INTO `book_detail` VALUES (31, 31, '', '本版附赠：扫书签二维码 免费赠送 价值198元的 小白财商在线课程 作为富爸爸系列图书的引进者和富爸爸财商理念的推广者，北京读书人文化发现，要想让读者理解和掌握财商技能面临两个难题。 一 是阅读的时效性和读者');
INSERT INTO `book_detail` VALUES (32, 32, '', '《聪明的投资者》(原本第4版， 中译本修订版 )是本杰明 格雷厄姆的经典之作，它还原了本杰明 格雷厄姆生前最后一次修订的第4版的原貌，是一本开启人们智慧的投资哲学。作者本杰明 格雷厄姆是价值投资理论的开山鼻祖、巴菲特一生的精神导师。格雷厄姆对于价值投资的理解以及投资安全性的分析策略影响了包括市盈率鼻祖约翰');
INSERT INTO `book_detail` VALUES (33, 33, '', '●股神巴菲特反复研读的投资路线图，引领了巴菲特的价值投资之路。 ●价值投资流派开山之作，给出了历经时间检验的价值投资思想和常识。 ●巴菲特特别珍爱的版本 塞思 卡拉曼等十位投资大咖全新导读。巴曙松教授历时一年半，领衔 专业团队打造权威中文版。 ●高瓴资本创始人张磊专文推荐，高毅资产管理合伙企业董事长邱');
INSERT INTO `book_detail` VALUES (34, 34, '', '本书为炒股经典著作，2018年作者重新修改，添加了*近几年的诸多感悟。 全书共有九章。 *章 炒股的挑战 ：讲述了股票的迷惑性，以及讨厌风险、发财心太急、自以为是、跟风、迟疑不决等人性对炒股成功的阻碍。 第二章');
INSERT INTO `book_detail` VALUES (35, 35, '', '★ 荣登德、英、法、日、韩各大畅销书排行榜! ★ 欧美畅销的财富启蒙读物！引导孩子正确认识财富、创造财富的 金钱童话 ！ ★ 本书德语版一出版即登上德国各地销售排行榜榜首，随即在全球引发了一场 金钱童话 的热');
INSERT INTO `book_detail` VALUES (36, 36, '', '重新理解贫穷，探究穷人之所以贫穷的根源。 《金融时报》-高盛2011年度*商业图书，诺贝尔经济学奖得主罗伯特 默顿 索洛、阿马蒂亚 森、《魔鬼经济学》作者史蒂芬 列维特， 《经济学人》《福布斯》《纽约时报》《金融时报》《华尔街日报》《卫报》《快公司》等 推荐');
INSERT INTO `book_detail` VALUES (37, 37, '', '1、 看美国如何用司法 暗箭 ，将世界500强吃掉：是合理执法，还是敲诈勒索？ 2014年，举世瞩目的跨国收购案 法国能源巨头阿尔斯通被美国通用电气超低价收购，迷雾重重。被当成 经济人质 的核心人物出狱后详细披露海量细节，再现阿尔斯通、通用电气、美国司法部、法国政府、欧盟多方博弈，真相逐渐浮出水面。 2、 当5G跟核能');
INSERT INTO `book_detail` VALUES (38, 38, '', '曼昆的《经济学原理》是一本享誉全球的经济学经典教科书。该书简明的内容、贴近生活和时代的案例，以及生动、诙谐的语言风格，都是其他教材所不能具其一的。它正是经济学入门者的**选择。本书英文原版已被哈佛大学、耶鲁大学、斯坦福大学等美国600余所大学用作经济学原理课程的教材！迄今为止，它已被翻译成20多种');
INSERT INTO `book_detail` VALUES (39, 39, '', '华尔街投资大神、赚钱远超其他对冲基金公司 桥水创始人 作者瑞 达利欧出身美国普通中产家庭，26岁时被炒鱿鱼后在自己的两居室内创办了桥水，现在桥水管理资金超过1 500亿美元，截至2015年年底，盈利超过450亿美元。');
INSERT INTO `book_detail` VALUES (40, 40, '', '现代管理学之父 彼得 德鲁克谈个人管理。每个知识工作者都是管理者，其成效是决定企业成效的关键因素。卓有成效可以学会，于是平凡的人做成了不平凡的事业。邵明路、张瑞敏、赵曙明、包政、陈春花等鼎力推荐。');
INSERT INTO `book_detail` VALUES (41, 41, '', '《浪潮之巅》首版自出版以来，在业界获得了巨大反响。信息产业发展瞬息万变，在《浪潮之巅》首版上市的八年后， IT 行业也发生了很大的变化，吴军博士继续娓娓道来，与您聊聊这些年里，IT界的这些事。 这不是一本科技产业发展历史集，而是在这个数字时代，一本IT人非读不可，而非IT人也应该拜读的作品。 《浪潮之巅 第四');
INSERT INTO `book_detail` VALUES (42, 42, '', '本书迄今仍雄踞美国亚马逊畅销总榜前五十，两千多条全五星读者评论，纽约时报书评 时代周刊 华尔街日报 华盛顿邮报等数十家专业媒体的年度*图书，比尔 盖茨年末专门视频推荐。 本书聚焦的案件是自安然公司以后*大的金融诈骗案，作者约翰 卡雷鲁的报告在揭发这个惊世谎言的过程中有着决定性的作用，真相揭晓时举世震惊，');
INSERT INTO `book_detail` VALUES (43, 43, '', '1、大数据、智能革命、人工智能、机械智能领域科普作品，易于理解，有态度，有温度。 2、雷军、罗振宇、涂子沛、李善友、邬贺铨院士联袂推荐。 3、罗辑思维8小时售罄首印图书。 4、百万册畅销书作者作吴军博士备受期待作品。 5、吴军博士，计算机科学家，并做过Google、腾讯等世界知名公司的高管，作品兼具学');
INSERT INTO `book_detail` VALUES (44, 44, '', '1. 【吴军博士重磅作品】 计算机科学家、硅谷科技投资人、文津图书奖得主、百万册畅销书作者吴军博士2019全新力作。 2. 【北大清华资深教授作序推荐】 高文（工程院院士）、钱颖一（清华大学经管学院前院长）作序推荐。 3. 【读科技史的三个原因】 一是看懂整个科技变革的逻辑，判断清楚我们今天所处的位置，把握住未来科技演化的方向。 二是掌握解决问题的能力，通过科学发明以及技术发明之间的逻辑关系，我们知道我们自己怎么');
INSERT INTO `book_detail` VALUES (45, 45, '', '美国政府不想让全世界读到这本书，欧美上市当日作者便被美国司法部起诉！“棱镜门”主角爱德华·斯诺登首次亲自披露美国政府滥用NSA系统监控世界的真相，袒露从“爱国者”到“叛国者”的心路历程。');
INSERT INTO `book_detail` VALUES (46, 46, '', '早阅读一天，就让你在互联网时代先行一步 《必然》阐述 12种必然的科技力量，预测未来20-30年的必然趋势。 KK让我们相信，科技带给我们的未来，终将是一个充满温暖、任性与自由的 进托邦 （Protobia） 继《失控》《科技想要什么》后，《必然》让你更早的展望未来。');
INSERT INTO `book_detail` VALUES (47, 47, '', '◎全球首部埃隆 马斯克授权著作！了解埃隆 马斯克*全面、*真实、*经典读本 ◎创业者必读。首次披露马斯克如何建立和运营PayPal、特斯拉、Space X、Solar City等公司的细节。 ◎创新者必读。关于科技、梦想、创业、工作、团队、人生。马斯克首次公开创新的秘密。 ◎故事迷必读。硅谷*秀科技作家阿什利 万斯历时将近4年，遍');
INSERT INTO `book_detail` VALUES (48, 48, '', '●湛庐文化圣塔菲书系著作！ ●复杂性科学奠基人、首屈一指的技术思想家、 熊彼特奖 得主布莱恩 阿瑟作品！ ●谷歌Java程序开发的灵感源泉！ ●技术理论体系的先河之作，前所未有的关于技术产生和进化的系统性理论！ ●一次打开 技术黑箱 的尝试性创新探索！ ●技术思想大师用平实的语言向大众讲述技术前沿思想！ ●湛庐文');
INSERT INTO `book_detail` VALUES (49, 49, '', '※获第11届 文津图书奖 科普类推荐图书。 ★金融博物馆书院推荐！ ★ 比尔 盖茨博客撰文推荐！ 著名物理学家、科普作家李淼推荐！ ★材料学大师的力作。「未读 探索家」畅销科普系列图书。 ★2014年英国皇家学会科');
INSERT INTO `book_detail` VALUES (50, 50, '', '《创新者》是一部数字时代的全景式纪录作品，作者艾萨克森不仅用其生动的语言为我们铺展了计算机与互联网发展的宏大篇章，而且以独特的视角讲述了人文与科学相互交织的创新历程。 1.《创新者》继《乔布斯传》后，进');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `level` int(10) NOT NULL COMMENT '菜单等级',
  `parent_id` int(10) NULL DEFAULT NULL COMMENT '父菜单id',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '文学', 1, NULL, '2019-12-15 17:44:54', NULL, NULL, NULL);
INSERT INTO `menu` VALUES (2, '流行', 1, NULL, '2019-12-15 17:46:07', NULL, NULL, NULL);
INSERT INTO `menu` VALUES (3, '生活', 1, NULL, '2019-12-15 17:46:22', NULL, NULL, NULL);
INSERT INTO `menu` VALUES (4, '经管', 1, NULL, '2019-12-15 17:46:43', NULL, NULL, NULL);
INSERT INTO `menu` VALUES (5, '科技', 1, NULL, '2019-12-15 20:34:28', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for repository
-- ----------------------------
DROP TABLE IF EXISTS `repository`;
CREATE TABLE `repository`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `book_id` int(10) NOT NULL COMMENT '图书id',
  `inventory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '库存',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '系统管理员', '2019-11-30 23:06:56', NULL, NULL, NULL);
INSERT INTO `role` VALUES (2, '图书管理员', '2019-11-30 23:07:02', NULL, NULL, NULL);
INSERT INTO `role` VALUES (3, '订单管理员', '2019-11-30 23:08:35', NULL, NULL, NULL);
INSERT INTO `role` VALUES (4, '用户', '2019-11-30 23:08:39', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `role_id` int(5) NOT NULL COMMENT '角色',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `telphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_opr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '123', 'unicorn', '龚佳民', '男', 4, '2328367478@qq.com', '15071148332', '2019-12-17 17:29:56', NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, '123', 'dog', '柯基', '男', 2, '1', '1', '2019-12-09 19:40:42', NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, '123', 'cat', '美短', '男', 3, '1', '1', '2019-12-09 19:43:18', NULL, NULL, NULL);
INSERT INTO `user` VALUES (4, '123', 'yonghu', '用户', '女', 4, '1', '1', '2019-12-09 20:13:56', NULL, NULL, NULL);
INSERT INTO `user` VALUES (5, '00', '00', '00', 'woman', 4, '1661916905@qq.com', '15972114877', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, '00', '00', '00', 'man', 4, '00', '00', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (7, '00', '00', '00', 'man', 4, '00', '00', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (9, '123', 'bookmanager', '123', 'woman', 2, '123', '15972114877', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (10, '123', 'systemmanager', '123', 'woman', 1, '123', '123', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
