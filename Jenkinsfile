pipeline {
    agent any

    environment {
        MVN_HOME = '/usr/share/maven'
    }

    stages {
        stage('Clone') {
            steps {
                git credentialsId: 'github-pat', url: 'https://github.com/NithilaS2005/ToDoList.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i hosts deploy_app.yml'
            }
        }

        stage('Send Metrics') {
            steps {
                sh '''
                    echo "app.todo.build_time $(date +%s)" | nc 127.0.0.1 2003
                '''
            }
        }
    }
}
