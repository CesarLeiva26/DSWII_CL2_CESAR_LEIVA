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



}
