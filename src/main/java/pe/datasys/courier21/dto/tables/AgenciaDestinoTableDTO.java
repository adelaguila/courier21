package pe.datasys.courier21.dto.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AgenciaDestinoTableDTO {
    @EqualsAndHashCode.Include
    private Integer idAgenciaDestino;
    private String nombreAgencia;
    private String destino;
    private double adicionalEntrega;
    private double adicionalRecojo;
    private boolean aceptaCollec;
}
