def build(String ImageName){
     sh "docker build -t  '5cm4ii4w/basic_app':$ImageName  ."
}

def push(String ImageName){
     echo "pushing image"
     withCredentials([ usernamePassword(credentialsId:"nexus",usernameVariable: "USER", passwordVariable: "pass")]){
            sh ' echo $pass |docker login -u $USER --password-stdin'
        }
     sh "docker push '5cm4ii4w/basic_app':$ImageName"
}

return this

