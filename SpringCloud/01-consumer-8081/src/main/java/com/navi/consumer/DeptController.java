package com.navi.consumer;

import com.navi.consumer.dto.DeptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * DeptController Class
 *
 * @author navi
 * @date 2019-04-12
 * @since 1.0.0
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVICE_PATH = "http://localhost:8080/provider/dept/";

    @PostMapping("/save")
    public Boolean save(@RequestBody DeptDTO dept) {
        return restTemplate.postForObject(SERVICE_PATH + "save", dept, Boolean.class);
    }

    @PostMapping("/delete/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return restTemplate.postForObject(SERVICE_PATH + "delete/" + id, null, Boolean.class);
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody DeptDTO dept) {
        return restTemplate.postForObject(SERVICE_PATH + "update", dept, Boolean.class);

    }

    @GetMapping("/get/{id}")
    public DeptDTO get(@PathVariable Integer id) {
        ResponseEntity<DeptDTO> responseEntity = restTemplate.getForEntity(SERVICE_PATH + "get/" + id, DeptDTO.class);

        return responseEntity.getBody();

    }

    @GetMapping("/list")
    public List<DeptDTO> list() {
        return restTemplate.getForObject(SERVICE_PATH + "list", List.class);
    }
}
