pipeline{

    agent {
        label 'windows'
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

            stage('build Docker image') {
            steps {
                script {
                    def dockerImage = 'mf-app'
                    def dockerFilePath = '/Dockerfile'
                    def dockerTag = 'latest'
                    
                    bat "docker build -t ${dockerImage}:${dockerTag} -f ${dockerFilePath} ."
                }
            }
        } 

    }   

}