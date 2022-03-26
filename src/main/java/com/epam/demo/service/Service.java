package com.epam.demo.service;

public interface Service <T, E>{
    void create(T object);
    T getByEmailAndPassword(String password,String email);
}
