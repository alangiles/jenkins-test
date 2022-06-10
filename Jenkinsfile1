pipeline {
    agent { dockerfile true }
    stages {
        stage('Test') {
            steps {
                sh 'java --version'
                sh 'gradle --version'
                sh 'gradle test'
            }
        }
        stage('Build') {
            steps {
                sh 'gradle clean build'
            }
        }
    }
}