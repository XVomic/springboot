package com.xxc.learnboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnbootApplication.class, args);
	}

}

//被@SpringBootApplication修饰的类位于，因此Spring容器会自动扫描并处理该包及其子包下的所有配置类（@Configuration 注解修饰的类）和组件类（@Component`@Controller`@Service`@Repository等注解修饰的类）
//传统的spring项目中我们使用applicationContext.xml文件定义context:component-scan属性，base-package属性定义自动扫描的包

