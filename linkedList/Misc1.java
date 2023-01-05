import javax.swing.text.StyledEditorKit.BoldAction;

public class Misc1 {
    static class Node{
        public int val;
        public Node ptr;

        public Node(int val){
            this.val=val;
        }
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

    static Node foldLL(Node start){
        Node left = start;
        return foldCheck(start, start, left, 0);
    }

    static Node foldCheck(Node right, Node start, Node left, int cout){
        if(right == null){
            return start;
        }

        foldCheck(right.ptr, start, left, cout+1);
        System.out.println(sizeLL(start));
        System.out.println(cout);
        if(cout > sizeLL(start)){
            Node tmp = left.ptr;
            left.ptr= right;
            //System.out.println(left.val);
            //System.out.println(right.val);
            right.ptr= tmp;
            left=tmp;
        } else if( cout == sizeLL(start)){
            right.ptr=null;
        }

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
        Node start1 = new Node(0);
        start1.ptr = new Node(3);
        start1.ptr.ptr = new Node(4);
        start1.ptr.ptr.ptr= new Node(5);
        start1.ptr.ptr.ptr.ptr= new Node(7);
        start1.ptr.ptr.ptr.ptr.ptr= new Node(9);
        //start.ptr.ptr.ptr.ptr.ptr.ptr= new Node(2);

        Node start2 = new Node(0);
        start2.ptr = new Node(10);
        start2.ptr.ptr = new Node(6);
        start2.ptr.ptr.ptr= new Node(27);
        start2.ptr.ptr.ptr.ptr= new Node(11);
        start2.ptr.ptr.ptr.ptr.ptr= new Node(14);
        start2.ptr.ptr.ptr.ptr.ptr.ptr= new Node(22);


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
        printLL(foldLL(start1));

        //printLL(kReverse(start2, 3));


    }
}
