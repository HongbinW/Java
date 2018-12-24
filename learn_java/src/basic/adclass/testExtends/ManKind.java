package basic.adclass.testExtends;

/**
 * .(1)定义一个ManKind类，包括
 * 成员变量int sex和int salary；
 * 方法void manOrWorman()：根据sex的值显示“man”(sex==1)或者“women”(sex==0)；
 * 方法void employeed()：根据salary的值显示“no job”(salary==0)或者“ job”(salary!=0)。
 *    (2)定义类Kids继承ManKind，并包括
 * 成员变量int yearsOld；
 * 方法printAge()打印yearsOld的值。
 *    (3)在Kids类的main方法中实例化Kids的对象someKid，用该对象访问其父类的成员变量及方法。
 */
public class ManKind {
    private int sex;
    private int salary;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void manOrWorman(){
        if(sex == 1){
            System.out.println("man");
        }else if(sex ==0){
            System.out.println("woman");
        }else{
            System.out.println("输入有误");
        }
    }
    public void employeed(){
        if(salary == 0) {
            System.out.println("no job");
        }else if(salary > 0){
            System.out.println("job");
        }
    }
}
