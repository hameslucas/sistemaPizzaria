/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.webservice;

import br.com.pizzaria.entidade.EnderecoDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 *
 * @author lucas.hames
 */
public class CepRest {

    private Client client;
    private WebResource webResource;

    public CepRest() {
        ClientConfig clientConfig
                = new DefaultClientConfig(GensonProvider.class);
        client = Client.create(clientConfig);
        webResource = client.resource("https://viacep.com.br/ws/");
    }

    public EnderecoDTO pesquisarCep(String cep) {
        try {
            return webResource.path(cep).path("/json").get(EnderecoDTO.class);
        } catch (UniformInterfaceException | ClientHandlerException ue) {
            return null;
        }
    }

    public static void main(String[] args) {
        CepRest rest = new CepRest();
        EnderecoDTO endereco = rest.pesquisarCep("88110400");

        System.out.println("Log: " + endereco.getLogradouro());
        System.out.println("Bairro: " + endereco.getBairro());
        System.out.println("Uf: " + endereco.getUf());
        System.out.println("Cidade: " + endereco.getLocalidade());
    }

}
