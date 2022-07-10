/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Pedido;
import static br.com.pizzaria.util.GeradorUtil.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas.hames
 */
public class PedidoDaoImplTest {

    private Pedido pedido;
    private PedidoDao pedidoDao;
    private Session sessao;

    public PedidoDaoImplTest() {
        pedidoDao = new PedidoDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        ClienteDaoImplTest cdit = new ClienteDaoImplTest();
        
        pedido = new Pedido(5, new BigDecimal(gerarNumero(3)), new Date());
        pedido.setCliente(cdit.buscarClienteBd());
        sessao = HibernateUtil.abrirConexao();
        pedidoDao.salvarOuAlterar(pedido, sessao);
        sessao.close();
        assertNotNull(pedido.getId());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
    }

//    @Test
    public void testPesquisarPorNumero() {
        System.out.println("pesquisarPorNumero");
    }

//    @Test
    public void testPesquisarPorValorMaiorIgual() {
        System.out.println("pesquisarPorValorMaiorIgual");
    }

}
