package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.TipoOrdenServicioDTO;
import pe.datasys.courier21.model.TipoOrdenServicio;
import pe.datasys.courier21.service.ITipoOrdenServicioService;
import pe.datasys.courier21.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/tipos-ordenes-servicios")
@RequiredArgsConstructor
public class TipoOrdenServicioController {
    private final ITipoOrdenServicioService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoOrdenServicioDTO>> findAll() throws Exception{
        List<TipoOrdenServicioDTO> list = mapperUtil.mapList(service.findAll(), TipoOrdenServicioDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoOrdenServicioDTO> findById(@PathVariable("id") Integer id) throws Exception{
        TipoOrdenServicio obj = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipoOrdenServicioDTO.class, "defaultMapper"));
    }

    @PostMapping
    public ResponseEntity<TipoOrdenServicioDTO> save(@Valid @RequestBody TipoOrdenServicioDTO dto) throws Exception{
        TipoOrdenServicio obj = service.save(mapperUtil.map(dto, TipoOrdenServicio.class));
        return new ResponseEntity<>(mapperUtil.map(obj, TipoOrdenServicioDTO.class, "defaultMapper"), HttpStatus.CREATED);
    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<TipoOrdenServicioDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<TipoOrdenServicioDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoOrdenServicioDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoOrdenServicioDTO dto) throws Exception{
        TipoOrdenServicio obj =  service.update(id, mapperUtil.map(dto, TipoOrdenServicio.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoOrdenServicioDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
