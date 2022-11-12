/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuário
 */
public class CiidadeDao {

    private final Connection connection;

    public CiidadeDao() {
        this.connection = new ConexaoBancodeDados().getConnection();
    }

    // Método Salvar 
    public void Salvar(Cidade cidade) {

        String sql = "Insert into cidade (nomecidade, estado) values (?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, cidade.getNomeCidade());
            pst.setString(2, cidade.getEstado());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados gravado com sucesso!!");
        } catch (SQLException ex) {
            Logger.getLogger(CiidadeDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    // Método Excluír
    public void Excluir(Cidade cidade) {
        String sql = "Delete from cidade where codigocidade=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, cidade.getCodigoCidade());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(CiidadeDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir os dados da cidade!!");
        }
    }
//Método Atualizar Registro

    public void atualizar(Cidade cidade) {
        String sql = "Update cidade set codigocidade=?, nomecidade=?, estado=? where codigocidade=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, cidade.getCodigoCidade());
            pst.setString(2, cidade.getNomeCidade());
            pst.setString(3, cidade.getEstado());
            pst.setInt(4, cidade.getCodigoCidade());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(CiidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
// Método carregar dados
    public Vector dadosCidade(){
        Vector tabela = new Vector();
        
        String sql = "select codigocidade, nomecidade, estado from cidade";
              try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while (rs.next()){
                Vector dados = new Vector();
                dados.add(rs.getInt("codigocidade"));
                dados.add(rs.getString("nomecidade"));
                dados.add(rs.getString("estado"));
                tabela.add(dados);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CiidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabela;
    }
    public List<Cidade> listarCidade() {
        List<Cidade> cidadeArray = new ArrayList<>();

        String sql = "select codigocidade, nomecidade, estado from cidade";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Cidade cidade = new Cidade();

                cidade.setCodigoCidade(rs.getInt("codigocidade"));
                cidade.setNomeCidade(rs.getString("nomecidade"));
                cidade.setEstado(rs.getString("estado"));
                cidadeArray.add(cidade);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CiidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cidadeArray;
    }

}
