/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.*;
import DAOdataperpus.dataperpusDAO;
import model.modeltabeldataperpus;
import view.MainView;
import DAOImplement.dataperpusimplement;
import model.dataperpus;

/**
 *
 * @author Lab Informatika
 */
public class dataperpuscontroller{
    MainView frame;
    dataperpusimplement impldataperpus;
    List<dataperpus> dp;
    
    public dataperpuscontroller(MainView frame){
        this.frame=frame;
        impldataperpus = new dataperpusDAO();
        dp = impldataperpus.getAll();
    }

    public void isitabel(){
        dp = impldataperpus.getAll();
        modeltabeldataperpus mp = new modeltabeldataperpus(dp);
        frame.getjTable1().setModel(mp);
    }
    
    public void insert(){
        dataperpus dp = new dataperpus();
        dp.setJudul(frame.getjTextField2().getText());
        dp.setGenre(frame.getjTextField3().getText());
        dp.setPenulis(frame.getjTextField4().getText());
        dp.setPenerbit(frame.getjTextField5().getText());
        dp.setLokasi(frame.getjTextField6().getText());
        dp.setStock(frame.getjTextField7().getText());
        impldataperpus.insert(dp);
    }
    public void update(){
        dataperpus dp = new dataperpus();
        dp.setJudul(frame.getjTextField2().getText());
        dp.setGenre(frame.getjTextField3().getText());
        dp.setPenulis(frame.getjTextField4().getText());
        dp.setPenerbit(frame.getjTextField5().getText());
        dp.setLokasi(frame.getjTextField6().getText());
        dp.setStock(frame.getjTextField7().getText());
        dp.setId(frame.getjTextField1().getText());
        impldataperpus.insert(dp);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getjTextField1().getText());
        impldataperpus.delete(id);
    }
    
    
}
