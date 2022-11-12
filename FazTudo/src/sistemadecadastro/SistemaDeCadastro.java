/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemadecadastro;

import Controle.Cidade;
import DAO.CiidadeDao;
 
public class SistemaDeCadastro {
     public static void main(String[] args) {
       /*
         Cidade cidade = new Cidade();
        cidade.setNomeCidade("Palmas");
        cidade.setEstado("Tocantins");
        CiidadeDao dao = new CiidadeDao();        
        dao.Salvar(cidade);
          
         */            
                
        /*
        Cidade cidade = new Cidade ();
        cidade.setCodigoCidade(986);
        CiidadeDao dao = new CiidadeDao();
        dao.Excluir(cidade);
*/
        
         Cidade cidade = new  Cidade();
         cidade.setCodigoCidade(6);
         cidade.setNomeCidade("Rio Verde");
         cidade.setEstado("Goiás");
         CiidadeDao dao = new CiidadeDao();
         dao.atualizar(cidade);


       
       
       
    }
     
     
    
}
