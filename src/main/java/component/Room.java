package component;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import java.io.File;

public class Room implements IDisplayable {
    private int texture;
    private GLUT glut = new GLUT();
    public Room( ) {

    }
    public void Init(GL2 gl) {

        try
        {
            File im = new File("src/main/resources/demo.jpg");
            Texture t = TextureIO.newTexture(im, true);
            texture= t.getTextureObject(gl);
//            System.out.println("Texture: "+t);
        }
        catch (Exception e) {
//            System.out.println("failure");
            System.out.println(e);
        }

    }
    @Override
    public void Display(GL2 gl) {
        gl.glTranslated(0,0,0);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture);
        gl.glBegin(GL2.GL_QUADS);

        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f(-10.0f, -10.0f, 10.0f);
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f( 10.0f, -10.0f, 10.0f);
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f( 10.0f, 10.0f, 10.0f);
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(-10.0f, 10.0f, 10.0f);

        // Back Face
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(-10.0f, -10.0f, -10.0f);
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(-10.0f, 10.0f, -10.0f);
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f( 10.0f, 10.0f, -10.0f);
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f( 1.0f, -1.0f, -10.0f);

        // Top Face
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(-10.0f, 10.0f, -10.0f);
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f(-10.0f, 10.0f, 10.0f);
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f( 10.0f, 10.0f, 10.0f);
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f( 10.0f, 10.0f, -1.00f);

        // Bottom Face
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(-10.0f, -10.0f, -10.0f);
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f( 10.0f, -10.0f, -10.0f);
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f( 10.0f, -10.0f, 10.0f);
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(-10.0f, -10.0f, 10.0f);

        // Right face
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f( 10.0f, -10.0f, -10.0f);
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f( 10.0f, 10.0f, -10.0f);
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f( 10.0f, 10.0f, 10.0f);
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f( 10.0f, -10.0f, 10.0f);

        // Left Face
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f(-10.0f, -10.0f, -10.0f);
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(-10.0f, -10.0f, 10.0f);
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(-10.0f, 10.0f, 10.0f);
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(-10.0f, 10.0f, -10.0f);
        gl.glEnd();

        gl.glDisable(GL2.GL_TEXTURE_2D);
    }
}
