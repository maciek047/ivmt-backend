package com.interviewmate.repository

import com.interviewmate.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository interface for User entity operations.
 * Provides basic CRUD operations and custom query methods.
 */
@Repository
interface UserRepository : JpaRepository<User, Long> {
    
    /**
     * Find a user by their email address.
     * Used for authentication and user lookup.
     * 
     * @param email the email address to search for
     * @return the user if found, null otherwise
     */
    fun findByEmail(email: String): User?
}