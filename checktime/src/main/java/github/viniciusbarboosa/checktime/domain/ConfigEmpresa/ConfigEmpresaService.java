package github.viniciusbarboosa.checktime.domain.ConfigEmpresa;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ConfigEmpresaService {
    private final ConfigEmpresaRepositorio configEmpresaRepositorio;

    public ConfigEmpresaService(ConfigEmpresaRepositorio configEmpresaRepositorio){
        this.configEmpresaRepositorio = configEmpresaRepositorio;
    }

    public ConfigEmpresa salvarConfigEmpresa(ConfigEmpresa configEmpresa) {
        //VERIFICAR LOGICA DPS
        return configEmpresaRepositorio.save(configEmpresa);
    }

    public Optional<ConfigEmpresa> obterConfigEmpresaPorId(String id) {
        return configEmpresaRepositorio.findById(id);
    }

    public List<ConfigEmpresa> obterTodasConfigEmpresas() {
        return configEmpresaRepositorio.findAll();
    }

    public ConfigEmpresa atualizarConfigEmpresa(String id, ConfigEmpresa novaConfigEmpresa) {
        // VERIFICACAO SE O ID EXISTE
        Optional<ConfigEmpresa> configEmpresaExistente = configEmpresaRepositorio.findById(id);

        if (configEmpresaExistente.isPresent()) {
            //ATUALIZA COFNIGS
            ConfigEmpresa configEmpresaAtualizada = configEmpresaExistente.get();
            configEmpresaAtualizada.setHoraPadraoEntrada(novaConfigEmpresa.getHoraPadraoEntrada());
            configEmpresaAtualizada.setHoraPadraoSaida(novaConfigEmpresa.getHoraPadraoSaida());
            configEmpresaAtualizada.setHoraPadraoIntervalo(novaConfigEmpresa.getHoraPadraoIntervalo());

            //SALVAMENTO
            return configEmpresaRepositorio.save(configEmpresaAtualizada);
        } else {
            // tratar exeçao dps
            throw new RuntimeException("ConfigEmpresa com o ID " + id + " não encontrada.");
        }
    }

}
