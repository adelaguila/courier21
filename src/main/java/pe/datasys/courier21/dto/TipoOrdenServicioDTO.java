package pe.datasys.courier21.dto;

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
public class TipoOrdenServicioDTO {
    @EqualsAndHashCode.Include
    private Integer idTipoOrdenServicio;

    @NotNull
    @Size(min = 3, max = 100)
    private String nombreTipoOrdenServicio;
}
