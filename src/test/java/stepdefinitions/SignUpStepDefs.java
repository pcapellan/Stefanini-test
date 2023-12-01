package stepdefinitions;

import config.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import pages.SignUpPage;
import utils.DriverManager;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignUpStepDefs {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Dado("que estou na página de cadastro de usuários")
    public void queEstouNaPáginaDeCadastroDeUsuários() {
        String urlCadastroUsuarios = ConfigReader.getCadastroUsuariosUrl();
        driver.get(urlCadastroUsuarios);
        signUpPage = new SignUpPage(driver);
    }

    @Quando("preencho o campo Nome com {string}")
    public void preenchoOCampoNomeCom(String name) {
        signUpPage.completeNameField(name);
    }

    @E("preencho o campo E-mail com {string}")
    public void preenchoOCampoEMailCom(String email) {
        signUpPage.completeEmailField(email);
    }

    @E("preencho o campo Senha com {string}")
    public void preenchoOCampoSenhaCom(String pass) {
        signUpPage.completePasswordField(pass);
    }

    @E("pressiono o botão Cadastrar")
    public void pressionoOBotãoCadastrar() {
        signUpPage.clickRegisterBtn();
    }

    @Então("vejo a mensagem {string} abaixo do campo Nome")
    public void vejoAMensagemAbaixoDoCampoNome(String message) {
        assertThat(signUpPage.getErrorMessage(message), equalTo(message));
    }

    @E("vejo a mensagem {string} abaixo do campo E-mail")
    public void vejoAMensagemAbaixoDoCampoEMail(String message) {
        assertThat(signUpPage.getErrorMessage(message), equalTo(message));
    }

    @E("vejo a mensagem {string} abaixo do campo Senha")
    public void vejoAMensagemAbaixoDoCampoSenha(String message) {
        assertThat(signUpPage.getErrorMessage(message), equalTo(message));
    }

    @E("não vejo a tabela com usuários cadastrados")
    public void nãoVejoATabelaComUsuáriosCadastrados() {
        assertThat("tabela de usuários cadastrados não está visível", signUpPage.tableExists(), equalTo(false));
    }

    @Quando("cadastro um usuário com sucesso")
    public void cadastroUmUsuárioComSucesso(DataTable table) {
        List<List<String>> fields = table.asLists();
        String name = fields.get(1).get(0);
        String email = fields.get(1).get(1);
        String password = fields.get(1).get(1);

        signUpPage.registerUser(name, email, password);
    }

    @Então("vejo a tabela com usuários cadastrados")
    public void vejoATabelaComUsuáriosCadastrados() {
        assertThat("tabela de usuários cadastrados não está visível", signUpPage.tableExists(), equalTo(true));
    }

    @E("pressiono o botão excluir na tabela de usuários cadastrados, para o id {string}")
    public void pressionoOBotãoExcluirNaTabelaDeUsuáriosCadastrados(String id) {
        signUpPage.deleteRowById(id);
    }
}
