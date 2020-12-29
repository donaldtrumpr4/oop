package Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class TxtSave extends JFrame {
    public TxtSave(DefaultTableModel table1,DefaultTableModel table2,DefaultTableModel table3,DefaultTableModel table4){
        FileDialog sava = new FileDialog(this,"Сохранить как",FileDialog.SAVE);
        sava.setFile("*.txt");// Установка начального каталога
        sava.setVisible(true);
        //Определяем имя каталога или файла
        String fileNameSave = sava.getDirectory() + sava.getFile();
        if(fileNameSave == null) return; // Пользователь нажал отмена
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameSave));
            writer.write("Drivers:\n\n\n\n");
            for(int i = 0; i < table1.getRowCount(); i++){
                writer.write("\r\n");
                for(int j = 0; j < table1.getColumnCount(); j++){
                    if (table1.getValueAt(i, j)!=null)
                        writer.write((String) table1.getValueAt(i, j));
                    else
                        writer.write("   ");

                    if(j<table1.getColumnCount()) writer.write("|");
                }
            }
            writer.write("\n\nCars:\n\n\n\n");
            for(int i = 0; i < table2.getRowCount(); i++){
                writer.write("\r\n");
                for(int j = 0; j < table2.getColumnCount(); j++){
                    if (table2.getValueAt(i, j)!=null)
                        writer.write((String) table2.getValueAt(i, j));
                    else
                        writer.write("   ");

                    if(j<table2.getColumnCount()) writer.write("|");
                }
            }
            writer.write("\n\nRides:\n\n\n\n");
            for(int i = 0; i < table3.getRowCount(); i++){
                writer.write("\r\n");
                for(int j = 0; j < table3.getColumnCount(); j++){
                    if (table3.getValueAt(i, j)!=null)
                        writer.write((String) table3.getValueAt(i, j));
                    else
                        writer.write("   ");

                    if(j<table3.getColumnCount()) writer.write("|");
                }
            }
            writer.write("\n\nService:\n\n\n\n");
            for(int i = 0; i < table4.getRowCount(); i++){
                writer.write("\r\n");
                for(int j = 0; j < table4.getColumnCount(); j++){
                    if (table4.getValueAt(i, j)!=null)
                        writer.write((String) table4.getValueAt(i, j));
                    else
                        writer.write("   ");

                    if(j<table4.getColumnCount()) writer.write("|");
                }
            }
            writer.close();
            dispose();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}