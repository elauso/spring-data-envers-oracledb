package net.elau.example.springdataenversoracledb.model

import org.hibernate.envers.Audited
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.EnumType.STRING
import javax.persistence.GenerationType.SEQUENCE

@Entity
@Table(name = "products")
@Audited
data class Product(

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "PROD_SEQ")
    @SequenceGenerator(sequenceName = "product_seq", allocationSize = 1, name = "PROD_SEQ")
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @Column(name = "description", nullable = false)
    var description: String? = null,

    @Enumerated(STRING)
    @Column(name = "category", nullable = false)
    var category: CategoryType? = null,

    @CreatedDate
    @Column(name = "created_date")
    var createdDate: LocalDateTime? = null
)
