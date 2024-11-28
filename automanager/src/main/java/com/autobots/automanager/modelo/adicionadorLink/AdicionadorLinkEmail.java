package com.autobots.automanager.modelo.adicionadorLink;

import com.autobots.automanager.controles.EmailControle;
import com.autobots.automanager.entidades.Email;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdicionadorLinkEmail implements AdicionadorLink<Email> {
	@Override
	public void adicionarLink(List<Email> lista) {
        for(Email email: lista){
			long id = email.getId();
	        Link linkProprio = WebMvcLinkBuilder
			        .linkTo(WebMvcLinkBuilder
			                .methodOn(EmailControle.class)
			                .obterEmail(id))
			        .withSelfRel();
			email.add(linkProprio);
        }
    }
	
	@Override
	public void adicionarLink(Email objeto){
		Long id = objeto.getId();
		Link linkProprio = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(EmailControle.class)
                        .obterEmails())
                .withRel("emails");
        objeto.add(linkProprio);
		Link linkDeletar = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
                        .methodOn(EmailControle.class)
                        .excluirEmail(id))
                .withRel("deletarEmail");
        objeto.add(linkDeletar);
		Link linkAtualizar = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
                        .methodOn(EmailControle.class)
                        .atualizarEmail(null, id))
               .withRel("atualizarEmail");
        objeto.add(linkAtualizar);
	}
}
