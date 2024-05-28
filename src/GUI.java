import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    public String getZadanyText() {
        zmacknutetlacitko = false;
        return zadanyText;
    }

    private String zadanyText = "";
    private boolean zmacknutetlacitko = false;

    public boolean isZmacknutetlacitko() {
        return zmacknutetlacitko;
    }

    public GUI(String mistnost1, String mistnost2, String mistnost3, String mistnost4, String mistnost5, String mistnost6, String mistnost7, String mistnost8, String mistnost9) {
        JFrame frame = new JFrame("GridBagLayout Demo");

        JButton btn1 = new JButton(mistnost1);
        JButton btn2 = new JButton(mistnost2);
        JButton btn3 = new JButton(mistnost3);
        JButton btn4 = new JButton(mistnost4);
        JButton btn5 = new JButton(mistnost5);
        JButton btn6 = new JButton(mistnost6);
        JButton btn7 = new JButton(mistnost7);
        JButton btn8 = new JButton(mistnost8);
        JButton btn9 = new JButton(mistnost9);



        JButton lastBtn = new JButton("Last Button");
        JButton longBtn = new JButton("Long Button");
        JLabel lblOutput = new JLabel("zatim nic");
        JTextField txtInput = new JTextField(20);
        JButton btnSubmit = new JButton("Submit");

        // Set preferred, minimum, and maximum sizes for 3x3 buttons to make them smaller
        Dimension buttonSize = new Dimension(160, 100); // Adjust size as needed
        JButton[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        for (JButton btn : buttons) {
            btn.setPreferredSize(buttonSize);
            btn.setMinimumSize(buttonSize);
            btn.setMaximumSize(buttonSize);
        }

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cst = new GridBagConstraints();

        cst.insets = new Insets(40, 40, 40, 40); // Adding larger spaces between components

        // Last button at the top right corner
        cst.gridx = 3;
        cst.gridy = 1;
        cst.gridheight = 1;
        cst.gridwidth = 1;
        cst.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lastBtn, cst);

        // Setting up common constraints for 3x3 buttons
        cst.fill = GridBagConstraints.NONE;
        cst.weightx = 0;
        cst.weighty = 0;

        // First row of buttons
        cst.gridx = 0;
        cst.gridy = 1;
        panel.add(btn1, cst);

        cst.gridx = 1;
        panel.add(btn2, cst);

        cst.gridx = 2;
        panel.add(btn3, cst);

        // Second row of buttons
        cst.gridx = 0;
        cst.gridy = 2;
        panel.add(btn4, cst);

        cst.gridx = 1;
        panel.add(btn5, cst);

        cst.gridx = 2;
        panel.add(btn6, cst);

        // Third row of buttons
        cst.gridx = 0;
        cst.gridy = 3;
        panel.add(btn7, cst);

        cst.gridx = 1;
        panel.add(btn8, cst);

        cst.gridx = 2;
        panel.add(btn9, cst);

        // Long button
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridwidth = 3;
        cst.gridx = 0;
        cst.gridy = 4;
        cst.weightx = 0;
        cst.weighty = 0;
        panel.add(longBtn, cst);

        // Text field and submit button
        cst.gridwidth = 2;
        cst.gridx = 0;
        cst.gridy = 5;
        panel.add(txtInput, cst);

        cst.gridwidth = 1;
        cst.gridx = 2;
        panel.add(btnSubmit, cst);

        // Label output
        cst.gridwidth = 3;
        cst.gridx = 0;
        cst.gridy = 6;
        panel.add(lblOutput, cst);

        // Action listener for the submit button
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (zmacknutetlacitko == true) {
                    zadanyText = txtInput.getText();
                    lblOutput.setText(zadanyText);
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1100);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public class EventSoucet implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }
    }
}
