public class Misc11 {
    static class DNode {
        public int val;
        public DNode next;
        public DNode prev;

        public DNode(int val){
            this.val=val;
        }
    }

    static void printLL(DNode node){
        if(node==null){
            System.out.println("null");
        }
        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }

    static int sizeLL(DNode node){
        int size=1;
        while(node!=null){
            size++;
            node=node.next;
        }
        return size;
    }

    static DNode addFirst(DNode head, int ele){
        if(head==null){
            DNode nnode = new DNode(ele);
            head=nnode;
            return head;
        }
        DNode nnode = new DNode(ele);
        nnode.next=head;
        head.prev=nnode;
        nnode.prev=null;
        head=nnode;

        return head;
    }

    static DNode addLast(DNode head, int ele){
        if(head==null){
            DNode nnode = new DNode(ele);
            head=nnode;
            return head;
        }
        DNode tmp=head;
        while(tmp.next!=null){
            tmp=tmp.next;
        }
        DNode nnode = new DNode(ele);
        tmp.next=nnode;
        nnode.prev=tmp;
        nnode.next=null;

        return head;
    }

    static DNode removeFirst(DNode head){
        if(head==null || head.next==null){
            head=null;
            return null;
        }
        DNode tmp = head.next;
        head.next=null;
        tmp.prev=null;
        head=tmp;

        return head;
    }


    static DNode removeLast(DNode head){
        if(head==null || head.next==null){
            head=null;
            return null;
        }
        DNode tmp = head;
        while(tmp.next.next!=null){
            tmp=tmp.next;
        }
        tmp.next.prev=null;
        tmp.next=null;
        return head;
    }

    static int getFirst(DNode head){
        if(head==null){
            return -1;
        }
        return head.val;
    }

    static int getLast(DNode head){
        if(head==null){
            return -1;
        }
        DNode tmp=head;
        while(tmp.next!=null){
            tmp=tmp.next;
        }
        return tmp.val;
    }

    static DNode getAt(DNode head, int idx){
        if(head==null){
            return null;
        }
        DNode tmp=head;
        while(idx-->0){
            tmp=tmp.next;
        }
        return tmp;
    }

    static DNode addAt(DNode head, int idx, int ele){
        if(head==null || head.next==null || idx==0){
            addFirst(head, ele);
        }
        if(sizeLL(head)==idx){
            addLast(head, ele);
        }
        DNode tmp = getAt(head, idx);
        DNode pre = tmp.prev;
        //System.out.println(tmp.val);
        DNode nnode = new DNode(ele);
        pre.next=nnode;
        nnode.prev=pre;
        nnode.next=tmp;
        tmp.prev=nnode;

        return head;
        

    }


    public static void main(String[] args) {
        DNode start1 = new DNode(8);
        start1.next = new DNode(3);
        start1.next.next = new DNode(4);
        start1.next.next.next= new DNode(5);
        start1.next.next.next.next= new DNode(7);
        //start1.next.next.next.next.next= new DNode(9);
        //start1.next.next.next.next.next.next= new DNode(2);

        DNode start2 = new DNode(0);
        start2.next = new DNode(1);
        start2.next.next = new DNode(6);
        start2.next.next.next= new DNode(7);
        start2.next.next.next.next= new DNode(11);
        //start2.next.next.next.next.next= new Node(14);
        //start2.next.next.next.next.next.next= new Node(22);

        //printLL(addFirst(start1, 91));
        //printLL(removeFirst(start1));
        //printLL(removeLast(start2));
        //System.out.println(getFirst(start1));
        //System.out.println(getLast(start1));
        //System.out.println(getAt(start1, 2));
        printLL(addAt(start2, 3, 22));



        
    }
}
