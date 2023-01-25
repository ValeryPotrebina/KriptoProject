package grafics;

import servises.BruteForce;
import servises.Decoding;
import servises.Encryption;
import servises.SendingFiles;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;

public class Grafics extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;
    private static final String MESSAGE_KEY = "Введите ключ";

    public Grafics() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Подключение слушателя окна
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Выйти из программы?");
                if (res == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        Toolkit toolkit = Toolkit.getDefaultToolkit(); //штука для работы с нашим приложением
        Dimension dimension = toolkit.getScreenSize(); //ширина и высота нашего экрана
        setBounds(dimension.width / 2 - (WIDTH / 2), dimension.height / 2 - (HEIGHT / 2), WIDTH, HEIGHT);
        setTitle("MyApp");
    }

    public void start() {
        new Grafics();
        JPanel panel = new JPanel();
        JButton button1 = new JButton("Encrupt and Decrypt");
        button1.setPreferredSize(new Dimension(450, 80));
        JButton button2 = new JButton("Decrypt by Brute Force");
        button2.setPreferredSize(new Dimension(450, 80));
        JButton button3 = new JButton("Syntax Analyz");
        button3.setPreferredSize(new Dimension(450, 80));
        button1.addActionListener(e -> interfaceOfEncryption(makeWindow()));
        button2.addActionListener(e -> interfaceOfBruteForse(makeWindow()));
        button3.addActionListener(e -> makeWindow());
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        add(panel);
        setVisible(true);
    }

    public JFrame makeWindow() {
        JFrame frame = new JFrame();
        Toolkit toolkit = Toolkit.getDefaultToolkit(); //штука для работы с нашим приложением
        Dimension dimension = toolkit.getScreenSize(); //ширина и высота нашего экрана
        frame.setBounds(dimension.width / 2 - (WIDTH / 2), dimension.height / 2 - (HEIGHT / 2), WIDTH, HEIGHT);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Хотите вернуться в меню?");
                if (res == JOptionPane.YES_OPTION)
                    frame.setVisible(false);
            }
        });
        frame.setBackground(Color.cyan);
        frame.setVisible(true);
        return frame;
    }

    //todo добавить время на файлы
    public void interfaceOfEncryption(JFrame frame) {
        JPanel panel = new JPanel();
        JTextField textField2 = new JTextField(35);
        JLabel label2 = new JLabel(MESSAGE_KEY);
        JLabel result01 = new JLabel("                             ");
        JLabel result02 = new JLabel("                             ");
        JLabel result1 = new JLabel("");
        JLabel result2 = new JLabel("");
        JButton button = new JButton("Encrypt");
        JFilePicker filePicker = new JFilePicker("Выберите файл", "Открыть..", 25);  // создаем объект файлПикера, которому сразу задаем текст в текстбоксе и текст кнопки
        filePicker.setMode(JFilePicker.MODE_SAVE);
        filePicker.addFileTypeFilter(".txt", "Текстовый файл"); // добавляем фильтр только по текстовым файлам
        JFileChooser fileChooser = filePicker.getFileChooser();
        fileChooser.setCurrentDirectory(new File("C:/"));
        panel.add(filePicker);
        panel.add(label2);
        panel.add(textField2);
        panel.add(result01);
        panel.add(button);
        button.addActionListener(e -> {
            String path1;
            int key;
            try {
                path1 = filePicker.getSelectedFilePath();
                key = Integer.parseInt(String.valueOf(textField2.getText()));
                String filePathEncryption = SendingFiles.
                        sendEncryptMessage(Encryption.messageEncrypt(key, Encryption.read(path1)));
                String filePathDecoding = SendingFiles.
                        sendDecipherMessage(Decoding.messageDecipher(key, filePathEncryption));
                result1.setText("Encrypted message is in dir - " + filePathEncryption);
                result2.setText("Decoded message is in dir " + filePathDecoding);         //ошибка
            } catch (FileNotFoundException e1) {
                JOptionPane.showMessageDialog(panel, "Такого файла не существует!");
            } catch (NumberFormatException e2) {
                JOptionPane.showMessageDialog(panel, "Введите числовой ключ");
            } catch (Exception e3) {
                JOptionPane.showMessageDialog(panel, "Ошибка ввода");
            }
        });
        panel.add(result02);
        panel.add(result1);
        panel.add(result2);
        frame.getContentPane().add(panel);
        panel.setVisible(true);
    }

    public void interfaceOfBruteForse(JFrame frame) {
        JPanel panel = new JPanel();
        JLabel result01 = new JLabel("                             ");
        JLabel result02 = new JLabel("                             ");
        JLabel result = new JLabel("");
        JButton button = new JButton("BruteForce");
        JFilePicker filePicker = new JFilePicker("Выберите файл", "Открыть..", 25);  // создаем объект файлПикера, которому сразу задаем текст в текстбоксе и текст кнопки
        filePicker.setMode(JFilePicker.MODE_SAVE);
        filePicker.addFileTypeFilter(".txt", "Текстовый файл"); // добавляем фильтр только по текстовым файлам
        JFileChooser fileChooser = filePicker.getFileChooser();
        fileChooser.setCurrentDirectory(new File("C:/"));

        panel.add(filePicker);
        panel.add(result01);
        panel.add(button);
        button.addActionListener(e -> {
            String path;
            try {
                path = filePicker.getSelectedFilePath();
                String filePathBF = BruteForce.bruteForce(path);
                result.setText("Decoded message by BF is in dir" + filePathBF);
            } catch (FileNotFoundException e1) {
                JOptionPane.showMessageDialog(panel, "Такого файла не существует!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(panel, "Ошибка ввода");
            }
        });
        panel.add(result02);
        panel.add(result);
        frame.add(panel);
        panel.setVisible(true);
    }
}
