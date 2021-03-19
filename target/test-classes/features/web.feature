#language: pt

Funcionalidade: Buscar Cursos por professor
	Como usuário 
	Quero fazer pesquisas no site
	Para que eu possa verificar o preço dos cursos
	
@pesquisaPorProfessor
Esquema do Cenário: Deve pesquisar pelo nome do professor
	Dado que eu acessei o portal
	E clico no botão Por Professor
	E clico no botão com o nome do professor "<nome>"
	E seleciono um curso "<curso>"
	E clico no botão Detalhes
	Então valido se o valor do curso da listagem é igual ao que está dentro da tela de detalhes	
	
Exemplos: 
	|nome      |curso																																													|
	|Ena Loiola|Conhecimentos Específicos p/ Prefeitura Araçariguama-SP (Professor PEB II - Inglês) Pós-Edital|


@pesquisaPorMatéria
Esquema do Cenário: Deve pesquisar pelo nome da matéria
	Dado que eu acessei o portal
	E clico no botão por matéria
	E clico no botão com o nome da matéria "<materia>"
	Então seleciono uma assinatura "<assinatura>"

	
Exemplos: 
	|materia        |assinatura																|
	|Receita Federal|Assinatura Básica 1 Ano - Cartão até 12 x|

	
@pesquisaPorBusca
Esquema do Cenário: Deve pesquisar pela caixa de busca
	Dado que eu acessei o portal
	E digito o que procuro na caixa de busca "<busca>"
	E valido que o que foi buscado é o mesmo que digitei "<busca>"
	E seleciono um pacote "<pacote>"
	Então valido se ele clicou no pacote que solicitei"<pacote>"
	
Exemplos: 
	|busca     |pacote        																															 |
	|Prefeitura|Pacote p/ Prefeitura de Redenção-PA (Fonoaudiologia) - Pós-Edital|
	

@validarLogin
Esquema do Cenário: Deve cadastrar um novo usuário
	Dado que eu acessei o portal
	E faço o login com o "<usuario>" e "<senha>"
	Então valido que o login foi feito

Exemplos:
	|usuario										|senha |
	|c00691d4cc@firemailbox.club|123456|	
	