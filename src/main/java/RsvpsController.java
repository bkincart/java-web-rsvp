import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/rsvps/new", "/rsvps"})
public class RsvpsController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getServletPath().equals("/rsvps/new")) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/rsvps/new.jsp");
      dispatcher.forward(req, resp);
    }
    else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getServletPath().equals("/rsvps")) {
      Rsvp rsvp = new Rsvp();
      try {
        System.out.println(req.getParameterMap());
        BeanUtils.populate(rsvp, req.getParameterMap());
      }
      catch(IllegalAccessException ex) {
       System.out.println("There was an illegal access exception");
       System.out.println(ex);
      }
      catch(InvocationTargetException ex) {
        System.out.println("There was an invocation target exception");
        System.out.println(ex);
      }

      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();
      try {
        em.getTransaction().begin();
        em.persist(rsvp);
        em.getTransaction().commit();
      }
      finally {
        em.close();
      }
      resp.sendRedirect("/rsvps/new");
    }
    else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  private EntityManagerFactory getEmf() {
    return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
  }
}