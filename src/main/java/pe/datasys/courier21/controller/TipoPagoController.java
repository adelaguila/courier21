package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.TipoPagoDTO;
import pe.datasys.courier21.model.TipoPago;
import pe.datasys.courier21.service.ITipoPagoService;
import pe.datasys.courier21.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/tipos-pagos")
@RequiredArgsConstructor
public class TipoPagoController {
    private final ITipoPagoService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoPagoDTO>> findAll() throws Exception{
        List<TipoPagoDTO> list = mapperUtil.mapList(service.findAll(), TipoPagoDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPagoDTO> findById(@PathVariable("id") Integer id) throws Exception{
        TipoPago obj = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipoPagoDTO.class, "defaultMapper"));
    }

    @PostMapping
    public ResponseEntity<TipoPagoDTO> save(@Valid @RequestBody TipoPagoDTO dto) throws Exception{
        TipoPago obj = service.save(mapperUtil.map(dto, TipoPago.class));
        return new ResponseEntity<>(mapperUtil.map(obj, TipoPagoDTO.class, "defaultMapper"), HttpStatus.CREATED);
    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<TipoPagoDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<TipoPagoDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPagoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoPagoDTO dto) throws Exception{
        TipoPago obj =  service.update(id, mapperUtil.map(dto, TipoPago.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoPagoDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
