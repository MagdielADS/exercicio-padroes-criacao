/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicio.padroes.facade;

import exercicio.padroes.builder.Aluno;
import java.util.List;

/**
 *
 * @author Magdiel Ildefonso
 */
public interface Fachada {
    public boolean isCaracter(String nome);
    public boolean temSobrenome(String nome);
    public boolean validaCPF(String cpf);
    public boolean validarDocumentoPorSexo(String docMilitar);
    public void armazenaAluno(Aluno aluno, boolean masculino);
    public List<Aluno> listaAlunos();
}
