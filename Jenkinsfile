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

       stage("version"){
            steps{
                script{
                        sh " npm version minor --prefix app/  "
                       env.ImageName=  sh (script:'''node -pe "require('./app/package.json')['version']" ''', , returnStdout:true).trim()
                        sh (script: 'npm --version ', , returnStdout:true).trim()
                        echo "$ImageName"
                }
            }
        }


        stage('Build image') {
            steps {
               script{
                   echo "building image"
                   gv.build "$ImageName"
               }
            }
        }

        stage('push image' ) {
            steps {
              script{
                  gv.push "$ImageName"
              }
            }
        }
    }
}