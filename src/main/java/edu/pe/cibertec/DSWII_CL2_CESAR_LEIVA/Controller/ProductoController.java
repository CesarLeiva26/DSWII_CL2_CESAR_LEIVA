package edu.pe.cibertec.DSWII_CL2_CESAR_LEIVA.Controller;

import edu.pe.cibertec.DSWII_CL2_CESAR_LEIVA.Model.Producto;
import edu.pe.cibertec.DSWII_CL2_CESAR_LEIVA.Service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<Producto>> listaProductos() {
        List<Producto> productoList = productoService.listaProductos();
        if (productoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.registrarProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }


}
