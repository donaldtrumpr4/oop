package Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SelectFunc extends JFrame {
    int t;
    Connection connection;
    Object[] srv_headers;
    Object[][] srv_data;

    Object[] ride_headers;
    Object[][] ride_data;

    JTable srv_table;
    JTable ride_table;

    DefaultTableModel ride_tableModel;
    DefaultTableModel srv_tableModel;

    JPanel content;
    Box buttons;
    JButton Submit;
    JButton Cancel;
    JTextField item;
    iHandler ihandler = new iHandler();
    public SelectFunc(Connection conn, int type)
    {
        t = type;
        connection = conn;
        switch (t)
        {
            case 0:
            {
                this.setTitle("Введите имя водителя");
                break;
            }
            case 1:
            {
                this.setTitle("Введите номер автомобиля");
                break;
            }
            case 2:
            {
                this.setTitle("Введите номер автомобиля");
                break;
            }
        }


        setSize(600,600);
        content = new JPanel();
        if (t!=2)
        {
            updateRides(connection);
            init();
            updateRides(connection);
        }
        else
        {
            updateService(connection);
            init();
            updateService(connection);
        }



        Submit.addActionListener(ihandler);
        Cancel.addActionListener(ihandler);
    }

    void init()
    {
        if (t!=2)
        {
            ride_tableModel = new DefaultTableModel(ride_data,ride_headers);
            ride_table = new JTable(ride_tableModel);
        }
        else
        {
            srv_tableModel = new DefaultTableModel(srv_data,srv_headers);
            srv_table = new JTable(srv_tableModel);
        }



        buttons = Box.createHorizontalBox();
        item = new JTextField();
        Submit = new JButton("Искать");
        Cancel = new JButton("Отмена");
        buttons.add(Box.createGlue());
        buttons.add(item);
        buttons.add(Submit);
        buttons.add(Cancel);
        buttons.add(Box.createGlue());

        content.setLayout(new BorderLayout());
        content.add(buttons, BorderLayout.SOUTH);

        if (t!=2)
        {
            content.add(ride_table,BorderLayout.CENTER);
            content.add(new JScrollPane(ride_table));
        }
        else
        {
            content.add(srv_table,BorderLayout.CENTER);
            content.add(new JScrollPane(srv_table));
        }




        getContentPane().add(content);
    }

    void GetCarServiceList(Connection conn, String g_num)
    {
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM [dbo].[GetCarServiceList] (\n" +
                    "   '"+g_num+"')");
            ResultSetMetaData rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount()+1;
            if (srv_headers == null)
            {
                srv_headers = new Object[size-1];
                for (int k = 1; k < size; k++) {
                    srv_headers[k - 1] = rsmd.getColumnName(k);
                }
            }
            if (srv_data == null)
            {
                srv_data = new Object[100][size-1];
                int j=0;
                while (rs.next()) {
                    for (int k = 1; k < size; k++) {
                        srv_data[j][k - 1] = rs.getString(k);
                    }
                    j++;
                }
            }
            else
            {
                int rows = srv_tableModel.getRowCount();
                for(int i = 0; i < rows; i++)
                    srv_tableModel.removeRow(0);
                while (rs.next()) {
                    String insertion[] = new String[size-1];
                    for (int k = 1;k<size;k++)
                    {
                        insertion[k-1] = rs.getString(k);
                    }
                    srv_tableModel.addRow(insertion);
                }
            }


        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    void updateService(Connection conn)
    {

        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Service ORDER BY Service_id");
            ResultSetMetaData rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount()+1;
            if (srv_headers == null)
            {
                srv_headers = new Object[size-1];
                for (int k = 1; k < size; k++) {
                    srv_headers[k - 1] = rsmd.getColumnName(k);
                }
            }
            if (srv_data == null)
            {
                srv_data = new Object[100][size-1];
                int j=0;
                while (rs.next()) {
                    for (int k = 1; k < size; k++) {
                        srv_data[j][k - 1] = rs.getString(k);
                    }
                    j++;
                }
            }
            else
            {
                int rows = srv_tableModel.getRowCount();
                for(int i = 0; i < rows; i++)
                    srv_tableModel.removeRow(0);
                while (rs.next()) {
                    String insertion[] = new String[size-1];
                    for (int k = 1;k<size;k++)
                    {
                        insertion[k-1] = rs.getString(k);
                    }
                    srv_tableModel.addRow(insertion);
                }
            }


        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    void updateRides(Connection conn)
    {

        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Rides ORDER BY Ride_id");
            ResultSetMetaData rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount()+1;
            if (ride_headers == null)
            {
                ride_headers = new Object[size-1];
                for (int k = 1; k < size; k++) {
                    ride_headers[k - 1] = rsmd.getColumnName(k);
                }
            }
            if (ride_data == null)
            {
                ride_data = new Object[100][size-1];
                int j=0;
                while (rs.next()) {
                    for (int k = 1; k < size; k++) {
                        ride_data[j][k - 1] = rs.getString(k);
                    }
                    j++;
                }
            }
            else
            {
                int rows = ride_tableModel.getRowCount();
                for(int i = 0; i < rows; i++)
                    ride_tableModel.removeRow(0);
                while (rs.next()) {
                    String insertion[] = new String[size-1];
                    for (int k = 1;k<size;k++)
                    {
                        insertion[k-1] = rs.getString(k);
                    }
                    ride_tableModel.addRow(insertion);
                }
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    void GetCarRides(Connection conn, String number)
    {

        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM [dbo].[GetCarRides] (\n" +
                    "   '"+number+"')");
            ResultSetMetaData rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount()+1;
            if (ride_headers == null)
            {
                ride_headers = new Object[size-1];
                for (int k = 1; k < size; k++) {
                    ride_headers[k - 1] = rsmd.getColumnName(k);
                }
            }
            if (ride_data == null)
            {
                ride_data = new Object[10][size-1];
                int j=0;
                while (rs.next()) {
                    for (int k = 1; k < size; k++) {
                        ride_data[j][k - 1] = rs.getString(k);
                    }
                    j++;
                }
            }
            else
            {
                int rows = ride_tableModel.getRowCount();
                for(int i = 0; i < rows; i++)
                    ride_tableModel.removeRow(0);
                while (rs.next()) {
                    String insertion[] = new String[size-1];
                    for (int k = 1;k<size;k++)
                    {
                        insertion[k-1] = rs.getString(k);
                    }
                    ride_tableModel.addRow(insertion);

                }
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    void GetDriverRides(Connection conn,String name)
    {
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM [dbo].[GetDriverRides] ('"+name+"')");
            ResultSetMetaData rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount()+1;
            if (ride_headers == null)
            {
                ride_headers = new Object[size-1];
                for (int k = 1; k < size; k++) {
                    ride_headers[k - 1] = rsmd.getColumnName(k);
                }
            }
            if (ride_data == null)
            {
                ride_data = new Object[10][size-1];
                int j=0;
                while (rs.next()) {
                    for (int k = 1; k < size; k++) {
                        ride_data[j][k - 1] = rs.getString(k);
                    }
                    j++;
                }
            }
            else
            {
                int rows = ride_tableModel.getRowCount();
                for(int i = 0; i < rows; i++)
                    ride_tableModel.removeRow(0);
                while (rs.next()) {
                    String insertion[] = new String[size-1];
                    for (int k = 1;k<size;k++)
                    {
                        insertion[k-1] = rs.getString(k);
                    }
                    ride_tableModel.addRow(insertion);

                }
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public class iHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == Submit){
                switch (t)
                {
                    case 0:
                    {
                        GetDriverRides(connection, item.getText());
                        new HtmlSaveRide(ride_tableModel);
                        return;
                    }
                    case 1:
                    {
                        GetCarRides(connection,item.getText());
                        new HtmlSaveRide(ride_tableModel);
                        return;
                    }
                    case 2:
                    {
                        GetCarServiceList(connection,item.getText());
                        new HtmlSaveSrv(srv_tableModel);
                        return;
                    }
                    default:
                    {
                        return;
                    }
                }

            }
            if(e.getSource() == Cancel)
            {
                dispose();
            }

        }
    }







}
