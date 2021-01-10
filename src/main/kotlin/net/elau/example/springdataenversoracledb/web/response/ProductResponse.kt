package net.elau.example.springdataenversoracledb.web.response

import net.elau.example.springdataenversoracledb.model.CategoryType

data class ProductResponse(

    val id: Long,

    val name: String,

    val description: String,

    val category: CategoryType
)
