/**
 * 
 */



$('document').ready(function(){	
	$('.table #editButton').on('click',function(event){	
		
		event.preventDefault();  		
		var href = $(this).attr('href');
		
		$.get(href, function(transactions, status){
			 $('#tidEdit').val(transactions.tid);
			 $('#transaction_amountEdit').val(transactions.transaction_amount);
			 $('#senderEdit').val(transactions.sender);
			 $('#receiverEdit').val(transactions.receiver); 
			 $('#transaction_dateEdit').val(transactions.transaction_date);
		});	
		
		
		
		$('#editModal').modal();				
	});	 
	
	$('.table #deleteButton').on('click',function(event){		
		
		event.preventDefault(); 
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
		
	});
	
	
	$('#dropdownMenuLink').on('click',function(event){		
		
		event.preventDefault(); 
		
		$('#dropdownLink').modal();
		
	});
	
	
});