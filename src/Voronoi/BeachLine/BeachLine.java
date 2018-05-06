package Voronoi.BeachLine;

public class BeachLine {

    private final EdgeNode head = new EdgeNode();

    public void setRoot(BeachLineNode root) {
        this.head.setLeftChild(root);
    }

    public BeachLineNode getRoot() {
        return head.getLeftChild();
    }

    boolean isEmpty() {
        return head.getLeftChild() == null;
    }

}
