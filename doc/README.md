# IET Jay 2022

Contributors:

- Balázs Püspök-Kiss
- Adam Tran
- Bálint Dolla
- Péter Tóth
- Viktor Szabó

Authors of this documentation:

- Balázs Püspök-Kiss

I will list the tasks chosen by the team for the open-source Android application Jay.

## Technology focus

### Installing CI

Installing a simple CICD pipeline, which runs test on pull requests and/or pushes on the main branch.

### Writing Unit tests

Testing out data propagation classes for Jay. Mock dependent classes in Interactors, Presenters and Datasources inside the app and test them out via dependency injection.

### Static code analysis and code review

Review code on pull requests, write issues and use GitHub features to properly solve the problems. Impelement static code analysis in the CICD pipeline using SonarCloud.

## Product/User focus

### Manual, exploratory testing

Get to know the app and make exploratory tests for it. Manually test out expected behaviors.

### Writing UI tests

Espresso framework provides tools to UI test Android applications. Write a few UI tests using this tool.
