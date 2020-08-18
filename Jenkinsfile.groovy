pipeline {
    agent any
    tools {
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