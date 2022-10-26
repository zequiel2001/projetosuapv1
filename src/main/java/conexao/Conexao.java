/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ezeks
 */
public class Conexao {
    //variaveis de conexao
    private static final String DRIVE_MYSQL = "com.mysql.cj.jdbc.Driver";
    private static final String ENDERECO = "jdbc:mysql://localhost:3306/suap";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
    public static Connection getConexao(){
    
        try {
            Class.forName(DRIVE_MYSQL);
            //variavel de conexao que indica a qual banco desejamos nos conectar.
            Connection con = DriverManager.getConnection(ENDERECO, USUARIO, SENHA);
            return con;
            
          
          //caso ocorra um erro durante o estabelecimento de conexao  
        } catch (ClassNotFoundException | SQLException ex) {
            
            ex.printStackTrace();
            throw new RuntimeException("Erro ao estabelecer uma conexao com o banco");
        }
    }
    
    //metodo que fecha a conexão recebendo por parametro apenas a variavel de conexao
    public static void fechaConexao(Connection con){
    
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar uma conexao com o banco");
            
        }
    
    }
        //metodo metodo que fecha a conexão recebendo por parametro a conexao e e variavel de estrutura que prepara os dados
        public static void fecharConexao(Connection con, PreparedStatement stmt) {
        fechaConexao(con);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            
            throw new RuntimeException("Erro ao fechar uma conexao com o banco");
        }

    }

    public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
        fecharConexao(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar uma conexao com o banco");
        }

    }
        
        
        
    
    
}
