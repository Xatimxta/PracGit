/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author RenzoHypeBeast
 */
public class RankingUsuarioAmigosTO {
    private String username;
    private int nAmigos;

    public RankingUsuarioAmigosTO(String username, int nAmigos) {
        this.username = username;
        this.nAmigos = nAmigos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getnAmigos() {
        return nAmigos;
    }

    public void setnAmigos(int nAmigos) {
        this.nAmigos = nAmigos;
    }

    @Override
    public String toString() {
        return "RankingUsuarioAmigosTO{" + "username=" + username + ", nAmigos=" + nAmigos + '}';
    }
    
    
}
