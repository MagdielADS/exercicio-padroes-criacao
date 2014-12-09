
import exercicio.padroes.builder.Aluno;
import exercicio.padroes.builder.AlunoBuilder;
import exercicio.padroes.dao.AlunoDAO;
import exercicio.padroes.gui.TelaDeCadastro;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Magdiel Ildefonso
 */
public class Loader {
    public static void main(String[] args) {
        new TelaDeCadastro().setVisible(true);
    }
}
