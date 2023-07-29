

todo




用idea下载jdk17版本


修改相关的编译选项为17


编译报错
Non-parseable POM ~/data/apache-maven-repository/io/opentelemetry/opentelemetry-bom-alpha/1.18.0-alpha/opentelemetry-bom-alpha-1.18.0-alpha.pom: 
processing instruction can not have PITarget with reserved xml name (position: START_DOCUMENT seen \r\n<?xml ... @2:7)  
@ ~/data/apache-maven-repository/io/opentelemetry/opentelemetry-bom-alpha/1.18.0-alpha/opentelemetry-bom-alpha-1.18.0-alpha.pom, line 2, column 7 -> [Help 2]

解决方法：
找到上面的pom文件，把第一行空行删掉，保存即可


```xml

<?xml version="1.0" encoding="UTF-8"?>
<project xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
```


```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
```