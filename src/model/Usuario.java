/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sarin
 */
public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String email;
    private String senha;
    private String confirmaSenha;
    private String novaSenha;
    private String confirmaNovaSenha;
    

    public Usuario() {
    }

    public Usuario(int idUsuario, String nomeUsuario, String email, String senha, String confirmaSenha, String novaSenha, String confirmaNovaSenha) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
        this.novaSenha = novaSenha;
        this.confirmaNovaSenha = confirmaNovaSenha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getConfirmaNovaSenha() {
        return confirmaNovaSenha;
    }

    public void setConfirmaNovaSenha(String confirmaNovaSenha) {
        this.confirmaNovaSenha = confirmaNovaSenha;
    }

    @Override
    public String toString() {
                return                                                   "Nome do usuário = " + nomeUsuario + ", E-mail = " + email + ", Senha = " + senha + " Confirma senha = " + confirmaSenha + ",| Nova senha=" + novaSenha + " Confirmar nova senha=" + confirmaNovaSenha; 
    }
       
}

