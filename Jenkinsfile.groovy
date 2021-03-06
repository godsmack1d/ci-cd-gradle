// https://www.jenkins.io/doc/pipeline/tour/tests-and-artifacts/
// https://www.jenkins.io/doc/pipeline/steps/junit/
// https://www.jenkins.io/doc/pipeline/steps/jacoco/
// https://www.jenkins.io/doc/pipeline/steps/sonar/
// https://docs.sonarqube.org/latest/analysis/scan/sonarscanner-for-jenkins/

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

        stage('SonarQube analysis') {
            steps {
                // Server with this name must be added in configure system in Jenkins
                withSonarQubeEnv('Local sonar server') {
                    bat 'gradlew sonarqube'
                }
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