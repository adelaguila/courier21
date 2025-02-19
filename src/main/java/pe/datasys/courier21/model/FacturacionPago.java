package pe.datasys.courier21.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "facturacion_pagos")
public class FacturacionPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idFacturacionPago;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_facturacion", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURACION_PAGO_FACTURACION"))
    private Facturacion facturacion;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURACION_PAGO_METODO_PAGO"))
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_bancaria", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURACION_PAGO_CUENTA_BANCARIA"))
    private CuentaBancaria cuentaBancaria;

    @Column(nullable = false)
    private String referencia;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double monto;
}
