package org.example;

import org.example.config.MyConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        ApplicationContext cntx = new AnnotationConfigApplicationContext(MyConfiguration.class);
          Student st = cntx.getBean(Student.class);
//        Student st = (Student) cntx.getBean("s1");
//        System.out.println("Writer ref =" + st.getWriter());
        System.out.println("Roll No: " + st.getRno());
        st.writeExam();
    }
}
