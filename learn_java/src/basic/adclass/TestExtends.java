package basic.adclass;
//继承
    /*
    面向对象的特征二：继承性
    1.通过“class A extends B”实现类的继承
         子类：A      父类（superclass）：B
    2.子类继承父类后，父类中声明的属性、方法，子类都可以得到。
          明确：对于父类中有private的属性，子类虽然能获取到，但是由于封装性和权限的问题不能使用
      子类除了通过继承，获取父类的结构之外，还可以定义自己特有的成分。
      子类是对父类功能的“扩展”，明确子类不是父类的子集。
    3.Java中类的继承性只支持单继承。即一个类只能继承一个父类。而一个父类可以拥有多个子类。
    4.子类父类是相对的概念。即子类依然可以再次被继承，这样就是另一对父类子类的关系。

    //方法的重写
    1.前提：有子类继承父类
    2.子类继承父类后，若父类的方法对子类不适用，那么子类可以对父类的方法重写(override/overwrite)、覆盖。
    3.规则： 1）要求子类方法的 “返回值类型 方法名（参数列表） ”与父类方法一样。
             2）子类方法的修饰符权限不能小于父类的方法。对于父类private的方法，子类相当于重新定义。
             3）若父类方法抛异常，那么子类方法抛的异常类型不能大于父类。
             4）子父类的方法必须同为static或同为非static的。
     */
public class TestExtends {
    public static void main(String[] args){

    }
}
