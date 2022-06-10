pipeline {
    agent {
        dockerfile true
        docker {
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
                    junit 'build/test-results/**/*.xml'
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