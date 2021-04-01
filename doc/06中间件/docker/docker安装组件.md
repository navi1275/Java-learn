
 * 安装zookeeper

```shell
$ docker run -d --name zookeeper -p 2181:2181 wurstmeister/zookeeper

# 进入容器
$ docker exec -it zookeeper /bin/sh

# 容器的bash居然不支持tab补全......
```




 * 安装kafka

`KAFKA_BROKER_ID` 设置brokerid

`KAFKA_ZOOKEEPER_CONNECT`设置zookeeper管理kafka路径

`KAFKA_ADVERTISED_LISTENERS` kafka注册

`KAFKA_LISTENERS` kafka监听端口

`-v /etc/localtime:/etc/localtime` docker容器同步虚拟机时间

 ```shell
    $ docker run -d --name kafka -p 9092:9092 \
    -e KAFKA_BROKER_ID=0 \ 
    -e KAFKA_ZOOKEEPER_CONNECT=10.211.55.8:2181/kafka \
    -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://10.211.55.8:9092 \
    -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 \
    -v /etc/localtime:/etc/localtime wurstmeister/kafka
    
    # 进入容器
    $ docker exec -it kafka /bin/sh
    # 进入路径
    $ cd /opt/kafka_2.11-2.0.0/bin
    # 运行生产者程序
    $ ./kafka-console-producer.sh --broker-list localhost:9092 --topic test
    # 运行消费者程序
    $ ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
    
    
 ```

 * 安装zipkin
```shell
    $ docker run -d -p 9411:9411 openzipkin/zipkin
    
    # zipkin 连接kafka
    $ docker run -d --name zipkin-kafka -p 9411:9411 \
    -e KAFKA_BOOTSTRAP_SERVERS=10.211.55.8:9092  openzipkin/zipkin
```