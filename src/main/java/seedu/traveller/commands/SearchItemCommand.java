
package seedu.traveller.commands;

import seedu.traveller.TripsList;
import seedu.traveller.Ui;
import seedu.traveller.exceptions.TravellerException;
import seedu.traveller.exceptions.TripNotFoundException;

import java.util.logging.Level;
import java.util.logging.Logger;


public class SearchItemCommand extends Command {
    private static final Logger logger = Logger.getLogger(DeleteDayCommand.class.getName());
    private final String tripName;
    private final String itemName;

    public SearchItemCommand(String tripName, String itemName) {
        logger.setLevel(Level.INFO);
        this.tripName = tripName;
        this.itemName = itemName;

        logger.log(Level.INFO, "Created a search-item command: \n" + this);
    }

    @Override
    public String toString() {
        return "Search-item command:"
                + "\n\titem: " + itemName;
    }

    public void execute(TripsList tripsList, Ui ui) throws TravellerException {
        int tripIndex = tripsList.getTripIndex(tripName);
        assert tripIndex < tripsList.getSize() : "The trip index is out of bound.";
        if (tripIndex == -1) {
            throw new TripNotFoundException();
        }

        ui.printSearchItem(tripName, itemName);
    }
}

