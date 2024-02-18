package github.viniciusbarboosa.checktime.domain.ConfigEmpresa;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name="config_empresa")
@Entity(name="config_empresa")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ConfigEmpresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome_empresa;
    private int horaPadraoEntrada;
    private int horaPadraoSaida;
    private int horaPadraoIntervalo;
}
