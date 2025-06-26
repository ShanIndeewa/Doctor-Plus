package DoctorPlus.ViewInterfaces.Components;

import javax.swing.*;
import java.awt.*;

public class HeadPanel extends JPanel {
    JLabel title;

    public HeadPanel(String text) {
        InitializedUI(text);
    }

    private void InitializedUI(String text) {
        setLayout(new FlowLayout());
        setBackground(new Color(0, 191, 6));

        title = new JLabel(text);
        title.setFont(new Font(Font.SERIF,Font.BOLD,24));
        add(title);
    }
}
