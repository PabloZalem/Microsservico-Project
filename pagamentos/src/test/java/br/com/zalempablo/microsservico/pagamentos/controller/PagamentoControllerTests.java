package br.com.zalempablo.microsservico.pagamentos.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.zalempablo.microsservico.pagamentos.dto.PagamentoDTO;
import br.com.zalempablo.microsservico.pagamentos.service.PagamentoService;

@WebMvcTest(PagamentoController.class)
public class PagamentoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PagamentoService pagamentoService;

    private List<PagamentoDTO> pagamentoDTOList;

    @BeforeEach
    public void setUp() {
        this.pagamentoDTOList = new ArrayList<>();
        // Inicialize a lista de PagamentoDTO com dados de teste, se necessário
    }

    @Test
    public void testListarPagamentos() throws Exception {
        Page<PagamentoDTO> pagamentosPage = new PageImpl<>(pagamentoDTOList);
        when(pagamentoService.obterTodos(any(Pageable.class))).thenReturn(pagamentosPage);

        mockMvc.perform(get("/pagamentos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content.length()").value(pagamentoDTOList.size()));
    }

    @Test
    public void testDetalharPagamento() throws Exception {
        Long pagamentoId = 1L;
        PagamentoDTO pagamentoDTO = new PagamentoDTO(); // Preencha com os dados de teste

        when(pagamentoService.obterPorId(pagamentoId)).thenReturn(pagamentoDTO);

        mockMvc.perform(get("/pagamentos/{id}", pagamentoId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(pagamentoDTO.getId()));
    }

    @Test
    public void testCadastrarPagamento() throws Exception {
        // Crie um objeto PagamentoDTO com valores fictícios
        PagamentoDTO pagamentoDTO = new PagamentoDTO();
        pagamentoDTO.setValor(new BigDecimal("100.50"));
        pagamentoDTO.setNome("João da Silva");

        // Mock do serviço para retornar o pagamentoDTO criado
        when(pagamentoService.criarPagamento(any(PagamentoDTO.class))).thenReturn(pagamentoDTO);

        // Execute a requisição POST para "/pagamentos"
        mockMvc.perform(post("/pagamentos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(pagamentoDTO)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "http://localhost/pagamentos/"));
    }
}
