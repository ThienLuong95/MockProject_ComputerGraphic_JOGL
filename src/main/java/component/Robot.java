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
    private int left_Shoulder = 0, left_Elbow = 0, right_Shoulder = 0, right_Elbow =0;
    private int left_hip = 0, left_knee = 0, right_hip = 0, right_knee =0;
    @Override
    public void Display(GL2 gl2) {
        this.gl2 = gl2;
        DrawHead();
        DrawBody();
        DrawLefArm();
        DrawRightArm();
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

    private void DrawLefArm() {
        gl2.glColor4f(handColor[0], handColor[1], handColor[2], handColor[3]);
        // upper arm
        gl2.glPushMatrix();
        gl2.glTranslated(position.getX()-1f, position.getY()+0.6f, position.getZ());
        gl2.glRotated(left_Shoulder, 0, 0, 1);
        gl2.glTranslated(position.getX()-.9f, position.getY(), position.getZ());
        gl2.glPushMatrix();
        gl2.glScalef(.75f, .35f, 1);
        glut.glutWireCube(2);
        gl2.glPopMatrix();
        // forearm
        gl2.glTranslated(position.getX()-.8f, position.getY(), position.getZ());
        gl2.glRotated(left_Elbow, 0, 0, 1);
        gl2.glTranslated(position.getX()-.8f, position.getY(), position.getZ());
        gl2.glPushMatrix();
        gl2.glScalef(.75f, .35f, 1);
        glut.glutWireCube(2);
        gl2.glPopMatrix();
        gl2.glPopMatrix();

    }

    private void DrawRightArm() {
        gl2.glColor4f(handColor[0], handColor[1], handColor[2], handColor[3]);

        // upper arm
        gl2.glPushMatrix();
        gl2.glTranslated(position.getX()+1f, position.getY()+0.6f, position.getZ());
        gl2.glRotated(right_Shoulder, 0, 0, 1);
        gl2.glTranslated(position.getX()+.9f, position.getY(), position.getZ());
        gl2.glPushMatrix();
        gl2.glScalef(.75f, .35f, 1);
        glut.glutWireCube(2);
        gl2.glPopMatrix();

        // forearm
        gl2.glTranslated(position.getX()+.8f, position.getY(), position.getZ());
        gl2.glRotated(right_Elbow, 0, 0, 1);
        gl2.glTranslated(position.getX()+.8f, position.getY(), position.getZ());
        gl2.glPushMatrix();
        gl2.glScalef(.75f, .35f, 1);
        glut.glutWireCube(2);
        gl2.glPopMatrix();
        gl2.glPopMatrix();

        //hand
    }

    private void DrawLeftLeg() {
        gl2.glColor4f(legColor[0], legColor[1], legColor[2], legColor[3]);
        //thigh
        gl2.glPushMatrix();
        gl2.glTranslated(position.getX() -.5f, position.getY() -2, position.getZ());
        gl2.glRotated(left_hip, 0, 0, 1);
        gl2.glTranslated(position.getX(), position.getY() -1, position.getZ());
        gl2.glPushMatrix();
        gl2.glScalef(.35f, 1f, 1);
        glut.glutWireCube(2);
        gl2.glPopMatrix();

        //calf
        gl2.glTranslated(position.getX(), position.getY() -1, position.getZ());
        gl2.glRotated(left_knee, 0, 0, 1);
        gl2.glTranslated(position.getX(), position.getY() -1, position.getZ());
        gl2.glPushMatrix();
        gl2.glScalef(.35f, 1f, 1);
        glut.glutWireCube(2);
        gl2.glPopMatrix();

//        foot
        gl2.glPopMatrix();
    }

    private void DrawRightLeg() {
        gl2.glColor4f(legColor[0], legColor[1], legColor[2], legColor[3]);
        //thigh
        gl2.glPushMatrix();
        gl2.glTranslated(position.getX() +.5f, position.getY() -2, position.getZ());
        gl2.glRotated(right_hip, 0, 0, 1);
        gl2.glTranslated(position.getX(), position.getY() -1, position.getZ());
        gl2.glPushMatrix();
        gl2.glScalef(.35f, 1f, 1);
        glut.glutWireCube(2);
        gl2.glPopMatrix();

        //calf
        gl2.glTranslated(position.getX(), position.getY() -1, position.getZ());
        gl2.glRotated(right_knee, 0, 0, 1);
        gl2.glTranslated(position.getX(), position.getY() -1, position.getZ());
        gl2.glPushMatrix();
        gl2.glScalef(.35f, 1f, 1);
        glut.glutWireCube(2);
        gl2.glPopMatrix();

//        foot
        gl2.glPopMatrix();
    }

    public void LeftShoulderUp() {
        left_Shoulder = (left_Shoulder + 5) % 360;
    }
    public void LeftShoulderDown() {
        left_Shoulder = (left_Shoulder - 5) % 360;
    }
    public void LeftElbowUp() {
        left_Elbow = (left_Elbow + 5) % 360;
    }
    public void LeftElbowDown() {
        left_Elbow = (left_Elbow - 5) % 360;
    }

    public void RightShoulderUp() {
        right_Shoulder = (right_Shoulder + 5) % 360;
    }
    public void RightShoulderDown() {
        right_Shoulder = (right_Shoulder - 5) % 360;
    }
    public void RightElbowUp() {
        right_Elbow = (right_Elbow + 5) % 360;
    }
    public void RightElbowDown() {
        right_Elbow = (right_Elbow - 5) % 360;
    }

    public void LeftHipUp() {
        left_hip = (left_hip + 5) % 360;
    }
    public void LeftHipDown() {
        left_hip = (left_hip - 5) % 360;
    }
    public void LeftKneeUp() {
        left_knee = (left_knee + 5) % 360;
    }
    public void LeftKneeDown() {
        left_knee = (left_knee - 5) % 360;
    }

    public void RightHipUp() {
        right_hip = (right_hip + 5) % 360;
    }
    public void RightHipDown() {
        right_hip = (right_hip - 5) % 360;
    }
    public void RightKneeUp() {
        right_knee = (right_knee + 5) % 360;
    }
    public void RightKneeDown() {
        right_knee = (right_knee - 5) % 360;
    }
}
