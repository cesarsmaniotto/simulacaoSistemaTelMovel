package controle;

import java.time.LocalTime;
import java.util.Observer;
import modelo.CalendarioEventos;
import modelo.Celula;
import modelo.Cluster;
import modelo.GeradorVariavelAleatoria;
import modelo.HistoricoEstados;
import modelo.SorteioDeChamadas;
import visao.JanelaPrincipal;

public class Fachada {

	Cluster cluster;
	CalendarioEventos calEventos;
        HistoricoEstados historicoEstados;

	/**
	 * 
	 */
	public Fachada() {
		cluster = new Cluster(2);

	}

	public void definirTempoSimulacao(LocalTime tempoSimulacao) {

		calEventos = new CalendarioEventos(tempoSimulacao, cluster);
                historicoEstados = new HistoricoEstados(tempoSimulacao);

	}
        
        public void definirVelocidade(int velocidade){
            calEventos.alterarVelocidade(velocidade);
        }

	public void definirTemposChamada(String idCelula,
			float percentualComecaTermina, float percentualMudaCelula,
			float percentualSaiDaArea, GeradorVariavelAleatoria gvaTS) {

		Celula cel = cluster.getCelula(idCelula);
		SorteioDeChamadas sorteio = new SorteioDeChamadas(cel, gvaTS,
				percentualComecaTermina, percentualMudaCelula,
				percentualSaiDaArea);
		cel.setGeradorDeChamadas(sorteio);

		cluster.atualizaCelula(cel);

	}

	public void definirNumeroCanaisCelula(String idCelula, int qttCanais) {
               
		Celula cel = cluster.getCelula(idCelula);
		cel.setNroCanais(qttCanais);
		cluster.atualizaCelula(cel);

	}

	public void definirTempoEntreChegadas(String idCelula,
			GeradorVariavelAleatoria gvaTEC) {

		Celula cel = cluster.getCelula(idCelula);
		cel.setTempoEntreChamadas(gvaTEC);
		cluster.atualizaCelula(cel);

	}

	public void iniciarSimulacao() {

		calEventos.start();

	}

	public void pausarSimulacao() {

		calEventos.setPausado(true);

	}

	public void continuarSimulacao() {

		calEventos.setPausado(false);
	}

	public String obterRelatorio() {

		
		
		HistoricoEstados historico = calEventos.getHistorico();
		
		StringBuilder strBuilder = new StringBuilder("Relatório \n");

		strBuilder.append("Média de chamadas no sistema: "
				+ historico.getOcupacaoMediaSistema() + "\n");
		strBuilder.append("Máximo de chamadas no sistema: "
				+ historico.getOcupacaoMaximaSistema() + "\n");

		for (Celula cel : cluster.getCelulas()) {

			String idCelula = cel.getId();

			strBuilder.append("Média de chamadas na célula: " + idCelula + " "
					+ historico.getOcupacaoMediaCelula(idCelula) + "\n");
			strBuilder.append("Máximo de chamadas na célula: " + idCelula + " "
					+ historico.getOcupacaoMaximaCelula(idCelula) + "\n");
			strBuilder.append("Número de chamadas completadas: "
					+ cel.getQttLigacoesCompletadas() + "\n");
			strBuilder.append("Número de chamadas perdidas por falta de canais: "
					+ cel.getQttLigacoesPerdidasFaltaDeCanais() + "\n");
			strBuilder
					.append("Número de chamadas perdidas por saída da área de cobertura: "
							+ cel.getQttLigacoesPerdidasForaDeArea() + "\n");
                        //tratar excecao de lista nao existente!!!!
			strBuilder.append("Chamada de menor duração: "
					+ cel.getTempoChamadaMenorDuracao() + "\n");
			strBuilder.append("Chamada de maior duração: "
					+ cel.getTempoChamadaMaiorDuracao() + "\n");
			strBuilder.append("Tempo médio de duração das chamadas: "
					+ cel.getTempoMedioDuracaoChamada() + "\n");

		}
		
		System.out.println(strBuilder);
                return strBuilder.toString();
	}
        //comunica-se com o calendario sem misturar interface e modelo
        public void adicionarObservador(Observer ob){
            calEventos.adicionarObservador(ob);
        }
        
        public void adicionarObservadorDeProgresso(JanelaPrincipal jp,Observer ob){
            jp.adicionarObservadorProgresso(ob);
            
        }

    public void informarObservado(JanelaPrincipal jp) {
        //jp.adicionarObservadorProgresso(this.calEventos);
    }
    public CalendarioEventos infomarObservador(){
        return calEventos;
    }
    public boolean fimSimulacao(){
        return calEventos.ehFimSimulacao();
    }
    public HistoricoEstados obterHistorico(){
        return calEventos.getHistorico();
    }
    
    

}