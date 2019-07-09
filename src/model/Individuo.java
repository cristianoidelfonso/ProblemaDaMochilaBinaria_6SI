/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Idelfonso
 */
public class Individuo implements Comparable<Individuo>{
    private List pesos = new ArrayList<>();
    private List valores = new ArrayList<>();
    private Double limitePeso;
    private Double notaAvaliacao;
    private Double pesoIndividuo;
    private int geracao;
    private List cromossomo = new ArrayList<>();

    //--------------------------------------------------------------------------
    public Individuo(List pesos, List valores, Double limitePeso) {
        this.pesos = pesos;
        this.valores = valores;
        this.limitePeso = limitePeso;
        this.notaAvaliacao = 0.0;
        this.pesoIndividuo = 0.0;
        this.geracao = 0;
        
        for (int i = 0; i < this.pesos.size(); i++) {
            if(java.lang.Math.random() < 0.5){
                this.cromossomo.add("0");
            }else{
                this.cromossomo.add("1");
            }
        }
    }
    //--------------------------------------------------------------------------
    public void avaliacao(){
        Double nota = 0.0;
        Double somaEspacos = 0.0;
        for (int i = 0; i < this.cromossomo.size(); i++) {
            if(this.cromossomo.get(i).equals("1")){
                nota += (Double) this.valores.get(i);
                somaEspacos += (Double)this.pesos.get(i);
            }
        }
        
        if(somaEspacos > this.limitePeso){
            nota = 1.0;
        }
        
        this.notaAvaliacao = nota;
        this.pesoIndividuo = somaEspacos;
    }
    //--------------------------------------------------------------------------
    public List crossover(Individuo outroIndividuo){
        int corte = (int)Math.round(Math.random() * this.cromossomo.size());
        List filho1 = new ArrayList<>();
        filho1.addAll(outroIndividuo.getCromossomo().subList(0, corte));
        filho1.addAll(this.cromossomo.subList(corte, this.cromossomo.size()));
        
        List filho2 = new ArrayList<>();
        filho2.addAll(this.cromossomo.subList(0, corte));
        filho2.addAll(outroIndividuo.getCromossomo().subList(corte, this.cromossomo.size()));
        
        
        List<Individuo> filhos = new ArrayList<>();
        filhos.add(new Individuo(this.pesos, this.valores, this.limitePeso));
        filhos.add(new Individuo(this.pesos, this.valores, this.limitePeso));
        
        filhos.get(0).setCromossomo(filho1);
        filhos.get(0).setGeracao(this.geracao + 1);
        
        filhos.get(1).setCromossomo(filho2);
        filhos.get(1).setGeracao(this.geracao + 1);
        
        return filhos;
    }
    //--------------------------------------------------------------------------
    public Individuo mutacao(Double taxaMutacao){
        //System.out.println("Antes da mutação : " + this.cromossomo);
        for (int i = 0; i < this.cromossomo.size(); i++) {
            if (Math.random() < taxaMutacao) {
                //System.out.println("Ocorrerá mutação no posição " + i);
                if (this.cromossomo.get(i).equals("1")) {
                    this.cromossomo.set(i, "0");
                }else{
                    this.cromossomo.set(i, "1");
                }
            }
        }
        //System.out.println("Após a mutação : " + this.cromossomo);
        return this;
    }
    //--------------------------------------------------------------------------
    public List getPesos() {
        return pesos;
    }

    public void setPesos(List pesos) {
        this.pesos = pesos;
    }

    public List getValores() {
        return valores;
    }

    public void setValores(List valores) {
        this.valores = valores;
    }

    public Double getLimitePeso() {
        return limitePeso;
    }

    public void setLimitePeso(Double limitePeso) {
        this.limitePeso = limitePeso;
    }

    public Double getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(Double notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public Double getPesoIndividuo() {
        return pesoIndividuo;
    }

    public void setPesoIndividuo(Double pesoIndividuo) {
        this.pesoIndividuo = pesoIndividuo;
    }
    
    public int getGeracao() {
        return geracao;
    }

    public void setGeracao(int geracao) {
        this.geracao = geracao;
    }

    public List getCromossomo() {
        return cromossomo;
    }

    public void setCromossomo(List cromossomo) {
        this.cromossomo = cromossomo;
    }

    @Override
    public int compareTo(Individuo o) {
        if (this.notaAvaliacao > o.getNotaAvaliacao()) {
            return -1;
        }
        if (this.notaAvaliacao < o.getNotaAvaliacao()) {
            return 1;
        }
        return 0;
    }
}
