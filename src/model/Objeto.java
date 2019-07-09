/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Idelfonso
 */
public class Objeto {
    
    private int id;
    private Double peso;
    private Double valor;

    public Objeto() {
    }

    public Objeto(int id) {
        this.id = id;
    }

    public Objeto(int id, Double peso, Double valor) {
        this.id = id;
        this.peso = peso;
        this.valor = valor;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
    public void println(){
        System.out.println("Objeto : " + this.getId()  + "-->  " +   
                           "Peso : " + this.getPeso() + "   |   " + 
                           "Valor: " + this.getValor()
        );
    }
    
}
