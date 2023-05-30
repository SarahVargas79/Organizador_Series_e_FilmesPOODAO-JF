/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Filme;
import services.ServicosFactory;
import services.UsuarioServicos;

/**
 *
 * @author sarin
 */
public class FilmeDAO {

    public void cadastrarFilmeDAO(Filme filmVO) {

        try {
            //busca conexão com o BD
            Connection con = Conexao.getConexao();//abrindo conexão
            //cria espaço de trabalho SQL, é a área no Java onde vamo executar os sripts SQL.
            String sql;
            sql = "insert into filmes values (null, ?, ?, ?, ?, ?, ?, ?, ?)";//? paramêtros que está esperando para receber, null é o id.
            PreparedStatement pst = con.prepareStatement(sql);
            //Estes são os paramêtros
            pst.setString(1, filmVO.getCaminhoImagem());
            pst.setString(3, filmVO.getTitulo());
            pst.setInt(4, filmVO.getAnoLancamento());
            pst.setString(5, filmVO.getNomeAtor());
            pst.setString(7, filmVO.getNacionalidade());
            pst.setString(2, filmVO.getGenero());
            pst.setFloat(6, filmVO.getDuracaoEspera());
            pst.setInt(8, filmVO.getIdUsuario().getIdUsuario());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("\nErro ao cadastrar!\n" + ex.getMessage());
        }
    }//fim cadastrar

    public ArrayList<Filme> getFilmesDAO() {
        ArrayList<Filme> filmes = new ArrayList<>();
        try {//Para tratar erros
            Connection con = Conexao.getConexao();
            String sql = "select filmes.*, e.email from filmes join usuarios e using(idUsuario)";//' para executar para o banco(mysql)
            Statement stm = con.createStatement();
            UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
            ResultSet rs = stm.executeQuery(sql);//ResultSet estrutura no java, é um meio de campo entre o banco de dados e o java(aplicação).
            while (rs.next()) {
                Filme film = new Filme();//objeto cliente
                //lado do java |x| (lado do banco)
                film.setIdFilme(rs.getByte("idFilme"));
                film.setCaminhoImagem(rs.getString("caminhoImagem"));
                film.setGenero(rs.getString("genero"));
                film.setTitulo(rs.getString("titulo"));
                film.setAnoLancamento(rs.getInt("anoLancamento"));
                film.setNomeAtor(rs.getString("nomeAtor"));
                film.setDuracaoEspera(rs.getInt("duracaoEspera"));
                film.setNacionalidade(rs.getString("nacionalidade"));
                film.setIdUsuario(usuarioS.buscarUsuariobyEmail(rs.getString("email")));
                filmes.add(film);
            }
        } catch (SQLException ex) {
            System.out.println("\nErro ao listar filmes!\n" + ex.getMessage());
        }
        return filmes;
    }//fim listar

    public Filme getFilmeByTitulo(String titulo) {
        UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
        Filme film = new Filme();
        try {//Para tratar erros
            Connection con = Conexao.getConexao();
            String sql = "select filmes.*, e.email from filmes join usuarios e using(idUsuario) where titulo = ?";//' para executar para o banco(mysql)
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, titulo);
            ResultSet rs = pst.executeQuery();//ResultSet estrutura no java, é um meio de campo entre o banco de dados e o java(aplicação).
            while (rs.next()) {
                //lado do java |x| (lado do banco)
                film.setIdFilme(rs.getByte("idFilme"));
                film.setCaminhoImagem(rs.getString("caminhoImagem"));
                film.setGenero(rs.getString("genero"));
                film.setTitulo(rs.getString("titulo"));
                film.setAnoLancamento(rs.getInt("anoLancamento"));
                film.setNomeAtor(rs.getString("nomeAtor"));
                film.setDuracaoEspera(rs.getInt("duracaoEspera"));
                film.setNacionalidade(rs.getString("nacionalidade"));
                film.setIdUsuario(usuarioS.buscarUsuariobyEmail(rs.getString("email")));
            }
        } catch (SQLException ex) {
            System.out.println("\nErro ao buscar filme!\n" + ex.getMessage());
        }
        return film;
    }

    public void atualizaFilmeByDoc(Filme filmVO) {

        try {
            Connection con = Conexao.getConexao();
            String sql = "update filmes set caminhoImagem = ?, duracaoEspera = ? where titulo = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, filmVO.getCaminhoImagem());
            pst.setFloat(2, filmVO.getDuracaoEspera());
            pst.setString(3, filmVO.getTitulo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("\nErro ao atualizar filme!\n" + ex.getMessage());
        }
    }//fim atualizaFilme

    public void removerFilmeDAO(String titulo) {

        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from filmes where titulo = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, titulo);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("\nErro ao remover filme!\n" + ex.getMessage());
        }
    }//fim removerFilme
}
