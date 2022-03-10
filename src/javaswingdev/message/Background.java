package javaswingdev.message;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Background extends JPanel {

    public Background() {
        init();
    }

    private void init() {
        setOpaque(false);
        setBackground(new Color(245, 245, 245));
        setForeground(new Color(118, 118, 118));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 0;
        int y = 40;
        int width = getWidth();
        int height = getHeight();
        int iconSpace = 7;
        int totalIconSpace = iconSpace * 2;
        int iconSize = y * 2;
        int iconX = (width - (iconSize + totalIconSpace)) / 2;
        int iconY = 0;
        Area area = new Area(new Rectangle2D.Double(x, y, width, height - y));
        area.subtract(new Area(new Ellipse2D.Double(iconX, iconY - iconSpace, iconSize + totalIconSpace, iconSize + totalIconSpace)));
        area.add(new Area(new Ellipse2D.Double(iconX + iconSpace, 0, iconSize, iconSize)));
        g2.setColor(getBackground());
        g2.fill(area);
        g2.dispose();
        super.paintComponent(g);
    }
}
