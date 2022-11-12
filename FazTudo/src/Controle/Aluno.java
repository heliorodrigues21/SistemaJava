/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

/**
 *
 * @author Usuário
 */
public class Aluno {
    private int codigoAluno;
    private String nome;
    private String endereco;
    private String telefone;
    private Cidade CodigoCidade;
    private Curso CodigoCurso;

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cidade getCodigoCidade() {
        return CodigoCidade;
    }

    public void setCodigoCidade(Cidade CodigoCidade) {
        this.CodigoCidade = CodigoCidade;
    }

    public Curso getCodigoCurso() {
        return CodigoCurso;
    }

    public void setCodigoCurso(Curso CodigoCurso) {
        this.CodigoCurso = CodigoCurso;
    }
    
    
    
}
