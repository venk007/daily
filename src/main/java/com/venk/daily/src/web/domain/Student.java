package com.venk.daily.src.web.domain;


import java.util.Objects;

public class Student implements Cloneable {

    private String name;

    private int age;

    private School school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(school, student.school);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, school);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.school = (School) school.clone();
        return student;
    }

    /**
     * 深克隆demo
     * Cloneable接口无方法，clone方法来自Object类，修饰符是protected native。
     * Cloneable接口因与Object类处于同一个包下，所以能继承clone方法，继承Cloneable接口成为它的子类同样也就继承了clone方法
     * native：一个Native Method是一个java调用非java代码的接口，该方法的实现由非java语言实现，比如C。
     * @param args
     */
    public static void main(String[] args) {
        School xaufe = new School("XAUFE", "Xi'an");
        Student stu1 = new Student("O0O", 20);
        stu1.setSchool(xaufe);
        Student stu2 = stu1;
        System.out.println(stu1.hashCode() == stu2.hashCode());
        System.out.println(stu1.equals(stu2));
        System.out.println(stu1 == stu2);
        System.out.println(stu1.school == stu2.school);
        System.out.println("------");
        try {
            Student stu3 = (Student) stu1.clone();
            System.out.println(stu1.hashCode() == stu3.hashCode());
            System.out.println(stu1.equals(stu3));
            System.out.println(stu1 == stu3);
            System.out.println(stu1.school == stu3.school);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
