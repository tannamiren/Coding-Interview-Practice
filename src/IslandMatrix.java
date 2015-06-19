import java.util.HashSet;

/**
 * Created by miren_t on 6/18/2015.
 */
public class IslandMatrix {
    public static void main(String[] args) {

        int m[][]={ {1, 1, 0, 0, 0},
                    {0, 1, 0, 0, 1},
                    {1, 0, 0, 1, 1},
                    {0, 0, 0, 0, 0},
                    {1, 0, 1, 0, 1}
                    };
        System.out.println(countIslands(m));
    }

    public static int countIslands(int m[][]){
        HashSet<String> visited= new HashSet<String>();
        int countIslands=0;
         for(int i=0; i<m.length; i++){
             for(int j=0; j<m.length; j++){
                 if(m[i][j]==1){
                     if(i>0 && i<m.length-1 && j==0){
                         if(m[i-1][j+1]==1 || m[i][j+1]==1 || m[i+1][j+1]==1 || m[i+1][j]==1 || m[i-1][j]==1){
                             //do nothing
                         }
                         else{
                             visited.add(i+ ","+ j);
                             countIslands++;
                         }
                     }
                     if(i>0 && i<m.length-1 && j==m.length-1){
                         if(m[i+1][j]==1 || m[i+1][j-1]==1 || m[i][j-1]==1 || m[i-1][j-1]==1 || m[i-1][j]==1){
                             if(!visited.contains(i+1 + ","+ j) && !visited.contains(i+1 + ","+ (j-1))  &&
                                     !visited.contains(i + ","+ (j-1)) && !visited.contains((i-1) + ","+ (j-1)) &&
                                     !visited.contains((i-1) + ","+ j))
                                 visited.add(i+ ","+ j);
                         }
                         else{
                             visited.add(i+ ","+ j);
                             countIslands++;
                         }
                     }
                     if(i==0){
                         if(j==0){
                             if(m[i][j+1]==1 || m[i+1][j+1]==1 || m[i+1][j]==1)
                             {
                                if(visited.isEmpty())
                                    visited.add(i+ ","+ j);
                             }
                             else{
                                 visited.add(i+ ","+ j);
                                 countIslands++;
                             }
                         }
                         if(j==m.length-1){
                             if(m[i+1][j]==1 || m[i+1][j-1]==1 || m[i][j-1]==1)
                             {
                                 //do nothing
                             }
                             else{
                                 visited.add(i+ ","+ j);
                                 countIslands++;
                             }
                         }
                         if(j>0 && j<m.length-1){
                             if(m[i][j+1]==1 || m[i+1][j+1]==1 || m[i+1][j]==1 || m[i+1][j-1]==1 || m[i][j-1]==1){
                                 //do nothing
                             }
                             else{
                                 visited.add(i+ ","+ j);
                                 countIslands++;
                             }
                         }
                     }
                     if(i==m.length-1){
                         if(j==0){
                             if(m[i-1][j]==1 || m[i-1][j+1]==1 || m[i][j+1]==1)
                             {
                                 if(visited.isEmpty())
                                     visited.add(i+ ","+ j);
                             }
                             else{
                                 visited.add(i+ ","+ j);
                                 countIslands++;
                             }
                         }
                         if(j==m.length-1){
                             if(m[i-1][j]==1 || m[i-1][j-1]==1 || m[i][j-1]==1)
                             {
                                 //do nothing
                             }
                             else{
                                 visited.add(i+ ","+ j);
                                 countIslands++;
                             }
                         }
                         if(j>0 && j<m.length-1){
                             if(m[i-1][j+1]==1 || m[i][j+1]==1 || m[i][j-1]==1 || m[i-1][j-1]==1 || m[i-1][j]==1){
                                 //do nothing
                             }
                             else{
                                 visited.add(i+ ","+ j);
                                 countIslands++;
                             }
                         }
                         if(i>0 && i<m.length-1 && j>0 && j<m.length-1){
                             if(m[i-1][j+1]==1 || m[i][j+1]==1 || m[i+1][j+1]==1 || m[i+1][j]==1 || m[i+1][j-1]==1 ||
                                     m[i][j-1]==1 || m[i-1][j-1]==1 || m[i-1][j]==1){
                                 //do nothing
                             }
                             else{
                                 visited.add(i+ ","+ j);
                                 countIslands++;
                             }
                         }
                     }
                 }
             }
         }
   //     System.out.println(visited);
        return visited.size();
    }
}
