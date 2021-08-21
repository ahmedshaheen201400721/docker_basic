def gv
pipeline{
    agent any
    stages  {
        stage("init"){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }

        stage('Build image') {
            steps {
               script{
                   gv.build()
               }
            }
        }

        stage('push image' ) {
            steps {
              script{
                  gv.push()
              }
            }
        }
    }
}