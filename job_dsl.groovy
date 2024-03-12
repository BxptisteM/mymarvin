folder('Tools') {
    description('Folder for miscellaneous tools')
    displayName('Tools')

    freestyleJob('clone-repository') {
        displayName('clone-repository')

        // Has a GIT_REPOSITORY_URL string parameter with a “Git URL of the repository to clone” description and no default value.
        parameters {
            stringParam('GIT_REPOSITORY_URL', '', 'Git URL of the repository to clone')
        }
        // When executed, clone with Git the repository at the specified URL, using a single shell command.
        steps {
            script {
                sh("git clone \${GIT_REPOSITORY_URL} .")
            }
        }
        // Performs a pre-build workspace cleanup
        wrappers {
            preBuildCleanup {
                preBuildCleanup()
            }
        }
        // Is only executed manually.
        triggers {
            manual()
        }
    }
}
