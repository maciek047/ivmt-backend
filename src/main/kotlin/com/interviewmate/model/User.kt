package com.interviewmate.model

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import java.time.Instant

/**
 * User entity representing users of the InterviewMate application.
 * Supports both registered users with subscriptions and anonymous users.
 */
@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @Column(unique = true, nullable = false)
    @field:Email
    val email: String = "",
    
    @Column(nullable = false)
    val passwordHash: String = "",
    
    @Column(nullable = false)
    val role: String = "USER",
    
    @Column(nullable = false)
    val subscriptionStatus: String = "NONE",
    
    @Column(nullable = false)
    val createdAt: Instant = Instant.now()
)