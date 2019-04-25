package com.navi.web;

import com.navi.dto.BaseResponseDTO;
import com.navi.dto.ReqDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * BugController Class
 *
 * @author navi
 * @date 2019-04-10
 * @since 1.0.0
 */
@Controller
@RequestMapping("/bug")
public class BugController {

    @PostMapping("/allocate")
    @ResponseBody
    private Object bug(@RequestBody ReqDTO dto) {

        BaseResponseDTO responseDTO = new BaseResponseDTO();

        for (int i = 0; i < dto.getNum(); i++) {
            byte[] bytes = new byte[dto.getMem() * 1024 * 1024];
        }

        responseDTO.setMsg("ok");
        responseDTO.setCode("0");

        return responseDTO;
    }

}
