package com.jogl.sample;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import util.Color;

public class Line implements GLEventListener {
    private GLU glu = new GLU();
    @Override
    public void init(GLAutoDrawable drawable) {

    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glBegin (GL2.GL_LINES);//static field
        gl.glVertex3f(0.50f,-0.50f,.5f);
        gl.glVertex3f(-0.50f,0.50f,.5f);
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
//        GL2 gl = drawable.getGL().getGL2();
//
//        if( height <= 0 )
//            height = 1;
//
//        final float h = ( float ) width / ( float ) height;
//        gl.glViewport( 0, 0, width, height );
//        gl.glMatrixMode( GL2.GL_PROJECTION );
//        gl.glLoadIdentity();
//
////        glu.gluPerspective( 80.0f, h, 1.0, 20.0 );
//        gl.glMatrixMode( GL2.GL_MODELVIEW );
//        gl.glLoadIdentity();
    }
}
