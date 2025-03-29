package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.OrdenServicioDTO;
import pe.datasys.courier21.dto.tables.OrdenServicioTableDTO;
import pe.datasys.courier21.model.OrdenServicio;
import pe.datasys.courier21.service.IOrdenServicioService;
import pe.datasys.courier21.util.MapperUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/ordenes-servicios")
@RequiredArgsConstructor
public class OrdenServicioController {
    private final IOrdenServicioService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<OrdenServicioDTO>> findAll() throws Exception{
        List<OrdenServicioDTO> list = mapperUtil.mapList(service.findAll(), OrdenServicioDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenServicioDTO> findById(@PathVariable("id") String id) throws Exception{
        OrdenServicio obj = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, OrdenServicioDTO.class, "defaultMapper"));
    }

    @GetMapping("/numero/{numero}")
    public ResponseEntity<OrdenServicioDTO> findOneByCodigo(@PathVariable("numero") String numero) throws Exception{
        OrdenServicio obj = service.findOneByIdOrdenServicio(numero);

        return ResponseEntity.ok(mapperUtil.map(obj, OrdenServicioDTO.class, "defaultMapper"));
    }

    @GetMapping("/lista/numero/{numero}")
    public ResponseEntity<List<OrdenServicioDTO>> findByCodigo(@PathVariable("numero") String numero) throws Exception{
        List<OrdenServicioDTO> list = mapperUtil.mapList(service.findByIdOrdenServicio(numero), OrdenServicioDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/fecha-registro/{inicio}/{fin}")
    public ResponseEntity<List<OrdenServicioDTO>> findByFechaRegistroBetween(@PathVariable("inicio") String inicio, @PathVariable("fin") String fin) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<OrdenServicioDTO> lista = mapperUtil.mapList(service.findByFechaHoraRegistroBetween(LocalDateTime.parse(inicio + " 00:00:00", formatter), LocalDateTime.parse(fin + " 00:00:00", formatter)), OrdenServicioDTO.class, "defaultMapper");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrdenServicioDTO> save(@Valid @RequestBody OrdenServicioDTO dto) throws Exception{
        OrdenServicio obj = service.save(mapperUtil.map(dto, OrdenServicio.class));
        return new ResponseEntity<>(mapperUtil.map(obj, OrdenServicioDTO.class, "defaultMapper"), HttpStatus.CREATED);
    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<OrdenServicioTableDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<OrdenServicioTableDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PutMapping("/{numero}")
    public ResponseEntity<OrdenServicioDTO> update(@Valid @PathVariable("numero") String numero, @RequestBody OrdenServicioDTO dto) throws Exception{
        OrdenServicio obj =  service.update(numero, mapperUtil.map(dto, OrdenServicio.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, OrdenServicioDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
