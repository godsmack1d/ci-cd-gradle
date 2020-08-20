pipeline {
    agent any
    tools {
        jdk 'jdk8'
    }

    stages {
        stage('Build') {
            steps {
                bat 'gradlew build'
            }
        }
        post {
            always {
                junit '**/test-results/test/*.xml'
            }
        }
//        stage('Publish test results') {
//            junit '**/test-results/test/*.xml'
//        }
    }
}