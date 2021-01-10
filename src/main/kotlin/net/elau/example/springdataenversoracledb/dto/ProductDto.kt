package net.elau.example.springdataenversoracledb.dto

import net.elau.example.springdataenversoracledb.model.CategoryType

data class ProductDto(

    val id: Long,

    val name: String,

    val description: String,

    val category: CategoryType
)
