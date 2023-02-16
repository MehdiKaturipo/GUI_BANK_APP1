package vue.palette;
import dao.daoFiles.AccountDao;
import dao.daoFiles.ClientDao;
import model.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;

public class TablePanel1 extends JPanel {

    private JTable table;
    private TableModel1 tableModel1;
    private JScrollPane scrollPane;
    private SearchPanel searchPanel;


    private void initTable(){

        tableModel1  = new TableModel1();
        tableModel1.initColumns("Id", "DATE_CREATION","SOLDE", "ID_CLIENT");
        tableModel1.initComptesData(new AccountDao().findAll());

        table       = new JTable(tableModel1);
        table.setFont(new Font("Optima", Font.BOLD, 17));
        table.setForeground(new Color(16, 44, 114));
        table.setRowHeight(35);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Optima", Font.BOLD, 20));
        header.setForeground(new Color(198, 113, 34));
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
                        "Veuillez choisir un Compte d'abord !!!",
                        "A L E R T",
                        JOptionPane.ERROR_MESSAGE);
            }
            else{

                long id           =  (long)tableModel1.getValueAt(row, 0);
                LocalDate date      = (LocalDate) tableModel1.getValueAt(row, 1);
                Double solde   = (Double) tableModel1.getValueAt(row, 2);
                Client proprietaire = (Client) tableModel1.getValueAt(row, 3);


                new AccountDao().deleteById(id);
                var list = new AccountDao().findAll();
                tableModel1.initComptesData(list);

                JOptionPane.showMessageDialog(this,
                        "Le Compte "+proprietaire+ " a été supprimé avec succès",
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

            var comptes =  new AccountDao().findByKeywordLike(keyword);

            tableModel1.initComptesData(comptes);

        });
    }

    public TablePanel1(){

        initTable();
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.SOUTH);
    }
}
