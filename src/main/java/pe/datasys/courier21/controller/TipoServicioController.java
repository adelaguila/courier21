package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.TipoServicioDTO;
import pe.datasys.courier21.model.TipoServicio;
import pe.datasys.courier21.service.ITipoServicioService;
import pe.datasys.courier21.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/tipos-servicios")
@RequiredArgsConstructor
public class TipoServicioController {
    private final ITipoServicioService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoServicioDTO>> findAll() throws Exception{
        List<TipoServicioDTO> list = mapperUtil.mapList(service.findAll(), TipoServicioDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoServicioDTO> findById(@PathVariable("id") Integer id) throws Exception{
        TipoServicio obj = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipoServicioDTO.class, "defaultMapper"));
    }

    @PostMapping
    public ResponseEntity<TipoServicioDTO> save(@Valid @RequestBody TipoServicioDTO dto) throws Exception{
        TipoServicio obj = service.save(mapperUtil.map(dto, TipoServicio.class));
        return new ResponseEntity<>(mapperUtil.map(obj, TipoServicioDTO.class, "defaultMapper"), HttpStatus.CREATED);
    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<TipoServicioDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<TipoServicioDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoServicioDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoServicioDTO dto) throws Exception{
        TipoServicio obj =  service.update(id, mapperUtil.map(dto, TipoServicio.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoServicioDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
