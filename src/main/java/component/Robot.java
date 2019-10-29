package component;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.gl2.GLUT;
import common.Point3D;
import util.Color;

public class Robot implements IDisplayable{
    private Point3D position;
    private GL2 gl2;
    private GLUT glut;
    private float scale = 1;
    private int left_Shoulder = 0, left_Elbow = 0, right_Shoulder = 0, right_Elbow =0;
    private int left_hip = 0, left_knee = 0, right_hip = 0, right_knee =0;
    private int y =0;
    private GLUquadric quadric;
    private GLU glu;

    float mat_ambient[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    float mat_specular[] = { 1.0f, 1.0f, 1.0f, 1.0f };
    float mat_shininess[] = { 50.0f };
    float light_position[] = { 3.0f, 4.0f, 5.0f, 0.0f };
    float model_ambient[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    float dissfuse_light[] = {1f, 0f, 0f, 0f};

    @Override
    public void Display(GL2 gl2) {
        this.gl2 = gl2;
        gl2.glMaterialfv (GL2.GL_FRONT, GL2.GL_AMBIENT, mat_ambient,0);
        gl2.glMaterialfv (GL2.GL_FRONT, GL2.GL_SPECULAR, mat_specular,0);
        gl2.glMaterialfv (GL2.GL_FRONT, GL2.GL_SHININESS, mat_shininess,0);
        gl2.glLightfv (GL2.GL_LIGHT0, GL2.GL_POSITION, light_position,0);
        gl2.glLightModelfv (GL2.GL_LIGHT_MODEL_AMBIENT, model_ambient,0);
//        gl2.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, dissfuse_light, 0);
        gl2.glEnable (GL2.GL_LIGHTING);
        gl2.glEnable (GL2.GL_LIGHT0);
        gl2.glEnable (GL.GL_DEPTH_TEST);
        gl2.glScalef(scale,scale,scale);
        DrawHead();
        DrawBody();
        DrawLefArm();
        DrawRightArm();
        DrawLeftLeg();
        DrawRightLeg();

        gl2.glDisable (GL2.GL_LIGHTING);
        gl2.glDisable (GL2.GL_LIGHT0);
        gl2.glDisable (GL.GL_DEPTH_TEST);
    }
    public Robot( Point3D position, float scale) {
        this.position = position;
        this.scale = scale;
        this.glut = new GLUT();
    }
    public void Init(GL2 gl2) {
        glu = new GLU();
        quadric = glu.gluNewQuadric();
        glu.gluQuadricNormals(quadric, GLU.GLU_SMOOTH);
        glu.gluQuadricTexture(quadric, true);
    }
    private void DrawHead() {

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX(), position.getY()+.9, position.getZ());
        gl2.glScalef(1.2f,.5f, .9f);
        glu.gluSphere(quadric,1, 32 , 32);
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX(), position.getY()+2.2, position.getZ());
        gl2.glRotated(y, 0, 1, 0);
        glu.gluSphere(quadric,0.65, 32 , 32);
        gl2.glPopMatrix();
        IncreaseHead();
    }
    private void DrawBody() {
        gl2.glPushMatrix();
        gl2.glTranslated(position.getX(), position.getY()+1, position.getZ());
        gl2.glScalef(1f, 1f, .8f);
        gl2.glRotated(90, 1.0f, 0.0f, 0.0f);
        glu.gluCylinder(quadric, 1.2, 1,2.2, 32, 32);
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX(), position.getY()-1, position.getZ());
        gl2.glScalef(1f, 1f, .76f);
        gl2.glRotated(90, 1.0f, 0.0f, 0.0f);
        glu.gluCylinder(quadric, .96, 1.3,1, 32, 32);
        gl2.glPopMatrix();
    }

    private void DrawLefArm() {
        // upper arm
        gl2.glPushMatrix();
        gl2.glTranslated(position.getX()-1.4f, position.getY()+0.6f, position.getZ());
        glu.gluSphere(quadric,0.4, 32 , 32);
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX()-1.2f, position.getY()+0.6f, position.getZ());
        gl2.glRotated(left_Shoulder, 0, 0, 1);
        gl2.glTranslated(-.9f, 0, 0);
        gl2.glPushMatrix();
        gl2.glScalef(.8f, .35f, .35f);
        glu.gluSphere(quadric,1, 32 , 32);
        gl2.glPopMatrix();
        // forearm

        gl2.glTranslated(-.8f, 0, 0);
        glu.gluSphere(quadric,0.25, 32 , 32);
        gl2.glRotated(left_Elbow, 0, 0, 1);
        gl2.glTranslated(-.8f,0,0);
        gl2.glPushMatrix();
        gl2.glScalef(.8f, .25f, .25f);
        glu.gluSphere(quadric,1, 32 , 32);
        gl2.glPopMatrix();
        gl2.glTranslated(-.8f,0,0);
        glu.gluSphere(quadric,0.28, 32 , 32);
        gl2.glPopMatrix();

    }

    private void DrawRightArm() {
        gl2.glPushMatrix();
        gl2.glTranslated(position.getX()+1.4f, position.getY()+0.6f, position.getZ());
        glu.gluSphere(quadric,0.4, 32 , 32);
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glTranslated(position.getX()+1.2f, position.getY()+0.6f, position.getZ());
        gl2.glRotated(right_Shoulder, 0, 0, 1);
        gl2.glTranslated(+.9f, 0, 0);
        gl2.glPushMatrix();
        gl2.glScalef(.8f, .35f, .35f);
        glu.gluSphere(quadric,1, 32 , 32);
        gl2.glPopMatrix();
        // forearm

        gl2.glTranslated(+.8f, 0, 0);
        glu.gluSphere(quadric,0.25, 32 , 32);
        gl2.glRotated(right_Elbow, 0, 0, 1);
        gl2.glTranslated(+.8f,0,0);
        gl2.glPushMatrix();
        gl2.glScalef(.8f, .25f, .25f);
        glu.gluSphere(quadric,1, 32 , 32);
        gl2.glPopMatrix();
        gl2.glTranslated(+.8f,0,0);
        glu.gluSphere(quadric,0.28, 32 , 32);
        gl2.glPopMatrix();
    }

    private void DrawLeftLeg() {
        gl2.glPushMatrix();
        gl2.glTranslated(position.getX() -.5f, position.getY() -2.2, position.getZ());
        glu.gluSphere(quadric,.8, 32 , 32);
        gl2.glPopMatrix();
        //thigh
        gl2.glPushMatrix();
        gl2.glTranslated(position.getX() -.5f, position.getY() -2.5, position.getZ());
        gl2.glRotated(left_hip, 0, 0, 1);
        gl2.glTranslated(0, -1,0);
        gl2.glPushMatrix();
        gl2.glScalef(.48f, 1f, .48f);
        glu.gluSphere(quadric,1.4, 32 , 32);
        gl2.glPopMatrix();

        //calf
        gl2.glTranslated(0,  -1.3, 0);
        glu.gluSphere(quadric,.5, 32 , 32);
        gl2.glRotated(left_knee, 0, 0, 1);
        gl2.glTranslated(0,  -1.2, 0);
        gl2.glPushMatrix();
        gl2.glScalef(.35f, 1f, .35f);
        glu.gluSphere(quadric,1.4, 32 , 32);
        gl2.glPopMatrix();
        gl2.glTranslated(0,  -1.3, 0);
        glu.gluSphere(quadric,.5, 32 , 32);
//        foot
        gl2.glPopMatrix();
    }

    private void DrawRightLeg() {
        gl2.glPushMatrix();
        gl2.glTranslated(position.getX() + .5f, position.getY() - 2.2, position.getZ());
        glu.gluSphere(quadric, .8, 32, 32);
        gl2.glPopMatrix();
        //thigh
        gl2.glPushMatrix();
        gl2.glTranslated(position.getX() + .5f, position.getY() - 2.5, position.getZ());
        gl2.glRotated(right_hip, 0, 0, 1);
        gl2.glTranslated(0, -1, 0);
        gl2.glPushMatrix();
        gl2.glScalef(.48f, 1f, .48f);
        glu.gluSphere(quadric, 1.4, 32, 32);
        gl2.glPopMatrix();

        //calf
        gl2.glTranslated(0, -1.3, 0);
        glu.gluSphere(quadric, .5, 32, 32);
        gl2.glRotated(right_knee, 0, 0, 1);
        gl2.glTranslated(0, -1.2, 0);
        gl2.glPushMatrix();
        gl2.glScalef(.35f, 1f, .35f);
        glu.gluSphere(quadric, 1.4, 32, 32);
        gl2.glPopMatrix();
        gl2.glTranslated(0, -1.3, 0);
        glu.gluSphere(quadric, .5, 32, 32);
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
    public void IncreaseHead() {
        y = (y + 5) % 360;
    }
}
