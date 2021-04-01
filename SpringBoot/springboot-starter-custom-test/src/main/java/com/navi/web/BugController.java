package com.navi.web;

import com.navi.dto.BaseResponseDTO;
import com.navi.dto.ReqDTO;
import com.navi.springbootstartercustomer.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * BugController Class
 *
 * @author navi
 * @date 2019-04-10
 * @since 1.0.0
 */
@RestController
@RequestMapping("/bug")
public class BugController {

    @Autowired
    private CustomService customService;

    @PostMapping("/allocate")
    private Object bug(@RequestBody ReqDTO dto) {

        BaseResponseDTO responseDTO = new BaseResponseDTO();

        for (int i = 0; i < dto.getNum(); i++) {
            byte[] bytes = new byte[dto.getMem() * 1024 * 1024];
        }

        responseDTO.setMsg("ok");
        responseDTO.setCode("0");

        return responseDTO;
    }

    @GetMapping("/custom")
    private Object custom(String content){
        return customService.wrap(content);
    }

}
