package leet.merge.linked.lists;

public class Solution {

//	public ListNode mergeKLists(ListNode[] lists) {
//	        
//	}
	
	public static ListNode merge2Lists(ListNode n1, ListNode n2) {
		ListNode it1 = n1;
		ListNode it2 = n2;
	
		ListNode result = null;
		print(n1);
		while(it1 != null && it2 != null) {
			
			if (it1.val<=it2.val) {
				if (result == null) result = new ListNode(it1.val);
				else result.next = new ListNode(it1.val);
				System.out.print(it1);
				it1 = it1.next;			
			}
			else {
			
				if (result == null) result = it2;
				else result.next = new ListNode(it2.val);
				System.out.print(it2);
				it2 = it2.next;				
			}
			//System.out.print(it2);
			//it2 = it2.next;
			result = result.next;
		}
		
		if (it1!=null) {
			System.out.print(it1);
			result.next = it1;
			it1=it1.next;
			//result = result.next;
		}
		if (it2!=null) {
			System.out.print(it2);
			result.next = it2;
			it2=it2.next;
			//result = result.next;
		}

		return result;
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
		l1.next.next.next = null;
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(5);
		l2.next.next.next = null;
	

		System.out.println(merge2Lists(l1,l2));
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