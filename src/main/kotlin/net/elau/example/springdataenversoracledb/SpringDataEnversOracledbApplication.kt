package net.elau.example.springdataenversoracledb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean::class)
class SpringDataEnversOracledbApplication

fun main(args: Array<String>) {
    runApplication<SpringDataEnversOracledbApplication>(*args)
}
