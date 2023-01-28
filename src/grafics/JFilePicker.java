package grafics;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFilePicker extends JPanel {
    private final JTextField textField;
    private final JFileChooser fileChooser;
    private int mode;
    public static final int MODE_OPEN = 1;
    public static final int MODE_SAVE = 2;

    public JFilePicker(String textFieldLabel, String buttonLabel, Integer columns) {
        fileChooser = new JFileChooser();
        textField = new JTextField(columns);
        init(textFieldLabel, buttonLabel);
    }

    private void init(String textFieldLabel, String buttonLabel) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        // creates the GUI
        JLabel label = new JLabel(textFieldLabel);
        JButton button = new JButton(buttonLabel);
        button.addActionListener(evt -> buttonActionPerformed());
        add(label);
        add(textField);
        add(button);
    }

    private void buttonActionPerformed() {
        if (mode == MODE_OPEN) {
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        } else if (mode == MODE_SAVE) {
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        }
    }

    public void addFileTypeFilter(String extension, String description) {
        FileTypeFilter filter = new FileTypeFilter(extension, description);
        fileChooser.addChoosableFileFilter(filter);
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getSelectedFilePath() {
        return textField.getText();
    }

    public JFileChooser getFileChooser() {
        return this.fileChooser;
    }
}