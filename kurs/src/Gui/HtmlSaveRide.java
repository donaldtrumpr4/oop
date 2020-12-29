package Gui;

import javax.swing.table.TableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HtmlSaveRide extends HtmlSave{
    public HtmlSaveRide(TableModel tableModel) {
        super(tableModel);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("./HtmlDataRide.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.println("<TABLE BORDER><TR><TH>Ride_id<TH>Driver_id<TH>Car_id<TH>Price<TH>Adress_start<TH>Adress_finish<TH>Time_start<TH>Time_finish<TH>Commission<TH>Information<TH>Status</TR>");
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
                    + "<TD>" + (String) tableModel.getValueAt(i,10)

            );
        }
        pw.println("</TABLE>");
        pw.close();




    }
}
