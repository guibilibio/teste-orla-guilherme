package com.example.testeorla.test;

import com.example.testeorla.controler.ProjetoController;
import com.example.testeorla.model.Funcionario;
import com.example.testeorla.model.Projeto;
import com.example.testeorla.repository.FuncionarioRepository;
import com.example.testeorla.repository.ProjetoRepository;
import org.junit.Test;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import static javax.management.Query.times;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProjetoControllerTeste {

    @Mock
    private ProjetoRepository projetoRepository;

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @InjectMocks
    private ProjetoController projetoController;

    @Captor
    private ArgumentCaptor<Projeto> projetoCaptor;

    @Captor
    private ArgumentCaptor<Funcionario> funcionarioCaptor;

    @Captor
    private ArgumentCaptor<List<Projeto>> projetoListCaptor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializa os mocks
    }

    @Test
    public void testCadastrarProjeto() {
        // Simulando a entrada do usuário usando um Scanner
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextLine()).thenReturn("Projeto Alpha", "2025-03-25");

        // Substituindo o scanner no controller
        projetoController.setScanner(scannerMock);

        projetoController.cadastrarProjeto();

        verify(projetoRepository, times(1)).save(projetoCaptor.capture());

    }

    @Test
    public void testListarProjetosComFuncionarios() {
        // Criando uma lista de projetos mockados
        Projeto projeto1 = new Projeto();
        projeto1.setNome("Projeto Alpha");
        projeto1.setDataCriacao(Date.valueOf("2025-03-25"));

        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNome("João Silva");
        funcionario1.setCpf("123.456.789-00");

        Set<Funcionario> funcionarios = new HashSet<>();
        funcionarios.add(funcionario1);

        projeto1.setFuncionarios(funcionarios);

        List<Projeto> projetos = new ArrayList<>();
        projetos.add(projeto1);

        // Simulando o comportamento do repositório
        when(projetoRepository.findAll()).thenReturn(projetos);

        // Executando o método a ser testado
        projetoController.listarProjetosComFuncionarios();

        // Verificando se o repositório foi chamado corretamente
        verify(projetoRepository, times(1)).findAll();
    }
}
