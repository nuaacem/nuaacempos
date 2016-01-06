var TableManaged = function () {

    return {

        //main function to initiate the module
        init: function () {
            
            if (!jQuery().dataTable) {
                return;
            }

            // begin first table
            $('#website_table').dataTable({
            	"aoColumns": [
                              { "bSortable": false },
                              null,
                              { "bSortable": false, "sType": "text" },
                              null,
                              { "bSortable": false },
                              { "bSortable": false },
            				  null
                            ],
                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"] // change per page values here
                ],
                // set the initial value
                "iDisplayLength": 15,
                "sPaginationType": "bootstrap",
                "oLanguage": {
                    "sLengthMenu": "_MENU_ records",
                    "oPaginate": {
                        "sPrevious": "Prev",
                        "sNext": "Next"
                    }
                },
                "aoColumnDefs": [
                    { 'bSortable': false, 'aTargets': [0] },
                    { "bSearchable": false, "aTargets": [ 0 ] }
                ]
            });

            jQuery('#website_table .group-checkable').change(function () {
                var set = jQuery(this).attr("data-set");
                var checked = jQuery(this).is(":checked");
                jQuery(set).each(function () {
                    if (checked) {
                        $(this).attr("checked", true);
                        $(this).parents('tr').addClass("active");
                    } else {
                        $(this).attr("checked", false);
                        $(this).parents('tr').removeClass("active");
                    }                    
                });
                jQuery.uniform.update(set);
            });

            jQuery('#website_table').on('change', 'tbody tr .checkboxes', function(){
                 $(this).parents('tr').toggleClass("active");
            });

            jQuery('#website_table_wrapper .dataTables_filter input').addClass("form-control input-medium input-inline"); // modify table search input
            jQuery('#website_table_wrapper .dataTables_length select').addClass("form-control input-xsmall"); // modify table per page dropdown
            //jQuery('#website_table_wrapper .dataTables_length select').select2(); // initialize select2 dropdown            
       
            jQuery('#edit_btn').on('click', function(){
            	var checkboxes = $('.checkboxes:checked');
            	if (checkboxes.length > 0) {
            		location.href = "edit/" + checkboxes[0].value;
            	}
            	else
        		{
            		alert('没有选中的站点！');
        		}
            });
            
            jQuery('#delete_btn').on('click', function(){
            	var checkboxes = $('.checkboxes:checked');
            	if (checkboxes.length > 0) {
            		if (!confirm("确定删除选中的站点")) {
            			return;
            		}
            		var s = "";
            		for (var i = 0; i < checkboxes.length; i++) {
            			s += checkboxes[i].value + ","
            		}
            		location.href = "delete/" + s;
            	}
            	else
        		{
            		alert('没有选中的站点！');
        		}
            });
        }

    };

}();