package ui;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogl.Grid;
import com.jogl.sample.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel top_header_panel, left_control_panel, right_control_panel, bottom_status_panel;
    private GLCanvas center_display_canvas;

    public MainFrame() {
        initialize();
    }

    private void initialize()
    {
        bottom_status_panel = new JPanel();
        getContentPane().add(bottom_status_panel, BorderLayout.SOUTH);

        top_header_panel = new JPanel();
        getContentPane().add(top_header_panel, BorderLayout.NORTH);

        left_control_panel = new JPanel();
        getContentPane().add(left_control_panel, BorderLayout.WEST);

        right_control_panel = new JPanel();
        getContentPane().add(right_control_panel, BorderLayout.EAST);

        initCanvas();
    }
    private void initCanvas()
    {
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        center_display_canvas = new GLCanvas(capabilities);

//        Line line = new Line();
//        TriangleRotation triangleRotation = new TriangleRotation();
//        center_display_canvas.addGLEventListener(triangleRotation);
//        center_display_canvas.addGLEventListener(line);
//        TriangleDepth triangleDepth = new TriangleDepth();
//        center_display_canvas.addGLEventListener(triangleDepth);
//         Cube cube = new Cube();
//         CubeTexture cube = new CubeTexture();
        Grid grid = new Grid();
        center_display_canvas.addGLEventListener(grid);


        getContentPane().add(center_display_canvas, BorderLayout.CENTER);
        FPSAnimator animator = new FPSAnimator(center_display_canvas, 60, true);
        animator.start();
    }
}
