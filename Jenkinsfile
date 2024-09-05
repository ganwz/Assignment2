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
                script {
                    if (isUnix()) {
                        sh './gradlew --stop'
                    } else {
                        powershell './gradlew --stop'
                    }
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh './gradlew clean bootJar'
                    } else {
                        powershell './gradlew clean bootJar'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh './gradlew test'
                    } else {
                        powershell './gradlew test'
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'java -jar build/libs/Assignment2-0.0.1-SNAPSHOT.jar'
                    } else {
                        powershell 'java -jar build/libs/Assignment2-0.0.1-SNAPSHOT.jar'
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace'
            cleanWs() // Clean up the workspace after the build
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
