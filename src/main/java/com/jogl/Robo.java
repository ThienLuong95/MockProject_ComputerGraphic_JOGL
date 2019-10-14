package com.jogl;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

public class Robo {
    private float x =0 , y = 0, z = 0;
    private GLUT glut = new GLUT();
    public void Display(final GL2 gl) {
        gl.glColor4f(1f, 1f, 1f, .6f);
        DrawBody(gl);
        DrawHead(gl);
    }
    private void DrawBody(final GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslated(x, y, z);
        gl.glScalef( 1f,0.5f,1f );
        glut.glutWireCube(4);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(x, y+3, z);
        gl.glScalef( 1f,1f,1f );
        glut.glutWireCube(4);
        gl.glPopMatrix();
    }
    private void DrawHead(final GL2 gl)
    {
//        gl.glPushMatrix();
//        gl.glTranslated(x, y+5.5, z);
//        gl.glScalef( 1f,0.5f,1f );
//        glut.glutWireCube(2);
//        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(x, y+7, z);
        gl.glScalef( 1f,1f,1f );
        glut.glutWireCube(2);
        gl.glPopMatrix();
    }
}
