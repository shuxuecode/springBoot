
# https://gitee.com/smart-doc-team/smart-doc


> smart-doc是一款同时支持java restful api和apache dubbo rpc接口文档生成的工具，smart-doc颠覆了传统类似swagger这种大量采用注解侵入来生成文档的实现方法。 smart-doc完全基于接口源码分析来生成接口文档，完全做到零注解侵入，你只需要按照java标准注释编写，smart-doc就能帮你生成一个简易明了的markdown 或是一个像GitBook样式的静态html文档。如果你已经厌倦了swagger等文档工具的无数注解和强侵入污染，那请拥抱smart-doc吧！

## 功能特性
- 零注解、零学习成本、只需要写标准java注释。
- 基于源代码接口定义自动推导，强大的返回结构推导。
- 支持Spring MVC,Spring Boot,Spring Boot Web Flux(controller书写方式)。
- 支持Callable,Future,CompletableFuture等异步接口返回的推导。
- 支持JavaBean上的JSR303参数校验规范，支持分组验证。
- 对json请求参数的接口能够自动生成模拟json参数。
- 对一些常用字段定义能够生成有效的模拟值。
- 支持生成json返回值示例。
- 支持从项目外部加载源代码来生成字段注释(包括标准规范发布的jar包)。
- 支持生成多种格式文档：Markdown、HTML5、Asciidoctor、Postman collection。
- 轻易实现在Spring Boot服务上在线查看静态HTML5 api文档。
- 开放文档数据，可自由实现接入文档管理系统。
- 一款代码注释检测工具，不写注释的小伙伴逃不过法眼了。
- 插件式快速集成(支持maven和gradle插件)。
- 支持apache dubbo rpc文档生成。

## Smart-doc vs Swagger

- smart-doc不是对Swagger造轮子，这是一款用完全不同的理念重新开发的restful api接口文档生成工具。
- smart-doc比swagger集成更简单，可以自由生成多种格式的api文档。
- smart-doc完全不需要在侵入到业务代码中写任何注解，插件化集成到项目。
- smart-doc提供了许多swagger没有功能，例如：字典码、业务错误码导出到文档，dubbo rpc接口文档生成。