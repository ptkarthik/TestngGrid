pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'
        jdk 'JAVA'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from the repository
                git branch: 'feature/testngprojects', url: 'https://github.com/ptkarthik/TestNGProject.git'
            }
        }

        stage('Build and Test') {
            steps {
                // Build the project and run tests
                bat 'mvn clean install'
                bat 'mvn test'
            }
        }

        stage('Archive Results') {
            steps {
                // Archive test results
                junit '**/target/surefire-reports/*.xml'
                archiveArtifacts artifacts: '**/target/surefire-reports/*.html', allowEmptyArchive: true
                archiveArtifacts artifacts: '**/target/ExtentReports/*', allowEmptyArchive: true
            }
        }
    }
}
