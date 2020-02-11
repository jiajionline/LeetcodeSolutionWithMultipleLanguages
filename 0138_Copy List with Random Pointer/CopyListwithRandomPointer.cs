public class Solution {
   public Node CopyRandomList(Node head) {
       if(head == null) return null;
       var current = head;
       while(current!=null){
           var cloneNode = new Node(current.val);
           var next = current.next;
           current.next = cloneNode;
           cloneNode.next = next;
           current = next;
       }

       current = head;
       while(current!=null){
           var next = current.next;
           if(current.random!=null){
               next.random = current.random.next;
           }           
           current = current.next.next;
       }

       current = head;
       var cloneHead = head.next;
       var cloneCurrent = cloneHead;
       while(current!=null){
           current.next = cloneCurrent.next;
           current = cloneCurrent.next;
           if(current!=null){
               cloneCurrent.next = current.next;
               cloneCurrent = cloneCurrent.next;
           }           
       }

       return cloneHead;
   }
}
