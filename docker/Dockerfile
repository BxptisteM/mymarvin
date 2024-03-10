# Jenkins official image
FROM jenkins/jenkins:lts-jdk17

# Disable the setup wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

# Copier le fichier de liste de plugins dans le conteneur
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt

# Utiliser jenkins-plugin-cli pour installer les plugins
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# # Ajouter votre fichier de configuration JCasC dans l'image
# COPY my-jenkins-configuration.yml /var/jenkins_home/casc_configs/my-jenkins-configuration.yml

# # Dire à Jenkins où trouver les fichiers de configuration JCasC
# ENV CASC_JENKINS_CONFIG="/var/jenkins_home/casc_configs"