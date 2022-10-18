package ifsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Cadastro() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String cep = request.getParameter("cep");
		String telefone = request.getParameter("telefone");
		
		if (nome.isBlank() || endereco.isBlank() || bairro.isBlank() || cidade.isBlank() || cep.isBlank() || telefone.isBlank()) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} 
		else {
			
			session.setAttribute("nome", nome);
			session.setAttribute("endereco", endereco);
			session.setAttribute("bairro", bairro);
			session.setAttribute("cidade", cidade);
			session.setAttribute("cep", cep);
			session.setAttribute("telefone", telefone);
			
			response.sendRedirect(request.getContextPath() + "/final.jsp");
		}
	}

}
