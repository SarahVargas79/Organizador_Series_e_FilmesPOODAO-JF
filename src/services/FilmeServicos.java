/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DAOFactory;
import dao.FilmeDAO;
import java.util.ArrayList;
import model.Filme;

/**
 *
 * @author sarin
 */
public class FilmeServicos {

    public void cadFilme(Filme filmVO) {//FilmeDAO - classe | filmDAO - objeto
        FilmeDAO filmDAO = DAOFactory.getFilmeDAO();
        filmDAO.cadastrarFilmeDAO(filmVO);
    }

    public ArrayList<Filme> buscaFilmes() {
        FilmeDAO filmDAO = DAOFactory.getFilmeDAO();
        return filmDAO.getFilmesDAO();
    }

    public Filme buscaFilmeTitulo(String titulo) {
        FilmeDAO filmDAO = DAOFactory.getFilmeDAO();
        return filmDAO.getFilmeByTitulo(titulo);
    }

    public void atualizarFilme(Filme filmVO) {
        FilmeDAO filmDAO = DAOFactory.getFilmeDAO();
        filmDAO.atualizaFilmeByDoc(filmVO);
    }

    public void removerFilme(String titulo) {
        FilmeDAO filmDAO = DAOFactory.getFilmeDAO();
        filmDAO.removerFilmeDAO(titulo);
    }
}
