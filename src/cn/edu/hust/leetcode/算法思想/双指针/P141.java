package cn.edu.hust.leetcode.算法思想.双指针;

/**
 * @author kaisheng
 * @create 2020-11-07 20:20
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * 使用快慢指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
 */
public class P141 {

    //判断链表是否有环
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode pre = head;
        ListNode next = head.next;

        while (pre != null && next != null && next.next != null){
            if (pre == next){
                return true;
            }
            pre = pre.next;
            next = next.next.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
         val = x;
         next = null;
     }
}
