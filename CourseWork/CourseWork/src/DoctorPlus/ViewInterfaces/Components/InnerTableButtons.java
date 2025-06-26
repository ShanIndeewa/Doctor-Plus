package DoctorPlus.ViewInterfaces.Components;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class InnerTableButtons extends JPanel implements TableCellRenderer {
    private final JButton updateButton;
    private final JButton deleteButton;

    public InnerTableButtons() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        updateButton = new RoundedButton("Update",new Color(46, 255, 102));
        updateButton.setBackground(new Color(46, 255, 102));
        deleteButton = new RoundedButton("Delete",new Color(255, 46, 67));
        deleteButton.setBackground(new Color(255, 46, 67));
        add(updateButton);
        add(deleteButton);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}
