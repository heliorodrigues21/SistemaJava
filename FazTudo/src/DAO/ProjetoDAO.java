/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.Projeto;
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
public class ProjetoDAO {
    
    private final Connection connection;
    
    public ProjetoDAO(){
        this.connection = new ConexaoBancodeDados().getConnection();
    }
    
    //Método Salvar projeto
    public void SalvarProjeto(Projeto projeto){
        String sql = "Insert into Projeto (NomeProjeto, DataPrevistaTermino) values(?,?)";
        
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(2, projeto.getNomeProjeto());
            pst.setString(3, projeto.getDataPrevTermino());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!!");
            
        } catch (SQLException erro) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, erro);
        }
        
    }
    
    
    //Método para Excluir o Projeto
    public void ExcluirProjeto(Projeto projeto){
        String sql = "DELETE FROM Projeto WHERE CodigoProjeto=?";
        
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, projeto.getCodigoProjeto());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Exclusão realizada com Sucesso.");
            pst.close();
            
        } catch (Exception erro) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir os dados de Projeto");
            
        }
    
    }
    
    //Método para Carregar a tabela
    public Vector CarregarTabela(){
        Vector dadosProjeto = new Vector();
        
        String sql = "SELECT CodigoProjeto, NomeProjeto, DataPrevistaTermino";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next());
            
            Vector dados = new Vector();
            dados.add(rs.getInt("CodigoProjeto"));
            dados.add(rs.getString("NomeProjeto"));
            dados.add(rs.getString("DataPrevistaTermino"));
            
        } catch (SQLException erro) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, erro);
        }
        
    
        return dadosProjeto;
    }
    
}
