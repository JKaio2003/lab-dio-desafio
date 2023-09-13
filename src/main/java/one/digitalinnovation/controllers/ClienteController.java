package one.digitalinnovation.controllers;

import one.digitalinnovation.model.Cliente;
import one.digitalinnovation.repository.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private RepositorioCliente repository;

    @PostMapping
    public void save(String nome, LocalDate dataNascimento, String estado, String cidade, String rua, String numero) {
        repository.save(nome, dataNascimento, estado, cidade, rua, numero);
    }

    @PutMapping
    public void update(String nome, LocalDate dataNascimento, String estado, String cidade, String rua, String numero) {
        repository.save(nome, dataNascimento, estado, cidade, rua, numero);
    }

    @GetMapping
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{nome}")
    public Cliente findByname(@PathVariable("nome") String nome) {
       return repository.findByName(nome);
    }

    @DeleteMapping("/{nome}")
    public void deleteByName(@PathVariable("nome") String nome) {
        repository.deleteByName(nome);
    }
}
