package tutorial.keyboardmouse;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.gl2.GLUgl2;
import com.jogamp.opengl.util.Animator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class KeyBoardAndMouseSample implements GLEventListener, KeyListener, MouseListener {
    private Game game;
    private static Point center;
    private Point mousePos;
    private static boolean fullscreen = false;
    private int w=1024;
    private int h=768;

    private int forward= KeyEvent.VK_W;
    private int backward=KeyEvent.VK_S;
    private int strafel=KeyEvent.VK_A;
    private int strafer=KeyEvent.VK_D;
    private int shoot= InputEvent.BUTTON1_MASK;
    private int use=InputEvent.BUTTON3_MASK;
    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        game=new Game(gl);
        game.setMouseCenter(center);
        mousePos=center;
        GLU glu=new GLU();
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(gl.GL_PROJECTION);
        glu.gluPerspective(45.0f, ((float)w/(float)h), 0.1f, 100.0f);
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glShadeModel(gl.GL_SMOOTH);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(gl.GL_DEPTH_TEST);
        gl.glDepthFunc(gl.GL_LEQUAL);
        gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT, gl.GL_NICEST);

    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        game.tick();
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        GLU glu = new GLU();
        if (height <= 0) { height = 1; }
        final float h=(float)width/(float)height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        center=new Point(x+width/2, y+height/2);

        game.setMouseCenter(center);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("JOGL Events");
        Toolkit t=Toolkit.getDefaultToolkit();
        Image img=new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Cursor pointer=t.createCustomCursor(img, new Point(0,0), "none");
        GLCanvas canvas = new GLCanvas();
        KeyBoardAndMouseSample sample= new KeyBoardAndMouseSample();
        canvas.addGLEventListener(sample);
        canvas.addKeyListener(sample);
        canvas.addMouseListener(sample);
        canvas.setFocusable(true);
        canvas.requestFocus();
        frame.add(canvas);
        frame.setUndecorated(true);
        frame.setSize(1024, 768);
        frame.setLocationRelativeTo(null);
        frame.setCursor(pointer);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        if(fullscreen){
            ge.getDefaultScreenDevice().setFullScreenWindow(frame);
        }

        final Animator animator = new Animator(canvas);
        animator.setRunAsFastAsPossible(true);
        animator.start();
        Rectangle r=frame.getBounds();
        center=new Point(r.x+r.width/2, r.y+r.height/2);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            new Thread(new Runnable(){
                public void run(){
                    System.exit(0);
                }
            }).start();
        }
        if(e.getKeyCode()==forward)game.setFord(true);
        if(e.getKeyCode()==backward)game.setBack(true);
        if(e.getKeyCode()==strafel)game.setStrafel(true);
        if(e.getKeyCode()==strafer)game.setStrafer(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==forward)game.setFord(true);
        if(e.getKeyCode()==backward)game.setBack(true);
        if(e.getKeyCode()==strafel)game.setStrafel(true);
        if(e.getKeyCode()==strafer)game.setStrafer(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==forward)game.setFord(false);
        if(e.getKeyCode()==backward)game.setBack(false);
        if(e.getKeyCode()==strafel)game.setStrafel(false);
        if(e.getKeyCode()==strafer)game.setStrafer(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if((e.getModifiers() & shoot)!=0)
            game.setShoot();
        if((e.getModifiers() & use)!=0)
            game.setUse();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
