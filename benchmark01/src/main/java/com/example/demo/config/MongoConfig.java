package com.example.demo.config;

import com.mongodb.MongoClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {

    @Bean
    @Override
    public MongoClient mongoClient() {
        MongoClient client = new MongoClient("localhost", 27017);
        return client;
    }

    @Override
    protected String getDatabaseName() {
        return "mydb";
    }

    @Bean
    @Override
    public MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate template = new MongoTemplate(mongoClient(), getDatabaseName());

        return template;
    }
}
