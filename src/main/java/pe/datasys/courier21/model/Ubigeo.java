package pe.datasys.courier21.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ubigeos")
public class Ubigeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idUbigeo;

    @Column(length = 10, nullable = false)
    private String codigo;

    @Column(length = 150, nullable = false)
    private String departamento;

    @Column(length = 150, nullable = false)
    private String provincia;

    @Column(length = 150, nullable = false)
    private String distrito;

}
