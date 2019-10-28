package component;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import java.io.File;

public class Room implements IDisplayable {
    private int textureFront, textureBack, textureBottom, textureTop, textureRight, textureLeft;
    private float xrot,yrot,zrot;
    private GLUT glut = new GLUT();
    private float witdh =10;
    public Room( ) {

    }
    public void Init(GL2 gl) {
        textureFront = LoadTexture("front.png", gl);
        textureBack = LoadTexture("back.png", gl);
        textureTop = LoadTexture("top.png", gl);
        textureBottom = LoadTexture("bottom.png", gl);
        textureLeft = LoadTexture("left.png", gl);
        textureRight = LoadTexture("right.png", gl);
    }
    private int LoadTexture(String name, GL2 gl){
        Texture t = null;
        try
        {
            StringBuilder path =new StringBuilder("src/main/resources/");
            path.append(name);
            File im = new File(path.toString());
            t = TextureIO.newTexture(im, true);
        }
        catch (Exception e) {
//            System.out.println("failure");
            System.out.println(e);

        }
        return t.getTextureObject(gl);
    }
    @Override
    public void Display(GL2 gl) {
        gl.glTranslated(0,0,0);

        gl.glRotatef(xrot, 1.0f, 1.0f, 1.0f);
        gl.glRotatef(yrot, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(zrot, 0.0f, 0.0f, 1.0f);

        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glBegin(GL2.GL_QUADS);
        // Front Face
        gl.glBindTexture(GL2.GL_TEXTURE_2D, textureFront);
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f(-witdh, -witdh, witdh);
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f( witdh, -witdh, witdh);
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f( witdh, witdh, witdh);
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(-witdh, witdh, witdh);
        // Back Face
        gl.glBindTexture(GL2.GL_TEXTURE_2D, textureBack);
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(-witdh, -witdh, -witdh);
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(-witdh, witdh, -witdh);
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f( witdh, witdh, -witdh);
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f( witdh, -witdh, -witdh);

        // Top Face
        gl.glBindTexture(GL2.GL_TEXTURE_2D, textureTop);
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(-witdh, witdh, -witdh);
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f(-witdh, witdh, witdh);
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f( witdh, witdh, witdh);
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f( witdh, witdh, -witdh);

        // Bottom Face
        gl.glBindTexture(GL2.GL_TEXTURE_2D, textureFront);
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(-witdh, -witdh, -witdh);
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f( witdh, -witdh, -witdh);
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f( witdh, -witdh, witdh);
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(-witdh, -witdh, witdh);

        // Right face
        gl.glBindTexture(GL2.GL_TEXTURE_2D, textureRight);
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f( witdh, -witdh, -witdh);
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f( witdh, witdh, -witdh);
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f( witdh, witdh, witdh);
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f( witdh, -witdh, witdh);

        // Left Face
        gl.glBindTexture(GL2.GL_TEXTURE_2D, textureLeft);
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f(-witdh, -witdh, -witdh);
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(-witdh, -witdh, witdh);
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(-witdh, witdh, witdh);
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(-witdh, witdh, -witdh);
        gl.glEnd();
//        xrot += .3f;
        yrot += .3f;
//        zrot += .3f;

        gl.glDisable(GL2.GL_TEXTURE_2D);
    }
}
