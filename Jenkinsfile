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
                git branch: 'master', url: 'https://github.com/ptkarthik/TestNGProject.git'
            }
        }

        stage('Build and Test') {
            steps {
                // Build the project and run tests
                sh 'mvn clean install'
                sh 'mvn test'
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
