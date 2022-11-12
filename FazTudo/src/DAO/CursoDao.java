/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.Cidade;
import Controle.Curso;
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
public class CursoDao {

    private final Connection connection;

    public CursoDao() {
        this.connection = new ConexaoBancodeDados().getConnection();
    }

    // Método Salvar 
    public void Salvar(Curso curso) {

        String sql = "Insert into curso (nomecurso, cargahoraria) values (?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, curso.getNomecurso());
            pst.setString(2, curso.getCargahoraria());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados gravado com sucesso!!");
        } catch (SQLException ex) {
            Logger.getLogger(CiidadeDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    // Método Excluír
    public void Excluir(Curso curso) {
        String sql = "Delete from curso where codigocurso=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, curso.getCodigocurso());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(CiidadeDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao tentar Excluir os dados da cidade!!");
        }
    }
//Método Atualizar Registro

    public void atualizar(Curso curso) {
        String sql = "Update curso set codigocurso=?, nomecurso=?, cargahoraria=? where codigocurso=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, curso.getCodigocurso());
            pst.setString(2, curso.getNomecurso());
            pst.setString(3, curso.getCargahoraria());
            pst.setInt(4, curso.getCodigocurso());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(CiidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

// Método carregar dados
    public Vector dadosCurso() {
        Vector tabela = new Vector();

        String sql = "select codigocurso, nomecurso, cargahoraria from curso";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //
                Vector dados = new Vector();
                dados.add(rs.getInt("codigocurso"));
                dados.add(rs.getString("nomecurso"));
                dados.add(rs.getString("cargahoraria"));
                tabela.add(dados);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CiidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabela;
    }
    
    public List<Curso> listarCurso() {
        List<Curso> cursoArray = new ArrayList<>();

        String sql = "select codigocurso, nomecurso, cargahoraria from curso";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Curso curso =  new Curso();

                curso.setCodigocurso(rs.getInt("codigocurso"));
                curso.setNomecurso(rs.getString("nomecurso"));
                curso.setCargahoraria(rs.getString("cargahoraria"));
                cursoArray.add(curso);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CiidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cursoArray;
    }

    
}



