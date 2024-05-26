import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI(String mistnost1, String mistnost2, String mistnost3, String mistnost4, String mistnost5, String mistnost6, String mistnost7, String mistnost8 ) {

        JFrame frame = new JFrame("GridBagLayout Demo");
        JButton btn1 = new JButton(mistnost1);
        JButton btn2 = new JButton(mistnost2);
        JButton btn3 = new JButton(mistnost3);
        JButton btn4 = new JButton(mistnost4);
        JButton btn5 = new JButton(mistnost5);
        JButton btn6 = new JButton(mistnost6);
        JButton btn7 = new JButton(mistnost7);
        JButton btn8 = new JButton(mistnost8);


        JButton btns = new JButton("Submit");
        JLabel lblOutput = new JLabel("zatim nic");
        JTextField txtInput = new JTextField(20);


        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cst = new GridBagConstraints();
    }



}
