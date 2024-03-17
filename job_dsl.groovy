folder('Tools') {
    displayName('Tools')
    description('Folder for miscellaneous tools')
}

freeStyleJob('/Tools/clone-repository') {
    displayName('clone-repository')

    parameters {
        stringParam('GIT_REPOSITORY_URL', '', 'Git URL of the repository to clone')
    }
    steps {
        shell("git clone \${GIT_REPOSITORY_URL} .")
    }
    wrappers {
        preBuildCleanup {
            preBuildCleanup()
        }
    }
}

freeStyleJob('Tools/SEED') {
    parameters {
        stringParam('GITHUB_NAME', '', 'GitHub repository owner/repo_name (e.g.: "EpitechIT31000/chocolatine")')
        stringParam('DISPLAY_NAME', '', 'Display name for the job')
    }
    steps {
        dsl {
            text('''freeStyleJob("Tools/$DISPLAY_NAME") {
                triggers {
                    scm('* * * * *')
                }
                scm {
                    github("$GITHUB_NAME")
                }
                wrappers {
                    preBuildCleanup {
                        preBuildCleanup()
                        }
                    }
                steps {
                    shell('make fclean')
                    shell('make')
                    shell('make tests_run')
                    shell('make clean')
                }
            }
            ''')
        }
    }
}
