
function clique(){
	let produto = document.getElementById('produto').value;
	let quantidade = document.getElementById('quantidade').value;
	let valor = document.getElementById('valor').value;

	let data = {
			"produto" : produto,
			"quantidade" : quantidade,
			"valor" : valor
	};
			
			fetch("/item", {
				method: "POST",
				headers : {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(data)
				
			}).then(function(response){
				createTable();
				
			}).catch(function(error) {
				console.log(error);
			})
}


function createTable(){
	fetch("/item")
		.then(function(response){
		if(response.status >= 200 && response.status <= 300){
			
			response.json()
				.then(function(data){
					
					let tb = document.getElementById("item");
					tb.innerHTML =  "<tr><th>produto</th></th><th>quantidade</th><th>valor</th></tr>"
						
					for(let i = 0; i < data.content.length;i++){
						

						let k = data.content[i];
						tb.innerHTML += `<tr><th>${k.produto}</th><th>${k.quantidade}</th>
								<th>${k.valor}</th></tr>`;
					}
				})
		}
	}).catch(function(error) {
		console.log(error);
	});
}

createTable();
/*let xhr = new XMLHttpRequest();
xhr.open('GET','/item')//metodo, endereco, async, user, password 

xhr.onload = function(){
	if(this.status != 200) console.log("Error !");
	else{
		console.log(this.responseText);
		
		
		let a = JSON.parse(this.responseText);
		
		let tb = document.getElementById("item");
		
		console.log(a);
		console.log(a.content.length);
		for(let i = 0; i < a.content.length; i++)
		{
			console.log(1);
			let k = a.content[i];
			console.log(k);
			if(k.produto)
				tb.innerHTML += `<tr><th>${k.produto}</th><th>${k.quantidade}</th>
				<th>${k.valor}</th></tr>`;

		}
	}

};
	
xhr.send();

let xhr2 = new XMLHttpRequest();

function send() {
	xhr2.open('POST','/item')
	xhr2.setRequestHeader('content-Type','application/json');
	
		let produtos = document.getElementById('produto').value;
		let quantidades = document.getElementById('quantidade').value;
		let valorTotal = document.getElementById('valor').value;
		
		//console.log(produtos+ " "+quantidades+" "+valorTotal);   
		
		let form = {
				"produto" : `${produtos}`,
				"quantidade" : `${quantidades}`,
				"valor" : `${valorTotal}`
		}
		
		xhr2.send(JSON.stringify(form));

		
		
}
*/

/*error
xhr2.setRequestHeader('content-Type','application/json');

let novo_p ={"produto"; "tarara",
"item":{"id":20}
"coordinate":{"latitude":-45.8485,
	"longitude":-66.3345}
};

xhr2.send(JSON.stringify(novo_p));

xhr.onerror = () => alert('erro!');
xhr.send();
*/

