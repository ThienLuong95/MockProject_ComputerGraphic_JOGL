package tutorial.sgame;

import com.jogamp.opengl.GL2;

import java.awt.*;

public class Game {
    Player player;
    private Floor floor;
    private GL2 gl;
    private Point mouseCenter;
    private Robot robot;
    private float dx, dy;
    private final float headSens=0.02f;
    private final float pitchSens=0.01f;
    private boolean ford = false;
    private boolean back = false;
    private boolean strafel = false;
    private boolean strafer = false;
    private long lastTime;

    private int shoot = 0;
    private int use = 0;

    public Game(GL2 gl) {
        this.gl = gl;
        player=new Player();
        floor = new Floor();
        Robot r= null;
        try {
            r = new Robot();
        }
        catch ( final  AWTException e) {
            System.out.println("Trouble staring robot");
        }
        this.robot = r;
        if (robot == null) System.out.println("Error Robot has not been initialized");
    }
    public void tick() {
        pollEvent();
//        robot.mouseMove(mouseCenter.x, mouseCenter.y);
//        if(robot!=null)
//            robot.mouseMove(mouseCenter.x, mouseCenter.y);
        shoot = 0;
        use = 0;
        player.draw(gl);
        floor.draw(gl);

//        gl.glTranslatef(-1.5f, 0.0f, -6.0f);
//
//        gl.glBegin(GL.GL_TRIANGLES);
//        gl.glColor3f(1.0f, 0.0f, 0.0f);
//        gl.glVertex3f(0.0f, 1.0f, 0.0f);
//        gl.glColor3f(0.0f, 1.0f, 0.0f);
//        gl.glVertex3f(-1.0f, -1.0f, 0.0f);
//        gl.glColor3f(0.0f, 0.0f, 1.0f);
//        gl.glVertex3f(1.0f, -1.0f, 0.0f);
//        gl.glEnd();
//
//        gl.glTranslatef(3.0f, 0.0f, 0.0f);
//
//        gl.glBegin(GL2.GL_QUADS);
//        gl.glColor3f(0.5f, 0.5f, 1.0f);
//        gl.glVertex3f(-1.0f, 1.0f, 0.0f);
//        gl.glVertex3f(1.0f, 1.0f, 0.0f);
//        gl.glVertex3f(1.0f, -1.0f, 0.0f);
//        gl.glVertex3f(-1.0f, -1.0f, 0.0f);
//        gl.glEnd();

    }
    private void pollEvent() {
        long now=System.nanoTime();
        float period=(float)((now-lastTime)*0.000005);
        lastTime=now;
        dx= MouseInfo.getPointerInfo().getLocation().x;
        dy= MouseInfo.getPointerInfo().getLocation().y;
        float head=mouseCenter.x-dx;
        float pit=mouseCenter.y-dy;

//        if ((mouseCenter.x-dx)!=0) System.out.println("Changing heading" + (mouseCenter.x - dx));
//        if ((mouseCenter.y-dy)!=0) System.out.println("Changing heading" + (mouseCenter.y - dy));

        if(head!=0) player.setHeading(head*headSens);
        if(pit!=0) player.setPitch(pit*pitchSens);
        if(ford) player.setFord((float)period);
        if(back) player.setBack((float)period);
        if(strafel) player.setStrafel((float)period);
        if(strafer) player.setStrafer((float)period);
        if (shoot > 0) System.out.println("player has shot");
        if (use > 0) System.out.println("player has used");
        player.set();
    }
    public void setShoot(){
        shoot++;
    }
    public void setUse(){
        use++;
    }

    public void setFord(boolean ford) {
        this.ford = ford;
    }

    public void setBack(boolean back) {
        this.back = back;
    }

    public void setStrafel(boolean strafel) {
        this.strafel = strafel;
    }

    public void setStrafer(boolean strafer) {
        this.strafer = strafer;
    }

    public void setShoot(int shoot) {
        this.shoot = shoot;
    }

    public void setUse(int use) {
        this.use = use;
    }

    public void setMouseCenter(Point mouseCenter) {
        this.mouseCenter = mouseCenter;
    }
}
