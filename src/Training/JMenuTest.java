package Training;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class JMenuTest extends JFrame
{
    private static final long serialVersionUID = 1L;
    //--------------------------------------------------------
    /**
     * Конструктор класса
     */
    public JMenuTest()
    {
        super("Системное меню");
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        // Создание строки главного меню
        JMenuBar menuBar = new JMenuBar();
        // Добавление в главное меню выпадающих пунктов меню  
        menuBar.add(createFileMenu());
        menuBar.add(createViewMenu());
        // Подключаем меню к интерфейсу приложения
        setJMenuBar(menuBar);
        // Открытие окна
        setSize(300, 200);
        setVisible(true);
    }
    //--------------------------------------------------------
    /**
     * Функция создания меню "Файл"
     * @return
     */
    private JMenu createFileMenu()
    {
        // Создание выпадающего меню
        JMenu file = new JMenu("Файл");
        // Пункт меню "Открыть" с изображением
        JMenuItem open = new JMenuItem("Открыть",
                new ImageIcon("images/open.png"));
        // Пункт меню из команды с выходом из программы
        JMenuItem exit = new JMenuItem(new ExitAction());
        // Добавление к пункту меню изображения
        exit.setIcon(new ImageIcon("images/exit.png"));
        // Добавим в меню пункта open
        file.add(open);
        // Добавление разделителя
        file.addSeparator();
        file.add(exit);

        open.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("ActionListener.actionPerformed : open");
            }
        });
        return file;
    }
    //--------------------------------------------------------
    // создадим забавное меню
    /**
     * Функция создания меню 
     * @return
     */
    private JMenu createViewMenu()
    {
        // создадим выпадающее меню
        JMenu viewMenu = new JMenu("Вид");
        // меню-флажки
        JCheckBoxMenuItem line  = new JCheckBoxMenuItem("Линейка");
        JCheckBoxMenuItem grid  = new JCheckBoxMenuItem("Сетка");
        JCheckBoxMenuItem navig = new JCheckBoxMenuItem("Навигация");
        // меню-переключатели
        JRadioButtonMenuItem one = new JRadioButtonMenuItem("Одна страница");
        JRadioButtonMenuItem two = new JRadioButtonMenuItem("Две страницы");
        // организуем переключатели в логическую группу
        ButtonGroup bg = new ButtonGroup();
        bg.add(one);
        bg.add(two);
        // добавим все в меню
        viewMenu.add(line);
        viewMenu.add(grid);
        viewMenu.add(navig);
        // разделитель можно создать и явно
        viewMenu.add( new JSeparator());
        viewMenu.add(one);
        viewMenu.add(two);
        return viewMenu;
    }
    //--------------------------------------------------------
    /**
     * Вложенный класс завершения работы приложения 
     */
    class ExitAction extends AbstractAction
    {
        private static final long serialVersionUID = 1L;
        ExitAction() {
            putValue(NAME, "Выход");
        }
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    //--------------------------------------------------------
    public static void main(String[] args)
    {
        // Подключение украшений для окон
        JFrame.setDefaultLookAndFeelDecorated(true);
        new JMenuTest();
    }
}