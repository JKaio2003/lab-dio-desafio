package one.digitalinnovation.repository;

import one.digitalinnovation.model.Cliente;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class RepositorioCliente {
    private Set<Cliente> clientes;
    public void save(String nome, LocalDate dataNascimento, String estado, String cidade, String rua, String numero) {
        if (clientes == null) {
            clientes = new HashSet<>();
            clientes.add(Cliente.getInstance(nome, dataNascimento, estado, cidade, rua, numero));
        } else {
            Cliente cliente = clientes.stream()
                    .filter(n -> n.getNome().equalsIgnoreCase(nome))
                    .findFirst()
                    .orElse(null);
            clientes.remove(cliente);
            clientes.add(Cliente.getInstance(nome, dataNascimento, estado, cidade, rua, numero));
        }
    }

    public List<Cliente> findAll() {
        if (clientes != null) {
            Set<Cliente> clientesOrdenados = new TreeSet<>(clientes);
            return clientesOrdenados.stream().toList();
        }
        return new ArrayList<>();
    }

    public Cliente findByName(String nome) {
        return clientes.stream()
                .filter(n -> n.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public void deleteByName(String nome) {
        Cliente cliente = clientes.stream()
                .filter(n -> n.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);

        if (clientes != null)
            if (cliente != null) {
                System.out.println("Deletando cliente " + cliente.getNome());
                clientes.remove(cliente);
            } else {
                System.out.println("Esse cliente não existe...");
            }
    }
}
