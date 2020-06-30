/**
 * 
 */



$('document').ready(function(){	
	$('.table #editButton').on('click',function(event){	
		
		event.preventDefault();  		
		var href = $(this).attr('href');
		
		$.get(href, function(expense, status){
			 $('#idEdit').val(expense.id);
			 $('#nameEdit').val(expense.name);
			 $('#priceEdit').val(expense.price);
			 $('#dateEdit').val(expense.date); 			
		});	
		
		
		
		console.log("im here coming in this");
		$('#editModal').modal();				
	});	 
	
	$('.table #deleteButton').on('click',function(event){		
		
		event.preventDefault(); 
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
		
	});
});