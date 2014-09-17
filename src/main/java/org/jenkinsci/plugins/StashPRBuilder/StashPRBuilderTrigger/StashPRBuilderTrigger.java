package org.jenkinsci.plugins.StashPRBuilder;
import hudson.EnvVars;
import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.Util;
import hudson.model.Cause;
import hudson.model.Hudson;
import hudson.model.ParameterDefinition;
import hudson.model.ParametersDefinitionProperty;
import hudson.model.PasswordParameterValue;
import hudson.model.Project;
import hudson.model.StringParameterValue;
import hudson.model.Item;
import hudson.model.TaskListener;
import hudson.model.TopLevelItem;
import hudson.tasks.Messages;
import hudson.triggers.Trigger;
import hudson.triggers.TriggerDescriptor;
import hudson.util.LogTaskListener;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import hudson.Extension;
import hudson.triggers.Trigger;
import antlr.ANTLRException;
import hudson.model.BuildListener;
//import com.coravy.hudson.plugins.github.GithubProjectProperty;
import com.google.common.annotations.VisibleForTesting;

import hudson.Extension;
import hudson.Util;
import hudson.model.*;
import hudson.model.StringParameterValue;
import hudson.model.queue.QueueTaskFuture;
//import hudson.plugins.git.RevisionParameterAction;
//import hudson.plugins.git.util.BuildData;
import hudson.triggers.Trigger;
import hudson.triggers.TriggerDescriptor;
import hudson.util.FormValidation;
import hudson.util.LogTaskListener;
import net.sf.json.JSONObject;
/*
import org.kohsuke.github.GHAuthorization;
import org.kohsuke.github.GHCommitState;
import org.kohsuke.github.GitHub;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;
*/
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;


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

