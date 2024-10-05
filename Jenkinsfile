node {
    // Checkout the code from SCM
    stage('Checkout') {
        checkout scm  // Checkout code from your Git repository
    }

   // Build the project using Maven
    stage('Build') {
        bat 'build.bat'  // Run your batch file to build the project
    }

    // Run TestNG tests
    stage('Test') {
        bat 'mvn test -DsuiteXmlFile=testng.xml'  // Run the tests specified in testng.xml
    }

    // Notify success
    stage('Notify') {
        echo 'Build and Tests completed successfully!'  // Notification stage
    }
}
