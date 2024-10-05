pipeline {
    agent any

    tools {
        maven 'Maven 3.6.3' // Ensure you have Maven installed in Jenkins
        jdk 'JDK 21' // Ensure you have JDK 21 installed in Jenkins
    }

    environment {
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git branch: 'main', url: 'https://github.com/ptkarthik/TestNGProject.git' // Update with your repo URL
            }
        }

        stage('Build') {
            steps {
                // Build the project using Maven
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                // Run the tests using Maven Surefire Plugin
                sh 'mvn test'
            }
        }

        stage('Generate Reports') {
            steps {
                // Generate Extent Reports or any other reports as needed
                // This assumes that reports are generated automatically by the test run
                // You can add specific report generation commands here if necessary
                sh 'mvn site' // Optional: Generates a site report
            }
        }

        stage('Archive Results') {
            steps {
                // Archive the test results and reports
                junit '**/target/surefire-reports/*.xml' // Adjust the path based on your report location
                archiveArtifacts artifacts: '**/target/surefire-reports/*.html', allowEmptyArchive: true // Archive report files
                archiveArtifacts artifacts: '**/target/ExtentReports/*', allowEmptyArchive: true // Archive Extent Reports if generated
            }
        }

        stage('Cleanup') {
            steps {
                // Optional: Clean up workspace or resources if necessary
                cleanWs()
            }
        }
    }

    post {
        always {
            // Notify the build status (success/failure)
            script {
                def currentBuild = currentBuild.rawBuild
                def buildUrl = currentBuild.getAbsoluteUrl()
                def result = currentBuild.getResult()
                echo "Build URL: ${buildUrl}"
                echo "Build Result: ${result}"
            }
        }
        success {
            // Actions on successful build
            echo 'Build and tests were successful!'
        }
        failure {
            // Actions on failed build
            echo 'Build or tests failed!'
        }
    }
}
