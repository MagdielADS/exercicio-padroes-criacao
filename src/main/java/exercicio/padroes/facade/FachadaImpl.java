/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio.padroes.facade;

import exercicio.padroes.builder.Aluno;
import exercicio.padroes.dao.AlunoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Magdiel Ildefonso
 */
public class FachadaImpl implements Fachada {
    private AlunoDAO alunodb;

    public boolean temSobrenome(String nome) {
        boolean result = false;
        for (int i = 0; i < nome.length() - 1; i++) {
            if (nome.charAt(i) == ' ') {
                result = true;
            }
        }
        return result;
    }

    public boolean isCaracter(String nome) {
        boolean result = true;
        for (int i = 0; i < nome.length() - 1; i++) {
            if (Character.isDigit(nome.charAt(i))) {
                result = false;
            }
        }
        return result;
    }

    public boolean validaCPF(String cpf) {
        boolean result;
        String novoCpf = cpf.replace(".", "");
        novoCpf = novoCpf.replace("-", "");

        return result = ValidadorCPF.validaCPF(novoCpf);
    }

    public boolean validarDocumentoPorSexo(String docMilitar) {
        boolean result = false;
        
        if (docMilitar != "" && !docMilitar.equals(" ") && docMilitar != null)
            result = true;

        return result;
    }

    public void armazenaAluno(Aluno aluno, boolean masculino) {
        alunodb = new AlunoDAO();
        if(masculino){
            try {
                alunodb.saveMas(aluno);
            } catch (SQLException ex) {
                Logger.getLogger(FachadaImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                alunodb.saveFem(aluno);
            } catch (SQLException ex) {
                Logger.getLogger(FachadaImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Aluno> listaAlunos() {
        alunodb = new AlunoDAO();
        List<Aluno> alunos = new ArrayList();
        try {
            alunos = alunodb.getAlunos();
        } catch (SQLException ex) {
            Logger.getLogger(FachadaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alunos;
    }
}
