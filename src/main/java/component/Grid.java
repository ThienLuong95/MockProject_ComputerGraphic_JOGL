package component;

import com.jogamp.opengl.GL2;
import common.Point3D;
import util.Color;

public class Grid implements IDisplayable {
    private Point3D position;
    private int lineCount;
    private float[] gridColor, xAxisColor, yAxisColor, zAxisColor;

    public Grid(Point3D position, int length) {
        this.position = position;
        this.lineCount = length;
        initColor();
    }
    private void initColor() {
        gridColor = Color.COLOR_GREY;
        xAxisColor = Color.COLOR_RED;
        yAxisColor = Color.COLOR_GREEN;
        zAxisColor = Color.COLOR_BLUE;
    }

    @Override
    public void Display(final GL2 gl) {
        gl.glPushMatrix();
        this.position.translateTo(gl);
        gl.glNewList(1, GL2.GL_COMPILE);
        //Horizontal Lines
        gl.glBegin(GL2.GL_LINES);
        for (double i = -lineCount+position.getX(); i <= lineCount+position.getX(); i++) {
            if(i == this.position.getX())
            {
                gl.glColor4f(xAxisColor[0], xAxisColor[1], xAxisColor[2], xAxisColor[3]);
            } else  {
                gl.glColor4f(gridColor[0], gridColor[1], gridColor[2], gridColor[3]);
            }
            gl.glVertex3d(-lineCount+position.getX(), i, 0);
            gl.glVertex3d(lineCount+position.getX(), i, 0);
        }
        gl.glEnd();

        //Vertical Lines
        gl.glBegin(GL2.GL_LINES);
        for (double i = -lineCount+position.getY(); i <= lineCount+position.getY(); i++) {
            if(i == this.position.getY())
            {
                gl.glColor4f(yAxisColor[0], yAxisColor[1], yAxisColor[2], yAxisColor[3]);
            }
            else  {
                gl.glColor4f(gridColor[0], gridColor[1], gridColor[2], gridColor[3]);

            }
            gl.glVertex3d(i, -lineCount+position.getY(), 0);
            gl.glVertex3d(i, lineCount+position.getY(), 0);
        }
        // Depth Line
        for (double i = -lineCount+position.getZ(); i <= lineCount+position.getZ(); i++) {
            if(i == this.position.getY())
            {
                gl.glColor4f(zAxisColor[0], zAxisColor[1], zAxisColor[2], zAxisColor[3]);
            }
            else  {
                gl.glColor4f(gridColor[0], gridColor[1], gridColor[2], gridColor[3]);

            }
            gl.glVertex3d(0, i, -lineCount+position.getZ());
            gl.glVertex3d(0, i, lineCount+position.getZ());
        }

        gl.glEnd();
        //arrow x
        gl.glColor4f(xAxisColor[0], xAxisColor[1], xAxisColor[2], xAxisColor[3]);
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex3d(lineCount+position.getX(), position.getY(), 0);
        gl.glVertex3d(lineCount+position.getX()- .25f, position.getY()+.25f, 0);
        gl.glVertex3d(lineCount+position.getX()- .25f, position.getY()-.25f, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex3d(3+position.getX(), position.getY(), 0);
        gl.glVertex3d(3+position.getX()- .25f, position.getY()+.25f, 0);
        gl.glVertex3d(3+position.getX()- .25f, position.getY()-.25f, 0);
        gl.glEnd();

        //arrow y
        gl.glColor4f(yAxisColor[0], yAxisColor[1], yAxisColor[2], yAxisColor[3]);
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex3d(position.getX(),lineCount +position.getY(), 0);
        gl.glVertex3d(position.getX()+.25f, lineCount +position.getY()- .25f, 0);
        gl.glVertex3d(position.getX()-.25f, lineCount +position.getY()- .25f, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex3d(position.getX(),3 +position.getY(), 0);
        gl.glVertex3d(position.getX()+.25f, 3 +position.getY()- .25f, 0);
        gl.glVertex3d(position.getX()-.25f, 3 +position.getY()- .25f, 0);
        gl.glEnd();

        //arrow z
        gl.glColor4f(zAxisColor[0], zAxisColor[1], zAxisColor[2], zAxisColor[3]);
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex3d(0, position.getY(),lineCount+ position.getZ());
        gl.glVertex3d(0, position.getY()+.25f, lineCount +position.getZ()- .25f);
        gl.glVertex3d(0, position.getY()-.25f, lineCount +position.getZ()- .25f);
        gl.glEnd();

        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex3d(0, position.getY(),3 +position.getZ());
        gl.glVertex3d(0, position.getY()+.25f, 3 +position.getZ()- .25f);
        gl.glVertex3d(0, position.getY()-.25f, 3 +position.getZ()- .25f);
        gl.glEnd();


        gl.glEndList();
        gl.glCallList(1);
        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glPopMatrix();
    }

    public float[] getGridColor() {
        return gridColor;
    }

    public void setGridColor(float[] gridColor) {
        this.gridColor = gridColor;
    }

    public float[] getxAxisColor() {
        return xAxisColor;
    }

    public void setxAxisColor(float[] xAxisColor) {
        this.xAxisColor = xAxisColor;
    }

    public float[] getyAxisColor() {
        return yAxisColor;
    }

    public void setyAxisColor(float[] yAxisColor) {
        this.yAxisColor = yAxisColor;
    }

    public float[] getzAxisColor() {
        return zAxisColor;
    }

    public void setzAxisColor(float[] zAxisColor) {
        this.zAxisColor = zAxisColor;
    }

    public Point3D getPosition() {
        return position;
    }

    public void setPosition(Point3D position) {
        this.position = position;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }
}
