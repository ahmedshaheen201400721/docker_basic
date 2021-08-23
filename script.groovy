def build(String ImageName){
     sh "docker build -t  '127.0.0.1:8083/testimage':$ImageName  ."
}

def push(String ImageName){
     withCredentials([ usernamePassword(credentialsId:"nexus",usernameVariable: "USER", passwordVariable: "pass")]){
            sh " echo ${pass} |docker login -u ${USER} --password-stdin http://127.0.0.1:8083"
        }
     sh 'docker push "127.0.0.1:8083/testimage":$ImageName'
}

return this

