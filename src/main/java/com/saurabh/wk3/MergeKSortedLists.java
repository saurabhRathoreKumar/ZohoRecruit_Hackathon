package com.saurabh.wk3;

public class MergeKSortedLists {
    public static void main(String[] args) {
        // Create list1: [1,4,5]
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        // Create list2: [1,3,4]
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // Create list3: [2,6]
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};

        MergeKSortedLists mksl = new MergeKSortedLists();
        ListNode merged = mksl.mergeKLists(lists);

        // Print the merged list
        System.out.print("Merged list: [");
        ListNode curr = merged;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(",");
            curr = curr.next;
        }
        System.out.println("]");
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeList(lists, 0, lists.length-1);
    }
    private ListNode mergeList(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        if(start == end-1) {
            return merge(lists[start], lists[end]);

        }
        int m = (end + start)/2;
        ListNode left = mergeList(lists, start, m-1);
        ListNode right = mergeList(lists, m, end);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;

        }
        ListNode head, curr;
        if(left.val < right.val) {
            head = left;
            left = left.next;
            curr = head;
        } else {
            head = right;
            right = right.next;
            curr = head;
        }

        while(left != null && right != null) {
            if(left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        while(left != null) {
            curr.next = left;
            left = left.next;
            curr = curr.next;
        }

        while(right != null) {
            curr.next = right;
            right = right.next;
            curr = curr.next;
        }
        return head;
    }
}
