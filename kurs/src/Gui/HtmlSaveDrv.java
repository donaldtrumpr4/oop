package Gui;

import javax.swing.table.TableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HtmlSaveDrv extends HtmlSave{
    public HtmlSaveDrv(TableModel tableModel) {
        super(tableModel);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("./HtmlDataDrv.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.println("<TABLE BORDER><TR><TH>Driver_id<TH>Passport<TH>License_id<TH>FullName<TH>Birth<TH>Experience<TH>Information<TH>EMail<TH><Phone><TH>Status</TR>");
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
                    + "<TD>" + (String) tableModel.getValueAt(i,9)
            );
        }
        pw.println("</TABLE>");
        pw.close();




    }
}
