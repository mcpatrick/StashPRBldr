package org.jenkinsci.plugins.StashPRBuilder;

import hudson.Extension;
import hudson.triggers.Trigger;
import antlr.ANTLRException;

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
public class StashPRBuilderTrigger extends Trigger {


    public StashPRBuilderTrigger(String cron) throws ANTLRException {
       super(cron);
    }






        public String getDisplayName() {
            return "GitHub Pull Request Builder";
        }


}


