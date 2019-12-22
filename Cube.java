import java.awt.*;

public class Cube {

    private Facet[] facets;

    public Cube(){
        facets = new Facet[6];
        facets[0] = new Facet(new R3Vector(0,0,0), new R3Vector(1,0,0) ,new R3Vector(1,1,0) ,new R3Vector(0,1,0), Color.blue);
        facets[1] = new Facet(new R3Vector(1,0,1), new R3Vector(1,1,1) ,new R3Vector(1,1,0) ,new R3Vector(1,0,0), Color.red);
        facets[2] = new Facet(new R3Vector(0,0,0), new R3Vector(0,1,0) ,new R3Vector(0,1,1) ,new R3Vector(0,0,1), Color.YELLOW);
        facets[3] = new Facet(new R3Vector(0,0,0), new R3Vector(0,0,1) ,new R3Vector(1,0,1) ,new R3Vector(1,0,0), Color.CYAN);
        facets[4] = new Facet(new R3Vector(0,1,0), new R3Vector(1,1,0) ,new R3Vector(1,1,1) ,new R3Vector(0,1,1), Color.GREEN);
        facets[5] = new Facet(new R3Vector(0,0,1), new R3Vector(0,1,1) ,new R3Vector(1,1,1) ,new R3Vector(1,0,1), Color.MAGENTA);

    }

    public void outCu(){
        for(int i = 0; i < facets.length; i++) { facets[i].out(); }
    }

    public void rotateCu(double ux, double uy, double uz){
        for (int i = 0; i < facets.length; i++) { facets[i].rotate(ux,uy,uz);}
    }

    public void mashCu(double l){
        for (int i = 0; i < facets.length; i++) { facets[i].mash(l);}
    }

    public void transCu(double ux, double uy, double uz){
        for (int i = 0; i < facets.length; i++) { facets[i].trans(ux,uy,uz);}
    }

    public void draw(Graphics2D g){
        for (int i = 0; i < facets.length; i++) { facets[i].draw(g);}
    }

    public void Persdraw(Graphics2D g, int t){ for (int i = 0; i < facets.length; i++) { facets[i].Persdraw(g, t);}}
}
