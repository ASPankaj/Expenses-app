/**
 * 
 */



$('document').ready(function(){	
	$('.table #editButton').on('click',function(event){	
		
		event.preventDefault();  		
		var href = $(this).attr('href');
		
		$.get(href, function(products, status){
			 $('#pidEdit').val(products.pid);
			 $('#product_nameEdit').val(products.product_name);
			 $('#priceEdit').val(products.price);
			 $('#manufacturing_dateEdit').val(products.manufacturing_date); 
			 $('#expiry_dateEdit').val(products.expiry_date);
			 $('#brandEdit').val(products.brand); 
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