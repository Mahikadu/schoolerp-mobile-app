package com.edu.AttendanceData;

import com.edu.DataModel.Divisions;
import com.edu.DataModel.Standards;

import java.util.Arrays;
import java.util.List;

public class GenreDataFactory {

    public static List<SingleCheckGenre> makeSingleCheckGenres(List<Standards> std , List<Divisions> div) {
        return Arrays.asList(makeSingleCheckRockGenre(std, div),
                makeSingleCheckJazzGenre(std, div));
    }

    public static SingleCheckGenre makeSingleCheckRockGenre(List<Standards> std, List<Divisions> divs) {
        return new SingleCheckGenre(std.get(0).getName(), Arrays.asList(divs.get(0), divs.get(1)));
    }

//    public static List<Divisions> makeRockArtists() {
//        Divisions queen = new Divisions(1, "Queen", "", "");
//        Divisions styx = new Divisions(2, "Styx", "", "");
//        Divisions reoSpeedwagon = new Divisions(3, "REO Speedwagon", "", "");
//
//        return Arrays()//asList(queen, styx, reoSpeedwagon);
//    }

    public static SingleCheckGenre makeSingleCheckJazzGenre(List<Standards> std, List<Divisions> divs) {
        return new SingleCheckGenre(std.get(1).getName(), Arrays.asList(divs.get(0), divs.get(1)));
    }

//    public static List<Divisions> makeJazzArtists() {
//        Divisions milesDavis = new Divisions(1, "Miles Davis", "", "");
//        Divisions ellaFitzgerald = new Divisions(2, "Ella Fitzgerald", "", "");
//        Divisions billieHoliday = new Divisions(3, "Billie Holiday", "", "");

//        return Arrays.asList(milesDavis, ellaFitzgerald, billieHoliday);
//    }
}

