package fatec.ads.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repo;

    @Autowired
    private ClienteRepository clienteRepo;

    @GetMapping
    public List<Pedido> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido) {
        return repo.save(pedido);
    }

    @GetMapping("/cliente/{id}")
    public List<Pedido> listarPorCliente(@PathVariable Long id) {
        return repo.findAll().stream()
                .filter(p -> p.getCliente().getId().equals(id))
                .toList();
    }
}