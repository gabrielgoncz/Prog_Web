package fatec.ads.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    // GET (listar todos)
    @GetMapping
    public List<Cliente> listar() {
        return service.listarTodos();
    }

    // GET por ID
    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // POST (criar)
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    // PUT (atualizar)
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return service.atualizar(id, cliente);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}