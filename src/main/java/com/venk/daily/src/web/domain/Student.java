package com.venk.daily.src.web.domain;


import java.util.Objects;

public class Student implements Cloneable {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年级
     */
    private String grade;

    /**
     * 学校
     */
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

    /**
     * 使用构建器构造多参数对象
     */
    public static class Builder {
        private String name;
        private int age;
        private String sex = "";
        private String grade = "";
        private School school;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder grade(String grade) {
            this.grade = grade;
            return this;
        }

        public Builder school(School school) {
            this.school = school;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    private Student(Builder builder) {
        this.age = builder.age;
        this.name = builder.name;
        this.sex = builder.sex;
        this.grade = builder.grade;
        this.school = builder.school;
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

    /**
     * 深拷贝(将组合对象同样拷贝)
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.school = (School) school.clone();
        return student;
    }

    /**
     * 深克隆测试demo
     * Cloneable接口无方法，clone方法来自Object类，修饰符是protected native。
     * Cloneable接口因与Object类处于同一个包下，所以能继承clone方法，继承Cloneable接口成为它的子类同样也就继承了clone方法
     * native：一个Native Method是一个java调用非java代码的接口，该方法的实现由非java语言实现，比如C。
     * @param args
     */
    public static void main(String[] args) {
        //School xaufe = new School("XAUFE", "Xi'an");
        School xaufe = School.getInstance();
        xaufe.setName("XAUFE");
        xaufe.setAddress("Xi'an");

        Student lee = new Builder("lee", 20).school(xaufe).build();
        Student leeSame = lee;
        System.out.println(lee.hashCode() == leeSame.hashCode()); // true
        System.out.println(lee.equals(leeSame)); // true
        System.out.println(lee == leeSame); // true
        System.out.println(lee.school.equals(leeSame.school)); // true
        System.out.println(lee.school == leeSame.school); // true
        System.out.println("------");
        try {
            Student leeClone = (Student) lee.clone();
            System.out.println(lee.hashCode() == leeClone.hashCode()); // true
            System.out.println(lee.equals(leeClone)); // true
            System.out.println(lee == leeClone); // false
            System.out.println(lee.school.equals(leeClone.school)); // true
            System.out.println(lee.school == leeClone.school); // false
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
