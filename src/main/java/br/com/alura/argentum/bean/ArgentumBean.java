package br.com.alura.argentum.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.alura.argentum.modelo.Negociacao;
import br.com.alura.argentum.ws.ClientWebservice;

@ViewScoped
@ManagedBean
public class ArgentumBean implements Serializable {
	
	private List<Negociacao> negociacoes;
	private LineChartModel modeloGrafico;
	
	public ArgentumBean(){
		this.negociacoes = new ClientWebservice().getNegociacoes();
		this.modeloGrafico = new LineChartModel();
		this.modeloGrafico.setTitle("Meu primeiro Grafico");
		
		LineChartSeries linha = new LineChartSeries();
		linha.set(1, 10.5);
		linha.set(2, 13.0);
		linha.set(3, 12.0);
		
		this.modeloGrafico.addSeries(linha);
	}
	
	public List<Negociacao> getNegociacoes(){
		return this.negociacoes; 
	}
	
	public LineChartModel getModeloGrafico() {
		return modeloGrafico;
	}
}
