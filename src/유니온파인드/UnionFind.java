package 유니온파인드;

import java.util.Arrays;

public class UnionFind {

    static int [] parent;

    static int find(int num){
        if(num == parent[num]) return num;
        return parent[num] = find(parent[num]);
    }

    static void union(int n1, int n2){
        n1 = find(n1);
        n2 = find(n2);

        if(n1!=n2){
            if(n1<n2) parent[n2] = n1;
            else parent[n1] = n2;
        }
    }

    public static void main(String[] args) {
        int n = 8;
        parent = new int [n+1];

        Arrays.setAll(parent, (i) -> (i));




    }
}
