import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame  implements ActionListener  {

    // JMenuBar
    static JMenuBar mb;

    // JMenu
    static JMenu x;

    // Menu items
    static JMenuItem m1, m2, m3;

    static JTextArea ta;
    static JLabel lblOutput = new JLabel("zatim nic");

    // obsahuje zadany text z textoveho pole
    private String zadanyText = "";

    //indikuje zmáčknutí submit buttonu
    private boolean zmacknuteSubmittlacitko = false;

    JButton btn1 = new JButton();
    JButton btn2 = new JButton();
    JButton btn3 = new JButton();
    JButton btn4 = new JButton();
    JButton btn5 = new JButton();
    JButton btn6 = new JButton();
    JButton btn7 = new JButton();
    JButton btn8 = new JButton();
    JButton btn9 = new JButton();


    public String getZadanyText() {
        zmacknuteSubmittlacitko = false;
        return zadanyText;
    }

    public void setInfoText(String zobrazText) {
        lblOutput.setText(zobrazText);
    }

    public boolean isZmacknutetlacitko() {
        return zmacknuteSubmittlacitko;
    }

    public void settaText(String zobrazText) {
        ta.setText(zobrazText);
    }

    public GUI(String mistnost1, String mistnost2, String mistnost3, String mistnost4, String mistnost5, String mistnost6, String mistnost7, String mistnost8, String mistnost9) {
        JFrame frame = new JFrame("Zombieland");

        btn1.setText(mistnost1);
        btn2.setText(mistnost2);
        btn3.setText(mistnost3);
        btn4.setText(mistnost4);
        btn5.setText(mistnost5);
        btn6.setText(mistnost6);
        btn7.setText(mistnost7);
        btn8.setText(mistnost8);
        btn9.setText(mistnost9);


        JButton lastBtn = new JButton("Last Button");
        JButton longBtn = new JButton("Long Button");
        JTextField txtInput = new JTextField(20);
        JButton btnSubmit = new JButton("Potvrd");

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
                zadanyText = txtInput.getText();
                lblOutput.setText(zadanyText);
                zmacknuteSubmittlacitko = true;
            }
        });


        // create a menubar
        mb = new JMenuBar();

        // create a menu
        x = new JMenu("Menu");

        // create menuitems
        m1 = new JMenuItem("MenuItem1");
        m2 = new JMenuItem("MenuItem2");
        m3 = new JMenuItem("Konec");

        // add menu items to menu
        x.add(m1);
        x.add(m2);
        x.add(m3);

        ta = new JTextArea();
        ta.setBounds(5,5,360,320);
        ta.setEditable(false);
        panel.add(ta, cst);

        // add menu to menu bar
        mb.add(x);

        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);

        // add menubar to frame
        frame.setJMenuBar(mb);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1100);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(e.getSource()==m1){

            lblOutput.setText("Vybrana polozka menu 1");
        }

        if(e.getSource()==m2){

            lblOutput.setText("Vybrana polozka menu 2");
        }
        if(e.getSource()==m3){

            lblOutput.setText("Konec");
            System.exit(0);
        }
    }
}