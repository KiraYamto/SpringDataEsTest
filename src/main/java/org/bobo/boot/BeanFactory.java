package org.bobo.boot;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanFactory implements ApplicationContextAware {
      
    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanFactory.applicationContext=applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static Object getBean(String name){
       return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> tClass,String name){
        T bean = null;
        try {
           bean = applicationContext.getBean(tClass,name);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static  <T> T getBean(Class<T> tClass){
        T bean = null;
        try {
            bean = applicationContext.getBean(tClass);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return bean;    }
}