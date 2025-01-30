package pe.datasys.courier21.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "fletes")
public class FleteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idFlete;

    private LocalDate fecha;

    @Column(length = 50, nullable = false)
    private String documento;

    @ManyToOne
    @JoinColumn(name = "id_cliente_proveedor", nullable = false, foreignKey = @ForeignKey(name = "FK_FLETE_CLIENTE_PROVEEDOR"))
    private ClienteProveedorEntity clienteProveedor;

    @Column(length = 150, nullable = false)
    private String glosa;

    private double importe;

    private Integer piezas;

    private double peso;

    @ManyToOne
    @JoinColumn(name = "id_agencia_destino", nullable = false, foreignKey = @ForeignKey(name = "FK_FLETE_AGENCIA_DESTINO"))
    private AgenciaEntity agenciaDestino;

    private String estadoOperacion;

    private LocalDate fechaRecojo;

    private String observacionRecojo;

    private LocalDateTime fechaHoraAlerta;

    private String nombreAlertado;

}
