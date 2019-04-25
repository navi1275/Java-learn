package com.navi.consumer.web;

import com.navi.consumer.dto.DeptDTO;
import com.navi.consumer.service.DeptService;
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

    @Autowired
    private DeptService deptService;

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

    // @HystrixCommand(fallbackMethod = "errorHandle")
    @GetMapping("/get/{id}")
    public DeptDTO get(@PathVariable Integer id) {
        return deptService.selectDeptById(id);

    }

    // public DeptDTO errorHandle(Integer id) {
    //     DeptDTO deptDTO = new DeptDTO();
    //     deptDTO.setId(id);
    //     deptDTO.setDeptName("我不是一个科室,方法");
    //     return deptDTO;
    // }

    @GetMapping("/list")
    public List<DeptDTO> list() {
        return deptService.selectAllList();
    }
}
