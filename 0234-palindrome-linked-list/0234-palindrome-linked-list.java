/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
       ListNode fast = head;
       ListNode slow = head;
       while(fast.next!=null && fast.next.next!=null){
        slow = slow.next;
        fast = fast.next.next;
       } 
       ListNode a = slow.next;
       slow.next = null;
       ListNode curr = a;
       ListNode prev = null;
       ListNode forw = null;
       while(curr!=null){
        forw = curr.next;
        curr.next = prev;
        prev = curr;
        curr = forw;
        
       }

       ListNode i = head;
       ListNode j = prev;
       while(j!=null){
        if(i.val==j.val){
            i = i.next;
            j= j.next;
        }else{
            return false;
        }
       }
       return true;

    
    }
}