pipeline {
    agent {
//         dockerfile true
        docker {
            image 'amazoncorretto-gradle:11'
            args '--privileged -v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    stages {
        stage('Test') {
            steps {
                sh 'java --version'
                sh 'gradle --version'
                sh 'gradle clean test --no-daemon'
            }
            post {
                always {
                    junit 'build/reports/**/*.xml'
                }
            }
        }
        stage('Build') {
            steps {
                sh 'gradle clean build'
            }
        }
    }
}