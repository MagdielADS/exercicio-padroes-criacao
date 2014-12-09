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
public class AlunoBuilder {
    
    private final String nome;
    private final String nacionalidade;
    private final String identidade;
    private final String cpf;
    private String numMilitar;

    public AlunoBuilder(String nome, String nacionalidade, String identidade, String cpf) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.identidade = identidade;
        this.cpf = cpf;
    }
    
    public AlunoBuilder comDocumentoMilitar(String numMilitar){
        this.numMilitar = numMilitar;
        return this;
    }
    
    public Aluno construa(){
        return new Aluno(this.nome, this.nacionalidade, this.identidade, this.cpf, this.numMilitar);
    }
}
