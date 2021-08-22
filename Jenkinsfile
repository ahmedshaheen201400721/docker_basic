// @Library("shared-library")   // to include libaray , usr libray_name
library identifier: 'jenkins_shared_library@simple', retriever: modernSCM(
  [$class: 'GitSCMSource',
   remote: 'https://github.com/ahmedshaheen201400721/jenkins_shared_library.git',
   credentialsId: 'github-credentials'])
def gv
pipeline{
    agent any
    stages  {
       
        stage('Build image') {
            steps {
               script{
                   buildImage "v3.0"
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
                 pushImage "v3.0"
              }
            }
        }
    }
}