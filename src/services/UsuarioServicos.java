/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DAOFactory;
import dao.UsuarioDAO;
import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author sarin
 */
public class UsuarioServicos {

    public void cadUsuario(Usuario usuVO) {
        UsuarioDAO usuDAO = DAOFactory.getUsuarioDAO();
        usuDAO.cadastrarUsuarioDAO(usuVO);
    }

    public void atualizarUsuario(Usuario usuVO) {
        UsuarioDAO usuDAO = DAOFactory.getUsuarioDAO();
        usuDAO.atualizaUsuarioByDoc(usuVO);
    }

    public Usuario buscarUsuariobyEmail(String email) {
        UsuarioDAO usuDAO = DAOFactory.getUsuarioDAO();
        return usuDAO.getUsuarioByDoc(email);
    }

    public void removerUsuario(String email) {
        UsuarioDAO usuDAO = DAOFactory.getUsuarioDAO();
        usuDAO.removerUsuarioDAO(email);
    }

    public ArrayList<Usuario> getUsuarios() {
        UsuarioDAO usuDAO = DAOFactory.getUsuarioDAO();
        return usuDAO.getUsuariosDAO();
    }
}
