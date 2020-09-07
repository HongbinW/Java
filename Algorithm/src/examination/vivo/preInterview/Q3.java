package examination.vivo.preInterview;

import java.util.*;

public class Q3 {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {

                // write your code here
                int N = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < N; i ++){
                    lines.add(scanner.nextLine());
                }
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        // TODO output
        ListNode[] nodes = new ListNode[lines.size()];
        for (int i = 0; i < lines.size(); i ++){
            nodes[i] = process(lines.get(i).split(" "),0);
        }

        ListNode res = mergeNodes(nodes);
        while (res != null){
            System.out.printf("%d ", res.val);
            res = res.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode process(String[] strs, int i){
        if (i == strs.length){
            return null;
        }
        ListNode node = new ListNode(Integer.parseInt(strs[i]));
        node.next = process(strs,i+1);
        return node;
    }

    private static ListNode mergeNodes(ListNode[] lists ) {

        // write your code here
        if (lists == null || lists.length == 0){
            return null;
        }
        ListNode res = new ListNode(-1);
        ListNode current = res;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1,o2)->o1.val - o2.val);
        for (int i = 0; i < lists.length; i ++){
            while (lists[i] != null){
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        while (!queue.isEmpty()){
            ListNode tmp = queue.poll();
            current.next = tmp;
            current = current.next;
        }
        current.next = null;
        return res.next;
    }


}