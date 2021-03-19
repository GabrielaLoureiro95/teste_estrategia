:brazil:

## Instruções:

1. 🖥️ A resolução da tela deve ser 1280 x 720, sem alteração de escala;

2. Instalar JDK de https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html (será necessário fazer login com um usuário Oracle para fazer o download);

3. Instalar IDE "Eclipse IDE for Java Developers" de http://www.eclipse.org/downloads/packages/release/2021-03/r/eclipse-ide-java-developers;

4. :cucumber: Instalar o plugin do Cucumber no Eclipse, indo em Help -> Marketplace -> digite Cucumber no campo de pesquisa e instale o plugin "Cucumber Eclipse Plugin"

5. Importar o projeto para o Eclipse, indo em File -> Import... -> Maven -> Existing Maven Projects -> Next -> Selecione a pasta onde está localizado o projeto -> Selecione o projeto -> Finish;

6. Rodar o arquivo "Runner.java" no Eclipse, alterando o conteúdo do campo "tags" de acordo com a tag do teste que deseja rodar, conforme visto no arquivo "web.feature", por exemplo:

   tags = {"@pesquisaPorProfessor"}
   ou
   tags = {"@validarLogin"}.

:us:

## Instructions:

1. 🖥️The screen resolution must be 1280 x 720, without scaling;

2. Install JDK from https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html (you must log in with an Oracle user account in order to download);

3. Install "Eclipse IDE for Java Developers" IDE from http://www.eclipse.org/downloads/packages/release/2021-03/r/eclipse-ide-java-developers;

4. :cucumber: Install the Cucumber plugin for Eclipse, in Help -> Marketplace -> type Cucumber in the "Find:" field and install "Cucumber Eclipse Plugin"

5. Import the project into Eclipse, in File -> Import... -> Maven -> Existing Maven Projects -> Next -> Select the folder where the project is located -> Select the project -> Finish;

6. Run the "Runner.java" file in Eclipse, altering the content in the "tags" according to the tag for the test you wish to run, as seen in the "web.feature" file, for example:

   tags = {"@pesquisaPorProfessor"}
   or
   tags = {"@validarLogin"}.