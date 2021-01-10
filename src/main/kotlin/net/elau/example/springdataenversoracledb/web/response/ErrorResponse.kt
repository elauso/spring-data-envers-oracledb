package net.elau.example.springdataenversoracledb.web.response

data class ErrorResponse(

    val message: String,

    val details: MutableList<String?>
)
