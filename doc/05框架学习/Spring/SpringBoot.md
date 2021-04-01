# Tomcat调优

![image-20210127175340485](/Users/navi/store/workspace/Java-learn/doc/05框架学习/Spring/SpringBoot.assets/image-20210127175340485.png)

jmeter设置3000个线程请求40次，优化前qps峰值200

tomcat调优配置

```yml
server:
	tomcat:
    uri-encoding: UTF-8
		# 最大工作线程数，默认200，4核8g内存，线程数经验值800
		# 操作系统做线程之间的切换调到是有系统开销的，也不是越大越好
    max-threads: 800
    # 最大线程等待数，默认100
    # 当调用HTTP请求数达到tomcat的最大线程数时，还有新的HTTP请求到来，这时tomcat会将该请求放在等待队列中，这个acceptCount就是指能够接受的最大等待数，默认100。如果等待队列也被放满了，这个时候再来新的请求就会被tomcat拒绝（connection refused）
    accept-count: 1000
    # 最大连接数，默认8192
    max-connections: 20000
    # 最小工作空闲线程数（没有请求保持100个链接），默认10，适当调高一些以便应对突然增长的访问量
    min-spare-threads: 100
```

![image-20210127180327769](/Users/navi/store/workspace/Java-learn/doc/05框架学习/Spring/SpringBoot.assets/image-20210127180327769.png)

优化配置后