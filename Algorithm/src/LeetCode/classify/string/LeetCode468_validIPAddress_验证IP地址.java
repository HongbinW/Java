package LeetCode.classify.string;

public class LeetCode468_validIPAddress_验证IP地址 {
    private static final String Neither = "Neither";
    private static final String IPv4 = "IPv4";
    private static final String IPv6 = "IPv6";
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0 || IP.startsWith(":") || IP.startsWith(".") || IP.endsWith(":") || IP.endsWith(".")){
            return "Neither";
        }
        if (IP.indexOf(":") != -1){
            return IPv6Process(IP.toLowerCase().split(":"));
        }else if (IP.indexOf(".") != -1){
            return IPv4Process(IP.split("\\."));
        }else
            return Neither;
    }
    public String IPv4Process(String[] IP){
        if (IP.length != 4){
            return Neither;
        }
        for (int i = 0; i < IP.length; i ++){
            if (IP[i].length() == 0 || IP[i].startsWith("0") && IP[i].length() > 1 || IP[i].length() > 3 || !(IP[i].charAt(0) >= '0' && IP[i].charAt(0) <= '2')){
                return Neither;
            }
            try {
                int num = Integer.parseInt(IP[i]);
                if (num < 0 || num > 255){
                    return Neither;
                }
            }catch (Exception e){
                return Neither;
            }
        }
        return IPv4;
    }
    public String IPv6Process(String[] IP){
        if (IP.length != 8){
            return Neither;
        }
        for (int i = 0; i < IP.length; i ++){
            if (IP[i].length() > 4 || IP[i].length() == 0){
                return Neither;
            }
            for (int j = 0; j < IP[i].length(); j ++){
                if (!(IP[i].charAt(j) >= '0' && IP[i].charAt(j) <= '9') && !(IP[i].charAt(j) >= 'a' && IP[i].charAt(j) <= 'f')){
                    return Neither;
                }
            }
        }
        return IPv6;
    }

    public static void main(String[] args) {
        LeetCode468_validIPAddress_验证IP地址 test = new LeetCode468_validIPAddress_验证IP地址();
        System.out.println(test.validIPAddress(
                "20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
    }
}
