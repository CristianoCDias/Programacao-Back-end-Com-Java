/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cristiano Dias
 */

package model;

import model.PessoaFisica;
import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {

    private ArrayList<PessoaFisica> lista = new ArrayList<>();

    public void inserir(PessoaFisica pf) {
        lista.add(pf);
    }

    public PessoaFisica obter(String id) {
        for (PessoaFisica pf : lista) {
            if (pf.getId().equals(id)) {
                return pf;
            }
        }
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return lista;
    }

    public void salvar(String prefixo) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(prefixo + ".fisica.bin"));
        oos.writeObject(lista);
        oos.close();
    }

    public void recuperar(String prefixo) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(prefixo + ".fisica.bin"));
        lista = (ArrayList<PessoaFisica>) ois.readObject();
        ois.close();
    }
}