# java语法

## jdk9

| 序号 | 特性                               | 代码        |
|----|----------------------------------|-----------|
| 1  | 集合框架引入了一组新的工厂方法                  | Solution1 |
| 2  | 私有接口方法                           | Solution2 |
| 3  | ProcessHandle 类，它代表一个本地操作系统进程的句柄 | Solution3 |
| 4  | ProcessBuilder 类添加了一些新的方法        | Solution4 |
| 5  | 改进的一些Stream API功能                | Solution5 |
| 6  | 以在try关键字之后声明资源的匿名变量              | Solution6 |
| 7  | 钻石操作符的适用范围得到了扩展                  | Solution7 |
| 8  | 改进的 Optional 类几个方法               | Solution8 |

## jdk10

| 序号  | 特性                                                  | 特性                    | 代码          |
|-----|-----------------------------------------------------|-----------------------|-------------|
| 286 | Local-Variable Type Inference                       | 局部变量类型推断              | Solution286 |
| 296 | Consolidate the JDK Forest into a Single Repository | JDK库的合并               | 
| 304 | Garbage-Collector Interface                         | 统一的垃圾回收接口             |
| 307 | Parallel Full GC for G1                             | 为G1提供并行的Full GC       |
| 310 | Application Class-Data Sharing                      | 应用程序类数据（AppCDS）共享     |
| 312 | Thread-Local Handshakes                             | ThreadLocal握手交互       |
| 313 | Remove the Native-Header Generation Tool (javah)    | 移除JDK中附带的javah工具      |
| 314 | Additional Unicode Language-Tag Extensions          | 使用附加的Unicode语言标记扩展    |
| 316 | Heap Allocation on Alternative Memory Devices       | 能将堆内存占用分配给用户指定的备用内存设备 |
| 317 | Experimental Java-Based JIT Compiler                | 使用基于Java的JIT编译器       |
| 319 | Root Certificates                                   | 根证书                   |
| 322 | Time-Based Release Versioning                       | 基于时间的发布版本             |


## jdk11

| 序号  | 特性                                                          | 特性                          | 代码          |
|-----|-------------------------------------------------------------|-----------------------------|-------------|
| 181 | Nest-Based Access Control                                   | 基于嵌套的访问控制                   | Solution181 |
| 309 | Dynamic Class-File Constants                                | 动态类文件常数                     |
| 315 | Improve Aarch64 Intrinsics                                  | 改进 Aarch64内部结构              |
| 318 | Epsilon: A No-Op Garbage Collector                          | Epsilon: 一个不可操作的垃圾收集器       |
| 320 | Remove the Java EE and CORBA Modules                        | 删除 JavaEE 和 CORBA 模块        |
| 321 | HTTP Client (Standard)                                      | HTTP 客户端(标准)                | Solution321 |
| 323 | Local-Variable Syntax for Lambda Parameters                 | Lambda 参数的局部变量语法            | Solution323 |
| 324 | Key Agreement with Curve25519 and Curve448                  | 与 Curve25519和 Curve448的关键协议 |
| 327 | Unicode 10                                                  |                             |
| 328 | Flight Recorder                                             | 飞行记录器                       |
| 329 | ChaCha20 and Poly1305 Cryptographic Algorithms              | ChaCha20和 Poly1305密码算法      |
| 330 | Launch Single-File Source-Code Programs                     | 启动单文件源代码程序                  |
| 331 | Low-Overhead Heap Profiling                                 | 低开销堆分析                      |
| 332 | Transport Layer Security (TLS) 1.3                          | 传输层安全(TLS)1.3               |
| 333 | ZGC: A Scalable Low-Latency Garbage Collector(Experimental) | ZGC: 一个可伸缩的低延迟垃圾收集器(实验)     |
| 335 | Deprecate the Nashorn JavaScript Engine                     | 废弃 Nashorn JavaScript 引擎    |
| 336 | Deprecate the Pack200 Tools and API                         | 废弃 Pack200工具和 API           |


| 序号 | 特性                            | 代码        |
|----|-------------------------------|-----------|
| 1  | String类添加了一些新方法               | Solution1 |
| 2  | Files类添加了一些静态方法               | Solution2 |
| 3  | Collection接口新增了一个重载的toArray方法 | Solution3 |
|    | 移除 JavaFX                     |           |

## jdk12

| 序号  | 特性                                                            | 特性                         | 代码          |
|-----|---------------------------------------------------------------|----------------------------|-------------|
| 189 | Shenandoah: A Low-Pause-Time Garbage Collector (Experimental) | Shenandoah: 低暂停时间垃圾收集器(实验) |             |
| 230 | Microbenchmark Suite                                          | 微基准测试套件                    |             |
| 325 | Switch Expressions (Preview)                                  | 开关表达式(预览)                  | Solution325 |
| 334 | JVM Constants API                                             | JVM 常量 API                 |             |
| 340 | One AArch64 Port, Not Two                                     | 一个 AArch64端口，不是两个          |             |
| 341 | Default CDS Archives                                          | 默认的 CDS 存档                 |             |
| 344 | Abortable Mixed Collections for G1                            | 可流产的 G1混合集合                |             |
| 346 | Promptly Return Unused Committed Memory from G1               | 从 G1及时返回未使用的提交内存           |             |

## jdk13

| 序号  | 特性                                | 特性            | 代码          |
|-----|-----------------------------------|---------------|-------------|
| 350 | Dynamic CDS Archives              | 动态 CDS 存档     |             |
| 351 | ZGC: Uncommit Unused Memory       | 取消未使用内存       |             |
| 353 | Reimplement the Legacy Socket API | 重新实现遗留套接字 API |             |
| 354 | Switch Expressions (Preview)      | 开关表达式(预览)     | Solution354 |
| 355 | Text Blocks (Preview)             | 文本块(预览)       |             |

## jdk14

| 序号  | 特性                                                        | 特性                          | 代码          |
|-----|-----------------------------------------------------------|-----------------------------|-------------|
| 305 | Pattern Matching for instanceof (Preview)                 | Instanceof 的模式匹配(预览)        | Solution305 |
| 343 | Packaging Tool (Incubator)                                | 包装工具(孵化器)                   |             |
| 345 | NUMA-Aware Memory Allocation for G1                       | 基于 NUMA 的 G1内存分配            |             |
| 349 | JFR Event StreamingJFR                                    | 事件流                         |             |
| 352 | Non-Volatile Mapped Byte Buffers                          | 非易失性映射字节缓冲区                 |             |
| 358 | Helpful NullPointerExceptions                             | 有用的 NullPointerException    |             |
| 359 | Records (Preview)                                         | 档案(预览)                      | Solution359 |
| 361 | Switch Expressions (Standard)                             | 开关表达式(标准)                   | Solution361 |
| 362 | Deprecate the Solaris and SPARC Ports                     | 废弃 Solaris 和 SPARC 端口       |             |
| 363 | Remove the Concurrent Mark Sweep (CMS) Garbage Collector  | 删除并发标记扫描(CMS)垃圾收集器          |             |
| 364 | ZGC on macOS                                              |                             |             |
| 365 | ZGC on Windows                                            | Windows 上的 ZGC              |             |
| 366 | Deprecate the ParallelScavenge + SerialOld GC Combination | 不推荐使用并行清除 + SerialOld GC 组合 |             |
| 367 | Remove the Pack200 Tools and API                          | 删除 Pack200工具和 API           |             |
| 368 | Text Blocks (Second Preview)                              | 文本块(第二次预览)                  |             |
| 370 | Foreign-Memory Access API (Incubator)                     | 外部内存访问 API (孵化器)            |             |


| 序号 | 特性                 | 代码        |
|----|--------------------|-----------|
| 1  | Numeral Formatting | Solution1 |

## jdk15

| 序号  | 特性                                               | 特性                        | 代码          |
|-----|--------------------------------------------------|---------------------------|-------------|
| 339 | Edwards-Curve Digital Signature Algorithm        | (EdDSA)曲线数字签名算法           |             |
| 360 | Sealed Classes (Preview)                         | 密封类(预览)                   | Solution360 |
| 371 | Hidden Classes                                   | 隐藏类别                      |             |
| 372 | Remove the Nashorn JavaScript Engine             | 删除 Nashorn JavaScript 引擎  |             |
| 373 | Reimplement the Legacy DatagramSocket API        | 重新实现遗留 DatagramSocket API |             |
| 374 | Disable and Deprecate Biased Locking             | 禁用和取消偏差锁定                 |             |
| 375 | Pattern Matching for instanceof (Second Preview) | 模式匹配(第二次预览)               |             |
| 377 | ZGC: A Scalable Low-Latency Garbage Collector    | ZGC: 一个可伸缩的低延迟垃圾收集器       |             |
| 378 | Text Blocks                                      | 文本块                       | Solution378 |
| 379 | Shenandoah: A Low-Pause-Time Garbage Collector   | Shenandoah: 一个低暂停时间的垃圾收集器 |             |
| 381 | Remove the Solaris and SPARC Ports               | 删除 Solaris 和 SPARC 端口     |             |
| 383 | Foreign-Memory Access API (Second Incubator)     | 外部内存访问 API (第二个孵化器)       |             |
| 384 | Records (Second Preview)                         | 纪录(第二次预览)                 |             |
| 385 | Deprecate RMI Activation for Removal             | 不推荐激活 RMI 以便删除            |             |

## jdk16

| 序号  | 特性                                            | 特性                  | 代码 |
|-----|-----------------------------------------------|---------------------|----|
| 338 | Vector API (Incubator)                        | 矢量 API (孵化器)        |    |
| 347 | Enable C++14 Language Features                | 启用 C + + 14语言特性     |    |
| 357 | Migrate from Mercurial to Git                 | 从 Mercurial 迁移到 Git |    |
| 369 | Migrate to GitHub                             | 迁移到 GitHub          |    |
| 376 | ZGC: Concurrent Thread-Stack Processing       | ZGC: 并发线程堆栈处理       |    |
| 380 | Unix-Domain Socket Channels                   | Unix 域套接字通道         |    |
| 386 | Alpine Linux Port                             | 高山 Linux 端口         |    |
| 387 | Elastic Metaspace                             | 弹性元空间               |    |
| 388 | Windows/AArch64 Port                          | Windows/AArch64端口   |    |
| 389 | Foreign Linker API (Incubator)                | 外部连接器 API (孵化器)     |    |
| 390 | Warnings for Value-Based Classes              | 基于值的类的警告            |    |
| 392 | Packaging Tool                                | 包装工具                |    |
| 393 | Foreign-Memory Access API (Third Incubator)   | 外部内存访问 API (第三孵化器)  |    |
| 394 | Pattern Matching for instanceof               | 模式匹配                |    |
| 395 | Records                                       | 记录                  |    |
| 396 | Strongly Encapsulate JDK Internals by Default | 默认情况下强封装 JDK 内部     |    |
| 397 | Sealed Classes (Second Preview)               | 密封类(第二次预览)          |    |

## jdk17

| 序号  | 特性                                             | 特性                  | 代码          |
|-----|------------------------------------------------|---------------------|-------------|
| 306 | Restore Always-Strict Floating-Point Semantics | 恢复始终严格的浮点语义         |             |
| 356 | Enhanced Pseudo-Random Number Generators       | 增强型伪随机数发生器          | Solution356 |
| 382 | New macOS Rendering Pipeline                   | 新的 macOS 渲染管道       |             |
| 391 | macOS/AArch64 Port                             | MacOS/AArch64端口     |             |
| 398 | Deprecate the Applet API for Removal           | 废弃 Applet API 以便删除  |             |
| 403 | Strongly Encapsulate JDK Internals             | 强封装 JDK 内部结构        |             |
| 406 | Pattern Matching for switch (Preview)          | 开关模式匹配(预览)          |             |
| 407 | Remove RMI Activation                          | 删除 RMI 激活           |             |
| 409 | Sealed Classes                                 | 密封类                 | Solution409 |
| 410 | Remove the Experimental AOT and JIT Compiler   | 删除实验性 AOT 和 JIT 编译器 |             |
| 411 | Deprecate the Security Manager for Removal     | 取消安全管理器以便删除         |             |
| 412 | Foreign Function & Memory API (Incubator)      | 外部函数和内存 API (孵化器)   |             |
| 414 | Vector API (Second Incubator)                  | 矢量 API (第二个孵化器)     |             |
| 415 | Context-Specific Deserialization Filters       | 特定于上下文的反序列化过滤器      |             |

## jdk18

| 序号      | 特性                                              | 特性                     | 代码          |
|---------|-------------------------------------------------|------------------------|-------------|
| JEP 400 | UTF-8 by Default                                | （默认字符集为 UTF-8）         |             |
| JEP 408 | Simple Web Server                               | （简易的 Web 服务器）          |             |
| JEP 413 | Code Snippets in Java API Documentation         | （Java API 文档中的代码片段）    |             |
| JEP 416 | Reimplement Core Reflection with Method Handles | （使用方法句柄重新实现反射核心）       |             |
| JEP 417 | Vector                                          | （向量） API（第三次孵化）        | Solution417 |
| JEP 418 | Internet-Address Resolution                     | （互联网地址解析）SPI           |             |
| JEP 419 | Foreign Function & Memory API                   | （外部函数和内存 API）（第二次孵化）   |             |
| JEP 420 | Pattern Matching for switch                     | （switch 模式匹配）（第二次预览）   |             |
| JEP 421 | Deprecate Finalization for Removal              | （废弃 Finalization 以便删除） |             |

## jdk19

| 序号      | 特性                            | 特性                | 代码          |
|---------|-------------------------------|-------------------|-------------|
| JEP 405 | Record Patterns               | （记录模式）（预览）        |             |
| JEP 422 | Linux/RISC-V Port             |                   |             |
| JEP 424 | Foreign Function & Memory API | （外部函数和内存 API）（预览） | Solution424 |
| JEP 425 | Virtual Threads               | （虚拟线程）（预览）        |             |
| JEP 426 | Vector                        | （向量）API（第四次孵化）    |             |
| JEP 427 | Pattern Matching for switch   | （switch 模式匹配）     |             |
| JEP 428 | Structured Concurrency        | （结构化并发）（孵化）       | Solution428 |

## jdk20

| 序号      | 特性                            | 特性                   | 代码 |
|---------|-------------------------------|----------------------|----|
| JEP 429 | Scoped Values                 | （作用域值）（第一次孵化）        |    |
| JEP 432 | Record Patterns               | （记录模式）（第二次预览）        |    |
| JEP 433 | switch                        | 模式匹配（第四次预览）          |    |
| JEP 434 | Foreign Function & Memory API | （外部函数和内存 API）（第二次预览） |    |
| JEP 436 | Virtual Threads               | （虚拟线程）（第二次预览）        |    |
| JEP 437 | Structured Concurrency        | （结构化并发）(第二次孵化)       |    |
| JEP 432 |                               | 向量 API（第五次孵化）        |    |

## jdk21

| 序号      | 特性                                        | 特性                     | 代码          |
|---------|-------------------------------------------|------------------------|-------------|
| JEP 430 | String Templates                          | （字符串模板）（预览）            |             |
| JEP 431 | Sequenced Collections                     | （序列化集合）                | Solution431 |
| JEP 439 | Generational ZGC                          | （分代 ZGC）               |             |
| JEP 440 | Record Patterns                           | （记录模式）                 | Solution440 |
| JEP 441 | Pattern Matching for switch               | （switch 的模式匹配）         | Solution441 |
| JEP 442 | Foreign Function & Memory API             | （外部函数和内存 API）（第三次预览）   |             |
| JEP 443 | Unnamed Patterns and Variables            | （未命名模式和变量（预览）          |             |
| JEP 444 | Virtual Threads                           | （虚拟线程）                 | Solution444 |
| JEP 445 | Unnamed Classes and Instance Main Methods | （未命名类和实例 main 方法 ）（预览） |             |
