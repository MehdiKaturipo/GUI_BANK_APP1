package vue.palette;

import model.Banque;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel2 extends AbstractTableModel {

    private String[]    columnsNames;
    private Object[][]  data;



    public void initColumns(String... colNames){
        columnsNames = new String[colNames.length];

        for (int i=0; i<colNames.length ; i++)
            columnsNames[i] = colNames[i];
    }
    public void initBanquesData(List<Banque> banques){

        data = new Object[banques.size()][columnsNames.length];

        int i = 0;
        for(Banque banque : banques){

            data[i][0] =  banque.getIdBanque();
            data[i][1] =  banque.getNomBanque();
            data[i][2] =  banque.getAdresseBanque();
            data[i][3] =  banque.getTelBanque();
            data[i][4] =  banque.getEmailBanque();


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

