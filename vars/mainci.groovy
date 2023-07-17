def call() {
    node ('practice') {

         if (env.cibuild== "java") {
             stage('build') {

                     sh 'mvn package'

             }
         }

            stage('unit tests') {

                    echo 'unit tests'

                    // sh 'npm test'

            }

            stage('code analysis') {

                    echo 'sonar'
                    //sh 'sonar-scanner -Dsonar.host.url=http://172.31.80.223:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=frontend -Dsonar.qualitygate.wait=true'

            }

            stage('Security Scans') {

                    echo 'Security Scans'

            }

           if (env.TAG_NAME ==~ ".*"){
               stage('Publish a Artifact') {

                   echo 'Publish a Artifact'

               }
           }

        }
    }
