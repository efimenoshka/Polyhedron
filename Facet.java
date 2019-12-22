import java.awt.*;
import java.awt.geom.Path2D;

public class Facet {

    private R3Vector[] vertex;
    private Color color;

    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4, Color color){
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
        for (int i = 0; i < vertex.length; i++) { vertex[i].offset(ux,uy,uz);}
    }

    public R3Vector normal(){
        return R3Vector.Vect(R3Vector.toVec(vertex[0],vertex[1]), R3Vector.toVec(vertex[0],vertex[3]));
    }

    public boolean light(){
        if (normal().getZ() > 0) {
            return false;
        }
        else return true;
    }

    public void draw(Graphics2D g2d){
        Path2D p = new Path2D.Double();
        p.moveTo(vertex[0].getX(), vertex[0].getY());
        p.lineTo(vertex[1].getX(), vertex[1].getY());
        p.lineTo(vertex[2].getX(), vertex[2].getY());
        p.lineTo(vertex[3].getX(), vertex[3].getY());
        p.lineTo(vertex[0].getX(), vertex[0].getY());
        p.closePath();
        if (light() == true) {
            g2d.setColor(color);
            g2d.fill(p);
            g2d.setColor(Color.black);
            g2d.draw(p);
        }
    }

    public void Persdraw(Graphics2D g2d, int t){
        Path2D p = new Path2D.Double();
        double k[] = new double[4];
        R3Vector[] v = new R3Vector[4];
        for (int i = 0; i < 4; i++){
            k[i] = -t/(vertex[i].getZ()-t);
            v[i] = new R3Vector(vertex[i].getX() * k[i], vertex[i].getY() * k[i], vertex[i].getZ()*k[i]);
        }
        p.moveTo(v[0].getX(), v[0].getY());
        p.lineTo(v[1].getX(), v[1].getY());
        p.lineTo(v[2].getX(), v[2].getY());
        p.lineTo(v[3].getX(), v[3].getY());
        p.lineTo(v[0].getX(), v[0].getY());
        p.closePath();
        Facet f = new Facet(v[0],v[1],v[2],v[3],Color.black);

        if (f.light() == true) {
            g2d.setColor(color);
            g2d.fill(p);
            g2d.setColor(Color.black);
            g2d.draw(p);
        }
    }

}
