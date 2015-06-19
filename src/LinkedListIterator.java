import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by miren_t on 6/4/2015.
 */
public class LinkedListIterator {
    public static int getMiddle(LinkedList<Integer> ll){
        ListIterator<Integer> slowIterator= ll.listIterator();
        ListIterator<Integer> fastIterator= ll.listIterator();

        int fast=-1;int slow=-1;
        while(slowIterator.hasNext()){
            slow=slowIterator.next();
            if(fastIterator.hasNext()){
                fast=fastIterator.next();
                if(fastIterator.hasNext())
                    fast= fastIterator.next();
                else{
                    return slow;
                }
            }
            else
            {
                return slow;
            }
            //         System.out.println(slow + " " + fast);
        }
        return -1;
    }
    public static int getNthFromLast(LinkedList<Integer> ll, int index){
        ListIterator<Integer> fastI= ll.listIterator();
        ListIterator<Integer> slowI= ll.listIterator();
        int count=0;
        while(fastI.hasNext() && count!=index){
            fastI.next();count++;
        }
        while(fastI.hasNext() && slowI.hasNext()){
            slowI.next();fastI.next();
        }
        return slowI.next();
    }

    public static boolean hasCycle(LinkedList<Integer> ll){
        ListIterator<Integer> fastI= ll.listIterator();
        ListIterator<Integer> slowI= ll.listIterator();
int fast=-1, slow=-1;
        while(slowI.hasNext()){
            slow=slowI.next();
            if(fastI.hasNext()){
                fastI.next();
                if(fastI.hasNext())
                    fast=fastI.next();
                if(slow==fast)
                    return true;
                else
                    return false;
            }
            if(slow==fast)
                return true;
            else
                return false;
        }
        return false;
    }
    public static void main(String[] args) {
        LinkedList<Integer> ll= new LinkedList<Integer>();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        System.out.println(ll);
        System.out.println(getMiddle(ll));
        System.out.println(getNthFromLast(ll, 2));
        System.out.println(hasCycle(ll));
    }
}
