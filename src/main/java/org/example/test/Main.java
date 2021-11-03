package org.example.test;

import org.example.test.service.FileParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        FileParser parser = context.getBean(FileParser.class);
        parser.templateMethod();
    }
}
