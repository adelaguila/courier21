package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.TipoEmbalajeDTO;
import pe.datasys.courier21.model.TipoEmbalaje;
import pe.datasys.courier21.service.ITipoEmbalajeService;
import pe.datasys.courier21.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/tipos-embalajes")
@RequiredArgsConstructor
public class TipoEmbalajeController {
    private final ITipoEmbalajeService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoEmbalajeDTO>> findAll() throws Exception{
        List<TipoEmbalajeDTO> list = mapperUtil.mapList(service.findAll(), TipoEmbalajeDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEmbalajeDTO> findById(@PathVariable("id") Integer id) throws Exception{
        TipoEmbalaje obj = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipoEmbalajeDTO.class, "defaultMapper"));
    }

    @PostMapping
    public ResponseEntity<TipoEmbalajeDTO> save(@Valid @RequestBody TipoEmbalajeDTO dto) throws Exception{
        TipoEmbalaje obj = service.save(mapperUtil.map(dto, TipoEmbalaje.class));
        return new ResponseEntity<>(mapperUtil.map(obj, TipoEmbalajeDTO.class, "defaultMapper"), HttpStatus.CREATED);
    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<TipoEmbalajeDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<TipoEmbalajeDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoEmbalajeDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoEmbalajeDTO dto) throws Exception{
        TipoEmbalaje obj =  service.update(id, mapperUtil.map(dto, TipoEmbalaje.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoEmbalajeDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
