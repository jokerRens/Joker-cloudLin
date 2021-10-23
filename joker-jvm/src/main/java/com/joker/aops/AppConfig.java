package com.joker.aops;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = {com.joker.aops.IBuy.class})
@EnableAspectJAutoProxy(proxyTargetClass = true) // 开启AOP
public class AppConfig {


}
