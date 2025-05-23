package pe.datasys.courier21.dto.tables;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pe.datasys.courier21.dto.AgenciaDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class UbigeoTableDTO {
    @EqualsAndHashCode.Include
    private Integer idUbigeo;

    private String codigo;

    private String departamento;

    private String provincia;

    private String distrito;

    private String nombreAgencia;

    private double adicionalEntrega;

    private double adicionalRecojo;

    private boolean aceptaCollec;

}
