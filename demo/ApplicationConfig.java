package com.learnspringboot.learnspring.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration

//@Profile("clone")
public class ApplicationConfig {
    @Bean
    @Qualifier("bean1")
    public MyFirstClass firstClass()
    {
        return new MyFirstClass("First Bean");
    }
    @Bean
    @Qualifier("bean2")
    //@Primary
    public MyFirstClass secondClass()
    {
        return new MyFirstClass("Second Bean");
    }
}
