package ui;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel top_header_panel, left_control_panel, right_control_panel, bottom_status_panel;
    private GLCanvas center_display_canvas;
    private int fieldWidth = 48;
    private int fieldHeight = 24;

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
        initLeftPanel();
        getContentPane().add(left_control_panel, BorderLayout.WEST);

        right_control_panel = new JPanel();
        getContentPane().add(right_control_panel, BorderLayout.EAST);

        initCanvas();
    }
    private void initLeftPanel() {

        //LookAt
        JPanel lookAtPanel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("LookAt: ");

        JPanel lookAtPanelValue = new JPanel();
        lookAtPanelValue.setLayout(new BoxLayout(lookAtPanelValue, BoxLayout.Y_AXIS));
        //eye
        JPanel lookAtPanelEye = new JPanel(new FlowLayout());
        JTextField lookAtEyeX = new JTextField();
        lookAtEyeX.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        JTextField lookAtEyeY = new JTextField();
        lookAtEyeY.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        JTextField lookAtEyeZ = new JTextField();
        lookAtEyeZ.setPreferredSize(new Dimension(fieldWidth, fieldHeight));

        lookAtPanelEye.add(new JLabel("E"));
        lookAtPanelEye.add(lookAtEyeX);
        lookAtPanelEye.add(lookAtEyeY);
        lookAtPanelEye.add(lookAtEyeZ);

        //center
        JPanel lookAtPanelCenter = new JPanel(new FlowLayout());

        JTextField lookAtCenterX = new JTextField();
        lookAtCenterX.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        JTextField lookAtCenterY = new JTextField();
        lookAtCenterY.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        JTextField lookAtCenterZ = new JTextField();
        lookAtCenterZ.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        lookAtPanelCenter.add(new JLabel("C"));
        lookAtPanelCenter.add(lookAtCenterX);
        lookAtPanelCenter.add(lookAtCenterY);
        lookAtPanelCenter.add(lookAtCenterZ);

        //up
        JPanel lookAtPanelUp = new JPanel(new FlowLayout());

        JTextField lookAtUpX = new JTextField();
        lookAtUpX.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        JTextField lookAtUpY = new JTextField();
        lookAtUpY.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        JTextField lookAtUpZ = new JTextField();
        lookAtUpZ.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        lookAtPanelUp.add(new JLabel("U"));
        lookAtPanelUp.add(lookAtUpX);
        lookAtPanelUp.add(lookAtUpY);
        lookAtPanelUp.add(lookAtUpZ);

        lookAtPanelValue.add(lookAtPanelEye);
        lookAtPanelValue.add(lookAtPanelCenter);
        lookAtPanelValue.add(lookAtPanelUp);

        lookAtPanel.add(label);
        lookAtPanel.add(lookAtPanelValue);

        //Room
//        JPanel roomPanel = new JPanel(new FlowLayout());
//        roomPanel.add(new JLabel("Room Pos"));
//
//        JTextField roomLocationX = new JTextField();
//        roomLocationX.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
//        JTextField roomLocationY = new JTextField();
//        roomLocationY.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
//        JTextField roomLocationZ = new JTextField();
//        roomLocationZ.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
//        roomPanel.add(roomLocationX);
//        roomPanel.add(roomLocationY);
//        roomPanel.add(roomLocationZ);
        //Room Size
        JPanel roomPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        roomPanel.add(new JLabel("Room Size: "));

        JTextField roomSize = new JTextField();
        roomSize.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        roomPanel.add(roomSize);

        //Robo Pos
        JPanel robotPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        robotPanel.add(new JLabel("Robot Position"));

        JTextField robotPosX = new JTextField();
        robotPosX.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        JTextField robotPosY = new JTextField();
        robotPosY.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        JTextField robotPosZ = new JTextField();
        robotPosZ.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        robotPanel.add(robotPosX);
        robotPanel.add(robotPosY);
        robotPanel.add(robotPosZ);

        //Robo Pos
        JPanel robotScalePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        robotScalePanel.add(new JLabel("Robot Position"));

        JTextField RobotScale = new JTextField();
        RobotScale.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        robotScalePanel.add(RobotScale);

        left_control_panel.setPreferredSize(new Dimension(248,600));
        left_control_panel.setLayout(new BoxLayout(left_control_panel, BoxLayout.Y_AXIS));
        left_control_panel.add(lookAtPanel);
        left_control_panel.add(roomPanel);
        left_control_panel.add(robotPanel);
        left_control_panel.add(robotScalePanel);

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
        DisplayManager displayManager = new DisplayManager();
        center_display_canvas.addGLEventListener(displayManager);
        center_display_canvas.addKeyListener(displayManager);
        getContentPane().add(center_display_canvas, BorderLayout.CENTER);
        FPSAnimator animator = new FPSAnimator(center_display_canvas, 60, true);
        animator.start();
    }
}
