package com.navi.consumer.web;

import com.navi.consumer.dto.DeptDTO;
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

    @GetMapping("/get/{id}")
    public DeptDTO get(@PathVariable Integer id) {
        ResponseEntity<DeptDTO> responseEntity = restTemplate.getForEntity(SERVICE_HOST + "/provider/dept/get/" + id, DeptDTO.class);

        return responseEntity.getBody();

    }

    @GetMapping("/list")
    public List<DeptDTO> list() {
        return restTemplate.getForObject(SERVICE_HOST + "/provider/dept/list", List.class);
    }
}
