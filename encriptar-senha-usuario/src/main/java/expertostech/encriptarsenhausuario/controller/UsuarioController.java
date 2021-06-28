package expertostech.encriptarsenhausuario.controller;

import expertostech.encriptarsenhausuario.model.UsuarioModel;
import expertostech.encriptarsenhausuario.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/listarTodos")
    public ResponseEntity<List<UsuarioModel>>listarTodos(){

        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioModel> salvar(@RequestBody UsuarioModel usuario){
        return ResponseEntity.ok(repository.save(usuario));
    }
}
