/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author sarin
 */
public class Serie {

    private int idSerie;
    private String titulo;
    private int anoLancamento;
    private String nomeAtor;
    private String nacionalidade;
    private String genero;
    private int temporada;
    private int episodio;
    private String caminhoImagem;
    private Usuario idUsuario;

    public Serie() {
    }

    public Serie(int idSerie, String titulo, int anoLancamento, String nomeAtor, String nacionalidade, String genero, int temporada, int episodio, String caminhoImagem, Usuario idUsuario) {
        this.idSerie = idSerie;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.nomeAtor = nomeAtor;
        this.nacionalidade = nacionalidade;
        this.genero = genero;
        this.temporada = temporada;
        this.episodio = episodio;
        this.caminhoImagem = caminhoImagem;
        this.idUsuario = idUsuario;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getNomeAtor() {
        return nomeAtor;
    }

    public void setNomeAtor(String nomeAtor) {
        this.nomeAtor = nomeAtor;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getEpisodio() {
        return episodio;
    }

    public void setEpisodio(int episodio) {
        this.episodio = episodio;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
                return "---" + "\nCaminho da Imagem: \t" + caminhoImagem + "\nTitulo: \t\t" + titulo + "\nAno de Lançamento: \t" + anoLancamento + "\nAtor: \t\t\t" + nomeAtor + "\nNacionalidade: \t\t" + nacionalidade + "\nGênero: \t\t" + genero + "\nTemporada: \t\t" + temporada + "\nEpisódio: \t\t" + episodio + "\nidUsuario: \t\t" + idUsuario;
    }

}
