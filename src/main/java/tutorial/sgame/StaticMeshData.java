package tutorial.sgame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL3;
import com.sun.prism.impl.BufferUtil;

import java.nio.FloatBuffer;

public class StaticMeshData {
    GL3 gl;
    //FrameData objects store the data as a set of FloatBuffers.
    private FrameData data;
    private int vboId;//we use a single VBO
    private int vertOff, coordOff, normOff, totalSize;//offsets into the VBO
    private int vertCount;
    private boolean vboDone=false;

    private final class FrameData{
        private FloatBuffer verts;
        private FloatBuffer coords;
        private FloatBuffer norms;
        public FrameData(float[] v, float[] c, float[] n){
            verts= BufferUtil.newFloatBuffer(v.length);
            verts.put(v);
            coords=BufferUtil.newFloatBuffer(c.length);
            coords.put(c);
            norms=BufferUtil.newFloatBuffer(n.length);
            norms.put(n);
        }
        public FloatBuffer getVerts(){

            verts.rewind();
            return verts;
        }
        public FloatBuffer getCoords(){
            coords.rewind();
            return coords;
        }
        public FloatBuffer getNorms(){
            norms.rewind();
            return norms;
        }
    }
    /*
     * There are at least 3 different ways of setting up VBOs. The least efficient
     * of these is to have a separate VBO for each set of data (verts, coords, etc)
     * and call drawArrays on each buffer. The most efficient is to interleave the data
     * and set up an index array. I have chosen a middle path, a single VBO containing
     * all the data and using offsets to point to each data set.
     */
    private void setupVbo(){
        /*
         * Setup the offsets to point to the data sets. Enum._float is 4 which
         * is the size Java uses for floats.
         */
//        vertOff=0;
//        coordOff=data.getVerts().capacity()*Enum._float;
//        normOff=coordOff+data.getCoords().capacity()*Enum._float;
//        totalSize=normOff+data.getNorms().capacity()*Enum._float;
////ask GL for a VBO
//        int[] tmp=new int[1];
//        gl.glGenBuffersARB(1, tmp, 0);
//        vboId=tmp[0];
//        if(vboId<1)System.out.println("Error getting VBO id");
////bind the buffer and declare it.
//        gl.glBindBufferARB(gl.GL_ARRAY_BUFFER_ARB, vboId);
//        gl.glBufferDataARB(gl.GL_ARRAY_BUFFER_ARB, totalSize, null,
//                gl.GL_STATIC_DRAW_ARB);
////initialize the buffer with data using the offsets to add the data in parts
//        gl.glBufferSubData(gl.GL_ARRAY_BUFFER_ARB, 0,
//                data.getVerts().capacity()*Enum._float, data.getVerts());
//        gl.glBufferSubData(gl.GL_ARRAY_BUFFER_ARB, coordOff,
//                data.getCoords().capacity()*Enum._float, data.getCoords());
//        gl.glBufferSubData(gl.GL_ARRAY_BUFFER_ARB, normOff,
//                data.getNorms().capacity()*Enum._float, data.getNorms());
////release the buffer
//        gl.glBindBufferARB(gl.GL_ARRAY_BUFFER_ARB, 0);
//        vboDone=true;
//    }
//    /*
//     * The VBO is drawn similar to the manner vertex arrays are drawn
//     */
//    public void draw(GL2 gl){
//        if(!vboDone)return;//make sure the VBOs have been set
////re bind the buffer
//        gl.glBindBufferARB(gl.GL_ARRAY_BUFFER_ARB, vboId);
////eanble the appropriate array pointers
//        gl.glEnableClientState(gl.GL_VERTEX_ARRAY);
//        gl.glEnableClientState(gl.GL_TEXTURE_COORD_ARRAY);
//        gl.glEnableClientState(gl.GL_NORMAL_ARRAY);
////describe how the pointers are to operate
//        gl.glVertexPointer(3, gl.GL_FLOAT, 0, 0);
//        gl.glTexCoordPointer(2, gl.GL_FLOAT, 0, coordOff);
//
//        gl.glNormalPointer(gl.GL_FLOAT, 0, normOff);
////draw the data and release the bound buffer
//        gl.glDrawArrays(gl.GL_TRIANGLES, 0, vertCount);
//        gl.glBindBufferARB(gl.GL_ARRAY_BUFFER_ARB, 0);
//    }
}
}
