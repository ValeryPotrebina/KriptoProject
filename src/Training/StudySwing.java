package Training;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
import java.beans.EventHandler;
import java.net.MalformedURLException;
import java.net.URL;

public class StudySwing {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) {
        //todo картинка, где будет окошко с просьбой ввести путь
        //todo сделать загрузку файла с зашифрованной информацией и расшифровать в другой файл
        //todo сделать какой-то брют форс и т.п
        //jFrame.add(new MyComponent()); //добавили компонент, с помощью которого мы будем рисовать
        jFrame.add(jPanel); //добавили панель, на которую сможем добавлять разные кнопочки
        JButton jButton = new JButton(new MyAction());
        jButton.setText("submit");
        jPanel.add(jButton); //добавили кнопку не панельку

//        jButton.addActionListener((EventHandler.create(ActionListener.class, jFrame, "title", "source.text")));

//        jFrame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
//            }
//        });


    }

    static class MyAction extends AbstractAction{
        MyAction(){
            putValue(AbstractAction.SHORT_DESCRIPTION, "My action");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            jPanel.setBackground(Color.blue);
        }
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true); //чтобы видеть окошко
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //закрытие программы при закрытии окошка
        Toolkit toolkit = Toolkit.getDefaultToolkit(); //штука для работы с нашим приложением
        Dimension dimension = toolkit.getScreenSize(); //ширина и высота нашего экрана
        jFrame.setBounds(dimension.width / 2 - 500, dimension.height / 2 - 400, 1000, 800);
        jFrame.setTitle("MyApplication");
        return jFrame;
    }

    static class MyComponent extends  JComponent{ //рисовать
        @Override
        protected void paintComponent(Graphics g1) {
            Font font = new Font("Chiller", Font.BOLD, 25);   //Шрифт
            Graphics2D g = (Graphics2D) g1; //просто привели к более совсеменному graphics
            g.setFont(font);
            g.setColor(Color.RED);
            g.drawString("I love you", 50, 50); //Нарисовать надпись

            Point2D point1 = new Point2D.Double(52, 52);
            Point2D point2 = new Point2D.Double(130, 52);
            Line2D line = new Line2D.Double(point1, point2);
            g.draw(line); //отрисовка линии (фигуры)

            Ellipse2D ellipse = new Ellipse2D.Double(150, 42, 70, 60);
            g.draw(ellipse);

            Rectangle2D rectangle = new Rectangle2D.Double(150, 42, 70, 60);
            g.draw(rectangle);

            try {
                URL url = new URL("https://abrakadabra.fun/uploads/posts/2022-01/1642478225_1-abrakadabra-fun-p-kontur-serdtse-na-prozrachnom-fone-1.png");
                Image image = new ImageIcon(url).getImage();
                g.drawImage(image,200, 20, null);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
    }
}
