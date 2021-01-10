package net.elau.example.springdataenversoracledb.web.controller

import net.elau.example.springdataenversoracledb.mapper.ProductMapper
import net.elau.example.springdataenversoracledb.service.ProductService
import net.elau.example.springdataenversoracledb.web.request.RegisterProductRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productMapper: ProductMapper,
    private val productService: ProductService
) {

    @GetMapping
    fun list(@RequestParam(required = true) start: Int, @RequestParam(required = true) end: Int) =
        productMapper.toResponse(productService.list(start, end))

    @PostMapping
    fun register(
        @Valid @RequestBody registerProductRequest: RegisterProductRequest,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<Void> {
        val productDto = productService.register(productMapper.toDto(registerProductRequest))
        val uriComponents = uriComponentsBuilder.path("/api/products/{id}").buildAndExpand(productDto.id)
        return ResponseEntity.created(uriComponents.toUri()).build()
    }
}
