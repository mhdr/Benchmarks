package com.example.demo;

import com.example.demo.lib.DB;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DB.usersRepository = applicationContext.getBean(UsersRepository.class);
    }
}
