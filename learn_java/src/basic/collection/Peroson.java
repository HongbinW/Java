package basic.collection;

import java.util.Objects;

public class Peroson {
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

    public Peroson(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Peroson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//重写equals方法，可是其返回值为true
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Peroson peroson = (Peroson) o;
//        return Objects.equals(name, peroson.name) &&
//                Objects.equals(age, peroson.age);
//    }

}
