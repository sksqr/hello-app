pipeline {
    agent any

    environment {
        EC2_USER = 'ubuntu'  // Update with your EC2 username
        EC2_HOST = 'ec2-3-21-159-74.us-east-2.compute.amazonaws.com'  // Replace with your EC2 instance IP
        JAR_NAME = 'hello-app-0.0.1-SNAPSHOT.jar'  // Change to your actual JAR file name
        DEPLOY_PATH = '/home/ubuntu/apps'  // Directory where JAR should be placed
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "mvn3.9.9"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/sksqr/hello-app.git'
            }
        }

        stage('Build and Package') {
            steps {
                sh 'mvn clean package -DskipTests'
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

        stage('Upload JAR to EC2') {
            steps {
                sh "scp -i /Users/shashikant/gfg/aws/new-jdbc-ec2-key.pem target/${JAR_NAME} ${EC2_USER}@${EC2_HOST}:${DEPLOY_PATH}/"
            }
        }

        stage('Kill Existing Application') {
            steps {
                sh "ssh -i /Users/shashikant/gfg/aws/new-jdbc-ec2-key.pem  ubuntu@ec2-3-21-159-74.us-east-2.compute.amazonaws.com  'kill -9 \$(pgrep -f hello-app-0.0.1-SNAPSHOT.jar)'"
            }
        }

        stage('Run new Application') {
            steps {
                sh "ssh -i /Users/shashikant/gfg/aws/new-jdbc-ec2-key.pem  ubuntu@ec2-3-21-159-74.us-east-2.compute.amazonaws.com  'nohup java -jar /home/ubuntu/apps/hello-app-0.0.1-SNAPSHOT.jar > /home/ubuntu/apps/app.log 2>&1 &'"
            }
        }

    }

    post {
        success {
            echo "Deployment successful!"
        }
        failure {
            echo "Deployment failed!"
        }
    }
}

