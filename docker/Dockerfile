# Jenkins official image
FROM jenkins/jenkins:lts-jdk17

# Disable the setup wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

# Mount plugin list to the Jenkins container
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt

# Install the plugins from the plugin.txt file with jenkins-plugin-cli
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# Setting up an environement var for the configuration as code path
ENV CASC_JENKINS_CONFIG="/var/jenkins_home/casc_configs"

# Copy the Job DSL script into the container
COPY ../job_dsl.groovy /usr/share/jenkins/ref/job_dsl.groovy
