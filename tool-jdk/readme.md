# tooljdk

基于maven的java工具

## 记录

| 功能 | 工具位置 | 描述 |
|--------|--------|--------|
| 拼音转换 | `com.sauzny.tooljdk.pinyin` | 将汉字转换为拼音[【注1】](#jump_1) |
| 进制转换 | `com.sauzny.tooljdk.hexconverte` | 2，8，10，16进制之间相互转换 |
| ip地址 | `com.sauzny.tooljdk.ip` | 获取ip，ip转换，ip掩码 |
| 金钱相关 | `com.sauzny.tooljdk.money` | 元分转换，转汉字金钱 |
| 补位格式化 | `com.sauzny.tooljdk.supplychar` | 补位格式化，左补0，右补0 |
| 唯一id生成 | `com.sauzny.tooljdk.uniqid` | java1.7版本使用AtomicLong，java1.8版本使用LongAdder |
| 数学公式 | `com.sauzny.tooljdk.math` | 数学常用公式 |
| ascii | `com.sauzny.tooljdk.ascii` | ascii转换 |
| cmd | `com.sauzny.tooljdk.cmd` | 调用本地cmd |
| rsa | `com.sauzny.tooljdk.rsa` | 非对称加密RSA的加密解密 |

* * *

注1：对于多音字是无法准确识别的。
