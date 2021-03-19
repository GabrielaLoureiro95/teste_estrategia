package com.br.projeto.steps;

import com.br.projeto.pages.EstrategiaPage;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;

public class EstrategiaSteps {
	EstrategiaPage estrategiaPage = new EstrategiaPage();

	//Busca por Professor
	@Dado("^que eu acessei o portal$")
	public void queEuAcesseiOPortal() throws Throwable {
		estrategiaPage.inicializa();
		estrategiaPage.notificacao();
		estrategiaPage.popupCookies();
	}

	@Dado("^clico no botão Por Professor$")
	public void clicoNoBotãoPorProfessor() throws Throwable {
		estrategiaPage.clicarBtnPorProfessor();
	}

	@Dado("^clico no botão com o nome do professor \"([^\"]*)\"$")
	public void clicoNoBotãoDetalhesComONomeDoProfessor(String nome) throws Throwable {
		estrategiaPage.getProfessorDoCurso(nome);
	}

	@Dado("^seleciono um curso \"([^\"]*)\"$")
	public void selecionoUmCurso(String curso) throws Throwable {
		estrategiaPage.getUmCurso(curso);
	}

	@Dado("^clico no botão Detalhes$")
	public void clicoNoBotãoDetalhes() throws Throwable {
		estrategiaPage.comparaPrecos();

	}

	@Então("^valido se o valor do curso da listagem é igual ao que está dentro da tela de detalhes$")
	public void validoSeOValorDoCursoDaListagemÉIgualAoQueEstáDentroDaTelaDeDetalhes() throws Throwable {
		estrategiaPage.finaliza();
	}
	
	
	// Test busca por matéria
	@Dado("^clico no botão por matéria$")
	public void clicoNoBotãoPorMatéria() throws Throwable {
	   estrategiaPage.porMateria();
	   estrategiaPage.notificacao();
	}

	@Dado("^clico no botão com o nome da matéria \"([^\"]*)\"$")
	public void clicoNoBotãoComONomeDaMatéria(String materia) throws Throwable {
	    estrategiaPage.umaMateria();
	}
	@Então("^seleciono uma assinatura \"([^\"]*)\"$")
	public void selecionoUmaAssinatura(String assinatura) throws Throwable {
	    estrategiaPage.umaAssinatura();
	    estrategiaPage.finaliza();
	}
	
	//Test pelo campo buscar
	@Dado("^digito o que procuro na caixa de busca \"([^\"]*)\"$")
	public void digitoOQueProcuroNaCaixaDeBusca(String busca) throws Throwable {
		estrategiaPage.notificacao();
	    estrategiaPage.campoBusca(busca);
	}

	@Dado("^valido que o que foi buscado é o mesmo que digitei \"([^\"]*)\"$")
	public void validoQueOQueFoiBuscadoÉOMesmoQueDigitei(String busca) throws Throwable {
		estrategiaPage.validaBusca(busca);
	}
	
	@Dado("^seleciono um pacote \"([^\"]*)\"$")
	public void selecionoUmPacote(String pacote) throws Throwable {
	    estrategiaPage.selecionaPacote(pacote);
	}

	@Então("^valido se ele clicou no pacote que solicitei\"([^\"]*)\"$")
	public void validoSeEleClicouNoPacoteQueSolicitei(String pacote) throws Throwable {
		estrategiaPage.validaPacote(pacote);
	    estrategiaPage.finaliza();
	}
	
	//Test do Login
		@Dado("^faço o login com o \"([^\"]*)\" e \"([^\"]*)\"$")
		public void façoOLoginComOE(String usuario, String senha) throws Throwable {
			estrategiaPage.minhaConta();
			estrategiaPage.usuario(usuario);
			estrategiaPage.senha(senha);
			estrategiaPage.clicarBotaoEntrar();
		}

		@Então("^eu valido que o login foi feito$")
		public void euValidoQueOLoginFoiFeito() throws Throwable {
			estrategiaPage.notificacaoLogin();
			estrategiaPage.validaMinhasMatriculas();
			estrategiaPage.finaliza();

		}
}
