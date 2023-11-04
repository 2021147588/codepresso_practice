$(document).ready(function(){

	$.ajax({
        url: "/posts"
    }).then(function(data) {
    	$.each(data.data, function(index, e) {
			console.log(e);
			$('#posts').append(
				'<div class="card mb-4"> <div class="card-body"> <h2 class="card-title">' + e.title
				+ '</h2> <p class="card-text">' + e.content
				+ '</p> <a href="/post/detail/' + e.id
				+ '" class="btn btn-primary">Read More &rarr;</a> </div> '
				+ '</div> </div>');
    	});
       console.log(data);
    }, function(err) {
    	console.log(err.responseJSON);
    });


});
