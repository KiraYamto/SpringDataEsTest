package org.bobo;

import org.bobo.es.CrudRepository;
import org.bobo.es.model.ImMessage;
import org.bobo.es.repository.MessageRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SpringStart {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/spring-application.xml");
        MessageRepository messageRepository = (MessageRepository)ctx.getBean("messageRepository");
        ImMessage message1 = messageRepository.findOne(1);
        System.out.println(message1.getMessageContent());


    }
}
