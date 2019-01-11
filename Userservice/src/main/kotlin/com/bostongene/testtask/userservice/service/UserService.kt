package com.bostongene.testtask.userservice.service

import com.bostongene.testtask.userservice.model.User
import com.bostongene.testtask.userservice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@EnableAutoConfiguration
class UserService {
    @Autowired
    private lateinit  var userRepository : UserRepository

    @PostMapping("/api/add")
    fun addUser(@RequestBody user : User) : ResponseEntity<String> =
            if (userRepository.existsById(user.email)) {
                ResponseEntity.badRequest().body("User ${user.email} already exists")
            } else {
                userRepository.save(user)
                ResponseEntity.ok("User ${user.email} successfully added")
            }

    @PostMapping("/api/delete")
    fun deleteUser(@RequestBody email:String) : ResponseEntity<String> =
            if (userRepository.existsById(email)) {
                userRepository.deleteById(email)
                ResponseEntity.ok("User $email successfully deleted")
            } else {
                ResponseEntity.badRequest().body("User $email not found")
            }

    @PostMapping("/api/find")
    fun findUser(@RequestBody email:String) : ResponseEntity<User> {
        val user = userRepository.findById(email)
        return if(user.isPresent) {
            ResponseEntity.ok(user.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

}