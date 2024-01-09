package ch9;

public class WeightedQuickUnionDS implements DisjointSets {
    public int[] parent;
    private int[] treeSize;

    public WeightedQuickUnionDS(int num) {
        parent = new int[num];
        treeSize = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i] = -1;
            treeSize[i] = 1;
        }
    }

    private int find(int p) {
        while (parent[p] >= 0) {
            p = parent[p];
        }
        return p;
    }

    private int sizeAt(int i) {
        int parentIndex = find(i);
        return treeSize[parentIndex];
    }

    private void setSizeAt(int i, int delta) {
        treeSize[i] += delta;
    }
    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j= find(q);
        if (i == j) {
            return;
        }
        int iSize = sizeAt(i);
        int jSize = sizeAt(j);
        if (iSize >= jSize) {
            parent[j] = i;
            setSizeAt(i, jSize);
        } else {
            parent[i] = j;
            setSizeAt(j, iSize);
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        int N = 100;
        int half = N/2;
        DisjointSets finder = new WeightedQuickUnionDS(N);
        for (int i = 0; i < half; i++) {
            finder.connect(i, i+1);
        }

        for (int i = half + 1; i < N-1; i++) {
            finder.connect(i, i+1);
        }

        assert !finder.isConnected(0, half);
        assert !finder.isConnected(half, N-1);
        assert finder.isConnected(0, half);
        assert finder.isConnected(half+1, N-1);
    }
}
