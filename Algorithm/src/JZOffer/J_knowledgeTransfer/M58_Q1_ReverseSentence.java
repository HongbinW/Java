package JZOffer.J_knowledgeTransfer;

public class M58_Q1_ReverseSentence {
    public String ReverseSentence(String str) {
        if(str == null || str.trim().length() == 0)
            return str;
        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length-1; i >= 0; i --){
            sb.append(strs[i]);
            if (i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
