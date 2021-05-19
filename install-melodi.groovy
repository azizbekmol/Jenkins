properties([
    parameters([
        string(defaultValue: '', description: 'Enter IP Address', name: 'IP', trim: true)
    ])
])

node {
    stage("Pull repo"){
        git 'https://github.com/azizbekmol/ansible-melodi.git'
    }
    stage('Install Melodi'){
        ansiblePlaybook become: true, colorized: true, credentialsId: 'jenkins-master-key', disableHostKeyChecking: true, inventory: "${ params.IP },", playbook: 'main.yml'
    }
}


