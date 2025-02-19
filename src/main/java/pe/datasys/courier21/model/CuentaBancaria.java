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
@Table(name = "cuentas_bancarias")
public class CuentaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCuentaBancaria;

    @ManyToOne
    @JoinColumn(name = "id_banco", nullable = false)
    private Banco banco;

    @ManyToOne
    @JoinColumn(name = "id_moneda", nullable = false)
    private Moneda moneda;

    @Column(length = 100, nullable = false)
    private String descripcion;

    @Column(length = 50, nullable = false)
    private String numero;

    @Column(length = 50, nullable = false)
    private String cci;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double saldoInicial;
}
