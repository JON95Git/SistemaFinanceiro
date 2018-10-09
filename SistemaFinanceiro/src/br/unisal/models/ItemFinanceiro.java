package br.unisal.models;


import java.io.Serializable;
import java.util.Date;


public class ItemFinanceiro implements Serializable{
    
    private long id;
    private String descricao;
    private String tipo;
    private double valor;
    private String categoria;
    private Date data;

    public ItemFinanceiro(String descricao, String tipo, double valor, String categoria, Date data) {
        this (0,descricao,tipo,valor, categoria, data);
    }
   public ItemFinanceiro(long id, String descrição, String tipo, double valor, String categoria, Date data) {
        this.id = id;
        this.descricao = descrição;
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescrição(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
