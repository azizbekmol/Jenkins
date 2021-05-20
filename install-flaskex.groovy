properties([
    parameters([
        string(defaultValue: '', description: 'Enter IP Address', name: 'IP', trim: true)
    ])
])

node {
    stage("Pull repo"){
        git 'https://github.com/azizbekmol/ansible-Flaskex.git'
    }

    stage('Install FlaskEx'){
        withEnv(['FLASKEX_REPO=https://github.com/ikambarov/Flaskex.git', 'FLASKEX_BRANCH=master']) {
            ansiblePlaybook become: true, colorized: true, credentialsId: 'jenkins-master-key', disableHostKeyChecking: true, inventory: "${ params.IP },", playbook: 'main.yml'
        }
    }
}
