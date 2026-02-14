/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cristiano Dias
 */

package model;

import model.PessoaJuridica;
import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> lista = new ArrayList<>();

    public void inserir(PessoaJuridica pj) {
        lista.add(pj);
    }

    public PessoaJuridica obter(String id) {
        for (PessoaJuridica pj : lista) {
            if (pj.getId().equals(id)) {
                return pj;
            }
        }
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return lista;
    }

    public void salvar(String prefixo) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(prefixo + ".juridica.bin"));
        oos.writeObject(lista);
        oos.close();
    }

    public void recuperar(String prefixo) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(prefixo + ".juridica.bin"));
        lista = (ArrayList<PessoaJuridica>) ois.readObject();
        ois.close();
    }
}