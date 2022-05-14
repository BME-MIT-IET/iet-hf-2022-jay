# CICD

Author of the document:

- Balázs Püspök-Kiss

Responsible for the writing the CICD pipeline, running unit tests and static code analysis via SonarCloud: 

- Balázs Püspök-Kiss

For this exercise, I had three main goals:

- Create a pipeline with caching.
- Run unit and/or UI tests on the pipeline.
- Run static code analysis via SonarCloud.

## CICD pipeline

Contributors:

- Balázs Püspök-Kiss

I used the Android CI template to configure
GitHub Actions.

<img src="assets/Android CI template.png" alt="Android CI template for configuring GitHub Actions">

### Caching

For caching, I used the ```actions/cache@v3```
package which is provided by GitHub. I configured
it with the Gradle template.

### Other configuration

In the base configuration, the Linux distribution
and Java JDK was already provided with proper
configuration.

## Building and running

Here, I elaborate on how I got to build Jay and
run the unit tests.

### Maps API key

For building the projects, I had to face several
problems. Jay uses Google Maps SDK to the map
inside the application, but the API key is
in a safe location, so it is not version
controlled. I had to create a repository secret
to manually add the key to a properly encoded
file on the virtual machine.

### Configure google-services.json

The other problem I faced was that another
non-version-controlled file was needed to
successfully build the project. This file
contained the keys to communicate with Google's
services. Jay uses Firebase as its main
authentication service and Google Maps to
display an interactive map. The workaround
was that I create a new repository secret
containing the content of the whole 
google-services.json file and paste it into
the proper location into the proper file.

### Running the tests

Now, that our project builds, it is time to run
some unit and/or UI tests. Unit tests are run
by giving the command ```bash ./gradlew test```
to the virtual machine. It runs the unit tests
associated with Jay.

## Static code analysis via SonarCloud

Setup was simple and easy, using the techniques
on sonarcloud.io's website.

<img src="assets/SonarCloud setup.png" alt="SonarCloud setup page contains all the information you need to setup your project">

I updated the ```build.gradle``` file, then
configured the CICD pipeline to work with
SonarCloud. I also had to create a new
repository secret, which contained the
token for authenticating the project.

# Conclusion

A CICD pipeline is hyper useful when an
individual or organization wants to have more
control over what is being developed. Cleaner,
more stable, less buggy code is what a CICD
pipeline can and will provide if setup and used
correctly.
