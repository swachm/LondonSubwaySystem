package ca.ubc.cs.cpsc210.mindthegap.TfL;

/*
 * Copyright 2015-2016 Department of Computer Science UBC
 */

import ca.ubc.cs.cpsc210.mindthegap.model.Line;
import ca.ubc.cs.cpsc210.mindthegap.model.Station;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Wrapper for TfL Arrival Data Provider
 */
public class TfLHttpArrivalDataProvider extends AbstractHttpDataProvider {
    //private static final String ARRIVALS_API_BASE = "https://api.tfl.gov.uk";              // for TfL data
    private static final String ARRIVALS_API_BASE = "http://kunghit.ugrad.cs.ubc.ca:6060";   // for simulated data (3pm to midnight)
    private Station stn;

    public TfLHttpArrivalDataProvider(Station stn) {
        super();
        this.stn = stn;
    }

    @Override
    protected URL getURL() throws MalformedURLException {
        String webLink = ARRIVALS_API_BASE + "/Line/";
        for (Line l:this.stn.getLines()) {
                webLink = webLink + l.getId() + ",";
        }
        webLink = webLink.substring(0, webLink.length()-1);
        webLink = webLink + "/Arrivals?stopPointId=" + stn.getID();
        System.out.println();
        System.out.println(webLink);
        System.out.println();
        return new URL(webLink);
    }
}
