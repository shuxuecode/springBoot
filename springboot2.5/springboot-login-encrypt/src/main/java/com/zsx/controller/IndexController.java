package com.zsx.controller;

import com.zsx.config.RsaUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 */
@Controller
public class IndexController {


    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @GetMapping("/home")
    public ModelAndView home(HttpServletRequest request) {

        String[] keys = RsaUtils.generateKey();

        String publicKey = keys[0];
        String privateKey = keys[1];

        HttpSession session = request.getSession();
        session.setAttribute("publicKey", publicKey);
        session.setAttribute("privateKey", privateKey);

        ModelAndView view = new ModelAndView("home");
        view.addObject("key", publicKey);
        return view;
    }

}
