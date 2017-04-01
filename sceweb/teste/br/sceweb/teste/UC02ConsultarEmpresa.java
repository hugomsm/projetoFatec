package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

/**
 */
public class UC02ConsultarEmpresa {

	/**
	 * Field empresa.
	 */
	static Empresa empresa = new Empresa();

	/**
	 * Field empresaDAO.
	 */
	static EmpresaDAO empresaDAO = new EmpresaDAO();

	/**
	 * Method setUpBeforeClass.
	 * @throws Exception
	 */
	@BeforeClass

	public static void setUpBeforeClass() throws Exception {

		empresa.setNomeDaEmpresa("Casas Bahia S/A");

		empresa.setCnpj("60430951000122");

		empresa.setNomeFantasia("Casas Bahia");

		empresa.setEndereco("rua taquari");

		empresa.setTelefone("111111");

	}

	/**
	 * Method preCondicao_insereEmpresa.
	 */
	@Before

	public void preCondicao_insereEmpresa() {

		empresaDAO.adiciona(empresa);

	}

	/**
	 * Method CT01UC02ConsultaEmpresa_cnpj_valido.
	 */
	@Test

	public void CT01UC02ConsultaEmpresa_cnpj_valido() {

		assertTrue(empresa.equals(empresaDAO.consultaEmpresa("60430951000122")));

	}
	
	/**
	 * Method CT02UC02ConsultaEmpresa_cnpj_invalido.
	 */
	@Test(expected = RuntimeException.class)
	public void CT02UC02ConsultaEmpresa_cnpj_invalido() {
		String cnpj = "219821";
		EmpresaDAO.consultaEmpresa(cnpj);
	}

	/**
	 * Method tearDown.
	 * @throws Exception
	 */
	@After

	public void tearDown() throws Exception {

		empresaDAO.exclui("60430951000122");

	}

}
