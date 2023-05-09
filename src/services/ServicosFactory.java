/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author sarin
 */
public class ServicosFactory {

    public static UsuarioServicos usuServicos = new UsuarioServicos();

    public static UsuarioServicos getUsuarioServicos() {
        return usuServicos;
    }

    public static SerieServicos sServicos = new SerieServicos();

    public static SerieServicos getSerieServicos() {
        return sServicos;
    }

    public static FilmeServicos filmServicos = new FilmeServicos();

    public static FilmeServicos getFilmeServicos() {
        return filmServicos;
    }
}
