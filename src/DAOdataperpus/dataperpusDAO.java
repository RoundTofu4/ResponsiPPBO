/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataperpus;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.dataperpusimplement;
/**
 *
 * @author Lab Informatika
 */
public class dataperpusDAO implements dataperpusimplement{
    Connection connection;
    final String select = "select * from dataperpus";
    final String insert = "INSERT INTO dataperpus(`judul`, `genre`, `penulis`, `penerbit`, `lokasi`, `stock`) VALUES (?, ?, ?, ?, ?, ?)";
    final String update = "update dataperpus SET `judul` = '?', `genre` = '?', `penulis` = '?', `penerbit` = '?', `lokasi` = '?', `stock` = '?' WHERE `dataperpus`.`id` = ?";
    final String delete = "delete from dataperpus where id=?";
    final String search = "select * from dataperpus where ? = ?";
    
    
    public dataperpusDAO(){connection = connector.connection();}
    
    @Override
    public void insert(dataperpus p) {
        PreparedStatement statement = null;
        try{
        statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, p.getJudul());
        statement.setString(2, p.getGenre());
        statement.setString(3, p.getPenulis());
        statement.setString(4, p.getPenerbit());
        statement.setString(5, p.getLokasi());
        statement.setString(6, p.getStock());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        while(rs.next()){p.setId(Integer.toString(rs.getInt(1)));}
        }
        catch(SQLException e){e.printStackTrace();}
        finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(dataperpus p) {
        PreparedStatement statement = null;
       try{
        connection.prepareStatement(update);
        statement.setString(1, p.getJudul());
        statement.setString(2, p.getGenre());
        statement.setString(3, p.getPenulis());
        statement.setString(4, p.getPenerbit());
        statement.setString(5, p.getLokasi());
        statement.setString(6, p.getStock());
        statement.setString(7, p.getId());
       }
       catch(SQLException e){
                e.printStackTrace();
       }finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch(SQLException e){
                e.printStackTrace();
        }finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void search(String p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(search);
            statement.setString(1, p);
            statement.executeUpdate();
        }
        catch(SQLException e){
                e.printStackTrace();
        }finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<dataperpus> getAll() {
        List<dataperpus> dp = null;
        try{
        dp = new ArrayList<dataperpus>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(select);
            while(rs.next()){
            dataperpus hp = new dataperpus();
            hp.setId(Integer.toString(rs.getInt("id")));
            hp.setJudul(rs.getString("judul"));
            hp.setGenre(rs.getString("genre"));
            hp.setPenulis(rs.getString("penulis"));
            hp.setPenerbit(rs.getString("penerbit"));
            hp.setLokasi(rs.getString("lokasi"));
            hp.setStock(Integer.toString(rs.getInt("stock")));
            }
        }
        catch(SQLException e){}
        return dp;
    }
    
    
}
