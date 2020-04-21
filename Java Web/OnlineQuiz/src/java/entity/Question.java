/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 */
public class Question {
    private int id;
    private String q_name;
    private String date_created;
    private String ans_1,ans_2,ans_3,ans_4;
    private String true_answer;
    private String create_by;
    private int index;
    public Question() {
    }

    public Question(int id, String q_name, String date_created, String ans_1, String ans_2, String ans_3, String ans_4, String true_answer, String create_by, int index) {
        this.id = id;
        this.q_name = q_name;
        this.date_created = date_created;
        this.ans_1 = ans_1;
        this.ans_2 = ans_2;
        this.ans_3 = ans_3;
        this.ans_4 = ans_4;
        this.true_answer = true_answer;
        this.create_by = create_by;
        this.index = index;
    }

    
    public Question(int id, String q_name, String date_created, String ans_1, String ans_2, String ans_3, String ans_4, String true_answer, String create_by) {
        this.id = id;
        this.q_name = q_name;
        this.date_created = date_created;
        this.ans_1 = ans_1;
        this.ans_2 = ans_2;
        this.ans_3 = ans_3;
        this.ans_4 = ans_4;
        this.true_answer = true_answer;
        this.create_by = create_by;
    }

    public Question(String q_name, String date_created, String ans_1, String ans_2, String ans_3, String ans_4, String true_answer, String create_by) {
        this.q_name = q_name;
        this.date_created = date_created;
        this.ans_1 = ans_1;
        this.ans_2 = ans_2;
        this.ans_3 = ans_3;
        this.ans_4 = ans_4;
        this.true_answer = true_answer;
        this.create_by = create_by;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQ_name() {
        return q_name;
    }

    public void setQ_name(String q_name) {
        this.q_name = q_name;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getAns_1() {
        return ans_1;
    }

    public void setAns_1(String ans_1) {
        this.ans_1 = ans_1;
    }

    public String getAns_2() {
        return ans_2;
    }

    public void setAns_2(String ans_2) {
        this.ans_2 = ans_2;
    }

    public String getAns_3() {
        return ans_3;
    }

    public void setAns_3(String ans_3) {
        this.ans_3 = ans_3;
    }

    public String getAns_4() {
        return ans_4;
    }

    public void setAns_4(String ans_4) {
        this.ans_4 = ans_4;
    }

    public String getTrue_answer() {
        return true_answer;
    }

    public void setTrue_answer(String true_answer) {
        this.true_answer = true_answer;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
