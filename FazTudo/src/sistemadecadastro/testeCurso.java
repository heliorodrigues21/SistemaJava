/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemadecadastro;

import Controle.Curso;
import DAO.CursoDao;

/**
 *
 * @author Usuário
 */
public class testeCurso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Curso curso = new Curso();
        curso.setNomecurso("Ciência da Computação");
        curso.setCargahoraria("2000");
        
       CursoDao  cursodao = new CursoDao();
       cursodao.Salvar(curso);
        
    }
    
}
