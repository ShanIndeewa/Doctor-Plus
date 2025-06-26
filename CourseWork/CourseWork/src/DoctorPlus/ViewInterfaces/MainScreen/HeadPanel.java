package DoctorPlus.ViewInterfaces.MainScreen;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class HeadPanel extends JPanel {
    String userName;
    JLabel nameLabel;
    JLabel iconLable;
    JLabel title;


    public HeadPanel(String userName) {
        this.userName = userName;
        InitializedUI();
    }

    private void InitializedUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(29, 38, 31));

        JPanel rightPanel = new JPanel();

        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
        rightPanel.setBackground(new Color(29, 38, 31));

        nameLabel =new JLabel(userName);
        nameLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
        nameLabel.setForeground(Color.WHITE);
        rightPanel.add(nameLabel);


        ImageIcon icon = new ImageIcon(getClass().getResource("\\Icons\\medical-team (2).png"));
        iconLable = new JLabel(icon);
        iconLable.setBorder(new EmptyBorder(1, 10, 1, 20));
        rightPanel.add(iconLable);

        add(rightPanel,BorderLayout.EAST);

        title=new JLabel("Doctor +");
        title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        title.setForeground(Color.WHITE);
        title.setBorder(new EmptyBorder(1, 10, 1, 20));

        add(title,BorderLayout.WEST);


    }


}
