pipeline {
    agent any

    environment {
        IMAGE_NAME = 'todolist'
        CONTAINER_PORT = '8080'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/NithilaS2005/ToDoList'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d -p 8080:$CONTAINER_PORT $IMAGE_NAME'
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i inventory.ini deploy.yml'
            }
        }
    }
}

