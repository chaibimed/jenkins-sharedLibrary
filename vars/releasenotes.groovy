import java.io.*;
import groovy.io.*;

@NonCPS
def call(Map config=[:]) {
  def dir = new File(pwd());
 
  new File(dir.path + '\\releasenotes.txt').withWriter('utf-8')
  {
    writer -> dir.eachFileRecurse(FileType.ANY){ file ->
       writer.writeLine('\t' + file.name +'\t' + file.length());
    }
  }
  def date = new Date();
  def sdf = new SimpleDateFormat("MM/dd/yyy HH:mm:ss")
  echo "****************************** date is: " + sdf.format(date);
  
  if(config.changes != "false"){
     echo "changes";
  }
}
