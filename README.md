# 人事管理系统

## 环境搭建

### MySQL

```shell script
docker pull mysql:5.7

docker run --name mysql \
--privileged=true \
-p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=yueliminvc@outlook.com \
-d mysql:5.7
```

### Zookeeper

```shell script
docker pull zookeeper:3.4.13

docker run -id --name zookeeper \
--privileged=true \
-p 2181:2181 \
zookeeper:3.4.13
```
