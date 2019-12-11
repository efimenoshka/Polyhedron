public class Main {

    public static void main(String[] args) {
        R3Vector a = new R3Vector(10,0,0);
        R3Vector b = new R3Vector(0,0,10);
        /*a.sum(b).out();
        R3Vector.sum(a,a).out();
        a.coef(5);
        a.out();
        a.offset(20,0,0);
        a.out();
        a.Scal(b);
        (R3Vector.Vect(b,a)).out();
        a.rotate('y',90);
        a.out();
        a.rotateAll(90,90,90);
        a.out();

        System.out.println("-------------");

        Facet f = new Facet(new R3Vector(0,0,0), new R3Vector(0,1,0), new R3Vector(1,1,0), new R3Vector(1,0,0));
        f.out();

        System.out.println("");

        f.rotate(360,360,360);
        f.out();

        System.out.println("");

        f.mash(6);
        f.out();
        f.trans(2,2,2);
        f.out();*/

        System.out.println("-------------");

        Cube c = new Cube();
        c.mashCu(100);
        c.transCu(30,30,0);

        System.out.println("-------------");

        Viewer v = new Viewer(c);







    }
}
