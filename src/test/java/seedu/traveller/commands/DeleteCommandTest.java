package seedu.traveller.commands;

import org.junit.jupiter.api.Test;
import seedu.traveller.TripsList;
import seedu.traveller.Ui;
import seedu.traveller.commands.DeleteCommand;
import seedu.traveller.exceptions.TravellerException;

import static org.junit.jupiter.api.Assertions.assertEquals;


//@@author Uxinnn
public class DeleteCommandTest {
    private DeleteCommand deleteCommand;

    public DeleteCommandTest() {
        this.deleteCommand = new DeleteCommand("testTrip");
    }

    @Test
    public void deleteCommand_tripNotFound_exceptionThrown() {
        final String expectedOutput = "\tThe trip specified does not exist.";
        TripsList tripsList = new TripsList();
        Ui ui = new Ui();
        try {
            this.deleteCommand.execute(tripsList, ui);
        } catch (TravellerException e) {
            assertEquals(expectedOutput, e.getMessage());
        }
    }
}
