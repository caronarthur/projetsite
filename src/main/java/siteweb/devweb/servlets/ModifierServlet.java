package siteweb.devweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import siteweb.devweb.models.Episode;
import siteweb.devweb.services.EpisodeService;

@WebServlet("/edit")
public class ModifierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContextTemplateResolver templateResolver=new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        WebContext context=new WebContext(req, resp, req.getServletContext());
        Integer id=Integer.parseInt(req.getParameter("livre"));
        context.setVariable("episodeamodifier", EpisodeService.getInstance().getEpisode(id));
        templateEngine.process("modifier", context,resp.getWriter());
    }

}