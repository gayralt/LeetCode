package main.java.LinkList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {
    //优先队列排序k个链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (null==lists||lists.length<=0)
        return null;
        //小顶堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o2.val - o1.val;
            }
        });
        ListNode head = new ListNode(0);
        //记住头节点
        ListNode newList=head;
        ListNode node;
        //加入k个链表
        for (int i = 0; i < lists.length; i++) {
            if (null!=lists[i])
            queue.offer(lists[i]);
        }
        //获取结果
        while (!queue.isEmpty()) {
            node = queue.poll();
            //取得下一个
            head.next = node;
            head = head.next;
            //该列表还有下一个
            if (null!=node&&null != node.next) {
                node = node.next;
                queue.offer(node);
            }
        }
        return newList.next;
    }

    /**
     * 分治法
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

//    作者：powcai
//    链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/leetcode-23-he-bing-kge-pai-xu-lian-biao-by-powcai/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * 非递归合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        // 将n个链表以中间为对称，合并，即合并
        while(len>1) {
            for (int i=0; i<len/2; i++) {
                lists[i] = mergeTwoLists2(lists[i], lists[len-1-i]);
            }
            len = (len+1)/2;
        }
        return lists[0];
    }


    // 合并两个链表
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else if (l2 != null) {
            p.next = l2;
        }
        return head.next;
    }
//
//    作者：lin-jian-you-xue
//    链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/luo-ji-fei-chang-jian-dan-de-javati-jie-shi-jian-j/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        ListNode no1=null;
        ListNode no2=new ListNode(1);
        MergeKLists lists=new MergeKLists();
        lists.mergeKLists(new ListNode[]{null,no2});
    }
}
