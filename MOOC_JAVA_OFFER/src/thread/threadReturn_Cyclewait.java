package thread;

/**
 * @Author: HongbinW
 * @Date: 2019/8/3 14:09
 * @Version 1.0
 * @Description:
 */
public class threadReturn_Cyclewait implements Runnable{
    private String  value;
    public void run(){
        try{
            Thread.currentThread().sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        value = "we have data now";
    }

    public static void main(String[] args) throws Exception{
        threadReturn_Cyclewait cw = new threadReturn_Cyclewait();
        Thread t1 = new Thread(cw);
        t1.start();
        t1.join();
//        while (cw.value == null){   //直到子线程获取到值，才跳过等待
//            try {
//                Thread.currentThread().sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println(cw.value);
    }
}

