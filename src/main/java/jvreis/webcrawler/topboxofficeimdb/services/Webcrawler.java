package jvreis.webcrawler.topboxofficeimdb.services;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;//importando biblioteca Jsoup
import org.jsoup.nodes.Document;//importado ao criar vari�vel "documento"
import org.jsoup.nodes.Element;//importado ao criar vari�vel "elemento"
import org.jsoup.select.Elements;

import jvreis.webcrawler.topboxofficeimdb.classes.Filme;


//Obs.: Comando Alt+Shift+s -> "Generate Getters and Setters" gera automaticamente as fun��es 
//get e set para cada variavel
public class Webcrawler {// classe que contem os dados HTML
//-------------------------------------------------
	// retorna uma lista de descrição dos Filmes (olhar classe Filme)
	public static List<Filme> search() {
		List<Filme> dados;
		dados = new ArrayList<>();
		
		// 1 - URL do site a ser acessado
		String link = ("https://www.imdb.com/chart/boxoffice/?ref_=nv_ch_cht");
		Document documento = null;
		try {
			// 2 - Conectando e obtendo uma cópia do html inteiro da página
			documento = Jsoup.connect(link).get();
		} catch (Exception e) {
			System.out.println("Site Indisponível ou falha na requisição!");
		}
		Elements table = documento.getElementsByClass("chart full-width"); 

		// 4 - Obtendo o corpo da tabela através da tag
		//tbody será um elemento da lista de elementos table que possui a tag dada
		Element tbody = table.get(0).getElementsByTag("tbody").first();

		// 5 - Criando uma lista de todos os tr's do tbody obtido
		List<Element> Filmes = tbody.getElementsByTag("tr");


		// 6 - Iterando por cada tr e convertendo-o em um Filme. Em seguida inserindo-o na lista de Filmes
		for (Element filme : Filmes) {// para cada elemento Filme da lista de elementos Filmes
			
			// Listando todos os atributos do tr em questão
			// pegando elemento pela tag
			List<Element> descricao = filme.getElementsByTag("td");			
			
			// criando o objeto e inserindo nele os atributos extraidos do td
			Filme x = new Filme();
			x.setTitulo(descricao.get(1).text());
			x.setFim_de_semana(descricao.get(2).text());
			x.setBruto(descricao.get(3).text());
			x.setSemanas(descricao.get(4).text());
			
			// adicionando o objeto na lista de objetos de Filmes
			dados.add(x);
		}	
		return dados;
	}

}
