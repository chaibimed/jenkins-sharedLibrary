def call(){
    pipeline {
        agent any
        environment {
            MODULE='m4'
        }
        
        stages {
            stage('Verify'){
                steps {
                       sh '''
                          git --version
                          docker --version
                          dotnet --list-sdks
                        '''
                }
            }
        }
    }
}
