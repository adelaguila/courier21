package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.TarifarioDTO;
import pe.datasys.courier21.dto.tables.TarifarioTableDTO;
import pe.datasys.courier21.model.Tarifario;
import pe.datasys.courier21.service.ITarifarioService;
import pe.datasys.courier21.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/tarifarios")
@RequiredArgsConstructor
public class TarifarioController {
    private final ITarifarioService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TarifarioDTO>> findAll() throws Exception{
        List<TarifarioDTO> list = mapperUtil.mapList(service.findAll(), TarifarioDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/general")
    public ResponseEntity<List<TarifarioDTO>> getTarifaGeneral() throws Exception{
        List<TarifarioDTO> list = mapperUtil.mapList(service.getTarifasGeneral(), TarifarioDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/cliente/{idClienteProveedor}")
    public ResponseEntity<List<TarifarioDTO>> getTarifaCliente(@PathVariable("idClienteProveedor") Long idClienteProveedor) throws Exception{
        List<TarifarioDTO> list = mapperUtil.mapList(service.getTarifasCliente(idClienteProveedor), TarifarioDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarifarioDTO> findById(@PathVariable("id") Long id) throws Exception{
        Tarifario obj = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TarifarioDTO.class, "defaultMapper"));
    }

    @PostMapping
    public ResponseEntity<TarifarioDTO> save(@Valid @RequestBody TarifarioDTO dto) throws Exception{
        Tarifario obj = service.save(mapperUtil.map(dto, Tarifario.class));
        return new ResponseEntity<>(mapperUtil.map(obj, TarifarioDTO.class, "defaultMapper"), HttpStatus.CREATED);
    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<TarifarioTableDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<TarifarioTableDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PutMapping("/{idTarifa}")
    public ResponseEntity<TarifarioDTO> update(@Valid @PathVariable("idTarifa") Long idTarifa, @RequestBody TarifarioDTO dto) throws Exception{
        Tarifario obj =  service.update(idTarifa, mapperUtil.map(dto, Tarifario.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, TarifarioDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
