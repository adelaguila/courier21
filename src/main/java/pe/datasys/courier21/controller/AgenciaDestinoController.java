package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.AgenciaDTO;
import pe.datasys.courier21.dto.AgenciaDestinoDTO;
import pe.datasys.courier21.dto.tables.AgenciaDestinoTableDTO;
import pe.datasys.courier21.model.Agencia;
import pe.datasys.courier21.model.AgenciaDestino;
import pe.datasys.courier21.service.IAgenciaDestinoService;
import pe.datasys.courier21.service.IAgenciaService;
import pe.datasys.courier21.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/agencias-destinos")
@RequiredArgsConstructor
public class AgenciaDestinoController {
    private final IAgenciaDestinoService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<AgenciaDestinoDTO>> findAll() throws Exception{
        List<AgenciaDestinoDTO> list = mapperUtil.mapList(service.findAll(), AgenciaDestinoDTO.class, "defaultMapper");

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgenciaDestinoDTO> findById(@PathVariable("id") Integer id) throws Exception{
        AgenciaDestino obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, AgenciaDestinoDTO.class, "defaultMapper"));
    }

    @GetMapping("agencia/{id}")
    public ResponseEntity<List<AgenciaDestinoDTO>> findByAgenciaIdAgencia(@PathVariable("id") Integer id) throws Exception{
        List<AgenciaDestinoDTO> list = mapperUtil.mapList(service.findByAgenciaIdAgencia(id), AgenciaDestinoDTO.class, "defaultMapper");

        return ResponseEntity.ok(list);
    }

   
    @PostMapping
    public ResponseEntity<AgenciaDestinoDTO> save(@Valid @RequestBody AgenciaDestinoDTO dto) throws Exception{
        AgenciaDestino obj = service.save(mapperUtil.map(dto, AgenciaDestino.class));

        return new ResponseEntity<>(mapperUtil.map(obj, AgenciaDestinoDTO.class, "defaultMapper"), HttpStatus.CREATED);

    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<AgenciaDestinoTableDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<AgenciaDestinoTableDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgenciaDestinoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody AgenciaDestinoDTO dto) throws Exception{
        AgenciaDestino obj =  service.update(id, mapperUtil.map(dto, AgenciaDestino.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, AgenciaDestinoDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
