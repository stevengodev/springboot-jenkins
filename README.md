Usa el siguiente comando para levantar un contenedor de Jenkins

docker pull jenkins/jenkins:lts

docker volume create jenkins_data

docker run -p 8080:8080 -p 50000:50000 -v jenkins_data:/var/jenkins_home jenkins/jenkins:lts
