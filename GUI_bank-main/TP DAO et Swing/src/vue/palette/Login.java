package vue.palette;


import vue.MyFrame;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {

    private JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;
    private   JLabel lblNewLabel;
    private   JLabel lblNewLabel_1;
    private   JLabel lblNewLabel_2;
    private   JLabel lblNewLabel_3;
    private   JLabel lblNewLabel_4;
    private   JLabel lblNewLabel_5;
    private   JLabel lblNewLabel_6;
    private   JLabel lblNewLabel_7;
    private  JComboBox comboBox;
    private JPanel panel ;
    private JPanel panel_1 ;
    private JButton btnNewButton_1;

    public Login() {
        initcontents();
        this.setVisible(true);
        this.setBounds(100, 100, 851, 503);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setLayout(null);
        this.getContentPane().add(panel);
        this.getContentPane().add(panel_1);

    }

    private void initcontents() {


         panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 0, 386, 456);

        panel.setLayout(null);

         lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBounds(322, 117, 0, 0);
        panel.add(lblNewLabel_3);

         lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/img/295128.png")));
        lblNewLabel_4.setBounds(36, 10, 379, 427);
        panel.add(lblNewLabel_4);

         panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 128, 255));
        panel_1.setBounds(406, 0, 421, 456);
        panel_1.setLayout(null);

         lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(175, 10, 77, 69);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        panel_1.add(lblNewLabel);

        textField = new JTextField("mouad");
        textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        textField.setBounds(142, 122, 224, 27);
        panel_1.add(textField);
        textField.setColumns(10);

         lblNewLabel_1 = new JLabel("Email :");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(36, 127, 77, 13);
        panel_1.add(lblNewLabel_1);

         lblNewLabel_2 = new JLabel("Password :");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(36, 180, 96, 13);
        panel_1.add(lblNewLabel_2);

         btnNewButton_1 = new JButton("login");
        btnNewButton_1.addActionListener(click -> {
            String email= textField.getText();
            String pass= String.valueOf(passwordField.getPassword());
            System.out.println(pass);

            if(email.equals("mouad")&&pass.equals("123")){
                            this.setVisible(false);
           JFrame MyFrame = new MyFrame("admin");}
            else{
                JOptionPane.showMessageDialog(this,
                        "votre mot de passe ou email est invalide",
                        "A L E R T",
                        JOptionPane.ERROR_MESSAGE);}


            })
        ;
        btnNewButton_1.setForeground(new Color(0, 128, 255));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton_1.setBounds(36, 300, 338, 42);

        panel_1.add(btnNewButton_1);

         comboBox = new JComboBox();
        comboBox.setForeground(new Color(0, 128, 255));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Client"}));
        comboBox.setMaximumRowCount(2);
        comboBox.setBounds(142, 220, 77, 27);
        panel_1.add(comboBox);

         lblNewLabel_5 = new JLabel("Status :");
        lblNewLabel_5.setForeground(new Color(255, 255, 255));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_5.setBounds(36, 228, 77, 13);
        panel_1.add(lblNewLabel_5);

        passwordField = new JPasswordField("123");
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        passwordField.setBounds(142, 175, 224, 27);
        panel_1.add(passwordField);

         lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon(Login.class.getResource("/img/userlogin.png")));
        lblNewLabel_6.setBounds(376, 109, 45, 42);
        panel_1.add(lblNewLabel_6);

         lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon(Login.class.getResource("/img/padlock.png")));
        lblNewLabel_7.setBounds(376, 170, 45, 32);
        panel_1.add(lblNewLabel_7);
    }


}
