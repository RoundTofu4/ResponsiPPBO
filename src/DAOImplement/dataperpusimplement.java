/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;

import java.util.List;
import model.dataperpus;

/**
 *
 * @author Lab Informatika
 */
public interface dataperpusimplement {
    public void insert (dataperpus p);
    public void update (dataperpus p);
    public void delete (int id);
    public void search (String p);
    public List<dataperpus> getAll();
}
