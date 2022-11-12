/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.Cidade;
import Controle.Professor;
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
public class ProfessorDao {

    private final Connection connection;

    public ProfessorDao() {
        this.connection = new ConexaoBancodeDados().getConnection();

    }

    // método para Salvar
    public void SalvarProfessor(Professor professor) {
        String sql = "Insert into professor (nomeprofessor, endereco, Codigocidade, telefone, formacao) values(?,?,?,?,?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, professor.getNome());
            pst.setString(2, professor.getEndereco());
            pst.setInt(3, professor.getCodigoCidade().getCodigoCidade());
            pst.setString(4, professor.getTelefone());
            pst.setString(5, professor.getFormacao());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados gravado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // Método Excluír
    public void Excluir(Professor professor) {
        String sql = "Delete from professor where codigoprofessor=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, professor.getCodigoProf());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir os dados da cidade!!");
        }
    }

    // método para Atualizar
    public void AtualizarProfessor(Professor professor) {
        String sql = "Update professor set codigoprofessor=?, nomeprofessor=?, endereco=?, Codigocidade=?, telefone=?, formacao=? where codigoprofessor=?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, professor.getCodigoProf());
            pst.setString(2, professor.getNome());
            pst.setString(3, professor.getEndereco());
            pst.setInt(4, professor.getCodigoCidade().getCodigoCidade());
            pst.setString(5, professor.getTelefone());
            pst.setString(6, professor.getFormacao());
            pst.setInt(7, professor.getCodigoProf());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados Atualizado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Método Carregar Cidade
    public Vector<Cidade> CarregarCidade() {
        Vector<Cidade> dados = new Vector<Cidade>();
        String sql = "Select codigocidade, nomecidade from cidade";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setCodigoCidade(rs.getInt("codigocidade"));
                cidade.setNomeCidade(rs.getString("nomecidade"));
                dados.add(cidade);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }

    // Método Carregar Tabela
    public Vector CarregarProfTabela() {

        Vector DadosProfessor = new Vector();

        String sql = "select codigoprofessor, nomeprofessor, endereco, nomecidade, telefone, formacao from\n"
                + "professor inner JOIN cidade on professor.Codigocidade=cidade.codigocidade";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Vector dados = new Vector();
                dados.add(rs.getInt("codigoprofessor"));
                dados.add(rs.getString("nomeprofessor"));
                dados.add(rs.getString("endereco"));
                dados.add(rs.getString("nomecidade"));
                dados.add(rs.getString("telefone"));
                dados.add(rs.getString("formacao"));
                DadosProfessor.add(dados);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DadosProfessor;
    }

    // Método para pesquisar a cidade
    public Professor PesquisarCidade(int id) {
        Professor professor = null;
        Cidade cidade = null;
        
      
        String Sql = "select codigoprofessor, cidade.Codigocidade, nomecidade, nomeprofessor, endereco, telefone, formacao from professor\n" +
                "inner join cidade ON professor.Codigocidade=cidade.codigocidade where codigoprofessor=" + id;

        try {
            PreparedStatement pst = connection.prepareStatement(Sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                cidade = new Cidade();
                professor = new Professor();

                cidade.setCodigoCidade(rs.getInt("Codigocidade"));
                cidade.setNomeCidade(rs.getString("nomecidade"));
               
                professor.setCodigoProf(rs.getInt("codigoprofessor"));
                professor.setNome(rs.getString("nomeprofessor"));
                professor.setEndereco(rs.getString("endereco"));
                professor.setTelefone(rs.getString("telefone"));
                professor.setFormacao(rs.getString("formacao"));

                professor.setCodigoCidade(cidade);

            }

            // return  true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professor;
    }
    
    public List<Professor> listarProfessor() {
        List<Professor> profArray = new ArrayList<>();

        String sql = "select codigoprofessor, nomeprofessor, endereco, Codigocidade, telefone, formacao from professor";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Professor prof = new Professor();

                prof.setCodigoProf(rs.getInt("codigoprofessor"));
                prof.setNome(rs.getString("nomeprofessor"));
                prof.setEndereco(rs.getString("endereco"));
                prof.setCodigoCidade((Cidade) rs.getObject("Codigocidade"));
                prof.setTelefone(rs.getString("telefone"));
                prof.setFormacao(rs.getString("formacao"));
                profArray.add(prof);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profArray;
    }
}
