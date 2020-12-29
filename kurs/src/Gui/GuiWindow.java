package Gui;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

public class GuiWindow extends JFrame{
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu aboutMenu;
    JMenu addMenu;
    JMenu editMenu;
    JMenu funcMenu;

    JMenuItem addCar;
    JMenuItem addDriver;
    JMenuItem addRide;
    JMenuItem addService;

    JMenuItem editCar;
    JMenuItem editDriver;
    JMenuItem editService;
    JMenuItem editRide;

    JMenuItem getCarRides;
    JMenuItem getDriverRides;
    JMenuItem getCarService;
    JMenuItem getDriversMoney;
    JMenuItem updateRides;

    JMenuItem about;
    JMenuItem update;
    JMenuItem saveTxt;
    JMenuItem saveAll;



    Connection connection = null;

    JTabbedPane tabbedPane;
    JPanel content;

    JPanel drv;
    JPanel car;
    JPanel ride;
    JPanel srv;


    Object drv_headers[];
    Object drv_data[][];

    Object car_headers[];
    Object car_data[][];

    Object ride_headers[];
    Object ride_data[][];

    Object srv_headers[];
    Object srv_data[][];

    JTable drv_table;
    JTable car_table;
    JTable ride_table;
    JTable srv_table;

    DefaultTableModel drv_tableModel;
    DefaultTableModel car_tableModel;
    DefaultTableModel ride_tableModel;
    DefaultTableModel srv_tableModel;

    iHandler ihandler = new iHandler();
    Keys ks = new Keys();
    LisT Ls = new LisT();
    ListSelectionModel selModel_srv;
    ListSelectionModel selModel_drv;
    ListSelectionModel selModel_car;
    ListSelectionModel selModel_ride;







    void updateDrivers(Connection conn)
    {

        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Drivers ORDER BY Driver_id");
            ResultSetMetaData rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount()+1;

            if (drv_headers == null)
            {
                drv_headers = new Object[size-1];
                for (int k = 1; k < size; k++) {
                    drv_headers[k - 1] = rsmd.getColumnName(k);
                }
            }
            if (drv_data == null)
            {
                drv_data = new Object[100][size-1];
                int j=0;
                while (rs.next()) {
                    for (int k = 1; k < size; k++) {
                        drv_data[j][k - 1] = rs.getString(k);
                    }
                    j++;
                }
            }
            else
            {
                int rows = drv_tableModel.getRowCount();
                for(int i = 0; i < rows; i++)
                    drv_tableModel.removeRow(0);
                while (rs.next()) {
                    String insertion[] = new String[size-1];
                    for (int k = 1;k<size;k++)
                    {
                        insertion[k-1] = rs.getString(k);
                    }
                    drv_tableModel.addRow(insertion);
                }
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }


    void updateCars(Connection conn)
    {

        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cars ORDER BY Inventory_id");
            ResultSetMetaData rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount()+1;
            if (car_headers == null)
            {
                car_headers = new Object[size-1];
                for (int k = 1; k < size; k++) {
                    car_headers[k - 1] = rsmd.getColumnName(k);
                }
            }
            if (car_data == null)
            {
                car_data = new Object[100][size-1];
                int j=0;
                while (rs.next()) {
                    for (int k = 1; k < size; k++) {
                        car_data[j][k - 1] = rs.getString(k);
                    }
                    j++;
                }
            }
            else
            {
                int rows = car_tableModel.getRowCount();
                for(int i = 0; i < rows; i++)
                    car_tableModel.removeRow(0);
                while (rs.next()) {
                    String insertion[] = new String[size-1];
                    for (int k = 1;k<size;k++)
                    {
                        insertion[k-1] = rs.getString(k);
                    }
                    car_tableModel.addRow(insertion);
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

    void updateTables(Connection conn)
    {
        updateDrivers(conn);
        updateRides(conn);
        updateCars(conn);
        updateService(conn);

    }


    void connectDB() throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;database=cab_co;integratedSecurity=true;");
            System.out.println("Connection Succeeded");

        } catch (SQLException e) {
            System.out.println("Connection Failed : " + e.getMessage());
        }
    }

    void init_Menu()
    {
        menuBar = new JMenuBar();
        fileMenu = new JMenu("Файл");
        aboutMenu = new JMenu("Справка");
        addMenu = new JMenu("Добавить");
        editMenu = new JMenu("Изменить");
        funcMenu = new JMenu("Операции");

        addCar = new JMenuItem("Добавить автомобиль");
        addDriver = new JMenuItem("Добавить водителя");
        addRide = new JMenuItem("Добавить поездку в базу");
        addService = new JMenuItem("Добавить сервисную запись");

        editCar = new JMenuItem("Изменить информацию об автомобиле");
        editDriver = new JMenuItem("Изменить информацию о водителе");
        editService = new JMenuItem("Изменить сервисную запись");
        editRide = new JMenuItem("Изменить поездку");

        getCarRides = new JMenuItem("Список поездок автомобиля");
        getDriverRides = new JMenuItem("Список поездки водителя");
        getCarService = new JMenuItem("Список сервисов автомобиля");
        getDriversMoney = new JMenuItem("Полная сумма по водителям");
        updateRides = new JMenuItem("Обновить поездки");
        about = new JMenuItem("О программе");
        update = new JMenuItem("Обновить");
        saveTxt = new JMenuItem("Сохранить как txt");
        saveAll = new JMenuItem("Сохранить все");

        menuBar.add(fileMenu);
        menuBar.add(addMenu);
        menuBar.add(editMenu);
        menuBar.add(funcMenu);
        menuBar.add(aboutMenu);

        addMenu.add(addCar);
        addMenu.add(addDriver);
        addMenu.add(addRide);
        addMenu.add(addService);

        editMenu.add(editCar);
        editMenu.add(editDriver);
        editMenu.add(editRide);
        editMenu.add(editService);

        aboutMenu.add(about);

        funcMenu.add(getCarRides);
        funcMenu.add(getDriverRides);
        funcMenu.add(getCarService);
        funcMenu.add(getDriversMoney);

        fileMenu.add(update);
        fileMenu.add(saveTxt);
        fileMenu.add(saveAll);
        setJMenuBar(menuBar);


    }



    void init()
    {
        tabbedPane = new JTabbedPane();
        content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(tabbedPane, BorderLayout.CENTER);


        drv = new JPanel();
        drv.setLayout(new BorderLayout());
        srv = new JPanel();
        srv.setLayout(new BorderLayout());
        ride = new JPanel();
        ride.setLayout(new BorderLayout());
        car = new JPanel();
        car.setLayout(new BorderLayout());


        drv_tableModel = new DefaultTableModel(drv_data,drv_headers);
        srv_tableModel = new DefaultTableModel(srv_data,srv_headers);
        ride_tableModel = new DefaultTableModel(ride_data,ride_headers);
        car_tableModel = new DefaultTableModel(car_data,car_headers);

        drv_table = new JTable(drv_tableModel);
        srv_table = new JTable(srv_tableModel);
        ride_table = new JTable(ride_tableModel);
        car_table = new JTable(car_tableModel);


        drv.add(drv_table,BorderLayout.CENTER);
        srv.add(srv_table,BorderLayout.CENTER);
        car.add(car_table,BorderLayout.CENTER);
        ride.add(ride_table,BorderLayout.CENTER);




        drv.add(new JScrollPane(drv_table));
        srv.add(new JScrollPane(srv_table));
        car.add(new JScrollPane(car_table));
        ride.add(new JScrollPane(ride_table));



        tabbedPane.addTab("Водители", drv);
        tabbedPane.addTab("Машины", car);
        tabbedPane.addTab("Сервис", srv);
        tabbedPane.addTab("Поездки", ride);

        getContentPane().add(content);
    }

    public GuiWindow()
    {
        this.setTitle("Taxi manager");
        setSize(1200,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init_Menu();
        //init_Lock();
        //set_lock();
        try
        {
            connectDB();
        } catch (ClassNotFoundException e)
        {
            e.getStackTrace();
        }
        updateTables(connection);
        init();
        updateTables(connection);

        selModel_srv = srv_table.getSelectionModel();
        selModel_srv.addListSelectionListener(Ls);
        selModel_car = car_table.getSelectionModel();
        selModel_car.addListSelectionListener(Ls);
        selModel_drv = drv_table.getSelectionModel();
        selModel_drv.addListSelectionListener(Ls);
        selModel_ride = ride_table.getSelectionModel();
        selModel_ride.addListSelectionListener(Ls);

        editService.addActionListener(ihandler);
        addService.addActionListener(ihandler);
        editCar.addActionListener(ihandler);
        addCar.addActionListener(ihandler);
        editDriver.addActionListener(ihandler);
        addDriver.addActionListener(ihandler);
        editRide.addActionListener(ihandler);
        addRide.addActionListener(ihandler);
        getDriverRides.addActionListener(ihandler);
        getCarRides.addActionListener(ihandler);
        getCarService.addActionListener(ihandler);
        getDriversMoney.addActionListener(ihandler);
        saveTxt.addActionListener(ihandler);
        update.addActionListener(ihandler);
        menuBar.setFocusable(true);
        menuBar.addKeyListener(ks);
        saveAll.addActionListener(ihandler);

    }

     public class Keys extends KeyAdapter {

         public void keyPressed(KeyEvent e) {
             if (e.getKeyText(e.getKeyCode()) == "F5")
             {
                 updateTables(connection);
                 System.out.println("UPDATED");

             }
         }
     }

    public class LisT implements ListSelectionListener{

        public void valueChanged(ListSelectionEvent e)
        {        }
    }

    public class iHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == editService){
                AddElement a = new AddElement(connection,srv_tableModel,selModel_srv.getAnchorSelectionIndex(),true,0);
                a.setVisible(true);
            }
            if (e.getSource() == addService)
            {
                AddElement a = new AddElement(connection,srv_tableModel,0,false,0);
                a.setVisible(true);
            }

            if (e.getSource() == editCar)
            {
                AddElement a = new AddElement(connection,car_tableModel,selModel_car.getAnchorSelectionIndex(),true,1);
                a.setVisible(true);
            }

            if (e.getSource() == addCar)
            {
                AddElement a = new AddElement(connection,car_tableModel,0,false,1);
                a.setVisible(true);
            }

            if (e.getSource() == editDriver)
            {
                AddElement a = new AddElement(connection,drv_tableModel,selModel_drv.getAnchorSelectionIndex(),true,2);
                a.setVisible(true);
            }

            if (e.getSource() == addDriver)
            {
                AddElement a = new AddElement(connection,drv_tableModel,0,false,2);
                a.setVisible(true);
            }

            if (e.getSource() == editRide)
            {
                AddElement a = new AddElement(connection,ride_tableModel,selModel_ride.getAnchorSelectionIndex(),true,3);
                a.setVisible(true);
            }

            if (e.getSource() == addRide)
            {
                AddElement a = new AddElement(connection,ride_tableModel,0,false,3);
                a.setVisible(true);
            }

            if (e.getSource() == getDriverRides)
            {
                SelectFunc a = new SelectFunc(connection,0);
                a.setVisible(true);
            }

            if (e.getSource() == getCarRides)
            {
                SelectFunc a = new SelectFunc(connection,1);
                a.setVisible(true);
            }

            if (e.getSource() == getCarService)
            {
                SelectFunc a = new SelectFunc(connection,2);
                a.setVisible(true);
            }

            if (e.getSource() == update)
            {
                updateTables(connection);
            }

            if (e.getSource() == saveTxt)
            {
                TxtSave a = new TxtSave(drv_tableModel,car_tableModel,ride_tableModel,srv_tableModel);

            }

            if (e.getSource()==saveAll)
            {
                new HtmlSaveDrv(drv_tableModel);
                new HtmlSaveSrv(srv_tableModel);
                new HtmlSaveRide(ride_tableModel);
                new HtmlSaveCar(car_tableModel);

            }

            if (e.getSource() == getDriversMoney)
            {
                String name = JOptionPane.showInputDialog("Введите id водителя");
                int id;
                try
                {
                    id = Integer.parseInt(name);
                }
                catch (NumberFormatException ex)
                {
                    ex.getStackTrace();
                    JOptionPane.showMessageDialog(null,"id should be INTEGER");
                    return;
                }
                try
                {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT [dbo].[GetDriversMoney] (\n" +
                            "   "+id+" ) AS total");

                    float total = 0;
                    while(rs.next())
                    {
                        total = rs.getFloat("total");
                    }

                    JOptionPane.showMessageDialog(null,"Driver "+id+"'s total Money = "+total);

                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }


            }

        }
    }




}
