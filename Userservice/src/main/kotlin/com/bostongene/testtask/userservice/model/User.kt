package com.bostongene.testtask.userservice.model

import org.hibernate.annotations.Generated
import org.hibernate.annotations.GenerationTime
import org.hibernate.annotations.NaturalId
import java.util.*
import javax.persistence.*

@Entity
@Table(name="USER")
data class User (

    @Column(name = "name")
    val name: String,

    @Column(name = "surname")
    val surname: String,

    @Column(name = "birthdate")
    val birthDate: Date,

    @Id
    @Column(name = "email", unique = true)
    val email: String,

    @Column(name = "password")
    val password: String


)