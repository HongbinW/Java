package basic.IO;

import org.junit.Test;

import java.io.*;

public class TestObjectInputOutputStream {
    //对象流   ObjectInputStream   ObjectOutputStream
    //对象的序列化过程：将内存中的对象通过ObjectOutputStream转换为二进制流，存储在硬盘文件中
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            Person p1 = new Person("ab",23);
            Person p2 = new Person("cd",21);
            oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
            oos.writeObject(p1);
            oos.flush();
            oos.writeObject(p2);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //对象的反序列化过程：将硬盘中的文件通过ObjectInputStream转换为相应的对象
    @Test
    public void testOjbectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("person.txt")));
            Person p1  = (Person)ois.readObject();
            Person p2  = (Person)ois.readObject();
            System.out.println(p1);
            System.out.println(p2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null ){
                try {
                    ois.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
//要实现序列化的类：

/**
 * 1.要求该类是可序列化的，如果需要让某个对象支持序列化机制，则必须让其类是可序列化的，为了让某个类是可序列化的，
 * 该类必须实现如下两个接口之一：
 * Serializable
 * Externalizable
 * 2.要求类的属性也要实现这俩接口
 * 3.凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量：
 * private static final long serialVersionUID;
 * 4.ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 */
class Person implements Serializable {
//    private static final long serialVersionUID = 41232423432L;
    String name;
    Integer age;
    Pet pet;
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Pet implements Serializable{
    String name;
}