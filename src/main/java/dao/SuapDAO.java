/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Aluno;

public class SuapDAO {
    
    public void cadastrar(Aluno aluno){
        //cria variavel de conexao
        Connection con = Conexao.getConexao();
        //variavel que prepara a estrutura para fazer as inserções de dados 
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO alunos (nome, cpf, endereco, nasc) VALUES (?,?,?,?)");
            
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEndereco());
            stmt.setString(4, aluno.getNascimento());
            
            //Executa a instrução SQL no objeto
            stmt.executeUpdate();
            
        //caso ocorra um erro    
        } catch (SQLException ex) {
            ex.printStackTrace();
        
        //será fechado a conexao idependente do que acontecer no try catch   
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
        
        
        
    }
    //método que vai colocar todo o resultado de uma consulta e colocar em uma lista
    public java.util.List<Aluno> consulta(){
       Connection con = Conexao.getConexao();
       PreparedStatement stmt = null;
       
       //variavel que vai guardar todos os dados vindo do banco de dados
       ResultSet rs = null;
       
       //criando lista
       java.util.List<Aluno> alunos = new ArrayList<Aluno>();
       
       
       try{
           
            stmt = con.prepareStatement("SELECT nome, cpf, endereco, nasc FROM alunos");
            //
            //stmt vai executar a query e em seguinda vai jogar o resultado na variavel que vai receber todo o resultado
            rs = stmt.executeQuery();
           
           while (rs.next()){
               Aluno aluno =  new Aluno();
              
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setNascimento(rs.getString("nasc"));
              
               
               alunos.add(aluno);
               
           }
           
           
       }catch (SQLException s){
           s.printStackTrace();
           
       }
       
        finally {
            Conexao.fecharConexao(con, stmt);

        }
       
      return alunos;

       
   }
        
}    
        
        
        
        
        
        

