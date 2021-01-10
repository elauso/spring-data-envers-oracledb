package net.elau.example.springdataenversoracledb.repository

import net.elau.example.springdataenversoracledb.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
}
