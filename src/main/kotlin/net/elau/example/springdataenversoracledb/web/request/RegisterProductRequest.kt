package net.elau.example.springdataenversoracledb.web.request

import net.elau.example.springdataenversoracledb.model.CategoryType
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class RegisterProductRequest(

    @field:NotBlank
    val name: String? = null,

    @field:NotBlank
    val description: String? = null,

    @field:NotNull
    val category: CategoryType? = null
)
