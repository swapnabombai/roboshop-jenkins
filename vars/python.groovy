def call() {
    pipeline {
        agent {
            node {label 'practice'}

        }

        stages {
            stage('code checkout') {
                steps {
                    echo 'code checkout'
                }
            }


            stage('unit tests') {
                steps {
                    echo 'unit tests'
                }
            }

            stage('code analysis') {
                steps {
                    echo 'sonar'
                    //sh 'sonar-scanner -Dsonar.host.url=http://172.31.80.223:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=payment'
                }
            }

            stage('Security Scans') {
                steps {
                    echo 'Security Scans'
                }
            }

            stage('publish a artifact') {
                steps {
                    echo 'publish a artifact'
                }
            }
        }
    }
}