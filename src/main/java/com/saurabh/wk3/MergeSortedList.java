package com.saurabh.wk3;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeSortedList {
    public static void main(String[] args){
        // Create list1: [1,2,4]
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        
        // Create list2: [1,3,4]
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        
        MergeSortedList msl = new MergeSortedList();
        ListNode merged = msl.mergeTwoLists(list1, list2);
        
        // Print the merged list
        System.out.print("Merged list: [");
        ListNode curr = merged;
        while(curr != null) {
            System.out.print(curr.val);
            if(curr.next != null) System.out.print(",");
            curr = curr.next;
        }
        System.out.println("]");
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return null;
        }
        else if(list1 != null && list2 == null) {
            return list1;
        }
        else if(list1 == null) {
            return list2;
        }

        ListNode head, curr;

        if(list1.val < list2.val) {
            head = list1;
            curr = list1;
            list1 = list1.next;
        } else {
            head = list2;
            curr = list2;
            list2 = list2.next;
        }

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
        }

        while(list1 != null) {
            curr.next = list1;
            curr = curr.next;
            list1 = list1.next;
        }

        while(list2 != null) {
            curr.next = list2;
            curr = curr.next;
            list2 = list2.next;
        }
        return head;
    }
}
