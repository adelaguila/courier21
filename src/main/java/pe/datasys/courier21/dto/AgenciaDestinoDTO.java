package pe.datasys.courier21.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgenciaDestinoDTO {
    @EqualsAndHashCode.Include
    private Integer idAgenciaDestino;

    @NotNull
    private AgenciaDTO agencia;

    @NotNull
    private UbigeoDTO ubigeo;

    @NotNull
    @Size(min = 3, max = 150)
    private String destino;

    private double adicionalEntrega;

    private double adicionalRecojo;

    private boolean aceptaCollec;
}
