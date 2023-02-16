package vue.palette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulaire extends JFrame  {
    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JComboBox comboBox;
   private JPanel panel;
    private JPanel panel_1 ;
    private JPanel panel_2 ;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;
    private JLabel lblNewLabel_11;
    private JLabel lblNewLabel_12;
    private JLabel lblNewLabel_13;
    private JLabel lblNewLabel_14;
    private JLabel lblNewLabel_15;
    private JLabel lblNewLabel_16;
    private JLabel lblNewLabel_17;
    private JLabel lblNewLabel_18;
    private JLabel lblNewLabel_19;
    private JLabel lblNewLabel_20;
    private JLabel lblNewLabel_21;
    private JLabel lblNewLabel_22;

    private JButton btnNewButton_2 ;
    private JButton btnNewButton_1 ;
    private JButton btnNewButton ;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;


   void init() {
        panel = new JPanel();
       panel.setLayout(null);

        panel_1 = new JPanel();
       panel_1.setBackground(new Color(0, 128, 255));
       panel_1.setBounds(0, 0, 497, 64);
       panel.add(panel_1);
       panel_1.setLayout(null);

        lblNewLabel = new JLabel("Formulaire");
       lblNewLabel.setForeground(new Color(255, 255, 255));
       lblNewLabel.setBounds(173, 20, 138, 34);
       panel_1.add(lblNewLabel);
       lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));

        panel_2 = new JPanel();
       panel_2.setBackground(new Color(0, 128, 255));
       panel_2.setBounds(0, 644, 497, 86);
       panel.add(panel_2);
       panel_2.setLayout(null);

        btnNewButton_1 = new JButton("");
       btnNewButton_1.setIcon(new ImageIcon(Formulaire.class.getResource("/img/add-user.png")));
       btnNewButton_1.setBounds(191, 10, 85, 63);
       panel_2.add(btnNewButton_1);

        lblNewLabel_2 = new JLabel("");
       lblNewLabel_2.setIcon(new ImageIcon(Formulaire.class.getResource("/img/prenom.png")));
       lblNewLabel_2.setBounds(10, 130, 45, 27);
       panel.add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("");
       lblNewLabel_3.setIcon(new ImageIcon(Formulaire.class.getResource("/img/mail.png")));
       lblNewLabel_3.setBounds(10, 395, 56, 32);
       panel.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("");
       lblNewLabel_4.setIcon(new ImageIcon(Formulaire.class.getResource("/img/user.png")));
       lblNewLabel_4.setBounds(10, 476, 30, 39);
       panel.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("");
       lblNewLabel_5.setIcon(new ImageIcon(Formulaire.class.getResource("/img/telephone-call.png")));
       lblNewLabel_5.setBounds(10, 445, 45, 21);
       panel.add(lblNewLabel_5);

       textField_1 = new JTextField();
       textField_1.setToolTipText("");
       textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
       textField_1.setBounds(149, 82, 245, 27);
       panel.add(textField_1);
       textField_1.setColumns(10);

       textField_3 = new JTextField();
       textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
       textField_3.setBounds(149, 130, 245, 27);
       panel.add(textField_3);
       textField_3.setColumns(10);

       textField_4 = new JTextField();
       textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
       textField_4.setBounds(149, 186, 245, 27);
       panel.add(textField_4);
       textField_4.setColumns(10);

       textField_5 = new JTextField();
       textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
       textField_5.setBounds(149, 349, 245, 27);
       panel.add(textField_5);
       textField_5.setColumns(10);

       textField_6 = new JTextField();
       textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
       textField_6.setBounds(149, 400, 245, 27);
       panel.add(textField_6);
       textField_6.setColumns(10);

       textField_7 = new JTextField();
       textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
       textField_7.setBounds(149, 443, 245, 27);
       panel.add(textField_7);
       textField_7.setColumns(10);

        lblNewLabel_6 = new JLabel("");
       lblNewLabel_6.setIcon(new ImageIcon(Formulaire.class.getResource("/img/id-card.png")));
       lblNewLabel_6.setBounds(10, 349, 45, 27);
       panel.add(lblNewLabel_6);

        lblNewLabel_7 = new JLabel("");
       lblNewLabel_7.setIcon(new ImageIcon(Formulaire.class.getResource("/img/company.png")));
       lblNewLabel_7.setBounds(10, 588, 45, 19);
       panel.add(lblNewLabel_7);

        lblNewLabel_8 = new JLabel("");
       lblNewLabel_8.setIcon(new ImageIcon(Formulaire.class.getResource("/img/password.png")));
       lblNewLabel_8.setBounds(10, 242, 45, 27);
       panel.add(lblNewLabel_8);

       textField_8 = new JTextField();
       textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
       textField_8.setBounds(149, 488, 245, 27);
       panel.add(textField_8);
       textField_8.setColumns(10);

       textField_10 = new JTextField();
       textField_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
       textField_10.setBounds(153, 580, 241, 27);
       panel.add(textField_10);
       textField_10.setColumns(10);

        lblNewLabel_9 = new JLabel("");
       lblNewLabel_9.setIcon(new ImageIcon(Formulaire.class.getResource("/img/password.png")));
       lblNewLabel_9.setBounds(10, 292, 45, 27);
       panel.add(lblNewLabel_9);

        lblNewLabel_10 = new JLabel("");
       lblNewLabel_10.setIcon(new ImageIcon(Formulaire.class.getResource("/img/sex.png")));
       lblNewLabel_10.setBounds(10, 538, 45, 21);
       panel.add(lblNewLabel_10);

        lblNewLabel_11 = new JLabel("");
       lblNewLabel_11.setIcon(new ImageIcon(Formulaire.class.getResource("/img/biometrics.png")));
       lblNewLabel_11.setBounds(10, 82, 45, 27);
       panel.add(lblNewLabel_11);

        lblNewLabel_1 = new JLabel("");
       lblNewLabel_1.setIcon(new ImageIcon(Formulaire.class.getResource("/img/prenom.png")));
       lblNewLabel_1.setBounds(10, 178, 45, 35);
       panel.add(lblNewLabel_1);

        comboBox = new JComboBox();
       comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
       comboBox.setModel(new DefaultComboBoxModel(new String[] {"Homme", "Femme"}));
       comboBox.setBounds(149, 538, 245, 28);
       panel.add(comboBox);

       passwordField = new JPasswordField();
       passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
       passwordField.setBounds(149, 242, 243, 27);
       panel.add(passwordField);

       passwordField_1 = new JPasswordField();
       passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
       passwordField_1.setBounds(147, 292, 245, 27);
       panel.add(passwordField_1);

        lblNewLabel_12 = new JLabel("ID :");
       lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
       lblNewLabel_12.setBounds(78, 90, 45, 13);
       panel.add(lblNewLabel_12);

        lblNewLabel_13 = new JLabel("Nom :");
       lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
       lblNewLabel_13.setBounds(78, 144, 45, 13);
       panel.add(lblNewLabel_13);

        lblNewLabel_14 = new JLabel("Prenom :");
       lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 13));
       lblNewLabel_14.setBounds(65, 195, 58, 13);
       panel.add(lblNewLabel_14);

        lblNewLabel_15 = new JLabel("Password :");
       lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 13));
       lblNewLabel_15.setBounds(65, 251, 74, 13);
       panel.add(lblNewLabel_15);

        lblNewLabel_16 = new JLabel("Password Conf :");
       lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 12));
       lblNewLabel_16.setBounds(51, 300, 92, 13);
       panel.add(lblNewLabel_16);

        lblNewLabel_17 = new JLabel("Login :");
       lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 13));
       lblNewLabel_17.setBounds(68, 358, 45, 13);
       panel.add(lblNewLabel_17);
        lblNewLabel_18 = new JLabel("Email :");
       lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 13));
       lblNewLabel_18.setBounds(68, 409, 45, 13);
       panel.add(lblNewLabel_18);

        lblNewLabel_19 = new JLabel("Telephone :");
       lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 13));
       lblNewLabel_19.setBounds(51, 449, 75, 13);
       panel.add(lblNewLabel_19);

        lblNewLabel_20 = new JLabel("CIN :");
       lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 13));
       lblNewLabel_20.setBounds(78, 496, 45, 13);
       panel.add(lblNewLabel_20);

        lblNewLabel_21 = new JLabel("Sex :");
       lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 13));
       lblNewLabel_21.setBounds(78, 546, 45, 13);
       panel.add(lblNewLabel_21);

        lblNewLabel_22 = new JLabel("Adresse :");
       lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 13));
       lblNewLabel_22.setBounds(67, 588, 56, 13);
       panel.add(lblNewLabel_22);

   }
    public Formulaire(){
       init();
       this.setVisible(true);
        this.setBounds(100, 100, 450, 765);
        this.setResizable(true);
        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.add(panel);
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

