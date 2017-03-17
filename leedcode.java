import com.google.common.collect.Lists;

///
//   Created by ruiqizhang on 3/16/17.
//  /
public class leedcode {

    //       Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        char[] chars1 = new char[]{2, 4, 3};
        char[] chars2 = new char[]{5, 6, 4};
        ListNode h1 = new ListNode(chars1[0]);
        ListNode l1 = h1;
        ListNode h2 = new ListNode(chars2[0]);
        ListNode l2 = h2;
        for (int i = 1; i < 3; i++) {
            ListNode temp1 = new ListNode(chars1[i]);
            h1.next = temp1;
            h1 = temp1;
            ListNode temp2 = new ListNode(chars2[i]);
            h2.next = temp2;
            h2 = temp2;
        }
        ListNode t1 = l1;
        ListNode t2 = l2;
        System.out.println("data ready ,,");

        ListNode l3 = addTwoNumbers(t1, t2);

        while (l3 != null) {
            System.out.print(l3.val + " ->");
            l3 = l3.next;
        }


    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int hdigit = 0;
        boolean flag = false;
        ListNode node = null;
        ListNode head = null;
        int j = 0;
        while (!flag) {
            int t1 = l1 == null ? 0 : l1.val;
            int t2 = l2 == null ? 0 : l2.val;
            int sum = t1 + t2 + hdigit;
            int ldigit = sum % 10;//用于下一次循环相加
            hdigit = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            flag = l1 == null && l2 == null;//全空的时候退出循环
            ListNode temp = new ListNode(ldigit);
            if (j == 0) {
                node = temp;
                head = node;
            } else {
                node.next = temp;
                node = temp;
            }
            if (flag && hdigit != 0) {
                ListNode last = new ListNode(hdigit);//最高位溢位
                node.next = last;
                node = last;
            }
            j++;
        }
        return head;
    }

    static String getSum(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int loops = chars1.length > chars2.length ? chars1.length : chars2.length;
        StringBuffer result = new StringBuffer();
        int hdigit = 0;
        for (int i = 0; i < loops; i++) {
            int t1 = 0;
            int t2 = 0;
            try {
                t1 = Character.getNumericValue(chars1[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                t1 = 0;
            }
            try {
                t2 = Character.getNumericValue(chars2[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                t2 = 0;
            }
            int sum = t1 + t2 + hdigit;
            int ldigit = sum % 10;//用于下一次循环相加
            result.append(ldigit);
            hdigit = sum / 10;
            System.out.println(" ldigit is " + ldigit + " t1 is " + t1 + " t2 is " + t2);
        }

        return result.toString();
    }


}
