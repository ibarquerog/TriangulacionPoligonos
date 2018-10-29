package triangulation;
        
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class View extends JPanel {

    private Polygon polygon = new Polygon();
    
    public ArrayList<Point> points = new ArrayList<>();
    public ArrayList<Polygon> triangles = new ArrayList<>();
    
    private Stroke stroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    private Color color = new Color(245,0,87,64);
    private BufferedImage image;
    
    public View() {
        super.setSize(650,650);
        this.setBackground(new java.awt.Color(255,224,130));
        this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 3, true));
        this.setVisible(true);
        this.setLocation(10,10);
        this.requestFocus();
        
        MouseHandler mouseHandler = new MouseHandler();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }
    
    public View(BufferedImage img) {
        
        super.setSize(img.getWidth()+100,100+img.getHeight()); //To change body of generated methods, choose Tools | Templates.
        image = img;
        this.setBackground(new java.awt.Color(255,255,255));
        this.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 3, true));
        this.setVisible(true);
        this.setLocation(10,10);
        this.requestFocus();
        super.repaint();
        MouseHandler mouseHandler = new MouseHandler();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if(image ==null){
            super.paintComponent(g);
            drawPolygon((Graphics2D) g);
            drawTriangles((Graphics2D) g);
        }else{
            super.paintComponent(g);
            g.drawImage(this.image, 50, 50,image.getWidth(),image.getHeight(), null);
            drawPolygon((Graphics2D) g);
            drawTriangles((Graphics2D) g); 
        } 
    }
    
    private void drawPolygon(Graphics2D g) {
        g.setStroke(stroke);
        for (int p = 0; p < points.size(); p++) {
            Point p1 = points.get(p % points.size());
            Point p2 = points.get((p + 1) % points.size());
            g.setColor(Color.BLUE);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
            
        }
    }
    
    private void drawTriangles(Graphics2D g) {
        g.setStroke(stroke);
        for (Polygon triangle : triangles) {
            g.setColor(color);
            g.fillPolygon(triangle);
            g.setColor(Color.BLUE);
            g.drawPolygon(triangle);
        }
    }
    
    public void update(){
        this.repaint();
    }
    
    public void generatePoints(int qPoints){
        
        ArrayList<Pair<Integer,Integer>> taken= new ArrayList<>();
        Random r = new Random();
        int x,y;

        for(int i=0;i<qPoints;i++){
            x = r.nextInt(this.getWidth());
            y = r.nextInt(this.getHeight());
            
            if(checkTakenPositions(x,y,taken)){//Coordinates already take if true
                qPoints++;
            }else{
                if(points.size() >=3){
                    //triangulatePolygon();
                    Pair<Integer,Integer> newCoord = new Pair<>(x,y);
                    taken.add(newCoord);
                    Point newPoint = new Point(x,y);
                    points.add(newPoint);
                System.out.println("Added a new point at: "+newPoint.getX()+","+newPoint.getY()+" Total points: "+String.valueOf(points.size()));
                this.repaint();
                
                }else{
                    Pair<Integer,Integer> newCoord = new Pair<>(x,y);
                    taken.add(newCoord);
                    Point newPoint = new Point(x,y);
                    points.add(newPoint);
                    System.out.println("Added a new point at: "+newPoint.getX()+","+newPoint.getY()+" Total points: "+String.valueOf(points.size()));
                    this.repaint();
                }
            }
        }
        //triangulatePolygon(); 
    }
    
    public boolean checkTakenPositions(int x,int y,ArrayList<Pair<Integer,Integer>> taken){
        for(int i=0;i< taken.size();i++){
            if(taken.get(i).getKey().equals(x) && taken.get(i).getValue().equals(y)){
                return true;
            }
        }
        return false;
    }
    
    public void triangulatePolygon() {
      
        long start = System.currentTimeMillis(); 
        boolean clockwise = isClockwise(points);
        int index = 0;
        if (points.size() < 3) {
            points.clear();
        }else{
            while (points.size() > 2) {

                Point p1 = points.get((index + 0) % points.size());
                Point p2 = points.get((index + 1) % points.size());
                Point p3 = points.get((index + 2) % points.size());

                Vector v1 = new Vector(p2.x - p1.x, p2.y - p1.y);
                Vector v2 = new Vector(p3.x - p1.x, p3.y - p1.y);
                double cross = v1.cross(v2);
                //System.out.println("Cross:"+String.valueOf(cross));
                Polygon triangle = new Polygon();
                triangle.addPoint(p1.x, p1.y);
                triangle.addPoint(p2.x, p2.y);
                triangle.addPoint(p3.x, p3.y);

                if (!clockwise && cross >= 0 && validTriangle(triangle, p1, p2, p3, points)) {
                    points.remove(p2);
                    triangles.add(triangle);
                }
                else if (clockwise && cross <= 0 && validTriangle(triangle, p1, p2, p3, points)) {
                    points.remove(p2);
                    triangles.add(triangle);
                }
                else {
                    index++;
                }
            }
        }
        long end = System.currentTimeMillis();
            long time = end-start;
            long minutes = (time / 1000)  / 60;
            long seconds = (time / 1000) % 60;
            long milli = time - (seconds * 1000) - (minutes * 60000);
            String report = "Time taken: " + minutes + " min " + seconds + " sec " + milli +" ms" ;
            JOptionPane.showMessageDialog(null,report);
    }
    
    public boolean validTriangle(Polygon triangle, Point p1, Point p2, Point p3,ArrayList<Point> points) {
        return points.stream().noneMatch((p) -> (p != p1 && p != p2 && p != p3 && triangle.contains(p)));
    }
   
    public boolean isClockwise(ArrayList<Point> points) {
        int sum = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            sum += (p2.x - p1.x) * (p2.y + p1.y);
        }
        return sum >= 0;
    } 
    class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                Point newPoint = new Point(e.getX(),e.getY());
                points.add(newPoint);
                System.out.println("Added a new point at: "+newPoint.getX()+","+newPoint.getY()+" Total points: "+String.valueOf(points.size()));  
            }
            else if (SwingUtilities.isRightMouseButton(e)) {
                System.out.println("Triangulating...");
                triangulatePolygon();
            }
            else if (SwingUtilities.isMiddleMouseButton(e)) {
                triangles.clear();
            }
            repaint();
        }
        
    }

}
