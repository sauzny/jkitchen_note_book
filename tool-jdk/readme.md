## jkitchen_tool

基于maven的java工具

**记录**

| 功能 | 工具位置 | 描述 |
|--------|--------|--------|
| 拼音转换 | `com.sauzny.jkitchen_tool.pinyin` | 将汉字转换为拼音[【注1】](#jump_1) |
| 进制转换 | `com.sauzny.jkitchen_tool.hexconverte` | 2，8，10，16进制之间相互转换 |
| ip地址 | `com.sauzny.jkitchen_tool.ip` | 获取ip，ip转换，ip掩码 |
| 金钱相关 | `com.sauzny.jkitchen_tool.money` | 元分转换，转汉字金钱 |
| 补位格式化 | `com.sauzny.jkitchen_tool.supplychar` | 补位格式化，左补0，右补0 |
| 唯一id生成 | `com.sauzny.jkitchen_tool.uniqid` | java1.7版本使用AtomicLong，java1.8版本使用LongAdder |
| 数学公式 | `com.sauzny.jkitchen_tool.math` | 数学常用公式 |
| ip转地址 | `com.sauzny.jkitchen_tool.ipipnet` | 使用ipipnet获取省市，速度很快。0.2-0.7毫秒 |
| ascii | `com.sauzny.jkitchen_tool.ascii` | ascii转换 |
| cmd | `com.sauzny.jkitchen_tool.cmd` | 调用本地cmd |
| reflect | `com.sauzny.jkitchen_tool.reflect` | 反射工具类 |
| rsa | `com.sauzny.jkitchen_tool.rsa` | 非对称加密RSA的加密解密 |
| 二维码 | `com.sauzny.jkitchen_tool.zxing` | 生成和解析二维码，可带logo |
| 制作建表SQL | `com.sauzny.jkitchen_tool.entity.DBUtils` | 根据实体类，生成SQL建表语句 |

* * *

注1：对于多音字是无法准确识别的。
