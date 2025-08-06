# 📦 Spring Boot + Jenkins CI/CD + SonarQube + JaCoCo

Este proyecto es una aplicación web desarrollada con Spring Boot que implementa un pipeline CI/CD utilizando **Jenkins**, con integración de análisis mediante **SonarQube** y reporte de cobertura de pruebas con **JaCoCo**.

---

## 🚀 Tecnologías utilizadas

- Java 21  
- Spring Boot 3.5.4  
- Gradle 8.14.3  
- Jenkins (con Docker)  
- SonarQube  
- JaCoCo  
- Checkstyle  
- GitHub (repositorio remoto)  

---

## 🛠️ Requisitos

- Docker y Docker Compose  
- Git  
- Jenkins instalado (puede ser con Docker)  
- SonarQube instalado (puede ser con Docker)  
- Java 21  
- Acceso a GitHub  

---

## ⚙️ Estructura del pipeline (Jenkinsfile)

```groovy
pipeline {
    agent any

    environment {
        SONARQUBE_TOKEN = credentials('sonarqube-token')
    }

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage("Compile") {
            steps {
                sh "./gradlew compileJava"
            }
        }

        stage("Unit test") {
            steps {
                sh "./gradlew test"
            }
        }

        stage("Code coverage") {
            steps {
                sh "./gradlew jacocoTestReport"
                publishHTML(target: [
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: 'JacocoReport'
                ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }

        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh "./gradlew sonarqube -Dsonar.login=$SONARQUBE_TOKEN"
                }
            }
        }
    }
}
