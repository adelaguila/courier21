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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgenciaDTO {
    @EqualsAndHashCode.Include
    private Integer idAgencia;

    @NotNull
    @Size(min = 3, max = 10)
    private String codigo;

    @NotNull
    @Size(min = 3, max = 150)
    private String nombreAgencia;
    @NotNull
    @Size(min = 3, max = 150)
    private String nombreAgente;
    @NotNull
    @Size(min = 8, max = 8)
    private String dniAgente;

    @NotNull
    private String direccion;

    @NotNull
    private String telefono;

    @NotNull
    private String correo;

    private String latitud;
    private String longitud;

    @NotNull
    private UbigeoDTO ubigeo;

    @NotNull
    private TipoAgenciaDTO tipoAgencia;

    @NotNull
    private boolean activo;

}
