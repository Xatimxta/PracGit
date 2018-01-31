/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomcrossing;

import dao.CrossingDAO;
import excepciones.ExcepcionCrossing;
import java.sql.SQLException;
import java.util.List;
import modelo.User;
import modelo.Character;
import modelo.Inventory;
import modelo.Item;
import modelo.RankingUsuarioAmigosTO;
import modelo.RankingUsuarioTO;


/**
 *
 * @author RenzoHypeBeast
 */
public class StucomCrossing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CrossingDAO crossingDAO = new CrossingDAO();
        CrossingDAO crossingDAO = new CrossingDAO();
        
        // TEst
        
        User u1 = new User("Xatimxta","123456789","Yzymafia");
        Character c1 = new Character("Hypebeast","Estudiodecalle","London","Ropalimited");
        Item i1 = new Item("PackPlox", 50, 25.5, "Oshe", "Hype");
        
        try {
            // Conecto
            crossingDAO.conectar();
            System.out.println("Conexion extablecida");
            System.out.println("Registrando usuario " + u1.getUsername());
            RegisterOfUser(crossingDAO, u1);
            System.out.println("************************************************************");
            System.out.println("Obtener usuario por Username");
            UserByUsername(crossingDAO, "Xatimxta");
            System.out.println("************************************************************");
            System.out.println("Registrando personaje " + c1.getName());
            RegisterOfCharacter(crossingDAO, c1);
            System.out.println("************************************************************");
            System.out.println("Registrando Item " + i1.getName());
            RegisterOfItem(crossingDAO, i1);
            System.out.println("************************************************************");
            System.out.println("Validando el login del usuario " + u1.getUsername());
            System.out.println("************************************************************");
            System.out.println("Modificar el perfil del usuario (level) " + u1.getUsername());
            u1.setLevel(5);
            ModificarUsuario(crossingDAO, u1);
            System.out.println("************************************************************");
            System.out.println("Modificar el lugar del usuario " + u1.getUsername());
            u1.setPlace("NewPlace");
            ModificarLugarUsuario(crossingDAO, u1); 
            System.out.println("************************************************************");
            System.out.println("Modificar el lugar del personaje " + c1.getName());
            c1.setPlace("NewPlaceCharacter");
            ModificarLugarPersonaje(crossingDAO, c1);
            System.out.println("************************************************************");
            System.out.println("Modificar el precio del item " + i1.getName());
            i1.setPrice(30);
            ModificarPrecioItem(crossingDAO, i1);
            System.out.println("************************************************************");
            System.out.println("Obtener los personajes que estan en el mismo lugar que " + u1.getUsername());
//            System.out.println("************************************************************");
//            System.out.println("Comprando un objeto el usuario " + u1.getUsername());
//            System.out.println("************************************************************");
//            System.out.println("Dando un objeto el usuario " + u1.getUsername()+ " al personaje " + c1.getName());
//            System.out.println("************************************************************");
//            System.out.println("Obteniendo el inventario del usuario " + u1.getUsername() + " Con su cantidad");
//            InventoryByUsername(crossingDAO,"Xatimxta");
//            System.out.println("************************************************************");
//            System.out.println("Obteniendo la lista de amigos del usuario " + u1.getUsername());
//            System.out.println("************************************************************");
//            System.out.println("Listando los objetos que no tiene el usuario" + u1.getUsername());
//            List<Item> items;
//            items = crossingDAO.selectAllItems();
//            System.out.println("Listado de objetos que no tiene");
//            for (Item x : items){
//                System.out.println(x);
//            }
            System.out.println("************************************************************");
            System.out.println("Obteniendo el ranking de los 10 mejores usuarios");
            List<RankingUsuarioTO> ranking = crossingDAO.rankingMejoresUsuarios();
            for (RankingUsuarioTO r : ranking){
                System.out.println(r);
            }
//            System.out.println("************************************************************");
//            System.out.println("Obteniendo el ranking de los usuarios con mas amigos");
//            List<RankingUsuarioAmigosTO> rk = crossingDAO.rankingMejoresUsuariosAmigos();
//            for (RankingUsuarioAmigosTO r : rk){
//                System.out.println(r);
//            }
            
//            System.out.println("************************************************************");
//            System.out.println("Obteniendo el listado de personajes que desconoce el usuario" + u1.getUsername());
            
            
            
            
            System.out.println("************************************************************");
            System.out.println("Cerrando conexion");
            crossingDAO.desconectar();
            ModificarPrecioItem(crossingDAO, i1);
            System.out.println("Conexion cerrada");
            
            
            
            
        }catch (SQLException ex){
            System.out.println("Error SQL" + ex.getMessage());
        }     
    }
    
    // --------------------- USUARIO ------------------------
    
    // Metodo para registrar usuario llamando el Insert del DAO
    private static void RegisterOfUser(CrossingDAO crossingDAO,User u) throws SQLException{
        try{
            crossingDAO.InsertUSer(u);
            System.out.println("Usuario registrado !");
        }catch(ExcepcionCrossing ex){
            System.out.println(ex.getMessage());
        } 
    }
   
    
    private static void UserByUsername(CrossingDAO crossingDAO, String username) throws SQLException{
        User aux;
        try {
            aux = crossingDAO.getUserByUsername(username);
            System.out.println(aux);
        }catch(ExcepcionCrossing ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    private static void Loginuser(User u, String pass)throws SQLException{
        
    }
 
    
    
    private static void ModificarUsuario(CrossingDAO crossingDAO, User u) throws SQLException {
        try{
            crossingDAO.ModificarPerfilUsuario(u);
            System.out.println("Level modificado.");
            System.out.println("Obteniendo datos de la BBDD del Usuario" + u.getUsername() + "para verificar la modificación del level");
            User aux = crossingDAO.getUserByUsername(u.getUsername());
            System.out.println("Nuevo perfil modificado (Level)");
            System.out.println(aux);
            
        }catch(ExcepcionCrossing ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    private static void ModificarLugarUsuario(CrossingDAO crossingDAO, User u) throws SQLException {
        try{
            crossingDAO.ModificarLugar(u);
            System.out.println("Lugar modificado.");
            System.out.println("Obteniendo datos de la BBDD del Usuario" + u.getUsername() + "para verificar la modificación del lugar");
            User aux = crossingDAO.getUserByUsername(u.getUsername());
            System.out.println("Nuevolugar modificado");
            System.out.println(aux);
            
        }catch(ExcepcionCrossing ex){
            System.out.println(ex.getMessage());
        }
         
    }
    
    
    // --------------------- PERSONAJE ------------------------

    private static void RegisterOfCharacter(CrossingDAO crossingDAO,Character c) throws SQLException{
        try{
            crossingDAO.InsertCharacter(c);
            System.out.println("Personaje registrado !");
        }catch(ExcepcionCrossing ex){
            System.out.println(ex.getMessage());
        } 
    }
    private static void ModificarLugarPersonaje(CrossingDAO crossingDAO, Character c) throws SQLException {
        try{
            crossingDAO.ModificarLugarP(c);
            System.out.println("Lugar modificado.");
            System.out.println("Obteniendo datos de la BBDD del Usuario" + c.getName() + "para verificar la modificación del lugar");
            Character aux = crossingDAO.getCharacterByName(c.getName());
            System.out.println("Nuevo lugar modificado");
            System.out.println(aux);
            
        }catch(ExcepcionCrossing ex){
            System.out.println(ex.getMessage());
        } 
    }

    
    
    // --------------------- ITEM ------------------------
    private static void RegisterOfItem(CrossingDAO crossingDAO,Item i) throws SQLException{
        try{
            crossingDAO.InsertItem(i);
            System.out.println("Item registrado !");
        }catch(ExcepcionCrossing ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    private static void ModificarPrecioItem(CrossingDAO crossingDAO, Item i) throws SQLException {
        try{
            crossingDAO.ModificarPrecio(i);
            System.out.println("Precio modificado");
            System.out.println("Obteniendo datos de la BBDD del Item" + i.getName() + "para verificar la modificación del precio");
            Item aux = crossingDAO.getItemByName(i.getName());
            System.out.println("Nuevo precio modificado");
            System.out.println(aux);
            
        }catch(ExcepcionCrossing ex){
            System.out.println(ex.getMessage());
        } 
    }

     // --------------------- INVENTORY ------------------------
    
       
    private static void InventoryByUsername(CrossingDAO crossingDAO, String username) throws SQLException{
        Inventory aux;
        try {
            aux = crossingDAO.getInventoryByUser(username);
            System.out.println(aux);
        }catch(ExcepcionCrossing ex){
            System.out.println(ex.getMessage());
        } 
    }
    
}
