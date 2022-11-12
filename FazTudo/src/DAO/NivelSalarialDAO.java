/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.NivelSalarial;
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
public class NivelSalarialDAO {
    
    private final Connection connection;
    
    public NivelSalarialDAO(){
        this.connection = new ConexaoBancodeDados().getConnection();
    }
    
    //Método Salvar Nível Salarial
    public void SalvarNivelSalarial(NivelSalarial nivelSalarial){
        String sql = "INSERT INTO NivelSalarial(CodigoNivelSalarial, ValorSalario) VALUES(?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, nivelSalarial.getCodigoNivelSalario());
            pst.setString(2, nivelSalarial.getValorSalario());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!!");
            
        } catch (SQLException erro) {
            Logger.getLogger(NivelSalarialDAO.class.getName()).log(Level.SEVERE, null, erro);
        }
    }
    
    //Método excluir Nivel Salarial
    public void ExcluirNivelSalarial(NivelSalarial nivelSalarial){
        String sql = "DELETE FROM NivelSalarial WHERE CodigoNivelSalarial=?";
        
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, nivelSalarial.getCodigoNivelSalario());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão Realizada com Sucesso!!");
            pst.close();
            
        } catch (SQLException erro) {
            Logger.getLogger(NivelSalarialDAO.class.getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir os dados do Nivel Salarial!!");
        }
    }
    
    //Método Carregar Tabela
    public Vector CarregarNivelSalarial(){
        
        Vector dadosNivelSalarial = new Vector();
        
        String sql = "SELECT CodigoNivelSalarial, ValorSalario FROM NivelSalarial";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next())  {
            
                 Vector dados = new Vector();
                 dados.add(rs.getInt("CodigoNivelSalarial "));
                 dados.add(rs.getDouble("ValorSalario"));
                 dadosNivelSalarial.add(dados);
            }
            
        } catch (SQLException erro) {
             Logger.getLogger(NivelSalarialDAO.class.getName()).log(Level.SEVERE, null, erro);
        }
        
        return dadosNivelSalarial;
    }
    
}
