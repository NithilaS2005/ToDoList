pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/NithilaS2005/ToDoList.git', branch: 'main', credentialsId: 'NithilaS2005/****** (GitHub PAT for Jenkins)
'
            }
        }

        stage('Build (Maven)') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Ansible Playbook') {
            steps {
                sh 'ansible-playbook -i hosts deploy_app.yml'
            }
        }
    }
}
