/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

/**
 *
 * @author Usuário
 */
public class Cidade {
    
    private  int CodigoCidade;
    private  String nomeCidade;
    private String Estado;

    public int getCodigoCidade() {
        return CodigoCidade;
    }

    public void setCodigoCidade(int CodigoCidade) {
        this.CodigoCidade = CodigoCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return nomeCidade;
    }


    
    
}
