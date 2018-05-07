import Voronoi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

class drawingPanel extends JPanel {
    private ArrayList<Polygon> polygons;

    public drawingPanel() {
        polygons = new ArrayList<>();
    }

    public boolean addPolygon(Polygon poly) {
        return polygons.add(poly);
    }

    public boolean addAllPolygons(Collection<? extends Polygon> polys) {
        return polygons.addAll(polys);
    }

    public boolean removePolygon(Polygon poly) {
        return polygons.remove(poly);
    }

    public void clearPolygons() {
        polygons.clear();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setStroke(new BasicStroke(3));
        for(Polygon p : polygons) {
            int height = ThreadLocalRandom.current().nextInt(-63,200);

            g.setColor(new Color(Tool.heightToColor(height)));
            g.fillPolygon(p);
            g.setColor(Color.black);
            g.drawPolygon(p);
        }
    }
}

class mapDrawing extends JFrame implements ActionListener {
    public drawingPanel panel;

    public mapDrawing() {
        setTitle("Test Drawing");
        setSize(900,950);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Button generateButton = new Button("Generate");
        generateButton.addActionListener(this);
        add(generateButton, BorderLayout.PAGE_START);

        panel = new drawingPanel();
        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        panel.clearPolygons();
        Tool.fillPanelSqr(this);
        repaint();
    }
}

class Tool {
    static int heightToColor(int height) {
        if(height < 0) return height*2+256;
        if(height == 0) return 256*32;
        if(height < 100) return (height+32)*256;
        if(height < 150) return (height+32)*256+(height+32)*256*256;
        return (height+32)*256*256;
    }

    static void fillPanelRandom(mapDrawing frame) {
        for(int i = 0, polyCount = ThreadLocalRandom.current().nextInt(1,13); i < polyCount; i++) {
            Polygon poly = new Polygon();
            for(int j = 0, vertex = ThreadLocalRandom.current().nextInt(3,4); j < vertex; j++) {
                poly.addPoint(ThreadLocalRandom.current().nextInt(0,900),ThreadLocalRandom.current().nextInt(0,900));
                frame.panel.addPolygon(poly);
            }
        }
    }
    static void fillPanelSqr(mapDrawing frame) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                Polygon poly = new Polygon();
                poly.addPoint(100*i,100*j);
                poly.addPoint(100*(i+1),100*j);
                poly.addPoint(100*(i+1),100*(j+1));
                poly.addPoint(100*i,100*(j+1));
                frame.panel.addPolygon(poly);
            }
        }
    }

}

public class Map {
    private ArrayList<SimplePoint> pointList;
    private Voronoi vor;

    public Map() {
        pointList = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            pointList.add(new SimplePoint(ThreadLocalRandom.current().nextInt(0,900), ThreadLocalRandom.current().nextInt(0,900)));
        }

        vor = new Voronoi(pointList);
    }

    static public void main(String[] args) {
        mapDrawing main = new mapDrawing();
        Tool.fillPanelSqr(main);
    }
}
