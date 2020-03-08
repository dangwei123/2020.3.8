给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] res=new int[amount+1];
        Arrays.fill(res,1,amount+1,amount+1);
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                res[j]=Math.min(res[j-coins[i]]+1,res[j]);
            }
        }
        return res[amount]==amount+1?-1:res[amount];
    }
}

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] c=s.toCharArray();
        reverse(c,0,n-1);
        reverse(c,n,c.length-1);
        reverse(c,0,c.length-1);
        return new String(c);
    }
    private void reverse(char[] c,int left,int right){
        while(left<right){
            char tmp=c[left];
            c[left++]=c[right];
            c[right--]=tmp;
        }
    }
}

输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(k<1||head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(k!=1){
            if(fast.next==null){
                return null;
            }
            fast=fast.next;
            k--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private int index;
    public int[] reversePrint(ListNode head) {
        
        index=0;
        int[] arr=new int[getLen(head)];
        if(head==null){
            return arr;
        }
        return reverse(arr,head);
        
    }
    private int getLen(ListNode head){
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }
    private int[] reverse(int[] arr,ListNode head){
        if(head==null){
            return null;
        }
        reverse(arr,head.next);
        arr[index++]=head.val;
        return arr;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private int index;
    private int[] res;
    public int[] reversePrint(ListNode head) {
        res=new int[getLen(head)];
        reverse(head);
        return res;
    }
    private int getLen(ListNode head){
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }

    private void reverse(ListNode head){
        if(head!=null){
            reverse(head.next);
            res[index++]=head.val;
        }
    }
}

