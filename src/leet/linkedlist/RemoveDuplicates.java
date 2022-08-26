package leet.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the head of a sorted linked list,
 *  delete all duplicates such that each element appears only once.
 *
 *  Return the linked list sorted as well.
 * @author jjanku
 *
 */
public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode it = head;
        ListNode newListHead = null;
        ListNode newListIterator = newListHead;
        Map<Integer,ListNode> nodes = new HashMap<>();

        while(it != null) {
            if (!nodes.containsKey(it.val)) {
                nodes.put(it.val,it);
                if (newListHead == null) {
                    newListHead = new ListNode(it.val);
                    newListIterator = newListHead;
                } else {
                    ListNode temp = new ListNode(it.val);
                    newListIterator.next = temp;
                    newListIterator = temp;
                }
            }
            it = it.next;
        }
        return newListHead;
    }
}
