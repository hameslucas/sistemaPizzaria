/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Pedido;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author lucas.hames
 */
public class PedidoDaoImpl extends BaseDaoImpl<Pedido, Long>
                                     implements PedidoDao, Serializable{

    @Override
    public Pedido pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Pedido.class, id);
    }

    @Override
    public List<Pedido> pesquisarPorNumero(int numero, Session session) throws HibernateException {
        Query<Pedido> consulta = session
                 .createQuery("from Pedido p where p.numero = :numero");
        consulta.setParameter("numero", numero);
        return consulta.getResultList();
    }

    @Override
    public List<Pedido> pesquisarPorValorMaiorIgual(BigDecimal valor,
                              Session sessao) throws HibernateException {
       Query<Pedido> consulta = sessao
              .createQuery("from Pedido p where p.valor_total >= :valor");
        consulta.setParameter("valor", valor);
        return consulta.getResultList(); 
    }
    
}
