package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.TipoAgenciaDTO;
import pe.datasys.courier21.dto.TipoClienteProveedorDTO;
import pe.datasys.courier21.model.TipoAgencia;
import pe.datasys.courier21.service.ITipoAgenciaService;
import pe.datasys.courier21.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/tipos-agencias")
@RequiredArgsConstructor
public class TipoAgenciaController {
    private final ITipoAgenciaService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoAgenciaDTO>> findAll() throws Exception{
        List<TipoAgenciaDTO> list = mapperUtil.mapList(service.findAll(), TipoAgenciaDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoAgenciaDTO> findById(@PathVariable("id") Integer id) throws Exception{
        TipoAgencia obj = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipoAgenciaDTO.class, "defaultMapper"));
    }

    @PostMapping
    public ResponseEntity<TipoAgenciaDTO> save(@Valid @RequestBody TipoAgenciaDTO dto) throws Exception{
        TipoAgencia obj = service.save(mapperUtil.map(dto, TipoAgencia.class));
        return new ResponseEntity<>(mapperUtil.map(obj, TipoAgenciaDTO.class, "defaultMapper"), HttpStatus.CREATED);
    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<TipoAgenciaDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<TipoAgenciaDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoAgenciaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoAgenciaDTO dto) throws Exception{
        TipoAgencia obj =  service.update(id, mapperUtil.map(dto, TipoAgencia.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoAgenciaDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
