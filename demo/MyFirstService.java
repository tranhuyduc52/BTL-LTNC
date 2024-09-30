package com.learnspringboot.learnspring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;



@Component
@PropertySources({
    @PropertySource("classpath:myPropFile")
})
public class MyFirstService {


    MyFirstClass myFirstClass;
    MyFirstClass mySecondClass;
    Environment env;
    // @Value("${my.prop}")
    // public String myPropVar;
    // @Value("${my.int}")
    // public String myIntVar;




    
    @Autowired
    public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass){
        this.myFirstClass=myFirstClass;
    }
    //Recommended way to inject dependencies
    @Autowired
    public void setmySecondClass(@Qualifier("bean2") MyFirstClass mySecondClass){
        this.mySecondClass=mySecondClass;
    }
    @Autowired
    public void setEnvironment(Environment env){
        this.env=env;
    }


    public String readProp(){
        return env.getProperty("my.prop");
    }
    public String tellAStory(){
        return "Service Class is saying: "+myFirstClass.sayHello()+"\n"+mySecondClass.sayHello();
    }
}
