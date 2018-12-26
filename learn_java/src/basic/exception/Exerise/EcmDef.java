package basic.exception.Exerise;

/**
 * 编写应用程序EcmDef.java，接收命令行的两个参数，要求不能输入负数，计算两数相除。
 * 	对数据类型不一致(NumberFormatException)、缺少命令行参数(ArrayIndexOutOfBoundsException、
 *   除0(ArithmeticException)及输入负数(EcDef 自定义的异常)进行异常处理。
 */
public class EcmDef {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            ecm(a, b);
        }catch (NumberFormatException e){
            System.out.println("输入的数据类型不一致");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数");
        }catch (ArithmeticException e){
            System.out.println("分母为零");
        }catch (EcDef e){
            System.out.println(e.getMessage());
        }

    }
    public static void ecm(int i ,int j) throws EcDef{
        if(i < 0 || j < 0){
            throw new EcDef("输入的数值存在负数");
        }
        System.out.println(i / j);
    }
}
class EcDef extends Exception{
    static final long serialVersionUID = -3387516993124229948L;
    public EcDef(){

    }
    public EcDef(String msg){
        super(msg);
    }
}