package com.example.springboot270.req;

/**
 * @date 2023/8/14
 */
public class DemoReq {

    private Integer id;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "DemoReq{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
