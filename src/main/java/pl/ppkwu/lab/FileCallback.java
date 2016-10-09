package pl.ppkwu.lab;

import javax.security.auth.callback.Callback;
import java.io.File;
import java.util.concurrent.Callable;

/**
 * Created by Pawełek on 10.10.2016.
 */
public class FileCallback implements Callable<Boolean> {

  private Boolean result = false;
  private static final String GOD_MESSAGE_TO_FILE = " yeah I'm live and it's my life ";

  public void setFile(File file) {
    this.file = file;
  }

  private File file;


  public void setResult(boolean result) {
    this.result = result;
  }


  public Boolean call() throws Exception {
    if (result) {

    }
    return result;
  }


}
