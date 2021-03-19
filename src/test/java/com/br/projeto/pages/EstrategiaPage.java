package com.br.projeto.pages;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class EstrategiaPage {

	private WebDriver driver = new ChromeDriver();
	String[] arrOfStr;
	String[] arrOfStr_2;
	String[] arrOfStr_vista;
	String str, str_2, str_vista;

	public void inicializa() {
		driver.get("https://www.estrategiaconcursos.com.br/");
		driver.manage().window().maximize();
	}

	public void finaliza() {
		driver.close();
		driver.quit();
	}

	private void getPopupNotificacao() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='onesignal-slidedown-cancel-button']")).click();
	}

	public void notificacao() {
		try {
			getPopupNotificacao();
			System.out.println("Popup Localizado");
		} catch (Exception e) {
			System.out.println("Popup Nao Localizado" + e.getMessage());
		}
	}
	
	private void getPopupCookies() throws InterruptedException {
		/*
		* clique em botão "Prosseguir" do popup de cookies mapeado
		*  por movimento do mouse relativo a outro elemento,
		*  devido a dificuldade em mapeamento do próprio botão por outros meios
		*/
		Thread.sleep(3000);
		WebElement popup = driver.findElement(By.className("iconAulas"));
		Actions actionBuilder = new Actions(driver);
		Action clicaPopup = actionBuilder.moveToElement(popup, 0, 338).click().build();
		clicaPopup.perform();
		Thread.sleep(2000);
	}

	public void popupCookies() {
		try {
			getPopupCookies();
			System.out.println("Popup Localizado");
		} catch (Exception e) {
			System.out.println("Popup Nao Localizado" + e.getMessage());
		}
	}

	public void ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		System.out.println("Fez Scroll");
	}

	public void clicarBtnPorProfessor() {
		driver.findElement(By.xpath("/html/body/header/nav/div/div/div[1]/a[3]")).click();
	}

	public void getProfessorDoCurso(String nome) throws InterruptedException {
		notificacao();
		Thread.sleep(5000);
		// ScrollDown(2000);
		WebElement professor = driver.findElement(By.xpath("//a[contains(text(), '" + nome + "')]"));
		ScrollDown();
		professor.click();
	}

	public void getUmCurso(String curso) throws InterruptedException {
		notificacao();
		Thread.sleep(3000);
		ScrollDown();
		str = getParcelado1();
		arrOfStr = str.split("cursos em até", -2);
		WebElement curso_selecionado = driver.findElement(By.xpath("//a[@class='js-card-prod-name'][contains(text(), '" + curso
				+ "')]/../../a[contains(text(), 'Detalhes')]"));
		curso_selecionado.click();

	}
	
	private String getParcelado1() {
		return driver.findElement(By.xpath("//*[@id='b_cursos_porconcurso']/div[2]/div/div[2]/div[2]/section[24]/div"))
				.getText();
	}

	public void comparaPrecos() throws InterruptedException {
		/*
		 * extração e conversão de strings para validação e comparação,
		 * 
		 */
		str_2 = getParcelado2();
		arrOfStr_2 = str_2.split("ou", -2);
		assertThat(arrOfStr, is(arrOfStr_2));
		str_2 = arrOfStr_2[1];
		arrOfStr_2 = (str_2.split("12x de R\\$ ", -2)[1]).split(",", -2);
		str_2 = arrOfStr_2[0] + "." + arrOfStr_2[1];
		float valor_parcelado = 12 * Float.parseFloat(str_2);
		str_vista = driver.findElement(By.className("value")).getText();
		arrOfStr_vista = (str_vista.split("R\\$ ",-2)[1]).split(",", -2);
		str_vista = arrOfStr_vista[0] + "." + arrOfStr_vista[1];
		float valor_vista = Float.parseFloat(str_vista);
		assertThat(valor_vista, is(valor_parcelado));
	}
	
	private String getParcelado2() {
		return driver.findElement(By.className("cur-details-shopping-installments")).getText();
	}

	public void minhaConta() {
		driver.findElement(By.xpath("/html/body/header/div/div/div/div[1]/a")).click();
	}

	public void usuario(String usuario) {
		driver.findElement(By.xpath("//*[@id='b_home']/header/div/div/div/div[1]/div/form/div/div[1]/input"))
				.sendKeys(usuario);
	}

	public void senha(String senha) {
		driver.findElement(By.xpath("//*[@id='b_home']/header/div/div/div/div[1]/div/form/div/div[2]/input"))
				.sendKeys(senha);
	}

	public void clicarBotaoEntrar() {
		driver.findElement(By.xpath("//*[@id='b_home']/header/div/div/div/div[1]/div/form/div/div[3]/button")).click();
	}

	private String butonMinhasMatriculas() {
		return driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/aside/nav/div[2]/a/span[2]")).getText();
	}

	public void validaMinhasMatriculas() {
		assertThat("Minhas Matrículas", is(butonMinhasMatriculas()));
	}

	private void getPopupNotificacaoLogin() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='pushActionRefuse']")).click();
	}

	public void notificacaoLogin() {
		try {
			getPopupNotificacaoLogin();
			System.out.println("Popup Localizado");
		} catch (Exception e) {
			System.out.println("Popup Nao Localizado" + e.getMessage());
		}
	}

	public void porMateria() {
		driver.findElement(By.xpath("//*[@id='b_home']/header/nav/div/div/div[1]/a[4]")).click();
	}

	public void umaMateria() {
		driver.findElement(By.xpath("//*[@id='b_cursos']/div[1]/div/div/section[1]/div/div/section[15]/h1/a")).click();
	}

	public void umaAssinatura() {
		driver.findElement(By.xpath("//*[@id='b_cursos_porconcurso']/div[2]/div/div[3]/div[2]/section[1]/h1/a"))
				.click();
	}

	public void campoBusca(String busca) {
		driver.findElement(By.name("q")).sendKeys(busca);
		driver.findElement(By.className("icon-find")).click();
	}

	public void validaBusca(String busca) {
		Assert.assertTrue(getResultadoBusca().contains(busca));
	}
	
	private String getResultadoBusca() {
		 return driver.findElement(By.className("found")).getText();
	}
	
	public void selecionaPacote(String pacote) {
		driver.findElement(By.xpath("//a[contains(text(), '" + pacote + "')]")).click();
	}

	public void validaPacote(String pacote) {
		assertThat("Pacote p/ Prefeitura de Redenção-PA (Fonoaudiologia) - Pós-Edital", is(getPacote()));
		//assertThat("Pacote p/ Prefeitura de Redenção-PA (Fonoaudiologia) - Pós-Edital", is(getPacote()));
	}
	
	private String getPacote() {
		 return driver.findElement(By.xpath("//*[@id='b_curso']/div[1]/section/div[1]/h1")).getText();
	}
}
