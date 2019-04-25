package com.navi.consumer.web;

import com.navi.consumer.dto.DeptDTO;
import com.navi.consumer.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * DeptController Class
 *
 * @author navi
 * @date 2019-04-12
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/consumer/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private ForkJoinPool pool = new ForkJoinPool(5);

    @PostMapping("/save")
    public Boolean save(@RequestBody DeptDTO dept) {
        return deptService.saveDept(dept);
    }

    @PostMapping("/delete/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return deptService.deleteDeptById(id);
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody DeptDTO dept) {
        return deptService.updateDept(dept);

    }

    @HystrixCommand(fallbackMethod = "errorHandle")
    @GetMapping("/get/{id}")
    public DeptDTO get(@PathVariable Integer id, HttpServletRequest request) {
        return deptService.selectDeptById(id);

    }

    public DeptDTO errorHandle(@PathVariable Integer id, HttpServletRequest request) {

        String ip = request.getLocalAddr();
        String key = ip + "_selectDeptById_fallback";

        cacheKey(key);

        DeptDTO deptDTO = new DeptDTO();
        deptDTO.setId(id);
        deptDTO.setDeptName("我不是一个科室,方法");
        return deptDTO;
    }

    private void cacheKey(String key) {

        BoundValueOperations<String, String> operations = redisTemplate.boundValueOps(key);

        String value = operations.get();
        if(value == null){
            synchronized (this){
                value = operations.get();
                if(value == null) {
                    sendForBackMsg(key);
                    value="短信已发送";
                    operations.set(value, 10, TimeUnit.SECONDS);
                }

            }
        }
    }

    private void sendForBackMsg(String key) {
        pool.submit(()->{
            log.warn("发送服务异常警告：{}", key);
        });
    }

    @GetMapping("/list")
    public List<DeptDTO> list() {
        BoundValueOperations<String, String> fallback = redisTemplate.boundValueOps("fallback");
        fallback.set("haha");
        String s = fallback.get();
        System.out.println(s);

        BoundValueOperations<String, String> ops = redisTemplate.boundValueOps("fallback1");
        ops.set("haha1", 30, TimeUnit.SECONDS);
        String s1 = ops.get();
        System.out.println(s1);

        return deptService.selectAllList();
    }
}
