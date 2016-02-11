package filelocker;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Starts the application by launching MyGui, the application's main interface.
 * @author xint
 */
public class Main {

    public static void main(String[] args) {
      // sets the look and feel of the GUI
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        // launches the gui to main interface
        MyGui MyGui = new MyGui();
        MyGui.getContentPane();
        MyGui.setLocationRelativeTo(null);
        MyGui.setVisible(true);

    }
}
