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
public class UbigeoDTO {
    @EqualsAndHashCode.Include
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

    @NotNull
    private AgenciaDTO agencia;

    private double adicionalEntrega;

    private double adicionalRecojo;

    private boolean aceptaCollec;

}
