package Training;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class JFrameWindowListener extends JFrame
{
    private static final long serialVersionUID = 1L;
    public JFrameWindowListener ()
    {
        // Создание окна с заголовком
        JFrame frame = new JFrame("Training.JFrameWindowListener");
        // Не закрывать окно по нажатию на кнопку с крестиком 
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Подключение слушателя окна
        frame.addWindowListener (new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Потверждение закрытия окна JFrame
                int res = JOptionPane.showConfirmDialog(null, "Выйти из программы?");
                if (res == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });

        frame.setPreferredSize(new Dimension(250, 80));
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new JFrameWindowListener();
    }
}