package pe.datasys.courier21.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "facturacion_pagos")
public class FacturacionPagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idFacturacionPago;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_facturacion", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURACION_PAGO_FACTURACION"))
    private FacturacionEntity facturacion;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURACION_PAGO_METODO_PAGO"))
    private MetodoPagoEntity metodoPago;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_bancaria", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURACION_PAGO_CUENTA_BANCARIA"))
    private CuentaBancariaEntity cuentaBancaria;

    @Column(nullable = false)
    private String referencia;

    @Column(nullable = false, columnDefinition = "decimal(6, 2)")
    private double monto;
}
