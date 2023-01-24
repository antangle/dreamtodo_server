pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  environment {
    DOCKERHUB_CREDENTIALS = credentials('docker_hub_credentials')
    DOCKERHUB_URL = "dreamtodo_server"
    DOCKERHUB_HOST = "antangle"
  }
  stages {
    stage('Java Build') {
      steps {
        sh './gradlew build'
      }
    }
    stage('Docker Image Build') {
      steps {
        sh 'docker build -t $DOCKERHUB_HOST/$DOCKERHUB_URL .'
      }
    }
    stage('Docker Login') {
      steps {
        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
      }
    }
    stage('Docker Image Push') {
      steps {
        sh 'docker push $DOCKERHUB_HOST/$DOCKERHUB_URL'
      }
    }
  }
  post {
    always {
      sh 'docker logout'
    }
  }
}