package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.AgenciaDTO;
import pe.datasys.courier21.dto.UbigeoDTO;
import pe.datasys.courier21.model.Agencia;
import pe.datasys.courier21.service.IAgenciaService;
import pe.datasys.courier21.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/agencias")
@RequiredArgsConstructor
public class AgenciaController {
    private final IAgenciaService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<AgenciaDTO>> findAll() throws Exception{
        List<AgenciaDTO> list = mapperUtil.mapList(service.findAll(), AgenciaDTO.class, "defaultMapper");

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgenciaDTO> findById(@PathVariable("id") Integer id) throws Exception{
        Agencia obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, AgenciaDTO.class, "defaultMapper"));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<AgenciaDTO> findOneByCodigo(@PathVariable("codigo") String codigo) throws Exception{
        Agencia obj = service.findOneByCodigo(codigo);

        return ResponseEntity.ok(mapperUtil.map(obj, AgenciaDTO.class, "defaultMapper"));
    }

    @PostMapping
    public ResponseEntity<AgenciaDTO> save(@Valid @RequestBody AgenciaDTO dto) throws Exception{
        Agencia obj = service.save(mapperUtil.map(dto, Agencia.class));

        return new ResponseEntity<>(mapperUtil.map(obj, AgenciaDTO.class, "defaultMapper"), HttpStatus.CREATED);

    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<AgenciaDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<AgenciaDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgenciaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody AgenciaDTO dto) throws Exception{
        Agencia obj =  service.update(id, mapperUtil.map(dto, Agencia.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, AgenciaDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
