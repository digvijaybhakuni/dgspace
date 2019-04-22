package com.digvijayb.oauth.client.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomeController {


    @RequestMapping("/")
    @ResponseBody
    public String welcome(Principal principal){
        final String name = principal.getName();
        return "Hi Welcome " + name;
    }

}
