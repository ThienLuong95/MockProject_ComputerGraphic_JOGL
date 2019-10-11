import com.jogamp.newt.opengl.GLWindow;
import ui.MainFrame;
import javax.swing.*;
import java.awt.*;

public class App {
    public static final int DEFAULT_WIDTH = 1024;
    public static final int DEFAULT_HEIGHT = 768;
    private String title = "ThienCa0298_MockProject_ComputerGraphic_GOGL";
    private GLWindow glWindow;
    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App window = new App();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public App() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new MainFrame();
        frame.setTitle(title);
        frame.setBounds(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
