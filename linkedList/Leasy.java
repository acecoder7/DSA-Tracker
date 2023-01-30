import javax.swing.plaf.metal.MetalRadioButtonUI;

public class Leasy {
    static class ListNode {
        public int val;
        public ListNode next;
        
        public ListNode(int val) { this.val = val; }
        
    }

    static int sizeLL(ListNode node){
        int ct=0;
        while (node.next != null) {
            node = node.next;
            ct++;
        }
        return ct;
    }

    static int getDecimalValue(ListNode head) {
        if(head == null){
            return 0;
        }
        ListNode tmp = head;
        int res=0;
        int size = sizeLL(head);
        while(tmp != null ){
            res += (tmp.val * Math.abs(Math.pow(2,size)));
            tmp=tmp.next;
            size--;
        }
        return res;
    }


    static ListNode middleNode(ListNode head) {
        ListNode front = head;
        ListNode back = head;

        while(front != null && front.next != null){
            front = front.next.next;
            back = back.next;
        }

        return back;
    }


    static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        while(curr.next != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        //head = curr;

        return curr;
    }


    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if ( list1 == null ){
            return list2;
        }
        if ( list2 == null ){
            return list1;
        }

        ListNode one= list1;
        ListNode two= list2;
        ListNode result = null;
        ListNode r;

        if(list1.val < list2.val){
            result = new ListNode(list1.val);
            one=list1.next;
            r=result;
            //r=r.ptr;
        } else {
            result = new ListNode(list2.val);
            two=list2.next;
            r=result;
            //r=r.ptr;
        }

        while(one != null && two != null){
            if ( one.val < two.val){
                ListNode nnode = new ListNode(one.val);
                r.next= nnode;
                nnode.next=null;
                r=nnode;
                one=one.next;
            } else {
                ListNode nnode = new ListNode(two.val);
                r.next= nnode;
                nnode.next=null;
                r=nnode;
                two=two.next;
            }
        }

        while(one != null){
            ListNode nnode = new ListNode(one.val);
            r.next= nnode;
            nnode.next=null;
            r=nnode;
            one=one.next;
        }

        while(two != null){
            ListNode nnode = new ListNode(two.val);
            r.next= nnode;
            nnode.next=null;
            r=nnode;
            two=two.next;
        }

        return result;
        
    }


    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sa = sizeLL(headA);
        int sb = sizeLL(headB);
        ListNode na = headA;
        ListNode nb = headB;

        int diff = Math.abs(sa-sb);

        if(sa<sb){
            for(int i=0; i<diff; i++){
                nb=nb.next;
            }
        } else if(sa>sb){
            for(int i=0; i<diff; i++){
                na=na.next;
            }
        }
        if(na==nb){
            return na;
        }
        while(na.next != nb.next){
            na=na.next;
            nb=nb.next;
        }
        if(na == null || nb == null){
            return null;
        }

        return na.next;
    }


    static ListNode deleteDuplicates(ListNode head) {
        ListNode out= new ListNode(0);
        ListNode t=out;

        while(head!=null){
            while(head.next!=null && head.val==head.next.val)
                head=head.next;
            t.next=new ListNode(head.val);
            t=t.next;
            head=head.next;    
        }
        return out.next;
    }


    static boolean pCheck(ListNode right){
        if(right==null){
            return true;
        }
        boolean result = pCheck(right.next);
        if(result == false){
            return false;
        } else if(left.val != right.val){
            return false;
        } else{
            left=left.next;
            return true;
        }
    }
    static ListNode left;
    static boolean isPalindrome(ListNode head) {
        left = head;
        return pCheck(head);
    }


    static boolean hasCycle(ListNode head) {
        //ListNode tmp =head;
        ListNode front =head;
        ListNode back = head;
        if(head == null || head.next == null){
            return false;
        } else{
            while(front != null && front.next != null){
                front=front.next.next;
                back=back.next;
                if(front==back){
                    return true;
                }
            }
            return false;
        }
    }


    static ListNode removeElements(ListNode head, int val) {
        ListNode tmp = head;
        ListNode prev = head;
        if(head == null){
            return null;
        } else {
            while(tmp.next != null){
                if(tmp.val == val){
                    if (tmp==head){
                        head=tmp.next;
                        tmp=head;
                        continue;
                    } else{
                        prev.next=tmp.next;
                        tmp=tmp.next;
                        continue;
                    }
                }
                prev=tmp;
                tmp=tmp.next;
            }
            if(tmp.val==val){
                if(tmp==head){
                    return null;
                }else{
                    prev.next=null;
                }
            }
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
        start2.next = new ListNode(11);
        start2.next.next = new ListNode(7);
        start2.next.next.next= new ListNode(7);
        start2.next.next.next.next= new ListNode(11);
        start2.next.next.next.next.next= new ListNode(11);
        //start2.ptr.ptr.ptr.ptr.ptr.ptr= new Node(22);

        //System.out.println(getDecimalValue(start2));
        //printLL(middleNode(start1));
        //printLL(reverseList(start2));
        //printLL(mergeTwoLists(start1, start2));
        //printLL(getIntersectionNode(start1, start2));
        //printLL(deleteDuplicates(start2));
        //System.out.println(isPalindrome(start2));
        printLL(removeElements(start2, 11));
    }
}
