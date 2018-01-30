/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import excepciones.ExcepcionCrossing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.User;
import modelo.Character;
import modelo.Inventory;
import modelo.Item;

/**
 *
 * @author RenzoHypeBeast
 */
public class CrossingDAO {
    Connection conexion;
    // Conexiones
    
    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/stucomcrossing";
        String user = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, user, pass);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
    
    // --------------------- USUARIO ------------------------
    
    // INSERTAR USUARIO
    
    public void InsertUSer(User u) throws SQLException, ExcepcionCrossing{
        if (ExistUser(u)){
            throw new ExcepcionCrossing("ERROR: Ya existe el usuario");
        }
        
        // Añadir si existe usuario -- >
        String insert = "insert into user values (?,?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
        ps.setInt(3, u.getStucoins());
        ps.setInt(4, u.getLevel());
        ps.setString(5, u.getPlace());
        ps.setInt(6,u.getPoints());
        ps.executeUpdate();
        ps.close();
    }
    
    
    // COMPROBACION SI USUARIO EXISTE
    
    private boolean ExistUser(User u) throws SQLException {
        String select = "select * from user where username='"+ u.getUsername() +"'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        boolean existe = false;
        if (rs.next()) {
            existe = true;
        }
        rs.close();
        st.close();
        return existe;
    }
    
    
    // COGER USUARIO POR USERNAME
    
    public User getUserByUsername(String username) throws SQLException, ExcepcionCrossing {
        User aux = new User(username);
        if (!ExistUser(aux)){
            throw new ExcepcionCrossing("ERROR No existe ningún usuario con este Username");
            
        }
        String select ="select * from user where username='" + username + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        User u = new User();
        if (rs.next()){
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setStucoins(rs.getInt("stucoins"));
            u.setLevel(rs.getInt("level"));
            u.setPlace(rs.getString("place"));
            u.setPoints(rs.getInt("points"));
        }
        rs.close();
        st.close();
        return u;
    }
    
     public void ModificarPerfilUsuario(User u) throws SQLException, ExcepcionCrossing{
        if (!ExistUser(u)){
            throw new ExcepcionCrossing("ERROR: No existe el usuario");
        }
        
        // Añadir si existe usuario -- >
        String update = "update user set level=? where username=?;";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setInt(1, u.getLevel());
        ps.setString(2, u.getUsername());
        ps.executeUpdate();
        ps.close();
    }
     
     public void ModificarLugar(User u) throws SQLException, ExcepcionCrossing{
        if (!ExistUser(u)){
            throw new ExcepcionCrossing("ERROR: No existe el usuario");
        }
        
        // Añadir si existe usuario -- >
        String update = "update user set place=? where username=?;";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setString(1, u.getPlace());
        ps.setString(2, u.getUsername());
        ps.executeUpdate();
        ps.close();
    }
    
    
    // --------------------- PERSONAJE ------------------------
    
    public void InsertCharacter(Character c) throws SQLException, ExcepcionCrossing{
        
        // Añadir si existe usuario -- >
        if (ExistCharacter(c)){
            throw new ExcepcionCrossing("ERROR: Ya existe el personaje");
        }
        String insert = "insert into stucomcrossing.character values (?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, c.getName());
        ps.setString(2, c.getStudy());
        ps.setString(3, c.getPlace());
        ps.setString(4, c.getPreference());
        ps.executeUpdate();
        ps.close();
    }
    
     private boolean ExistCharacter(Character c) throws SQLException {
        String select = "select * from stucomcrossing.character where name='"+ c.getName() +"'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        boolean existe = false;
        if (rs.next()) {
            existe = true;
        }
        rs.close();
        st.close();
        return existe;
    }
     
     public void ModificarLugarP(Character c) throws SQLException, ExcepcionCrossing {
      if (!ExistCharacter(c)){
            throw new ExcepcionCrossing("ERROR: No existe el personaje");
        }
        
        // Añadir si existe usuario -- >
        String update = "update stucomcrossing.character set place=? where name=?;";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setString(1, c.getPlace());
        ps.setString(2, c.getName());
        ps.executeUpdate();
        ps.close();
    }
     
     public Character getCharacterByName(String name) throws SQLException, ExcepcionCrossing {
        Character aux = new Character(name);
        if (!ExistCharacter(aux)){
            throw new ExcepcionCrossing("ERROR No existe ningún usuario con este Username");
            
        }
        String select ="select * from stucomcrossing.character where name='" + name + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        Character c = new Character();
        if (rs.next()){
            c.setName(rs.getString("name"));
            c.setStudy(rs.getString("study"));
            c.setPlace(rs.getString("place"));
            c.setPreference(rs.getString("preference"));
        }
        rs.close();
        st.close();
        return c;
    }
    
    // --------------------- ITEM ------------------------
    
    public void InsertItem(Item i) throws SQLException, ExcepcionCrossing{
        
        // Añadir si existe usuario -- >
        if (ExistItem(i)){
            throw new ExcepcionCrossing("ERROR: Ya existe el item");
        }
        String insert = "insert into item values (?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, i.getName());
        ps.setDouble(2, i.getPrice());
        ps.setDouble(3, i.getSaleprice());
        ps.setString(4, i.getType());
        ps.setString(5, i.getStyle());
        ps.executeUpdate();
        ps.close();
    }

    
     private boolean ExistItem(Item i) throws SQLException {
        String select = "select * from item where name='"+ i.getName() +"'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        boolean existe = false;
        if (rs.next()) {
            existe = true;
        }
        rs.close();
        st.close();
        return existe;
    }

    public void ModificarPrecio(Item i) throws SQLException, ExcepcionCrossing {
       if (!ExistItem(i)){
            throw new ExcepcionCrossing("ERROR: No existe el item");
        }
        
        // Añadir si existe usuario -- >
        String update = "update item set price=? where name=?;";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setDouble(1, i.getPrice());
        ps.setString(2, i.getName());
        ps.executeUpdate();
        ps.close();
    }
    
  
    
    public Item getItemByName(String name) throws SQLException, ExcepcionCrossing {
        Item aux = new Item(name);
        if (!ExistItem(aux)){
            throw new ExcepcionCrossing("ERROR No existe ningún item con este nombre");
            
        }
        String select ="select * from item where name='" + name + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        Item i = new Item();
        if (rs.next()){
            i.setName(rs.getString("name"));
            i.setPrice(rs.getDouble("study"));
            i.setSaleprice(rs.getDouble("place"));
            i.setType(rs.getString("preference"));
            i.setStyle(rs.getString("style"));
        }
        rs.close();
        st.close();
        return i;
    }
    
    // --------------------- INVENTORIO ------------------------

    public Inventory getInventoryByUser(String username) throws SQLException, ExcepcionCrossing {
        Inventory aux = new Inventory(username);
//        if (!ExistUser(aux)){
//            throw new ExcepcionCrossing("ERROR No existe ningún usuario con este Username");          
//        }
        String select ="select * from inventory where user='" + username + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        Inventory i = new Inventory();
        if (rs.next()){
            i.getItem(rs.getString("item"));
            i.getQuantity(rs.getInt("quantity"));
        }
        rs.close();
        st.close();
        return i;
    }
    
    


   
    

    
    

}
