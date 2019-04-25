package com.navi.provider.web;

import com.navi.provider.entity.Dept;
import com.navi.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * DeptController Class
 *
 * @author navi
 * @date 2019-04-12
 * @since 1.0.0
 */
@RestController
@RequestMapping("/provider/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/save")
    public Boolean save(@RequestBody Dept dept) {
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
