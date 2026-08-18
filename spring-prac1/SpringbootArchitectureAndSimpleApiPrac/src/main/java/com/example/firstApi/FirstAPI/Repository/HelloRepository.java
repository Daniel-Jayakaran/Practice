package com.example.firstApi.FirstAPI.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
    public HelloRepository() {
        System.out.println("Repository Constructor Called");
    }
}
