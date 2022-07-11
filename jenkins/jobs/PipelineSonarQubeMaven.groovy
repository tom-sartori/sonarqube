/*
    * Jenkins pipeline for sonarqube with maven project.
    *
    * Don't forget to add credentials if necessary.
 */


Param : '(build_branch {master}, gitUrl {https://github.com/tom-sartori/jenkinsTest.git}, projectKey {testMaven})'

pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
        nodejs "NodeJS"
    }

    stages {
        stage ('git'){
            steps {
                // Get some code from a GitHub repository
                git branch: build_branch, url: gitUrl
            }
        }
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn clean install"
            }
        }
        stage('Analyse') {
            steps {
                sh "mvn sonar:sonar \
                -Dsonar.projectKey=" + projectKey + " \
                -Dsonar.host.url=http://sonarqube.localdomain:9000 \
                -Dsonar.login=admin \
                -Dsonar.password=admin"
            }
        }
    }
}
