import java.util.*;
import javax.swing.*;

public class Controller {
    Controller(JTextArea area, JTextField tf){
        area.setText(area.getText() + tf.getText() + "\n");
        tf.setText("");
    }
}