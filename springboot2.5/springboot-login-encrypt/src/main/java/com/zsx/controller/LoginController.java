package com.zsx.controller;

import com.zsx.config.RsaUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Controller
public class LoginController {


    @PostMapping("loginAction")
    @ResponseBody
    public String loginAction(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username = " + username);
        System.out.println("password = " + password);

        String privateKey = (String) request.getSession().getAttribute("privateKey");
        System.out.println("privateKey = " + privateKey);

        String decryptPwd = RsaUtils.decrypt(password, privateKey);

        System.out.println("decryptPwd = " + decryptPwd);


        return "ok";
    }


}
