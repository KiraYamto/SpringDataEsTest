package org.bobo.boot;


import org.bobo.es.model.ImMessage;
import org.bobo.es.repository.MessageRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"org.bobo.es.*","org.bobo.util","org.bobo.boot",})
public class ServiceStart {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =SpringApplication.run(ServiceStart.class);
        MessageRepository repository = (MessageRepository)ctx.getBean("messageRepository");

        ImMessage message = repository.findOne(1);
        System.out.println(message.getMessageContent());


    }

}
