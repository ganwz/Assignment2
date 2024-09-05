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
                powershell './gradlew --stop'
            }
        }   
        stage('Build') {
            steps {

                        powershell './gradlew clean build'
                
            }
        }
        stage('Test') {
            steps {
                
                        powershell './gradlew test'
                  
            }
        }
        stage('Deploy') {
            steps {                
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
            echo 'Build succeeded!!'
            // You could add notification steps here, e.g., send an email
        }
        failure {
            echo 'Build failed!!'
            // You could add notification steps here, e.g., send an email or Slack message
        }
    }
    }


