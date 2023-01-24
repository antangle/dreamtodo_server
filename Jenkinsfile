pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  environment {
    DOCKERHUB_CREDENTIALS = credentials('docker_hub_credentials')
  }
  stages {
    stage('PreBuild') {
      steps {
        sh './gradlew clean build'
      }
    }
    stage('Build') {
      steps {
        sh 'docker build -t antangle/dreamtodo_back .'
      }
    }
    stage('Login') {
      steps {
        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
      }
    }
    stage('Push') {
      steps {
        sh 'docker push antangle/dreamtodo_back'
      }
    }
  }
  post {
    always {
      sh 'docker logout'
    }
  }
}