# anagramapp

A web app for serching anagrams for a given word. It uses an embedded English dictionary to lookup all possible anagrams of the word. The architecture diagram is below.

<br>

![anagramArchDiagram](https://user-images.githubusercontent.com/36462985/86835100-a45ed980-c069-11ea-8bed-76f720db4865.png)

<br>

<h4> Requirement </h4>
Create an internet-facing web service accepting a single word and deriving all possible anagrams.

<h4> Technology Overview </h4>
The architecture is designed with security, high availability and scalability in mind. The web app is developed using Spring Boot 2.3.1 and Java 8 which runs in Tomcat. Continuous integration with Github and Jenkins allows automated build when code changes are committed. A successful build triggers a Jenkins job to create a docker image based on the generated WAR file and upload it to Docker Hub using Ansible playbooks. A downstream Jenkin job then triggers the master node in a Kubernetes cluster to pull the docker image and create a deployment and service for the Anagram app.
<br>
The app is designed following the MVC framework. AnagramController accepts a request with a word entered in an HTML form and calls AnagramService to look up all possible anagrams. AnagramService implements an anagram search algorithm based on string permutation and dictionary lookup.  It returns all possible anagrams to the controller. If no anagram is found in the dictionary it returns a string indicating that no match is found. The list of anagrams is displayed in the browser.

<h4> Unit Testing </h4>
A couple of unit testings are included in the repository. It checks for a valid return of anagrams and a no match found outcome.

<h4> Input Validation </h4>
Client side validation enforces a word with a minimum of 2 and maximum of 8 characters to be entered. No space is allowed.


