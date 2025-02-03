package pe.datasys.courier21.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UbigeoDTO {
    private Integer idUbigeo;

    @NotNull
    @Size(min = 3, max = 10)
    private String codigo;

    @NotNull
    @Size(min = 3, max = 150)
    private String departamento;
    @NotNull
    @Size(min = 3, max = 150)
    private String provincia;
    @NotNull
    @Size(min = 3, max = 150)
    private String distrito;

}
