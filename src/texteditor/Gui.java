package texteditor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Gui extends JFrame {
    private JTextArea textArea;
    private File currentFile;
    private int fontSize = 40;

    public Gui() {
        setTitle("Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();

        Font font = textArea.getFont();
        textArea.setFont(new Font(font.getName(), font.getStyle(), fontSize));

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        Box horizontalBox = Box.createHorizontalBox();

        JButton openItem = new JButton("Open");
        JButton saveItem = new JButton("Save");

        JButton increaseFontButton = new JButton("+");
        JButton decreaseFontButton = new JButton("-");

        openItem.setPreferredSize(new Dimension(70, 20));
        saveItem.setPreferredSize(new Dimension(70, 20));

        horizontalBox.add(openItem);
        horizontalBox.add(Box.createHorizontalStrut(5)); 
        horizontalBox.add(saveItem);
        horizontalBox.add(Box.createHorizontalGlue()); 

        horizontalBox.add(increaseFontButton);
        horizontalBox.add(Box.createHorizontalStrut(5));
        horizontalBox.add(decreaseFontButton);

        menuBar.add(horizontalBox);

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operation.openFile(Gui.this);
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentFile != null) {
                    Operation.saveFile(Gui.this);
                } else {
                    Operation.saveAsFile(Gui.this);
                }
            }
        });

        increaseFontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontSize(Math.min(70, getFontSize() + 5));
            }
        });

        decreaseFontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontSize(Math.max(10, getFontSize() - 5));
            }
        });

    }

    private void setFontSize(int size) {
        fontSize = size;
        Font currentFont = textArea.getFont();
        textArea.setFont(new Font(currentFont.getName(), currentFont.getStyle(), fontSize));
    }

    private int getFontSize() {
        return fontSize;
    }

    public File getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(File file) {
        currentFile = file;
    }

    public void appendTextArea(String s) {
        textArea.append(s + "\n");
    }

    public String getTextArea() {
        return textArea.getText();
    }

}
