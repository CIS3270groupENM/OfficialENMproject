package edu.gsu.bizlogic;

import edu.gsu.common.Action;
import edu.gsu.common.Customer;
import edu.gsu.common.Flight;
import edu.gsu.db.DBQueryIM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class BizLogicProcess {

    public static void process1(Customer c1) throws Exception {

        switch (c1.getAction()) {

            case Action.LOGIN:

                DBQueryIM.login(c1);
                break;

            case Action.REGISTER:

                DBQueryIM.register(c1);
                break;

        }

    }

    public static String processQ(Customer c1) throws Exception {

        String statement = null;

        switch (c1.getAction()) {
            case Action.FIND_QUESTION:
                statement = DBQueryIM.question(c1);
                break;
            case Action.FIND_PASSWORD:
                statement = DBQueryIM.password(c1);
                break;
            case Action.FLIGHT_NUM:
                statement = DBQueryIM.royalty(c1);
                break;
            case Action.FIRST_NAME:
                statement = DBQueryIM.first(c1);
                break;
            case Action.LAST_NAME:
                statement = DBQueryIM.last(c1);
                break;

        }
        return statement;
    }

    public static ObservableList<Flight> process3(Customer c1) throws Exception {

        ObservableList<Flight> flight = FXCollections.observableArrayList();

        switch (c1.getAction()) {
            case Action.GET_MY_FLIGHTS:
                flight = DBQueryIM.getMyFlights(c1);
                break;
            case Action.ALL_FLIGHTS:
                flight = DBQueryIM.getAllFlights();
                break;

        }
        return flight;
    }

    public static ObservableList<Flight> searching
            (String air, String dep, String arr, String depT, String depD) throws Exception {

        ObservableList<Flight> flight = DBQueryIM.searchFlights(air,dep,arr,depT,depD);

        return flight;
    }

    public static void process2(Customer c1, Flight f1) throws Exception {
        DBQueryIM.delete(c1,f1);
    }

    public static void book(Customer c1, Flight f1) throws Exception {
        DBQueryIM.book(c1,f1);
    }

}
