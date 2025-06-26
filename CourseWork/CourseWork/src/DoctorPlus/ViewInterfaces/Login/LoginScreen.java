package DoctorPlus.ViewInterfaces.Login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginScreen extends JFrame {
    JPanel leftPanel;
    JPanel rightPanel;
    JLabel welcomeLable;
    JLabel titleLable;


    public LoginScreen(String title) throws HeadlessException {
        super(title);
        InitializedUI();
    }

    public LoginScreen() throws HeadlessException {
        InitializedUI();
    }

    private void InitializedUI() {
        Container container = getContentPane();
        setSize(new Dimension(750,400));
        setLayout(new BorderLayout());

        //left side panel with welcome message
        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(new Color(51, 145, 52));
        leftPanel.setSize(350,400);
        welcomeLable =new JLabel("<html><body style='color:white'><p text-align:center><font size='70'><b>Welcome</b></font> <br> to<br> Doctor + services</p></body></html>");
        welcomeLable.setBorder(new EmptyBorder(10, 20, 10, 20));
        welcomeLable.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
        leftPanel.add(welcomeLable,BorderLayout.CENTER);

        //right side panel with form of login details
        Box box = Box.createVerticalBox();
        rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setSize(3500,400);
        rightPanel.setLayout(new BorderLayout());
        titleLable = new JLabel("Log In");
        titleLable.setForeground(new Color(81, 206, 76 ));
        titleLable.setBorder(new EmptyBorder(10, 20, 10, 20));
        titleLable.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLable.setFont(new Font(Font.SANS_SERIF,Font.BOLD,36));
        box.add(titleLable);
        rightPanel.add(box,BorderLayout.NORTH);

        //form panel--------------------------------------------------------------
        rightPanel.add(new FormPanel(this),BorderLayout.CENTER);

        container.add(leftPanel,BorderLayout.WEST);
        container.add(rightPanel,BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }



}
