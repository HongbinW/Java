
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class Singleton {

        private Singleton() {
        }

        public static int Sum(int a,int b){
            return a+b;
        }
        private static final Singleton instance = new Singleton();
        public static final Singleton getSingleton(){
            return instance;
        }
    }

class Test {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }
    static class A {
        protected int value;
        public A (int v) {
            setValue(v);
        }
        public void setValue(int value) {
            this.value= value;
        }
        public int getValue() {
            try {
                value ++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }
    static class B extends A {
        public B () {
            super(5);
            setValue(getValue()- 3);
        }
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}

