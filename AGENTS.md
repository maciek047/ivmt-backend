# InterviewMate Backend - Agent Guide

## Project Overview

**InterviewMate** is a Spring Boot backend service built with Kotlin that powers a web application for interview preparation. The application generates customized interview questions based on job descriptions using AI services (OpenAI GPT initially, extensible to other LLMs).

### Core Features
- **Job-specific interview question generation** using AI/LLM APIs
- **Freemium model**: 3 free questions for anonymous users, full access requires subscription
- **User authentication and subscription management**
- **CV generation** (premium feature)
- **Multi-LLM support** (starting with OpenAI, designed for easy extension)

### User Flow
1. **Job Name Entry**: User enters the job title they're applying for
2. **Job Details**: User provides specific job listing details
3. **Question Generation**: AI generates interview questions based on combined job info
4. **Access Control**: Free users see 3 questions, subscribers get full access + additional features

## Project Structure

```
src/main/kotlin/com/interviewmate/
├── Application.kt                    # Main Spring Boot application
├── config/                          # Configuration classes
│   ├── SecurityConfig.kt            # Spring Security configuration
│   ├── WebConfig.kt                 # Web MVC configuration
│   └── OpenAiConfig.kt             # AI service configuration
├── controller/                      # REST API endpoints
│   ├── InterviewController.kt       # Interview question generation
│   ├── AuthController.kt           # Authentication endpoints
│   └── UserController.kt           # User management
├── service/                        # Business logic layer
│   ├── InterviewService.kt         # Core interview logic
│   ├── LlmService.kt              # AI/LLM integration
│   ├── UserService.kt             # User management
│   └── SubscriptionService.kt     # Subscription handling
├── model/                          # Data entities
│   ├── User.kt                    # User entity
│   ├── Interview.kt               # Interview session entity
│   ├── Question.kt                # Generated questions
│   └── Subscription.kt            # User subscription data
├── repository/                     # Data access layer
│   ├── UserRepository.kt          # User data access
│   ├── InterviewRepository.kt     # Interview data access
│   └── SubscriptionRepository.kt  # Subscription data access
├── dto/                           # Data transfer objects
│   ├── request/                   # API request DTOs
│   └── response/                  # API response DTOs
├── security/                      # Security components
│   ├── JwtTokenProvider.kt        # JWT token handling
│   └── UserDetailsService.kt     # Spring Security user details
└── exception/                     # Custom exceptions and handlers
    ├── GlobalExceptionHandler.kt  # Global error handling
    └── CustomExceptions.kt       # Application-specific exceptions
```

## Technology Stack

- **Language**: Kotlin 1.9.23
- **Framework**: Spring Boot 3.3.0
- **Database**: PostgreSQL with Spring Data JPA
- **Security**: Spring Security with JWT
- **HTTP Client**: WebFlux WebClient (for AI API calls)
- **Build Tool**: Gradle with Kotlin DSL
- **Deployment**: Heroku-ready with Procfile

## Code Conventions

### Kotlin Style
- Use Kotlin idioms and conventions
- Prefer data classes for DTOs
- Use nullable types appropriately (`?`)
- Leverage Kotlin's null safety features
- Use extension functions where beneficial

### Spring Boot Patterns
- Use `@Service`, `@Repository`, `@Controller` annotations
- Implement proper dependency injection with constructor injection
- Use `@ConfigurationProperties` for configuration binding
- Follow REST API conventions for endpoints

### Database
- JPA entities with Kotlin-friendly annotations
- Use `@Entity` with `@Table` for clear table mapping
- Repository interfaces extending `JpaRepository`
- Database migrations handled via `ddl-auto: update` (consider Flyway for production)

## Configuration

### Environment Variables
- `PORT`: Server port (default: 8080)
- `DATABASE_URL`: PostgreSQL connection string
- `DB_USERNAME`: Database username
- `DB_PASSWORD`: Database password
- `OPENAI_API_KEY`: OpenAI API key for question generation
- `JWT_SECRET`: Secret key for JWT token signing

### Application Properties
See `application.yml` for full configuration including:
- Database connection settings
- JWT configuration
- OpenAI API settings
- Free tier limits
- Logging configuration

## Build and Development

### Building the Project
```bash
./gradlew build
```

### Running Locally
```bash
./gradlew bootRun
```

### Running Tests
```bash
./gradlew test
```

### Building for Production
```bash
./gradlew bootJar
```
This creates `build/libs/interviewmate.jar` ready for deployment.

## API Design Patterns

### Request/Response Structure
- Use DTOs for all API interactions
- Implement proper validation with Bean Validation annotations
- Return consistent response formats
- Use appropriate HTTP status codes

### Error Handling
- Global exception handler for consistent error responses
- Custom exceptions for business logic errors
- Proper logging for debugging and monitoring

### Security
- JWT-based authentication
- Role-based access control
- API rate limiting (TODO)
- Input validation and sanitization

## Future Development TODOs

### Immediate Features (Next Tasks)
- [ ] Implement user authentication and JWT handling
- [ ] Create interview question generation service
- [ ] Add OpenAI API integration
- [ ] Implement subscription management
- [ ] Add user registration and login endpoints

### Advanced Features
- [ ] CV generation functionality
- [ ] Multiple LLM provider support (Claude, Gemini, Nova)
- [ ] Caching layer for generated questions
- [ ] Analytics and usage tracking
- [ ] Email notifications
- [ ] Payment integration (Stripe/PayPal)

### Infrastructure
- [ ] Database migrations with Flyway
- [ ] Monitoring and health checks
- [ ] API documentation with OpenAPI/Swagger
- [ ] CI/CD pipeline
- [ ] Docker containerization
- [ ] Production logging and monitoring

## LLM Integration Architecture

The system is designed to support multiple LLM providers:

1. **LlmService Interface**: Abstract interface for LLM operations
2. **Provider Implementations**: Specific implementations for each LLM (OpenAI, Claude, etc.)
3. **Configuration-based Selection**: Choose provider via configuration
4. **Failover Support**: Ability to fall back to alternative providers

This architecture ensures easy addition of new LLM providers without changing core business logic.

## Security Considerations

- Never commit API keys or secrets
- Use environment variables for all sensitive configuration
- Implement proper input validation
- Use HTTPS in production
- Regular security dependency updates
- Implement rate limiting for API endpoints

## Contributing

When working on this project:
1. Follow the established package structure
2. Add comprehensive tests for new features
3. Update this guide when adding new major components
4. Use meaningful commit messages
5. Ensure all builds pass before submitting changes

---

This project follows Spring Boot and Kotlin best practices. For questions about specific implementations, refer to the official Spring Boot and Kotlin documentation.