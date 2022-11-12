/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoBancodeDados;
import Controle.Aluno;
import Controle.Cidade;
import Controle.Curso;
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
 * @author Usuário
 */
public class AlunoDao {

    private final Connection connection;

    public AlunoDao() {
        this.connection = new ConexaoBancodeDados().getConnection();

    }

    // método para Salvar
    public void SalvarAluno(Aluno aluno) {
        String sql = "Insert into aluno (nome, endereco, telefone, codigoCidade, CodigoCurso) values(?,?,?,?,?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, aluno.getNome());
            pst.setString(2, aluno.getEndereco());
            pst.setString(3, aluno.getTelefone());
            pst.setInt(4, aluno.getCodigoCidade().getCodigoCidade());
            pst.setInt(5, aluno.getCodigoCurso().getCodigocurso());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados gravado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // método para Atualizar
    public void AtualizarAluno(Aluno aluno) {
        String sql = "Update aluno set codigoAluno=?, nome=?, endereco=?, telefone=?, CodigoCidade=?, CodigoCurso=? where codigoAluno=?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, aluno.getCodigoAluno());
            pst.setString(2, aluno.getNome());
            pst.setString(3, aluno.getEndereco());
            pst.setString(4, aluno.getTelefone());
            pst.setInt(5, aluno.getCodigoCidade().getCodigoCidade());
            pst.setInt(6, aluno.getCodigoCurso().getCodigocurso());
            pst.setInt(7, aluno.getCodigoAluno());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados Atualizado com sucesso!!");

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }

    // Método Carregar Cidade
    public Vector<Curso> CarregarCurso() {
        Vector<Curso> dados = new Vector<Curso>();
        String sql = "Select codigocurso, nomecurso from curso";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setCodigocurso(rs.getInt("codigocurso"));
                curso.setNomecurso(rs.getString("nomecurso"));
                dados.add(curso);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }

    // Método Carregar Tabela
    public Vector CarregarAlunoTabela() {

        Vector DadosAlunos = new Vector();

        String sql = "select codigoAluno, nome, endereco, telefone, nomecidade, nomecurso from\n"
                + "aluno inner JOIN cidade on aluno.Codigocidade=cidade.codigocidade INNER JOIN curso\n"
                + "on aluno.Codigocurso=curso.codigocurso";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Vector dados = new Vector();
                dados.add(rs.getInt("codigoAluno"));
                dados.add(rs.getString("nome"));
                dados.add(rs.getString("endereco"));
                dados.add(rs.getString("telefone"));
                dados.add(rs.getString("nomecidade"));
                dados.add(rs.getString("nomecurso"));
                DadosAlunos.add(dados);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DadosAlunos;
    }

    // Método para pesquisar  a cidade e curso
    public Aluno PesquisarCidade(int id) {
        Aluno aluno = null;
        Cidade cidade = null;
        Curso curso = null;
        
      
        String Sql = "select codigoAluno, cidade.Codigocidade, curso.codigocurso, nomecurso, nomecidade,  nome, endereco, telefone  from aluno\n" +
"                inner join cidade ON aluno.Codigocidade=cidade.codigocidade INNER JOIN curso\n" +
"                on aluno.Codigocurso=curso.codigocurso  where codigoAluno=" + id;

        try {
            PreparedStatement pst = connection.prepareStatement(Sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                cidade = new Cidade();
                aluno = new Aluno();
                curso = new Curso();

                cidade.setCodigoCidade(rs.getInt("Codigocidade"));
                cidade.setNomeCidade(rs.getString("nomecidade"));
                
                curso.setCodigocurso(rs.getInt("codigocurso"));
                curso.setNomecurso(rs.getString("nomecurso"));
                
                
                

                aluno.setCodigoAluno(rs.getInt("codigoAluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setTelefone(rs.getString("telefone"));

                aluno.setCodigoCidade(cidade);
                aluno.setCodigoCurso(curso);

            }

            // return  true;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno;
    }
}


