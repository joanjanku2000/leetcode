package leet.swap.nodes.pairs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

        public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,new ListNode(3)));
        ListNode newHead = swapPairs(head);
        newHead.print();
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        Map<Integer,ListNode> evenNodes = new HashMap<>();
        Map<Integer,ListNode> oddNodes = new HashMap<>();


        boolean flag = true;
        ListNode current = head;
        int i = 0;
        while (current != null) {
            if (flag) {
                evenNodes.put(i,current);
                flag = false;
            } else {
                oddNodes.put(i,current);
                flag = true;
            }
            current = current.next;
            i++;
        }
        System.out.println(evenNodes);
        System.out.println(oddNodes);

        ListNode newHead = null;
        System.out.println("i=" + i);
        if (i%2 == 0) {
            for (int j = 0; j < i; j+=2) {
                ListNode even = evenNodes.get(j);
                ListNode odd = oddNodes.get(j+1);

                if (odd != null) {
                    odd.next = even;
                    even.next = oddNodes.get(j+3);
                }

                if (j == 0){
                    newHead = odd;
                }
            }
        }
        else {
            ListNode l = null;
            if (oddNodes.size() > evenNodes.size()){
                l = oddNodes.get(i-1);
                oddNodes.remove(i-1);
           //     evenNodes.get(i - 2).next = null;
            } else {
                l = evenNodes.get(i-1);
                evenNodes.remove(i-1);
          //      oddNodes.get(i - 2).next = null;
            }
            System.out.println(evenNodes);
            System.out.println(oddNodes);
            System.out.println(l);
            ListNode currenT = null;
            for (int j = 0; j < i-1; j+=2) {
                ListNode even = evenNodes.get(j);
                ListNode odd = oddNodes.get(j+1);

                if (odd != null) {
                    odd.next = even;
                    System.out.print(odd);
                    System.out.print(".next=");
                    System.out.print(even);
                    System.out.println();
                    System.out.print(even);
                    System.out.print(".next=");
                    System.out.print(oddNodes.get(j+3));
                    System.out.println();

                    even.next = oddNodes.get(j+3);
                    currenT = even;
                }

                if (j == 0){
                    newHead = odd;
                }
                System.out.println("CURR " + currenT + " j = " + j);
                if (j == i - 3 ){
                    currenT.next = l;
                }
            }
        }


        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +

                '}';
    }

    void print(){
        ListNode current = this;
        while (current != null) {
            System.out.print(current.val + ", ");
            current = current.next;

        }

    }
}