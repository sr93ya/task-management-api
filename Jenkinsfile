
pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home'
        PATH = "${JAVA_HOME}/bin:/opt/homebrew/bin:/usr/bin:/bin:/usr/sbin:/sbin"
    }

    triggers {
        pollSCM('H/2 * * * *')
    }

    stages {
        stage('Build and Test') {
            steps {
                sh 'mvn -B clean package'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }

        success {
            archiveArtifacts artifacts: 'target/*.jar',
                             fingerprint: true
        }
    }
}
