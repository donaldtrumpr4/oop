package Gui;

import javax.swing.table.TableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HtmlSaveCar extends HtmlSave {
    public HtmlSaveCar(TableModel tableModel) {
        super(tableModel);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("./HtmlDataCar.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.println("<TABLE BORDER><TR><TH>Inventory_id<TH>Gov_number<TH>Manufacturer<TH>Model<TH>Year_<TH>Color<TH>Class<TH>Information<TH>Status</TR>");
        for(int i = 0; i < tableModel.getRowCount(); i++) {
            int square = i * i;
            pw.println("<TR><TD>" + (String) tableModel.getValueAt(i,0)
                    + "<TD>" + (String) tableModel.getValueAt(i,1)
                    + "<TD>" + (String) tableModel.getValueAt(i,2)
                    + "<TD>" + (String) tableModel.getValueAt(i,3)
                    + "<TD>" + (String) tableModel.getValueAt(i,4)
                    + "<TD>" + (String) tableModel.getValueAt(i,5)
                    + "<TD>" + (String) tableModel.getValueAt(i,6)
                    + "<TD>" + (String) tableModel.getValueAt(i,7)
                    + "<TD>" + (String) tableModel.getValueAt(i,8)
            );
        }
        pw.println("</TABLE>");
        pw.close();




    }
}
