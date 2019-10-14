package com.jogl;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import util.Color;

public class Grid implements GLEventListener {
    private int lineCount =10;
    private GLU glu = new GLU();
    private Robo robo = new Robo();
    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glShadeModel( GL2.GL_FLAT );
        gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
        gl.glClearColor( 0f, 0f, 0f, 1f );
        gl.glClearDepth(1.0f);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glPushMatrix();
        gl.glTranslated(0, 0, 0);

        gl.glNewList(1, GL2.GL_COMPILE);
        //Horizontal Lines
        gl.glBegin(GL2.GL_LINES);
        for (int i = -lineCount; i <= lineCount; i++) {
            if(i == 0)
            {
                gl.glColor4f(1f, 0f, 0f, .5f);
            } else  {
                gl.glColor4f(1f, 1f, 1f, .2f);
            }
            gl.glVertex3f(-lineCount, i, 0);
            gl.glVertex3f(lineCount, i, 0);
        }
        gl.glEnd();

        //Vertical Lines
        gl.glBegin(GL2.GL_LINES);
        for (int i = -lineCount; i <= lineCount; i++) {
            if(i == 0)
            {
                gl.glColor4f(0f, 1f, 0f, .5f);
            }
            else  {
                gl.glColor4f(1f, 1f, 1f, .2f);
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

        robo.Display(gl);
        gl.glPopMatrix();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL2 gl = drawable.getGL().getGL2();
        if( height <= 0 )
            height = 1;

        final float h = ( float ) width / ( float ) height;
        gl.glViewport( 0, 0, width, height );
        gl.glMatrixMode( GL2.GL_PROJECTION );
        gl.glLoadIdentity();

        glu.gluPerspective( 60.0f, h, 1.0, 20.0 );
        glu.gluOrtho2D(20, 20, 20, 20);
        gl.glMatrixMode( GL2.GL_MODELVIEW );
        gl.glLoadIdentity();
        glu.gluLookAt(0, 0, 20, 0, 0, 0, 0, 1, 0);
    }

    private void Draw() {

    }
}
