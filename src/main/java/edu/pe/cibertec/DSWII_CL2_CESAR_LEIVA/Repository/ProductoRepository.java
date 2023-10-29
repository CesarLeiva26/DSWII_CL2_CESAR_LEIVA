package edu.pe.cibertec.DSWII_CL2_CESAR_LEIVA.Repository;

import edu.pe.cibertec.DSWII_CL2_CESAR_LEIVA.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "SELECT * FROM producto WHERE nombre LIKE :filtro%",
    nativeQuery = true)
    List<Producto>filtrarProductoNombre(@Param("filtro")String filtro);
    @Query(value = "SELECT * FROM producto WHERE cantidad > 10 AND cantidad < 100", nativeQuery = true)
    List<Producto> findProductosEntre10Y100();
    @Query(value = "SELECT * FROM producto WHERE YEAR(fechavencimiento) = 2024", nativeQuery = true)
    List<Producto> findProductosVencen2024();
}
