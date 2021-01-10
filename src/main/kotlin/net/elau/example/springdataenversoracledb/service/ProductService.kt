package net.elau.example.springdataenversoracledb.service

import net.elau.example.springdataenversoracledb.dto.ProductDto
import net.elau.example.springdataenversoracledb.dto.RegisterProductDto
import net.elau.example.springdataenversoracledb.mapper.ProductMapper
import net.elau.example.springdataenversoracledb.repository.ProductRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation.NOT_SUPPORTED
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productMapper: ProductMapper,
    private val productRepository: ProductRepository
) {

    @Transactional(propagation = NOT_SUPPORTED)
    fun list(start: Int, end: Int) =
        productMapper.toDto(productRepository.findAll(PageRequest.of(start, end)))

    @Transactional
    fun register(registerProductDto: RegisterProductDto): ProductDto {
        val product = productMapper.toModel(registerProductDto)
        return productMapper.toDto(productRepository.save(product))
    }
}
