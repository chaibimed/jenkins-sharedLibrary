def call(){
    node {
        sh '''
          git --version
          docker --version
          dotnet --list-sdks
        '''
    }
}