package pe.datasys.courier21.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "agencias")
public class Agencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idAgencia;

    @Column(length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(length = 150, nullable = false)
    private String nombreAgencia;

    @Column(length = 150, nullable = false)
    private String nombreAgente;

    @Column(length = 8, nullable = false)
    private String dniAgente;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String latitud;

    @Column(nullable = false)
    private String longitud;

    @ManyToOne //FK
    @JoinColumn(name = "id_ubigeo", nullable = false, foreignKey = @ForeignKey(name = "FK_AGENCIA_UBIGEO"))
    private Ubigeo ubigeo;

    @ManyToOne //FK
    @JoinColumn(name = "id_tipo_agencia", nullable = false, foreignKey = @ForeignKey(name = "FK_AGENCIA_TIPO_AGENCIA"))
    private TipoAgencia tipoAgencia;

    @Column(nullable = false)
    private boolean activo = true;
}
