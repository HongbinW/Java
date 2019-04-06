
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

    public class Test{
        public static void main(String[] args) {
            Singleton s1 = Singleton.getSingleton();
            Singleton s2 = Singleton.getSingleton();
            System.out.println(s1 == s2);

        }
    }


