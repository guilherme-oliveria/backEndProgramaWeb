package br.edu.unievangelica.domain.provincia;

import br.edu.unievangelica.core.controller.ResponseAbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provincia")
public class ProvinciaController extends ResponseAbstractController{

    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping("/{paisId}")
    public ResponseEntity<?> listarProvincias(@PathVariable("paisId") long paisId){
        return jsonResponse(provinciaService.listarPorPais(paisId));
    }
}
