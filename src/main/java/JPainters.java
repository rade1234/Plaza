import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;


public class JPainters extends JComponent {
    private int tx;
    private int ty;
    private int rx;
    private int ry;
    int v1, v2;
    int wx, wy;
    int y;
    int liniaBrzegowa;

    public JPainters() {
        tx = 100;
        ty = 20;
        rx = 200;
        ry = 120;
        v1 = 40;
        v2 = 20;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        y = liniaBrzegowa;
        
        g2d.setColor(Color.blue);
        g2d.fillRect(0, 0, getWidth(), liniaBrzegowa);

        g2d.setColor(Color.orange);
        g2d.fillRect(0, liniaBrzegowa, getWidth(), getHeight() - liniaBrzegowa);

        g2d.setColor(Color.red);
        g2d.drawOval(tx, ty, 5, 5);

        g2d.setColor(Color.red);
        g2d.drawOval(rx, y + ry, 5, 5);

        g2d.setColor(Color.cyan);

        wx = Licz(getWidth());
        g2d.setColor(Color.green);
        g2d.drawLine(tx, ty, wx, y);
        g2d.drawLine(rx, ry + y, wx, y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 100);
    }

    public void SetTX(int x) {
        this.tx = x;
    }

    public void SetSpeeds(int sp1, int sp2) {
        this.v1 = sp1;
        this.v2 = sp2;

    }

    public int Licz(int szer) {
        double min = 0;
        int punkt = 20;
        double d1, d2;
        double t1, t2;

        for (int i = 0; i < szer; i++) {
            d1 = Math.sqrt(Math.pow(tx - i, 2) + Math.pow(ty, 2));
            d2 = Math.sqrt(Math.pow(i - rx, 2) + Math.pow(ry + y, 2));
            t1 = v1 * d1;
            t2 = v2 * d2;
            if (i == 0) {
                min = t1 + t2;
            } else {
                if ((t1 + t2) < min) {
                    min = t1 + t2;
                    punkt = i;
                }
            }
        }
        return punkt;

    }

    public void Przyplyw(int prz) {
        liniaBrzegowa = prz;

    }

    public void SetTY(int y) {
        this.ty = y;
    }

    public void SetRX(int x) {
        this.rx = x;
    }

    public void SetRY(int y) {
        this.ry = y;
    }
}