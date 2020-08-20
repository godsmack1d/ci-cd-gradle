pipeline {
    agent any
    tools {
        jdk 'jdk8'
    }

    stages {
        stage('Build') {
            steps {
                bat 'gradlew clean build'
            }
        }

        /*stage('Test') {
            steps {
                bat 'gradlew check'
            }
        }*/
    }
    post {
        always {
            junit '**/test-results/test/*.xml'
        }
    }
}