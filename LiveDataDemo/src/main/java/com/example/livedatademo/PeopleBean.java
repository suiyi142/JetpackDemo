package com.example.livedatademo;

/**
 * @CreateDate: 2021-3-10 8:48
 * @UpdateDate: 2021-3-10 8:48
 * @Description:
 * @Author: uidq2189
 * @UpdateRemark:
 * @Version: 1.0
 */
public class PeopleBean {
    private String name;
    private int age;

    public PeopleBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "DataBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
