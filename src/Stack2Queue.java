import java.util.Stack;

/**
 * Created by miren_t on 6/7/2015.
 */
public class Stack2Queue {
    public static void main(String[] args) {
        Stack s1= new Stack();
        Stack s2= new Stack();

        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.push(6);

        System.out.println(s1.toString());

        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        while(!s2.isEmpty())
            System.out.println(s2.pop());
    }
}
