import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Plaza extends JFrame {

    JPainters painters;
    JSlider slider = new JSlider();
    JSlider slider_1;
    JSlider slider_3;
    JSlider slider_2;
    JSpinner spinner;
    JSpinner spinner_2;
    JSpinner spinner_1;
    Watek watek;
    private final JLabel lblNewLabel;
    private final JLabel lblNewLabel_1;
    private final JLabel lblX;
    private final JLabel lblLiniaBrzegowa;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Plaza frame = new Plaza();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Plaza() {
        setTitle("PLAŻA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);

        JLayeredPane layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane, BorderLayout.CENTER);

        painters = new JPainters();
        painters.setBounds(40, 40, 290, 140);
        layeredPane.add(painters);

        slider = new JSlider();
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                painters.SetTX(slider.getValue());
            }
        });
        slider.setBounds(32, 8, 305, 25);
        layeredPane.add(slider);

        slider_1 = new JSlider();
        slider_1.setMaximum(20);
        slider_1.setPaintTicks(true);

        slider_1.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent arg0) {

            }
        });
        slider_1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
                painters.SetTY(slider_1.getValue());
            }
        });
        slider_1.setOrientation(SwingConstants.VERTICAL);
        slider_1.setBounds(10, 34, 30, 82);
        slider_1.setInverted(true);
        layeredPane.add(slider_1);

        slider_2 = new JSlider();
        slider_2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                painters.SetRY(slider_2.getValue());
            }
        });
        slider_2.setOrientation(SwingConstants.VERTICAL);
        slider_2.setBounds(340, 105, 30, 82);
        slider_2.setInverted(true);
        layeredPane.add(slider_2);

        slider_3 = new JSlider();
        slider_3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
                painters.SetRX(slider_3.getValue());
            }
        });
        slider_3.setBounds(32, 190, 308, 25);
        layeredPane.add(slider_3);

        slider.setMaximum(painters.getWidth());
        slider_3.setMaximum(painters.getWidth());
        slider_2.setMaximum(painters.getHeight() / 2);
        slider_1.setMaximum(painters.getHeight() / 2);

        spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(new Integer(20), new Integer(0), null, new Integer(1)));
        layeredPane.setLayer(spinner, 0);
        spinner.setBounds(73, 235, 66, 20);
        layeredPane.add(spinner);

        spinner_1 = new JSpinner();
        spinner_1.setModel(new SpinnerNumberModel(new Integer(40), new Integer(0), null, new Integer(1)));
        spinner_1.setBounds(282, 235, 66, 20);
        layeredPane.add(spinner_1);

        JLabel lblVPoPlay_1 = new JLabel("V po pla\u017Cy");
        lblVPoPlay_1.setBounds(12, 237, 74, 14);
        layeredPane.add(lblVPoPlay_1);

        JLabel lblVWWodzie = new JLabel("V w wodzie");
        lblVWWodzie.setBounds(355, 237, 74, 14);
        layeredPane.add(lblVWWodzie);

        JButton btnNewButton = new JButton("Zmie\u0144 pr\u0119dko\u015Bci");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int temp = (int) spinner_2.getValue();
                painters.SetSpeeds((int) spinner.getValue(), (int) spinner_1.getValue());
                painters.Przyplyw(temp);
                slider_1.setMaximum(temp);
                slider_2.setMaximum(painters.getHeight() - temp);
            }
        });
        btnNewButton.setBounds(142, 269, 140, 23);
        layeredPane.add(btnNewButton);

        lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(163, 190, 46, 14);
        layeredPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Punkt wej\u015Bcia");
        lblNewLabel_1.setBounds(340, 44, 99, 14);
        layeredPane.add(lblNewLabel_1);

        lblX = new JLabel("X=0");
        lblX.setBounds(340, 69, 76, 14);
        layeredPane.add(lblX);
        watek = new Watek(painters, lblX);

        lblLiniaBrzegowa = new JLabel("Linia brzegowa");
        lblLiniaBrzegowa.setBounds(173, 218, 90, 14);
        layeredPane.add(lblLiniaBrzegowa);

        spinner_2 = new JSpinner();
        spinner_2.setModel(new SpinnerNumberModel(100, 0, painters.getHeight(), 1));
        spinner_2.setBounds(183, 235, 66, 20);
        painters.Przyplyw(painters.getHeight() / 2);
        layeredPane.add(spinner_2);
        watek.start();
    }
}