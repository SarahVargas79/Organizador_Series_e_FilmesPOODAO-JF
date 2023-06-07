/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author sarin
 */
public class UsuarioDAO {

    public static String geraSenha(String senha) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        MessageDigest mdMD5 = MessageDigest.getInstance("MD5");
        byte mdByteMD5[] = mdMD5.digest(senha.getBytes("UTF-8"));
        StringBuilder hexMDMD5 = new StringBuilder();
        for (byte b : mdByteMD5) {
            hexMDMD5.append(String.format("%02X", 0xFF & b));
        }
        String senhaMD5HashHex = hexMDMD5.toString();
        return senhaMD5HashHex;
    }

    public void cadastrarUsuarioDAO(Usuario usuVO) {

        try {
            //busca conexão com o BD
            Connection con = Conexao.getConexao();//abrindo conexão
            //cria espaço de trabalho SQL, é a área no Java onde vamo executar os sripts SQL.
            String sql;
            sql = "insert into usuarios values (null, ?, ?, ?, ?)";//? paramêtros que está esperando para receber, null é o id.
            PreparedStatement pst = con.prepareStatement(sql);
            //Estes são os paramêtros
            pst.setString(1, usuVO.getNomeUsuario());
            pst.setString(2, usuVO.getEmail());
            String pass = geraSenha(usuVO.getSenha());
            pst.setString(3, pass);
            String passC = geraSenha(usuVO.getConfirmaSenha());
            pst.setString(4, passC);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("\nErro ao cadastrar!\n" + ex.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//fim cadastrar

    public ArrayList<Usuario> getUsuariosDAO(String mail) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {//Para tratar erros
            Connection con = Conexao.getConexao();
            Statement stat = con.createStatement();
            String sql = "select * from usuarios where email = '" + mail + "'";//' para executar para o banco(mysql)
            ResultSet rs = stat.executeQuery(sql);//ResultSet estrutura no java, é um meio de campo entre o banco de dados e o java(aplicação).
            while (rs.next()) {
                Usuario usu = new Usuario();//objeto usuario
                //lado do java |x| (lado do banco)
                usu.setIdUsuario(rs.getByte("idUsuario"));
                usu.setNomeUsuario(rs.getString("nomeUsuario"));
                usu.setEmail(rs.getString("email"));
                usu.setSenha(rs.getString("senha"));
                usu.setConfirmaSenha(rs.getString("confirmarSenha"));
                usuarios.add(usu);
            }
        } catch (SQLException ex) {
            System.out.println("\nErro ao listar!\n" + ex.getMessage());
        }
        return usuarios;
    }//fim listar

    public Usuario getUsuarioByDoc(String email) {

        Usuario usu = new Usuario();
        try {
            Connection con = Conexao.getConexao();//estabelecendo conexão
            String sql = "select * from usuarios where email = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //lado do java |x| (lado do banco)
                usu.setIdUsuario(rs.getByte("idUsuario"));
                usu.setNomeUsuario(rs.getString("nomeUsuario"));
                usu.setEmail(rs.getString("email"));
                usu.setSenha(rs.getString("senha"));
                usu.setConfirmaSenha(rs.getString("confirmarSenha"));
            }
        } catch (SQLException ex) {
            System.out.println("\nErro ao consultar e-mail!\n" + ex.getMessage());
        }
        return usu;
    }

    public void atualizaUsuarioByDoc(Usuario usuVO) {

        try {
            Connection con = Conexao.getConexao();
            String sql = "update usuarios set nomeUsuario = ? , senha = ?, confirmarSenha = ? where email = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, usuVO.getNomeUsuario());
            pst.setString(2, usuVO.getSenha());
            pst.setString(3, usuVO.getConfirmaSenha());
            pst.setString(4, usuVO.getEmail());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("\nErro ao atualizar e-mail!\n" + ex.getMessage());
        }
    }//fim atualizaUsuario

    public void removerUsuarioDAO(String email) {

        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from usuarios where email = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("\nErro ao remover e-mail!\n" + ex.getMessage());
        }
    }//fim removerUsuario
}
