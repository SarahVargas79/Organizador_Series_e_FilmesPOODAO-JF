/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author sarin
 */
public class DAOFactory {
    
    private static UsuarioDAO usuDAO = new UsuarioDAO();
    
    public static UsuarioDAO getUsuarioDAO() {
        return usuDAO;
    }
    
    private static SerieDAO sDAO = new SerieDAO();
    
    public static SerieDAO getSerieDAO() {
        return sDAO;
    }
    
    private static  FilmeDAO filmDAO = new FilmeDAO();
    
    public static FilmeDAO getFilmeDAO() {
        return filmDAO;
    }
}
