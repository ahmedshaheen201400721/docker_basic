def build(){
     sh ' docker build -t  "127.0.0.1:8083/testimage":v2.2  .'
}

def push(){
     withCredentials([ usernamePassword(credentialsId:"nexus",usernameVariable: "USER", passwordVariable: "pass")]){
            sh " echo ${pass} |docker login -u ${USER} --password-stdin http://127.0.0.1:8083"
        }
     sh 'docker push "127.0.0.1:8083/testimage":v2.2'
}

return this

