package pe.datasys.courier21.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    @JoinColumn(name = "id_agencia", nullable = false)
    private AgenciaEntity agencia;

    @ManyToOne //FK
    @JoinColumn(name = "id_ubigeo", nullable = false)
    private UbigeoEntity ubigeo;

    private BigDecimal adicionalEntrega;

    private BigDecimal adicionalRecojo;

    private Boolean aceptaCollec;

}
