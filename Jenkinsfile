pipeline {
    agent {
//         dockerfile true
        docker {
            image 'amazoncorretto-gradle:11'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
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