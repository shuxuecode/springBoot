

## todo

## 构建Docker镜像：

在你的Spring Boot项目根目录下运行docker build -t your-image-name .命令来构建Docker镜像。
这里的your-image-name是你想要给镜像命名的名称。


## 运行Docker容器：

使用docker run -p host-port:container-port your-image-name命令来运行你的Docker容器。
这里的host-port是你在主机上想要监听的端口，container-port是你在Spring Boot应用程序中配置的端口。