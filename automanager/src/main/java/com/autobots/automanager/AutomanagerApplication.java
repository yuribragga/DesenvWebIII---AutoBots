package com.autobots.automanager;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@SpringBootApplication
public class AutomanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomanagerApplication.class, args);
	}

	@Component
	public static class Runner implements ApplicationRunner {
		@Autowired
		public ClienteRepositorio repositorio;

		@Override
		public void run(ApplicationArguments args) throws Exception {
			Calendar calendario = Calendar.getInstance();
			calendario.set(1990, Calendar.APRIL, 12);

			Cliente cliente = new Cliente();
			cliente.setNome("Joana de Albuquerque");
			cliente.setDataCadastro(Calendar.getInstance().getTime());
			cliente.setDataNascimento(calendario.getTime());
			cliente.setNomeSocial("Joana Lima");

			Telefone telefone = new Telefone();
			telefone.setDdd("11");
			telefone.setNumero("987654321");
			cliente.getTelefones().add(telefone);

			Endereco endereco = new Endereco();
			endereco.setEstado("São Paulo");
			endereco.setCidade("São Paulo");
			endereco.setBairro("Vila Mariana");
			endereco.setRua("Rua Domingos de Morais");
			endereco.setNumero("1234");
			endereco.setCodigoPostal("04009002");
			endereco.setInformacoesAdicionais("Apartamento 45");
			cliente.setEndereco(endereco);

			Documento rg = new Documento();
			rg.setTipo("RG");
			rg.setNumero("452369874");

			Documento cpf = new Documento();
			cpf.setTipo("CPF");
			cpf.setNumero("12345678909");

			cliente.getDocumentos().add(rg);
			cliente.getDocumentos().add(cpf);

			repositorio.save(cliente);
		}
	}
}
