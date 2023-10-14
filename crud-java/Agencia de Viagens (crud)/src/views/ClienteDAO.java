package views;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements AutoCloseable {
    
    public void inserir(Cliente cliente) {
        // implementation to insert a new client into the database
    }
    
    public void alterar(Cliente cliente) {
        // implementation to update an existing client in the database
    }
    
    public void excluir(Cliente cliente) {
        // implementation to delete a client from the database
    }
    
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        // implementation to retrieve all clients from the database and add them to the list
        return clientes;
    }

    public Cliente buscarClientePorId(int id) {
        Cliente cliente = null;
        // implementation to retrieve a client from the database by its id
        return cliente;
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }
}
