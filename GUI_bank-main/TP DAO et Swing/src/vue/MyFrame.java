package vue;


import vue.palette.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class    MyFrame extends JFrame {

    ClassLoader cl = getClass().getClassLoader();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Container  container;
    TablePanel tablePanel;
    TablePanel1 tablePanel1;
    TablePanel2 tablePanel2;
    HeaderPanel header;
    SideMenuPanel menuPanel;

    private void initPanels(){
        tablePanel = new TablePanel();
        //tablePanel1 = new TablePanel1();
        //tablePanel2 = new TablePanel2();

        menuPanel = new SideMenuPanel("Ajouter","Modifier","Supprimer","Chercher");

        Font logoFont = new Font("Optima", Font.BOLD, 15);
        header = new HeaderPanel(Color.WHITE,
                new ImageIcon(cl.getResource("images/icons/bankIcon64.png")), "", Color.BLACK, logoFont,
                new ImageIcon((Login.class.getResource("/img/prenom.png"))), "logout", Color.BLACK, logoFont,

                new ImageIcon(cl.getResource("images/icons/menu.png")), "", Color.BLACK, logoFont);


        initActions();
    }

    private void initContainer(){
        initPanels();
        container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(tablePanel, BorderLayout.CENTER);
        //container.add(tablePanel1, BorderLayout.CENTER);
        //container.add(tablePanel2, BorderLayout.CENTER);
        container.add(menuPanel, BorderLayout.WEST);
        container.add(header, BorderLayout.NORTH);
    }


    private void initActions(){

       var buttons = menuPanel.getButtons();

       buttons.get("Ajouter")
               .addActionListener(click -> {System.out.println("btn Ajouter cliqué");
        System.out.println("hi");
               JFrame formulaire = new Formulaire();})
               ;

        buttons.get("Modifier")
                .addActionListener(click -> System.out.println("btn Modifier cliqué"));

        buttons.get("Supprimer")
                .addActionListener(click -> {System.out.println("btn Supprimé cliqué");
                     });

        buttons.get("Chercher")
                .addActionListener(click -> System.out.println("btn Chercher cliqué"));
        buttons.get("Modifier")
                .addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        buttons.get("Modifier").setFont(new Font("Optima", Font.BOLD, 20));


                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        buttons.get("Modifier").setForeground(Color.BLUE);
                        buttons.get("Modifier").setFont(new Font("Optima", Font.BOLD, 18));

                    }
                });
        buttons.get("Supprimer")
                .addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        buttons.get("Supprimer").setFont(new Font("Optima", Font.BOLD, 20));

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        buttons.get("Supprimer").setForeground(Color.BLUE);
                        buttons.get("Supprimer").setFont(new Font("Optima", Font.BOLD, 18));

                    }
                });

        buttons.get("Chercher")
                .addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        buttons.get("Chercher").setFont(new Font("Optima", Font.BOLD, 20));

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        buttons.get("Chercher").setForeground(Color.BLUE);
                        buttons.get("Chercher").setFont(new Font("Optima", Font.BOLD, 18));

                    }
                });

        buttons.get("Ajouter")
                .addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        buttons.get("Ajouter").setFont(new Font("Optima", Font.BOLD, 20));

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        buttons.get("Ajouter").setForeground(Color.BLUE);
                        buttons.get("Ajouter").setFont(new Font("Optima", Font.BOLD, 18));

                    }
                });

        header.getToggleMenu().addActionListener(e->{

            if(menuPanel.isVisible()) menuPanel.setVisible(false);
            else menuPanel.setVisible(true);
        });
        header.getBtn_logout().addActionListener(e->{

           this.setVisible(false);
           JFrame Login = new Login();

        });

    }



    public MyFrame(String title){

        initContainer();
        setTitle(title);
        setLocation(0,0);
        setSize(screenSize.width,screenSize.height-90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

   public static void main(String[] args) {
      //new MyFrame("admin");
     new Login();
   }
}
