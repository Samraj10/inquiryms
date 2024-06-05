pipeline{

    agent {
        label 'windows'
    }
        environment {

            DOCKER_CREDENTIALS_ID= ''
            DOCKER_IMAGE_NAME= 'samadhangapat/mf_app:latest'

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
                        bat 'docker build -t ${DOCKER_IMAGE_NAME} .'
                      
                    }
                }
            }

            stage('push docker image'){

                steps {
                    
                    script {

                        withCredentials([string(credentialsId: dockerhub, variable: 'DOCKERHUB_PASSWORD')]) {
                        bat "docker login -u your-docker-username -p %DOCKERHUB_PASSWORD%"
                    }
                        bat " docker push ${DOCKER_IMAGE_NAME} "

                    }


                }

            }           

    }   

}