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
        double d = u * Math.PI /180;
        double x1 = x;
        x = x1* Math.cos(d) - y* Math.sin(d);
        y = -x1* Math.sin(d) + y* Math.cos(d);
    }

    public void rotateY (double u){
        double d = u * Math.PI /180;
        double x1 = x;
        x = x1* Math.cos(d) + z* Math.sin(d);
        z = -x1* Math.sin(d) + z* Math.cos(d);
    }

    public void rotateX (double u){
        double d = u * Math.PI /180;
        double z1 = z;
        z = z1* Math.cos(d) - y* Math.sin(d);
        y = z1* Math.sin(d) + y* Math.cos(d);
    }

    public void rotate(char k, double u){
        switch (k){
            case 'x':
                rotateX(u);
                break;
            case 'y':
                rotateY(u);
                break;
            case 'z':
                rotateZ(u);
                break;
        }
    }

    public void rotateAll(double u, double v, double t){
        rotateX(u);
        rotateY(v);
        rotateZ(t);
    }
}
