package edu.pe.cibertec.DSWII_CL2_CESAR_LEIVA.Controller;

import edu.pe.cibertec.DSWII_CL2_CESAR_LEIVA.Exception.ResourceNotFoundException;
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

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable("id") Integer id) {
        Producto producto = productoService.obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el ID " + id + " no existe"));
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.registrarProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable("id") Integer id, @RequestBody Producto producto) {
        Producto oldProducto = productoService.obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el ID " +
                        id + " no existe"));
        oldProducto.setNombre(producto.getNombre());
        oldProducto.setDescripcion(producto.getDescripcion());
        oldProducto.setCantidad(producto.getCantidad());
        oldProducto.setFechavencimiento(producto.getFechavencimiento());
        productoService.registrarProducto(oldProducto);
        return new ResponseEntity<>(oldProducto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id") Integer id) {
        Producto producto = productoService.obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el ID " + id + " no existe"));
        productoService.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/nombre/{filtro}")
    public ResponseEntity<List<Producto>> filtrarProductosPorNombre(@PathVariable("filtro") String filtro) {
        List<Producto> productoList = productoService.obtenerProductosPorNombre(filtro);
        if (productoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @GetMapping("/productosentre10y100")
    public ResponseEntity<List<Producto>> consultarProductosEntre10Y100() {
        List<Producto> productos = productoService.consultarProductosEntre10Y100();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/vencimiento2024")
    public ResponseEntity<List<Producto>> consultarProductosConVencimiento2024() {
        List<Producto> productos = productoService.consultarProductosConVencimiento2024();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

}
