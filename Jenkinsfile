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
                try {
                    sh 'gradle clean test --no-daemon'
                } finally {
                    junit '**/build/test-results/test/*.xml'
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