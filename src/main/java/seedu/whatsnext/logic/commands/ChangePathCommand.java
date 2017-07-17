package seedu.whatsnext.logic.commands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import seedu.whatsnext.commons.core.Config;
import seedu.whatsnext.commons.core.LogsCenter;
import seedu.whatsnext.commons.util.ConfigUtil;
import seedu.whatsnext.commons.util.StringUtil;
import seedu.whatsnext.logic.commands.exceptions.CommandException;
import seedu.whatsnext.storage.XmlTaskManagerStorage;



/**
 * Changes location where task manager is stored.
 */
//@@author A0149894H
public class ChangePathCommand extends Command {
    public static final String COMMAND_WORD = "changepath";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Changes where task manager is stored. Takes in new file location";
    public static final String MESSAGE_CREATED_NEW_CONFIG_FILE = "TEST";
    public static final String MESSAGE_REPEAT_TASK_MANAGER_FILE_PATH = "This file is already saved at this location";
    public static final String MESSAGE_SUCCESS = "Save location changed to: %1$s";

    private static final Logger logger = LogsCenter.getLogger(ChangePathCommand.class);



    private static File toSave;




    public ChangePathCommand(File filePath) {
        toSave = filePath;
    }

    @Override
    public CommandResult execute() throws CommandException {
        try {
            //delete
            deleteOldFile();

            //overwrite filepath
            String stringLocation = overwriteFilePath();

            //set new file path in config
            Config config = new Config();
            config.setTaskManagerFilePath(stringLocation);
            ConfigUtil.saveConfig(config, Config.DEFAULT_CONFIG_FILE);


            XmlTaskManagerStorage.changeTaskManagerFilePath(stringLocation);
            model.saveTaskManager();

            return new CommandResult(String.format(MESSAGE_SUCCESS, toSave));
        } catch (Config.RepeatTaskManagerFilePathException dtmfpe) {
            throw new CommandException(MESSAGE_REPEAT_TASK_MANAGER_FILE_PATH);
        } catch (IOException ioe) {
            logger.warning("Failed to save config file : " + StringUtil.getDetails(ioe));
            throw new CommandException(MESSAGE_CREATED_NEW_CONFIG_FILE);
        }

    }
    /**
    Overwrites the current filepath in the path file located at resource/filepath/filepath
     */
    private String overwriteFilePath() throws IOException {
        File pathFile = new File("/filepath/filepath");
        FileWriter writer = new FileWriter(pathFile, false);

        String stringLocation = toSave.toString();
        writer.write(stringLocation);
        writer.close();
        return stringLocation;
    }
    /**
     * Deletes old file at previous location
     */
    private void deleteOldFile() {
        File f = new File("test.txt");
        String string = f.getAbsolutePath();
        int texttxtSize = 8;
        int size = string.length() - texttxtSize;
        string = string.substring(0, size);
        String deleteLocation = String.format(string).concat(Config.getTaskManagerFilePath());
        deleteLocation = deleteLocation.replace("\\", "/");
        File toDeleteFilePath = new File(deleteLocation);
        toDeleteFilePath.delete();
    }


}
