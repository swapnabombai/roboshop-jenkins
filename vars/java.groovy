def call() {
    pipeline {
        agent {
            node { label 'practice' }

        }

        stages {

            stage('build') {
                steps {
                    sh 'mvn package'
                }
            }

            stage('Unit tests') {
                steps {
                    echo 'unit tests'
                    // sh 'mvn test'
                }
            }

            stage('Code Analysis') {
                steps {
                    echo 'sonar'
                    //sh 'sonar-scanner -Dsonar.host.url=http://172.31.80.223:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=shipping -Dsonar.java.binaries=target'

                }
            }

            stage('Security Scans') {
                steps {
                    echo 'Security Scans'
                }
            }

            stage('Publish a Artifact') {
                steps {
                    echo 'Publish a Artifact'
                }
            }
        }
    }
}