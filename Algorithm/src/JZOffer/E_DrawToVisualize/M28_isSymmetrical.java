package JZOffer.E_DrawToVisualize;

/**
 * @Author: HongbinW
 * @Date: 2019/3/27 11:35
 * @Version 1.0
 * @Description:
 */
public class M28_isSymmetrical {
    public boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot,pRoot);
    }
    public boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2){
        if(pRoot1 == null && pRoot2 == null)
            return true;
        if(pRoot1 == null || pRoot2 == null)
            return false;
        if(pRoot1.val != pRoot2.val)
            return false;
        return isSymmetrical(pRoot1.left,pRoot2.right)
                && isSymmetrical(pRoot1.right,pRoot2.left);
    }
}
