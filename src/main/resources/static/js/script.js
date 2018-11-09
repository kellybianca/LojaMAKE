let xhr = new XMLHttpRequest();
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


/*
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

