package net.elau.example.springdataenversoracledb.mapper

import net.elau.example.springdataenversoracledb.dto.ProductDto
import net.elau.example.springdataenversoracledb.dto.RegisterProductDto
import net.elau.example.springdataenversoracledb.model.Product
import net.elau.example.springdataenversoracledb.web.request.RegisterProductRequest
import net.elau.example.springdataenversoracledb.web.response.ProductResponse
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.data.domain.Page

@Mapper(componentModel = "spring")
interface ProductMapper {

    fun toModel(registerProductDto: RegisterProductDto): Product

    fun toDto(registerProductRequest: RegisterProductRequest): RegisterProductDto

    fun toDto(product: Product): ProductDto

    fun toDto(productList: Page<Product>): List<ProductDto>

    fun toResponse(productDtoList: List<ProductDto>): List<ProductResponse>
}
