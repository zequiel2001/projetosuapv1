  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.SuapDAO;
import java.util.ArrayList;
import java.util.List;


public class AlunoBO {
    
    
    public AlunoBO(){
    
    }
     //o método consultar ira retornar uma segunda lista vinda do dao   
     public List<Aluno> consulta(){
     
         
     SuapDAO dao = new SuapDAO();
      List<Aluno> alunos = new ArrayList<Aluno>();
      
      
         try {
             alunos = dao.consulta();
             
         } catch (Exception e) {
             
              throw new RuntimeException("Erro ao inserir recuperar no banco de dados");
         }
     
     
     return alunos;
     }
     
     public void cadastrar(Aluno aluno){
         
         SuapDAO dao = new SuapDAO();
         
         try {
             dao.cadastrar(aluno);
         } catch (Exception e) {
             throw new RuntimeException("Erro ao inserir informação no banco de dados");
         }
             
     }
}
