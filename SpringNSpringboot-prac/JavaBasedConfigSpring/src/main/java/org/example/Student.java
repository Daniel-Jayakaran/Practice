package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("25")
    private int rno;

    // Constructor Injection
    @Autowired
    public Student(@Qualifier("pencil") Writer writer) {
        this.writer = writer;
    }


//    Field Injection

//    @Autowired
//    @Qualifier("sketch")
    private Writer writer;

    public Writer getWriter() {
        return writer;
    }

//  Setter Injection
//    @Autowired
//    @Qualifier("pen")
    public void setWriter(Writer writer) {
        System.out.println("Setter Called");
        this.writer = writer;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public Student() {
        System.out.println("Student Constructor Called");
    }

    public void show() {
        System.out.println("Showing Student");
    }

    public void writeExam(){
        writer.write();
    }
}
