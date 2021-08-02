package com.spring.Proxy.JdkProxy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.spring.Proxy.JdkProxy")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
