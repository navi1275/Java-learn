package com.navi.consumer.service;

import com.navi.consumer.dto.DeptDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * DeptService Class
 *
 * @author navi
 * @date 2019-04-12
 * @since 1.0.0
 */
@Service
@FeignClient(value = "navi-demo-provider")
@RequestMapping("/provider/dept")
public interface DeptService {

    @PostMapping("/save")
    boolean saveDept(DeptDTO dept);

    @PostMapping("/delete/{id}")
    boolean deleteDeptById(@PathVariable("id") Integer id);

    @PostMapping("/update")
    boolean updateDept(DeptDTO dept);

    @GetMapping("/get/{id}")
    DeptDTO selectDeptById(@PathVariable("id") Integer id);

    @GetMapping("/list")
    List<DeptDTO> selectAllList();
}
