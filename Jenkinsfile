pipeline{

    agent {
        label 'windows'
    }
        environment {

            DOCKER_CREDENTIALS_ID= 'dockerhub'
            DOCKER_IMAGE_NAME= 'samadhangapat/mf_app:latest'
            DOCKER_USERNAME='samadhangapat'
            DOCKER_PASSWORD='Samraj@10'
            ANSIBLE_VM_IP = '192.168.59.111'
            ANSIBLE_USER = 'samra'
            ANSIBLE_CREDENTIALS_ID = 'ansible_credentials'

        }
   
        stages{
            stage('checkout'){

                steps {

                    git url: 'https://github.com/Samraj10/mf.git', branch: 'master'

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

                        def dockerFileName='Dockerfile'
                        def dockerTag='latest'
                        def dockerfilePath='D://applications//mf//mf'
                        def dockerImageName='mf_app'
                        bat 'cd D:/applications/mf/mf'
                        bat 'docker build -t samadhangapat/mf_app:latest .'
                      
                    }
                }
            }
/*
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
            stage ('ssh into ansible server') {

                steps {

                    ssh  'samra@192.168.59.111'

                    sh 'ansible-playbook windows_ping.yml'
                    
                }

            }


    }
}
            