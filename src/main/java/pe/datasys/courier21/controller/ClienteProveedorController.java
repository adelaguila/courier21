package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.ClienteProveedorDTO;
import pe.datasys.courier21.dto.ClienteProveedorDireccionDTO;
import pe.datasys.courier21.dto.UbigeoDTO;
import pe.datasys.courier21.dto.tables.ClienteProveedorTableDTO;
import pe.datasys.courier21.model.ClienteProveedor;
import pe.datasys.courier21.model.ClienteProveedorDireccion;
import pe.datasys.courier21.service.IClienteProveedorDireccionService;
import pe.datasys.courier21.service.IClienteProveedorService;
import pe.datasys.courier21.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/clientes-proveedores")
@RequiredArgsConstructor
public class ClienteProveedorController {
    private final IClienteProveedorService service;
    private final IClienteProveedorDireccionService serviceDireccion;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ClienteProveedorDTO>> findAll() throws Exception{
        List<ClienteProveedorDTO> list = mapperUtil.mapList(service.findAll(), ClienteProveedorDTO.class, "defaultMapper");

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteProveedorDTO> findById(@PathVariable("id") Long id) throws Exception{
        ClienteProveedor obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, ClienteProveedorDTO.class, "defaultMapper"));
    }

    @GetMapping("/numero-documento-identidad/{numeroDocumentoIdentidad}")
    public ResponseEntity<ClienteProveedorDTO> findOneByNumeroDocumentoIdentidad(@PathVariable("numeroDocumentoIdentidad") String numeroDocumentoIdentidad) throws Exception{
        ClienteProveedor obj = service.findOneByNumeroDocumentoIdentidad(numeroDocumentoIdentidad);
        ClienteProveedorDTO objDTO = null;

        if(obj != null){
            objDTO = mapperUtil.map(obj, ClienteProveedorDTO.class, "defaultMapper");
        }
        return ResponseEntity.ok(objDTO);
    }

    @GetMapping("/autocomplete/{term}")
    public ResponseEntity<List<ClienteProveedorDTO>> autocomplete(@PathVariable("term") String term) throws Exception{
        List<ClienteProveedorDTO> list = mapperUtil.mapList(service.getAutocomplete(term), ClienteProveedorDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<ClienteProveedorTableDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<ClienteProveedorTableDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteProveedorDTO> save(@Valid @RequestBody ClienteProveedorDTO dto) throws Exception{
        ClienteProveedor obj = service.save(mapperUtil.map(dto, ClienteProveedor.class));
        return new ResponseEntity<>(mapperUtil.map(obj, ClienteProveedorDTO.class, "defaultMapper"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteProveedorDTO> update(@Valid @PathVariable("id") Long id, @RequestBody ClienteProveedorDTO dto) throws Exception{
        ClienteProveedor obj =  service.update(id, mapperUtil.map(dto, ClienteProveedor.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, ClienteProveedorDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/direccion/{id}")
    public ResponseEntity<ClienteProveedorDireccionDTO> updateDireccion(@Valid @PathVariable("id") Long id, @RequestBody ClienteProveedorDireccionDTO dto) throws Exception{
        ClienteProveedorDireccion obj =  serviceDireccion.update(id, mapperUtil.map(dto, ClienteProveedorDireccion.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, ClienteProveedorDireccionDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/direccion/{id}")
    public ResponseEntity<Void> deleteDireccion(@PathVariable("id") Long id) throws Exception{
        serviceDireccion.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
