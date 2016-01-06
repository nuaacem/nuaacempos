var TableEditable = function () {

    return {

        //main function to initiate the module
        init: function () {
            function restoreRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);

                for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    oTable.fnUpdate(aData[i], nRow, i, false);
                }

                oTable.fnDraw();
            }

            function editRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML = '<input type="text" class="m-wrap small" value="' + aData[0] + '">';
                jqTds[1].innerHTML = '<a class="edit btn mini green" href=""><i class="icon-save"></i>Save</a>';
                jqTds[2].innerHTML = '<a class="cancel btn mini" href=""><i class="icon-remove"></i>Cancel</a>';
			}

            function saveRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                var word = jqInputs[0].value;
                if (jqInputs[1] == null) {
                	$(nRow).append('<input id="keywords\'' + word 
        					+ '\'.name" name="keywords[\''+ word
        					+'\'].name" value="'+ word
        					+'" type="hidden">');
                }
                else
                {
                	jqInputs[1].outerHTML = '<input id="keywords\'' + word 
                					+ '\'.name" name="keywords[\''+ word
                					+'\'].name" value="'+ word
                					+'" type="hidden">';
                	if (jqInputs[2] != null) {
                		jqInputs[2].id = "keywords'" + word + "'.id";
                		jqInputs[2].name = "keywords['" + word + "'].id";                		
                	}
                }	
                oTable.fnUpdate(word, nRow, 0, false);
                oTable.fnUpdate('<a class="edit btn mini purple" href="javascript:;"><i class="icon-edit"></i>Edit</a>', nRow, 1, false);
                oTable.fnUpdate('<a class="delete btn mini black" href="javascript:;"><i class="icon-trash"></i>Delete</a>', nRow, 2, false);
				oTable.fnDraw();
            }

            function cancelEditRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 1, false);
                oTable.fnDraw();
            }

            var oTable = $('#keyword_editable').dataTable({
                bPaginate : false,
				bSort : false,
				bFilter : false,
				bInfo : false,
				bAutoWidth : false,
				aoColumnDefs: [
					{ "sWidth" : "50%",
					  "aTargets" : [ 0 ]
					}					  
				]
                // set the initial value                
            });

            var nEditing = null;
			var nNew = false;

            $('#keyword_editable_new').click(function (e) {
                e.preventDefault();
				
				if (nNew && nEditing) {
					if (confirm("新建项尚未保存,是否现在保存?")) {
						saveRow(oTable, nEditing); // save
						$(nEditing).find("td:first").html("Untitled");
						nEditing = null;
						nNew = false;

					} else {
						oTable.fnDeleteRow(nEditing); // cancel
						nEditing = null;
						nNew = false;
						
						return;
					}
				}				
				
                var aiNew = oTable.fnAddData(['', '', ''
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                nEditing = nRow;
				nNew = true;

            });

            $('#keyword_editable a.delete').live('click', function (e) {
                e.preventDefault();

                if (confirm("Are you sure to delete this row ?") == false) {
                    return;
                }

                var nRow = $(this).parents('tr')[0];
                oTable.fnDeleteRow(nRow);
                alert("Deleted! Do not forget to do some ajax to sync with backend :)");
            });

            $('#keyword_editable a.cancel').live('click', function (e) {
                e.preventDefault();
                if (nNew) {
                    oTable.fnDeleteRow(nEditing);
					nEditing = null;
					nNew = false;
                } else {
                    restoreRow(oTable, nEditing);
                    nEditing = null;
                }
            });

            $('#keyword_editable a.edit').live('click', function (e) {
                e.preventDefault();

                /* Get the row as a parent of the link that was clicked on */
                var nRow = $(this).parents('tr')[0];

                if (nEditing !== null && nEditing != nRow) {
                    /* Currently editing - but not this row - restore the old before continuing to edit mode */
                    restoreRow(oTable, nEditing);
                    editRow(oTable, nRow);
                    nEditing = nRow;
                } else if (nEditing == nRow && this.innerHTML.indexOf("Save") >= 0) {
                    /* Editing this row and want to save it */
                    saveRow(oTable, nEditing);
                    nEditing = null;
                    //alert("Updated! Do not forget to do some ajax to sync with backend :)");
                } else {
                    /* No edit in progress - let's start one */
                    editRow(oTable, nRow);
                    nEditing = nRow;
                }
            });
        }

    };

}();