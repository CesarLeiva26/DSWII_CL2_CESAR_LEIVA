package edu.pe.cibertec.DSWII_CL2_CESAR_LEIVA.Service;

import edu.pe.cibertec.DSWII_CL2_CESAR_LEIVA.Model.Producto;
import edu.pe.cibertec.DSWII_CL2_CESAR_LEIVA.Repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public List<Producto> listaProductos() {
        return productoRepository.findAll();
    }

    public Producto registrarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public List<Producto> obtenerProductosPorNombre(String filtro) {
        return productoRepository.filtrarProductoNombre(filtro);
    }
    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> consultarProductosEntre10Y100() {
        return productoRepository.findProductosEntre10Y100();
    }
    public List<Producto> consultarProductosConVencimiento2024() {
        return productoRepository.findProductosVencen2024();
    }
}
