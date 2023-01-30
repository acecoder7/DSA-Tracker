import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class Lmedium {
    static class ListNode {
        public int val;
        public ListNode next;
        
        public ListNode(int val) { this.val = val; }
        
    };
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    class Node2 {
        public int val;
        public Node2 prev;
        public Node2 next;
        public Node2 child;
    };

    static int sizeLL(ListNode node){
        int ct=0;
        while (node != null) {
            node = node.next;
            ct++;
        }
        return ct;
    }

    static void twinCheck(ListNode right, int cout){
        //int nres=0;
        int size = (sizeLL(right))/2;
        if(right==null){
            return ;
        } else {
            twinCheck(right.next, cout+1);
            if(cout>=size){
                max = Math.max(left.val+right.val, max);
                left=left.next;
                return;
            }
        }
    }
    static ListNode left;
    static int max=0;
    static int pairSum(ListNode head) {
        left=head;
        twinCheck(head, 0);
        return max;
    }


    static void deleteNode(ListNode node) {
        if(node == null){
            return;
        } else{
            node.val=node.next.val;
            node.next=node.next.next;
        }
    }


    static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev=list1;
        ListNode tmp=list1;
        for(int i=0; i<a; i++){
            prev=tmp;
            tmp=tmp.next;
        }
        for(int i=0; i<=b-a;i++){
            tmp=tmp.next;
        }
        prev.next = list2;
        while(list2.next!=null){
            list2=list2.next;
        }
        list2.next=tmp;

        return list1;
    }


    static ListNode removeNodes(ListNode head) {
        ListNode temp = head ;
        List<ListNode> li = new ArrayList<ListNode>();
        List<ListNode> li2 = new ArrayList<ListNode>();
        while( temp != null ){
            li.add(temp);          
            temp = temp.next ;
        }
        int max = li.get(li.size() - 1).val ;  
        for(int i = li.size() - 1 ;  i >= 0 ; i--){
            int val = li.get(i).val ;
            if( max <= val ){
                max = val ;
                li2.add(li.get(i)) ;      
            }
        }

        head = li2.get(li2.size()-1) ;
        ListNode t = null ; 
        for(int i = li2.size() -1  ; i >= 1 ; i-- ){                       
            t = li2.get(i) ;    
            t.next = li2.get(i-1) ;
        }
        return head ;
    }


    static ListNode swapNodes(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode curr = head;

        for(int i=1; i<k; i++){
            fast=fast.next;
            curr=fast;
        }
        fast=fast.next;
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }

        int val = slow.val;
        slow.val=curr.val;
        curr.val=val;

        return head;
    }


    static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode Dodd=new ListNode(0);
        ListNode Deven = new ListNode(0);
        ListNode prev_o = Dodd;
        ListNode prev_e = Deven;
        ListNode curr = head;
        int count=0;

        while(curr!=null){
            count++;
            if(count%2==0){
                prev_e.next=curr;
                prev_e=prev_e.next;
            }else{
                prev_o.next=curr;
                prev_o=prev_o.next;
            }
            curr=curr.next;
        }
        prev_o.next=Deven.next;
        prev_e.next=null;

        return Dodd.next;
    }


    static ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        
        ListNode Node=head;
        while(Node.next!=null)
        {
            int num=Node.val;
            Node.val=Node.next.val;
            Node.next.val=num;
            
            if(Node.next.next!=null)
                Node=Node.next.next;
            else
                Node=Node.next;
        }
        return head;
    }


    static int mid(ListNode start){
        int ct=1;
        while(start!=null){
            ct++;
            start=start.next;
        }
        return ct%2==0 ? ct/2:(ct+1)/2 ;
    }
    static ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode tmp=head;
        ListNode prev=head;
        int itr=1;
        int m= mid(head);
        while(itr!=m){
            itr++;
            prev=tmp;
            tmp=tmp.next;
        }
        prev.next=tmp.next;
        return head;
    }


    static Node getNextRight(Node p) {
        Node temp = p.next;
        while (temp != null){
            if (temp.left != null)
                return temp.left;
            if (temp.right != null)
                return temp.right;
            temp = temp.next;
        }
        return null;
    }
    static Node connect(Node p) {
        if (p == null)
            return null;

        if (p.next != null)
            connect(p.next);
  
        if (p.left != null){
            if (p.right != null) {
                p.left.next = p.right;
                p.right.next = getNextRight(p);
            } 
            else
                p.left.next = getNextRight(p);
            connect(p.left);
        }
        else if (p.right != null) {
            p.right.next = getNextRight(p);
            connect(p.right);
        } 
        else
            connect(getNextRight(p));
    
        return p;
    }


    static int[] nextLargerNodes(ListNode head) {
        int count = sizeLL(head);
        int[] ans = new int[count];
        int k = 0;
        ListNode j = new ListNode(0);
 
        while (head != null) {
            if (head.next == null) {
                ans[k] = 0;
                break;
            }
            j = head.next;
            if (head.val < j.val) {
                ans[k] = j.val;
                k++;
            } else if (head.val >= j.val) {
                while (j != null && head.val >= j.val) { 
                    j = j.next;
                }
                if (j != null) {
                    ans[k] = j.val;
                    k++;
                } else {
                    ans[k] = 0;
                    k++;
                }
            } else {
                ans[k] = 0;
                k++;
            }
            head = head.next;
        }
        return ans;
    }


    static int Solution(ListNode head) {
        if (head == null) {
            return -1;
        }
        Math.abs(UUID.randomUUID().getMostSignificantBits());
        return getRandom(head);
    }
    
    static int getRandom(ListNode nodee) {
        int result = nodee.val;
        ListNode current = nodee;
        int n;
        for (n = 2; current != null; n++) {
            if (Math.random() % n == 0) {
                result = current.val;
            }
            current = current.next;
        }
        return result;
    }


    static ListNode reverse(ListNode head){
        ListNode tmp=head;
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }
        head=prev;
        return head;
    }
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        l1=reverse(l1);
        l2=reverse(l2);
        ListNode tmp1=l1;
        ListNode tmp2=l2;
        ListNode dummy=new ListNode(0);
        ListNode itr=dummy;
        int carry=0;
        while(tmp1!=null || tmp2!=null || carry!=0){
            int sum = carry+ (tmp1!=null?tmp1.val:0) + (tmp2!=null?tmp2.val:0) ;
            carry= sum/10;
            int ele = sum%10;

            itr.next= new ListNode(ele);
            itr=itr.next;

            if(tmp1!=null){
            tmp1=tmp1.next;
            }
            if(tmp2!=null){
                tmp2=tmp2.next;
            }
        }
        return (reverse(dummy.next));
    }


    static Node2 flatten(Node2 head) {
        Node2 temp=head;
        while(temp!=null)
        {
            if(temp.child==null)temp=temp.next;
            else{
                if(temp.next!=null)
                link(temp.child,temp.next);
                temp.next=temp.child;
                temp.child.prev=temp;
                temp.child=null;
            }
        }
        return head;
        
    }
    static void link(Node2 n1,Node2 n2){
        while(n1.next!=null)n1=n1.next;
        n1.next=n2;
        n2.prev=n1;
    }


    static int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
        set.add(nums[i]);
    }
    int ans = 0;

    while (head != null) {
        if (set.contains(head.val)){
            ans++;
            while (head != null && set.contains(head.val)){
                head = head.next;
            }
        } else {
            while (head != null && !set.contains(head.val)){
                head = head.next;
            }
        }
    }
    return ans;
    }


    static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode curr = head;
        ListNode tmp = null;
        int num=sizeLL(head);
        int q = num/k;
        int r = num%k;
        for (int i = 0; curr != null && i < k; i++, r--) {
            ans[i] = curr;
            for (int j = 0; j < q + (r > 0 ? 1 : 0); j++) {
                tmp = curr;
                curr = curr.next;
            }
            tmp.next = null;
        }
        return ans; 
    }


    static ListNode sortList(ListNode head) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        temp=head;
        int a[]=new int[count];
        count=0;
        while(temp!=null){
            a[count++]=temp.val;
            temp=temp.next;
        }
        temp=head;
        Arrays.sort(a);
        int k=0;
        while(temp!=null){
            temp.val=a[k++];
            temp=temp.next;
        }
        return head;
    }


    static ListNode[] reverseList(ListNode node, int n) {
        ListNode pre = null, cur = node, post = null;
        while (n-- > 0) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        node.next = cur;
        return new ListNode[]{pre, post};
    }
    static ListNode reverseEvenLengthGroups(ListNode head) {
         if (head == null) {
            return null;
        }
        ListNode ptr = head;
        int total = 0;
        while (ptr != null) {
            total++;
            ptr = ptr.next;
        }
        
        int numOfNodes = 1;
        ListNode cur = head, pre = null;
        while (cur != null) {
            numOfNodes = Math.min(numOfNodes, total);
            total -= numOfNodes;
            if (numOfNodes % 2 == 1) {
                // Odd: Move pointers.
                int cnt = 0;
                while (cur != null && cnt++ < numOfNodes) {
                    pre = cur;
                    cur = cur.next;
                }
            } else {
                // Even: Reverse List
                ListNode[] res = reverseList(cur, numOfNodes);
                pre.next = res[0];
                pre = cur;
                cur = res[1];
            }
            numOfNodes++;
        }
        return head;
        
    }
    

    static void printLL(ListNode node) {
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }
    public static void main(String[] args) {
        ListNode start1 = new ListNode(0);
        start1.next = new ListNode(3);
        start1.next.next = new ListNode(4);
        start1.next.next.next= new ListNode(5);
        start1.next.next.next.next= new ListNode(7);
        //start1.ptr.ptr.ptr.ptr.ptr= new Node(9);
        //start.ptr.ptr.ptr.ptr.ptr.ptr= new Node(2);

        ListNode start2 = new ListNode(11);
        start2.next = new ListNode(1);
        start2.next.next = new ListNode(3);
        start2.next.next.next= new ListNode(7);
        start2.next.next.next.next= new ListNode(10);
        start2.next.next.next.next.next= new ListNode(9);
        //start2.ptr.ptr.ptr.ptr.ptr.ptr= new Node(22);

        int[] x = {0,4,7};

        //deleteNode(start1.next.next);
        //printLL(start1);
        //System.out.println(pairSum(start2));
        //printLL(mergeInBetween(start1, 2, 3, start2));
        //printLL(removeNodes(start2));
        //printLL(swapNodes(start1, 2));
        //printLL(oddEvenList(start1));
        //printLL(swapPairs(start2));
        //printLL(deleteMiddle(start2));
        // for (int x: (nextLargerNodes(start2))) {
        //     System.out.println(x);
        // };

        //printLL(addTwoNumbers(start1, start2));
        //printLL(flatten(start1));
        //System.out.println(numComponents(start2, x));
        //printLL(splitListToParts(start2, ));
        printLL(sortList(start2));
    }
}
