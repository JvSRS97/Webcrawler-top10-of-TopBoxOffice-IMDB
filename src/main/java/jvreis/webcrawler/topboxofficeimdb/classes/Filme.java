package jvreis.webcrawler.topboxofficeimdb.classes;

public class Filme {

    public String titulo;
    public String fim_de_semana;
    public String bruto;
    public String semanas;

    public Filme(String titulo, String fim_de_semana, String bruto, String semanas) {
    	this.titulo = titulo;
        this.fim_de_semana = fim_de_semana;
        this.bruto = bruto;
        this.semanas = semanas;
    }

	public Filme() {
    	
    }
    public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFim_de_semana() {
		return fim_de_semana;
	}

	public void setFim_de_semana(String fim_de_semana) {
		this.fim_de_semana = fim_de_semana;
	}

	public String getBruto() {
		return bruto;
	}

	public void setBruto(String bruto) {
		this.bruto = bruto;
	}

	public String getSemanas() {
		return semanas;
	}

	public void setSemanas(String semanas) {
		this.semanas = semanas;
	}


}