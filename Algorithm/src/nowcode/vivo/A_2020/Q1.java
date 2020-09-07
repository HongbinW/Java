package nowcode.vivo.A_2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public static class Main {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            String[] input = inputStr.split(" ");
            int totalDisk = Integer.parseInt(input[0]);
            int totalMemory = Integer.parseInt(input[1]);
            List<Service> services = parseServices(input[2].split("#"));
            int output = solution(totalDisk, totalMemory, services);
            System.out.println(output);
        }

        private static int solution(int totalDisk, int totalMemory, List<Service> services) {
            int len = services.size();
            int[][][] dp = new int[len+1][totalDisk+1][totalMemory+1];
            for (int i = 1; i <= len; i ++){
                int disk = services.get(i-1).disk;
                int memory = services.get(i-1).memory;
                int users = services.get(i-1).users;
                for (int j = 1; j <= totalDisk; j ++){
                    for(int k = 1; k <= totalMemory; k ++){
                        if (j - disk >= 0 && k - memory >= 0)
                            dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-disk][k-memory] + users);
                            // dp[i][j][k] 第i个服务，j 硬盘，k内存所能达到的最大值
                            // 如果能放下services[i]，那就比较去最大值，否则就不用这个服务
                        else{
                            dp[i][j][k] = dp[i-1][j][k];
                        }
                    }
                }
            }
            return dp[len][totalDisk][totalMemory];
        }

        private static List<Service> parseServices(String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return new ArrayList<Service>(0);
            }
            List<Service> services = new ArrayList<>(strArr.length);
            for (int i = 0; i < strArr.length; i++) {
                String[] serviceArr = strArr[i].split(",");
                int disk = Integer.parseInt(serviceArr[0]);
                int memory = Integer.parseInt(serviceArr[1]);
                int users = Integer.parseInt(serviceArr[2]);
                services.add(new Service(disk, memory, users));
            }
            return services;
        }

        static class Service {
            private int disk;

            private int memory;

            private int users;

            public Service(int disk, int memory, int users) {
                this.disk = disk;
                this.memory = memory;
                this.users = users;
            }

            public int getDisk() {
                return disk;
            }

            public void setDisk(int disk) {
                this.disk = disk;
            }

            public int getMemory() {
                return memory;
            }

            public void setMemory(int memory) {
                this.memory = memory;
            }

            public int getusers() {
                return users;
            }

            public void setusers(int users) {
                this.users = users;
            }
        }
    }
}
