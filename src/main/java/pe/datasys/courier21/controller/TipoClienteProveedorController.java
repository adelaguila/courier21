package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.TipoClienteProveedorDTO;
import pe.datasys.courier21.model.TipoClienteProveedor;
import pe.datasys.courier21.service.ITipoClienteProveedorService;
import pe.datasys.courier21.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/tipos-clientes-proveedores")
@RequiredArgsConstructor
public class TipoClienteProveedorController {
    private final ITipoClienteProveedorService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoClienteProveedorDTO>> findAll() throws Exception{
        List<TipoClienteProveedorDTO> list = mapperUtil.mapList(service.findAll(), TipoClienteProveedorDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoClienteProveedorDTO> findById(@PathVariable("id") Integer id) throws Exception{
        TipoClienteProveedor obj = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipoClienteProveedorDTO.class, "defaultMapper"));
    }


    @PostMapping
    public ResponseEntity<TipoClienteProveedorDTO> save(@Valid @RequestBody TipoClienteProveedorDTO dto) throws Exception{
        TipoClienteProveedor obj = service.save(mapperUtil.map(dto, TipoClienteProveedor.class));
        return new ResponseEntity<>(mapperUtil.map(obj, TipoClienteProveedorDTO.class, "defaultMapper"), HttpStatus.CREATED);
    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<TipoClienteProveedorDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<TipoClienteProveedorDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoClienteProveedorDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoClienteProveedorDTO dto) throws Exception{
        TipoClienteProveedor obj =  service.update(id, mapperUtil.map(dto, TipoClienteProveedor.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoClienteProveedorDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
