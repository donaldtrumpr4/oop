package Gui;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.util.Arrays;

public class AddElement extends JDialog {
    int t;
    Box united;
    Box buttons;
    Box[] inputBox;
    JLabel[] inputLabel;
    JTextField[] inputField;

    JButton Submit;
    JButton Cancel;
    iHandler ihandler = new iHandler();
    boolean mod;
    Connection connection;

    void SubmitServiceToDB(Connection conn,JTextField[] iF,boolean mode)
    {

        int Service_id;
        int Inventory_id;
        float Price;
        Date date_start = null;
        Date date_end = null;
        String Info;

        try
        {
            Service_id = Integer.parseInt(iF[0].getText());
        }
        catch (NumberFormatException ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"Service_id should be INTEGER");
            return;
        }
        try
        {
            Inventory_id= Integer.parseInt(iF[1].getText());
        }
        catch (NumberFormatException ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"Inventory_id should be INTEGER");
            return;
        }
        try
        {
            Price= Float.parseFloat(iF[4].getText());
        }
        catch (NumberFormatException ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"Price should be a NUMBER");
            return;
        }
        try
        {
            date_start = Date.valueOf(iF[2].getText());
            date_end = Date.valueOf(iF[3].getText());
        } catch (Exception ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"DATE incorrect");
            return;
        }
        Info = iF[5].getText();

        try
        {
            Statement stmt = conn.createStatement();
            if (mode)
            {
                stmt.executeQuery("UPDATE [dbo].[Service]" +
                        "   SET [Service_id] = "+Service_id+
                        "      ,[Inventory_id] = "+Inventory_id +
                        "      ,[Date_start] = '"+date_start+"'" +
                        "      ,[Date_end] = '"+date_end+"'" +
                        "      ,[Price] = "+Price+
                        "      ,[Information_] = '"+Info+"'"+
                        " WHERE Service_id = "+Service_id);
            }
            else
            {
                stmt.executeQuery("\n" +
                        "INSERT INTO [dbo].[Service]\n" +
                        "           ([Service_id]\n" +
                        "           ,[Inventory_id]\n" +
                        "           ,[Date_start]\n" +
                        "           ,[Date_end]\n" +
                        "           ,[Price]\n" +
                        "           ,[Information_])\n" +
                        "     VALUES\n" +
                        "           ("     +Service_id +
                        "           ,"   +Inventory_id +
                        "           ,'"+date_start+"'" +
                        "           ,'"  +date_end+"'" +
                        "           ,"           +Price+
                        "           ,'"           +Info+"')");
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        dispose();

    }

    void SubmitCarToDB(Connection conn,JTextField[] iF,boolean mode)
    {
        int Inventory_id;
        String Gov_number;
        String Manufacturer;
        String Model;
        int Year;
        String Color;
        String Class;
        String Car_status;
        String Info;

        try
        {
            Inventory_id = Integer.parseInt(iF[0].getText());
        }
        catch (NumberFormatException ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"Inventory_id should be INTEGER");
            return;
        }
        try
        {
            Year = Integer.parseInt(iF[4].getText());
        }
        catch (NumberFormatException ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"Year should be INTEGER");
            return;
        }
        Gov_number = iF[1].getText();
        Manufacturer = iF[2].getText();
        Model = iF[3].getText();
        Color = iF[5].getText();
        Class = iF[6].getText();
        Info = iF[7].getText();
        Car_status = iF[8].getText();

        try
        {
            Statement stmt = conn.createStatement();
            if (mode)
            {
                stmt.executeQuery("UPDATE [dbo].[Cars]\n" +
                        "   SET [Inventory_id] = "+Inventory_id+"\n" +
                        "      ,[Gov_number] = '"+Gov_number+"'\n" +
                        "      ,[Manufacturer] = '"+Manufacturer+"'\n" +
                        "      ,[Model] = '"+Model+"'\n" +
                        "      ,[Year_] = "+Year+"\n" +
                        "      ,[Color] = '"+Color+"'\n" +
                        "      ,[Class] = '"+Class+"'\n" +
                        "      ,[Information_] = '"+Info+"'\n" +
                        "      ,[Car_status] = '"+Car_status+"'\n" +
                        " WHERE Inventory_id = "+Inventory_id+"");
            }
            else
            {
                stmt.executeQuery("INSERT INTO [dbo].[Cars]\n" +
                        "           ([Inventory_id]\n" +
                        "           ,[Gov_number]\n" +
                        "           ,[Manufacturer]\n" +
                        "           ,[Model]\n" +
                        "           ,[Year_]\n" +
                        "           ,[Color]\n" +
                        "           ,[Class]\n" +
                        "           ,[Information_]\n" +
                        "           ,[Car_status])\n" +
                        "     VALUES\n" +
                        "           ("+Inventory_id+"\n" +
                        "           ,'"+Gov_number+"'\n" +
                        "           ,'"+Manufacturer+"'\n" +
                        "           ,'"+Model+"'\n" +
                        "           ,"+Year+"\n" +
                        "           ,'"+Color+"'\n" +
                        "           ,'"+Class +"'\n" +
                        "           ,'"+Info+"'\n" +
                        "           ,'"+Car_status+"')");
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        dispose();
    }

    void SubmitDriverToDB(Connection conn,JTextField[] iF,boolean mode)
    {

        int Driver_id;
        int Exp;
        Date birth = null;
        String passport;
        String License_id;
        String FullName;
        String Email;
        String Phone;
        String Status;
        String Info;

        try
        {
            Driver_id = Integer.parseInt(iF[0].getText());
        }
        catch (NumberFormatException ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"Driver_id should be INTEGER");
            return;
        }
        try
        {
            Exp = Integer.parseInt(iF[5].getText());
        }
        catch (NumberFormatException ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"Exp should be INTEGER");
            return;
        }

        try
        {
            birth = Date.valueOf(iF[4].getText());
        } catch (Exception ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"DATE incorrect");
            return;
        }
        passport=iF[1].getText();
        License_id=iF[2].getText();
        FullName=iF[3].getText();
        Email=iF[7].getText();
        Phone=iF[8].getText();
        Status=iF[9].getText();
        Info=iF[6].getText();

        try
        {
            Statement stmt = conn.createStatement();
            if (mode)
            {
                stmt.executeQuery("UPDATE [dbo].[Drivers]\n" +
                        "   SET [Driver_id] = "+Driver_id+"\n" +
                        "      ,[Passport] = '"+passport+"'\n" +
                        "      ,[License_id] = '"+License_id+"'\n" +
                        "      ,[FullName] = '"+FullName+"'\n" +
                        "      ,[Birth] = '"+birth+"'\n" +
                        "      ,[Experience] = "+Exp+"\n" +
                        "      ,[Information_] = '"+Info+"'\n" +
                        "      ,[Email] = '"+Email+"'\n" +
                        "      ,[Phone] = '"+Phone+"'\n" +
                        "      ,[Driver_status] = '"+Status+"'\n" +
                        " WHERE Driver_id = "+Driver_id);
            }
            else
            {
                stmt.executeQuery("INSERT INTO [dbo].[Drivers]\n" +
                        "           ([Driver_id]\n" +
                        "           ,[Passport]\n" +
                        "           ,[License_id]\n" +
                        "           ,[FullName]\n" +
                        "           ,[Birth]\n" +
                        "           ,[Experience]\n" +
                        "           ,[Information_]\n" +
                        "           ,[Email]\n" +
                        "           ,[Phone]\n" +
                        "           ,[Driver_status])\n" +
                        "     VALUES\n" +
                        "           ("+Driver_id+"\n" +
                        "           ,'"+passport+"'\n" +
                        "           ,'"+License_id+"'\n" +
                        "           ,'"+FullName+"'\n" +
                        "           ,'"+birth+"'\n" +
                        "           ,"+Exp+"\n" +
                        "           ,'"+Info+"'\n" +
                        "           ,'"+Email+"'\n" +
                        "           ,'"+Phone+"'\n" +
                        "           ,'"+Status+"')");
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        dispose();
    }

    void SubmitRideToDB(Connection conn,JTextField[] iF,boolean mode)
    {
        int Ride_id;
        int Driver_id;
        int Car_id;
        int Commission;
        Timestamp Time_start = null;
        Timestamp Time_finish = null;

        float Price;

        try
        {
            Ride_id = Integer.parseInt(iF[0].getText());
        }
        catch (NumberFormatException ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"Ride_id should be INTEGER");
            return;
        }
        try
        {
            Driver_id = Integer.parseInt(iF[1].getText());
        }
        catch (NumberFormatException ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"Driver_id should be INTEGER");
            return;
        }
        try
        {
            Car_id = Integer.parseInt(iF[2].getText());
        }
        catch (NumberFormatException ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"Car_id should be INTEGER");
            return;
        }
        try
        {
            Commission = Integer.parseInt(iF[8].getText());
        }
        catch (NumberFormatException ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"Commission should be INTEGER");
            return;
        }
        try
        {
            Price= Float.parseFloat(iF[3].getText());
        }
        catch (NumberFormatException ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"Price should be a NUMBER");
            return;
        }
        try
        {
            Time_start = Timestamp.valueOf(iF[6].getText());
            Time_finish = Timestamp.valueOf(iF[7].getText());
        } catch (Exception ex)
        {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null,"Time incorrect");
            return;
        }
        String Adress_start = iF[4].getText();
        String Adress_finish= iF[5].getText();
        String Info= iF[9].getText();
        String Status= iF[10].getText();

        try
        {
            Statement stmt = conn.createStatement();
            if (mode)
            {
                stmt.executeQuery("UPDATE [dbo].[Rides]\n" +
                        "   SET [Ride_id] = "+Ride_id+"\n" +
                        "      ,[Driver_id] = "+Driver_id+"\n" +
                        "      ,[Car_id] = "+Car_id+"\n" +
                        "      ,[Price] = "+Price+"\n" +
                        "      ,[Adress_start] = '"+Adress_start+"'\n" +
                        "      ,[Adress_finish] = '"+Adress_finish+"'\n" +
                        "      ,[Time_start] = '"+Time_start+"'\n" +
                        "      ,[Time_finish] = '"+Time_finish+"'\n" +
                        "      ,[Commission] = "+Commission+"\n" +
                        "      ,[Information_] = '"+Info+"'\n" +
                        "      ,[Ride_status] = '"+Status+"'\n" +
                        " WHERE Ride_id = "+Ride_id);
            }
            else
            {
                stmt.executeQuery("INSERT INTO [dbo].[Rides]\n" +
                        "           ([Ride_id]\n" +
                        "           ,[Driver_id]\n" +
                        "           ,[Car_id]\n" +
                        "           ,[Price]\n" +
                        "           ,[Adress_start]\n" +
                        "           ,[Adress_finish]\n" +
                        "           ,[Time_start]\n" +
                        "           ,[Time_finish]\n" +
                        "           ,[Commission]\n" +
                        "           ,[Information_]\n" +
                        "           ,[Ride_status])\n" +
                        "     VALUES\n" +
                        "           ("+Ride_id+"\n" +
                        "           ,"+Driver_id+"\n" +
                        "           ,"+Car_id+"\n" +
                        "           ,"+Price+"\n" +
                        "           ,'"+Adress_start+"'\n" +
                        "           ,'"+Adress_finish+"'\n" +
                        "           ,'"+Time_start+"'\n" +
                        "           ,'"+Time_finish+"'\n" +
                        "           ,"+Commission+"\n" +
                        "           ,'"+Info+"'\n" +
                        "           ,'"+Status+"')");
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        dispose();

    }



    public AddElement(Connection conn, TableModel tableModel, int row, boolean mode, int type)
    {
        t = type;
        mod = mode;
        connection = conn;

        switch (t)
        {
            case 0:
            {
                this.setTitle("Введите данные о сервисе");
                break;
            }
            case 1:
            {
                this.setTitle("Введите данные об автомобиле");
                break;
            }
            case 2:
            {
                this.setTitle("Введите данные о водителе");
                break;
            }
            case 3:
            {
                this.setTitle("Введите данные о поездке");
                break;
            }
        }


        setSize(600,600);
        int fields = tableModel.getColumnCount();
        united = Box.createVerticalBox();
        inputLabel = new JLabel[fields];
        inputField = new JTextField[fields];
        inputBox = new Box[fields];
        for (int j = 0;j<fields;j++)
        {

            inputLabel[j] = new JLabel(tableModel.getColumnName(j)+":");
            inputField[j] = new JTextField();


            inputBox[j] = Box.createHorizontalBox();

            inputBox[j].add(inputLabel[j]);
            inputBox[j].add(Box.createHorizontalStrut(3));
            inputBox[j].add(inputField[j]);
            united.add(inputBox[j]);
        }

        buttons = Box.createHorizontalBox();
        Submit = new JButton("Сохранить");
        Cancel = new JButton("Отмена");
        buttons.add(Submit);
        buttons.add(Box.createHorizontalStrut(3));
        buttons.add(Cancel);

        united.add(buttons);

        getContentPane().add(united);
        if (mode)
        {

            for (int j = 0;j<fields;j++)
            {
                try
                {
                    if (tableModel.getValueAt(row,j) != null)
                        inputField[j].setText(tableModel.getValueAt(row,j).toString());
                }
                catch (NullPointerException ex)
                {
                    ex.printStackTrace();
                }

            }
        }
        Submit.addActionListener(ihandler);
        Cancel.addActionListener(ihandler);


    }
    public class iHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == Submit){
                switch (t)
                {
                    case 0:
                    {
                        SubmitServiceToDB(connection,inputField,mod);
                        return;
                    }
                    case 1:
                    {
                        SubmitCarToDB(connection,inputField,mod);
                        return;
                    }
                    case 2:
                    {
                        SubmitDriverToDB(connection,inputField,mod);
                        return;
                    }
                    case 3:
                    {
                        SubmitRideToDB(connection,inputField,mod);
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
