//生产者消费者

//法一：synchronized wait notify

class SharedResource{
    private volatile int number = 0;

    public void increase(){
        synchronized (this) {
            while (number != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            notify();
        }
    }

    public void decrease() {
        synchronized (this) {
            while (number == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            notify();
        }
    }
}

class Test{
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        new Thread(()->{
            for (int i = 0 ; i < 10; i ++) {
                sharedResource.increase();
            }
        },"AA").start();
        new Thread(()->{
            for(int i = 0 ; i < 10; i ++)
                sharedResource.decrease();
        },"BB").start();
    }
}