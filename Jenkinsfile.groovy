// https://www.jenkins.io/doc/pipeline/tour/tests-and-artifacts/

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
    }
    post {
        always {
            junit '**/test-results/test/*.xml'
            jacoco(
                    execPattern: '**/build/jacoco/test.exec',
                    classPattern: '**/build/classes',
                    sourcePattern: '**/src/main/java',
                    exclusionPattern: '**/src/test*'
            )
        }
    }
}