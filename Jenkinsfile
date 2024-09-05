pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ganwz/Assignment2.git'
            }
        }
        stage('Stop Gradle Daemons') {
            steps {
                // Stop any existing Gradle daemons before building
                powershell './gradlew --stop'
            }
        }
        stage('Build') {
            steps {
                // Clean and build the project
                powershell './gradlew clean bootJar'
            }
        }
        stage('Test') {
            steps {
                // Run tests with more detailed output
                powershell './gradlew test '
            }
        }
        stage('Deploy') {
            steps {
                // Run the built JAR file
                powershell 'java -jar build/libs/Assignment2-0.0.1-SNAPSHOT.jar'
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace'
            deleteDir() // Clean up the workspace after the build
        }
        success {
            echo 'Build and tests succeeded!!'
            // Add notifications, such as email, if needed
        }
        failure {
            echo 'Build or tests failed!!'
            // Add notification steps here for failure (e.g., send an email or Slack message)
        }
    }
}
