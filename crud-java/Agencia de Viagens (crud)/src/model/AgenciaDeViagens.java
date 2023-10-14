package model;

import java.util.ArrayList;
import java.util.List;

import views.Cliente;

public class AgenciaDeViagens {
    private List<Cliente> clientes;
    private List<PacoteDeViagem> pacotesDeViagem;
    private List<Destino> destinos;
    private List<Fornecedor> fornecedores;

    public AgenciaDeViagens() {
        clientes = new ArrayList<>();
        pacotesDeViagem = new ArrayList<>();
        destinos = new ArrayList<>();
        fornecedores = new ArrayList<>();
    }

    // Operações CRUD para Cliente
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(int id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.remove(i);
                break;
            }
        }
    }

    public void atualizarCliente(int id, Cliente novoCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.set(i, novoCliente);
                break;
            }
        }
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    // Operações CRUD para PacoteDeViagem
    public void adicionarPacoteDeViagem(PacoteDeViagem pacoteDeViagem) {
        pacotesDeViagem.add(pacoteDeViagem);
    }

    public void removerPacoteDeViagem(int id) {
        for (int i = 0; i < pacotesDeViagem.size(); i++) {
            if (pacotesDeViagem.get(i).getId() == id) {
                pacotesDeViagem.remove(i);
                break;
            }
        }
    }

    public void atualizarPacoteDeViagem(int id, PacoteDeViagem novoPacoteDeViagem) {
        for (int i = 0; i < pacotesDeViagem.size(); i++) {
            if (pacotesDeViagem.get(i).getId() == id) {
                pacotesDeViagem.set(i, novoPacoteDeViagem);
                break;
            }
        }
    }

    public List<PacoteDeViagem> listarPacotesDeViagem() {
        return pacotesDeViagem;
    }

    // Operações CRUD para Destino
    public void adicionarDestino(Destino destino) {
        destinos.add(destino);
    }

    public void removerDestino(int id) {
        for (int i = 0; i < destinos.size(); i++) {
            if (destinos.get(i).getId() == id) {
                destinos.remove(i);
                break;
            }
        }
    }

    public void atualizarDestino(int id, Destino novoDestino) {
        for (int i = 0; i < destinos.size(); i++) {
            if (destinos.get(i).getId() == id) {
                destinos.set(i, novoDestino);
                break;
            }
        }
    }

    public List<Destino> listarDestinos() {
        return destinos;
    }

    // Operações CRUD para Fornecedor
    public void adicionarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public void removerFornecedor(int id) {
        for (int i = 0; i < fornecedores.size(); i++) {
            if (fornecedores.get(i).getId() == id) {
                fornecedores.remove(i);
                break;
            }
        }
    }

    public void atualizarFornecedor(int id, Fornecedor novoFornecedor) {
        for (int i = 0; i < fornecedores.size(); i++) {
            if (fornecedores.get(i).getId() == id) {
                fornecedores.set(i, novoFornecedor);
                break;
            }
        }
    }

    public List<Fornecedor> listarFornecedores() {
        return fornecedores;
    }
}
