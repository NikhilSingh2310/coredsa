package util;

public class Tree {
    private int data;
    Tree left;
    Tree right;

    public Tree(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    public Tree() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
