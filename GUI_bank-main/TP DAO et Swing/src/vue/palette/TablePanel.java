package vue.palette;
import Validator.FormValidator;
import dao.daoFiles.ClientDao;
import model.Banque;
import model.Client;
import model.Sexe;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TablePanel extends JPanel {

    private JTable table;
    private TableModel tableModel;
    private JScrollPane scrollPane;
    private SearchPanel searchPanel;


    private void initTable(){

        tableModel  = new TableModel();
        tableModel.initColumns("Id", "Nom", "Prénom",
                "Login", "Pass", "Cin", "Email", "Tel", "Sexe");
        tableModel.initClientsData(new ClientDao().findAll());

        table       = new JTable(tableModel);
        table.setFont(new Font("Optima", Font.BOLD, 17));
        table.setForeground(new Color(16, 44, 114));
        table.setRowHeight(35);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Optima", Font.BOLD, 20));
        header.setForeground(new Color(6, 0, 3));
        header.setBackground(Color.WHITE);

        ((DefaultTableCellRenderer)header.getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);

        JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);

        scrollPane = new JScrollPane(table);

        searchPanel = new SearchPanel(Color.white);

        initActions();
    }

    private void initActions(){


        searchPanel.getCrudPanel().deleteBtn().addActionListener(e->{

            int row = table.getSelectedRow();
            if(row == -1){

                   JOptionPane.showMessageDialog(this,
                                "Veuillez choisir un client d'abord !!!",
                                "A L E R T",
                                JOptionPane.ERROR_MESSAGE);
            }
            else{

                long id           =  (long)tableModel.getValueAt(row, 0);
                String  nom      =  (String)tableModel.getValueAt(row, 1);
                String  prenom   =  (String)tableModel.getValueAt(row, 2);
                String nomComplet = nom + " " + prenom;


                new ClientDao().deleteById(id);
                var list = new ClientDao().findAll();
                tableModel.initClientsData(list);

                JOptionPane.showMessageDialog(this,
                        "Le Client "+nomComplet+ " a été supprimé avec succès",
                        "I N F O",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        });

        searchPanel.getTxt_search().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    searchPanel.getBtn_search().doClick();
                }
            }
        });
        searchPanel.getBtn_search().addActionListener(e->{
            String keyword = searchPanel.getTxt_search().getText();

            var clients =  new ClientDao().findByKeywordLike(keyword);

            tableModel.initClientsData(clients);

        });
        searchPanel.getCrudPanel().addBtn().addActionListener(e -> {
            JTextField textFieldId = new JTextField(10);
            JTextField textFieldNom = new JTextField(10);
            JTextField textFieldPrenom = new JTextField(10);
            JTextField textFieldLogin = new JTextField(10);
            JPasswordField textFieldPass= new JPasswordField(10);
            JTextField textFieldEmail = new JTextField(10);
            JTextField textFieldTele= new JTextField(10);
            JTextField textFieldSexe = new JTextField(10);

            JPanel panel = new JPanel();
            panel.add(new JLabel("ID:"));
            panel.add(textFieldId);
            panel.add(new JLabel("Nom:"));
            panel.add(textFieldNom);
            panel.add(new JLabel("Prenom:"));
            panel.add(textFieldPrenom);
            panel.add(new JLabel("Login:"));
            panel.add(textFieldLogin);
            panel.add(new JLabel("Password:"));
            panel.add(textFieldPass);
            panel.add(new JLabel("Email:"));
            panel.add(textFieldEmail);
            panel.add(new JLabel("Tele:"));
            panel.add(textFieldTele);
            panel.add(new JLabel("Sexe:"));
            panel.add(textFieldTele);
            //String Id = textFieldId.getText();
            String Nom = textFieldNom.getText();
            String Prenom = textFieldPrenom.getText();
            String Login = textFieldLogin.getText();
            String Password = textFieldPass.getText();
            String Email = textFieldEmail.getText();
            String Tele = textFieldTele.getText();
            //String Sexe = textFieldSexe.getText();

            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Entrer infos nouveau Client", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String passwordValue = String.valueOf(textFieldPass.getPassword());
                if (FormValidator.validateEmail(textFieldEmail.getText()) &&
                        FormValidator.validatePassword(passwordValue) &&
                        (textFieldNom.getText().length() > 0) &&
                        (textFieldPrenom.getText().length() > 0)

                ){
                    new ClientDao().save(new Client( 1, Nom, Prenom, Login, Password, Email, Tele, Tele, Sexe.HOMME));

                    // Show a success message using the JOptionPane class
                    JOptionPane.showMessageDialog(this,
                            "Le client a été ajouté avec succès",
                            "I N F O",
                            JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, "Erreur de saisie");
                }
            }


        });
    }

    public TablePanel(){

        initTable();
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.SOUTH);
    }
}
