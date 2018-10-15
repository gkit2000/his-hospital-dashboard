
<%--
 *  Copyright 2009 Society for Health Information Systems Programmes, India (HISP India)
 *
 *  This file is part of Patient-dashboard module.
 *
 *  Patient-dashboard module is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  Patient-dashboard module is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Patient-dashboard module.  If not, see <http://www.gnu.org/licenses/>.
 *
--%>
<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<style type="text/css">

</style>

<script type="text/javascript">
jQuery(document).ready(  
		function() { 	
			jQuery("#homeNavLink").hide();
			jQuery("#findPatientNavLink").hide();
			jQuery("#dictionaryNavLink").hide();
			jQuery("#administrationNavLink").hide();
			jQuery("#userLoggedOut").hide();
			jQuery("#userLogIn").hide();
			jQuery("#userHelp").hide();
		});
</script>

<script type="text/javascript">
function abc(){
	var identifier=jQuery("#identifier").val();
	jQuery.ajax({
		type : "GET",
		url : getContextPath() + "/module/patientdashboard/searchPatientByIdentifier.form",
		data : ({
			identifier			: identifier
		}),
		success : function(data) {
			jQuery("#searchResult").html(data);	
				//tb_init("a.thickbox"); // init to show thickbox
		},
		error : function(xhr, ajaxOptions, thrownError) {
			alert(thrownError);
		}
	});
}
</script>
<script type="text/javascript">
function getContextPath(){		
		pn = location.pathname;
		len = pn.indexOf("/", 1);				
		cp = pn.substring(0, len);
		return cp;
	}
</script>

<div class="box">
<b style="text-align: center" class="boxHeader">Patient Search</b>
<form>
<table width="100%">
<tr>
<td>Search Details By 16 digit Patient Identifier</td>
<td><input type="text" id="identifier" name="identifier" onkeyup="abc(this);"> </td>
<td><input type="button" id="butt" name="butt" value="submit" onclick="abc();"> </td>
</tr>
</table>
</form>
<div id="searchResult">
</div>
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>
