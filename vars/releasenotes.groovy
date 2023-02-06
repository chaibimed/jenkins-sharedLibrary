import java.io.*;
import groovy.io.*;
import java.utils.Calendar.*;
import java.text.SimpleDateFormat;
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
  
  def changeLogSets = currentBuild.changeSets;
  
  for(change in changeLogsets) {
    def entries = change.items;
    for (entry in entries) {
      echo "${entry.commitId} by ${entry.author} on ${new Date(entry.timestamp)} : ${entry.msg}"
      for (file in entry.affectedFiles) {
        echo " ${file.editType.name} ${file.path}";
      }
    }
  }
  echo "Build number is: ${BUILD_NUMBER}";
  if(config.changes != "false"){
     echo "changes";
  }
}
