/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Question;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.QuestionDAO;
import modal.UserDAO;

/**
 *
 */
public class MakeQuiz extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
//            check login
            User user = (User) request.getSession().getAttribute("Account");
            if (user == null) {
                request.getRequestDispatcher("Home").forward(request, response);
            } else {
//                check student or teacher
                if (user.getRole().equalsIgnoreCase("student")) {
                    request.setAttribute("warning", true);
                }
                request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
//            get parameter question:name,ans,true_ans
            String question = request.getParameter("question");
            String ans_1 = request.getParameter("ans_1");
            String ans_2 = request.getParameter("ans_2");
            String ans_3 = request.getParameter("ans_3");
            String ans_4 = request.getParameter("ans_4");
            String[] true_ans = request.getParameterValues("true_ans");
//          check invalid:input all fields and choose at least 1 correct answer,Do not choose all the correct answers
            if (question.isEmpty() || ans_1.isEmpty() || ans_2.isEmpty() || ans_3.isEmpty() || ans_4.isEmpty() || true_ans == null || true_ans.length == 4 || true_ans.length == 0) {
                request.setAttribute("notify", "*You must input all fields and choose at least 1 correct answer*");
//                resend filled information
                request.setAttribute("question", question);
                request.setAttribute("ans_1", ans_1);
                request.setAttribute("ans_2", ans_2);
                request.setAttribute("ans_3", ans_3);
                request.setAttribute("ans_4", ans_4);
                if (true_ans != null) {
                    for (int i = 0; i < true_ans.length; i++) {
                        request.setAttribute("checkbox" + true_ans[i], "checked");
                    }
                }
                request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
            } 
            
//              Complete all fields
            else {
                QuestionDAO qDao = new QuestionDAO();
//                get user
                User user = (User) request.getSession().getAttribute("Account");
                String trueans = "";
//                take true answer
                for (int i = 0; i < true_ans.length; i++) {
                    trueans += true_ans[i];
                }

//                get date create
                DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateCreate = simpleDateFormat.format(Calendar.getInstance().getTime());
        
                Question q = new Question(question, dateCreate, ans_1, ans_2, ans_3, ans_4, trueans, user.getUsername());
                // add question to database
                qDao.addQuestion(q);
//                notify
                request.setAttribute("notify", "Question is created successful!");
                
                request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
