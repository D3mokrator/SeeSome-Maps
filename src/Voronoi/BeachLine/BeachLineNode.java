package Voronoi.BeachLine;

public abstract class BeachLineNode {
    private BeachLineNode parent;

    public void setParent(BeachLineNode perent) {
        this.parent = perent;
    }

    public BeachLineNode getParent() {
        return parent;
    }
}
