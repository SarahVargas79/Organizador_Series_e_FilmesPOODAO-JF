/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sarin
 */
public class Conexao {

    //Cria uma constante com endereço do BD/Schema
    private static String url = "jdbc:mysql://localhost:3306/organizador_series_e_filmes";

    //Cria uma constante um user do BD
    private static String user = "root";

    //Cria uma constante com a senha do BD
    private static String pass = "";

    public static Connection getConexao() throws SQLException {
        //Inicia a conexão nula, ainda não estabelecida.
        Connection c = null;
        //tenta estabelecer conexão
        try {
            c = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            //caso haja erron na conexão do banco 
            throw new SQLException("Erro ao conectar banco!\n" + e.getMessage());
        }
        return c;
    }
}
