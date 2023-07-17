def call() {
    pipeline {
        agent {
            node { label 'practice' }

        }


        stages {
            stage('build') {
                steps {
                    echo 'npm install'
                }
            }

            stage('unit tests') {
                steps {
                    echo 'unit tests'
                    // sh 'npm test'
                }
            }

            stage('code analysis') {
                steps {
                    echo 'sonar'
                    //sh 'sonar-scanner -Dsonar.host.url=http://172.31.80.223:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=cart'
                }
            }

            stage('Security Scans') {
                steps {
                    echo 'Security Scans'
                }
            }

            stage('Publish a Artifact') {
                when {
                    expression {
                        env.TAG_NAME==~ ".*"
                    }
                }
                steps {
                    echo 'Publish a Artifact'
                    sh 'env'
                }
            }
        }
    }

}