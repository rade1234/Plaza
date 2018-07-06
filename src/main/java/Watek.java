import javax.swing.JLabel;


public class Watek extends Thread {
    JPainters PainterThrd;
    JLabel labs;

    Watek(JPainters jp, JLabel labs) {
        this.labs = labs;
        this.PainterThrd = jp;
    }

    @Override
    public void run() {
        while (true) {
            PainterThrd.repaint();
            labs.setText(new Integer(PainterThrd.wx).toString());
        }
    }
}