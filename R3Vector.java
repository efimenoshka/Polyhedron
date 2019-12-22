//радиус-вектор
public class R3Vector {
    private double x, y, z;

    public R3Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }

    public void out(){
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }

    public R3Vector sum(R3Vector a){
        // System.out.println("(" + a.x + x + ", " + a.y + y +", " + a.z + z + ")");
        return new R3Vector(x +a.x, y + a.y, z + a.z);
    }

    public static R3Vector sum(R3Vector a, R3Vector b){
        return new R3Vector(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    public void coef(double k){
        this.x *= k;
        this.y *= k;
        this.z *= k;
    }

    public void offset(double dx, double dy, double dz){
        this.x += dx;
        this.y += dy;
        this.z += dz;
    }

    public void Scal(R3Vector i){
        double c = (i.x * x + i.y * y + i.z * z);
        System.out.println(c);
    }

    public static R3Vector Vect(R3Vector a,R3Vector b){
        return new R3Vector(a.y * b.z - a.z * b.y, a.z * b.x - a.x * b.z, a.x * b.y - a.y * b.x);
    }

    public void rotateZ (double u){
        double rad = u * Math.PI /180;
        double x1 = x; double y1 = y;
        x = x1 * Math.cos(rad) + y1 * Math.sin(rad);
        y = y1 * Math.cos(rad) - x1 * Math.sin(rad);
    }

    public void rotateY (double u){
        double rad = u * Math.PI /180;
        double x1 = x; double z1 = z;
        x = x1 * Math.cos(rad) + z1 * Math.sin(rad);
        z = z1 * Math.cos(rad) - x1 * Math.sin(rad);
    }

    public void rotateX (double u){
        double rad = u * Math.PI /180;
        double y1 = y; double z1 = z;
        y = y1 * Math.cos(rad) + z1 * Math.sin(rad);
        z = z1 * Math.cos(rad) - y1 * Math.sin(rad);
    }

    public void rotateAll(double u, double v, double t){
        rotateX(u);
        rotateY(v);
        rotateZ(t);
    }

    public static R3Vector toVec(R3Vector v1, R3Vector v2){
        return new R3Vector(v2.x - v1.x, v2.y-v1.y, v2.z-v1.z);
    }
}
