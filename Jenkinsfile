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
            when {
                expression {
                    env.BRANCH_NAME == main
                }
            }
            steps {
              script{
                  gv.push()
              }
            }
        }
    }
}