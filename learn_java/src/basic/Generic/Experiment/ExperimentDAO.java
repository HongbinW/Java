package basic.Generic.Experiment;

import org.junit.Test;

import java.util.*;

/**
 * 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。
 *
 * 分别创建以下方法：
 * public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
 * T get(String id)：从 map 中获取 id 对应的对象
 * void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
 * List<T> list()：返回 map 中存放的所有 T 对象
 * void delete(String id)：删除指定 id 对象
 *
 * 定义一个 User 类：
 * 该类包含：private成员变量（int类型） id，age；（String 类型）name。
 *
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 */
public class ExperimentDAO {
    @Test
    public void test1(){
        DAO<User> dao = new DAO<User>();
        dao.map = new HashMap<String,User>();
        dao.save("1001",new User(1,23,"AA"));
        dao.save("1002",new User(2,21,"DDD"));
        dao.save("1003",new User(3,25,"CA"));
        User u1 = dao.get("1001");
        System.out.println(u1);
        dao.update("1002",new User(12,44,"bbb"));
        dao.delete("1003");
        List<User> list = dao.list();
        System.out.println(list);

    }
}
class User{
    private int id;
    private int age;
    private String name;

    public User() {
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, age, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
class DAO<T>{
    Map<String,T> map = new HashMap<String,T>();

    public void save(String id,T entity){
        map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id,T entity){
        map.put(id,entity);
    }
    public List<T> list(){
        List<T> list = new ArrayList<>();
        for(String s : map.keySet()){
            list.add(map.get(s));
        }
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }
}