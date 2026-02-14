/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cristiano Dias
 */

package app;

import model.*;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        int opcao;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1 - Incluir");
            System.out.println("2 - Exibir por ID");
            System.out.println("3 - Exibir todos");
            System.out.println("4 - Salvar");
            System.out.println("5 - Recuperar");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                case 1:
                    System.out.print("Pessoa Física (1) ou Jurídica (2)? ");
                    int tipo = Integer.parseInt(sc.nextLine());

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();
                        repoFisica.inserir(new PessoaFisica(id, nome, cpf));
                    } else {
                        System.out.print("CNPJ: ");
                        String cnpj = sc.nextLine();
                        repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
                    }

                    break;

                case 2:
                    System.out.print("Pessoa Física (1) ou Jurídica (2)? ");
                    tipo = Integer.parseInt(sc.nextLine());

                    System.out.print("ID: ");
                    id = sc.nextLine();

                    if (tipo == 1) {
                        PessoaFisica pf = repoFisica.obter(id);
                        if (pf != null) pf.exibir();
                        else System.out.println("Não encontrada.");
                    } else {
                        PessoaJuridica pj = repoJuridica.obter(id);
                        if (pj != null) pj.exibir();
                        else System.out.println("Não encontrada.");
                    }
                    break;

                case 3:
                    for (PessoaFisica pf : repoFisica.obterTodos())
                        pf.exibir();

                    for (PessoaJuridica pj : repoJuridica.obterTodos())
                        pj.exibir();
                    break;

                case 4:
                    try {
                        System.out.print("Prefixo do arquivo: ");
                        String prefixo = sc.nextLine();
                        repoFisica.salvar(prefixo);
                        repoJuridica.salvar(prefixo);
                        System.out.println("Dados salvos com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar.");
                    }
                    break;

                case 5:
                    try {
                        System.out.print("Prefixo do arquivo: ");
                        String prefixo = sc.nextLine();
                        repoFisica.recuperar(prefixo);
                        repoJuridica.recuperar(prefixo);
                        System.out.println("Dados recuperados com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar.");
                    }
                    break;

            }

        } while (opcao != 0);

        System.out.println("Programa finalizado.");
    }
}