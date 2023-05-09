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
import model.Serie;
import services.ServicosFactory;
import services.UsuarioServicos;

/**
 *
 * @author sarin
 */
public class SerieDAO {

    public void cadastrarSerieDAO(Serie sVO) {

        try {
            //busca conexão com o BD
            Connection con = Conexao.getConexao();//abrindo conexão
            //cria espaço de trabalho SQL, é a área no Java onde vamo executar os sripts SQL.
            String sql;
            sql = "insert into series values (null, ?, ?, ?, ?, ?, ?, ?, ?)";//? paramêtros que está esperando para receber, null é o id.
            PreparedStatement pst = con.prepareStatement(sql);
            //Estes são os paramêtros
            pst.setString(1, sVO.getTitulo());
            pst.setInt(2, sVO.getAnoLancamento());
            pst.setString(4, sVO.getNomeAtor());
            pst.setString(7, sVO.getNacionalidade());
            pst.setString(3, sVO.getGenero());
            pst.setInt(6, sVO.getTemporada());
            pst.setInt(5, sVO.getEpisodio());
            pst.setInt(8, sVO.getIdUsuario().getIdUsuario());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("\nErro ao cadastrar!\n" + ex.getMessage());
        }
    }//fim cadastrar

    public ArrayList<Serie> getSeriesDAO() {
        ArrayList<Serie> series = new ArrayList<>();
        try {//Para tratar erros
            Connection con = Conexao.getConexao();
            String sql = "select series.*, e.email from series join usuarios e using(idUsuario)";//' para executar para o banco(mysql)
            Statement stm = con.createStatement();
            UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
            ResultSet rs = stm.executeQuery(sql);//ResultSet estrutura no java, é um meio de campo entre o banco de dados e o java(aplicação).
            while (rs.next()) {
                Serie s = new Serie();//objeto cliente
                //lado do java |x| (lado do banco)
                s.setIdSerie(rs.getByte("idSerie"));
                s.setTitulo(rs.getString("titulo"));
                s.setAnoLancamento(rs.getInt("anoLancamento"));
                s.setGenero(rs.getString("genero"));
                s.setNomeAtor(rs.getString("nomeAtor"));
                s.setNacionalidade(rs.getString("nacionalidade"));
                s.setTemporada(rs.getInt("temporada"));
                s.setEpisodio(rs.getInt("episodio"));
                s.setIdUsuario(usuarioS.buscarUsuariobyEmail(rs.getString("email")));
                series.add(s);
            }
        } catch (SQLException ex) {
            System.out.println("\nErro ao listar séries!\n" + ex.getMessage());
        }
        return series;
    }//fim listar

    public Serie getSerieByTitulo(String titulo) {
        UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
        Serie s = new Serie();
        try {//Para tratar erros
            Connection con = Conexao.getConexao();
            String sql = "select series.*, e.email from series join usuarios e using(idUsuario) where titulo = ?";//' para executar para o banco(mysql)
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, titulo);
            ResultSet rs = pst.executeQuery();//ResultSet estrutura no java, é um meio de campo entre o banco de dados e o java(aplicação).
            while (rs.next()) {
                //lado do java |x| (lado do banco)
                s.setIdSerie(rs.getByte("idSerie"));
                s.setTitulo(rs.getString("titulo"));
                s.setAnoLancamento(rs.getInt("anoLancamento"));
                s.setGenero(rs.getString("genero"));
                s.setNomeAtor(rs.getString("nomeAtor"));
                s.setNacionalidade(rs.getString("nacionalidade"));
                s.setTemporada(rs.getInt("temporada"));
                s.setEpisodio(rs.getInt("episodio"));
                s.setIdUsuario(usuarioS.buscarUsuariobyEmail(rs.getString("email")));
            }
        } catch (SQLException ex) {
            System.out.println("\nErro ao buscar série!\n" + ex.getMessage());
        }
        return s;
    }

    public void atualizaSerieByDoc(Serie sVO) {

        try {
            Connection con = Conexao.getConexao();
            String sql = "update series set temporada = ? , episodio = ? where titulo = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, sVO.getTemporada());
            pst.setInt(2, sVO.getEpisodio());
            pst.setString(3, sVO.getTitulo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("\nErro ao atualizar série!\n" + ex.getMessage());
        }
    }//fim atualizaSerie

    public void removerSerieDAO(String titulo) {

        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from series where titulo = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, titulo);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("\nErro ao remover série!\n" + ex.getMessage());
        }
    }//fim removerSerie
}
