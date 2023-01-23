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
        printLL(removeLast(start2));
        
    }
}
