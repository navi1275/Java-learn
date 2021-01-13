1. 搜索rocketmq镜像

```powershell
➜  ~ docker search rocketmq
```

使用`foxiswho/rocketmq`镜像

2. 查看镜像所有的版本shell命令

```powershell
➜  ~ curl https://registry.hub.docker.com/v1/repositories/foxiswho/rocketmq/tags\
> | tr -d '[\[\]" ]' | tr '}' '\n'\
> | awk -F: -v image='foxiswho/rocketmq' '{if(NR!=NF && $3 != ""){printf("%s:%s\n",image,$3)}}'
```

3. 下拉`broker`、`nameserver`和管理控制台的镜像

```powershell
➜  ~ docker pull foxiswho/rocketmq:broker-4.5.2
➜  ~ docker pull foxiswho/rocketmq:server-4.5.2
➜  ~ docker pull styletang/rocketmq-console-ng
```

4. 启动镜像

```powershell
➜  ~ docker run -d -p 9876:9876 --name rmqserver foxiswho/rocketmq:server-4.5.2
6e6154a16bfe
➜  ~ docker run -d -p 10911:10911 -p 10909:10909 \
> --name rmqbroker -e "JAVA_OPTS=-Duser.home=/opt" \
> -e "JAVA_OPT_EXT=-server -Xms128m -Xmx128m" \
> -v /gdata/rocketmq/conf/broker.conf:/etc/rocketmq/broker.conf \
> foxiswho/rocketmq:broker-4.5.2
a6242dfaee583b2f9ca0a42ed831ff183fb2ce4728aaf909407ae582ceb72639
➜  ~ docker run  -d --name rmqconsole -p 8180:8080 -e "JAVA_OPTS=-Drocketmq.namesrv.addr=10.211.55.8:9876 -Dcom.rocketmq.sendMessageWithVIPChannel=false" \
-t styletang/rocketmq-console-ng
```





