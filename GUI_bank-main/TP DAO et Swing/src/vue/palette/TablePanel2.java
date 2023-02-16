package vue.palette;
import dao.daoFiles.BanqueDao;
import dao.daoFiles.ClientDao;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TablePanel2 extends JPanel {

    private JTable table;
    private TableModel2 tableModel2;
    private JScrollPane scrollPane;
    private SearchPanel searchPanel;


    private void initTable(){
         tableModel2  = new TableModel2();
        tableModel2.initColumns("Id", "NomBanque", "Adresse", "Email", "Tel");
        tableModel2.initBanquesData(new BanqueDao().findAll());

        table       = new JTable(tableModel2);
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
                        "Veuillez choisir une Banque d'abord !!!",
                        "A L E R T",
                        JOptionPane.ERROR_MESSAGE);
            }
            else{

                long id           =  (long)tableModel2.getValueAt(row, 0);
                String  nomBnque     =  (String)tableModel2.getValueAt(row, 1);
                String  adrresse   =  (String)tableModel2.getValueAt(row, 2);



                new BanqueDao().deleteById(id);
                var list = new BanqueDao().findAll();
                tableModel2.initBanquesData(list);

                JOptionPane.showMessageDialog(this,
                        "La Banque "+nomBnque+ " a été supprimé avec succès",
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

            var banques =  new BanqueDao().findByKeywordLike(keyword);

            tableModel2.initBanquesData(banques);

        });
    }

    public TablePanel2(){

        initTable();
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.SOUTH);
    }
}
