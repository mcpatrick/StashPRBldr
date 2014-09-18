package org.jenkinsci.plugins.stashprbuilder;
import hudson.Extension;
import hudson.FilePath;
import hudson.model.Project;
import hudson.model.Item;
import hudson.model.TopLevelItem;
import hudson.triggers.Trigger;
import hudson.triggers.TriggerDescriptor;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;


import antlr.ANTLRException;
//import com.coravy.hudson.plugins.github.GithubProjectProperty;

//import hudson.plugins.git.RevisionParameterAction;
//import hudson.plugins.git.util.BuildData;
/*
import org.kohsuke.github.GHAuthorization;
import org.kohsuke.github.GHCommitState;
import org.kohsuke.github.GitHub;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;
*/


/**
 * Created by cpatrick on 9/3/14.
 */


public class StashPRBuilderTrigger extends Trigger<Project> {
    private transient static final Logger LOGGER    = Logger.getLogger(StashPRBuilderTrigger.class.getName());

    private        final String name2;


    @DataBoundConstructor
    public StashPRBuilderTrigger(String name2) throws ANTLRException {

        this.name2 = name2;
    }

    @SuppressWarnings({"UnusedDeclaration"})
    public String getName2() {
        return name2;
    }





    /**
     * Plugin entry point is here.
     */
    public void run() {
        //added to check if project is disabled/buildable or not.
   //     if (!Hudson.getInstance().isQuietingDown() && this.job.isBuildable()) {
     //       listener.getLogger().println("Bonjour+ name2");
    //    }
    }



    @Extension
    public static final class DescriptorImpl extends TriggerDescriptor {
        public String getDisplayName() {
            return "Stash Pull request";
        }

        public boolean isApplicable(Item item) {
            return item instanceof TopLevelItem;
        }
    }




    private static class LogStream extends OutputStream {
        private final StringBuilder log       = new StringBuilder();
        private final OutputStream  logStream;

        public LogStream(FilePath logFile) throws IOException, InterruptedException {
            logStream = logFile.write();
        }

        public void write(int b) throws IOException {
            log.append((char) b);
            logStream.write(b);
        }

        public void close() throws IOException {
            //super.close();
            logStream.close();
        }

        public String toString() {
            return log.toString();
        }
    }
}

