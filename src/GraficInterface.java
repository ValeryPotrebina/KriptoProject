import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
//todo когда закрываешь, чтобы спросили уверена ли я.
//todo картинка на задний фон
public class GraficInterface extends JFrame {
    private static final int WIDTH = 540;
    private static final int HEIGHT = 400;
    private static final String MESSAGE_PATH = "Введите путь";
    private static final String MESSAGE_KEY = "Введите ключ";

    private static final long serialVersionUID = 1L;
    public GraficInterface ()
    {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Подключение слушателя окна
        addWindowListener (new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Выйти из программы?");
                if (res == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        Toolkit toolkit = Toolkit.getDefaultToolkit(); //штука для работы с нашим приложением
        Dimension dimension = toolkit.getScreenSize(); //ширина и высота нашего экрана
        setBounds(dimension.width / 2 - (WIDTH/2), dimension.height / 2 - (HEIGHT/2), WIDTH, HEIGHT);
        setTitle("Encryption");
    }

    public void start() {
        new GraficInterface();
        JPanel panel = new JPanel();
        //JTextField textField1 = new JTextField(25);
        JTextField textField2 = new JTextField(35);
        JLabel label1 = new JLabel(MESSAGE_PATH);
        JLabel label2 = new JLabel(MESSAGE_KEY);
        JLabel result1 = new JLabel("");
        JLabel result2 = new JLabel("");
        JButton button = new JButton("Encrypt");

        JFilePicker filePicker = new JFilePicker("Выберите файл", "Открыть..", 25);  // создаем объект файлПикера, которому сразу задаем текст в текстбоксе и текст кнопки
        filePicker.setMode(JFilePicker.MODE_SAVE);
        filePicker.addFileTypeFilter(".txt", "Текстовый файл"); // добавляем фильтр только по текстовым файлам

        JFileChooser fileChooser = filePicker.getFileChooser();
        fileChooser.setCurrentDirectory(new File("D:/"));

        /*setSize(520, 120);*/

        //TODO сделать картинку для приложения
        //TODO сделать чтобы файлы каждый раз создавались новыми (без повтора) - ГОТОВО
        //TODO private
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path;
                int key;
                try {
                    path = filePicker.getSelectedFilePath();
                    //path = String.valueOf(textField1.getText());
                    key = Integer.parseInt(String.valueOf(textField2.getText()));
                    String filePathEncryption = SendingFiles.sendEncryptMessage(Encryption.messageEncrypt(key, Encryption.read(path)));
                    String filePathDecoding = SendingFiles.sendDecipherMessage(Decoding.messageDecipher(key, filePathEncryption));
                    result1.setText("Encrypted message is in dir - " + filePathEncryption);
                    result2.setText("Decoded message is in dir " + filePathDecoding);         //ошибка
                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(panel, "Такого файла не существует!");
                } catch (NumberFormatException e2){
                    JOptionPane.showMessageDialog(panel, "Введите числовой ключ");
                } catch (Exception e3){
                    JOptionPane.showMessageDialog(panel, "Ошибка ввода");
                }

            }
        });
        panel.add(filePicker);
        //panel.add(label1);
        //panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(result1);
        panel.add(result2);
        panel.add(button);
        add(panel);

        setVisible(true);
    }
}
