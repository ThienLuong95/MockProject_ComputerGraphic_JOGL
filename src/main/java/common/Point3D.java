package common;

import com.jogamp.opengl.GL2;

public class Point3D {
    private double x, y, z;
    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Point3D() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void increaseX(double x) {
        this.x+=x;
    }
    public void increaseY(double y) {
        this.y+=y;
    }
    public void increaseZ(double z) {
        this.z+=z;
    }
    public void translateTo(GL2 gl2) {
        gl2.glTranslated(this.x, this.y, this.z);
    }
    public static Point3D GetPoint(double x, double y, double z) {
        return new Point3D(x, y, z);
    }
}
