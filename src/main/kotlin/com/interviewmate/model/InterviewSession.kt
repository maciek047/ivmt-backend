package com.interviewmate.model

import jakarta.persistence.*
import java.time.Instant

/**
 * InterviewSession entity representing a user's interview question generation session.
 * Can be associated with a registered user or be anonymous (user = null).
 */
@Entity
@Table(name = "interview_sessions")
data class InterviewSession(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User? = null,
    
    @Column(nullable = false)
    val jobName: String = "",
    
    @Column(length = 4000, nullable = false)
    val jobDescription: String = "",
    
    @Column(nullable = false)
    val generatedAt: Instant = Instant.now(),
    
    @Lob
    @Column(nullable = false)
    val questionsJson: String = ""
)