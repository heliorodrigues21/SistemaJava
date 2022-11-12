/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

/**
 *
 * @author hélio
 */
public class Funcionario {
    
    private int codigoFuncionario;
    private String nomeFuncionario;
    private String dataAdmissao;
    private String endereco;
    private int quantidadeDependente;
    private Funcao codigoFuncao;
    private NivelSalarial codigoNivelSalarial;

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public int getQuantidadeDependente() {
        return quantidadeDependente;
    }

    public void setQuantidadeDependente(int quantidadeDependente) {
        this.quantidadeDependente = quantidadeDependente;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
     public Funcao getCodigoFuncao() {
        return codigoFuncao;
    }

    public void setCodigoFuncao(Funcao codigoFuncao) {
        this.codigoFuncao = codigoFuncao;
    }

    public NivelSalarial getCodigoNivelSalarial() {
        return codigoNivelSalarial;
    }

    public void setCodigoNivelSalarial(NivelSalarial codigoNivelSalarial) {
        this.codigoNivelSalarial = codigoNivelSalarial;
    }
    
  
}
