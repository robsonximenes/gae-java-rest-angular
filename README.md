appengine-skeleton
=============================


Novo projeto: EpdemicBonus

Gerando um novo projeto
	mvn archetype:generate -Dappengine-version=1.9.37 -Dapplication-id=your-app-id -Dfilter=com.google.appengine.archetypes:
	mvn clean install

Rodar local:  http://localhost:8080/
	mvn appengine:devserver


DEPLOY

mvn appengine:update


	