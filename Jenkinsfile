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
                powershell './gradlew clean --info'
            }
        }
        stage('Test') {
            steps {
                // Run tests with more detailed output
                powershell './gradlew test --info'
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
        }
        failure {
            echo 'Build or tests failed!!'
        }
    }
}
