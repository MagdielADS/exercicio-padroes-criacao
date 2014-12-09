/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicio.padroes.builder;

/**
 *
 * @author Magdiel Ildefonso
 */
public class Aluno {
    
    private final String nome;
    private final String nacionalidade;
    private final String identidade;
    private final String cpf;
    private final String numMilitar;

    protected Aluno(String nome, String nacionalidade, String identidade, String cpf, String numMilitar) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.identidade = identidade;
        this.cpf = cpf;
        this.numMilitar = numMilitar;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getIdentidade() {
        return identidade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNumMilitar() {
        return numMilitar;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", nacionalidade=" + nacionalidade + ", identidade=" + identidade + ", cpf=" + cpf + ", numMilitar=" + numMilitar + '}';
    }
}
