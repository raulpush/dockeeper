function queryById(index) {
alert("paragrafu "+index+" ... urmeaza sa fie afisat .. da nu e implementat inca:)");

$.getJSON('<spring:url value="paragraphs.json/100"/>', {
					ajax : 'true'
				}, function(data){
					alert(data);
				});
}