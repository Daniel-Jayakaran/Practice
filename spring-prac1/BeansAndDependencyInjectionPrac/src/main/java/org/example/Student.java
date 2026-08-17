package org.example;

public class Student {
    private int age;
    private int rno;
    private Writer writer;

    public Student(int age, int rno, Writer writer){
        this.age = age;
        this.rno = rno;
        this.writer = writer;
    }

    public Student(){

    }

    public void setWriter (Writer writer){
        this.writer = writer;
    }
//    private Pen pen;

//    public void setPen(Pen pen){
//        this.pen = pen;
//    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age) {
//        System.out.println("Setter is getting called..");
        if(age < 0) age = 0;
        else this.age = age;
    }
//    public Student() {
//        System.out.println("Student is Created..");
//    }
    public void show() {
        System.out.println("Student details show methods exec.");
    }
    public void writingExam () {
        writer.write();
    }
}
