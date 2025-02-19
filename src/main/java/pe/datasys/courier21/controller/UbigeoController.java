package pe.datasys.courier21.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.datasys.courier21.commons.PaginationModel;
import pe.datasys.courier21.dto.UbigeoDTO;
import pe.datasys.courier21.model.Ubigeo;
import pe.datasys.courier21.service.IUbigeoService;
import pe.datasys.courier21.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/ubigeos")
@RequiredArgsConstructor
public class UbigeoController {
    private final IUbigeoService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<UbigeoDTO>> findAll() throws Exception{
        List<UbigeoDTO> list = mapperUtil.mapList(service.findAll(), UbigeoDTO.class, "defaultMapper");

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbigeoDTO> findById(@PathVariable("id") Integer id) throws Exception{
        Ubigeo obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, UbigeoDTO.class, "defaultMapper"));
    }

    @GetMapping("/find/codigo/{codigo}")
    public ResponseEntity<UbigeoDTO> findByCodigo(@PathVariable("codigo") String codigo) throws Exception{
        Ubigeo obj = service.findOneByCodigo(codigo);
        return ResponseEntity.ok(mapperUtil.map(obj, UbigeoDTO.class, "defaultMapper"));
    }

    @GetMapping("/find/distrito/contains/{distrito}")
    public ResponseEntity<List<UbigeoDTO>> findByDistritoLike(@PathVariable("distrito") String distrito) throws Exception{

        List<UbigeoDTO> list = mapperUtil.mapList(service.findByDistritoContains(distrito), UbigeoDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/autocomplete/{term}")
    public ResponseEntity<List<UbigeoDTO>> autocomplete(@PathVariable("term") String term) throws Exception{

        List<UbigeoDTO> list = mapperUtil.mapList(service.getAutocomplete(term), UbigeoDTO.class, "defaultMapper");
        return ResponseEntity.ok(list);
    }

    @PostMapping("/paginate")
    public ResponseEntity<Page<UbigeoDTO>> paginate(@RequestBody PaginationModel pagination) {
        Page<UbigeoDTO> pag = service.paginate(pagination.getPageNumber(), pagination.getRowsPerPage(),
                pagination.getFilters(), pagination.getSorts());
        return new ResponseEntity<>(pag, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UbigeoDTO> save(@Valid @RequestBody UbigeoDTO dto) throws Exception{
        Ubigeo obj = service.save(mapperUtil.map(dto, Ubigeo.class));
        return new ResponseEntity<>(mapperUtil.map(obj, UbigeoDTO.class, "defaultMapper"), HttpStatus.CREATED);
        //return ResponseEntity.created();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UbigeoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody UbigeoDTO dto) throws Exception{
        Ubigeo obj =  service.update(id, mapperUtil.map(dto, Ubigeo.class, "defaultMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, UbigeoDTO.class, "defaultMapper"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
