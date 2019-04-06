package com.sdy.mvc01.controller;

/**
 * @author weirdo
 * @data 2019/4/6 12:20
 */
public class abc {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "abc{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
