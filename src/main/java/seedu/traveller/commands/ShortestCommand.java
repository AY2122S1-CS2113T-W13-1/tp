package seedu.traveller.commands;

import seedu.traveller.TripsList;
import seedu.traveller.Ui;
import seedu.traveller.worldmap.MinCalcResult;
import seedu.traveller.worldmap.WorldMap;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ShortestCommand extends Command {
    private static final Logger logger = Logger.getLogger(ShortestCommand.class.getName());
    private final String startCountry;
    private final String endCountry;

    public ShortestCommand(String startCountry, String endCountry) {
        logger.setLevel(Level.INFO);
        this.startCountry = startCountry;
        this.endCountry = endCountry;
        logger.log(Level.INFO, "Created an search command: \n" + this);
    }

    public String getStartCountry() {
        return this.startCountry;
    }

    public String getEndCountry() {
        return this.endCountry;
    }

    @Override
    public String toString() {
        return "Shortest command: "
                + "\n\tstartCountry: " + startCountry
                + "\n\tendCountry: " + endCountry;
    }

    public void execute(TripsList tripsList, Ui ui) {
        MinCalcResult result = WorldMap.calcMinDistance(this.startCountry, this.endCountry);
        List<Double> distances = result.getDistances();
        double sum = 0.0;
        for (double d : distances) {  // TODO: CHECK THIS, LOOKS V SUS
            sum += d;
        }
        assert sum >= 0 : "The distance should be more than or equal to 0.";
        ui.printSearch(this.startCountry, this.endCountry, sum);
    }
}
