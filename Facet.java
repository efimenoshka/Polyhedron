import java.awt.*;
import java.awt.geom.Path2D;

public class Facet {

    private R3Vector[] vertex;
    private Color color;

    public Facet(R3Vector v1, R3Vector v2 ,R3Vector v3 ,R3Vector v4, Color color){
        vertex = new R3Vector[4];
        vertex[0] = v1;
        vertex[1] = v2;
        vertex[2] = v3;
        vertex[3] = v4;
        this.color = color;
    }

    public void out(){
        for(int i = 0; i < vertex.length; i++) { vertex[i].out(); }
    }

    public void rotate(double ux, double uy, double uz){
        for (int i = 0; i < vertex.length; i++) { vertex[i].rotateAll(ux,uy,uz);}
    }

    public void mash(double m){
        for (int i = 0; i < vertex.length; i++) { vertex[i].coef(m);}
    }

    public void trans(double ux, double uy, double uz){
        for (int i = 0; i < vertex.length; i++) { vertex[i].rotateAll(ux,uy,uz);}
    }

    public void draw(Graphics2D g2d){
        Path2D p = new Path2D.Double();
        p.moveTo(vertex[0].getX(), vertex[0].getY());
        p.lineTo(vertex[1].getX(), vertex[1].getY());
        p.lineTo(vertex[2].getX(), vertex[2].getY());
        p.lineTo(vertex[3].getX(), vertex[3].getY());
        p.lineTo(vertex[0].getX(), vertex[0].getY());
        p.closePath();
        g2d.setColor(Color.red);
        g2d.setColor(color);
        g2d.draw(p);
        g2d.fill(p);
    }



}
