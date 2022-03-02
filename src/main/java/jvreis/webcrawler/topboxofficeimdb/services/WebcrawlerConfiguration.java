package jvreis.webcrawler.topboxofficeimdb.services;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import jvreis.webcrawler.topboxofficeimdb.classes.Filme;

public class WebcrawlerConfiguration {// obs.: editar caminho do arquivo em caso de mudan�a de pasta
	private String path = "C:\\Users\\jvict\\eclipse-workspace\\webcrawler.topboxofficeimdb\\Webcrawler-TopBoxOffice-IMDB.txt";
	
	private OutputStreamWriter writer;

	public WebcrawlerConfiguration() {
		executar();
	}

	// ------------------------------------------------------------------
	private void escreverFile(String texto, String caminho) {
		try {
			File arquivo = new File(caminho);
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			writer = new OutputStreamWriter(new FileOutputStream(arquivo));
			writer.write(texto);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------
	private void executar() {
		List<Filme> dados;
		//dados = new ArrayList<>();
		
		dados = Webcrawler.search();
		
		imprimir_lista_p(dados);
		escreverFile(list_to_txt_p(dados), path);
	}

	private void imprimir_lista_p(List<Filme> filmes) {// imprimindo a lista
		int i;
		String titulo, filme, fim_de_semana, bruto, semanas;
		System.out.println("Classificação de filmes");
		for (i = 0; i < filmes.size(); i++) {
			titulo = filmes.get(i).getTitulo();
			fim_de_semana = filmes.get(i).getFim_de_semana();
			bruto = filmes.get(i).getBruto();
			semanas = filmes.get(i).getSemanas();
			System.out.println("Titulo: " + titulo + "; Fim de Semana: " + fim_de_semana + "; Bruto: " + bruto
					+ "; Semanas: " + semanas + ".");
		}
	}

	private String list_to_txt_p(List<Filme> filmes) {// convertendo lista em texto numa única variável
		String texto = "Titulo\tFim de Semana\tBruto\tSemanas\n";
		int i;
		String titulo, filme, fim_de_semana, bruto, semanas;
		for (i = 0; i < filmes.size(); i++) {
			titulo = filmes.get(i).getTitulo();
			fim_de_semana = filmes.get(i).getFim_de_semana();
			bruto = filmes.get(i).getBruto();
			semanas = filmes.get(i).getSemanas();
			texto += titulo + "\t" + fim_de_semana + "\t" + bruto + "\t" + semanas + "\n";
		}
		return texto;
	}
	

}