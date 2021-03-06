package com.venk.daily.src.web.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class School implements Cloneable {

    private String name;

    private String address;

    /**
     * 静态工厂方法代替构造器
     */
    public static School getInstance() {
        return new School();
    }

    public School() {
    }

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(name, school.name) &&
                Objects.equals(address, school.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
