package modelo;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoricoEstados {

	private List<Estado> estadosDaSimulacao;
	private LocalTime tempoSimulacao;

	public HistoricoEstados(LocalTime tempoSimulacao) {
		this.tempoSimulacao = tempoSimulacao;
		this.estadosDaSimulacao = new ArrayList<>();
	}

	public void adicionarEstado(Estado est) {
		estadosDaSimulacao.add(est);
	}

	public int getOcupacaoMaximaSistema() {

		Estado maiorOcupacao = estadosDaSimulacao.get(0);

		for (int i = 1; i < estadosDaSimulacao.size(); i++) {
			if (maiorOcupacao.getOcupacaoSistema() < estadosDaSimulacao.get(i)
					.getOcupacaoSistema()) {
				maiorOcupacao = estadosDaSimulacao.get(i);
			}
		}
		return maiorOcupacao.getOcupacaoSistema();
	}

	public float getOcupacaoMediaSistema() {

		Map<Integer, Long> ocupacaoESeuTempo = new HashMap<>();

		for (int i = 0; i < estadosDaSimulacao.size() - 1; i++) {

			Estado umEstado = estadosDaSimulacao.get(i);
			Estado proximoEstado = estadosDaSimulacao.get(i + 1);

			long tempoAteProximoEstado = umEstado.getTempoInicio().until(
					proximoEstado.getTempoInicio(), ChronoUnit.SECONDS);
			int ocupacaoSistema = umEstado.getOcupacaoSistema();

			if (ocupacaoESeuTempo.containsKey(ocupacaoSistema)) {

				long tempoAtual = ocupacaoESeuTempo.get(ocupacaoSistema);
				ocupacaoESeuTempo.put(ocupacaoSistema, tempoAtual
						+ tempoAteProximoEstado);

			} else {
				ocupacaoESeuTempo.put(ocupacaoSistema, tempoAteProximoEstado);
			}

		}

		List<Integer> ocupacoes = new ArrayList<>(ocupacaoESeuTempo.keySet());

		float mediaPonderada = 0;

		for (Integer ocupacao : ocupacoes) {

			mediaPonderada += (ocupacao * ((float) ocupacaoESeuTempo
					.get(ocupacao) / (float) LocalTime.MIDNIGHT.until(
					tempoSimulacao, ChronoUnit.SECONDS)));
		}

		return mediaPonderada;
	}

	public int getOcupacaoMaximaCelula(String idCelula) {

		Estado maiorOcupacao = estadosDaSimulacao.get(0);

		for (int i = 1; i < estadosDaSimulacao.size(); i++) {
			if (maiorOcupacao.getOcupacaoCanal(idCelula) < estadosDaSimulacao
					.get(i).getOcupacaoCanal(idCelula)) {
				maiorOcupacao = estadosDaSimulacao.get(i);
			}
		}
		return maiorOcupacao.getOcupacaoCanal(idCelula);
	}

	public float getOcupacaoMediaCelula(String idCelula) {

		Map<Integer, Long> ocupacaoESeuTempo = new HashMap<>();

		for (int i = 0; i < estadosDaSimulacao.size() - 1; i++) {

			Estado umEstado = estadosDaSimulacao.get(i);
			Estado proximoEstado = estadosDaSimulacao.get(i + 1);

			long tempoAteProximoEstado = umEstado.getTempoInicio().until(
					proximoEstado.getTempoInicio(), ChronoUnit.SECONDS);
			int ocupacaoSistema = umEstado.getOcupacaoCanal(idCelula);

			if (ocupacaoESeuTempo.containsKey(ocupacaoSistema)) {

				long tempoAtual = ocupacaoESeuTempo.get(ocupacaoSistema);
				ocupacaoESeuTempo.put(ocupacaoSistema, tempoAtual
						+ tempoAteProximoEstado);

			} else {
				ocupacaoESeuTempo.put(ocupacaoSistema, tempoAteProximoEstado);
			}

		}

		List<Integer> ocupacoes = new ArrayList<>(ocupacaoESeuTempo.keySet());

		float mediaPonderada = 0;

		for (Integer ocupacao : ocupacoes) {

			mediaPonderada += (ocupacao * ((float) ocupacaoESeuTempo
					.get(ocupacao) / (float) LocalTime.MIDNIGHT.until(
					tempoSimulacao, ChronoUnit.SECONDS)));
		}

		return mediaPonderada;
	}

}
