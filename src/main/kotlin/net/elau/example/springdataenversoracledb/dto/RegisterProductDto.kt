package net.elau.example.springdataenversoracledb.dto

import net.elau.example.springdataenversoracledb.model.CategoryType

data class RegisterProductDto(

    val name: String,

    val description: String,

    val category: CategoryType
)
