$.extend( true, $.fn.dataTable.defaults, {
	dom: "ftp",
	columnDefs: [
		{ orderable: false, targets: -1 }
	],
    language: {
    	search: "",
        searchPlaceholder: "Rechercher",
        emptyTable: "Aucune donnée retournée",
        zeroRecords: "Aucune donnée correspondante trouvée",
        paginate: {
            first: "Premier",
            last: "Dernier",
            next: "Suivant",
            previous: "Précédent"
        },
    }
});

const toast = swal.mixin({
	toast: true,
	position: 'top-end',
	showConfirmButton: false,
	timer: 3000
});

$(document).ready(function() {
	$('.datatable').DataTable();
	$('div.dataTables_filter input').focus();
	$('.modal').on('shown.bs.modal', function () {
		$('input:text:visible:first', this).focus();
	});
	
    $.ajax({
        url: "http://localhost:8080/employees/countTimesheetNotification"
    }).then(function(data) {
    	if(data != 0) {
        	$("#toApproveBadge").text(data);
        	$("#toApproveBadge").show();
    	}
    });
});