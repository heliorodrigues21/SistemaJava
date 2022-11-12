/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

/**
 *
 * @author hélio
 */
public class Professor {
    private int codigoProf;
    private String Nome;
    private String Endereco;
    private Cidade codigoCidade;
    private String telefone;
    private String formacao;

    public int getCodigoProf() {
        return codigoProf;
    }

    public void setCodigoProf(int codigoProf) {
        this.codigoProf = codigoProf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public Cidade getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(Cidade codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    
}
