package Voronoi.BeachLine;

public class EdgeNode extends BeachLineNode {

    private BeachLineNode leftChild;
    private BeachLineNode rightChild;

    EdgeNode() {}

    EdgeNode(BeachLineNode leftChild, BeachLineNode rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void setLeftChild(BeachLineNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BeachLineNode rightChild) {
        this.rightChild = rightChild;
    }

    public BeachLineNode getLeftChild() {
        return leftChild;
    }

    public BeachLineNode getRightChild() {
        return rightChild;
    }
}
