pipeline {
    agent {
        label 'windows' // Specify the Jenkins agent label
    }
    
    environment {
        DOCKER_CREDENTIALS_ID = 'dockerhub' // Define Docker credentials ID
        DOCKER_IMAGE_NAME = 'samadhangapat/inquiryms:latest' // Define Docker image name
    }
  
    stages {

        stage ('checkout') {
            steps {
                deleteDir() // Clean workspace before checking out
                git url: 'https://github.com/Samraj10/inquiryms.git', branch: 'master' // Checkout Git repository
            }
        }


        stage ('build') {
            steps {
                bat 'mvn clean package' // Build the project using Maven
            }
        }

        stage ('test') {
            steps {
                bat 'mvn test' // Run tests using Maven
                
            }
        }

        //Sonar stage


        stage ('check docker version') {
            steps {
                script {
                    // Verify Docker is available
                    bat 'docker --version'
                }
            }
        }

        // Uncomment and configure Docker build and push stages if needed
       
        stage ('build docker image') {
            steps {
                script {
                    docker.build('samadhangapat/inquiryms:latest') // Build Docker image
                }
            }
        }

        stage ('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
                        docker.image('samadhangapat/inquiryms:latest').push() // Push Docker image to registry
                    }
                }
            }
        }
 

        stage ('SSH into Ansible Server and Run Playbook') {
            steps {
                sshPublisher( 
                    publishers: [
                        sshPublisherDesc(
                            configName: 'ansible_server', // Name of SSH server configured in Jenkins
                            transfers: [
                                sshTransfer(
                                    sourceFiles: '**/ansible/k8s-ims', // Files to transfer (optional)
                                    remoteDirectory: '/power-tiller-app', // Remote directory to transfer files
                                    execCommand: 'ansible-playbook /home/samra/power-tiller-app/k8s-ims/site.yml', // Command to execute on remote server
                                    removePrefix: '/ansible/k8s-ims', // Remove prefix from transferred files (optional)
                                    execTimeout: 120000, // Execution timeout in milliseconds (optional)
                                    usePty: true // Use Pseudo Terminal (optional)
                                )
                            ],
                            usePromotionTimestamp: false,
                            useWorkspaceInPromotion: false,
                            verbose: true
                        )
                    ]
                )
            }
        }
    }
}
