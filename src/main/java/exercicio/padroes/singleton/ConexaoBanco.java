/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicio.padroes.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Magdiel Ildefonso
 */
public class ConexaoBanco {
    private static ConexaoBanco instance;
    private final String url;
    private final String usuario;
    private final String senha;

    private ConexaoBanco() {
        this.url = "jdbc:postgresql://localhost:5432/exercicio_padroes";
        this.usuario = "postgres";
        this.senha = "123456";    
    }

    public static ConexaoBanco getInstance() {
        if (instance == null) {
            instance = new ConexaoBanco();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException("Problemas com a conexão com BD");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }
}
