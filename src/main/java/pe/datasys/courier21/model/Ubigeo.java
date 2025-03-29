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

    @ManyToOne
    @JoinColumn(name = "id_agencia", nullable = false, foreignKey = @ForeignKey(name = "FK_UBIGEO_AGENCIA"))
    private Agencia agencia;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double adicionalEntrega = 0.0;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double adicionalRecojo = 0.0;

    @Column(nullable = false)
    private boolean aceptaCollec = false;

}
