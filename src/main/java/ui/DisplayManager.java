package ui;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import common.Point3D;
import component.Grid;
import component.Robot;
import component.Room;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DisplayManager implements GLEventListener, KeyListener {
        private int w=1024;
        private int h=768;
        private GLU glu;
        private Grid grid;
        private int lineCount= 10;
        private Robot robot;
        private Room room;

        private float ex=0,ey=0,ez=20;
        public DisplayManager() {
            glu =  new GLU();
            grid = new Grid(new Point3D(0f,0f, 0f), lineCount);
            robot = new Robot(new Point3D(0f, 0f, 0f));
            room = new Room();
        }
    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(gl.GL_PROJECTION);
        glu.gluPerspective(60.0f, ((float)w/(float)h), 1f, 20.0f);
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glShadeModel(gl.GL_SMOOTH);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(gl.GL_DEPTH_TEST);
        gl.glDepthFunc(gl.GL_LEQUAL);
        gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT, gl.GL_NICEST);
        gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
        room.Init(gl);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        glu =  null;
        grid = null;
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glLoadIdentity();
        glu.gluLookAt(ex, ey, ez, 0, 0, 0, 0, 1, 0);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        room.Display(gl);
//        grid.Display(gl);
//        robot.Display(gl);
        gl.glFlush();
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
        gl.glMatrixMode( GL2.GL_MODELVIEW );
        gl.glLoadIdentity();
        glu.gluLookAt(ex, ey, ez, 0, 0, 0, 0, 1, 0);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Q : robot.LeftShoulderUp(); break;
            case KeyEvent.VK_A : robot.LeftShoulderDown(); break;
            case KeyEvent.VK_W : robot.LeftElbowUp(); break;
            case KeyEvent.VK_S : robot.LeftElbowDown(); break;
            case KeyEvent.VK_E : robot.RightShoulderUp(); break;
            case KeyEvent.VK_D : robot.RightShoulderDown(); break;
            case KeyEvent.VK_R : robot.RightElbowUp(); break;
            case KeyEvent.VK_F : robot.RightElbowDown(); break;

            case KeyEvent.VK_T : robot.LeftHipUp(); break;
            case KeyEvent.VK_G : robot.LeftHipDown(); break;
            case KeyEvent.VK_Y : robot.LeftKneeUp(); break;
            case KeyEvent.VK_H : robot.LeftKneeDown(); break;
            case KeyEvent.VK_U : robot.RightHipUp(); break;
            case KeyEvent.VK_J : robot.RightHipDown(); break;
            case KeyEvent.VK_I : robot.RightKneeUp(); break;
            case KeyEvent.VK_K : robot.RightKneeDown(); break;

            case KeyEvent.VK_Z : ex++; break;
            case KeyEvent.VK_X: ey++; break;
            case KeyEvent.VK_C : ez++; break;
            case KeyEvent.VK_V : ex--; break;
            case KeyEvent.VK_B: ey--; break;
            case KeyEvent.VK_N : ez--; break;
            default: break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
