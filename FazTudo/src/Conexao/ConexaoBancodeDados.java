/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hélio
 */
public class ConexaoBancodeDados {
     public Connection  getConnection(){
        
        try {
        
       //    return  DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_Seguradora?useTimezone=true&serverTimezone=UTC&user=root&password=root");
           return  DriverManager.getConnection("jdbc:mysql:///FazTudo?useTimezone=true&serverTimezone=UTC&user=password=");
        } catch (SQLException ex) { 
           throw  new  RuntimeException(ex);
        }
        
           }
    PreparedStatement preparedStatement (String  query){
        throw  new UnsupportedOperationException("Erro na conexão com banco de dados");
    } 
}
