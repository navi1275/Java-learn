package com.navi.consumer.fallback;

import com.navi.consumer.dto.DeptDTO;
import com.navi.consumer.service.DeptService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * DeptFallbackFactory Class
 *
 * @author navi
 * @date 2019-04-17
 * @since 1.0.0
 */
@Component
@RequestMapping("/fallback/consumer/dept")
public class DeptFallback implements DeptService {
    @Override
    public boolean saveDept(DeptDTO dept) {
        return false;
    }

    @Override
    public boolean deleteDeptById(Integer id) {
        return false;
    }

    @Override
    public boolean updateDept(DeptDTO dept) {
        return false;
    }

    @Override
    public DeptDTO selectDeptById(Integer id) {
        DeptDTO deptDTO = new DeptDTO();
        deptDTO.setId(id);
        deptDTO.setDeptName("我不是一个科室");
        return deptDTO;
    }

    @Override
    public List<DeptDTO> selectAllList() {
        return null;
    }
}
