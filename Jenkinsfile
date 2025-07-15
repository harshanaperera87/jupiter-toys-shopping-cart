pipeline {
    agent any

    tools {
        jdk 'JDK_18'       // Make sure this matches your Jenkins JDK config name
        maven 'Maven_3'    // Make sure this matches your Jenkins Maven config name
    }

    environment {
        MAVEN_HOME = tool 'Maven_3'
        PATH = "${env.MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Display Java and Maven versions') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
