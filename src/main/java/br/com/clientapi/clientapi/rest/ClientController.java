package br.com.clientapi.clientapi.rest;

import br.com.clientapi.clientapi.model.entity.Client;
import br.com.clientapi.clientapi.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository repository;

    @Autowired
    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client insert(@RequestBody @Valid Client client) {
        return repository.save(client);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        repository.findById(id).map(client -> {
            repository.delete(client);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid Client clientUpdated) {
        repository.findById(id).map(client -> {
            clientUpdated.setIdClient(client.getIdClient());
            return repository.save(clientUpdated);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }

}
