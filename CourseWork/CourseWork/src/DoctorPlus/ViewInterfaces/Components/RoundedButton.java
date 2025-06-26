package DoctorPlus.ViewInterfaces.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {
    Color c1;
    Color borderColor = c1;

    public RoundedButton(String label, Color c1) {
        super(label);
        setContentAreaFilled(false);

        this.c1=c1;
        borderColor=c1;

        setFocusable(false);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(new Color(107, 107, 107  ));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(c1);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                borderColor = new Color(220, 220, 220  );
            }

            @Override
            public void mouseExited(MouseEvent e) {
                borderColor = c1;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());

        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 30, 30));

        super.paintComponent(g2);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setColor(borderColor);

        g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 30, 30));

        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        // Make sure the clickable area is within the rounded shape
        return new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 30, 30).contains(x, y);
    }

}
