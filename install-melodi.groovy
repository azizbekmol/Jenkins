properties([
    parameters([
        string(defaultValue: '', description: 'Enter IP Address', name: 'IP', trim: true)
    ])
])

node {
    stage("Pull repo"){
        git 'https://github.com/azizbekmol/ansible-melodi.git'
    }

    withCredentials([sshUserPrivateKey(credentialsId: 'jenkins-master-key', keyFileVariable: 'SSH_KEY', passphraseVariable: '', usernameVariable: 'SSH_USERNAME')]) {
        stage('Install Melodi'){
            sh """
                export ANSIBLE_HOST_KEY_CHECKING=False
                ansible-playbook -i \"${ params.IP },\" --private-key $SSH_KEY -u $SSH_USERNAME -b main.yml 
            """
        }
    }
}

