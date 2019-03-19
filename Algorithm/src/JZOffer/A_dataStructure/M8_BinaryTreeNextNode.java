package JZOffer.A_dataStructure;
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class M8_BinaryTreeNextNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode.right != null){
            TreeLinkNode node = pNode.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }else if(pNode.next != null && pNode.next.left == pNode){
            return pNode.next;
        }else{
            while(pNode.next != null && pNode.next.right == pNode){
                 pNode = pNode.next;
            }
            if(pNode.next != null && pNode.next.left == pNode){
                return pNode.next;
            }else{
                return null;
            }
        }
    }

}