package com.bostongene.testtask.userservice.repository

import com.bostongene.testtask.userservice.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String> {
}