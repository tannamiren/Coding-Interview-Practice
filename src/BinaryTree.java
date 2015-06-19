import java.util.LinkedHashSet;
import java.util.Stack;

/**
 * Created by miren_t on 6/5/2015.
 */
class Nodes{
    int data;
    Nodes left, right, next;
    public Nodes(int data){
        this.data=data;
        left=null;
        right=null;
    }
    public int getNext() {
        return data;
    }

    public void setNext(Nodes next) {
        this.next = next;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Nodes getLeft() {
        return left;
    }

    public void setLeft(Nodes left) {
        this.left = left;
    }

    public Nodes getRight() {
        return right;
    }

    public void setRight(Nodes right) {
        this.right = right;
    }
}
class BT{
    Node root;
    LinkedHashSet<Integer> left= new LinkedHashSet<Integer>();
    LinkedHashSet<Integer> right= new LinkedHashSet<Integer>();

    void printPostOrder(Nodes node){
        if(node== null)
            return;
        printPostOrder(node.getLeft());
        printPostOrder(node.getRight());
        System.out.print(node.getData() + "-");
    }
    void printInOrder(Nodes node){
        if(node== null)
            return;
        printInOrder(node.getLeft());
        System.out.print(node.getData() + "-");
        printInOrder(node.getRight());
    }
    void printPreOrder(Nodes node){
        if(node== null)
            return;
        System.out.print(node.getData() + "-");
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }
    int size(Nodes node){
        if(node== null)
            return 0;
        else
            return size(node.getLeft()) + 1 + size(node.getRight());
    }
    boolean isDuplicate(Nodes one, Nodes two){
        if(one== null && two== null)
            return true;
        else if(one!= null && two!= null){
            return one.getData()==two.getData() && isDuplicate(one.getLeft(), two.getLeft()) && isDuplicate(one.getRight(), two.getRight());
        }
        return false;
    }
    int getDepth(Nodes node){
        if(node== null)
            return 0;
        else{
            int left= getDepth(node.getLeft());
            int right= getDepth(node.getRight());

            if(left>right)
                return left+1;
            else
                return right+1;
        }
    }
    void setMirror(Nodes node){
        if(node== null)
            return;
        else {
            Nodes temp= null;
            setMirror(node.getLeft());
            setMirror(node.getRight());

            temp= node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);
        }
    }
    void printRootToLeaf(Nodes node, int path[], int pathLen){
        if(node== null)
            return;
        path[pathLen]= node.getData();
        pathLen++;
        if(node.getLeft()== null && node.getRight()== null)
            printArray(path, pathLen);
        else{
            printRootToLeaf(node.getLeft(), path, pathLen);
            printRootToLeaf(node.getRight(), path, pathLen);
        }
    }
    void printArray(int path[], int pathLen){
        for (int i = 0; i < pathLen; i++) {
            System.out.print(path[i] + "-");
        }
        System.out.println();
    }
    void printLevelOrder(Nodes node){
        for (int i = 1 ; i <= getDepth(node); i++) {
            printGivenLevel(node, i);
        }
    }
    void printGivenLevel(Nodes node, int level){
        if(node== null)
            return;
        if(level== 1)
            System.out.print(node.getData() + "-");
        else{
            printGivenLevel(node.getLeft(), level-1);
            printGivenLevel(node.getRight(), level-1);
        }
    }
    int getCountOfLeaf(Nodes node){
        if(node== null)
            return 0;
        if(node.getLeft()== null && node.getRight()== null)
            return 1;
        else{
            return getCountOfLeaf(node.getLeft()) + getCountOfLeaf(node.getRight());
        }
    }
    void printSpiral(Nodes node){
        if(node== null)
            return;
        Stack<Nodes> s1= new Stack<Nodes>();
        Stack<Nodes> s2= new Stack<Nodes>();

        s1.push(node);

        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                Nodes temp= s1.peek();
                s1.pop();
                System.out.print(temp.getData() + " ");
                if(temp.getRight()!= null)
                    s2.push(temp.getRight());
                if(temp.getLeft()!= null)
                    s2.push(temp.getLeft());
            }
            System.out.println();
            while(!s2.isEmpty()){
                Nodes temp= s2.peek();
                s2.pop();
                System.out.print(temp.getData() + " ");
                if(temp.getLeft()!= null)
                    s1.push(temp.getLeft());
                if(temp.getRight()!= null)
                    s1.push(temp.getRight());

            }
            System.out.println();
        }
    }
    boolean isSumProperty(Nodes node){
        int left=0, right=0;
        if(node== null && (node.getLeft()== null && node.getRight()==null))
            return true;
        else{
            if(node.getLeft()!= null)
                left= node.getLeft().getData();
            if(node.getRight()!= null)
                right= node.getRight().getData();
            if(node.getData()== left+right && isSumProperty(node.getLeft()) && isSumProperty(node.getRight()))
                return true;
            else
                return false;
        }

    }
    Nodes leastCommonAncestor(Nodes node, int n1, int n2){
        if(node== null)
            return null;
        else if(node.getData()< n1 && node.getData()< n2)
        {
            System.out.println(node.getData());
            return leastCommonAncestor(node.getRight(), n1, n2);
        }
        else if(node.getData()> n1 && node.getData()> n2)
        {
            System.out.println(node.getData());
            return leastCommonAncestor(node.getLeft(), n1, n2);
        }
        else if(node.getData()> n1 && node.getData()< n2)
        {
            System.out.println(node.getData());
            return node;
        }
        return node;
    }
    public int getLCA(Nodes node, int n1, int n2){
        return leastCommonAncestor(node, n1, n2).getData();
    }

}
public class BinaryTree {
    public static void main(String[] args) {
        Nodes root= new Nodes(1);
        root.left= new Nodes(2);
        root.right= new Nodes(3);
        root.left.left= new Nodes(7);
        root.left.right= new Nodes(4);
        root.left.right.right= new Nodes(5);
        root.left.right.right.right= new Nodes(6);
        root.right.left= new Nodes(2);
        root.right.left.right= new Nodes(1);

        Nodes root2= new Nodes(1);
        root2.left= new Nodes(2);
        root2.right= new Nodes(3);
        root2.left.left= new Nodes(7);
        root2.left.right= new Nodes(4);
        root2.left.right.right= new Nodes(5);
        root2.left.right.right.right= new Nodes(6);
        root2.right.left= new Nodes(2);
        root2.right.left.right= new Nodes(1);

        BT bt= new BT();
        bt.printPreOrder(root);
        System.out.println("=========");
        bt.printInOrder(root);
        System.out.println("=========");
        bt.printPostOrder(root);
        System.out.println("=========");
        System.out.println(bt.size(root));
        System.out.println("=========");
        System.out.println(bt.isDuplicate(root, root2));
        System.out.println("=========");
        System.out.println(bt.getDepth(root));
        System.out.println("=========");
        bt.setMirror(root);
        bt.printInOrder(root);
        System.out.println("=========");
        int paths[]= new int[20];
        bt.printRootToLeaf(root, paths, 0);
        System.out.println("=========");
        bt.printLevelOrder(root);
        System.out.println("=========");
        System.out.println(bt.getCountOfLeaf(root));
        System.out.println("=========");
        bt.printSpiral(root);
        System.out.println("=========");
        System.out.println(bt.isSumProperty(root));
        System.out.println("=========");

        Nodes root3= new Nodes(20);
        root3.left= new Nodes(8);
        root3.right= new Nodes(22);
        root3.left.left= new Nodes(4);
        root3.left.right= new Nodes(12);
        root3.left.right.left  = new Nodes(10);
        root3.left.right.right = new Nodes(14);
        System.out.println(bt.getLCA(root3, 10, 22));



    }
}
