

## MapStruct

### 官方文档

https://mapstruct.org/documentation/stable/reference/html/#basic-mappings


MapStruct是一个Java注释处理器，用于生成类型安全的bean映射类。

您要做的就是定义一个映射器接口，该接口声明任何必需的映射方法。在编译期间，MapStruct将生成此接口的实现。此实现使用简单的Java方法调用在源对象和目标对象之间进行映射，即没有反射或类似内容。

与手动编写映射代码相比，MapStruct通过生成繁琐且易于出错的代码来节省时间。遵循配置方法上的约定，MapStruct使用合理的默认值，但在配置或实现特殊行为时不加理会。
与动态映射框架相比，MapStruct具有以下优点：

1. 通过使用普通方法调用（settter/getter）而不是反射来快速执行
2. 编译时类型安全性：只能映射相互映射的对象和属性，不能将order实体意外映射到customer DTO等。
3. 如果有如下问题，编译时会抛出异常
   1. 映射不完整（并非所有目标属性都被映射）
   2. 映射不正确（找不到正确的映射方法或类型转换）
4. 可以通过freemarker定制化开发

---

同时与动态映射框架相比，MapStruct具有以下优点：

1. 速度快：使用普通的方法代替反射
2. 编译时类型安全性 : 只能映射彼此的对象和属性，不会将商品实体意外映射到用户DTO等



## pom依赖


## 使用方法

如果不指定@Mapping，默认映射name相同的field
如果映射的对象field name不一样，通过 @Mapping 指定。
忽略字段加@Mapping#ignore() = true

### 指定默认值

@Mapping(target = "describe", source = "describe", defaultValue = "默认值")


### 使用表达式

@Mapping(target = "createTime",expression = "java(new java.util.Date())")

**注意**： 这个属性不能与source()、defaultValue()、defaultExpression()、qualifiedBy()、qualifiedByName()或constant()一起使用。


### 时间格式化

@Mapping(target = "createTime" ,source = "createTime", dateFormat = "yyyy-MM-dd")

如果属性从字符串映射到日期，则该格式字符串可由SimpleDateFormat处理，反之亦然。当映射枚举常量时，将忽略所有其他属性类型。

### 嵌套映射

```java
@Data
public class Person {
	...
	private Child personChild;
	...
}
@Data
public class PersonDTO {
	...
    private Child child;
    ...
}
// mapper
@Mapper(uses =DateFormtUtil.class)
public interface PersonMapper {

    PersonMapper INSTANCT = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "child", source = "personChild")
    PersonDTO conver(Person person);

}
```

### numberFormat

如果带注释的方法从数字映射到字符串，则使用DecimalFormat将格式字符串作为可处理的格式。反之亦然。对于所有其他元素类型，将被忽略。
从基本2.1 基本映射可以看出，number类型与字符串直接的转换是通过valueOf()，如果字符串格式不正确会抛出java.lang.NumberFormatException异常,例如：Integer.valueOf(“10.2”)

使用numberFormat()之后DecimalFormat格式转换，还是会抛出NFE异常

@Mapping(target = "age",source = "age", numberFormat = "#0.00")





