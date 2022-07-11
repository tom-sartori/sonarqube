FROM jenkins/jenkins:2.282

COPY --chown=jenkins:jenkins config/plugins/ /usr/share/jenkins/ref/plugins/
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

COPY config/jenkins-casc.yaml /usr/local/jenkins-casc.yaml
ENV CASC_JENKINS_CONFIG /usr/local/jenkins-casc.yaml
