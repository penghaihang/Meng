package com.peng.meng.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

  @RequestMapping("/login")
  public String login() {

    // return "/user/login2";
    return "/index";
  }

  @RequestMapping("/index")
  public String index() {
    return "/admin/index";
  }
}
