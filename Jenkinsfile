pipeline {
    agent any  // Runs on any available agent

//     environment {
//         SONARQUBE_URL = 'http://your-sonarqube-server'  // Update with your SonarQube URL
//         SONARQUBE_CREDENTIALS = 'sonarqube-token' // Add credentials in Jenkins and use its ID
//     }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/sksqr/hello-app.git'  // Replace with actual repo URL
            }
        }

//         stage('SonarQube Analysis') {
//             steps {
//                 withSonarQubeEnv(credentialsId: SONARQUBE_CREDENTIALS) {
//                     sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=your-project-key'
//                 }
//             }
//         }

        stage('Build Application') {
            steps {
                sh 'mvn clean package -DskipTests'  // Skip tests in build stage (already tested separately)
            }
        }

        stage('Run Unit Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'  // Collect test reports
                }
            }
        }

        stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

//         stage('Deploy') {
//             steps {
//                 echo "Deploying JAR to server..."
//                 // Add actual deployment command here (e.g., SCP, Docker, Kubernetes, etc.)
//                 sh 'scp target/*.jar user@server:/path/to/deploy/'
//             }
//         }
    }

    post {
        failure {
            echo "Build failed! Please check the logs."
        }
        success {
            echo "Build and deployment successful!"
        }
    }
}
