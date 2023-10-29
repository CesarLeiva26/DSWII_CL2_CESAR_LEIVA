package edu.pe.cibertec.DSWII_CL2_CESAR_LEIVA.Repository;

import edu.pe.cibertec.DSWII_CL2_CESAR_LEIVA.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {


}
