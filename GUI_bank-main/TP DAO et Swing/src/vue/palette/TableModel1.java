package vue.palette;

import model.Compte;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel1 extends AbstractTableModel {

    private String[]    columnsNames;
    private Object[][]  data;



    public void initColumns(String... colNames){
        columnsNames = new String[colNames.length];

        for (int i=0; i<colNames.length ; i++)
            columnsNames[i] = colNames[i];
    }
    public void initComptesData(List<Compte> comptes){

        data = new Object[comptes.size()][columnsNames.length];

        int i = 0;
        for(Compte compte : comptes){

            data[i][0] =  compte.getId();
            data[i][1] =  compte.getDateCreation();
            data[i][2] =  compte.getSolde();
            data[i][3] =  compte.getPropriétaire();

            i++;
        }

        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int col) { return columnsNames[col];}
    @Override
    public int getRowCount() { return data.length;}
    @Override
    public int getColumnCount() { return columnsNames.length;}
    @Override
    public Object getValueAt(int row, int col) {return data[row][col];}
}
