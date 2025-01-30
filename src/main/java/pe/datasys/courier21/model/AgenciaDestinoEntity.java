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
@Table(name = "agencias_destinos")
public class AgenciaDestinoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idAgenciaDestino;

    @ManyToOne //FK
    @JoinColumn(name = "id_agencia", nullable = false, foreignKey = @ForeignKey(name = "FK_AGENCIA_DESTINO_AGENCIA"))
    private AgenciaEntity agencia;

    @ManyToOne //FK
    @JoinColumn(name = "id_ubigeo", nullable = false, foreignKey = @ForeignKey(name = "FK_AGENCIA_DESTINO_UBIGEO"))
    private UbigeoEntity ubigeo;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double adicionalEntrega = 0.0;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double adicionalRecojo = 0.0;

    @Column(nullable = false)
    private boolean aceptaCollec = false;

}
