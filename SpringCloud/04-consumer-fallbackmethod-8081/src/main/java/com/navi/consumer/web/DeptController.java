package com.navi.consumer.web;

import com.navi.consumer.dto.DeptDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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

    private static final String SERVICE_HOST = "http://navi-demo-provider";


    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/save")
    public Boolean save(@RequestBody DeptDTO dept) {
        return restTemplate.postForObject(SERVICE_HOST + "/provider/dept/save", dept, Boolean.class);
    }

    @PostMapping("/delete/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return restTemplate.postForObject(SERVICE_HOST + "/provider/dept/delete/" + id, null, Boolean.class);
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody DeptDTO dept) {
        return restTemplate.postForObject(SERVICE_HOST + "/provider/dept/update", dept, Boolean.class);

    }

    @HystrixCommand(fallbackMethod = "errorHandle")
    @GetMapping("/get/{id}")
    public DeptDTO get(@PathVariable Integer id) {
        log.info("访问到我了");
        ResponseEntity<DeptDTO> responseEntity = restTemplate.getForEntity(SERVICE_HOST + "/provider/dept/get/" + id, DeptDTO.class);

        return responseEntity.getBody();

    }

    public DeptDTO errorHandle(@PathVariable Integer id) {
        DeptDTO deptDTO = new DeptDTO();
        deptDTO.setId(id);
        deptDTO.setDeptName("我不是一个科室");
        return deptDTO;

    }

    @GetMapping("/list")
    public List<DeptDTO> list() {
        return restTemplate.getForObject(SERVICE_HOST + "/provider/dept/list", List.class);
    }
}
