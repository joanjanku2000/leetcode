package leet.remove_Nth_node_from_end_list;

import java.util.HashMap;
import java.util.Map;

/**
 * Removes Nth node from the end of the list
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
public class Main {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> nodeIndexMap = new HashMap<>();

        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            nodeIndexMap.put(count,curr);
            curr = curr.next;
        }

        int toRemove = nodeIndexMap.size() - n + 1;

        nodeIndexMap.remove(toRemove);

        ListNode newList = null;
        ListNode newHead = null;
        for (Map.Entry<Integer,ListNode> entry : nodeIndexMap.entrySet()) {
            if (newList == null) {
                newList = new ListNode(entry.getValue().val);
                newHead = newList;
            } else {
                newList.next = new ListNode(entry.getValue().val);
                newList = newList.next;
            }
        }
        return newHead;
    }


    public static void main(String[] args) {
        ListNode l ;
        ListNode res ;
        l = new ListNode(1
        );

        res = removeNthFromEnd(l,1);
        print(res);

        l = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5))))
        );

        res = removeNthFromEnd(l,2);
        print(res);
    }

    static void print(ListNode n) {
        System.out.println();
        ListNode c = n;
        while (c != null){
            System.out.print (" " + c.val);
            c = c.next;
        }
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString(){
          return "[ val = " + val +  "]";
    }
}
