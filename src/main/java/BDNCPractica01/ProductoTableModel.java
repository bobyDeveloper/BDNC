package BDNCPractica01;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public abstract class ProductoTableModel<T> extends AbstractTableModel{
    protected List<T> valores;
    protected String[] columnNames = {"Clave", "Descripcion", "Precio Venta", "Precio Compra"};
    
    public ProductoTableModel(String[] columnNames, List<T> lstValores){
        this.columnNames = columnNames;
        this.valores = lstValores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

}