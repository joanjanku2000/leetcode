package leet.merge.linked.lists;

public class Solution {

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists.length<=2) {
			return merge2Lists(lists[0],lists[1]);
		}
		
		ListNode root = merge2Lists(lists[0],lists[1]);
		
	        for (int i = 2;i<lists.length;i+=1) {
	        	root = merge2Lists(root,lists[i]);
	        }
	    return root;
	}
	
	public static ListNode merge2Lists(ListNode n1, ListNode n2) {
		ListNode it1 = n1;
		ListNode it2 = n2;
	    if (n1 == null ) return n2;
        if (n2==null) return n1;
		ListNode result = n1.val<n2.val ? new ListNode(n1.val) : new ListNode(n2.val);
		ListNode resultRoot = result;
		
		if (result.val == n1.val) it1 = it1.next;
		else it2 = it2.next;
		while(it1 != null && it2 != null) {
			
			if (it1.val<=it2.val) {
				result.next = new ListNode(it1.val) ;
				it1 = it1.next;			
			}
			else {
				result.next = new ListNode(it2.val);
				it2 = it2.next;				
			}
			result = result.next;
		}
		
		
		if (it1!=null) {
				result.next = it1;	
		}
		if (it2!=null) {
				result.next = it2;
		}

		
		return resultRoot;
	}
	public static void print(ListNode l) {
		ListNode iterator = l;
		while(iterator != null) {
			System.out.print("  "+iterator.val);
			iterator = iterator.next;
		}
	}
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(6);
	
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(5);

		
		ListNode l3 = new ListNode(6);
		l3.next = new ListNode(9);
		
		ListNode l4 = new ListNode(12);
		l4.next = new ListNode(22);
		
		ListNode l5 = new ListNode(18);
		l3.next = new ListNode(19);
		l5.next = new ListNode(28);
		
		ListNode[] lists = new ListNode[5];
		
		
		lists[0] = l1;
		lists[1] = l2;
		lists[2] = l3;
		lists[3] = l4;
		lists[4] = l5;
		print(mergeKLists(lists));
		//System.out.println(merge2Lists(l1,l2));
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
    	 return " " + val;
     }
}