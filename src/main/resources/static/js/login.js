''
function clicando(){
	let nome = document.getElementById('nome').value;
	let cpf = document.getElementById('cpf').value;

	let data = {
			"nome" : nome,
			"cpf" : cpf
		
	};
			
			fetch("/login", {
				method: "POST",
				headers : {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(data)
				
			}).then(function(response){
				criandoTable();
				
			}).catch(function(error) {
				console.log(error);
			})
}


function criandoTable(){
	fetch("/cliente")
		.then(function(response){
		if(response.status >= 200 && response.status <= 300){
			
			response.json()
				.then(function(data){
					
					let tb = document.getElementById("cliente");
					tb.innerHTML =  "<tr><th>  </th></th><th>  </th></tr>"
						
					for(let i = 0; i < data.content.length;i++){
						

						let k = data.content[i];
						tb.innerHTML += `<tr><th>${k.nome}</th><th>${k.cpf}</th></tr>`;
					}
				})
		}
	}).catch(function(error) {
		console.log(error);
	});
}

criandoTable();