package Training;// Использование прозрачной панели JOptionPane
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JOptionPaneTest extends JFrame
{
    private static final long serialVersionUID = 1L;

    public static final Font FONT = new Font("Verdana", Font.PLAIN, 11);

    public static void createGUI()
    {
        JFrame frame = new JFrame("Test JOptionPane");

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowListener() {

            public void windowActivated(WindowEvent event) {}

            public void windowClosed(WindowEvent event) {}


            public void windowDeactivated(WindowEvent event) {}

            public void windowDeiconified(WindowEvent event) {}

            public void windowIconified(WindowEvent event) {}

            public void windowOpened(WindowEvent event) {}

            public void windowClosing(WindowEvent event)
            {
                Object[] options = { "Да", "Нет!" };
                int rc = JOptionPane.showOptionDialog(
                        event.getWindow(), "Закрыть окно?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
                if (rc == 0) {
                    event.getWindow().setVisible(false);
                    System.exit(0);
                }
            }
        });
        JLabel label = new JLabel("Использование прозрачной панели при закрытии окна");
        frame.getContentPane().add(label);

        frame.setPreferredSize(new Dimension(350, 80));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("Button.font", FONT);
                UIManager.put("Label.font", FONT);
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}