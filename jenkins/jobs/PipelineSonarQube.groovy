/*
    * Jenkins pipeline for sonarqube which use SonarScanner. Don't use it for maven project.
    *
    * Java files have to be compiled before.
    * Don't forget to add credentials if necessary.
*/

Param : '(build_branch {master}, gitUrl {https://github.com/tom-sartori/projetC-client.git}, projectKey {projectTest})'

pipeline {
    agent any
    tools {
        nodejs "NodeJS"
    }
    stages {
        stage('git') {
            steps {
                git branch: build_branch, url: gitUrl
            }
        }
        stage('analyse') {
            steps {
                script {
                    def scannerHome = tool 'SonarScanner';
                    withSonarQubeEnv("SonarQube") {
                        sh "${tool("SonarScanner")}/bin/sonar-scanner \
                    -Dsonar.projectKey=" + projectKey + " \
                    -Dsonar.host.url=http://sonarqube.localdomain:9000 \
                    -Dsonar.login=admin \
                    -Dsonar.password=admin"
                    }
                }
            }
        }
    }
}
