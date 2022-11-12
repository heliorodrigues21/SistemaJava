/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.Departamento;
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
 * @author helio
 */
public class DepartamentoDAO {

    private final Connection connection;
    
    public DepartamentoDAO(){
        this.connection = new ConexaoBancodeDados().getConnection();
    }
    
    //Método Salvar Departamento
    public void SalvarDepartamento(Departamento departamento){
        String sql = "Insert into Departamento(NomeDepartamento) values(?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, departamento.getNomeDepartamento());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
            
        } catch (SQLException erro) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, erro);
        }
    }
    
    //Método Excluir Departamento
    public void Excluir(Departamento departamento){
        String sql = "Delete from Departamento where CodigoDepartamento=?";
        try {
             PreparedStatement pst = connection.prepareStatement(sql);
             pst.setInt(1, departamento.getCodigoDepartamento());
             pst.execute();
             JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
            pst.close();
            
        } catch (SQLException erro) {
             Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir os dados do departamento!!");
        }
      
    }
    
    public void AtualizarDepartamento(Departamento departamento){
        String sql = "Update Departamento set CodigoDepartamento=?, NomeDepartamento=? Where CodigoDepartamento=?;";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, departamento.getCodigoDepartamento());
            pst.setString(2, departamento.getNomeDepartamento());
            pst.setInt(3, departamento.getCodigoDepartamento());
            pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
            
        } catch (Exception erro) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, erro);
        }
    }
    // Método Carregar Tabela
    public Vector CarregarDepartTabela() {

        Vector DadosDepartamento = new Vector();

        String sql = "SELECT NomeDepartamento, CodigoDepartamento FROM Departamento ";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Vector dados = new Vector();
                dados.add(rs.getInt("CodigoDepartamento"));
                dados.add(rs.getString("NomeDepartamento"));
                DadosDepartamento.add(dados);
            }

        } catch (SQLException erro) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, erro);
        }
        return DadosDepartamento;
    }
}
