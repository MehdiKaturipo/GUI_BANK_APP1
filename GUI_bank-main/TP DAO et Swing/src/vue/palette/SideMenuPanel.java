package vue.palette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class SideMenuPanel extends JPanel {

    ClassLoader cl = getClass().getClassLoader();
    private LinkedHashMap<String, JButton> buttons;

    public LinkedHashMap<String, JButton> getButtons() {
        return buttons;
    }

    //                      ("Ajouter","Modifier","Supprimer","Chercher")
    private void initButtons(String... buttonsNames){

        buttons = new LinkedHashMap<>();

        List<String > btnNames = new ArrayList<>(Arrays.asList(buttonsNames));

        btnNames.forEach(nameOfButton -> {

            JButton btn = new JButton(nameOfButton);
                    btn.setFont(new Font("Optima", Font.BOLD, 18));
                    btn.setForeground(Color.BLUE);
                    btn.setHorizontalAlignment(JButton.CENTER);
                    btn.setPreferredSize(new Dimension(150, 50));
                    btn.setMaximumSize(new Dimension(150, 50));
                    btn.setMargin(new Insets(5,5,5,5));
            btn.setBorderPainted(false);
            btn.setFocusable(false);


            //btn.setIcon(icon);
                    //btn.setHorizontalTextPosition(JButton.CENTER);
                    //btn.setVerticalTextPosition(JButton.BOTTOM);

                    buttons.put(nameOfButton, btn);
        });

    }


    public SideMenuPanel(String... buttonsNames){
        initButtons(buttonsNames);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        setBorder(new EmptyBorder(15, 6, 0, 6));
        setBackground(new Color(0, 128, 255));

        buttons.forEach((names, btn)-> {
            add(Box.createRigidArea(new Dimension(10, 50)));

            add(btn);
        });
        buttons.get("Ajouter").setIcon(new ImageIcon(Login.class.getResource("/img/user.png")));
        buttons.get("Chercher").setIcon(new ImageIcon(Login.class.getResource("/img/prenom.png")));
        buttons.get("Supprimer").setIcon(new ImageIcon(Login.class.getResource("/img/remove.png")));
        buttons.get("Modifier").setIcon(new ImageIcon(Login.class.getResource("/img/prenom.png")));



        setVisible(false);
    }
}
