pipeline{

    agent {
        label 'windows'
    }
        environment {

            DOCKER_CREDENTIALS_ID= 'dockerhub'
            DOCKER_IMAGE_NAME= 'samadhangapat/inquiryms:latest'
            DOCKER_USERNAME='samadhangapat'
            DOCKER_PASSWORD='Samraj@10'
           

        }
  
        stages{

/*
            stage('checkout'){

                steps {

                    git url: 'https://github.com/Samraj10/inquiryms.git', branch: 'master'

                }

            }
            stage('build'){

                steps {

                    bat 'mvn clean package'
                }
            }
            stage('test'){

                steps {

                    bat 'mvn test'
                }

            }

            stage ('check docker version') {

                steps {

                    script {
                    // Verify Docker is available
                    bat 'docker --version'
                     }
                }

            }

            stage ('build docker image') {

                steps {

                    script {
                        
                        bat 'cd D:/applications/inquiryms'
                        bat 'docker build -t samadhangapat/inquiryms:latest .'
                      
                    }
                }
            }

            stage('push docker image'){

                steps {
                    
                    script {

                        withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                            bat "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
                        }
                            bat " docker push ${DOCKER_IMAGE_NAME} "

                    }
                }
            }


*/            
        stage('SSH into Ansible Server and Run Playbook') {
            steps {
                // Use the SSH Publisher plugin to run commands on the remote server
                sshPublisher( 
                    publishers: [
                        sshPublisherDesc(
                            configName: 'ansible_server',  // Name of the SSH server configured in Jenkins
                            transfers: [
                                sshTransfer(
                                    sourceFiles: 'inquiryms/k8s-ims/deploy-script.yml',  // Source files to transfer (optional)
                                    remoteDirectory: 'power-tiller-app',  //                       
                                    execCommand: 'ansible-playbook /home/samra/power-tiller-app/k8s-ims/deploy-script.yml',  // Command to execute
                                    removePrefix: '',  // Remove prefix from transferred files (optional)
                                    execTimeout: 120000,  // Execution timeout in milliseconds (optional)
                                    usePty: true  // Use Pseudo Terminal (optional)
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
            