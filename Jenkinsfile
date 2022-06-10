pipeline {
    agent {
//         dockerfile true
        docker {
            image 'amazoncorretto-gradle:11'
            args '--privileged -v /var/run/docker.sock:/var/run/docker.sock -v /usr/local/bin/docker:/var/lib/docker'
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