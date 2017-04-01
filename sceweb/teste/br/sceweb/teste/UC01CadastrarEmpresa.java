package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa {
	public static Empresa empresa;
	public static EmpresaDAO empresaDAO;

	@BeforeClass

	public static void setUpBeforeClass() throws Exception {

		empresaDAO = new EmpresaDAO();

		empresa = new Empresa();

		empresa.setNomeDaEmpresa("empresa x");

		empresa.setCnpj("89424232000180");

		empresa.setNomeFantasia("empresa x");

		empresa.setEndereco("rua taquari");

		empresa.setTelefone("2222");

	}

	@Test

	public void CT01UC01FBCadastra_com_sucesso() {

		assertEquals(1, empresaDAO.adiciona(empresa));

	}
	
	@Test(expected = RuntimeException.class)
	public void CT02UC01A2Cadastra_empresa_cnpj_ja_cadastrado(){
		empresaDAO.adiciona(empresa);
		empresaDAO.adiciona(empresa);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void CT03UC01A3Cadastra_empresa_cnpj_invalido(){
		if((empresa.getCnpj().length()) != 14) {
			throw new IllegalArgumentException();
		} else {
			empresaDAO.adiciona(empresa);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void CT04UC01A4Cadastra_empresa_com_dados_invalidos_telefone(){
		empresa.setTelefone("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void CT04UC01A4Cadastra_empresa_com_dados_invalidos_endereco(){
		empresa.setEndereco("");
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void CT04UC01A4Cadastra_empresa_com_dados_invalidos_nomeFantasia(){
		empresa.setNomeFantasia("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void CT04UC01A4Cadastra_empresa_com_dados_invalidos_cnpj(){
		empresa.setCnpj("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void CT04UC01A4Cadastra_empresa_com_dados_invalidos_nomeEmpresa(){
		empresa.setNomeDaEmpresa("");
	}

	@After
	public void excluiEmpresa() throws Exception{
	empresaDAO.exclui("89424232000180");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
