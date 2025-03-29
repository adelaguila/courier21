package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.TipoEnvioDTO;
import pe.datasys.courier21.model.TipoEnvio;
import pe.datasys.courier21.service.ITipoEnvioService;
import pe.datasys.courier21.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/tipos-envios")
@RequiredArgsConstructor
public class TipoEnvioController {
    private final ITipoEnvioService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoEnvioDTO>> findAll() throws Exception{
        List<TipoEnvioDTO> list = mapperUtil.mapList(service.findAll(), TipoEnvioDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEnvioDTO> findById(@PathVariable("id") Integer id) throws Exception{
        TipoEnvio obj = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipoEnvioDTO.class, "defaultMapper"));
    }

    @PostMapping
    public ResponseEntity<TipoEnvioDTO> save(@Valid @RequestBody TipoEnvioDTO dto) throws Exception{
        TipoEnvio obj = service.save(mapperUtil.map(dto, TipoEnvio.class));
        return new ResponseEntity<>(mapperUtil.map(obj, TipoEnvioDTO.class, "defaultMapper"), HttpStatus.CREATED);
    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<TipoEnvioDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<TipoEnvioDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoEnvioDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoEnvioDTO dto) throws Exception{
        TipoEnvio obj =  service.update(id, mapperUtil.map(dto, TipoEnvio.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoEnvioDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
