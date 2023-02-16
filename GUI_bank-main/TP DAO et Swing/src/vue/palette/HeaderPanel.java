package vue.palette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HeaderPanel extends JPanel {

    private JLabel lbl_logo;
    private JButton btn_logout;
    private JButton btn_toggleMenu;


    public JButton getToggleMenu() {
        return btn_toggleMenu;
    }
    public JButton getBtn_logout() {
        return btn_logout;
    }


    private void initLabel(Icon icon, String text, Color color, Font font){

        lbl_logo = new JLabel(text);
        lbl_logo.setIcon(icon);
        lbl_logo.setForeground(color);
        lbl_logo.setFont(font);
        lbl_logo.setHorizontalAlignment(JLabel.CENTER);
//        lbl_logo.setHorizontalTextPosition(JLabel.CENTER);
//        lbl_logo.setVerticalTextPosition(JLabel.BOTTOM);


    }
    private void initButton1(Icon icon, String text, Color color, Font font){


        btn_logout = new JButton(text);
        btn_logout.setIcon(icon);
        btn_logout.setForeground(color);
        btn_logout.setFont(font);
        btn_logout.setHorizontalTextPosition(JLabel.CENTER);
        btn_logout.setVerticalTextPosition(JLabel.BOTTOM);
        btn_logout.setBorderPainted(false);
        btn_logout.setFocusable(false);

    }

    private void initButton(Icon icon, String text, Color color, Font font){

        btn_toggleMenu = new JButton(text);
        btn_toggleMenu.setIcon(icon);
        btn_toggleMenu.setForeground(color);
        btn_toggleMenu.setFont(font);
        btn_toggleMenu.setHorizontalTextPosition(JLabel.CENTER);
        btn_toggleMenu.setVerticalTextPosition(JLabel.BOTTOM);
        btn_toggleMenu.setBorderPainted(false);
        btn_toggleMenu.setFocusable(false);
//        btn_logout = new JButton(text);
//        btn_logout.setIcon(icon);
//        btn_logout.setForeground(color);
//        btn_logout.setFont(font);
//        btn_logout.setHorizontalTextPosition(JLabel.CENTER);
//        btn_logout.setVerticalTextPosition(JLabel.BOTTOM);
//        btn_logout.setBorderPainted(false);
//        btn_logout.setFocusable(false);
    }



    public  HeaderPanel(Color bgColor,
                        Icon iconlbl, String textlbl, Color colorlbl, Font fontlbl,Icon iconlbl1, String textlbl1, Color colorlbl1, Font fontlbl1,
                        Icon iconbtn, String textbtn, Color colorbtn, Font fontbtn){

        initLabel( iconlbl,  textlbl,  colorlbl,  fontlbl);
        initButton1( iconlbl1,  textlbl1,  colorlbl1,  fontlbl1);


        initButton( iconbtn,  textbtn,  colorbtn,  fontbtn);
        setLayout(new BorderLayout());
        setBackground(bgColor);
        setBorder(new EmptyBorder(10,20,10,10));
        add(lbl_logo, BorderLayout.CENTER);
        add(btn_toggleMenu, BorderLayout.WEST);
        add(btn_logout, BorderLayout.EAST);

    }

}
