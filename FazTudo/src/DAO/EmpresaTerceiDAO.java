/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.EmpresaTercei;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.sun.jndi.ldap.Connection;
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
public class EmpresaTerceiDAO {
    
    private final java.sql.Connection connection;
    
    public EmpresaTerceiDAO(){
         this.connection = new ConexaoBancodeDados().getConnection();
    }
    
    //Método Salvar Empresa Terceirizada
     public void SavarEmpresaTercei(EmpresaTercei empresaTercei){
         String sql = "Insert into EmpresaTerceirizada(RazaoSocialEmpresa, CNPJ ) values(?,?)";
         
         try {
             PreparedStatement pst = connection.prepareStatement(sql);
             pst.setString(1, empresaTercei.getRazaoSocial());
             pst.setString(2, empresaTercei.getCnpj());
             
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Salvo com Sucesso!!");
             
         } catch (SQLException erro) {
             Logger.getLogger(EmpresaTerceiDAO.class.getName()).log(Level.SEVERE, null, erro);
             
         }
         
     }
     
     //Método Excluir Empresa Terceirizada
     public void Excluir(EmpresaTercei empresaTercei){
         String sql = "DELETE FROM EmpresaTerceirizada WHERE CodigoEmpresaTerceirizada=?";
         
         try {
             PreparedStatement pst = connection.prepareStatement(sql);
             pst.setInt(1, empresaTercei.getCodigoEmpresaTercei());
             pst.execute();
             
             JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso.");
             pst.close();
             
         } catch (SQLException erro) {
             Logger.getLogger(EmpresaTerceiDAO.class.getName()).log(Level.SEVERE, null, erro);
             JOptionPane.showMessageDialog(null, "Erro ao tentar excluir os dados de Empresa Terceirizada");
             
         }
     }
    
             
       //Método para carregar Tabela
     public Vector CarregarEmpresaTercei() {

        Vector DadosEmpresaTercei = new Vector();

        String sql = "SELECT CodigoEmpresaTerceirizada, RazaoSocialEmpresa, CNPJ FROM EmpresaTerceirizada";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Vector dados = new Vector();
                dados.add(rs.getInt("CodigoEmpresaTerceirizada"));
                dados.add(rs.getString("RazaoSocialEmpresa"));
                dados.add(rs.getString("CNPJ"));
                DadosEmpresaTercei.add(dados);
            }

        } catch (SQLException erro) {
            Logger.getLogger(EmpresaTerceiDAO.class.getName()).log(Level.SEVERE, null, erro);
        }
        return DadosEmpresaTercei;
    }
             
             
             
}
