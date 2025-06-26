package DoctorPlus.ViewInterfaces.Components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FooterPanel extends JPanel {
    JButton functionBtn;
    JButton cancelBtn;

    public JButton getFunctionBtn() {
        return functionBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public FooterPanel(String text) {
        InitializedUI(text);
    }

    private void InitializedUI(String text) {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20,20,30,20));


        functionBtn = new RoundedButton(text,new Color(31, 31, 31 ));
        functionBtn.setBackground(new Color(31, 31, 31 ));
        functionBtn.setForeground(Color.WHITE);
        functionBtn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));

        cancelBtn = new RoundedButton("Cancel",new Color(220, 43, 43 ));
        cancelBtn.setBackground(new Color(220, 43, 43 ));
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));

        add(functionBtn,BorderLayout.EAST);
        add(cancelBtn,BorderLayout.WEST);
    }
}
