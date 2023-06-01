package org.example.action;

import org.example.dao.pevaluationDAO;
import org.example.entity.SelectedMarks;
import org.example.service.ZhurnalService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class ZhurnalAction extends HttpServlet {
    public class pair{
        pair(String first){
            this.first =first;
            second = new ArrayList<>();
        }
        public String first;
        public ArrayList<Integer> second;
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Здесь можно выполнить логику для получения данных из базы данных
        // и сохранить их в атрибуты запроса или сессии, чтобы передать на страницу zhurnal.jsp
        response.setContentType("text/html");

        ZhurnalService service = new ZhurnalService();
        try {
            String login = (String) request.getSession().getAttribute("login");
            ArrayList<SelectedMarks> timeTables = service.getTimeTables(login);

            ArrayList<pair> temp = new ArrayList<>();
            for (int i = 0; i < timeTables.size(); i++) {
                boolean flag = false;
                for (int j = 0; j < temp.size(); j++) {
                    if(timeTables.get(i).getSubject_name().equals(temp.get(j).first)){
                        temp.get(j).second.add( timeTables.get(i).getMark());
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    temp.add(new pair(timeTables.get(i).getSubject_name()) );
                    temp.get(temp.size()-1).second.add(timeTables.get(i).getMark());
                }
            }

            request.setAttribute("temp", temp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("zhurnal.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
