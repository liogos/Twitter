<img src="img/cl-users-avatar.png" alt="" />	
	<%

		out.print("<h2>"
				+"Connectez-vous"	
				+"</h2>"
				+"<form action='TweetsConnect' method='Post'>"
				+"<input type='email' name='email' placeholder='email' value='' size='30' />"
				+"<input type='password' name='pwd' placeholder='password' value='' size='30'/>"	
				+"<input type='hidden' name='where' value='"+request.getServletPath().substring(1) +"'/>"
				+"<input type='submit' name='submit'>"
				+"</form>"
				);
		if(session.getAttribute("errorLogin").equals(true)){
			out.print("<p class='showError'>"
					+"Email or password incorrect ! "
					+" </p>"		
					);			
		}
		out.print("<hr/>"
				+"<p>Pas encore de compte? <button type='button'>Créer un compte</button> </p>"		
				);		
	%>		