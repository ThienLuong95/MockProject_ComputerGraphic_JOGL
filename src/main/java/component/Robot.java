package component;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;
import common.Point3D;
import util.Color;

public class Robot implements IDisplayable{
    private Point3D position;
    private GL2 gl2;
    private GLUT glut;
    private float[] bodyColor = Color.COLOR_WHITE;
    private float[] headColor = Color.COLOR_WHITE;
    private float[] legColor = Color.COLOR_WHITE;
    private float[] handColor = Color.COLOR_WHITE;
    @Override
    public void Display(GL2 gl2) {
        this.gl2 = gl2;
        DrawHead();
        DrawBody();
        DrawLefHand();
        DrawRightHand();
        DrawLeftLeg();
        DrawRightLeg();
    }
    public Robot( Point3D position) {
        this.position = position;
        this.glut = new GLUT();
    }
    private void DrawHead() {
        gl2.glColor4f(headColor[0], headColor[1], headColor[2], headColor[3]);

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX(), position.getY()+2, position.getZ());
        glut.glutWireCube(1);
        gl2.glPopMatrix();
    }
    private void DrawBody() {
        gl2.glColor4f(bodyColor[0], bodyColor[1], bodyColor[2], bodyColor[3]);

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX(), position.getY(), position.getZ());
        glut.glutWireCube(2);
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX(), position.getY() -1.5, position.getZ());
        gl2.glScalef(1, 0.4f, 1);
        glut.glutWireCube(2);
        gl2.glPopMatrix();

    }

    private void DrawLefHand() {
        gl2.glColor4f(bodyColor[0], bodyColor[1], bodyColor[2], bodyColor[3]);

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX()-1.9f, position.getY()+0.6f, position.getZ());
        gl2.glScalef(.75f, .35f, 1);
        glut.glutWireCube(2);

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX()-1.9f, position.getY(), position.getZ());
        glut.glutWireCube(2);

        gl2.glPopMatrix();
        gl2.glPopMatrix();
    }

    private  void DrawRightHand() {
        gl2.glColor4f(bodyColor[0], bodyColor[1], bodyColor[2], bodyColor[3]);

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX()+1.9f, position.getY()+0.6f, position.getZ());
        gl2.glScalef(.75f, .35f, 1);
        glut.glutWireCube(2);

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX()+1.9f, position.getY(), position.getZ());
        glut.glutWireCube(2);

        gl2.glPopMatrix();
        gl2.glPopMatrix();
    }

    private void DrawLeftLeg() {
        gl2.glColor4f(legColor[0], legColor[1], legColor[2], legColor[3]);

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX() -.5f, position.getY() -3, position.getZ());
        gl2.glScalef(.35f, 1f, 1);
        glut.glutWireCube(2);

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX(), position.getY() -2, position.getZ());
        glut.glutWireCube(2);
        gl2.glPopMatrix();
        gl2.glPopMatrix();
    }

    private void DrawRightLeg() {
        gl2.glColor4f(legColor[0], legColor[1], legColor[2], legColor[3]);

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX() +.5f, position.getY() -3, position.getZ());
        gl2.glScalef(.35f, 1f, 1);
        glut.glutWireCube(2);

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX(), position.getY() -2, position.getZ());
        glut.glutWireCube(2);
        gl2.glPopMatrix();
        gl2.glPopMatrix();
    }

}
