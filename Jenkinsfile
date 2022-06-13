pipeline {
    agent {
        dockerfile {
            additionalBuildArgs  '--tag amazoncorretto-gradle:11'
            args '--privileged -v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    stages {
        stage('Test') {
            steps {
                sh 'gradle clean test'
            }
            post {
                always {
                    junit 'build/test-results/**/*.xml'
                }
            }
        }
    }
}