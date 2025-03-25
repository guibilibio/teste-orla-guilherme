package com.example.testeorla.test;

import com.example.testeorla.controler.FuncionarioController;
import com.example.testeorla.model.Funcionario;
import com.example.testeorla.repository.FuncionarioRepository;
import com.example.testeorla.repository.ProjetoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static javax.management.Query.times;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FuncionarioControllerTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @Mock
    private ProjetoRepository projetoRepository;

    @InjectMocks
    private FuncionarioController funcionarioController;

    @Captor
    private ArgumentCaptor<Funcionario> funcionarioCaptor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarFuncionario() {
        Scanner scannerMock = Mockito.mock(Scanner.class);
        Mockito.when(scannerMock.nextLine()).thenReturn("João Silva", "123.456.789-00", "joao@exemplo.com");
        Mockito.when(scannerMock.nextDouble()).thenReturn(2500.00);

        funcionarioController.cadastrarFuncionario();

        verify(funcionarioRepository, times(1)).save(funcionarioCaptor.capture());

        Funcionario funcionarioSalvo = funcionarioCaptor.getValue();
        assertNotNull(funcionarioSalvo);
        assertEquals("João Silva", funcionarioSalvo.getNome());
        assertEquals("123.456.789-00", funcionarioSalvo.getCpf());
        assertEquals("joao@exemplo.com", funcionarioSalvo.getEmail());
        assertEquals(Optional.of(2500.00), funcionarioSalvo.getSalario());
    }

    @Test
    public void testListarFuncionariosComProjetos() {
        // Criando uma lista de funcionários mockados
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNome("João Silva");
        funcionario1.setCpf("123.456.789-00");

        Funcionario funcionario2 = new Funcionario();
        funcionario2.setNome("Maria Oliveira");
        funcionario2.setCpf("987.654.321-00");

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);

        Mockito.when(funcionarioRepository.findAll()).thenReturn(funcionarios);

        funcionarioController.listarFuncionariosComProjetos();
    }
}
