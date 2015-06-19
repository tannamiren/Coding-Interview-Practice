/**
 * Created by miren_t on 6/8/2015.
 */
public class MaxSumNotAdjacent {
    public static void main(String[] args) {
        int arr[] = {-1, 4, 5, -2, -6, 6};

        int incl= arr[0];
        int excl=0, excl_new, t=0, t2=0 ;
     //   System.out.println("\texcl_new\tincl\texcl\n0\t"+incl+"\t"+excl);
        for (int i = 1; i < arr.length; i++) {
            excl_new= incl>excl? incl : excl;
            t=incl; t2=excl;
            incl= excl+arr[i];
            excl= excl_new;
   //         System.out.println(arr[i] + ":\t" + excl_new + "("+ t +">" + t2 + ")\t" + incl + "\t" + excl);
            }
        System.out.println(incl>excl?incl:excl);
    }
}
