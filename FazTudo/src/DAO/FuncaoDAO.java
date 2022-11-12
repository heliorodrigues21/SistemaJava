/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.Departamento;
import Controle.Funcao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alunoifto
 */
public class FuncaoDAO {
    
     private final Connection connection;
     
     public FuncaoDAO(){
        this.connection = new ConexaoBancodeDados().getConnection();
    }
     
     //Método Salvar Funcao
      public void SalvarFuncao(Funcao funcao){
        String sql = "Insert into Funcao(CodigoFuncao, NomeDaFuncao, DataInicio, Departamento_CodigoDepartamento ) values(?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, funcao.getNomeFuncao()); 
            pst.setString(2, funcao.getDataInicio());
            pst.setInt(3, funcao.getCodigoCodigoDepartamento().getCodigoDepartamento());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
            
        } catch (SQLException erro) {
            Logger.getLogger(FuncaoDAO.class.getName()).log(Level.SEVERE, null, erro);
        }
    }
      
      
      //Método Carregar departamento
      public Vector<Departamento> CarregarDepartamento() {
          
        Vector<Departamento> dados = new Vector<Departamento>();
        
        String sql = "Select CodigoDepartamento, NomeDepartamento from Departamento";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Departamento departamento = new Departamento();
                departamento.setCodigoDepartamento(rs.getInt("CodigoDepartamento"));
                departamento.setNomeDepartamento(rs.getString("NomeDepartamento"));
                dados.add(departamento);
            }

        } catch (SQLException erro) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, erro);
        }
        return dados;
    }
      
     
}
