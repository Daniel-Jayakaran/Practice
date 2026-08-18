package org.example.config;

import org.example.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("org.example")
public class MyConfiguration {
//    @Bean(name = "s1")
//    public Student std(@Autowired @Qualifier("pen") Writer writer) {
//        Student st = new Student();
//        st.setRno(25);
//        st.setWriter(writer);
//        return st;
//    }
//
//    @Bean
//    public Pen pen() {
//        return new Pen();
//    }
//
//    @Bean
//    public Pencil pencil() {
//        return new Pencil();
//    }
//
//    @Bean
//    @Primary
//    public Sketch sketch() {
//        return new Sketch();
//    }
}
