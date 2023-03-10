//import javax.swing.text.StyledEditorKit.BoldAction;

public class Misc1 {
    static class Node{
        public int val;
        public Node ptr;

        public Node(int val){
            this.val=val;
        }
    }

    static Node addFirst(Node start, int num) {
        Node nnode = new Node(num);
        nnode.ptr = start;
        start = nnode;

        return start;
    }

    static int kthEnd(Node start, int k){
        Node front=start;
        Node back=start;
        
        int i=0;
        while(i<k){
            front=front.ptr;
            i++;
        }
        while(front.ptr != null){
            front=front.ptr;
            back=back.ptr;
        }

        return back.val;
    }

    static Node midLL(Node start){
        Node front = start;
        Node back = start;

        while (front.ptr != null && front.ptr.ptr != null){
            front=front.ptr.ptr;
            back=back.ptr;
        }
        return back;
    }

    static Node merge2SortedList(Node start1, Node start2){
        Node p = start1;
        Node q = start2;
        Node start3;
        Node r;

        if(start1.val < start2.val){
            start3 = new Node(start1.val);
            p=start1.ptr;
            r=start3;
            //r=r.ptr;
        } else {
            start3 = new Node(start2.val);
            q=start2.ptr;
            r=start3;
            //r=r.ptr;
        }
        while(p.ptr != null && q.ptr != null){
            if ( p.val < q.val){
                Node nnode = new Node(p.val);
                r.ptr= nnode;
                nnode.ptr=null;
                r=nnode;
                p=p.ptr;
            } else {
                Node nnode = new Node(q.val);
                r.ptr= nnode;
                nnode.ptr=null;
                r=nnode;
                q=q.ptr;
            }
        }

        while(p.ptr != null){
            Node nnode = new Node(p.val);
            r.ptr= nnode;
            nnode.ptr=null;
            r=nnode;
            p=p.ptr;
        }

        while(q.ptr != null){
            Node nnode = new Node(q.val);
            r.ptr= nnode;
            nnode.ptr=null;
            r=nnode;
            q=q.ptr;
        }

        return start3;
    }

    static Node sortedMerge(Node start1, Node start2){
        Node start3 = null;
        if(start1 == null){
            return start2;
        }
        if(start2 == null){
            return start1;
        }
        if(start1.val<start2.val){
            start3 = start1;
            start3.ptr = sortedMerge(start1.ptr, start2);
        } else{
            start3=start2;
            start3.ptr = sortedMerge(start1, start2.ptr);
        }

        return start3;
    }

    static Node mergeSort(Node start){
        if (start==null || start.ptr == null){
            return start;
        }

        Node mid = midLL(start);
        Node tmp = mid.ptr;
        Node one = mergeSort(start);
        Node two = mergeSort(tmp);
        Node sort = sortedMerge(one, two);

        return sort;
    }

    static Node kReverse(Node start, int k){
        Node curr = start;
        Node tmp = null;
        Node prev = null;

        if (start==null){
            return null;
        }
        int i=0;
        while(i<k && curr != null){
            tmp = curr.ptr;
            curr.ptr = prev;
            prev=curr;
            curr=tmp;
            i++;
        }
        if(tmp != null){
            start.ptr=kReverse(tmp, k);
        }
        return prev;
    }

    static Node kReverse2(Node start, int k){
        if(start==null ){
            return null;
        }

        Node curr = start;
        Node fowd = start;
        Node head = null;
        Node tail = null;
        Node tmph = null;
        Node tmpt = null;

        int length = sizeLL(start);
        while(length >= k){
            int tmpk = k;
            for(int i=tmpk; i<=0; tmpk--){
                fowd=curr.ptr;
                curr.ptr=null;
                addFirst(curr, curr.val);
                curr=fowd;
            }
            if(head==null){
                head= tmph;
                tail= tmpt;
            } else{
                tail.ptr=tmph;
                tail=tmpt;
            }
            tmph=null;
            tmpt=null;
            length=length-k;
        }
        tail.ptr=curr;
        return head;
    }
    

    static boolean isPalindrome(Node start){
        Node left = start;
        return pCheck(start, start, left);
    }

    static boolean pCheck(Node right, Node start, Node left){
        if(right == null){
            return true;
        }
        boolean res = pCheck(right.ptr, start, left);
        if(res == false){
            return false;
        } else if(left.val != right.val){
            return false;
        } else {
            left=left.ptr;
            return true;
        }

    }

    static void foldLL(Node start){
        Node left = start;
        foldCheck(start, start, left, 0);
    }

    static void foldCheck(Node right, Node start, Node left, int cout){
        Node cstart= start;
        if(right == null){
            return ;
        }

        //System.out.println(cout);
        foldCheck(right.ptr, start, left, cout+1);
        System.out.println(sizeLL(cstart)/2);
        System.out.println(cout);
        if(cout > sizeLL(cstart)/2){
            Node tmp = left.ptr;
            left.ptr= right;
            //System.out.println(left.val);
            //System.out.println(right.val);
            right.ptr= tmp;
            left=tmp;
        } else if( cout == sizeLL(cstart)/2){
            right.ptr=null;
        }
    }

    static Node intersectLL(Node start1, Node start2){
        Node tmp1 = start1;
        Node tmp2 = start2;

        int d= Math.abs(sizeLL(start1)-sizeLL(start2));
        System.out.println(d);
        if(sizeLL(start1)> sizeLL(tmp2)){
            for( int i=0; i<d; i++){
                tmp1=tmp1.ptr;
            }
        } else{
            for(int i=0; i<d;i++){
                tmp2=tmp2.ptr;
            }
        }

        while(tmp1.ptr != tmp2.ptr){
            tmp1 = tmp1.ptr;
            tmp2 = tmp2.ptr;
        }

        return tmp1.ptr;
    }

    static Node add2NumLL(Node start1, Node start2){
        Node result=null;
        int crr = addCheck(start1, sizeLL(start1), start2, sizeLL(start2), result);
        System.out.println(result.val);
        if(crr>0){
            addFirst(result, crr);
        }
        return result;
    }
    static int addCheck(Node start1, int pos1, Node start2, int pos2, Node result){
        if(pos1 == 0 && pos2 == 0){
            return 0;
        }
        int ele=0;
        if(pos1<pos2){
            int crr = addCheck(start1, pos1, start2.ptr, pos2 - 1, result);
            ele = start2.val + crr;
        } else if(pos1>pos2){
            int crr = addCheck(start1.ptr, pos1 -1, start2, pos2, result);
            ele = start1.val + crr;
        } else {
            int crr = addCheck(start1.ptr, pos1 -1, start2.ptr, pos2 -1, result);
            ele = start1.val + start2.val + crr;
        }

        int nele = ele%10;
        int ncrr = ele/10;
        addFirst(result, nele);

        return ncrr;
    }

    static Node add2NumLL2(Node start1, Node start2){
        if(start1==null || start2==null){
            return null;
        }
        
        start1 = reverse(start1);
        start2 = reverse(start2);

        Node head = new Node(0);
        Node tmp = head;
        Node curr1 = start1;
        Node curr2 = start2;
        int carry = 0;
        //int sum = 0;
        
        while(curr1!=null || curr2!=null || carry!=0){
            //int sum = carry + (if(curr1!=null){return curr1.val;}else{return 0;}) + (if(curr2!=null){return curr2.val;}else{return 0;}) ;
            int sum = carry + (curr1 != null ? curr1.val:0) + (curr2!=null ? curr2.val:0);

            int ele = sum%10;
            carry = sum/10;

            tmp.ptr = new Node(ele);
            tmp=tmp.ptr; 

            if(curr1!=null){
                curr1=curr1.ptr ;
            }
            if(curr2!=null){
                curr2=curr2.ptr ;
            }
        }
        return reverse(head.ptr);
    }

    static Node reverse(Node start){
        Node tmp = start;
        Node prev = null;
        Node st;

        while(tmp.ptr != null){
            st= tmp.ptr;
            tmp.ptr = prev;
            prev=tmp;
            tmp=st;
        }
        tmp.ptr=prev;
        start=tmp;

        return start;
    }

    static int sizeLL(Node node){
        int ct=1;
        while (node.ptr != null) {
            node = node.ptr;
            ct++;
        }
        return ct;

    }

    static void printLL(Node node) {
        while (node.ptr != null) {
            System.out.println(node.val);
            node = node.ptr;
        }
        System.out.println(node.val);
    }
    public static void main(String[] args) {
        Node start1 = new Node(8);
        start1.ptr = new Node(3);
        start1.ptr.ptr = new Node(4);
        start1.ptr.ptr.ptr= new Node(5);
        start1.ptr.ptr.ptr.ptr= new Node(7);
        //start1.ptr.ptr.ptr.ptr.ptr= new Node(9);
        //start.ptr.ptr.ptr.ptr.ptr.ptr= new Node(2);

        Node start2 = new Node(0);
        start2.ptr = new Node(1);
        start2.ptr.ptr = new Node(6);
        start2.ptr.ptr.ptr= new Node(7);
        start2.ptr.ptr.ptr.ptr= new Node(11);
        //start2.ptr.ptr.ptr.ptr.ptr= new Node(14);
        //start2.ptr.ptr.ptr.ptr.ptr.ptr= new Node(22);


        //printLL(start1);

        //int value = midLL(start1);
        
        //int value = kthEnd(start1, 3);
        //System.out.println("Value: "+value);

        //printLL(merge2SortedList(start1, start2));

        //Node startN = mergeSort(start2);
        //printLL(startN);

        /* 
        if (isPalindrome(start1)){
            System.out.println("true");
        } else {
            System.out.println("False");
        }
        */

        //System.out.println("gkjgj");
        //foldLL(start2);
        //printLL(start2);
        //printLL(kReverse(start2, 3));
        //printLL(kReverse2(start2, 3));

        //System.out.println("Value"+(intersectLL(start1, start2)).val);

        printLL(add2NumLL2(start1, start2));


    }
}
