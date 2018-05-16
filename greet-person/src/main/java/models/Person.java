package models;

public class Person {
    private String name;
    private Integer time;
    private String greet;

    public Person(String name, Integer time){
        this.name = name;
        this.time = time;
    }

    private Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getGreet() {
        return greet;
    }

    public void setGreet(String greet) {
        this.greet = greet;
    }
}
