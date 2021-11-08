package com.zsx.controller;

import com.zsx.service.DemoService;
import com.zsx.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shuxuezhao
 * @date 2021/11/8
 */
@Controller
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping
    public String index() {
        return "/index";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<UserVO> list() {
        return demoService.list();
    }
}
