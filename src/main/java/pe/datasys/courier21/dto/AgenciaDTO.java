package pe.datasys.courier21.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenciaDTO {
    private Integer idAgencia;

    @NotNull
    @Size(min = 3, max = 10)
    private String codigo;

    @NotNull
    @Size(min = 3, max = 150)
    private String nombreAgencia;
    private String direccion;
    private String telefono;
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
