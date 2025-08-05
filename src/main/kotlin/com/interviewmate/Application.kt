package com.interviewmate

import com.interviewmate.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

/**
 * Main Spring Boot application class for InterviewMate backend service.
 * 
 * InterviewMate is a web application that helps users prepare for job interviews
 * by generating customized interview questions based on job descriptions.
 * 
 * The application provides:
 * - Job-specific interview question generation using AI
 * - User authentication and subscription management
 * - CV generation capabilities (premium feature)
 * - Free tier with limited question access
 */
@SpringBootApplication
class InterviewMateApplication {
    @Bean
    fun initDatabase(userRepository: UserRepository) = CommandLineRunner {
        val userCount = userRepository.count()
        println("Database ready: user table rows = $userCount")
    }
}

fun main(args: Array<String>) {
    runApplication<InterviewMateApplication>(*args)
}