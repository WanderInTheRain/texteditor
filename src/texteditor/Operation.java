package texteditor;
import javax.swing.*;
import java.io.*;

class Operation {
    private static File currentPath = new File("C:\\");

    public static void openFile(Gui gui) {
        JFileChooser fileChooser = new JFileChooser(currentPath);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            gui.setCurrentFile(file);
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String s;
                while ((s = br.readLine()) != null) {
                    gui.appendTextArea(s);
                }
                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error reading the file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void saveFile(Gui gui) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(gui.getCurrentFile()));
            bw.write(gui.getTextArea());
            bw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving the file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void saveAsFile(Gui gui) {
        JFileChooser fileChooser = new JFileChooser(currentPath);
        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            gui.setCurrentFile(file);
            saveFile(gui);
        }
    }
}