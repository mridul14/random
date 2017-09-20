package com.example.firebasedemo;

/**
 * Created by dell on 07-07-2017.
 */

public class QuoteModel {

    String quote,email;

    //the variable name should be same as key name in firebase

    //empty constructor for firebase
    public QuoteModel() {

    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public QuoteModel(String quote, String email) {

        this.quote = quote;
        this.email = email;
    }
}
