package br.com.alura.argentum.reader;

import java.time.LocalDateTime;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.argentum.modelo.Negociacao;

public class LeitorXml {
	public static void main(String[] args) {
		
		Negociacao negociacao = new Negociacao(10.0, 2, LocalDateTime.now());
		
		XStream xstream = new XStream(new DomDriver());
		String xml = xstream.toXML(negociacao);
		
		System.out.println(xml);
	}
}
