/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizadorseriesfilmespoo;

import controller.CFilme;
import controller.CSerie;
import controller.CUsuario;
import java.util.Scanner;
import model.Filme;
import model.Serie;
import model.Usuario;
import services.FilmeServicos;
import services.SerieServicos;
import services.ServicosFactory;
import services.UsuarioServicos;
import util.Validadores;
import view.Login;
import view.MenuPrincipal;

/**
 *
 * @author sarin
 */
public class OrganizadorSeriesFilmesPOO {

    public static CUsuario cadUsuario = new CUsuario();
    public static CSerie cadSerie = new CSerie();
    public static CFilme cadFilme = new CFilme();
    public static Scanner leia = new Scanner(System.in);

    public static int leiaNumInt() {//Dois scanner para não crachar a aplicação.
        Scanner leiaNum = new Scanner(System.in);
        int num = 99; //valor inválido
        try {//try como um "TENTAR EXECUTAR UM TRECHO DE CÓDIGO", se não executar esse trecho vai se para o cath onde as chamadas exceções (erros) são tratadas, se não ele é ignorado.
            return leiaNum.nextInt();
        } catch (Exception e) {//O bloco try diz "que tal código pode gerar exceção(erro)" e o bloco catch faz o "tratamento  para essa exceção(erro)".
            System.out.println("Tente novamente!");
            leiaNumInt();
        }
        return num;
    }

    public static float leiaNumFloat() {//Dois scanner para não crachar a aplicação.
        Scanner leiaNum = new Scanner(System.in);
        float num = 99; //valor inválido
        try {//try como um "TENTAR EXECUTAR UM TRECHO DE CÓDIGO", se não executar esse trecho vai se para o cath onde as chamadas exceções (erros) são tratadas, se não ele é ignorado.
            num = leiaNum.nextFloat();
        } catch (Exception e) {//O bloco try diz "que tal código pode gerar exceção(erro)" e o bloco catch faz o "tratamento  para essa exceção(erro)".
            System.out.println("Tente novamente!");
            leiaNumFloat();
        }
        return num;
    }

    public static void menuP() {
        System.out.println("\n.:ORGANIZADOR DE SÉRIES E FILMES:.");
        System.out.println("1 - Ger. de Usuários");
        System.out.println("2 - Ger. de Series");
        System.out.println("3 - Ger. de Filmes");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma das opções: ");
    }

    public static void subMenu(int op) {
        String tpCad = null;
        switch (op) {
            case 1:
                tpCad = "Usuário";
                break;
            case 2:
                tpCad = "Série";
                break;
            case 3:
                tpCad = "Filme";
                break;
        }
        System.out.println("\n.:Ger." + tpCad + ":.");
        System.out.println("1 - Cadastrar " + tpCad);
        System.out.println("2 - Editar " + tpCad);
        System.out.println("3 - Listar " + tpCad + "s");
        System.out.println("4 - Deletar " + tpCad);
        System.out.println("0 - Voltar para o menu");
        System.out.print("Escolha uma das opções: ");
    }

    private static void cadastrarUsuario() {
        int idUsuario;
        String nomeUsuario;
        String email;
        String senha;
        String confirmSenha;

        UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();

        System.out.println("___ Cadastro de Usuário ___");

        boolean emailIs;
        int opEmail;
        do {
            System.out.print("\nInforme e-mali: ");
            email = leia.nextLine();
            emailIs = Validadores.isValidEmailAddressRegex(email);
            if (!emailIs) {
                System.out.println("\nE-mail inválido, \nDeseja tentar novamente? 1 - Sim | 2 - Não");
                opEmail = leiaNumInt();
                if (opEmail == 1) {
                    System.out.print("\nInforme e-mail: ");
                } else if (opEmail == 2) {
                    System.out.println("\nCadastro cancelado pelo usuário!");
                    return;
                }
            } else if (usuarioS.buscarUsuariobyEmail(email).getEmail() != null) {
                System.out.println("\nUsuário já cadastrado!");
                emailIs = false;
            }
        } while (!emailIs);
        System.out.print("\nInforme nome: ");
        nomeUsuario = leia.nextLine();
        System.out.print("\nSenha: ");
        senha = leia.nextLine();
        System.out.print("Confirmar senha:");
        confirmSenha = leia.nextLine();
        boolean forteSenha = false;
        int opSenha;
        do {

            forteSenha = Validadores.senhaForte(senha);
            if (!forteSenha) {
                System.out.println("\nSenha não corresponde aos critérios, \nDeseja tentar novamente? 1 - Sim | 2 - Não");
                opSenha = leiaNumInt();
                if (opSenha == 1) {
                    System.out.print("\nSenha: ");
                    senha = leia.nextLine();
                    System.out.print("Confirmar senha:");
                    confirmSenha = leia.nextLine();
                } else if (opSenha == 2) {
                    System.out.println("\nCadastro cancelado pelo usuário!");
                    return;
                }
            }
        } while (!forteSenha);
        idUsuario = cadUsuario.geraID();
        Usuario usu = new Usuario(idUsuario, nomeUsuario, email, senha, confirmSenha, senha, confirmSenha);
        cadUsuario.addUsuario(usu);
        usuarioS.cadUsuario(usu);
        System.out.println("\nUsuário cadastrado com sucesso!");

    }//fim cadastrar usuário

    private static void editarUsuario() {

        System.out.println("___ Editar Usuário ___");

        System.out.print("\nInforme e-mail: ");
        String email = leia.nextLine();
        if (Validadores.isValidEmailAddressRegex(email)) {
            Usuario usu = cadUsuario.getUsuarioEmail(email);
            if (usu != null) {
                System.out.println("1 - Nome:\t" + usu.getNomeUsuario());
                System.out.println("2 - E-mail:\t" + usu.getEmail());
                System.out.println("3 - Senha:\t" + usu.getSenha());
                System.out.println("4 - Alterar todos os campos acima?");
                System.out.println("0 - Cancelar");
                System.out.print("\nQual campo deseja alterar? \nDigite aqui sua opção: ");
                int opEditar = leiaNumInt();

                if (opEditar == 1 || opEditar == 4) {// "||" pipe significa "ou"
                    System.out.print("\nInforme nome: ");
                    usu.setNomeUsuario(leia.nextLine());
                }
                if (opEditar == 2 || opEditar == 4) {
                    System.out.print("\nInforme e-mail: ");
                    usu.setEmail(leia.nextLine());
                }
                if (opEditar == 3 || opEditar == 4) {
                    System.out.print("\nDigite senha: ");
                    usu.setSenha(leia.nextLine());
                }
                if (opEditar == 0) {
                    System.out.println("\nOperação cancelada");
                    return;
                }
                UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
                usuarioS.atualizarUsuario(usu);

                System.out.println("\nUsuário:\n" + usu.toString());
            } else {
                System.out.println("\nUsuário não cadastrado!");
            }
        } else {
            System.out.println("\nE-mail inválido!");
        }
    }//fim editar usuário 

    private static void listaUsuarios() {

        System.out.println("___ Lista de Usuário ___");

        UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
        for (Usuario usu : usuarioS.getUsuarios(MenuPrincipal.emailLogado)) {
            System.out.println("\n---");
            System.out.println("Nome:\t" + usu.getNomeUsuario());//\t faz tabulação
            System.out.println("E-mail:\t" + usu.getEmail());
            System.out.println("Senha:\t" + usu.getSenha());
        }
    }//fim imprimir lista de usuários

    private static void removerUsuario() {

        System.out.println("___ Remover Usuário ___");

        System.out.print("\nInforme e-mail: ");
        String email = leia.next();
        UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();
        if (Validadores.isValidEmailAddressRegex(email)) {
            Usuario usu = usuarioS.buscarUsuariobyEmail(email);
            if (usu.getEmail() != null) {
                //cadUsuario.removeUsuario(usu);
                System.out.println("\nConfirma remover usuário? 1 - Sim | 2 - Não");
                int opRemove = leiaNumInt();
                if (opRemove == 1) {
                    usuarioS.removerUsuario(email);
                    System.out.println("\nUsuário removido com sucesso!");
                } else if (opRemove == 2) {
                    System.out.println("\nRemoção cancelada!");
                }
            } else {
                System.out.println("\nUsuário não encontrado!");
            }
        } else {
            System.out.println("\nE-mail inválido!");
        }
    }//fim remover usuário

    private static void cadastrarSerie() {
        int idSerie;
        String titulo;
        int anoLancamento;
        String nomeAtor;
        String nacionalidade;
        String genero;
        int temporada;
        int episodio;
        SerieServicos serieS = ServicosFactory.getSerieServicos();
        UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();

        System.out.println("___ Cadastro de Série ___");

        System.out.print("\nInforme o título: ");
        titulo = leia.nextLine();
        if (serieS.buscaSerieTitulo(titulo).getTitulo() != null) {
            System.out.println("\nSérie já cadastrada!");
        } else {
            idSerie = cadSerie.geraID();
            System.out.print("\nInforme o ano de lançamento: ");
            anoLancamento = leiaNumInt();
            System.out.print("\nInforme o nome do ator: ");
            nomeAtor = leia.nextLine();
            System.out.print("\nInforme a nacionalidade: ");
            nacionalidade = leia.nextLine();
            System.out.print("\nInforme o gênero: ");
            genero = leia.nextLine();
            System.out.print("\nInforme a temporada: ");
            temporada = leiaNumInt();
            System.out.print("\nInforme o episódio: ");
            episodio = leiaNumInt();
            boolean isValidEmailAddressRegex = false;
            Usuario idUsuario = null;
            do {
                System.out.print("\nInforme E-mail: ");
                String email = leia.nextLine();
                isValidEmailAddressRegex = Validadores.isValidEmailAddressRegex(email);
                if (isValidEmailAddressRegex) {
                    idUsuario = usuarioS.buscarUsuariobyEmail(email);
                    if (idUsuario.getEmail() == null) {
                        System.out.println("\nUsuário não cadastrado");
                        isValidEmailAddressRegex = false;
                    } else {
                        System.out.println("\nUsuário: " + idUsuario.getNomeUsuario());
                    }
                } else {
                    System.out.println("\nE-mail inválido!");
                }
            } while (!isValidEmailAddressRegex);
            Serie s = new Serie(idSerie, titulo, anoLancamento, nomeAtor, nacionalidade, genero, temporada, episodio, nacionalidade, idUsuario);
            serieS.cadSerie(s);
            cadSerie.addSerie(s);
            System.out.println("\nSerie cadastrado com sucesso!");
        }
    }//fim cadastrar série

    private static void editarSerie() {

        System.out.println("___ Editar Série ___");

        System.out.print("\nInforme o título: ");
        String titulo = leia.nextLine();
        SerieServicos serieS = ServicosFactory.getSerieServicos();
        Serie s = serieS.buscaSerieTitulo(titulo);
        if (s.getTitulo() != null) {
            System.out.println("\nSérie selecionada: " + s.getTitulo());
            System.out.println("O que deseja alterar: ");
            System.out.println("1 - Temporada: \t" + s.getTemporada());
            System.out.println("2 - Episódio: \t" + s.getEpisodio());
            System.out.println("3 - Todos os campos acima? ");
            System.out.println("0 - Cancelar");
            System.out.print("\nDigite aqui sua opção: ");
            int opEditar = leiaNumInt();
            if (opEditar == 1 || opEditar == 3) {
                System.out.println("\nTemporada atual: \t" + s.getTemporada());
                System.out.print("\nInforme a nova temporada: ");
                s.setTemporada(leiaNumInt());
            }
            if (opEditar == 2 || opEditar == 3) {
                System.out.println("\nEpisódio atual: \t" + s.getEpisodio());
                System.out.print("\nInforme o novo episódio: ");
                s.setEpisodio(leiaNumInt());
            }
            if (opEditar == 0) {
                System.out.println("\nOperação cancelada\n");
                return;
            }
            serieS.atualizarSerie(s);
            System.out.println("\nSérie editada:\n" + s.toString());
        } else {
            System.out.println("\nTítulo inválido!");
        }
    }

    private static void listaSeries() {

        System.out.println("___ Lista de Séries ___");
        System.out.println("\n");
        SerieServicos serieS = ServicosFactory.getSerieServicos();
        if (!serieS.buscaSeries(MenuPrincipal.emailLogado).isEmpty()) {
            for (Serie s : serieS.buscaSeries(MenuPrincipal.emailLogado)) {
                System.out.println(s.toString());
            }
        } else {
            System.out.println("\nNão tem séries cadastradas!");
        }
    }//fim lista de séries

    private static void removerSerie() {

        System.out.println("___ Remover Série ___");

        System.out.print("\nInforme o título da série: ");
        String titulo = leia.nextLine();
        SerieServicos serieS = ServicosFactory.getSerieServicos();
        Serie s = serieS.buscaSerieTitulo(titulo);
        if (s.getTitulo() != null) {
            //cadSerie.removeSerie(s);
            System.out.println("\nConfirma remover série? 1 - Sim | 2 - Não");
            int opRemove = leiaNumInt();
            if (opRemove == 1) {
                serieS.removerSerie(titulo);
                System.out.println("\nSérie: " + s.getTitulo() + " removida!");
            } else if (opRemove == 2) {
                System.out.println("\nRemoção cancelada!");
            }
        } else {
            System.out.println("\nTítulo não encontrado!");
        }
    }//fim remover série

    private static void cadastrarFilme() {
        int idFilme;
        String titulo;
        int anoLancamento;
        String nomeAtor;
        String nacionalidade;
        String genero;
        float duracaoEspera;
        FilmeServicos filmeS = ServicosFactory.getFilmeServicos();
        UsuarioServicos usuarioS = ServicosFactory.getUsuarioServicos();

        System.out.println("___ Cadastro de Filme ___");

        System.out.print("\nInforme o título: ");
        titulo = leia.nextLine();
        if (filmeS.buscaFilmeTitulo(titulo).getTitulo() != null) {
            System.out.println("\nFilme já cadastrado!");
        } else {
            idFilme = cadFilme.geraID();
            System.out.print("\nInforme o ano de lançamento: ");
            anoLancamento = leiaNumInt();
            System.out.print("\nInforme o nome do ator: ");
            nomeAtor = leia.nextLine();
            System.out.print("\nInforme a nacionalidade: ");
            nacionalidade = leia.nextLine();
            System.out.print("\nInforme o gênero: ");
            genero = leia.nextLine();
            System.out.print("\nInforme o tempo de duração: ");
            duracaoEspera = leiaNumFloat();
            boolean isValidEmailAddressRegex = false;
            Usuario idUsuario = null;
            do {
                System.out.print("\nInforme E-mail: ");
                String email = leia.nextLine();
                isValidEmailAddressRegex = Validadores.isValidEmailAddressRegex(email);
                if (isValidEmailAddressRegex) {
                    idUsuario = usuarioS.buscarUsuariobyEmail(email);
                    if (idUsuario.getEmail() == null) {
                        System.out.println("\nUsuário não cadastrado");
                        isValidEmailAddressRegex = false;
                    } else {
                        System.out.println("\nUsuário: " + idUsuario.getNomeUsuario());
                    }
                } else {
                    System.out.println("\nE-mail inválido!");
                }
            } while (!isValidEmailAddressRegex);
            Filme film = new Filme(idFilme, titulo, anoLancamento, nomeAtor, nacionalidade, genero, duracaoEspera, nacionalidade, idUsuario);
            filmeS.cadFilme(film);
            cadFilme.addFilme(film);
            System.out.println("\nFilme cadastrado com sucesso!");
        }
    }

    private static void editarFilme() {

        System.out.println("___ Editar Filme ___");

        System.out.print("\nInforme o título: ");
        String titulo = leia.nextLine();
        FilmeServicos filmeS = ServicosFactory.getFilmeServicos();
        Filme film = filmeS.buscaFilmeTitulo(titulo);
        if (film.getTitulo() != null) {
            System.out.println("\nFilme selecionado: " + film.getTitulo());
            System.out.println("1 - Tempo de duração:\t" + film.getDuracaoEspera());
            System.out.println("0 - Cancelar");
            System.out.print("\nDigite aqui sua opção: ");
            int opEditar = leiaNumInt();
            if (opEditar == 1) {
                System.out.println("\nTempo de duração atual: \t" + film.getDuracaoEspera());
                System.out.print("\nInforme o novo tempo de duração: ");
                film.setDuracaoEspera(leiaNumFloat());
            }
            if (opEditar == 0) {
                System.out.println("\nOperação cancelada\n");
                return;
            }
            filmeS.atualizarFilme(film);
            System.out.println("\nFilme:\n" + film.toString());
        } else {
            System.out.println("\nTítulo inválido!");
        }
    }

    private static void listaFilmes() {

        System.out.println("___ Lista de Filmes ___");
        System.out.println("\n");
        FilmeServicos filmeS = ServicosFactory.getFilmeServicos();
        if (!filmeS.buscaFilmes(MenuPrincipal.emailLogado).isEmpty()) {
            for (Filme film : filmeS.buscaFilmes(MenuPrincipal.emailLogado)) {
                System.out.println(film.toString());
            }
        } else {
            System.out.println("\nNão tem filmes cadastrados!");
        }
    }//fim lista filmes

    private static void removerFilme() {

        System.out.println("___ Remover Filme ___");

        System.out.print("\nInforme o título do filme: ");
        String titulo = leia.nextLine();
        FilmeServicos filmeS = ServicosFactory.getFilmeServicos();
        Filme film = filmeS.buscaFilmeTitulo(titulo);
        if (film.getTitulo() != null) {
            //cadFilme.removeFilme(film);
            System.out.println("\nConfirma remover filme? 1 - Sim | 2 - Não");
            int opRemove = leiaNumInt();
            if (opRemove == 1) {
                filmeS.removerFilme(titulo);
                System.out.println("\nFilme: " + film.getTitulo() + " removido!");
            } else if (opRemove == 2) {
                System.out.println("\nRemoção cancelada");
            }
        } else {
            System.out.println("\nTítulo não encontrado!");
        }
    }//fim remover filme

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//A main dispara a chamada.
        Login jfLogin = new Login();
        jfLogin.setVisible(true);

        //Chamando mock. 
        /*
        cadUsuario.mockUsuario();
        cadSerie.mockSeries();
        cadFilme.mockFilmes();

        int opM;

        do {
            menuP();
            opM = leiaNumInt();
            switch (opM) {
                case 1:
                case 2:
                case 3:

                    int opSM;

                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        switch (opSM) {
                            case 1:
                                System.out.println("\n--- Cadastrar ---\n");
                                //usar opM para definir qual cadastro
                                if (opM == 1) {
                                    cadastrarUsuario();
                                } else if (opM == 2) {
                                    cadastrarSerie();
                                } else if (opM == 3) {
                                    cadastrarFilme();
                                }
                                break;
                            case 2:
                                System.out.println("\n--- Editar ---\n");
                                if (opM == 1) {
                                    editarUsuario();
                                } else if (opM == 2) {
                                    editarSerie();
                                } else if (opM == 3) {
                                    editarFilme();
                                }
                                break;
                            case 3:
                                System.out.println("\n--- Listar ---\n");
                                if (opM == 1) {
                                    listaUsuarios();
                                } else if (opM == 2) {
                                    listaSeries();
                                } else if (opM == 3) {
                                    listaFilmes();
                                }
                                break;
                            case 4:
                                System.out.println("\n--- Remover ---\n");
                                if (opM == 1) {
                                    removerUsuario();
                                } else if (opM == 2) {
                                    removerSerie();
                                } else if (opM == 3) {
                                    removerFilme();
                                }
                                break;
                            case 0:
                                System.out.println("\n-- Menu Inicial --");
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente!");
                                break;
                        }

                    } while (opSM != 0);//subMenu
                    break;
                case 0:
                    System.out.println("\nPrograma encerrado!!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        } while (opM != 0);//fim sistema
         */
    }//Fim main

}
