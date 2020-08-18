pipeline {
    agent any
    tools {
        gradle 'Gradle 5.6.4'
        jdk 'jdk8'
    }

//    triggers {
//        cron('H */8 * * *') // regular builds
//        pollSCM('* * * * *') // polling for changes, here once a minute
//    }

    stages {
        stage('Build') {
            steps {
                bat 'gradlew build'
            }
        }
    }
}