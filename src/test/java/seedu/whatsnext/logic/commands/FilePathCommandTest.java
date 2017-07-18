//package seedu.whatsnext.logic.commands;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import model.RepeatTaskManagerFilePathException;
//import seedu.whatsnext.logic.commands.exceptions.CommandException;
//import seedu.whatsnext.model.Model;
//import seedu.whatsnext.model.ModelManager;
//import seedu.whatsnext.model.UserPrefs;
//import seedu.whatsnext.testutil.TypicalTasks;
//
///**
// *contains integration tests and unit tests for FilePathCommand
// */
////@@author A0149894H
//
//public class FilePathCommandTest {
//
//    private Model model;
//
//    //@@author A0149894H
//    @Before
//    public void execute_getFilePath_success() throws RepeatTaskManagerFilePathException, CommandException {
//        model = new ModelManager(new TypicalTasks().getTypicalTaskManager(), new UserPrefs());
//    }
//    //@@author A0149894H

//    @Test
//    public void execute_filePathCommand_success(){
//        FilePathCommand();
//        assertCommandSuccess()
//    }
//    /**
//     * Executes {@code FilePathCommand} on the given {@code model}, confirms that <br>
//     * - the result message matches {@code FilePathCommand.MESSAGE_SUCCESS} <br>
//     * - file path remains the same {@code model} is empty <br>
//     * @throws CommandException
//     */
//    public void assertCommandSuccess()
//    //@@author A0149894H
//    /*
//    private void assertFilePathSuccess(Config config) throws CommandException {
//        assertEquals(TEST_ORIGINAL_LOCATION, config.getTaskManagerFilePath());
//    }
//    //@@author A0149894H
//    private void assertCompletedCommandSuccess() throws DuplicateTaskException, CommandException {
//
//
//        FilePathCommand command = new FilePathCommand();
//        CommandResult result = command.execute();
//
//        assertEquals(FilePathCommand.MESSAGE_SUCCESS, result.feedbackToUser);
//
//    }
//    */
//}
