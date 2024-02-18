package github.viniciusbarboosa.checktime.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.viniciusbarboosa.checktime.domain.ConfigEmpresa.ConfigEmpresa;
import github.viniciusbarboosa.checktime.domain.ConfigEmpresa.ConfigEmpresaService;

@RestController
@RequestMapping("/api/configEmpresa")
public class ConfigEmpresaController {
    
    private final ConfigEmpresaService configEmpresaService;

    @Autowired
    public ConfigEmpresaController(ConfigEmpresaService configEmpresaService) {
        this.configEmpresaService = configEmpresaService;
    }

    @GetMapping
    public ResponseEntity<List<ConfigEmpresa>> obterTodasConfigEmpresas() {
        List<ConfigEmpresa> configEmpresas = configEmpresaService.obterTodasConfigEmpresas();
        return new ResponseEntity<>(configEmpresas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConfigEmpresa> criarConfigEmpresa(@RequestBody ConfigEmpresa configEmpresa) {
        ConfigEmpresa novaConfigEmpresa = configEmpresaService.salvarConfigEmpresa(configEmpresa);
        System.out.println("AQUIIIII "+novaConfigEmpresa);
        return new ResponseEntity<>(novaConfigEmpresa, HttpStatus.CREATED);
    }
}
