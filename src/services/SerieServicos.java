/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DAOFactory;
import dao.SerieDAO;
import java.util.ArrayList;
import model.Serie;

/**
 *
 * @author sarin
 */
public class SerieServicos {

    public void cadSerie(Serie sVO) {//SerieDAO - classe | sDAO - objeto
        SerieDAO sDAO = DAOFactory.getSerieDAO();
        sDAO.cadastrarSerieDAO(sVO);
    }

    public ArrayList<Serie> buscaSeries() {
        SerieDAO sDAO = DAOFactory.getSerieDAO();
        return sDAO.getSeriesDAO();
    }

    public Serie buscaSerieTitulo(String titulo) {
        SerieDAO sDAO = DAOFactory.getSerieDAO();
        return sDAO.getSerieByTitulo(titulo);
    }

    public void atualizarSerie(Serie sVO) {
        SerieDAO sDAO = DAOFactory.getSerieDAO();
        sDAO.atualizaSerieByDoc(sVO);
    }

    public void removerSerie(String titulo) {
        SerieDAO sDAO = DAOFactory.getSerieDAO();
        sDAO.removerSerieDAO(titulo);
    }
}
