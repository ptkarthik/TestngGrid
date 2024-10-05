pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'
        jdk 'JAVA'
    }

    environment {
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/ptkarthik/TestNGProject.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Generate Reports') {
            steps {
                sh 'mvn site'
            }
        }

        stage('Archive Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                archiveArtifacts artifacts: '**/target/surefire-reports/*.html', allowEmptyArchive: true
                archiveArtifacts artifacts: '**/target/ExtentReports/*', allowEmptyArchive: true
            }
        }

        stage('Cleanup') {
            steps {
                cleanWs()
            }
        }
    }
}
