package com.learnspringboot.learnspring.Controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.learnspringboot.learnspring.customer.*;



@RestController
public class FirstController {

    @GetMapping("/hello-2")
    // @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2(){
        return "Hello 2 from my first controller";
    }

    
    @PostMapping("/post-order")
    public String postMethodName(@RequestBody order myOrder) {        
        return "Your order is: \n"+myOrder.toString();
    }
    @GetMapping("/hello/{user-name}")
    public String getMethodName(@PathVariable("user-name") String param) {
        return "My value is: "+param;
    }
    @GetMapping("/hello")
    public String getFUllname(@RequestParam(name="user-firstName",required=false) String firstname,
    @RequestParam(name="user-lastName",required=false) String lastname
    ) {
        return "Your full name is: "+firstname+" "+lastname;
    }
    
}
