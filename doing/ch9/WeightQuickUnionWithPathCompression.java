package ch9;

public class WeightQuickUnionWithPathCompression implements DisjointSets {
    private int[] parent;

    public WeightQuickUnionWithPathCompression(int num) {
        parent = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i] = -1;
        }
    }

    private int find(int p) {
        while (parent[p] >= 0) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j= find(q);
        parent[i] = j;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        DisjointSets finder = new WeightQuickUnionWithPathCompression(7);
        finder.connect(0, 1);
        finder.connect(1, 2);
        finder.connect(4, 2);
        finder.connect(3, 5);
        finder.connect(5, 6);
    }
}
