# LearningAndPractice
Redis 和 quill Demo记录
MapperDao && Mybatis-Scala Demo

Quill相关问题验证
1) 数据库中没有表时,是否会自动依据case class对象创建表
   不会, 若数据库中没有表,运行时将报异常错误: com.twitter.finagle.exp.mysql.ServerError: Table 'cpdailyspace.student' doesn't exist

2) 是否会向数据表中自动新增/删除字段
   新增异常: com.twitter.finagle.exp.mysql.ServerError: Unknown column 'tem' in 'field list'
   删除字段: 在case class对象中删除一个字段,并不会自动更新表,此时若做插入操作,则非主键字段值为空, 主键字段默认赋值0
   更改字段名: 不会自动更新表

3) 枚举类型的支持
   object Margin extends Enumeration {
     type Margin = Value
     val TOP, BOTTOM, LEFT, RIGHT = Value
   }

   case class Orders(id: Int, ref: String, cla: String)  // cla 在数据库表中为enum类型
   支持增删改查,枚举类型以String的形式即可

4) SQL注入的预防措施
   封装的finagle-mysql,最终调用的是finagle-mysql的PreparedStatement, 通过
   def executeQuery[T](sql: String, prepare: List[Parameter] => List[Parameter] = identity, extractor: Row => T = identity[Row] _): Future[List[T]]
   进行了一层封装
   Cassandra也一样

5) 连接池设置
   使用com.twitter.finagle.pool下的WatermarkPool


6) 复杂语句的支持

7) 事务机制
   用的finagle-mysql的事务处理





1、SQL注入攻击
2、跨站脚本攻击 - XSS
3、跨站伪造请求攻击 - CSRF
4、文件上传漏洞攻击
5、分布式拒绝服务攻击 - DDOS




