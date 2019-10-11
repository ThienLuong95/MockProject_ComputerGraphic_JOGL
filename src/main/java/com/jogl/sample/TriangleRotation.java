package com.jogl.sample;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class TriangleRotation implements GLEventListener {
    private float rtri;
    @Override
    public void init(GLAutoDrawable drawable) {
        System.out.println("Call init");
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        System.out.println("Call dispose");
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        System.out.println("Call display");
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear (GL2.GL_COLOR_BUFFER_BIT |  GL2.GL_DEPTH_BUFFER_BIT );

        // Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();  // Reset The View

        //triangle rotation
        gl.glRotatef( rtri, 0.0f, 1.0f, 0.0f );

        // Drawing Using Triangles
        gl.glBegin( GL2.GL_TRIANGLES );

        gl.glColor3f( 1.0f, 0.0f, 0.0f );   // Red
        gl.glVertex3f( 0.5f,0.7f,0.0f );    // Top
        gl.glColor3f( 0.0f,1.0f,0.0f );     // blue
        gl.glVertex3f( -0.2f,-0.50f,0.0f ); // Bottom Left
        gl.glColor3f( 0.0f,0.0f,1.0f );     // green
        gl.glVertex3f( 0.5f,-0.5f,0.0f );   // Bottom Right

        gl.glEnd();
        gl.glFlush();

        rtri += 0.5f;  //assigning the angle
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println("Call reshape");
    }
}
