package Gui;

import javax.swing.table.TableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HtmlSaveSrv extends HtmlSave{
    public HtmlSaveSrv(TableModel tableModel) {
        super(tableModel);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("./HtmlDataSrv.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.println("<TABLE BORDER><TR><TH>Serice_id<TH>Inventory_id<TH>Date_start<TH>Date_end<TH>Price<TH>Information</TR>");
        for(int i = 0; i < tableModel.getRowCount(); i++) {
            int square = i * i;
            pw.println("<TR><TD>" + (String) tableModel.getValueAt(i,0)
                    + "<TD>" + (String) tableModel.getValueAt(i,1)
                    + "<TD>" + (String) tableModel.getValueAt(i,2)
                    + "<TD>" + (String) tableModel.getValueAt(i,3)
                    + "<TD>" + (String) tableModel.getValueAt(i,4)
                    + "<TD>" + (String) tableModel.getValueAt(i,5)

            );
        }
        pw.println("</TABLE>");
        pw.close();




    }
}
