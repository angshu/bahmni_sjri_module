package org.bahmni.module.sjri;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.ModuleActivator;

/**
 * This class contains the logic that is run every time this module is either started or shutdown
 */
public class SJRIModuleActivator implements ModuleActivator {

  public static final String MODULE_NAME = "SJRI";

  private Log log = LogFactory.getLog(this.getClass());

  @Override
  public void willRefreshContext() {
    log.warn("Will refresh " + MODULE_NAME + " Module");
  }

  @Override
  public void contextRefreshed() {
    log.warn("Refreshed " + MODULE_NAME + " Module");
  }

  @Override
  public void willStart() {
    log.warn("Will start " + MODULE_NAME + " Module");

  }

  @Override
  public void started() {
    log.warn("Started " + MODULE_NAME + " Module");
  }

  @Override
  public void willStop() {
    log.warn("Will stop " + MODULE_NAME + " Module");
  }

  @Override
  public void stopped() {
    log.warn("Stopped " + MODULE_NAME + " Module");
  }
}
