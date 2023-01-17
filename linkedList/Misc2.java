import java.util.PriorityQueue;

public class Misc2 {
    static class Node{
        public int val;
        public Node next;

        public Node(int val){
            this.val=val;
        }
    }

    static int sizeLL(Node node){
        int ct=1;
        while (node.next != null) {
            node = node.next;
            ct++;
        }
        return ct;

    }

    static Node reverse(Node start){
        Node tmp = start;
        Node prev = null;
        Node st;

        while(tmp.next != null){
            st= tmp.next;
            tmp.next = prev;
            prev=tmp;
            tmp=st;
        }
        tmp.next=prev;
        start=tmp;

        return start;
    }

    static void printLL(Node node) {
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }

    static Node merge2List(Node start1, Node start2){
        if(start1==null){
            return start2;
        } 
        if(start2==null){
            return start1;
        }
        Node p=start1.next;
        Node q=start2.next;
        Node tmp;
        Node store;
        if(start1.val<start2.val){
            tmp = start1;
            store = start1;
        } else{
            tmp = start2;
            store = start2;
        }

        while(p!=null && q!=null){
            if(p.val<q.val){
                tmp.next=p;
                tmp=tmp.next;
                p=p.next;
            }else{
                tmp.next=q;
                tmp=tmp.next;
                q=q.next;
            }
        }

        while(p!=null){
            tmp.next=p;
            tmp=tmp.next;
            p=p.next;
        }
        while(q!=null){
            tmp.next=q;
            tmp=tmp.next;
            q=q.next;
        }

        return store;
    }

    static Node mergeKListcheck(Node[] list, int start, int end){
        if(start>end){
            return null;
        }
        if(start==end){
            return list[start];
        }
        int mid= (start+end)/2;

        Node one=mergeKListcheck(list, start, mid);
        Node two=mergeKListcheck(list, mid+1, end);

        return merge2List(one, two);
    }

    static Node mergeKList(Node[] list){
        if(list.length == 0){
            return null;
        }
        return(mergeKListcheck(list, 0, list.length-1));
    }

    static Node PmergeKList(Node[] list){
        PriorityQueue<Node> pQueue = new PriorityQueue<>((a,b)->{
            return a.val-b.val ;
        });

        for (Node i: list){
            if(i!=null){
                pQueue.add(i);
            }
        }
        Node st=new Node(0);
        Node tmp=st;
        while(pQueue.size()!=0){
            Node node = pQueue.remove();
            tmp.next=node;
            tmp=tmp.next;
            node=node.next;

            if(node!=null){
                pQueue.add(node);
            }
        }
        return st.next;
    }

    static Node OddEvenSep(Node start){
        if(start==null){
            return null;
        }

        Node head1=new Node(0);
        Node head2=new Node(0);
        Node odd=head1;
        Node even=head2;
        Node tmp = start.next;

        if(start.val%2==0){
            head2.next=start;
            even=start;
        }else{
            head1.next=start;
            odd=start;
        }

        while(tmp!=null){
            if(tmp.val%2==0){
                even.next=tmp;
                even=even.next;
            }else{
                odd.next=tmp;
                odd=odd.next;
            }
            tmp=tmp.next;
        }

        return head1;
    }

    static Node IntersectionNode(Node start){
        if(start==null || start.next==null){
            return null;
        }
        Node slow=start;
        Node fast=start;

        while(fast!=null || fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                break;
            }
        }
        if(slow!=fast){
            return null;
        }
        return slow;
    }
    static Node intNodeLL(Node headA, Node headB){
        if(headA==null || headB==null){
            return null;
        }
        Node tail=headA;

        while(tail.next!=null){
            tail=tail.next;
        }
        tail.next=headB;

        Node ans = IntersectionNode(headA);
        tail.next=null;
        return ans;

    }

    static Node Sub2LL(Node start1, Node start2){
        if(start1==null){
            start2.val=-start2.val;
            return start2;
        }
        if(start2==null){
            return start1;
        }

        start1=reverse(start1);
        start2=reverse(start2);

        Node curr1=start1;
        Node curr2=start2;
        Node head = new Node(0);
        Node tmp = head;
        int br = 0;
        int sub = 0;

        while(curr1!=null){
            sub = br + curr1.val - (curr2!=null?curr2.val:0);

            if(sub<0){
                br=-1;
                sub=sub+10;
            }else{
                br=0;
            }

            tmp.next = new Node(sub);
            tmp=tmp.next;

            curr1=curr1.next;
            if(curr2!=null){
                curr2=curr2.next;
            }
        }
        return reverse(head.next);
    }

    static Node mul2LL(Node start1, Node start2){
        if(start1==null || start2==null){
            return null;
        }

        start1=reverse(start1);
        start2=reverse(start2);

        Node itr2= start2;
        Node dummy = new Node(0);
        Node ansItr = dummy;

        while(itr2!=null){
            Node ans= mulLLdigit(start1, itr2.val);
            itr2=itr2.next;
            add2LL(ans, ansItr);
            ansItr=ansItr.next;
        }
        return reverse(dummy.next);
    }

    static Node mulLLdigit(Node start1, int digit){
        Node curr = start1;
        Node dummy = new Node(0);
        Node tmp = dummy;
        int carry = 0;
        int res;
        while(curr!=null || carry!=0){
            res = carry + (curr!=null?curr.val*digit : 0);

            int ele = res%10;
            carry = res/10;

            tmp.next=new Node(ele);
            tmp=tmp.next;

            if(curr!=null){
                curr=curr.next;
            }
        }
        return dummy.next;
    }

    static void add2LL(Node ans, Node ansItr){
        Node curr1 = ans;
        Node curr2 = ansItr;
        int carry = 0;
        int sum=0;

        while(curr1!=null || carry!=0 ){
            sum = carry + (curr1!=null?curr1.val:0) + (curr2.next!=null?curr2.next.val:0);

            int ele = sum%10;;
            carry = sum/10;

            if(curr2.next != null){
                curr2.next.val=ele;
            }else {
                curr2.next = new Node(ele);
            }

            if(curr1!=null){
                curr1=curr1.next;
            }
            curr2=curr2.next;
        }
    }

    static Node removeDupl(Node start){
        if(start==null || start.next==null){
            return null;
        }

        Node dummy = new Node(0);
        Node curr = start;
        Node tmp = dummy;

        while(curr!=null){
            while(curr!=null && tmp.val!=curr.val){
                curr=curr.next;
            }
            tmp.next=curr;
            tmp=tmp.next;
            if(curr!=null){
                curr=curr.next;
            }
        }
        return dummy.next;
    }

    static Node remAllDupl(Node start){
        if(start==null || start.next==null){
            return null;
        }
        Node dummy = new Node(0);
        Node tmp = dummy;
        tmp.next=start;
        Node curr = start.next;
        while(curr!=null){
            Boolean flag=false;
            while(curr!=null && tmp.next.val==curr.val){
                flag=true;
                curr=curr.next;
            }

            if(flag){
                tmp.next=curr;
            }else{
                tmp=tmp.next;
            }
            if(curr!=null){
                curr=curr.next;
            }
        }
        return dummy.next;
    }

    static Node seg012(Node start){
        if(start==null || start.next==null){
            return null;
        }
        Node zero = new Node(0);
        Node prev0 = zero;
        Node one = new Node(0);
        Node prev1 = one;
        Node two = new Node(0);
        Node prev2 = two;
        Node curr = start;

        while(curr!=null){
            if(curr.val==0){
                prev0.next=curr;
                prev0=prev0.next;
            }else if(curr.val==1){
                prev1.next=curr;
                prev1=prev1.next;
            }else{
                prev2.next=curr;
                prev2=prev2.next;
            }
            curr=curr.next;
        }
        prev1.next=prev2;
        prev0.next=prev1;
        prev2.next=null;

        return zero.next;
    }

    static Node[] segregate(Node start, int pivotIndex){
        Node less = new Node(0);
        Node high = new Node(0);
        Node curr = start;
        Node pivotNode = start;
        Node lp = less;
        Node hp = high;

        while(pivotIndex-->0){
            pivotNode=pivotNode.next;
        }

        while(curr != null){
            if(curr!=pivotNode){
                if(curr.val<=pivotNode.val){
                    lp.next=curr;
                    lp=lp.next;
                } else {
                    hp.next=curr;
                    hp=hp.next;
                }
            }
            curr=curr.next;
        }
        lp.next=null;
        hp.next=null;
        pivotNode.next=null;
        return new Node[] {less.next, pivotNode, high.next};
    }

    static Node[] mergeSorted(Node[] leftSorted, Node pivotNode, Node[] rightSorted){
        Node head = null;
        Node tail = null;

        if(leftSorted[0]==null && rightSorted[0]==null){
            leftSorted[1].next=pivotNode;
            pivotNode.next=rightSorted[0];
            rightSorted[1].next=null;
            head=leftSorted[0];
            tail=rightSorted[1];
        } else if(leftSorted[0]==null){
            pivotNode.next=rightSorted[0];
            rightSorted[1].next=null;
            head=pivotNode;
            tail=rightSorted[1];
        } else if(rightSorted[0]==null){
            leftSorted[1].next=pivotNode;
            pivotNode.next=null;
            head=leftSorted[0];
            tail=pivotNode;
        }else{
            head=tail=pivotNode;
            pivotNode.next=null;
        }
        return new Node[] {head,tail};
    }

    static Node[] quickSort_(Node start){
        int len=sizeLL(start);
        int pivotIndex = len/2;

        Node[] segregated = segregate(start, pivotIndex);
        Node[] leftSorted = quickSort_(segregated[0]);
        Node[] rightSorted = quickSort_(segregated[2]);

        return mergeSorted(leftSorted, segregated[1], rightSorted);
    }

    static Node quickSort(Node start){
        if(start==null || start.next==null){
            return start;
        }

        return quickSort_(start)[0];
    }



    public static void main(String[] args) {
        Node start1 = new Node(1);
        start1.next = new Node(3);
        start1.next.next = new Node(4);
        start1.next.next.next= new Node(4);
        start1.next.next.next.next= new Node(7);
        //start1.next.next.next.next.next= new Node(9);
        //start1.next.next.next.next.next.next= new Node(2);

        Node start2 = new Node(0);
        start2.next = new Node(1);
        start2.next.next = new Node(6);
        start2.next.next.next= new Node(7);
        //start2.next.next.next.next= new Node(11);
        //start2.next.next.next.next.next= new Node(14);
        //start2.next.next.next.next.next.next= new Node(22);

        Node start3 = new Node(0);
        start3.next = new Node(0);
        start3.next.next = new Node(1);
        start3.next.next.next= new Node(2);
        start3.next.next.next.next= new Node(1);
        start3.next.next.next.next.next= new Node(0);
        start3.next.next.next.next.next.next= new Node(2);

        //Node[] list = {start1, start2, start3};

        //printLL(mergeKList(list));
        //printLL(PmergeKList(list));
        //printLL(start3);

        //printLL(intNodeLL(start1,start2));

        //printLL(OddEvenSep(start3));

        //printLL(Sub2LL(start1, start2));
        //printLL(mul2LL(start1, start3));
        //printLL(removeDupl(start3));
        //printLL(remAllDupl(start1));
        //printLL(seg012(start3));
        printLL(quickSort(start3));


    }


}
