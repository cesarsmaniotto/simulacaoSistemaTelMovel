package modelo.evento;

import java.time.LocalTime;

import modelo.CalendarioEventos;
import modelo.Celula;
import modelo.Chamada;
import modelo.Cluster;
import modelo.Estado;
import modelo.TipoChamada;

public class EventoInicioChamada extends Evento {

	private Cluster cluster;
	private String idCelula;
        private Chamada chamada;

	public EventoInicioChamada(LocalTime tempoInicio, Cluster cluster,
			String idCelula) {
		super(tempoInicio);
		this.cluster = cluster;
                
		this.idCelula = idCelula;
                
	}

	@Override
	public Estado processaEvento(CalendarioEventos calEventos,
			Estado estadoAtual) {

		Celula cel = cluster.getCelula(idCelula);
                chamada = cel.geraNovaChamada();
                

		if (estadoAtual.getOcupacaoCanal(cel.getId()) < cel.getNroCanais()) {

			Evento proximoEvento = null;

			switch (chamada.getTipo()) {
			case COMECA_E_TERMINA_NA_MESMA_CELULA:

				proximoEvento = new EventoFimChamada(getTempoInicio()
						.plusSeconds(chamada.getTempoDuracao()), chamada, cluster);
				break;

			case TERMINA_EM_UMA_CELULA_DIFERENTE:

				proximoEvento = new EventoMudancaCanal(getTempoInicio()
						.plusSeconds(chamada.getTempoDuracao() / 2), chamada, cluster);
				break;

			case TERMINA_FORA_DA_AREA_DE_COBERTURA:

				proximoEvento = new EventoSaidaAreaCobertura(getTempoInicio()
						.plusSeconds(chamada.getTempoDuracao() / 2), chamada, cluster);
				break;

			}

			calEventos.adicionarEvento(proximoEvento);

			estadoAtual.incrementaOcupacaoCanal(cel.getId());

			

		} else {

			cel.incrementaLigacoesPerdidasFaltaDeCanais();
			cluster.atualizaCelula(cel);

		}
		
		calEventos.adicionarEvento(new EventoInicioChamada(this.tempoInicio
				.plusSeconds(cel.tempoParaNovaChamada()), cluster, cel.getId()));

		return new Estado(estadoAtual, getTempoInicio());

	}

        @Override
        public String toString() {
            
            return idCelula;
        }
        
}