import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame  implements ActionListener  {

    // JMenuBar
    private JMenuBar mb;

    // JMenu
    private JMenu x;

    // Menu items
    private JMenuItem m1, m2, m3;

    private JTextArea ta            = new JTextArea(" Použij tyto příkazy pro hraní hry:\n Směry: sever, jih, vychod, zapad\n Akce: zvedni a vypit \n ");
    private JTextArea taMistnost    = new JTextArea(" Předměty: \n");
    private JTextArea taNepř        = new JTextArea(" Předměty: \n");

    // Jlabel - staus from game
    private JLabel lblOutput    = new JLabel(" no text");
    private JLabel lblZivoty    = new JLabel("Zdraví hráče: 100%");
    private JLabel lblMistnost  = new JLabel("Místnost: Recepce");

    //JButton - game rooms and submit button
    private JButton btn1        = new JButton();
    private JButton btn2        = new JButton();
    private JButton btn3        = new JButton();
    private JButton btn4        = new JButton();
    private JButton btn5        = new JButton();
    private JButton btn6        = new JButton();
    private JButton btn7        = new JButton();
    private JButton btn8        = new JButton();
    private JButton btn9        = new JButton();
    private JButton btnSubmit   = new JButton("Submit");

    private JDialog modelDialog;
    private JDialog modelDialogH;

    // entered command
    private JTextField txtInput = new JTextField(20);

    // test from input field
    private String zadanyPrikaz = "";

    // indicate submitted button
    private boolean zmacknuteSubmitTlacitko = false;

    /**
     * Vrací zadaný příkaz.
     *
     * @return Zadaný příkaz.
     */

    public String getZadanyPrikaz() {
        zmacknuteSubmitTlacitko = false;
        return zadanyPrikaz;
    }

    /**
     * Nastavuje text výstupu.
     *
     * @param zobrazText Text k zobrazení.
     */

    public void setInfoText(String zobrazText) {
        lblOutput.setText(zobrazText);
    }

    /**
     * Nastavuje text pro zobrazení aktuální místnosti.
     *
     * @param zobrazText Text k zobrazení.
     */

    public void setMistnostText(String zobrazText) {
        lblMistnost.setText("Místnost: "+ zobrazText);
    }

    /**
     * Nastavuje text pro zobrazení zdraví hráče.
     *
     * @param zobrazText Text k zobrazení.
     */

    public void setZivotText(String zobrazText) {
        lblZivoty.setText("Zdraví hráče:n"+ zobrazText+"%");
    }

    /**
     * Vrací informaci, zda bylo stisknuto tlačítko pro potvrzení.
     *
     * @return True, pokud bylo tlačítko stisknuto, jinak false.
     */

    public boolean isZmacknutetlacitko() {
        return zmacknuteSubmitTlacitko;
    }

    /**
     * Nastavuje text oblasti ta.
     *
     * @param zobrazText Text k zobrazení.
     */

    public void setTaText(String zobrazText) {
        ta.setText(zobrazText);
    }

    /**
     * Nastavuje text oblasti taMistnost.
     *
     * @param zobrazText Text k zobrazení.
     */

    public void setTaMistnostText(String zobrazText) {
        taMistnost.setText("Předměty: \n" + zobrazText);
    }

    /**
     * Konstruktor pro vytvoření GUI.
     *
     * @param mistnost1 Popis první místnosti.
     * @param mistnost2 Popis druhé místnosti.
     * @param mistnost3 Popis třetí místnosti.
     * @param mistnost4 Popis čtvrté místnosti.
     * @param mistnost5 Popis páté místnosti.
     * @param mistnost6 Popis šesté místnosti.
     * @param mistnost7 Popis sedmé místnosti.
     * @param mistnost8 Popis osmé místnosti.
     * @param mistnost9 Popis deváté místnosti.
     */

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

        JTextField txtInput = new JTextField(20);
        btnSubmit   = new JButton("Potvrd");
        btnSubmit.setToolTipText("Potvrď herní příkaz");

        // Set preferred, minimum, and maximum sizes for 3x3 buttons to make them smaller
        Dimension buttonSize = new Dimension(160, 100); // Adjust size as needed
        JButton[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        for (JButton btn : buttons) {
            btn.setPreferredSize(buttonSize);
            btn.setMinimumSize(buttonSize);
            btn.setMaximumSize(buttonSize);
        }

        JPanel panel            = new JPanel(new GridBagLayout());
        GridBagConstraints cst  = new GridBagConstraints();

        // Adding larger spaces between components
        cst.insets = new Insets(20, 20, 20, 20);

        // Last button at the top right corner
        cst.gridx = 3;
        cst.gridy = 1;
        cst.gridheight = 1;
        cst.gridwidth = 1;
        cst.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lblZivoty, cst);

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

        // Text field and submit button
        cst.gridwidth = 2;
        cst.gridx = 0;
        cst.gridy = 5;
        panel.add(txtInput, cst);

        cst.gridwidth = 1;
        cst.gridx = 2;
        panel.add(btnSubmit, cst);

        // Label output
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridwidth = 3;
        cst.gridx = 0;
        cst.gridy = 6;
        cst.weightx = 0;
        cst.weighty = 0;
        panel.add(lblOutput, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridwidth = 3;
        cst.gridx = 3;
        cst.gridy = 2;
        cst.weightx = 0;
        cst.weighty = 0;
        panel.add(lblMistnost, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridwidth = 3;
        cst.gridx = 3;
        cst.gridy = 3;
        cst.weightx = 0;
        cst.weighty = 0;
        taMistnost.setBounds(5,5,30,320);
        taMistnost.setEditable(false);
        panel.add(taMistnost, cst);

        // Label output
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridwidth = 3;
        cst.gridx = 0;
        cst.gridy = 8;
        cst.weightx = 0;
        cst.weighty = 0;
        //panel.add(ta, cst);

        ta.setBounds(5,5,360,320);
        ta.setEditable(false);
        panel.add(ta, cst);

        // create a menubar
        mb = new JMenuBar();

        // create a menu
        x = new JMenu("Menu");

        // create menuitems
        m1 = new JMenuItem("O programu");
        m2 = new JMenuItem("Nápověda");
        m3 = new JMenuItem("Konec");

        // add menu items to menu
        x.add(m1);
        x.add(m2);
        x.add(m3);

        // add menu to menu bar
        mb.add(x);
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);

        // sent info that game command was submitted
        btnSubmit.addActionListener(new Hra());
        btnSubmit.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent evt) {
                        zadanyPrikaz = txtInput.getText();
                        zmacknuteSubmitTlacitko = true;
                        lblOutput.setText(zadanyPrikaz);
                    };
                });

        //Modal dialogs
        modelDialog = createDialog(frame,"Zombieland info");
        modelDialogH = createDialogH(frame,"Nápověda");

        // add menubar to frame
        frame.getRootPane().setDefaultButton(btnSubmit);
        frame.setJMenuBar(mb);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1100);
        frame.getContentPane().add(panel);
        btn6.setRequestFocusEnabled(true);
        btn6.setFocusable(true);
        btn6.requestFocusInWindow();
        //frame.pack();
        frame.setVisible(true);
    }

    /**
     * Metoda pro zpracování akcí uživatele.
     *
     * @param e ActionEvent objekt představující akci uživatele.
     */

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(e.getSource()==m1){
            modelDialog.setVisible(true);
        }
        if(e.getSource()==m2){
            modelDialogH.setVisible(true);
        }
        if(e.getSource()==m3){
            lblOutput.setText("Konec");
            System.exit(0);
        }
    }

    /**
     * Vytváří modální dialog s informacemi o programu.
     *
     * @param frame      Rámec, ke kterému je dialog připojen.
     * @param textDialog Text zobrazovaný v titulku dialogu.
     * @return JDialog objekt reprezentující modální dialog.
     */

    private static JDialog createDialog(final JFrame frame, String textDialog){
        final JDialog modelDialog = new JDialog(frame,textDialog,
                Dialog.ModalityType.DOCUMENT_MODAL);
        modelDialog.setBounds(132, 132, 300, 200);
        Container dialogContainer = modelDialog.getContentPane();
        dialogContainer.setLayout(new BorderLayout());
        dialogContainer.add(new JLabel("       Verze programu 2.1, Albert Schürrer ")
                , BorderLayout.CENTER);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelDialog.setVisible(false);
            }
        });
        panel1.add(okButton);
        dialogContainer.add(panel1, BorderLayout.SOUTH);
        return modelDialog;
    }

    /**
     * Vytváří modální dialog s nápovědou.
     *
     * @param frame      Rámec, ke kterému je dialog připojen.
     * @param textDialog Text zobrazovaný v titulku dialogu.
     * @return JDialog objekt reprezentující modální dialog.
     */

    private static JDialog createDialogH(final JFrame frame, String textDialog){
        final JDialog modelDialogH = new JDialog(frame,textDialog,
                Dialog.ModalityType.DOCUMENT_MODAL);
        modelDialogH.setBounds(132, 132, 300, 200);
        Container dialogContainer = modelDialogH.getContentPane();
        dialogContainer.setLayout(new BorderLayout());
        dialogContainer.add(new TextArea(" Použij tyto příkazy pro hraní hry:\n Směry: sever, jih, vychod, zapad\n Akce: zvedni a vypit")
                , BorderLayout.CENTER);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelDialogH.setVisible(false);
            }
        });
        panel1.add(okButton);
        dialogContainer.add(panel1, BorderLayout.SOUTH);
        return modelDialogH;
    }
}