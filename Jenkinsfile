pipeline {
    agent {
//         dockerfile true
        docker {
            image 'amazoncorretto-gradle:11'
            args '--privileged -v /var/run/docker.sock:/var/run/docker.sock -v /usr/local/bin/docker:/usr/bin/docker'
        }
    }
    stages {
        stage('Test') {
            steps {
                sh 'docker --version'
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