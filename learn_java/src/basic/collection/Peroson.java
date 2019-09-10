package basic.collection;

import basic.adclass.testDuotai.Person;

import java.util.Comparator;
import java.util.Objects;

public class Peroson implements Comparable {
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

    public Peroson(){
        super();
    }
    public Peroson(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

//    重写equals方法，可是其返回值为true
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peroson peroson = (Peroson) o;
        return Objects.equals(name, peroson.name) &&
            Objects.equals(age, peroson.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

//    @Override
//    public String toString() {
//        return "Peroson{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
    //当向TreeSet中添加Person类的对象时，依据此方法确定按照哪个属性排列
    @Override
    public int compareTo(Object o) {
        if(o instanceof Peroson) {
            Peroson p = (Peroson) o;
//            return this.name.compareTo(p.getName());
//            return this.age.compareTo(p.getAge());
            int i = this.age.compareTo(p.age);
            if(i == 0){
                return this.name.compareTo(p.name);
            }else {
                return i;
            }
        }
        return 0;
    }
}
