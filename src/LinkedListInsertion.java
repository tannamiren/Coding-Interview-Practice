
/**
 * Created by miren_t on 6/4/2015.
 */
class Node{
    Node next;
    Object data;

    public Node(Object dataValue){
        next=null;
        data=dataValue;
    }
    public Node(Node nextValue, Object dataValue){
        next=nextValue;
        data=dataValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
class LinkedList{
    private Node head;
    private int count;
    public LinkedList(){
        head= new Node(null);
        count=0;
    }
    public void add(Object data){
        Node temp= new Node(data);
        Node current= head;
        while(current.getNext()!= null){
            current= current.getNext();
        }
        current.setNext(temp);
        count++;
    }
    public void add(Object data, int index){
        Node temp= new Node(data);
        Node current= head;
        for(int i=1; i<index && current.getNext()!= null; i++){
            current= current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        count++;
    }
    public Object get(int index){
        if(index<=0)
            return null;
        Node current= head.getNext();
        for(int i=0; i<index; i++){
            if(current.getNext()== null)
                return null;
            current= current.getNext();
        }
        return current.getData();
    }
    public boolean remove(int index){
        if(index <1 || index >size())
            return false;
        Node current= head;
        for(int i=1; i<index; i++){
            if(current.getNext()== null)
                return false;
            current= current.getNext();
        }
        current.setNext(current.getNext().getNext());
        count--;
        return true;
    }
    public int size(){
        return count;
    }
    public String toString(){
        Node current=head.getNext();
        String output="";
        while(current!= null){
            output+= current.getData().toString()+ " ";
            current= current.getNext();
        }
        return output;
    }
    public String toString(Node head){
        Node current=head.getNext();
        String output="";
        while(current!= null){
            output+= current.getData().toString()+ " ";
            current= current.getNext();
        }
        return output;
    }
    public String getMiddle(){
        Node slow= head.getNext();
        Node fast= head.getNext();

        if (head.getNext()!= null){
            while(fast!= null && fast.getNext()!= null){
                fast= fast.getNext().getNext();
                slow=slow.getNext();
            }
        }
        return slow.getData().toString();
    }
    public Node getMiddleNode(){
        Node slow= head;
        Node fast= head.getNext();

        if (head.getNext()!= null){
            while(fast!= null && fast.getNext()!= null){
                fast= fast.getNext().getNext();
                slow=slow.getNext();
            }
        }
        return slow;
    }
    public String getNthFromLast(int index){
        Node slow= head.getNext();
        Node fast=head.getNext();
        if(head.getNext()!= null){
            for(int i=1; i<index; i++){
                fast=fast.getNext();
            }
            while(fast.getNext()!= null){
                slow=slow.getNext();
                fast=fast.getNext();
            }
        }
        return slow.getData().toString();
    }
    public void reverse(){
        Node prev= null;
        Node current= head.getNext();
        Node next;
        while (current!= null){
            next= current.getNext();
            current.setNext(prev);
            prev= current;
            current= next;
        }
        head.setNext(prev);

    }
    public void reverseFrom(Node head, Node mid){
        Node prev= null;
        Node current= head.getNext();
        Node next;
        while (current!= null){
            next= current.getNext();
            current.setNext(prev);
            prev= current;
            current= next;
  //          System.out.println(current.getData().toString());
        }
        head.setNext(prev);
   //     mid.setNext(head);
        System.out.println(head.getData());
  //      System.out.println(mid.getData());
        System.out.println(prev.getData());
  //      System.out.println(current.getData().toString());

    }
    public boolean hasCycle(){
        Node temp=head.getNext();
        while(temp.getNext()!= null){
            temp=temp.getNext();
        }
  //      temp.setNext(head.getNext().getNext());
        Node slow=head.getNext();
        Node fast=head.getNext();

        while(fast.getNext()!= null && fast!= null){
            fast=fast.getNext().getNext();
            slow=slow.getNext();
            if(fast.getData().equals(slow.getData()))
                return true;
        }
        return false;
    }
    public boolean isPallindrome(){
        Node mid= getMiddleNode();
    //    System.out.println(mid.getData());
        reverseFrom(mid, mid);
        Node slow= head.getNext();
    //    System.out.println(slow.getData());
        Node fast=mid.getNext();
    //    System.out.println(fast.getData());
        while(slow!= null && fast!= null){
            if(slow.getData()==fast.getData()){
                fast=fast.getNext();
                slow=slow.getNext();

            }
            else
                return false;

        }
        return true;
    }
    public void swap(Node x, Node y){
        Object temp=x.getData();
        x.setData(y.getData());
        y.setData(temp);
    }
    public void pairwiseSwap(){
        Node temp=head.getNext();
        while(temp!=null && temp.getNext()!= null){
            swap(temp, temp.getNext());
            temp=temp.getNext().getNext();
        }
    }
    public void intersectLL( LinkedList otherHeadd, LinkedList intersect){
        Node otherHead= otherHeadd.head.getNext();
        Node temp= head.getNext();
        int x=0;//=Integer.parseInt(head.getNext().getData().toString());
        //System.out.println(x);
        int y=0;//=Integer.parseInt(otherHead.getData().toString());
        //System.out.println(y);
        while(temp!= null || otherHead!= null)
           System.out.println(Integer.parseInt(temp.getData().toString()) + "-" + Integer.parseInt(otherHead.getData().toString()));
        x=Integer.parseInt(temp.getData().toString());
        System.out.println(x + " " + y);
    //    y=Integer.parseInt(otherHead.getData().toString());
        if(Integer.parseInt(temp.getData().toString())<Integer.parseInt(otherHead.getData().toString())){
            if(temp.getNext()!= null)
            temp=temp.getNext();
            //else break;
        }
        else if(Integer.parseInt(temp.getData().toString())>Integer.parseInt(otherHead.getData().toString()))
        {
            if(otherHead.getNext()!= null)
            otherHead=otherHead.getNext();
            //else break;
        }
        else if(Integer.parseInt(temp.getData().toString())==Integer.parseInt(otherHead.getData().toString())){
            intersect.add(Integer.parseInt(temp.getData().toString()));
        }
    }

    public void getMerged(){
        toString(mergeSort(head));
    }
    public Node mergeSort(Node head){
        Node a;
        Node b;
        if(head== null || head.getNext()== null){
            return head;
        }
        Node front= head.getNext();
        Node back= getMiddleNode();
        a= mergeSort(front);
        b= mergeSort(back);
        System.out.println(a.getData() + "-" + b.getData());
        return sortedMerge(a, b);

    }
    public Node sortedMerge(Node a, Node b){
        Node result= null;
        if(a==null)
            return b;
        else if(b== null)
            return a;

        if(Integer.parseInt(a.getData().toString()) <= Integer.parseInt(b.getData().toString())){
            result= a;
            result.setNext(sortedMerge(a.getNext(), b));
        }
        else{
            result= b;
            result.setNext(sortedMerge(a, b.getNext()));
        }
        return result;
    }
    public Node getHead(){
        return head.getNext();
    }

}
public class LinkedListInsertion {
    public static void main(String[] args) {

        LinkedList ll= new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);

        System.out.println(ll);
       // System.out.println("middle: " + ll.getMiddle());
     //   System.out.println(ll.getNthFromLast(3));
   //     ll.reverse();
   //     System.out.println(ll);
//        System.out.println(ll.hasCycle());
 //       System.out.println(ll.isPallindrome());
 //       ll.pairwiseSwap();
  //      System.out.println(ll);

        LinkedList ll2= new LinkedList();
        ll2.add(2);
        ll2.add(4);
        ll2.add(6);

        LinkedList intersect= new LinkedList();
   //     ll.intersectLL(ll2, intersect);
//        System.out.println(intersect);

        ll.getMerged();
    }

}
