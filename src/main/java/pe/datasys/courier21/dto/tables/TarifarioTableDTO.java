package pe.datasys.courier21.dto.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class TarifarioTableDTO {
    @EqualsAndHashCode.Include
    private Long idTarifario;
    private String nombreRazonSocial;
    private String area;
    private String distrito;
    private String destino;
    private String nombretTipoServicio;
    private String nombreTipoEnvio;
    private double pesoCondicional;
    private double tarifaMinima;
    private double tarifaExeso;
    private double pesoMinimo;
    private boolean collect;
}
