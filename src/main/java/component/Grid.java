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
        for (int i = -lineCount; i <= lineCount; i++) {
            if(i == this.position.getX())
            {
                gl.glColor4f(xAxisColor[0], xAxisColor[1], xAxisColor[2], xAxisColor[3]);
            } else  {
                gl.glColor4f(gridColor[0], gridColor[1], gridColor[2], gridColor[3]);
            }
            gl.glVertex3f(-lineCount, i, 0);
            gl.glVertex3f(lineCount, i, 0);
        }
        gl.glEnd();

        //Vertical Lines
        gl.glBegin(GL2.GL_LINES);
        for (int i = -lineCount; i <= lineCount; i++) {
            if(i == this.position.getY())
            {
                gl.glColor4f(yAxisColor[0], yAxisColor[1], yAxisColor[2], yAxisColor[3]);
            }
            else  {
                gl.glColor4f(gridColor[0], gridColor[1], gridColor[2], gridColor[3]);

            }
            gl.glVertex3f(i, -lineCount, 0);
            gl.glVertex3f(i, lineCount, 0);
        }

        gl.glEnd();
        //arrow x
        gl.glColor4f(1f, 0f, 0f, .5f);
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex3f(lineCount, 0, 0);
        gl.glVertex3f(lineCount- .25f, .25f, 0);
        gl.glVertex3f(lineCount- .25f, -.25f, 0);
        gl.glEnd();

        //arrow y
        gl.glColor4f(0f, 1f, 0f, .5f);
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex3f(0, lineCount, 0);
        gl.glVertex3f(.25f, lineCount- .25f, 0);
        gl.glVertex3f(-.25f, lineCount- .25f, 0);
        gl.glEnd();

        gl.glEndList();
        gl.glCallList(1);

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
