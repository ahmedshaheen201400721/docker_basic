@Library("shared-library")   // to include libaray , usr libray_name
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
                   buildImage()
               }
            }
        }

        stage('push image' ) {
            when {
                expression {
                    env.BRANCH_NAME == "main" || BRANCH_NAME == "dev"
                }
            }
            steps {
              script{
                 pushImage()
              }
            }
        }
    }
}