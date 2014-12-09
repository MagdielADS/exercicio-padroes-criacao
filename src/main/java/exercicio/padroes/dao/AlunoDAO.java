/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicio.padroes.dao;

import exercicio.padroes.builder.Aluno;
import exercicio.padroes.builder.AlunoBuilder;
import exercicio.padroes.singleton.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Magdiel Ildefonso
 */
public class AlunoDAO {
    public void saveFem(Aluno a) throws SQLException{
        
        Connection connection = ConexaoBanco.getInstance().getConnection();
        String sql = "insert into Aluno(cpf, nome, nacionalidade, identidade) values(?,?,?,?)";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, a.getCpf());
        stmt.setString(2, a.getNome());
        stmt.setString(3, a.getNacionalidade());
        stmt.setString(4, a.getIdentidade());
        

        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public void saveMas(Aluno a) throws SQLException{
        
        Connection connection = ConexaoBanco.getInstance().getConnection();
        String sql = "insert into aluno(cpf, nome, nacionalidade, identidade, documento_militar) values(?,?,?,?,?)";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, a.getCpf());
        stmt.setString(2, a.getNome());
        stmt.setString(3, a.getNacionalidade());
        stmt.setString(4, a.getIdentidade());
        stmt.setString(5, a.getNumMilitar());
        

        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public List<Aluno> getAlunos() throws SQLException{
        Connection connection = ConexaoBanco.getInstance().getConnection();
        
        String sql = "select * from aluno";
        List<Aluno> alunos = new ArrayList();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Aluno a = null;
            
            String cpf = rs.getString("cpf");
            String nome = rs.getString("nome");
            String nacionalidade = rs.getString("nacionalidade");
            String identidade = rs.getString("identidade");
            String docMilitar = rs.getString("documento_militar");
            
            
            
            if(docMilitar != null || docMilitar != "")
                a = new AlunoBuilder(nome, nacionalidade, identidade, cpf).comDocumentoMilitar(docMilitar).construa();
            else
                a = new AlunoBuilder(nome, nacionalidade, identidade, cpf).construa();
            
            alunos.add(a);
        }

        rs.close();
        stmt.close();
        connection.close();
        return alunos;
    }
}
