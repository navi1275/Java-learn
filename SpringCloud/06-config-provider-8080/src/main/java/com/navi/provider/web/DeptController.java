package com.navi.provider.web;

import com.navi.provider.entity.Dept;
import com.navi.provider.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/provider/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @Value("${dept.suffix}")
    private String suffix;


    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = client.getServices();
        for (String name:services){
            List<ServiceInstance> instances =
                    client.getInstances(name);
            for (ServiceInstance instance :instances){
                String instanceId = instance.getInstanceId();

                URI uri = instance.getUri();
                String host = instance.getHost();
                int port = instance.getPort();

                log.info("{} - {}:{} - {}", instanceId, host, port, uri.toString());
            }
        }

        return services;
    }

    @PostMapping("/save")
    public Boolean save(@RequestBody Dept dept) {
        dept.setDeptName(dept.getDeptName() + suffix);
        return deptService.saveDept(dept);
    }

    @PostMapping("/delete/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return deptService.deleleDeptById(id);
    }


    @PostMapping("/update")
    public Boolean update(@RequestBody Dept dept) {
        return deptService.updateDept(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable Integer id) {

        return deptService.selectDeptById(id);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return deptService.selectAllList();
    }
}
