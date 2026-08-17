package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        Student student = (Student) context.getBean("std1");
//        Teacher teacher = (Teacher) context.getBean("tchr1");
//        teacher.show();
//        student.setAge(25);
//        System.out.println("Student Roll Number: " + student.getRno() + " ; Student-Age: " + student.getAge());
        student.writingExam();
    }
}
