package UnionFind;

public class Solution {
    int[] root;
    int[] rank;
    public Solution(int x){
        root = new int[x];
        rank = new int[x];
        for(int i = 0; i < root.length; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        //using quick union path compression
        if(x == root[x]) return x;
        return root[x] = find(root[x]);
    }

    public void union(int x, int y){
        //using quick union optimization by rank
        int rootX = find(x);
        int rootY = find(y);

        //if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        //}
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }

}
