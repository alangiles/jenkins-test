pipeline {
    agent {
        dockerfile {
            additionalBuildArgs  '--tag amazoncorretto-gradle:11'
            args '--privileged -v /var/run/docker.sock:/var/run/docker.sock -v /usr/bin/docker:/usr/bin/docker'
        }
    }
    stages {
        stage('Test') {
            steps {
                sh 'java --version'
                sh 'gradle --version'
                sh 'gradle clean test'
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