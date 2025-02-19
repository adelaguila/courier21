package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.SunatTipoDocumentoIdentidadDTO;
import pe.datasys.courier21.model.SunatTipoDocumentoIdentidad;
import pe.datasys.courier21.service.ISunatTipoDocumentoIdentidadService;
import pe.datasys.courier21.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/sunat-tipos-documentos-identidad")
@RequiredArgsConstructor
public class SunatTipoDocumentoIdentidadController {
    private final ISunatTipoDocumentoIdentidadService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<SunatTipoDocumentoIdentidadDTO>> findAll() throws Exception{
        List<SunatTipoDocumentoIdentidadDTO> list = mapperUtil.mapList(service.findAll(), SunatTipoDocumentoIdentidadDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SunatTipoDocumentoIdentidadDTO> findById(@PathVariable("id") String id) throws Exception{
        SunatTipoDocumentoIdentidad obj = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, SunatTipoDocumentoIdentidadDTO.class, "defaultMapper"));
    }


    @PostMapping
    public ResponseEntity<SunatTipoDocumentoIdentidadDTO> save(@Valid @RequestBody SunatTipoDocumentoIdentidadDTO dto) throws Exception{
        SunatTipoDocumentoIdentidad obj = service.save(mapperUtil.map(dto, SunatTipoDocumentoIdentidad.class));
        return new ResponseEntity<>(mapperUtil.map(obj, SunatTipoDocumentoIdentidadDTO.class, "defaultMapper"), HttpStatus.CREATED);
    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<SunatTipoDocumentoIdentidadDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<SunatTipoDocumentoIdentidadDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SunatTipoDocumentoIdentidadDTO> update(@Valid @PathVariable("id") String id, @RequestBody SunatTipoDocumentoIdentidadDTO dto) throws Exception{
        SunatTipoDocumentoIdentidad obj =  service.update(id, mapperUtil.map(dto, SunatTipoDocumentoIdentidad.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, SunatTipoDocumentoIdentidadDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
