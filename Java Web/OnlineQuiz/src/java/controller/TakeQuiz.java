/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Question;
import entity.Result;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.QuestionDAO;
import modal.ResultDAO;

/**
 *
 */
public class TakeQuiz extends HttpServlet {
//show form take quiz

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            User user = (User) request.getSession().getAttribute("Account");
//            if don't login=> come back login page
            if (user == null) {
                request.getRequestDispatcher("Home").forward(request, response);
            } else {
//              If you are logged in, go to form takeQuiz to input numberQuestions
                request.setAttribute("start", false);
                request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
//handle creating questions and grading

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            QuestionDAO qDAO = new QuestionDAO();
//            check user who want to create a quiz or submit it
//            if numberQuestions !=null => create quiz
            if (request.getParameter("numberQuestions") != null) {

//                take number questions in quiz
                int numberQuestions = 0;
                try {
                    numberQuestions = Integer.parseInt(request.getParameter("numberQuestions"));
                } catch (NumberFormatException e) {
                    numberQuestions = -1;
                }

//                if numberQuestions<=0 invalid
                if (numberQuestions <= 0) {
                    request.setAttribute("start", false);
                    request.setAttribute("notify", "*input invalid*");
                } else //                    numberQuestions is not enough
                if (numberQuestions > qDAO.countQuestions()) {
                    request.setAttribute("start", false);
                    request.setAttribute("notify", "*Don't have enough question!*");
                } else {
//                   satisfies all conditions
                    request.setAttribute("start", true);
//                    take all question in DB
                    ArrayList<Question> listTakeQuestion = qDAO.getQuestionsRand(numberQuestions);
                    request.setAttribute("listQuestions", listTakeQuestion);

//                    Case handling only 1 question
                    if (listTakeQuestion.size() != 1) {
                        request.setAttribute("buttonFinish", "hidden");
                    } else {
                        request.setAttribute("buttonNext", "hidden");
                    }
//                    submission time
                    request.setAttribute("time", numberQuestions * 10);
                    request.setAttribute("numberQ", numberQuestions);

                    long timeEnd = new Date().getTime() + (numberQuestions * 10 * 1000 + 1000);
                    request.getSession().setAttribute("timeEnd", timeEnd);
                }
            } //              numberQuestions==null =>submit           
            else {
//                get session timeEnd
                long timeEnd = (long) request.getSession().getAttribute("timeEnd");
//                take current time
                long timeCurent = new Date().getTime();
//                compare if timeEnd - timeCurent >=0  =>submit quiz on time
                if (timeEnd - timeCurent >= 0) {
//                    take number quuestions
                    int numberQ = Integer.parseInt(request.getParameter("numberQ"));
                    int score = 0;
//                  Scoring quiz
                    for (int i = 1; i <= numberQ; i++) {
                        String q = "q" + String.valueOf(i);
                        int idQuestion = Integer.parseInt(request.getParameter(q));
                        Question question = qDAO.getQuestionsByID(idQuestion);
//                        get answers
                        String[] true_ans = request.getParameterValues("true_ans" + String.valueOf(i));
                        String trueans = "";
                        if (true_ans != null && true_ans.length != 0) {
                            for (int j = 0; j < true_ans.length; j++) {
                                trueans += true_ans[j];
                            }
                        }
//                        compare to true answer
                        if (question.getTrue_answer().equalsIgnoreCase(trueans)) {
                            score++;
                        }
                    }
//                    format float
                    DecimalFormat df = new DecimalFormat("0.0");
//                    get score
                    float d = (float) (score * 10) / numberQ;
//                    percent
                    int percent = (int) (d * 10);

                    String s = "  " + df.format(d) + " (" + String.valueOf(percent) + "%" + ")" + " - ";
                    request.setAttribute("score", s);

//                    pass or fail
                    if (d >= 5) {
                        request.setAttribute("passed", "Passed");
                    } else {
                        request.setAttribute("passed", "Failed");
                    }
                    User user = (User) request.getSession().getAttribute("Account");
                    ResultDAO r = new ResultDAO();
                    DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dateCreate = simpleDateFormat.format(Calendar.getInstance().getTime());
                    r.addResult(new Result(user.getUsername(), d, numberQ,dateCreate));

                } //                If your submission is overdue
                else {
                    request.setAttribute("passed", "Failed-The submission deadline has expired");
                }
            }
            request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
        } catch (Exception ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
