pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo "📦 Compiling Java project..."
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                echo "🧪 Running JUnit tests..."
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                echo "🐳 Building Docker image..."
                sh 'docker build -t todolist-app .'
            }
        }

        stage('Deploy with Ansible') {
            steps {
                echo "🚀 Deploying using Ansible..."
                sh 'ansible-playbook -i hosts deploy_app.yml'
            }
        }
    }
}
