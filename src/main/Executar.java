/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import control.AlgoritmoGenetico;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Grafico;
import model.Objeto;
import org.jfree.ui.RefineryUtilities;

//==============================================================================
/**
 *
 * @author Idelfonso
 */
public class Executar {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
               
        List<Objeto> listaObjetos = new ArrayList<>();
        
        
        //pesos :   44,46,90,72,91,40,75,35,8,54,78,40,77,15,61,17,75,29,75,63
        //valores : 92,4,43,83,84,68,92,82,6,44,32,18,56,83,25,96,70,48,14,58
        listaObjetos.add(new Objeto(1, 44.0, 92.0));
        listaObjetos.add(new Objeto(2, 46.0, 4.0));
        listaObjetos.add(new Objeto(3, 90.0, 43.0));
        listaObjetos.add(new Objeto(4, 72.0, 83.0));
        listaObjetos.add(new Objeto(5, 91.0, 84.0));
        listaObjetos.add(new Objeto(6, 40.0, 68.0));
        listaObjetos.add(new Objeto(7, 75.0, 92.0));
        listaObjetos.add(new Objeto(8, 35.0, 82.0));
        listaObjetos.add(new Objeto(9, 8.0, 6.0));
        listaObjetos.add(new Objeto(10, 54.0, 44.0));
        listaObjetos.add(new Objeto(11, 78.0, 32.0));
        listaObjetos.add(new Objeto(12, 40.0, 18.0));
        listaObjetos.add(new Objeto(13, 77.0, 56.0));
        listaObjetos.add(new Objeto(14, 15.0, 83.0));
        listaObjetos.add(new Objeto(15, 61.0, 25.0));
        listaObjetos.add(new Objeto(16, 17.0, 96.0));
        listaObjetos.add(new Objeto(17, 75.0, 70.0));
        listaObjetos.add(new Objeto(18, 29.0, 48.0));
        listaObjetos.add(new Objeto(19, 75.0, 14.0));
        listaObjetos.add(new Objeto(20, 63.0, 58.0));
     
        
        List pesos = new ArrayList<>();
        List valores = new ArrayList<>();
        List nomes = new ArrayList<>();
        
        for (Objeto objeto : listaObjetos) {
            pesos.add(objeto.getPeso());
            valores.add(objeto.getValor());
            nomes.add(objeto.getId());  
        }
        
        Double limitePeso = 878.0;
        Double taxaMutacao = 0.01;
        int tamanhoPopulacao = 20;
        int numeroGeracoes = 100;
        AlgoritmoGenetico ag = new AlgoritmoGenetico(tamanhoPopulacao);
        List resultado = ag.resolver(taxaMutacao, numeroGeracoes, pesos, valores, limitePeso);
        
        for (int i = 0; i < listaObjetos.size(); i++) {
            if (resultado.get(i).equals("1")) {
                System.out.println("Objetos : " + listaObjetos.get(i).getId());
            }
        }
        
        Grafico g = new Grafico("Algoritmo Genético", "Evolução das soluções", ag.getMelhoresCromossomos());
        g.pack();
        RefineryUtilities.centerFrameOnScreen(g);
        g.setVisible(true);
    }
}
