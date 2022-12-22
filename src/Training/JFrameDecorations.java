package Training;// Оформление окон Swing

import javax.swing.*;

public class JFrameDecorations
{
    public static void main(String[] args)
    {
        // Подключение украшений для окон
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        // Создание окна с рамкой
        JFrame frame = new JFrame("Oкнo с рамкой");
        // Определение способа завершения работы программы
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
        // Создание диалогового окна
        JDialog dialog = new JDialog(frame, "Диалоговое окно");
        // Определение способа завершения работы диалогового окна
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(150, 100);
        // Определение типа оформления диалогового окна
        dialog.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
        dialog.setVisible(true);
    }
}