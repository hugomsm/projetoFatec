package br.sceweb.modelo;

import java.util.InputMismatchException;

public class Empresa {
	String cnpj;
	String nomeDaEmpresa;
	String nomeFantasia;
	String endereco;
	String telefone;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		if (cnpj.equals("")) {
			throw new IllegalArgumentException("CNPJ inv�lido");
		} else {
			this.cnpj = cnpj;
		}
	}

	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	public void setNomeDaEmpresa(String nomeDaEmpresa) {
		if (nomeDaEmpresa.equals("")) {
			throw new IllegalArgumentException("Nome inv�lido");
		} else {
			this.nomeDaEmpresa = nomeDaEmpresa;
		}
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		if (nomeFantasia.equals("")) {
			throw new IllegalArgumentException("Nome Fantasia inv�lido");
		} else {
			this.nomeFantasia = nomeFantasia;
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (endereco.equals("")) {
			throw new IllegalArgumentException("Endereco inv�lido");
		} else {
			this.endereco = endereco;
		}
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (telefone.equals("")) {
			throw new IllegalArgumentException("Telefone inv�lido");
		} else {
			this.telefone = telefone;
		}
	}

}
