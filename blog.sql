/*
 Navicat Premium Data Transfer

 Source Server         : localhost_mysql
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 27/10/2020 09:39:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appreciation` bit(1) NOT NULL,
  `commentabled` bit(1) NOT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `first_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `published` bit(1) NOT NULL,
  `recommend` bit(1) NOT NULL,
  `share_statement` bit(1) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `views` int(11) NULL DEFAULT NULL,
  `type_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK292449gwg5yf7ocdlmswv9w4j`(`type_id`) USING BTREE,
  INDEX `FK8ky5rrsxh01nkhctmo7d48p82`(`user_id`) USING BTREE,
  CONSTRAINT `FK292449gwg5yf7ocdlmswv9w4j` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK8ky5rrsxh01nkhctmo7d48p82` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES (1, b'0', b'1', '# 俺是一级标题\r\n### 哈哈哈', '2020-08-06 21:53:56', '123', 'https://i.loli.net/2020/08/08/dWPzyGaCfrkelnX.png', '转载', b'1', b'0', b'1', '第一', '2019-12-01 21:07:44', 6, 2, 2);
INSERT INTO `t_blog` VALUES (2, b'1', b'1', '哈哈哈', '2020-08-07 20:15:29', '烦烦方哈哈哈哈哈哈哈哈哈', 'https://i.loli.net/2020/08/08/dWPzyGaCfrkelnX.png', '转载', b'1', b'0', b'1', '第二', '2020-08-08 21:07:56', 1, 1, 1);
INSERT INTO `t_blog` VALUES (3, b'1', b'1', '内容', '2020-08-07 20:15:34', '描述2哈哈哈哈哈哈哈哈哈哈哈', 'https://i.loli.net/2020/08/08/dWPzyGaCfrkelnX.png', '原创', b'1', b'0', b'1', '第三', '2019-10-01 21:08:17', 0, 2, 1);
INSERT INTO `t_blog` VALUES (6, b'0', b'0', '谷歌', '2020-08-07 16:59:30', '描述哈哈哈哈哈哈哈哈哈哈', 'https://i.loli.net/2020/08/08/dWPzyGaCfrkelnX.png', '转载', b'1', b'0', b'0', '第五次测试', '2020-08-08 21:10:28', 1, 1, 1);
INSERT INTO `t_blog` VALUES (7, b'1', b'1', '呃呃呃', '2020-08-07 20:09:31', '嘎嘎嘎哈哈哈哈哈哈哈哈哈哈', 'https://i.loli.net/2020/08/08/dWPzyGaCfrkelnX.png', '原创', b'1', b'0', b'1', '第六次测试', '2020-08-08 21:10:43', 1, 2, 1);
INSERT INTO `t_blog` VALUES (8, b'1', b'1', '嗯，测试', '2020-08-07 21:36:13', '俺是测试的哈哈哈哈哈哈哈哈哈哈', 'https://i.loli.net/2020/08/08/dWPzyGaCfrkelnX.png', '转载', b'0', b'0', b'1', '第七', '2018-09-01 21:10:58', 0, 4, 1);
INSERT INTO `t_blog` VALUES (10, b'1', b'1', '# 欢迎使用 Markdown在线编辑器 MdEditor\r\n\r\n**Markdown是一种轻量级的「标记语言」**\r\n\r\n\r\n![markdown](https://www.mdeditor.com/images/logos/markdown.png \"markdown\")\r\n\r\n\r\nMarkdown是一种可以使用普通文本编辑器编写的标记语言，通过简单的标记语法，它可以使普通文本内容具有一定的格式。它允许人们使用易读易写的纯文本格式编写文档，然后转换成格式丰富的HTML页面，Markdown文件的后缀名便是“.md”\r\n\r\n\r\n## MdEditor是一个在线编辑Markdown文档的编辑器\r\n\r\n*MdEditor扩展了Markdown的功能（如表格、脚注、内嵌HTML等等），以使让Markdown转换成更多的格式，和更丰富的展示效果，这些功能原初的Markdown尚不具备。*\r\n\r\n> Markdown增强版中比较有名的有Markdown Extra、MultiMarkdown、 Maruku等。这些衍生版本要么基于工具，如~~Pandoc~~，Pandao；要么基于网站，如GitHub和Wikipedia，在语法上基本兼容，但在一些语法和渲染效果上有改动。\r\n\r\nMdEditor源于Pandao的JavaScript开源项目，开源地址[Editor.md](https://github.com/pandao/editor.md \"Editor.md\")，并在MIT开源协议的许可范围内进行了优化，以适应广大用户群体的需求。向优秀的markdown开源编辑器原作者Pandao致敬。\r\n\r\n\r\n![Pandao editor.md](https://pandao.github.io/editor.md/images/logos/editormd-logo-180x180.png \"Pandao editor.md\")\r\n\r\n\r\n\r\n## MdEditor的功能列表演示\r\n\r\n# 标题H1\r\n\r\n## 标题H2\r\n\r\n### 标题H3\r\n\r\n#### 标题H4\r\n\r\n##### 标题H5\r\n\r\n###### 标题H5\r\n\r\n### 字符效果和横线等\r\n----\r\n\r\n~~删除线~~ <s>删除线（开启识别HTML标签时）</s>\r\n\r\n*斜体字*      _斜体字_\r\n\r\n**粗体**  __粗体__\r\n\r\n***粗斜体*** ___粗斜体___\r\n\r\n上标：X<sub>2</sub>，下标：O<sup>2</sup>\r\n\r\n**缩写(同HTML的abbr标签)**\r\n> 即更长的单词或短语的缩写形式，前提是开启识别HTML标签时，已默认开启\r\n\r\nThe <abbr title=\"Hyper Text Markup Language\">HTML</abbr> specification is maintained by the <abbr title=\"World Wide Web Consortium\">W3C</abbr>.\r\n### 引用 Blockquotes\r\n\r\n> 引用文本 Blockquotes\r\n\r\n引用的行内混合 Blockquotes\r\n\r\n> 引用：如果想要插入空白换行`即<br />标签`，在插入处先键入两个以上的空格然后回车即可，[普通链接](https://www.mdeditor.com/)。\r\n\r\n### 锚点与链接 Links\r\n[普通链接](https://www.mdeditor.com/)\r\n[普通链接带标题](https://www.mdeditor.com/ \"普通链接带标题\")\r\n直接链接：<https://www.mdeditor.com>\r\n[锚点链接][anchor-id]\r\n[anchor-id]: https://www.mdeditor.com/\r\n[mailto:test.test@gmail.com](mailto:test.test@gmail.com)\r\nGFM a-tail link @pandao\r\n邮箱地址自动链接 test.test@gmail.com  www@vip.qq.com\r\n> @pandao\r\n\r\n### 多语言代码高亮 Codes\r\n\r\n#### 行内代码 Inline code\r\n\r\n\r\n执行命令：`npm install marked`\r\n\r\n#### 缩进风格\r\n\r\n即缩进四个空格，也做为实现类似 `<pre>` 预格式化文本 ( Preformatted Text ) 的功能。\r\n\r\n    <?php\r\n        echo \"Hello world!\";\r\n    ?>\r\n预格式化文本：\r\n\r\n    | First Header  | Second Header |\r\n    | ------------- | ------------- |\r\n    | Content Cell  | Content Cell  |\r\n    | Content Cell  | Content Cell  |\r\n\r\n#### JS代码\r\n```javascript\r\nfunction test() {\r\n	console.log(\"Hello world!\");\r\n}\r\n```\r\n\r\n#### HTML 代码 HTML codes\r\n```html\r\n<!DOCTYPE html>\r\n<html>\r\n    <head>\r\n        <mate charest=\"utf-8\" />\r\n        <meta name=\"keywords\" content=\"Editor.md, Markdown, Editor\" />\r\n        <title>Hello world!</title>\r\n        <style type=\"text/css\">\r\n            body{font-size:14px;color:#444;font-family: \"Microsoft Yahei\", Tahoma, \"Hiragino Sans GB\", Arial;background:#fff;}\r\n            ul{list-style: none;}\r\n            img{border:none;vertical-align: middle;}\r\n        </style>\r\n    </head>\r\n    <body>\r\n        <h1 class=\"text-xxl\">Hello world!</h1>\r\n        <p class=\"text-green\">Plain text</p>\r\n    </body>\r\n</html>\r\n```', '2020-08-08 10:26:39', '这种事情见得多了，我只想说懂得都懂，不懂的我也不多解释，毕竟自己知道就好，细细品吧。你们也别来问我怎么了，利益牵扯太大，说了对你我都没好处，当不知道就行了，其余的我只能说这里面水很深，牵扯到很多东西。详细情况你们自己是很难找的，网上大部分已经删除干净了，所以我只能说懂得都懂。', 'https://i.loli.net/2020/08/08/15CsJYHZMFRtx8m.png', '原创', b'1', b'0', b'1', '第八，完整的内容', '2018-11-01 21:11:19', 11, 2, 1);
INSERT INTO `t_blog` VALUES (11, b'1', b'1', '呃呃呃', '2020-08-08 21:12:00', '烦烦方', 'jpg', '原创', b'0', b'0', b'1', '不发表', '2020-08-08 21:15:05', 0, 1, 1);
INSERT INTO `t_blog` VALUES (12, b'0', b'0', '嘎嘎嘎嘎嘎', '2020-08-09 20:10:04', '第十篇博客', 'https://i.loli.net/2020/08/08/15CsJYHZMFRtx8m.png', '翻译', b'1', b'0', b'0', '第十', '2020-08-10 16:16:36', 17, 5, 1);
INSERT INTO `t_blog` VALUES (13, b'1', b'1', '## 1、ArrayList 的属性\r\n\r\n```java\r\n //默认容量：10\r\nprivate static final int DEFAULT_CAPACITY = 10;\r\n\r\n //默认空数据，new的时候，初始化的就是这个空数据\r\n private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};\r\n\r\n //存储数据的数组\r\n transient Object[] elementData;\r\n\r\n //集合的大小、数组实际存储数据的大小\r\n private int size;\r\n```\r\n\r\n\r\n\r\n## 2、ArrayList 的构造函数\r\n\r\n**ArrayList有三种方式来初始化，构造方法源码如下：**\r\n\r\n```java\r\n	/**\r\n     * 默认初始容量大小\r\n     */\r\n    private static final int DEFAULT_CAPACITY = 10;\r\n    \r\n\r\n    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};\r\n\r\n    /**\r\n     *默认构造函数，使用初始容量10构造一个空列表(无参数构造)\r\n     */\r\n    public ArrayList() {\r\n        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;\r\n    }\r\n    \r\n    /**\r\n     * 带初始容量参数的构造函数。（用户自己指定容量）\r\n     */\r\n    public ArrayList(int initialCapacity) {\r\n        if (initialCapacity > 0) {//初始容量大于0\r\n            //创建initialCapacity大小的数组\r\n            this.elementData = new Object[initialCapacity];\r\n        } else if (initialCapacity == 0) {//初始容量等于0\r\n            //创建空数组\r\n            this.elementData = EMPTY_ELEMENTDATA;\r\n        } else {//初始容量小于0，抛出异常\r\n            throw new IllegalArgumentException(\"Illegal Capacity: \"+\r\n                                               initialCapacity);\r\n        }\r\n    }\r\n\r\n\r\n   /**\r\n    *构造包含指定collection元素的列表，这些元素利用该集合的迭代器按顺序返回\r\n    *如果指定的集合为null，throws NullPointerException。 \r\n    */\r\n     public ArrayList(Collection<? extends E> c) {\r\n        elementData = c.toArray();\r\n        if ((size = elementData.length) != 0) {\r\n            // c.toArray might (incorrectly) not return Object[] (see 6260652)\r\n            if (elementData.getClass() != Object[].class)\r\n                elementData = Arrays.copyOf(elementData, size, Object[].class);\r\n        } else {\r\n            // replace with empty array.\r\n            this.elementData = EMPTY_ELEMENTDATA;\r\n        }\r\n    }\r\n```\r\n\r\n​		**以无参数构造方法创建 ArrayList 时，实际上初始化赋值的是一个空数组。当真正对数组进行添加元素操作时，才真正分配容量。即向数组中添加第一个元素时，数组容量扩为10。**\r\n\r\n\r\n\r\n## 3、 一步一步分析 ArrayList 扩容机制\r\n\r\n这里以无参构造函数创建的 ArrayList 为例分析\r\n\r\n### 1. 先来看 `add` 方法\r\n\r\n```java\r\n 	/**\r\n     * 将指定的元素追加到此列表的末尾。 \r\n     */\r\n    public boolean add(E e) {\r\n   //添加元素之前，先调用ensureCapacityInternal方法\r\n        ensureCapacityInternal(size + 1);//size就是数组实际存储的数据个数\r\n        //这里看到ArrayList添加元素的实质就相当于为数组赋值\r\n        elementData[size++] = e;\r\n        return true;\r\n    }\r\n```\r\n\r\n### 2. 再来看看 `ensureCapacityInternal()` 方法\r\n\r\n可以看到 `add` 方法 首先调用了`ensureCapacityInternal(size + 1)`\r\n\r\n此时 minCapacity = size + 1\r\n\r\n```java\r\n	//得到最小扩容量\r\n    private void ensureCapacityInternal(int minCapacity) {\r\n        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {\r\n            // 获取默认的容量和传入参数的较大值\r\n            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);\r\n        }\r\n\r\n        ensureExplicitCapacity(minCapacity);\r\n    }\r\n```\r\n\r\n**当 要 add 进第1个元素时，minCapacity为1，在Math.max()方法比较后，minCapacity 为10。**\r\n\r\n### 3. `ensureExplicitCapacity()` 方法\r\n\r\n如果调用 `ensureCapacityInternal()` 方法就一定会进过（执行）这个方法。\r\n\r\n```java\r\n	//判断是否需要扩容\r\n    private void ensureExplicitCapacity(int minCapacity) {\r\n        modCount++;\r\n\r\n        //所需最小容量 - 数组长度\r\n        if (minCapacity - elementData.length > 0)\r\n            //调用grow方法进行扩容，调用此方法代表已经开始扩容了\r\n            grow(minCapacity);\r\n    }\r\n```\r\n\r\n我们来仔细分析一下：\r\n\r\n- 当我们要 add 进第1个元素到 ArrayList 时，elementData.length 为0 （因为还是一个空的 list），因为执行了 `ensureCapacityInternal()` 方法 ，所以 minCapacity 此时为10。此时，`minCapacity - elementData.length > 0 `成立，所以会进入 `grow(minCapacity)` 方法。\r\n- 当add第2个元素时，minCapacity 为2，此时e lementData.length(容量)在添加第一个元素后扩容成 10 了。此时，`minCapacity - elementData.length > 0 `不成立，所以不会进入 （执行）`grow(minCapacity)` 方法。\r\n- 添加第3、4···到第10个元素时，依然不会执行grow方法，数组容量都为10。\r\n\r\n直到添加第11个元素，minCapacity(为11)比elementData.length（为10）要大。进入grow方法进行扩容。\r\n\r\n### 4. `grow()` 方法\r\n\r\n```java\r\n 	/**\r\n     * 要分配的最大数组大小\r\n     */\r\n    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;\r\n\r\n    /**\r\n     * ArrayList扩容的核心方法。\r\n     */\r\n    private void grow(int minCapacity) {\r\n       // oldCapacity为旧容量，newCapacity为新容量\r\n       int oldCapacity = elementData.length;\r\n       //将oldCapacity 右移一位，其效果相当于oldCapacity /2，\r\n       //我们知道位运算的速度远远快于整除运算，整句运算式的结果就是将新容量更新为旧容量的1.5倍，\r\n       int newCapacity = oldCapacity + (oldCapacity >> 1);\r\n       //然后检查新容量是否大于最小需要容量，若还是小于最小需要容量，那么就把最小需要容量当作数组的新容量\r\n       if (newCapacity - minCapacity < 0)\r\n           newCapacity = minCapacity;\r\n       //如果新容量大于MAX_ARRAY_SIZE,进入(执行)hugeCapacity()方法来比较 minCapacity和MAX_ARRAY_SIZE，\r\n       //如果minCapacity大于最大容量，则新容量则为Integer.MAX_VALUE，否则，新容量大小则为 MAX_ARRAY_SIZE 即为 `Integer.MAX_VALUE - 8`。\r\n        if (newCapacity - MAX_ARRAY_SIZE > 0)\r\n            newCapacity = hugeCapacity(minCapacity);\r\n        // minCapacity is usually close to size, so this is a win:\r\n        elementData = Arrays.copyOf(elementData, newCapacity);\r\n    }\r\n```\r\n\r\n**int newCapacity = oldCapacity + (oldCapacity >> 1),所以 ArrayList 每次扩容之后容量都会变为原来的 1.5 倍左右（oldCapacity为偶数就是1.5倍，否则是1.5倍左右）！** 奇偶不同，比如 ：10+10/2 = 15, 33+33/2=49。如果是奇数的话会丢掉小数.\r\n\r\n> \">>\"（移位运算符）：>>1 右移一位相当于除2，右移n位相当于除以 2 的 n 次方。这里 oldCapacity 明显右移了1位所以相当于oldCapacity /2。对于大数据的2进制运算,位移运算符比那些普通运算符的运算要快很多,因为程序仅仅移动一下而已,不去计算,这样提高了效率,节省了资源 　\r\n\r\n### 5. `hugeCapacity()` 方法。\r\n\r\n从上面 `grow()` 方法源码我们知道： 如果新容量大于 MAX_ARRAY_SIZE,进入(执行) `hugeCapacity()` 方法来比较 minCapacity 和 MAX_ARRAY_SIZE，如果minCapacity大于最大容量，则新容量则为`Integer.MAX_VALUE`，否则，新容量大小则为 MAX_ARRAY_SIZE 即为 `Integer.MAX_VALUE - 8`。\r\n\r\n```java\r\n    private static int hugeCapacity(int minCapacity) {\r\n        if (minCapacity < 0) // overflow\r\n            throw new OutOfMemoryError();\r\n        //对minCapacity和MAX_ARRAY_SIZE进行比较\r\n        //若minCapacity大，将Integer.MAX_VALUE作为新数组的大小\r\n        //若MAX_ARRAY_SIZE大，将MAX_ARRAY_SIZE作为新数组的大小\r\n        //MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;\r\n        return (minCapacity > MAX_ARRAY_SIZE) ?\r\n            Integer.MAX_VALUE :\r\n            MAX_ARRAY_SIZE;\r\n    }\r\n```\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n', '2020-08-13 11:19:30', '简要概述一下ArrayList的扩容机制', 'https://i.loli.net/2020/08/08/15CsJYHZMFRtx8m.png', '原创', b'1', b'0', b'1', 'ArrayList扩容机制', '2020-08-13 11:24:43', 69, 7, 1);

-- ----------------------------
-- Table structure for t_blog_tags
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tags`;
CREATE TABLE `t_blog_tags`  (
  `blogs_id` bigint(20) NOT NULL,
  `tags_id` bigint(20) NOT NULL,
  INDEX `FK5feau0gb4lq47fdb03uboswm8`(`tags_id`) USING BTREE,
  INDEX `FKh4pacwjwofrugxa9hpwaxg6mr`(`blogs_id`) USING BTREE,
  CONSTRAINT `FK5feau0gb4lq47fdb03uboswm8` FOREIGN KEY (`tags_id`) REFERENCES `t_tag` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKh4pacwjwofrugxa9hpwaxg6mr` FOREIGN KEY (`blogs_id`) REFERENCES `t_blog` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_blog_tags
-- ----------------------------
INSERT INTO `t_blog_tags` VALUES (1, 1);
INSERT INTO `t_blog_tags` VALUES (6, 1);
INSERT INTO `t_blog_tags` VALUES (6, 2);
INSERT INTO `t_blog_tags` VALUES (6, 3);
INSERT INTO `t_blog_tags` VALUES (7, 2);
INSERT INTO `t_blog_tags` VALUES (8, 1);
INSERT INTO `t_blog_tags` VALUES (8, 2);
INSERT INTO `t_blog_tags` VALUES (10, 1);
INSERT INTO `t_blog_tags` VALUES (10, 2);
INSERT INTO `t_blog_tags` VALUES (11, 1);
INSERT INTO `t_blog_tags` VALUES (11, 2);
INSERT INTO `t_blog_tags` VALUES (12, 4);
INSERT INTO `t_blog_tags` VALUES (13, 1);

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_comment` bit(1) NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `blog_id` bigint(20) NULL DEFAULT NULL,
  `parent_comment_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKke3uogd04j4jx316m1p51e05u`(`blog_id`) USING BTREE,
  INDEX `FK4jj284r3pb7japogvo6h72q95`(`parent_comment_id`) USING BTREE,
  CONSTRAINT `FK4jj284r3pb7japogvo6h72q95` FOREIGN KEY (`parent_comment_id`) REFERENCES `t_comment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKke3uogd04j4jx316m1p51e05u` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (1, b'0', '/images/avatar.jpg', '回复小白的评论2', '2020-08-16 16:19:36', 'test@126.com', '光头强', 13, 2);
INSERT INTO `t_comment` VALUES (2, b'0', '/images/avatar.jpg', '测试', '2020-08-16 16:51:47', 'xiaobao@qq.com', '小白', 13, NULL);
INSERT INTO `t_comment` VALUES (3, b'0', '/images/avatar.jpg', '回复小白的评论', '2020-08-16 16:58:47', 'xiaohei@qq.com', '小黑', 13, 2);
INSERT INTO `t_comment` VALUES (5, b'0', '/images/avatar.jpg', '测试2', '2020-08-24 15:50:54', 'xiaohua@qq.com', '小花', 13, NULL);
INSERT INTO `t_comment` VALUES (6, b'0', '/images/avatar.jpg', '回复小花的评论', '2020-08-24 16:17:10', 'xiaolan@qq.com', '小蓝', 13, 5);
INSERT INTO `t_comment` VALUES (7, b'0', '/images/avatar.jpg', '测试3', '2020-08-24 21:23:39', 'xiaohong@qq.com', '小红', 13, NULL);
INSERT INTO `t_comment` VALUES (9, b'0', '/images/avatar.jpg', '回复小红', '2020-08-24 21:34:45', 'xiaolv@qq.com', '小绿', 13, 7);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `t_role` VALUES (2, 'ROLE_GUEST');

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (1, 'Java');
INSERT INTO `t_tag` VALUES (2, 'C++');
INSERT INTO `t_tag` VALUES (3, 'PHP');
INSERT INTO `t_tag` VALUES (4, 'python');

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES (1, '学习笔记');
INSERT INTO `t_type` VALUES (2, 'Spring');
INSERT INTO `t_type` VALUES (3, '异常日志');
INSERT INTO `t_type` VALUES (4, 'Spring Boot');
INSERT INTO `t_type` VALUES (5, 'MyBatis');
INSERT INTO `t_type` VALUES (6, '数据结构与算法');
INSERT INTO `t_type` VALUES (7, 'Java');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'https://i.loli.net/2020/08/10/kIHKbmnr2ySRDPd.jpg', '2020-07-24 19:05:15', 'test@126.com', '叩丁猫', '$2a$10$IlnkSUSZI5ZaQF9bKSVKGOMmJdGnHxEx9GaOzcHd.AFYc3DQNqetO', 0, '2020-07-24 19:06:46', 'tom');
INSERT INTO `t_user` VALUES (2, 'http://suo.im/6lQOlM', '2020-08-04 10:10:30', 'test@126.com', '泰斯特', '202cb962ac59075b964b07152d234b70', 0, '2020-08-04 10:10:54', 'test');
INSERT INTO `t_user` VALUES (3, NULL, NULL, NULL, '熊二', '$2a$10$IlnkSUSZI5ZaQF9bKSVKGOMmJdGnHxEx9GaOzcHd.AFYc3DQNqetO', NULL, NULL, '123');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `uid` bigint(10) NOT NULL,
  `rid` bigint(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 1, 1);
INSERT INTO `t_user_role` VALUES (2, 2, 2);

SET FOREIGN_KEY_CHECKS = 1;
