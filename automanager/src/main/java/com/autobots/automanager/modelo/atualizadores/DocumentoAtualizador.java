package com.autobots.automanager.modelo.atualizadores;

import java.util.List;

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.modelo.StringVerificadorNulo;

public class DocumentoAtualizador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();
	
	public void atualizar(Documento documento, Documento atualizacao) {
		if (atualizacao != null) {
			if (!verificador.verificar(String.valueOf(atualizacao.getTipo()))) {
				documento.setTipo(atualizacao.getTipo());
			}
			if (!verificador.verificar(atualizacao.getNumero())) {
				documento.setNumero(atualizacao.getNumero());
			}
		}
	}
	
	public void atualizar(List<Documento> documentos, List<Documento> atualizacoes) {
		for (Documento atualizacao : atualizacoes) {
			for (Documento documento : documentos) {
				if (atualizacao.getId() != null) {
					if (atualizacao.getId() == documento.getId()) {
						atualizar(documento, atualizacao);
					}
				}
			}
		}
	}
}
